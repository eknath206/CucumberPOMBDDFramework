package com.qa.util;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 20;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

}
