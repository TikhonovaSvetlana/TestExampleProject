package my.org.autotest;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class CSSSRLinkTest {
	private static final Logger log = Logger.getLogger(CSSSRLinkTest.class);

	 WebDriver driver;
	 WebElement SoftLink = null;
	 WebElement VKLink = null;
	 
	 //Source Data
	 String SoftXpath = "//a[contains( text(),'Софт')]";
	 String VKXpath = "//a[contains( text(),'vk.com')]";
	 String SampleSoftLink = "http://monosnap.com/";
	 String SampleVKLink = "http://vk.com/csssr";


	 @BeforeClass
	  public static void startLogger() {
		 try {
			System.out.println("start logger part");
			System.out.println("#####Present Project Directory : "+ System.getProperty("user.dir"));
			String nameFile = System.getProperty("user.dir") + "/nee.log4j.properties";
			System.out.println("#####LogFileName  " + nameFile);
			PropertyConfigurator.configure(System.getProperty("user.dir")+"/nee.log4j.properties");
		 }
			catch (RuntimeException e){
				 log.error("#####Logger start is failed", e);
			}
	  }
	  
	  @Before
	  public void startBrowser() {
		  
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		log.info("#####StartBrowser");
		try {
			driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
		catch (RuntimeException e){
			 log.error("#####WebDriver initializing is failed", e);
		}
	  }

	  @Test
	  public void SoftLinkCheckingTest() {
		  try {
			  log.info("#####SoftLinkCheckingTest is started");
			  OpenSiteInBrowser();
			  SoftLink = GetSoftLink();
			  log.info("#####Wright Link =  " + SampleSoftLink);
			  log.info("#####Site Link =  " + SoftLink.getAttribute("href"));
			  Assert.assertEquals(SampleSoftLink, SoftLink.getAttribute("href"));
		  	} catch (RuntimeException e){
				 log.error("#####SoftLinkCheckingTest is failed", e);
				 Assert.assertFalse(true);
			}
		  log.info("#####SoftLinkCheckingTestEnded");

	  }

	  @Test
	  public void VKLinkCheckingTest() {
		 try {
			 log.info("#####VKLinkCheckingTest is started");
			 System.out.println("VKLinkCheckingTest started");
			 OpenSiteInBrowser();
			 VKLink = GetVKLink();
			 log.info("#####Wright Link =  " + SampleVKLink);
			 log.info("#####Site Link =  " + VKLink.getAttribute("href"));
			 Assert.assertEquals(SampleVKLink, VKLink.getAttribute("href"));
		 } catch (RuntimeException e){
			 log.error("#####test2 failed", e);
			 Assert.assertFalse(true);
		}
		 log.info("#####VKLinkCheckingTest is ended");
		 System.out.println("VKLinkCheckingTest is ended");
	  }

	  
	  @After
	  public void ShutDownDriver() {
		  if (driver != null) {
		    	   try {
		    		   driver.close();		   
		    		   log.info("#####Driver is shut down");
	   } catch (RuntimeException e){
			 log.error("#####Driver shutdown is failed", e);
		}
	  }
	  }
		  
	  private void OpenSiteInBrowser() {
		  try {
	    driver.get("http://blog.csssr.ru/qa-engineer/");
		  } catch (RuntimeException e){
			 log.error("#####Site opening is failed", e);
		}
	  }
	  
	  private WebElement GetSoftLink() {
		  WebElement Link = null;
		  try {
			    Link = driver.findElement(By.xpath(SoftXpath));
			    log.info("#####Link " + Link.getAttribute("href"));
		  } catch (RuntimeException e){
			 log.error("#####Something failed", e);
		}
		return Link;
	  }
	  
	  private WebElement GetVKLink() {
		  WebElement Link = null;
		  try {
			    Link = driver.findElement(By.xpath(VKXpath));
			    log.info("#####Link " + Link.getAttribute("href"));
		  } catch (RuntimeException e){
			 log.error("#####Something failed", e);
		}
		return Link;
	  }

	}

