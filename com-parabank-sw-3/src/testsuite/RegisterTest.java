package testsuite;

import browserfactory.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test

    public void verifyThatSiginingUpPageDisplay(){
        //click on the ‘Register’ link
        selectMenu("//div[@id='loginPanel']/p[2]/a");
        //* Verify the text ‘Signing up is easy!
        verify("//div[@id='rightPanel']/h1","Signing up is easy!");

    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        //click on the ‘Register’ link
        selectMenu("//div[@id='loginPanel']/p[2]/a");
        driver.findElement(By.name("customer.firstName")).sendKeys("Tom1");
        driver.findElement(By.name("customer.lastName")).sendKeys("Smith1");
        driver.findElement(By.name("customer.address.street")).sendKeys("11 Main Street");
        driver.findElement(By.name("customer.address.city")).sendKeys("Boston1");
        driver.findElement(By.name("customer.address.state")).sendKeys("State1");
        driver.findElement(By.name("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.name("customer.phoneNumber")).sendKeys("123-999-9999");
        driver.findElement(By.name("customer.ssn")).sendKeys("888-88-8888");
        driver.findElement(By.name("customer.username")).sendKeys("TomSmith4444");
        driver.findElement(By.name("customer.password")).sendKeys("4444");
        driver.findElement(By.name("repeatedPassword")).sendKeys("4444");
        Thread.sleep(2000);
        selectMenu("//input[@value='Register']");
        Thread.sleep(3000);
        verify("//div[@id='rightPanel']/p","Your account was created successfully. You are now logged in.");


    }



}
