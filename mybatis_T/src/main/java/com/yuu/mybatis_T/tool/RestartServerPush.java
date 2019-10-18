package com.yuu.mybatis_T.tool;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yuu.model.Pjxxas_ReloadItems;

public class RestartServerPush {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			Reader reader = Resources.getResourceAsReader("pjxxas_mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Pjxxas_ReloadItems> reloadItems = sqlSession.selectList("selectAll");
		String now = new Date().toString();
		Pjxxas_ReloadItems new_item = new Pjxxas_ReloadItems("client_hot_patch", now);
		sqlSession.update("update_server", new_item);
		for(Pjxxas_ReloadItems reloadItem : reloadItems) {
			System.out.println(reloadItem);
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
