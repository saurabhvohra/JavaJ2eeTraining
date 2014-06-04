package com.agilemaple.common.dao;

import java.util.List;

import org.springframework.stereotype.Service;


import com.agilemaple.common.entity.Authors;
import com.agilemaple.common.entity.Contact;

@Service
public interface AuthorDAO {
	
	public Authors persistAuthor(Authors authors);
	
	/**
	 * Returns an Image object that can then be painted on the screen. 
	 * The url argument must specify an absolute {@link URL}. The name
	 * argument is a specifier that is relative to the url argument. 
	 * <p>
	 * This method always returns immediately, whether or not the 
	 * image exists. When this applet attempts to draw the image on
	 * the screen, the data will be loaded. The graphics primitives 
	 * that draw the image will incrementally paint on the screen. 
	 *
	 * @param  url  an absolute URL giving the base location of the image
	 * @param  name the location of the image, relative to the url argument
	 * @return      the image at the specified URL
	 * @see         Image
	 */
	public Authors saveAuthor(Authors authors);
	
}
