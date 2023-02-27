package org.example;

import java.io.File;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
//        mouse();
//        alertFunc();
//        windowFunc();
//        try {
//            screenShot();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        dropdown();
    }
    public static void alertFunc() throws InterruptedException{
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://letcode.in/alert");
        WebElement alertEle= driver.findElement(By.xpath("//*[@id=\"prompt\"]"));
        alertEle.click();
        driver.switchTo().alert().sendKeys("Noob Coder");
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        driver.close();
    }
    public static void windowFunc() throws InterruptedException{
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://letcode.in/windows");
        String parent=driver.getWindowHandle();
        WebElement multipg=driver.findElement(By.xpath("//*[@id=\"multi\"]"));
        multipg.click();
        Set<String> windows=driver.getWindowHandles();
        List<String> windowList=new ArrayList<>(windows);
//        windowList.get(0);
        Iterator<String> i=windows.iterator();

//        traversing and closing child windows

        while(i.hasNext()){
            String child=i.next();
            if(!parent.equals(child)) {
                driver.switchTo().window(child);
                System.out.println("Title of child window " + driver.switchTo().window(child).getTitle());
                driver.close();
            }
        }


        driver.switchTo().window(parent);
//        driver.close();
    }

    public static void mouse() throws InterruptedException{
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://letcode.in/dropable");
        Actions dragDrop=new Actions(driver);
        dragDrop.dragAndDrop(driver.findElement(By.xpath("//*[@id=\"draggable\"]")), driver.findElement(By.xpath("//*[@id=\"droppable\"]")) ).build().perform();
        Thread.sleep(3000);
        driver.close();
    }

    public static void screenShot() throws InterruptedException, IOException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://letcode.in/game");
        TakesScreenshot screenshot= ((TakesScreenshot)driver);
        File source=screenshot.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File("./destination.png"));
        Thread.sleep(3000);
        driver.close();
    }

    public static void input() throws InterruptedException{
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://letcode.in/edit");
        driver.findElement(By.xpath("//*[@id=\"fullName\"]")).sendKeys("Rajesh S");
        driver.findElement(By.xpath("//*[@id=\"join\"]")).sendKeys("human");
        System.out.println(driver.findElement(By.xpath("//*[@id=\"getMe\"]")).getAttribute("value"));
        driver.close();
    }
    public static void dropdown() throws InterruptedException{
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://letcode.in/dropdowns");
        Select select =new Select(driver.findElement(By.xpath("//*[@id=\"fruits\"]")));
//        List<WebElement> list=select.getOptions();        //list of all options
        select.selectByValue("1");
        WebElement multiSelect = driver.findElement(By.xpath("//*[@id=\"superheros\"]"));
        Select select2 = new Select(multiSelect);
        select2.selectByValue("aq");
        WebElement lang= driver.findElement(By.xpath("//*[@id=\"lang\"]"));
        Select select3=new Select(lang);
        select3.selectByIndex(1);
        Thread.sleep(3000);
        driver.close();
    }
}

