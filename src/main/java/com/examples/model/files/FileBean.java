package com.examples.model.files;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FileBean {
	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
}