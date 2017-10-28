package com.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.po.Repo;

@Controller
public class RepoController {
	@RequestMapping(value = "/SearchAction")
	@ResponseBody
	public ArrayList<Repo> RepoSearch(@RequestParam("searchInfo") String repoName) {
		System.out.println(1 + repoName);

		String[] languages = { "JavaScript", "Java", "Python" };

		ArrayList<Repo> repos = new ArrayList<Repo>();
		for (int i = 0; i < 10; i++) {
			Repo repo = new Repo();
			repo.setRepoId(i);
			repo.setRepoName("twbs/bootstrap");
			repo.setLanguage(languages[i % 3]);
			repo.setReadMe("BootstrapSleek, intuitive, and powerful front-end framework for"
					+ " faster and easier web development. BootstrapSleek, intuitive, and "
					+ "powerful front-end framework for faster and easier web development.");
			repos.add(repo);
		}

		return repos;
	}

	@RequestMapping(value = "/SearchAction1")
	@ResponseBody
	public ArrayList<Repo> RepoSearch1(@RequestParam("searchInfo") String repoName) {
		System.out.println(2 + repoName);

		String[] languages = { "JavaScript", "Java", "Python" };

		ArrayList<Repo> repos = new ArrayList<Repo>();
		for (int i = 0; i < 10; i++) {
			Repo repo = new Repo();
			repo.setRepoId(i);
			repo.setRepoName("VousAttendezrer/bootstrap");
			repo.setLanguage(languages[i % 3]);
			repo.setReadMe("BootstrapSleek, intuitive, and powerful front-end framework for"
					+ " faster and easier web development. BootstrapSleek, intuitive, and "
					+ "powerful front-end framework for faster and easier web development."
					+ "BootstrapSleek, intuitive, and powerful front-end framework for"
					+ " faster and easier web development. BootstrapSleek, intuitive, and "
					+ "powerful front-end framework for faster and easier web development.");
			repos.add(repo);
		}

		return repos;
	}
}