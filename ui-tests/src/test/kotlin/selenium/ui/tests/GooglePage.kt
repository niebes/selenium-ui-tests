package selenium.ui.tests

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class GooglePage(
        private val driver: WebDriver
) {
    fun open() {
        driver.get("http://www.google.de/");
    }

    fun `fill and submit search`(searchTerm: String) {
        with(driver.findElements(By.name("q")).single()) {
            sendKeys(searchTerm)
            submit()
        }
    }
}