package com.springmvc.po;

public class Repo {
	private int repoOrder;
	private String language;
	private int repoId;
	private String repoName;
	private String readMe;

	public int getRepoOrder() {
		return repoOrder;
	}

	public void setRepoOrder(int repoOrder) {
		this.repoOrder = repoOrder;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getRepoId() {
		return repoId;
	}

	public void setRepoId(int repoId) {
		this.repoId = repoId;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	public String getReadMe() {
		return readMe;
	}

	public void setReadMe(String readMe) {
		this.readMe = readMe;
	}

}

