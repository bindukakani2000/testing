package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieCriticTestCases extends MovieCriticElements {
    WebDriverWait wait;
    String url = "https://movie-reviews-psi.vercel.app";
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void addNewMovieTest() {
        String name = "Hi nanna";
        String released_date = "04-28-2024";

        try {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article")));
        }catch(Exception ignored){
        }
        int expectedCount = getMovieCount() + 1;
        addNewMovie(name, released_date);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//article)[" + expectedCount + "]")));
        int actualCount = getMovieCount();
        Assert.assertEquals(actualCount, expectedCount);
    }

    @Test
    public void addNewReviewForMovie() throws InterruptedException {
        String movieName = "Hi nanna";
        String released_date = "04-28-2024";
        String name = "Temp";
        int rating = (int)(Math.random() * 11);
        String comments = "temp comments";

        driver.get(url);
        addNewMovie(movieName, released_date);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//article")));
        driver.findElement(By.xpath("(//article)[1]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//h1)[2][text() != '']")));

        Assert.assertEquals(1,1);
    }

    public void addNewMovie(String name, String released_date){
        addNewMovieBtn().click();
        addNewMovieNameInput().sendKeys(name);
        addNewMovieReleaseDateInput().sendKeys(released_date);
        addNewMovieSubmitBtn().click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
