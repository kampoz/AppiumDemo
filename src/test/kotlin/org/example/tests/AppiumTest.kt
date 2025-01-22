package org.example.tests

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL


class AppiumTest {

    private lateinit var driver: AndroidDriver
    private val appPath = "/Users/kamilpoznakowski/Documents/Projects_my/AppForAppium/app/build/outputs/apk/debug/app-debug.apk"

    @BeforeClass
    fun setUp() {
        val options = UiAutomator2Options()
        options.setDeviceName("Android Emulator")  // Nazwa emulatora lub urządzenia
        options.setApp(appPath)  // Ścieżka do pliku APK aplikacji

        try {
            driver = AndroidDriver(URL("http://127.0.0.1:4723"), options)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testButtonClick() {
        val button = driver.findElement(AppiumBy.accessibilityId("SaveButton"))
        button.click()
        val result = driver.findElement(AppiumBy.accessibilityId("SavedTextView"))

        assert(result.text == "No text")
    }

    @AfterClass
    fun tearDown() {
        driver.quit()
    }
}
