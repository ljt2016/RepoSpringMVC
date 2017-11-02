package com.springmvc.dao.impl;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.springmvc.dao.RepoComparedResultDao;
import com.springmvc.po.RepoComparedResult;
import com.springmvc.util.MongoDBUtil;

public class RepoComparedResultDaoImpl implements RepoComparedResultDao {

	public RepoComparedResult getRepoComparedResults(String repoName) {
		Gson gson = new Gson();
		RepoComparedResult repoComparedResult = new RepoComparedResult();
		try {
			MongoDBUtil.start();
			MongoCollection<Document> collection = MongoDBUtil.mongoDatabase.getCollection("RepoSimilar");
			FindIterable<Document> findIterable = collection.find(Filters.eq("repoName", repoName));
			MongoCursor<Document> mongoCursor = findIterable.iterator();
			if (mongoCursor.hasNext()) {
				Document document = mongoCursor.next();
				repoComparedResult = gson.fromJson(document.toJson(), RepoComparedResult.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repoComparedResult;
	}

}
