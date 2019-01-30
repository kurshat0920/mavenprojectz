package com.cybertek.Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {



        public static void main(String [] args){

            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.amazon.com/");

            WebElement input = driver.findElement(By.id("twotabsearchtextbox"));

            input.sendKeys("car" + Keys.ENTER);

            String actual = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");

            String excepted = "car";

            if(actual.contains("car")){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("actual = " + actual);
                System.out.println("excepted = " + excepted);

            }




        }
    }
