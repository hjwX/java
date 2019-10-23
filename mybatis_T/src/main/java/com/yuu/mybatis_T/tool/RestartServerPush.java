package com.yuu.mybatis_T.tool;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yuu.model.Pjxxas_ReloadItems;
import com.yuu.util.SqlSessionUtil;

public class RestartServerPush {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			sqlSessionFactory = SqlSessionUtil.getInstance().getSqlSessionFactory("pjxxas_mybatis_config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String now = new Date().toString();
		Pjxxas_ReloadItems new_item = new Pjxxas_ReloadItems("client_hot_patch", now);
		sqlSession.update("update_server", new_item);
		List<Pjxxas_ReloadItems> reloadItems = sqlSession.selectList("selectAll");
		for(Pjxxas_ReloadItems reloadItem : reloadItems) {
			System.out.println(reloadItem);
		}
		sqlSession.commit();
		sqlSession.close();
	}
}
