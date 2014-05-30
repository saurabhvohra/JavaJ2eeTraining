package com.agilemaple.common.services.impl;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.helpers.Loader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.agilemaple.common.dao.AuthorDAO;
import com.agilemaple.common.dao.RestClientDAO;
import com.agilemaple.common.services.CapchaService;
import com.agilemaple.common.services.RestClient;

import java.util.Random;
import java.util.UUID;

@Service
public class CapchaServiceImpl implements CapchaService{
	
	
	static byte[] savedArray;
	private static final String CHAR_LIST = 
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int RANDOM_STRING_LENGTH = 10;
@Override
@Transactional
public byte[] CapchaString() {
	
	
	
	String capchaString=randomGenerator();
	         //String capchaString = UUID.randomUUID().toString();
	         savedArray=capchaString.getBytes();
//	       ByteArrayInputStream bais = new ByteArrayInputStream(capchaString.getBytes());
	                    try {
	                       BufferedImage bi=new BufferedImage(300, 100, BufferedImage.TYPE_INT_RGB);
	                       Graphics g = bi.getGraphics();
	                       g.drawString(capchaString, 50, 50);
	                       ByteArrayOutputStream baos = new ByteArrayOutputStream();
	                       ImageIO.write( bi, "png", baos );
	                       baos.flush();
	                       //ImageOutputStream out = new FileImageOutputStream(new File("C:/Users/Saurabh/Documents/Agile maple code/JavaJ2eeTraining/src/main/resources/new.png")); 
	                       //ImageIO.write(bi, "png", out);
	                       //savedArray =  baos.toByteArray();
                          return baos.toByteArray();
	                   } catch (IOException e) {
	                       throw new RuntimeException(e);
	                   }


	    }
public byte[] ReturnedCapchaString(){
	return savedArray;
	
}
@Override
public String randomGenerator(){
	 
		     
		    /**
		     * This method generates random string
		     * @return
		     */
		
		         
		        StringBuffer randStr = new StringBuffer();
		        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
		            int number = getRandomNumber();
		            char ch = CHAR_LIST.charAt(number);
		            randStr.append(ch);
		        }
		        return randStr.toString();
		    }
		     
		    /**
		     * This method generates random numbers
		     * @return int
		     */
		    private int getRandomNumber() {
		        int randomInt = 0;
		        Random randomGenerator = new Random();
		        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		        if (randomInt - 1 == -1) {
		            return randomInt;
		        } else {
		            return randomInt - 1;
		        }
		    }

	
}




