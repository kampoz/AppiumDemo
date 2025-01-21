package org.example.tests

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.WebElement
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL

class AppiumTest {

    private lateinit var driver: AndroidDriver

    @BeforeClass
    fun setUp() {
        val options = UiAutomator2Options()
        options.setDeviceName("Android Emulator")  // Nazwa emulatora lub urządzenia

        // TODO add path do correct apk
        options.setApp("path/to/your/app.apk")  // Ścieżka do pliku APK aplikacji

        try {
            driver = AndroidDriver(URL("http://127.0.0.1:4723"), options)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testButtonClick() {
        // Znajdź element przyciskiem ID

        // todo add tag in app in composable button by Modifier.testTeg(<String>), add that tag here
        // replace that code by
        // val button = driver.findElement(AppiumBy.accessibilityId("myButton"))
        val button: WebElement = driver.findElement(AppiumBy.id("com.example:id/button"))


        button.click()

        // Weryfikacja tekstu na ekranie
        val result: WebElement = driver.findElement(AppiumBy.id("com.example:id/result"))
        assert(result.text == "Expected Result")
    }

    @AfterClass
    fun tearDown() {
        driver.quit()
    }
}
