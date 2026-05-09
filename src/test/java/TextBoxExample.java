import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod; 

import org.openqa.selenium.WebElement;

public class TextBoxExample {
    
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests() {
        //enter name in the text box
        WebElement name =driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Imasha Kumarasinghe");

        //append country name in the text box
        WebElement country = driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys("Sri Lanka");

        //verify if the text box is disabled
        boolean enabled =driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println(" text box enabled " + enabled);

        //clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //retrieve the typed text 
        WebElement retrieveText = driver.findElement(By.id("j_idt88:j_idt95"));
        String retrieveString = retrieveText.getAttribute("value");
        System.out.println("The typed text is: " + retrieveString);

        //type email and press tab to move to the next text box
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("imakumarasinghe00@gmail.com"+org.openqa.selenium.Keys.TAB +"confirm go to next element");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
