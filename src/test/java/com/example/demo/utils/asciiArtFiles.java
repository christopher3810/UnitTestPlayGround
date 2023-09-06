package com.example.demo.utils;

public enum asciiArtFiles {
	SUCCESS("passedPika.txt"),
	FAILURE("failPepe.txt");
	private final String fileName;

	asciiArtFiles(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}
}
