package selenium.ui.tests

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.openqa.selenium.*
import selenium.ui.tests.SeleniumUtils.Companion.takeScreenshot

class GoogleTest : HeadlessDriverProvider {

    private lateinit var driver: WebDriver
    private lateinit var google: GooglePage

    @BeforeEach
    internal fun setUp() {
        driver = getWebDriver()
        google = GooglePage(driver)
    }

    @Test
    internal fun open_page() {
        google.open()
        google.`fill and submit search`("selenium how to")
        `take screenshot`("google-search.png")
        assertThat(driver.title).contains("selenium how to")
        println(driver.title)
    }

    private fun `take screenshot`(filename: String) {
        driver.takeScreenshot("/tmp/selenium-screenshots", filename)
    }
}