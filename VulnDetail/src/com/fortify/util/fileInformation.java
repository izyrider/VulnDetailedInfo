package com.fortify.util;

public class fileInformation
{
   private String fileName;
   private String resultFilename;
   private int count;

   public int getCount() {
	   return count;
   }

	public void setCount(int count) {
		this.count = count;
	}

	public fileInformation(String fileName, String resultFilename) {
		this.fileName = fileName;
		this.resultFilename = resultFilename;
	}

   	public String getFileName() {
   		return this.fileName;
   	}
 
   	public String getResultFileName() {
   		return this.resultFilename;
   	}
}