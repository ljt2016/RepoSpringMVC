package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.springmvc.dao.RepoComparedResultDao;
import com.springmvc.dao.impl.RepoComparedResultDaoImpl;
import com.springmvc.po.RepoComparedResult;
import com.springmvc.po.RepoSimilar;
import com.springmvc.service.RepoComparedResultService;

public class RepoComparedResultServiceImpl implements RepoComparedResultService {

	RepoComparedResultDao repoComparedResultDao = new RepoComparedResultDaoImpl();
	
	public ArrayList<String> getTopTenRepoNames(String repoName) {
		RepoComparedResult repoComparedResult = repoComparedResultDao.getRepoComparedResults(repoName);
		ArrayList<RepoSimilar> repoSimilars = repoComparedResult.getRepoSimilars();
		
		Collections.sort(repoSimilars,new Comparator<RepoSimilar>(){

			public int compare(RepoSimilar o1, RepoSimilar o2) {
				if (o1.getSimilar() < o2.getSimilar()) {
					return 1;
				}
				if (o1.getSimilar() == o2.getSimilar()) {
					return 0;
				}
				return -1;
			}
		});
		
		ArrayList<String> topTenRepoNames = new ArrayList<String>();
		for (int i = 0; topTenRepoNames.size()<10 ; i++) {
			String similarRepoName = repoSimilars.get(i).getRepoName();
			System.out.println(similarRepoName);
			if (!similarRepoName.equals(repoName)) {
				topTenRepoNames.add(similarRepoName);
			}
		}
		
		return topTenRepoNames;
	}

}
