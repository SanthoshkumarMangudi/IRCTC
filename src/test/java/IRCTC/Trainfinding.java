package IRCTC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Trainfinding {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\softwares\\selenium\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[contains(@class,'btn-primary')][text()='OK']")).click();

        driver.findElement(By.xpath("//input[@aria-controls='pr_id_1_list']")).sendKeys("tirupp");
        List<WebElement> fromsuggest = driver.findElements(By.cssSelector("li[class*='ng-tns-c57-8']"));
        Thread.sleep(5000);
        for(WebElement from:fromsuggest)
        {
            if (from.getText().equalsIgnoreCase("TIRUPPUR - TUP"))
            {
                from.click();
                break;
            }
        }
        driver.findElement(By.cssSelector("input[aria-controls='pr_id_2_list']")).sendKeys("chen");
        List<WebElement> tosuggest = driver.findElements(By.cssSelector("li[class*='ng-tns-c57-9']"));
        Thread.sleep(10000);
        for(WebElement to:tosuggest)
        {
            //if (to.getText().equalsIgnoreCase("MGR CHENNAI CTL - MAS"))
                if (to.getText().contains("MGR"))
            {
                to.click();
                break;
            }
        }
        int day =10;
        String month ="November";
        driver.findElement(By.cssSelector("span[class='ng-tns-c58-10 ui-calendar']")).click();
        while (true) {
        String text = driver.findElement(By.xpath("//*[@id='jDate']/span/div/div/div[1]/div/span[1]")).getText();

            if (text.equals(month))
            {
                break;
            }
            else
            {
                driver.findElement(By.cssSelector("span[class*='ui-datepicker-next-icon']")).click();
            }

        }
        driver.findElement(By.xpath("//a[contains(text(),"+day+")]")).click();

        driver.findElement(By.cssSelector("div[class*='ng-tns-c65-12'] span[class*='ui-dropdown-trigger-icon']")).click();
        driver.findElement(By.cssSelector("li[aria-label='LOWER BERTH/SR.CITIZEN']")).click();
        driver.findElement(By.cssSelector("span[class='ui-button-text ui-clickable']")).click();
        driver.findElement(By.cssSelector("div[class*='ng-tns-c65-11'] span[class*='ui-dropdown-trigger-icon']")).click();
        driver.findElement(By.xpath("//li[@aria-label='AC First Class (1A) ']")).click();
        driver.findElement(By.cssSelector("div[class='col-sm-6 remove-padding'] label[for='availableBerth']")).click();
        driver.findElement(By.cssSelector("img[id='disha-banner-close']")).click();
        driver.findElement(By.cssSelector("img[id='messageDialogClose']")).click();
        driver.findElement(By.xpath("//*[@id='askDishaLuncher']/img")).click();
        driver.findElement(By.cssSelector("button[class='search_btn train_Search']")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id='divMain']/div/app-train-list/div[4]/div[1]/div[5]/div[1]/div[1]/app-train-avl-enq/div[1]/div[5]/div[1]/table/tr/td[1]/div/div[2]/span")).click();
        System.out.println("gddf");
        System.out.println("gddf");
        System.out.println("gddf");



    }
}
