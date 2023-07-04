package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

//1. create class "TopMenuTest"
public class TopMenuTest extends Utility
{
    @Before
    public void openBrowser()
    {
        setUpBrowser();
    }

    //1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu)
    {
        //1.2 This method should click on the menu whatever name is passed as parameter. Write the following Test:
        clickOnElement(By.xpath(menu));
    }

    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        //1.1 Mouse hover on “Desktops” Tab and click
        clickOnElement(By.xpath("//a[text()='Desktops']"));
        Thread.sleep(2000);

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("//a[contains(text(),'Show AllDesktops')]");
        Thread.sleep(2000);

        //1.3 Verify the text ‘Desktops’
        assertVerifyText("Desktop text not found", "Desktops", By.xpath("//h2[contains(text(),'Desktops')]"));
    }

    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException
    {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("//a[contains(text(),'Show AllLaptops & Notebooks')]");
        Thread.sleep(2000);

        //2.3 Verify the text ‘Laptops & Notebooks’
        assertVerifyText("Laptop and notebook text not found", "Laptops & Notebooks",By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"));
    }

    //3. verifyUserShouldNavigateToComponentsPageSuccessfully()
    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //3.1 Mouse hover on “Components” Tab and click
        clickOnElement(By.xpath("//a[text()='Components']"));

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("//a[contains(text(),'Show AllComponents')]");
        Thread.sleep(1000);

        //3.3 Verify the text ‘Components’
        assertVerifyText("Component text not found","Components", By.xpath("//h2[contains(text(),'Components')]"));
    }

    @After
    public void quitBrowser()
    {
        closeBrowser();
    }

}
