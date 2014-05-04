package com.agilemaple.common;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

public class UtilsTest {
	@Test
	public void convertStringIntoListTest(){
		List<String> usernames = Utils.convertStringIntoList("Arvind,Saurabh,SHivam", ",");
		Assert.assertEquals(3, usernames.size());
		List<String> password = Utils.convertStringIntoList("Arvind:Saurabh:SHivam", ":");
		Assert.assertEquals(3, password.size());
	}
}
