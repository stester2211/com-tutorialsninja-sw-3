package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    //1.1 create method with name "selectMyAccountOptions" it has one parameter name "option" of type string
    public void selectMyAccountOptions(String option)
    {
        //1.2 This method should click on the options whatever name is passed as parameter. (Hint: Handle List of Element and Select options)
        List<WebElement> options= driver.findElements(By.linkText(option));
        for (WebElement op: options)
        {
            op.click();
        }
    }

    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(1000);

        //1.3 Verify the text “Register Account”.
        assertVerifyText("Register text not found", "Register Account", By.xpath("//h1[contains(text(),'Register Account')]"));
        Thread.sleep(1000);
    }

    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException
    {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(1000);

        //2.3 Verify the text “Returning Customer”.
        assertVerifyText("Returning customer text not found","Returning Customer",By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Thread.sleep(1000);
    }

    //3. Test name verifyThatUserRegisterAccountSuccessfully()
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        Thread.sleep(1000);

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Vishwa");

        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Patel");

        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"vp1234@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"1234567885");
        Thread.sleep(1000);

        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"123456vv");

        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"123456vv");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//input[@type='radio'][@name='newsletter'][@value='1']"));
        Thread.sleep(1000);

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox'][@name='agree'][@value='1']"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        assertVerifyText("Account created message not display", "Your Account Has Been Created!", By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        Thread.sleep(1000);

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout");
        Thread.sleep(1000);

        //3.16 Verify the text “Account Logout”
        assertVerifyText("Logout text not found","Account Logout",By.xpath("//h1[contains(text(),'Account Logout')]"));
        Thread.sleep(1000);

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login");
        Thread.sleep(1000);

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"vp@gmail.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"123456vv");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        assertVerifyText("My account text not found","My Account", By.xpath("//h2[contains(text(),'My Account')]"));

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //selectMyAccountOptions("Logout");
        Thread.sleep(1000);

        //4.10 Verify the text “Account Logout”
        assertVerifyText("Logout text not found","Account Logout",By.xpath("//h1[contains(text(),'Account Logout')]"));
        Thread.sleep(1000);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }


    @After
    public void quitBrowser()
    {
        closeBrowser();
    }
}
