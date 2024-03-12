package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MovieCriticElements {
    protected static WebDriver driver;

    public static WebElement addNewMovieBtn(){
        return driver.findElement(By.xpath("//h4[text()='Add new movie']"));
    }

    public static WebElement addNewMovieNameInput(){
        return driver.findElement(By.xpath("//div[@class='ReactModalPortal'][1]//input[@id='name']"));
    }

    public static WebElement addNewMovieReleaseDateInput(){
        return driver.findElement(By.xpath("//div[@class='ReactModalPortal'][1]//input[@id='release']"));
    }

    public static WebElement addNewMovieSubmitBtn(){
        return driver.findElement(By.xpath("//div[@class='ReactModalPortal'][1]//button[@type='submit']"));
    }

    public static int getMovieCount(){
        List<WebElement> movies = driver.findElements(By.xpath("//article"));
        return movies.size();
    }
}
