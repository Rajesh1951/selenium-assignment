package first;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
public class assign2 {
    public static void main(String args[]) {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/edit");
        driver.findElement(By.id("fullName")).sendKeys("Rajesh S");
        driver.findElement(By.id("join")).sendKeys(" human being");
        String textValue=driver.findElement(By.id("getMe")).getAttribute("value");
        System.out.println("textValue:"+textValue);
        driver.findElement(By.id("clearMe")).clear();
        Boolean isEnable=driver.findElement(By.id("noEdit")).isEnabled();
        System.out.println("isEnable:"+isEnable);
        String isReadOnly=driver.findElement(By.id("dontwrite")).getAttribute("readonly");
        System.out.println("isReadOnly:"+isReadOnly);
    }
}
