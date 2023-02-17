package org.cbsl.resuableComponent;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class PropertiesOperations {

	public static String getPropertyValueByKey(String keyName) throws Exception {
		Properties prop = new Properties();
		String propertyFile = System.getProperty("user.dir") + "/src/test/resources/config.properties";

		InputStream is = new FileInputStream(propertyFile);
		prop.load(is);

		String value = prop.get(keyName).toString();

		if (StringUtils.isEmpty(value)) {
			try {
				throw new Exception("Value is not specified for key: " + keyName + " in properties file.");
			} catch (Exception e) {

			}

		}

		return value;
	}

}
