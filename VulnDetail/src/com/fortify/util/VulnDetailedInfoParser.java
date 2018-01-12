package com.fortify.util;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class VulnDetailedInfoParser extends xmlParser
{
	private BufferedWriter out = null;
	private String detailInfoArray[] = {"Category", "FilePath", "Folder", "LineStart"};
	
	public int parsing() throws IOException
	{
		File file = new File(this.inform.getResultFileName());
		if(file.exists())
			file.delete();
		
		out = new BufferedWriter(new FileWriter(this.inform.getResultFileName()));
		
		NodeList headNodeList = this.doc.getElementsByTagName("Issue");
		int length = headNodeList.getLength();

		if (length == 0) {
			noResult();
			writeResult();
	     } else {
	       for (int i = 0; i < length; i++) {
	         Node headNode = headNodeList.item(i);
	         if (headNode == null) {
	           return 1;
	         }
	 
	         if (isELEMENT_NODE(headNode.getNodeType())) {
	        	 subParsing(headNode,i);
	         }
	       }
	     }
		out.close();
		return 0;
	}

	private boolean isELEMENT_NODE(short type) {
     if (type == 1) {
       return true;
     }
     return false;
   }
 
	private int subParsing(Node node,int index) throws IOException {
     Element element = (Element)node;
 //    System.out.println("***********************************************************");
//     System.out.println(element.getAttributeNode("ruleID"));
//     System.out.println(element.getAttributeNode("iid").toString());
     NodeList elementlist = null;
     Element detailInfo = null;
     int size = detailInfoArray.length;
     
     
     String vulnInfo = null;
     int j = index;
     for(int i = 0;i<size;i++){
    	 elementlist = element.getElementsByTagName(detailInfoArray[i].toString());
    	 detailInfo = (Element)elementlist.item(0);
    	 if(index == j) {
 //   		 System.out.print(Integer.toString(index));
//			 인덱스 번호    		 
    		 vulnInfo = Integer.toString(index);
    	 }
    	 System.out.print(","+ detailInfo.getChildNodes().item(0).getNodeValue().toString()); 	 
    	 vulnInfo += "," + detailInfo.getChildNodes().item(0).getNodeValue();
    	 
    	 
    	 j++;
     }
     System.out.println(vulnInfo);
     out.write(vulnInfo.toString());
     out.newLine();
     System.out.println("");
 
//     writeResult();
     return 0;
   }
	   
   
   private void noResult() {
//     this.resultBuffer.append("Critical 0");
   }
 
   private void writeResult() {
//       this.writeFile.write(this.resultBuffer.toString());
   }
 }
