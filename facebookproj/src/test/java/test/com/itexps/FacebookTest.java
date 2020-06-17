/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com.itexps;

import com.itexps.facebookproj.FileUtil;
import com.itexps.facebookproj.LoginVO;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.junit.Test;
//import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Uma
 */
public class FacebookTest {
    
    private WebDriver driver;
    private String baseUrl;
    private static LoginVO login = null;
    
    public FacebookTest() {
   
    }
    
    @BeforeClass
    public static void setUpClass() {
        login = FileUtil.getLoginData();
    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    System.setProperty("webdriver.chrome.driver", "c:\\data\\chromedriver.exe");     
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
  public void testFacebook() throws Exception {
     
   driver.get("https://www.facebook.com/");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys(login.getUsername());
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys(login.getPassword());
    //driver.findElement(By.id("u_0_2")).click();
    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
     
  }
}
