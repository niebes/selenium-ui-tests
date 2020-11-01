package selenium.ui.tests

import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File





interface DriverProvider {
    fun getWebDriver(): WebDriver
}

interface HeadlessDriverProvider : DriverProvider {
    override fun getWebDriver(): WebDriver = getHeadlessDriver()
    fun getHeadlessDriver(): WebDriver {
        val phantomjs = File("./src/test/resources/phantomjs-mac")
        System.setProperty("phantomjs.binary.path", phantomjs.absolutePath)
        val caps = DesiredCapabilities()
        caps.isJavascriptEnabled = true
        caps.setCapability("takesScreenshot", true)

        return PhantomJSDriver(caps)
    }
}