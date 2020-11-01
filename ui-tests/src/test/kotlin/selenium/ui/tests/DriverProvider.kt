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
        val os = getOs()
        val phantomJsBinPath = when {
            os.contains("Linux") -> "./src/test/resources/phantomjs-linux64"
            os.contains("Mac") -> "./src/test/resources/phantomjs-mac"
            else -> throw IllegalStateException("no driver found")
        }.let(::File)
        System.setProperty("phantomjs.binary.path", phantomJsBinPath.absolutePath)
        val caps = DesiredCapabilities()
        caps.isJavascriptEnabled = true
        caps.setCapability("takesScreenshot", true)

        return PhantomJSDriver(caps)
    }

    fun getOs(): String = System.getProperty("os.name")
}