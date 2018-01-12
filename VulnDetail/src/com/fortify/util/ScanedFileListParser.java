package com.fortify.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ScanedFileListParser extends xmlParser {
	public int parsing() {
		NodeList nodeList = doc.getElementsByTagName("SubSection");
		int size = nodeList.getLength();
		Node node = null;
		Element element = null;
		String scanedFileName = null;
		for(int i = 0;i<size;i++) {
			node = nodeList.item(i);
			if (node == null) 
				break;
		
			element = (Element)node;
			scanedFileName = element.getElementsByTagName("Title").item(0).getTextContent();
			if(scanedFileName.compareTo("Files Scanned") == 0) {
				if(isELEMENT_NODE(node.getNodeType()) == true) {			
					subParsing(node);
				}
			}
		}							
		return 0;
	}
	
	private boolean isELEMENT_NODE(short type) {
		if(type == Node.ELEMENT_NODE) {
			return true;
		}
		return false;
	}
	
	private int subParsing(Node node) {
		BufferedWriter out = null;
		try {
			Element element = (Element)node;
			String scanedList = element.getElementsByTagName("Text").item(0).getTextContent();
			out = new BufferedWriter(new FileWriter(this.inform.getResultFileName()));
			out.write(scanedList);
		} catch (IOException e) {
			e.printStackTrace();
			try {
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
