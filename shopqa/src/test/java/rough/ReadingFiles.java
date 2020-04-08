package rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingFiles {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
		Properties orFile = new Properties();
		orFile.load(fis);
		System.out.println(orFile.getProperty("myaccountlink"));
		

	}

}
