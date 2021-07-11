package frameWork.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fs = new FileInputStream(src);
			pro = new Properties();
			pro.load(fs);

		} catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
		}

	}

	public String getURL() {

		String url=pro.getProperty("baseURL");
		return url;
	}
	public String username() {

		String username=pro.getProperty("username");
		return username;
	}
	public String password() {

		String password=pro.getProperty("password");
		return password;
	}
	public String chromepath() {

		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String firefoxpath() {

		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
