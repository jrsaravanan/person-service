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


@Component
public final class CommonUtils {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);

	public static final String CONFIG_FILE_EMPTY = "File not foud in the classpath";
	public static final String CONFIG_LOCATION = "config.location";
	public static final String CONFIG_DEV = "/config/";


  
 
	public static Resource getConfigFile(String fileName) throws FileNotFoundException {

		if (fileName == null) {
               throw new FileNotFoundException(CONFIG_FILE_EMPTY + "[" + fileName + "]");
        }

		if (StringUtils.hasText(System.getProperty(CONFIG_LOCATION))) {

			final File file = new File(System.getProperty(CONFIG_LOCATION) + File.separator + fileName);
              LOGGER.info("Trying to read configuration from file: " + file.getAbsolutePath());
               if (file.exists() && file.canRead()) {
                    LOGGER.info("Reading configuration from file: " + file.getAbsolutePath());
                     return new FileSystemResource(file);
               }
        }

		LOGGER.info(" >> Reading configuration from default config, classpath: /config/" + fileName);
        return new ClassPathResource(fileName);
	}


	

   
	
}
