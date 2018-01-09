package nju.reviewlabel.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import nju.reviewlabel.service.UploadFileService;
import nju.reviewlabel.service.impl.UploadFileServiceImpl;

public class UploadFileController {
	private UploadFileService ufs = new UploadFileServiceImpl();
	
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(@RequestParam("dataFile") MultipartFile partFile) {
		try {
			int uploadResult = ufs.uploadDataFile(partFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
