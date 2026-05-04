import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }

    @Test
    public void linkTests() {
            // Click on the "Go to Dashboard" link and navigate back
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();  

        // Find the link with partial text "Find the" and print its href attribute

        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the"));
        String path = whereToGo.getAttribute("href");
        System.out.println("The path is: " + path);

        // Click on the "Broken?" link and check if the page title contains "404"

        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("The link is broken");
        } else {
            System.out.println("The link is not broken");
        }

        driver.navigate().back();

        // Click on the "Go to Dashboard" link again and navigate back

        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("The number of links is: " + links.size());

        // Find the layout element and count the number of links within it

        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        int countOfLayoutElements = layoutElement.findElements(By.tagName("a")).size();
        System.out.println("The number of links in the layout element is: " + countOfLayoutElements);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}