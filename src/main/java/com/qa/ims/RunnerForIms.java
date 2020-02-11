package com.qa.ims;

import org.apache.log4j.Logger;

public class RunnerForIms {
	
	public static final Logger LOGGER = Logger.getLogger(RunnerForIms.class);
	
	public static void main(String[] args) {
		MyIms ims = new MyIms();
		ims.imsSystem();
	}

}
