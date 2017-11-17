package com.wby.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import com.wby.dao.UserMapper;
import com.wby.entities.User;
public class Test {
	public static void main(String[] args)  {
		
		try {
			//���������ǻ�ȡ SqlSessionFactory�ķ�ʽ,��Ŀ����Ϊ�˻�ȡ SqlSession
			 String resource = "mybatis-config.xml";
			 InputStream inputStream;
			 inputStream = Resources.getResourceAsStream(resource);
			 SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
			 /*  SqlSession �Ƿ��̰߳�ȫ�ģ����Բ��ܰ������һ�����ͱ���
			  *  SqlSession ���������ݿ��һ�λỰ���൱��Connection
			  *  SqlSession ʹ����ɺ�ǵùر�
			  * */
			 SqlSession session=sqlSessionFactory.openSession();
			 //��ȡdao�ӿڵĴ�����
			 UserMapper userMapper=session.getMapper(UserMapper.class);
		
			 User user =  userMapper.getUserById(1);
			 System.out.println(user);
			 session.close();
			 } 
		    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
	

	


