package selenium.ui.tests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.*
import selenium.ui.tests.SeleniumUtils.Companion.takeScreenshot

class GoogleTest : HeadlessDriverProvider {

    lateinit var driver: WebDriver

    @BeforeEach
    internal fun setUp() {
        driver = getWebDriver()
    }

    @Test
    internal fun open_page() {
        `open google`()
        `fill and submit search`("selenium how to")
        `take screenshot`("google-search.png")
        assertThat(driver.title).contains("selenium how to")
        println(driver.title)
    }

    private fun `open google`() {
        driver.get("http://www.google.de/");
    }

    private fun `fill and submit search`(searchTerm: String) {
        with(driver.findElements(By.name("q")).single()) {
            sendKeys(searchTerm)
            submit()
        }
    }

    private fun `take screenshot`(filename: String) {
        driver.takeScreenshot("/tmp/selenium-screenshots", filename)
    }
}