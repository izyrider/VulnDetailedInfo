package com.fortify.util;

import java.io.IOException;

public class VulnDetail {
	public static void main(String[] args) throws IOException {
		
		String param0 = "/Users/zack27/temp/nhtest.xml";
		String param1 = "/Users/zack27/temp/nhtest.txt";
		
//		String param0 = args[0];
//		String param1 = args[1];
		fileInformation information = new fileInformation(param0.toString(), param1.toString());

		VulnCountInfoParser countInfo = new VulnCountInfoParser();
		countInfo.init(information);
		countInfo.parsing();
		int size = information.getCount();
		if(size > 0){
			ScanedFileListParser scanedFileList = new ScanedFileListParser();
			scanedFileList.init(information);
			scanedFileList.parsing();
		}		
		
		
/* 		VulnDetailedInfoParser detailedInfo = new VulnDetailedInfoParser();
		detailedInfo.init(information);
		detailedInfo.parsing();
*/
	}

}
