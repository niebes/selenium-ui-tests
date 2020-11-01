package selenium.ui.tests

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import java.util.concurrent.TimeUnit

class IdealoTest : HeadlessDriverProvider {

    lateinit var driver: WebDriver

    @BeforeEach
    internal fun setUp() {
        driver = getWebDriver()
    }

    @Test
    internal fun open_page() {
        val baseUrl = "http://www.google.de/";
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
}