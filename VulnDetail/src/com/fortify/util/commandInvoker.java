package com.fortify.util;

public class commandInvoker
{
	command command_;
	public void setParser(command com)
	{
		this.command_ = com;
	}
 	public void goParsing() {
	 this.command_.execute();
 	}
 }
