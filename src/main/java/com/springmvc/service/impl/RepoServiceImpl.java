package com.springmvc.service.impl;


import java.util.ArrayList;

import com.springmvc.dao.RepoDao;
import com.springmvc.dao.impl.RepoDaoImpl;
import com.springmvc.po.Repo;
import com.springmvc.service.RepoService;

public class RepoServiceImpl implements RepoService{
	
	RepoDao repoDao = new RepoDaoImpl();

	public ArrayList<Repo> getTopTenRepos(ArrayList<String> topTenRepoNames) {
		return repoDao.getTopTenRepos(topTenRepoNames);
	}

}
