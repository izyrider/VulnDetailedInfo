package com.fortify.util;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VulnCountInfoParser extends xmlParser{
	private int count = 0;
	public int parsing() {
		NodeList headNodeList = doc.getElementsByTagName("Chart");
		Node headNode = headNodeList.item(0);
		if (headNode == null) {
			return 1;
		}

		if(isELEMENT_NODE(headNode.getNodeType()) == true) {
			subParsing(headNode);
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
		String strCount = null;
		Element element = (Element)node;
		NodeList elementlist = element.getElementsByTagName("GroupingSection");
		for(int i = 0;i<elementlist.getLength();i++) {
			Element sub = (Element)elementlist.item(i);
			strCount = sub.getAttribute("count").toString();
			count += Integer.parseInt(strCount);
		}
		inform.setCount(count);
		return 0;
	}
}
