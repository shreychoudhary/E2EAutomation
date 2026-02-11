package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties prop;

	static {
		try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
			prop = new Properties();
			prop.load(is);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load config");
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}
}
