package com.springmvc.po;

import com.google.gson.annotations.SerializedName;

public class Repo {
	@SerializedName("repo_order")
	private int repoOrder;
	@SerializedName("repo_id")
	private int repoId;
	@SerializedName("repo_name")
	private String repoName;
	private String language;
	@SerializedName("readme")
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
