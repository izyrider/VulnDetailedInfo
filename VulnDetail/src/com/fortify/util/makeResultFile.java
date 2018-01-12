package com.fortify.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class makeResultFile {
	private String filename;
	protected BufferedWriter writeFile;
  	protected StringBuffer resultBuffer;
	
	public makeResultFile(String filename){
		this.filename = filename;
	}
	
	public void createResultFile() {
  		try {
  			this.resultBuffer = new StringBuffer();
  			this.writeFile = new BufferedWriter(new FileWriter(filename));
  		} catch (IOException e) {
  			System.out.println(e.toString());
  		}
  	}
 
  	public void closeResultFile() {
  		try {
  			this.writeFile.close();
  		} catch (IOException e) {
  			System.out.println(e.toString());
  		}
  	}
}
