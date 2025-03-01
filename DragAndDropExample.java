

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropExample {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to a webpage with drag and drop functionality
            driver.get("https://jqueryui.com/droppable/");
            driver.manage().window().maximize();

            // Switch to the frame containing the elements
            driver.switchTo().frame(0);

            // Locate the source and target elements
            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));

            // Perform drag and drop action
            Actions actions = new Actions(driver);
            actions.dragAndDrop(source, target).perform();

            // Verify success
            String textAfterDrop = target.getText();
            if (textAfterDrop.contains("Dropped!")) {
                System.out.println("Drag and Drop successful!");
            } else {
                System.out.println("Drag and Drop failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

