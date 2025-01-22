package org.example.tests

import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org.testng.annotations.AfterClass
import org.testng.annotations.BeforeClass
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL
import java.time.Duration.ofSeconds


class AppiumTest {

    private lateinit var driver: AndroidDriver
    private val appPath = "/Users/kamilpoznakowski/Documents/Projects_my/AppForAppium/app/build/outputs/apk/debug/app-debug.apk"
    private val deviceId = "CEK7OBKRLNAMSS8H"   // id z adb devices

    @BeforeClass
    fun setUp() {
        val options = UiAutomator2Options().apply {
            setUdid(deviceId)
            setDeviceName("AndroidEmulator")
            setApp(appPath)
        }
        try {
            driver = AndroidDriver(URL("http://127.0.0.1:4723"), options)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }
    }

    @Test
    fun testButtonClick() {
        val wait1 = WebDriverWait(driver, ofSeconds(3))
        val textField = wait1.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().description(\"editText1\")")))
        println("mylog Found element: ${textField.getAttribute("content-desc")}")
        textField.click()
        textField.clear()

        Actions(driver).setActiveKeyboard("abc")
        driver.pressKey(KeyEvent(AndroidKey.A))
        driver.pressKey(KeyEvent(AndroidKey.B))
        driver.pressKey(KeyEvent(AndroidKey.C))
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"savebutton1\")")).click()


        val wait = WebDriverWait(driver, ofSeconds(5))
        val result = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().description(\"SavedTextView\")")))
        println("mylog ${result.text}")
        assert(result.text == "abc")
    }

    @AfterClass
    fun tearDown() {
        driver.quit()
    }
}
