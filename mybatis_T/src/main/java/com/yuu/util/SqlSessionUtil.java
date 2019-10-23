package com.yuu.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtil {
	private static SqlSessionUtil instance = null;
	
	private SqlSessionUtil() {}
	
	public static SqlSessionUtil getInstance() {
		if(instance == null) {
			instance = new SqlSessionUtil();
		}
		return instance;
	}
	
	/**
	 * 获取sqlSessionFactory
	 * @param xmlPath
	 * @return
	 * @throws IOException
	 */
	public SqlSessionFactory getSqlSessionFactory(String xmlPath) throws IOException {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(xmlPath);
			return new SqlSessionFactoryBuilder().build(reader);
		} finally {
			if(reader != null) {
				reader.close();
			}
		}
	}
}
