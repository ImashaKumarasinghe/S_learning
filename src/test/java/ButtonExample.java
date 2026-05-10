import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;

public class ButtonExample{

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/button.xhtml");
    }

    @Test
    public void buttonTests() { 
    //click and confirm title
    driver.findElement(By.id("j_idt88:j_idt90")).click();
    String expectedTitle = "Dashboard";
    String actualTitle = driver.getTitle();
    if (expectedTitle.equals(actualTitle)) {
        System.out.println("actual titile same as expeted= " + actualTitle);
    } else {
        System.out.println("Title is incorrect. Expected: " + expectedTitle + ", Actual: " + actualTitle);
    }

    //find the positin of the submit button
    driver.navigate().back();
  WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt90"));
  Point xypoint = getPosition.getLocation();
 int x = xypoint.getX();
 int y = xypoint.getY();
 System.out.println("The position of the submit button is: " + x + ", " + y);

    //find the color of the save button
    WebElement buttonColor=driver.findElement(By.id("j_idt88:j_idt96"));
    String color = buttonColor.getCssValue("background-color");
    System.out.println("The color of the save button is: " + color);

    //find hight and width of button
    WebElement buttonSize = driver.findElement(By.id("j_idt88:j_idt98"));
    int height = buttonSize.getSize().getHeight();
    int width = buttonSize.getSize().getWidth();

    System.out.println("The height of the button is: " + height);
    System.out.println("The width of the button is: " + width);}
}