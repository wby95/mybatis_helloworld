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
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
			 SqlSession session=sqlSessionFactory.openSession();
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
	

	


