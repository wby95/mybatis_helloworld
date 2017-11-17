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
			//下面四行是获取 SqlSessionFactory的方式,其目的是为了获取 SqlSession
			 String resource = "mybatis-config.xml";
			 InputStream inputStream;
			 inputStream = Resources.getResourceAsStream(resource);
			 SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
			 /*  SqlSession 是非线程安全的，所以不能把它设成一个成型变量
			  *  SqlSession 代表与数据库的一次会话，相当于Connection
			  *  SqlSession 使用完成后记得关闭
			  * */
			 SqlSession session=sqlSessionFactory.openSession();
			 //获取dao接口的代理类
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
	

	


