package com.yuu.pixiv;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yuu.model.DayRank;
import com.yuu.util.SqlSessionUtil;

public class ImageToDb {
	private static ImageToDb instance = null;
	private static final String ORIGINAL_IMAGE_PATH = "D:/python/python_repository/original_images";
	private static final Logger logger = LoggerFactory.getLogger(ImageToDb.class);
	
	public ImageToDb() {}
	
	public static ImageToDb getInstance() {
		if(instance == null) {
			instance = new ImageToDb();
		}
		return instance;
	}
	
	private File getOriginalImagePathFile() {
		File file = new File(ORIGINAL_IMAGE_PATH);
		if(!file.isDirectory()) {
			logger.error(ORIGINAL_IMAGE_PATH + "is not a directory!");
			return null;
		}
		return file;
	}
	
	private Map<Integer, Set<Long>> getAllDateImage(Integer date) {
		File file = getOriginalImagePathFile();
		if(file == null) {
			return new HashMap<Integer, Set<Long>>();
		}
		Map<Integer, Set<Long>> total = new HashMap<Integer, Set<Long>>();
		File[] files = file.listFiles();
		for(File f : files) {
			if(!f.isDirectory()) {
				logger.warn(f.toPath().toString() + "is not a directory!");
				continue;
			}
			if(date != null && !f.getName().equals(String.valueOf(date))) {
				continue;
			}
			File[] images = f.listFiles();
			String fileName = f.getName();
			Set<Long> dateImages = new HashSet<Long>();
			for(File image : images) {
				if(!image.isFile()) {
					logger.warn(image.toPath().toString() + "is not a image!");
					continue;
				}
				String imagePath = image.getName();
				try {
					long imageId = Long.valueOf(imagePath.split("\\.")[0]);
					dateImages.add(imageId);
				} catch (Throwable t) {
					logger.error("", t);
				}
			}
			total.put(Integer.valueOf(fileName), dateImages);
		}
		return total;
 	}
	
	public void saveImageToDayRank(Integer date) {
		SqlSessionFactory sessionFactory;
		try {
			sessionFactory = SqlSessionUtil.getInstance().getSqlSessionFactory("mydb_config.xml");
			SqlSession sqlSession = sessionFactory.openSession();
			Map<Integer, Set<Long>> results = ImageToDb.getInstance().getAllDateImage(date);
			for(Integer da : results.keySet()) {
				Set<Long> imageIds = results.get(da);
				DayRank dayRank = new DayRank();
				dayRank.setDate(da);
				for(Long imageId : imageIds) {
					dayRank.setImageId(imageId);
					sqlSession.insert("insertToDayRank", dayRank);
				}
			}
			sqlSession.commit();
			sqlSession.close();
		} catch (Throwable t) {
			logger.error("", t);
		}
	}
	
	@Test
	public void test() {
		Map<Integer, Set<Long>> results = ImageToDb.getInstance().getAllDateImage(20191020);
		for(Integer date : results.keySet()) {
			System.out.println(results.get(date));
		}
		ImageToDb.getInstance().saveImageToDayRank(null);
	}
}
