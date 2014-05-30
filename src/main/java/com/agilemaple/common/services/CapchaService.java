package com.agilemaple.common.services;

import java.awt.image.BufferedImage;

public interface CapchaService {
	public  byte[] CapchaString();
	public byte[] ReturnedCapchaString();
	public String randomGenerator();

}
