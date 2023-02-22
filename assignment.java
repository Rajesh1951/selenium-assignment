package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class assign {
    public static void main(String[] args)throws InterruptedException {
//        chrome();
//        firefox();
        safari();
    }
    public static void chrome() throws InterruptedException {
        //1.Choose browser:
        ChromeDriver chromeDriver = new ChromeDriver();
        //2. Launch url
        chromeDriver.get("https://letcode.in/test");
        //3. Identify the element
        WebElement editLinkElement = chromeDriver.findElement(By.xpath("//a[text()='Edit']"));
        //4. Do action on element
        editLinkElement.click();
        Thread.sleep(3000);
        //5. Close the browser:
        chromeDriver.close();
    }

    public static void firefox() throws InterruptedException {
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://letcode.in/test");
        WebElement editLinkElement = firefoxDriver.findElement(By.xpath("//a[text()='Edit']"));
        editLinkElement.click();
        Thread.sleep(3000);
        firefoxDriver.close();
    }
    public static void safari() throws InterruptedException {
        SafariDriver safardriver = new SafariDriver();
        safardriver.navigate().to("https://letcode.in/test");
        WebElement editLinkElement = safardriver.findElement(By.xpath("//a[text()='Edit']"));
        editLinkElement.click();
        Thread.sleep(3000);
        safardriver.close();
    }
}
