package testsuite;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("TomSmith4444");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("4444");
        selectMenu("//input[@value='Log In']");
        Thread.sleep(2000);
        verify("//div[@id='rightPanel']/div/div/h1","Accounts Overview");
    }
    @Test
    public void verifyTheErrorMessage(){
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("TomSmithde333");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("333546");
        selectMenu("//input[@value='Log In']");
        verify("//div[@id='rightPanel']/p","An internal error has occurred and has been logged.");


    }
    @Test
    public void userShouldLogOutSuccessfully() throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("TomSmith4444");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("4444");
        selectMenu("//input[@value='Log In']");

        selectMenu("//div[@id='leftPanel']/ul/li[8]/a");
        verify("//div[@id='leftPanel']/h2","Customer Login");

    }









}
