package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LaptopsAndNotebooksTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        /**
         * Both steps in 1 mousehover step
         * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
         * 1.2 Click on “Show All Laptops & Notebooks”*/
        mouseHoverAction(By.xpath("//a[text()='Laptops & Notebooks']"),By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(1000);

        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        Thread.sleep(1000);

        //1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> product = driver.findElements(By.xpath("//div[@class='caption']"));
        for (WebElement productName: product)
        {
            System.out.println(productName.getText());
        }
        Thread.sleep(1000);
    }

    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        /**
         * Both steps in 1 mousehover step
         * 1.1 Mouse hover on Laptops & Notebooks Tab.and click
         * 1.2 Click on “Show All Laptops & Notebooks”*/
        mouseHoverAction(By.xpath("//a[text()='Laptops & Notebooks']"),By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(1000);

        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        Thread.sleep(1000);

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[text()='MacBook']"));

        //2.5 Verify the text “MacBook”
        assertVerifyText("Macbook text not found", "MacBook", By.xpath("//h1[contains(text(),'MacBook')]"));
        Thread.sleep(1000);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        assertVerifyText("Success text not found", "Success: You have added MacBook to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //2.9 Verify the text "Shopping Cart"
        assertVerifyText("Shopping cart text not found", "Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"));

        //2.10 Verify the Product name "MacBook"
        assertVerifyText("Product text not found", "MacBook", By.linkText("MacBook"));
        Thread.sleep(1000);

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']")).clear();
        sendTextToElement(By.xpath("//div[@class='input-group btn-block']//input[@class='form-control']"),"2");
        Thread.sleep(1000);

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        //assertVerifyText("Sucess text not found","Success: You have modified your shopping cart!",By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.14 Verify the Total £737.45
        assertVerifyText("Total text not found","$1,204.00",By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$1,204.00']"));

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(1000);

        //2.16 Verify the text “Checkout”
        assertVerifyText("Checkout text not found","Checkout",By.xpath("//a[text()='Checkout']"));

        //2.17 Verify the Text “New Customer”
        assertVerifyText("Customer text not found","New Customer",By.xpath("//h2[contains(text(),'New Customer')]"));

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        Thread.sleep(1000);

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        Thread.sleep(1000);

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"Vishwa");

        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"patel");

        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"vp@gmail.com");

        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"1234567893");

        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"Asking");

        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"Windsor");

        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"123456");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");

        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Anglesey");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(1000);

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@class='form-control']"),"Please call before you deliver the package");
        Thread.sleep(1000);

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        Thread.sleep(1000);

        //2.25 Verify the message “Warning: Payment method required!”
        //assertVerifyText("Warning message not display", "Warning: Payment method required!", By.xpath("//div[text()='Warning: Payment method required!']"));
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
