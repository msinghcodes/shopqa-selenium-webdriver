package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties ORFile;
	public static Properties configFile;

	@BeforeSuite
	public void setUp() {

		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configFile = new Properties();
		try {
			configFile.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(configFile.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/browsers/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(configFile.getProperty("baseurl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if(configFile.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/browsers/geckodriver");
			driver = new FirefoxDriver(); driver.manage().window().maximize();
			driver.get(configFile.getProperty("baseurl"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			System.out.println("Browser not found");
		}
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ORFile = new Properties();
		try {
			ORFile.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		 

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();

	}

}
