package selenium.ui.tests

import com.google.common.io.Files
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import java.io.File

class SeleniumUtils private constructor() {
    companion object {
        private fun WebDriver.getScreenshotAsPng(): File {
            check(this is TakesScreenshot) { "given WebDriver doesn't support screenhots" }
            return getScreenshotAs(OutputType.FILE)
        }

        fun WebDriver.takeScreenshot(path: String, filename: String) {
            File(path).mkdirs()
            Files.copy(getScreenshotAsPng(), File(path, filename))
        }
    }
}