package first;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
public class assign3 {
    public static void main(String args[]) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/buttons");
        driver.findElement(By.id("home")).click();
        driver.navigate().back();
        Point p = driver.findElement(By.id("position")).getLocation();
        int x = p.getX();
        int y = p.getY();
        System.out.println("X: " + x + " y: " + y);
//button color
        String butColor = driver.findElement(By.id("color")).getCssValue("background-color");
        System.out.println(butColor);
//height and width of button
        Rectangle rect = driver.findElement(By.id("property")).getRect();
        System.out.println("width- " + rect.getWidth());
        System.out.println("height- " + rect.getHeight());
//check button disabled
        Boolean isDisable = driver.findElement(By.id("isDisabled")).isDisplayed();
        System.out.print("Disable: " + isDisable);
//click and hold
        WebElement clickAndHold = driver.findElement(By.tagName("h2"));
        Actions act = new Actions(driver);
        act.clickAndHold(clickAndHold);
    }
}
