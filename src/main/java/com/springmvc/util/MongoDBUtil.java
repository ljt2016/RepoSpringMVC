package com.springmvc.util;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {

	public static MongoDatabase mongoDatabase;
	private static MongoClient mongoClient;

	public static void start() {
		try {
			Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
			mongoLogger.setLevel(Level.SEVERE);
			// 连接到 MongoDB服务
			mongoClient = new MongoClient("localhost", 27017);
			// 连接到数据库
			mongoDatabase = mongoClient.getDatabase("repopal");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void close() {
		mongoClient.close();
	}
}

