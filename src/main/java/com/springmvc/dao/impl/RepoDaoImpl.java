package com.springmvc.dao.impl;

import java.util.ArrayList;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.springmvc.dao.RepoDao;
import com.springmvc.po.Repo;
import com.springmvc.util.MongoDBUtil;

public class RepoDaoImpl implements RepoDao {

	public ArrayList<Repo> getTopTenRepos(ArrayList<String> topTenRepoNames) {
		Gson gson = new Gson();
		ArrayList<Repo> repos = new ArrayList<Repo>();
		try {
			MongoDBUtil.start();
			MongoCollection<Document> mongoCollection = MongoDBUtil.mongoDatabase.getCollection("repos");
			FindIterable<Document> findIterable;
			MongoCursor<Document> mongoCursor;
			for (int i = 0; i < topTenRepoNames.size(); i++) {
				findIterable = mongoCollection.find(Filters.eq("repo_name", topTenRepoNames.get(i)));
				mongoCursor = findIterable.iterator();
				if (mongoCursor.hasNext()) {
					Repo repo = new Repo();
					Document document = mongoCursor.next();
					repo = gson.fromJson(document.toJson(), Repo.class);
					repos.add(repo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repos;
	}


}
