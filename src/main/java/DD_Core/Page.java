package DD_Core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import DD_Util.Xlfile_Reader;

public class Page
{
   
   public static WebDriver driver;
   public static Xlfile_Reader excel = new Xlfile_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\DD_TestData\\TestData.xlsx");
   public static Properties config = new Properties();
   public static Properties OR = new Properties();
   public static ExtentReports extent = new ExtentReports(System.getProperty("user.dir")+"\\ExtentResults.html");
   public static ExtentTest test;
   public static Logger logger = LoggerFactory.getLogger(Page.class);
   public static FileInputStream fis;
   
   @BeforeSuite
   public void init() throws IOException{
      fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\DD_Config\\Config.properties");
      config.load(fis);
      
      fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\DD_Config\\OR.properties");
      OR.load(fis);
      
      if(config.getProperty("browser").contentEquals("firefox")){
         driver = new FirefoxDriver();
      }else if (config.getProperty("browser").contentEquals("chrome")){
         System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
         driver = new ChromeDriver();
      }else if (config.getProperty("browser").contentEquals("ie")){
         System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\IEDriverServer.exe");
         driver = new InternetExplorerDriver();
      }
      
      driver.get(config.getProperty("testsiteurl"));
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
      extent.addSystemInfo("Suite", "Regression Suite");
      extent.addSystemInfo("Version", "4.0");
      
   }
   
   @AfterSuite
   public void closeSuite(){
      driver.close();
      extent.flush();
      extent.close();
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   

}
