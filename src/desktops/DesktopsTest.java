package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    //1.Test name verifyProductArrangeInAlphaBaticalOrder()
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        /**
         * Both steps in 1 mouse hover step
         * 1.1 Mouse hover on Desktops Tab.and click
         * 1.2 Click on “Show All Desktops”
         */
        mouseHoverAction(By.xpath("//li[@class='dropdown']//a[text()='Desktops']"), By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(2000);

        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='caption']"));
        System.out.println("Products list in decending order :");
        for (WebElement productsName : products)
        {
            System.out.println(productsName.getText());
        }
        Thread.sleep(1000);
    }

    //2. Test name verifyProductAddedToShoppingCartSuccessFully()
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        /**
         * Both steps in 1 mouse hover step
         * 2.1 Mouse hover on Desktops Tab. and click
         * 2.2 Click on “Show All Desktops”
         */
        mouseHoverAction(By.xpath("//li[@class='dropdown']//a[text()='Desktops']"), By.xpath("//a[contains(text(),'Show AllDesktops')]"));
        Thread.sleep(2000);

        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Thread.sleep(1000);

        //2.5 Verify the Text "HP LP3065"
        assertVerifyText("Hp text not found","HP LP3065",By.xpath("//h1[contains(text(),'HP LP3065')]"));

        //2.6 Select Delivery Date "2022-11-30"
        WebElement deliveryDateInput = driver.findElement(By.id("input-option225"));
        deliveryDateInput.clear();
        deliveryDateInput.sendKeys("2022-11-30");
        Thread.sleep(2000);

        //2.7.Enter Qty "1” using Select class.
        WebElement quantity= driver.findElement(By.xpath("//input[@id='input-quantity']"));
        quantity.clear();
        quantity.sendKeys("1");
        Thread.sleep(1000);

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(2000);

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
         assertVerifyText("Success message not found","Success: You have added HP LP3065 to your shopping cart!\n×",By.xpath("//div[@class='alert alert-success alert-dismissible']"));

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);

        //2.11 Verify the text "Shopping Cart"
        assertVerifyText("Shopping cart text not found","Shopping Cart",By.xpath("//a[contains(text(),'Shopping Cart')]"));
        Thread.sleep(1000);

        //2.12 Verify the Product name "HP LP3065"
        assertVerifyText("Hp text not found","HP LP3065",By.xpath("//div[@class='table-responsive']//a[text()='HP LP3065']"));

        //2.13 Verify the Delivery Date "2022-11-30"
        assertVerifyText("Date not found","Delivery Date:2022-11-30",By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));

        //2.14 Verify the Model "Product21"
        assertVerifyText("Product 21 not found","Product 21",By.xpath("//td[contains(text(),'Product 21')]"));
        Thread.sleep(1000);

        //2.15 Verify the Todat "£74.73"
        assertVerifyText("$122 text not found","$122.00",By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$122.00']"));
        Thread.sleep(1000);
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
