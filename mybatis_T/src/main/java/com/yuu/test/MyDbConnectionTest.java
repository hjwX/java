package com.yuu.test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yuu.model.Test_param;
import com.yuu.util.PrintTool;
import com.yuu.util.SqlSessionUtil;

public class MyDbConnectionTest {

	private static final Logger logger = LoggerFactory.getLogger(MyDbConnectionTest.class);

	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = SqlSessionUtil.getInstance().getSqlSessionFactory("mydb_config.xml");
			SqlSession sqlSession = sqlSessionFactory.openSession();
			List<Test_param> test_params = sqlSession.selectList("selectAll");
			for (Test_param test_param : test_params) {
				PrintTool.printWithColon("", test_param);
				break;
			}
			PrintTool.printWithColon("", test_params.size());
			sqlSession.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		String path = "D:/python/python_repository/original_images";
		File file = new File(path);
		if (!file.isDirectory()) {
			logger.error(path + "is not a directory!");
			return;
		}

		File[] files = file.listFiles();
		for (File f : files) {
			if (!f.isDirectory()) {
				logger.warn(f.toPath().toString() + "is not a directory!");
				continue;
			}
			File[] images = f.listFiles();
			for (File image : images) {
				if (!image.isFile()) {
					logger.warn(image.toPath().toString() + "is not a image!");
					continue;
				}
				String imageName = image.getName();
				PrintTool.printWithColon(null, imageName);
			}
		}
	}
}
