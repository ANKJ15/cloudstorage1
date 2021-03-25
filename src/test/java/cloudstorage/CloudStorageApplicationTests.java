package com.udacity.jwdnd.course1.cloudstorage;

import cloudstorage.HomePage;
import cloudstorage.LoginPage;
import cloudstorage.SignupPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CloudStorageApplicationTests {

	@LocalServerPort
	public int port;

	public static WebDriver driver;

	public String baseURL;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
		driver = null;
	}

	@BeforeEach
	public void beforeEach() {
		baseURL = baseURL = "http://localhost:" + port;
	}

	@Test
	public void testUserSignup() throws InterruptedException {
		String username = "ankj";
		String password = "12345";


		driver.get(baseURL + "/signup");

		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup("karim", "12345", username, password);
		Thread.sleep(5000);

	}

	@Test
	public void testUserLogin() throws InterruptedException {

		String username = "karim";
		String password = "12345";


		driver.get(baseURL + "/login");

		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);


		Thread.sleep(5000);
	}


	@Test
	public void testUserSignUpLoginAndAutheticateHomePage() throws InterruptedException {

		String username = "karim";
		String password = "12345";

		driver.get(baseURL + "/signup");
		Thread.sleep(5000);
		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup("karim", "12345", username, password);
		Thread.sleep(5000);





		driver.get(baseURL + "/login");
		Thread.sleep(5000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		Thread.sleep(5000);



		HomePage homePage = new HomePage(driver);
		Assertions.assertEquals("Home", driver.getTitle());
		homePage.logout();
		driver.get(baseURL + "/");
		Thread.sleep(5000);
		Assertions.assertEquals("Login", driver.getTitle());
	}


	@Test
	public void addAndUpdateAndDeleteNewNote() throws InterruptedException {

		String username = "ankj";
		String password = "12345";
		driver.get(baseURL + "/signup");
		SignupPage signupPage = new SignupPage(driver);
		signupPage.signup("karim", "12345", username, password);
		Thread.sleep(3000);


		driver.get(baseURL + "/login");
		Thread.sleep(3000);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username, password);
		Thread.sleep(3000);



		HomePage homePage = new HomePage(driver);

		homePage.openNoteTap();
		Thread.sleep(3000);

		homePage.openNoteModal();
		Thread.sleep(3000);

		homePage.submitNote("hello world","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus enim tortor, porta ut nisl eget, laoreet tempus eros. Vivamus a nisl nec ante accumsan tincidunt. Sed vitae risus malesuada mi lobortis iaculis non quis leo. Etiam eu imperdiet neque, quis cursus nunc. Curabitur");
		Thread.sleep(3000);

		driver.get(baseURL + "/");
		Thread.sleep(3000);


		homePage.openNoteTap();
		Thread.sleep(3000);

	}
}
