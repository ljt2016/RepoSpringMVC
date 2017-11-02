package com.springmvc.po;

import java.util.ArrayList;

public class RepoComparedResult {
	private int repoOrder;
	private String repoName;
	private ArrayList<RepoSimilar> repoSimilars;

	public RepoComparedResult() {
	}

	public RepoComparedResult(int repoOrder, String repoName, ArrayList<RepoSimilar> repoSimilars) {
		this.repoOrder = repoOrder;
		this.repoName = repoName;
		this.repoSimilars = repoSimilars;
	}

	public int getRepoOrder() {
		return repoOrder;
	}

	public void setRepoOrder(int repoOrder) {
		this.repoOrder = repoOrder;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public ArrayList<RepoSimilar> getRepoSimilars() {
		return repoSimilars;
	}

	public void setRepoSimilars(ArrayList<RepoSimilar> repoSimilars) {
		this.repoSimilars = repoSimilars;
	}

}

