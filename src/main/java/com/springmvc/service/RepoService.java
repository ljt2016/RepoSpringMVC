package com.springmvc.service;

import java.util.ArrayList;

import com.springmvc.po.Repo;

public interface RepoService {

	ArrayList<Repo> getTopTenRepos(ArrayList<String> topTenRepoNames);

}
