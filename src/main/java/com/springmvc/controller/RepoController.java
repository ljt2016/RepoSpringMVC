package com.springmvc.controller;

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.po.Repo;
import com.springmvc.service.RepoComparedResultService;
import com.springmvc.service.RepoService;
import com.springmvc.service.impl.RepoComparedResultServiceImpl;
import com.springmvc.service.impl.RepoServiceImpl;

@Controller
public class RepoController {
	RepoComparedResultService repoComparedResultService= new RepoComparedResultServiceImpl();
	RepoService repoService = new RepoServiceImpl();
	
	@RequestMapping(value = "/SearchAction")
	@ResponseBody
	public ArrayList<Repo> RepoSearch(@RequestParam("searchInfo") String repoName) {
		
		ArrayList<String> topTenRepoNames = repoComparedResultService.getTopTenRepoNames(repoName);
		if (topTenRepoNames.size() == 0 ) {
			return null;
		}
		ArrayList<Repo> repos = repoService.getTopTenRepos(topTenRepoNames);

		return repos;
	}

	public void test_tool(){
		System.out.print("this is test function.");
	}
}