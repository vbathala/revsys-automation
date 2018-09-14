import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.sql.SQLException;

public class ReachPayCCDD {

    public WebDriver driver;



    @Test

    public void loginReachpay() throws InterruptedException, SQLException {

        System.setProperty("webdriver.chrome.driver", "/Users/vbathala/downloads/chromedriver");
        driver = new ChromeDriver();

        //Login URL
        driver.get("https://reachsecurepay.qa.reachlocal.com/client/index.php");

        //Enter Email
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("reachprodtest1@gmail.com");

        //Go to Password page
        WebElement start = driver.findElement(By.name("commit"));
        start.click();

        //Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='px']")));

        //Enter pwd
        WebElement pwd = driver.findElement(By.xpath(".//*[@id='px']"));
        pwd.sendKeys("Success1");

        //Go to Main Menu page
        WebElement login = driver.findElement(By.name("commit"));
        login.click();

        //Thread.sleep(3000);

        WebDriverWait wait1 = new WebDriverWait(driver,10);
        wait1.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("VIEW")));

        //Go to View Payment page
        WebElement viewpayment = driver.findElement(By.partialLinkText("VIEW"));
        viewpayment.click();

        //Thread.sleep(3000);
        WebDriverWait wait2 = new WebDriverWait(driver,10);
        wait2.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("New")));

        //Add CC Payment Info
        WebElement addccpayment = driver.findElement(By.partialLinkText("New"));
        addccpayment.click();

        //Add Payment name
        WebElement paymentname = driver.findElement(By.id("info_tag"));
        paymentname.sendKeys("vb cc1");

        //Select CC payment
        WebElement paymenttype = driver.findElement(By.id("info_type_0"));
        paymenttype.click();

        //Switch to frame
        driver.switchTo().frame(0);

        //Add Card Name
        WebElement cardname =driver.findElement(By.id("name"));
        cardname.sendKeys("vb cc");

        //Add Card Number
        WebElement cardnumber = driver.findElement(By.id("ccNumber"));
        //cardnumber.sendKeys("4444444444444448");
        cardnumber.sendKeys("4444444444444448");

        //CVC Number
        WebElement cvcnumber = driver.findElement(By.id("CVV2"));
        cvcnumber.sendKeys("123");


        //Select Card Type
        Select cardtype = new Select(driver.findElement(By.name("ccType")));
        cardtype.selectByVisibleText("Visa");

        //Select Exp Month
        Select expmonth = new Select(driver.findElement(By.id("expMonth")));
        expmonth.selectByVisibleText("01");

        //Select Exp year
        Select expyear = new Select(driver.findElement(By.id("expYear")));
        expyear.selectByVisibleText("2021");

        //Thread.sleep(10000);
        WebDriverWait wait3 = new WebDriverWait(driver,10);
        wait3.until(ExpectedConditions.elementToBeClickable(By.id("completeButton")));
        //wait3.until(ExpectedConditions.)

        //Complete CCPaymentInfo
        WebElement complete = driver.findElement(By.id("completeButton"));
        complete.click();
        driver.switchTo().defaultContent();

        //Thread.sleep(3000);
        WebDriverWait wait4 = new WebDriverWait(driver,10);
        wait4.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("New")));



        //Go to View Payment page
        WebElement viewpayment1 = driver.findElement(By.partialLinkText("New"));
        viewpayment1.click();

        //Enter DD Payment Method

        driver.findElement(By.id("info_tag")).sendKeys("vb dd1"); //Account Name

        WebElement PaymentType = driver.findElement(By.id("info_type_1"));
        PaymentType.click();//Payment Type

        driver.findElement(By.id("info_account_name")).sendKeys("vb dd1"); //Card Name

        driver.findElement(By.id("info_account_number")).sendKeys("123456789");//Card Number

        driver.findElement(By.id("info_routing_number")).sendKeys("021000021");


        driver.findElement(By.id("password")).sendKeys("Success1");//Password



        driver.findElement(By.name("commit")).click();   //Submit Payment Info


    }

}