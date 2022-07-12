package tech.walkingtree.Appium.util;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumUtility {
	static AppiumServiceBuilder builder;
	static AppiumDriverLocalService service;
	static AndroidDriver<WebElement> driver;
	static String appiumServiceUrl;

	public static void stopAppiumService() {
		service.stop();
		System.out.println(service.isRunning());
	}

	public static void startServer() {

		File f = new File("APK File");
		File fs = new File(f, "ApiDemos-debug.apk");

		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
			cap.setCapability("unicodeKeyboard", "true");
			cap.setCapability("resetKeyboard", "true");
			cap.setCapability("noReset", "false");
			// cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
			cap.setCapability("appPackage", "com.android.calculator2");
			cap.setCapability("appActivity", "com.android.calculator2.Calculator");

			// Build the Appium service
			builder = new AppiumServiceBuilder();
			builder.withIPAddress("127.0.0.1");
			builder.usingPort(4723);
			builder.withCapabilities(cap);
			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

			// Start the server with the builder
			service = AppiumDriverLocalService.buildService(builder);
			service.start();

			// URL url = new URL("http://127.0.0.1:4723/wd/hub");
			URL url = new URL("http://localhost:4723/wd/hub");
			driver = new AndroidDriver<WebElement>(url, cap);

			driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		} catch (Exception exp) {
			System.out.println("Cause is: " + exp.getCause());
			System.out.println("Message is : " + exp.getMessage());
		}
	}

	public static void touchOnElement(WebElement we) {
		TouchAction touch = new TouchAction(driver);
		touch.tap(tapOptions().withElement(element(we))).perform();

	}
}
