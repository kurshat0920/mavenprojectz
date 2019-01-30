package com.cybertek.Tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesExample extends TestBase {


    @Test
    public void printWholeTable(){
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }


    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        verifyTextMatches(driver.getTitle(),"Web Orders Login");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

        verifyTextMatches(driver.getTitle(),"Web Orders");
        verifyTextMatches(driver.getCurrentUrl(),"http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");


    }

    @Test
    public void printAllHeeaders(){

        login();
        List<WebElement> headers = driver.findElements(By.xpath("(//table[@id ='ctl00_MainContent_orderGrid'])//th"));
        for (WebElement header : headers){
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRow(){
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("(//table[@id ='ctl00_MainContent_orderGrid'])/tbody/tr"));
        System.out.println("number of rows: " + allRows.size());

        for(WebElement header : allRows){
            System.out.println(header.getText());
        }


        System.out.println("Printing row " + 3);
        System.out.println(allRows.get(2).getText());
    }

    @Test
    public void printTableSize(){
        List<WebElement> allRows = driver.findElements(By.xpath("(//table[@id ='ctl00_MainContent_orderGrid'])/tbody/tr"));
        System.out.println("number of rows: " + allRows.size());

    }

    @Test
    public void printRow2(){
        login();
        WebElement row = driver.findElement(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));
        System.out.println(row.getText());
    }

    /*
    print all the cells of a row whole index is given in the xpath
     */
    @Test
    public void printAllCellsInOneRow(){
        login();
        List<WebElement> cells = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[4]/td"));

        for(WebElement header:cells){
            System.out.println(header.getText());
        }
    }
    @Test
    public void printByCoordiantes(){
        login();
        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));
        System.out.println(cell.getText());

        System.out.println(getCell(6,11).getText());
    }

    public WebElement getCell(int row, int col){
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[" +row+ "]/td[" +col+"]";
        return driver.findElement(By.xpath(xpath));
    }
    @Test
    public WebElement printColumn(int column){
        login();
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+column+"]";
        return  driver.findElement(By.xpath(xpath));

    }
}