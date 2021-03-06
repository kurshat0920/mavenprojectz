package com.cybertek.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {

    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dropdown");


        WebElement selectElement = driver.findElement(By.id("dropdown"));

        Select list = new Select(selectElement);

        String selectedOption = list.getFirstSelectedOption().getText();
        System.out.println(selectedOption);

        List<WebElement> options = list.getOptions();
        System.out.println("option.size() = " + options.size());

        for (WebElement option:options){
            System.out.println(option);
        }

        list.selectByVisibleText("Option 2");
        System.out.println("Selected option" + list.getFirstSelectedOption().getText());

        list.selectByIndex(2);
        System.out.println("Selected option" + list.getFirstSelectedOption().getText());

        list.selectByValue("1");
        System.out.println("Selected option" + list.getFirstSelectedOption().getText());




    }
}
