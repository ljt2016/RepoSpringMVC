package com.springmvc.dao;

import java.util.ArrayList;

import com.springmvc.po.Repo;

public interface RepoDao {

	ArrayList<Repo> getTopTenRepos(ArrayList<String> topTenRepoNames);

	
}
