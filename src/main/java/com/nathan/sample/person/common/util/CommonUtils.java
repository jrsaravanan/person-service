package com.nathan.sample.person.common.util;



import java.io.File;
import java.io.FileNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Common utility function 
 * @author saravanan renganathan
 *
 */

@Component
public final class CommonUtils {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	public static final String CONFIG_FILE_EMPTY = "File not foud in the classpath";
	public static final String CONFIG_LOCATION = "config.location";
	public static final String CONFIG_DEV = "/config/";
	public static final String CONFIG_FILE_LOCATION = "/var/opt/properties/person";


  
	/**
	 * property file reader 
	 * looking for a given fileName from common property location , it will return from application classpath:
	 * if it is not available in external location
	 * @param fileName
	 * @return {@link Resource}
	 * @throws FileNotFoundException
	 */
 
	public static Resource getConfigFile(String fileName) throws FileNotFoundException {

		if (fileName == null) {
               throw new FileNotFoundException(CONFIG_FILE_EMPTY + "[" + fileName + "]");
        }

		 
		/*
		 * Read from external property file
		 * property file location is hard coded 
		 * it will looks person.properties in /var/opt/properties/person location
		 */

		final File file = new File(CONFIG_FILE_LOCATION + File.separator + fileName);
		
		System.out.println(">> property file -- " + file.getPath() );
		
	      LOGGER.info("Trying to read configuration from file: " + file.getAbsolutePath());
	       if (file != null && file.exists() && file.canRead()) {
	            LOGGER.info("Reading configuration from file: " + file.getAbsolutePath());
	             return new FileSystemResource(file);
	       }
      
         //if the file is not find in above location
         // it will return from classpath
		LOGGER.info(" >> Reading configuration from default config, classpath: " + fileName);
        return new ClassPathResource(fileName);
	}


	

   
	
}
