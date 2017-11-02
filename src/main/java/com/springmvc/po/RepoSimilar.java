package com.springmvc.po;

public class RepoSimilar {
	private String repoName;
	private double similar;

	public RepoSimilar() {
	}

	public RepoSimilar(String repoName, double Similar) {
		this.repoName = repoName;
		this.similar = Similar;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public double getSimilar() {
		return similar;
	}

	public void setSimilar(double rSimilar) {
		this.similar = rSimilar;
	}

}

