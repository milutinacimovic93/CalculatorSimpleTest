package Dom2609;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class CalculatorTest {

    private WebDriver driver;
    private WebElement firstNumber;
    private WebElement secondNumber;
    private List<WebElement> operations;
    private WebElement calculate;

    @BeforeClass

    public void setup() {

        System.setProperty("webdriver.chrome.driver", "C://Users//ROG//IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();

    }

    @BeforeMethod

    public void restart() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().window().maximize();
        firstNumber = driver.findElement(By.id("number1Field"));
        secondNumber = driver.findElement(By.id("number2Field"));
        operations = driver.findElements(By.id("selectOperationDropdown"));
        calculate = driver.findElement(By.id("calculateButton"));
    }

    @Test

    public void multiplyTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearBtn = driver.findElement(By.id("clearButton"));

        js.executeScript("arguments[0].scrollIntoView();", clearBtn);

        firstNumber.sendKeys("5");
        secondNumber.sendKeys("-5");


        for (int i = 0; i < operations.size(); i++) {
            WebElement operation = operations.get(i);
            Select multiply = new Select(operation);
            multiply.selectByVisibleText("Multiply");
            break;
        }

        calculate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String expectedResult = "-25";
        String actualResult = String.valueOf(result.getAttribute("value"));
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void divideTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearBtn = driver.findElement(By.id("clearButton"));

        js.executeScript("arguments[0].scrollIntoView();", clearBtn);

        firstNumber.sendKeys("25");
        secondNumber.sendKeys("5");

        for (int i = 0; i < operations.size(); i++) {
            WebElement operation = operations.get(i);
            Select multiply = new Select(operation);
            multiply.selectByVisibleText("Divide");
            break;
        }

        calculate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String expectedResult = "5";
        String actualResult = String.valueOf(result.getAttribute("value"));
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void addTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearBtn = driver.findElement(By.id("clearButton"));

        js.executeScript("arguments[0].scrollIntoView();", clearBtn);

        firstNumber.sendKeys("25");
        secondNumber.sendKeys("5");

        for (int i = 0; i < operations.size(); i++) {
            WebElement operation = operations.get(i);
            Select multiply = new Select(operation);
            multiply.selectByVisibleText("Add");
            break;
        }

        calculate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String expectedResult = "30";
        String actualResult = String.valueOf(result.getAttribute("value"));
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void subtractTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearBtn = driver.findElement(By.id("clearButton"));

        js.executeScript("arguments[0].scrollIntoView();", clearBtn);

        firstNumber.sendKeys("25");
        secondNumber.sendKeys("5");

        for (int i = 0; i < operations.size(); i++) {
            WebElement operation = operations.get(i);
            Select multiply = new Select(operation);
            multiply.selectByVisibleText("Subtract");
            break;
        }

        calculate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String expectedResult = "20";
        String actualResult = String.valueOf(result.getAttribute("value"));
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void concatenateTest() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement clearBtn = driver.findElement(By.id("clearButton"));

        js.executeScript("arguments[0].scrollIntoView();", clearBtn);

        firstNumber.sendKeys("25");
        secondNumber.sendKeys("5");

        for (int i = 0; i < operations.size(); i++) {
            WebElement operation = operations.get(i);
            Select multiply = new Select(operation);
            multiply.selectByVisibleText("Concatenate");
            break;
        }

        calculate.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement result = driver.findElement(By.id("numberAnswerField"));
        String expectedResult = "255";
        String actualResult = String.valueOf(result.getAttribute("value"));
        Assert.assertEquals(actualResult, expectedResult);

    }

    @AfterClass
    public void afterClass() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
