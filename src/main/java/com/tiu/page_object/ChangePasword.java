package com.tiu.page_object;
//package com.PageObject.User;

import java.awt.AWTException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;

import com.tiu.all_action_driver.*;
import com.tiu.test_base.TestBase;

public class ChangePasword extends TestBase {
	// public static final Logger log =
	// Logger.getLogger(ChangePasword.class.getName());

	WebDriver driver;
	public Properties OR = new Properties();

	public ChangePasword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// .............Home-page- login............//

	@FindBy(xpath = "//input[@name=\"log\" and @placeholder=\"Username/Email\"]") 
	public static WebElement loginField;

	public void enterLogin() {
		ActionDriver.scrollByVisibiltyOfElement(driver, loginField);
		ActionDriver.click(driver, loginField);
		loginField.sendKeys("vvaidya@tiuconsulting.com");
	}

	@FindBy(xpath = "//input[@name=\"pwd\" and @placeholder=\"Password\"]") 
	public static WebElement passwordField;

	public void enterpwd() {
		ActionDriver.scrollByVisibiltyOfElement(driver, passwordField);
		ActionDriver.click(driver, passwordField);
		passwordField.sendKeys("Tiu@gladden1");
	}

	@FindBy(xpath = "//button[@name=\"wp-submit\" and span[text()=\"Log In\"]]")
	public static WebElement signInButton;

	public void submit() {
		ActionDriver.click(driver, signInButton);
	}

	// ......................................//

	@FindBy(xpath = "//a[@id='pmpro_actionlink-change-password']")
	public WebElement ClickChangePwd;
	
	public void clickChangePassword() {
		ActionDriver.scrollByVisibiltyOfElement(driver, ClickChangePwd);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ClickChangePwd));
		ClickChangePwd.click();
		//ActionDriver.click(driver, ClickChangePwd);
	}

	// ................Window-Pop-up login......................//

	@FindBy(xpath = "//*[@id=\"login-username\"]")
	public static WebElement username;

	public void enterUsername() {
		ActionDriver.click(driver, username);
		username.sendKeys("vvaidya@tiuconsulting.com");
	}

	@FindBy(xpath = "//*[@id=\"login-password\"]")
	public static WebElement loginPassword;

	public void enterpwpasswordd() {
		ActionDriver.click(driver, loginPassword);
		loginPassword.sendKeys("Tiu@gladden1");
	}

	@FindBy(xpath = "//*[@id=\"login-submit\"]")
	public static WebElement loginSubmit;

	public void submitBtn() {
		ActionDriver.click(driver, loginSubmit);
	}

	// ......................................//

	@FindBy(xpath = "//*[@id=\"loginrequred\"]")
	public WebElement findSubmitYourPhotos;

	public void findSubmitYourPhotos() throws InterruptedException {
		ActionDriver.scrollByVisibiltyOfElement(driver, findSubmitYourPhotos);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(findSubmitYourPhotos));
		findSubmitYourPhotos.click();
		Thread.sleep(3000);
	}

	// ..................Change Password....................//

	@FindBy(xpath = "//*[@id='password_current']")
	public WebElement CurrentPwd;

	public void pwdChange() {
		ActionDriver.scrollByVisibiltyOfElement(driver, CurrentPwd);
		// ActionDriver.click(driver, CurrentPwd);
		CurrentPwd.sendKeys("Tiu@gladden1");
	}

	@FindBy(id = "pass1")
	public WebElement NewPwd;

	public void newPwdChange() {
		ActionDriver.scrollByVisibiltyOfElement(driver, NewPwd);
		// ActionDriver.click(driver, NewPwd);
		NewPwd.sendKeys("Tiu@gladden123");
	}

	@FindBy(id = "pass2")
	public WebElement ConfirmPwd;

	public void confPwd() {
		ActionDriver.scrollByVisibiltyOfElement(driver, ConfirmPwd);
		// ActionDriver.click(driver, ConfirmPwd);
		ConfirmPwd.sendKeys("Tiu@gladden123");
	}

	@FindBy(xpath = "//*[@id=\"change-password\"]/div[2]/input[1]")
	public WebElement ChangePasswordBtn;
	//input[@value='Change Password']
	//*[@id="change-password"]/div[2]/input[1]

	public void changePWDButton() {
		ActionDriver.scrollByVisibiltyOfElement(driver, ChangePasswordBtn);
		//ActionDriver.click(driver, ChangePasswordBtn);
		ChangePasswordBtn.click();
	}

	@FindBy(xpath = "//div[@role='alert']")
	public WebElement SuccessMessage;

	public void ConfirmPwd(String string) {
		// TODO Auto-generated method stub

	}
	
	//...................JRGOS multiple/data driven Data..................//
	
	/*
	 * @FindBy(xpath = "//input[@name=\"log\" and @placeholder=\"Username/Email\"]")
	 * WebElement loginField1;
	 * 
	 * @FindBy(xpath = "//input[@name=\"pwd\" and @placeholder=\"Password\"]")
	 * WebElement passwordField1;
	 * 
	 * @FindBy(xpath = "//button[@name=\"wp-submit\" and span[text()=\"Log In\"]]")
	 * WebElement signInButton1;
	 */
	
	@FindBy(xpath = "//input[@name=\"log\" and @type=\"text\"]")
	WebElement loginField1;
	@FindBy(xpath = "//input[@name=\"pwd\" and @placeholder=\"Password\"]")
	WebElement passwordField1;
	@FindBy(xpath = "//button[@name=\"wp-submit\" and .//span[text()=\"Log In\"]]")
	WebElement signInButton1;
	
   // @FindBy(xpath = "//div[@class='pmpro_message pmpro_error']")
    //List<WebElement> incorrectpassword;
    @FindBy(xpath = "//span[@class=\"val_error\"]")
	List<WebElement> incorrectpassword;
	
	public void clientSignInn(String username, String password, String errorpassword) throws InterruptedException {
        waitInSeconds(3);
        loginField1.sendKeys(username);
        wait_in_seconds(5);
        passwordField1.sendKeys(password);
        wait_in_seconds(5);
        //scrollDownToElement(signInButton1);
        //wait_in_seconds(5);
        signInButton1.click();
        wait_in_seconds(5);
        for (WebElement e : incorrectpassword) {
            String errormessage = e.getText();
            System.out.print("The error message is " + errormessage);
            if (errormessage.equals("Unknown email address. Check again or try your username.")) {
                System.out.print("The actual error message for validation is " + errormessage);
                AssertJUnit.assertEquals(errorpassword, errormessage);
                
            }
            if (errormessage.equals("The username field is empty.")) {
                System.out.print("The actual error message for validation is " + errormessage);
                AssertJUnit.assertEquals(errorpassword, errormessage);
                
            }
            if (errormessage.equals("The password field is empty."
                    + "")) {
                System.out.print("The actual error message for validation is " + errormessage);
                AssertJUnit.assertEquals(errorpassword, errormessage);
                
            }
            if (errormessage.equals("Unknown email address. Check again or try your username."
                    + "")) {
                System.out.print("The actual error message for validation is " + errormessage);
                AssertJUnit.assertEquals(errorpassword, errormessage);
                
            }
          
        }}
        
	/*public void clientSignIn(String username, String password) throws InterruptedException {

		waitInSeconds(3);

		try {
			if (loginField.isDisplayed()) {
				loginField.click();
			}
		} catch (NoSuchElementException e) {

		}
		waitInSeconds(3);
		log.info("Clicking on accept button");
		try {
			if (signInButton.isDisplayed()) {
				signInButton.click();
			}
		} catch (NoSuchElementException e) {

		}
		waitInSeconds(3);
		loginField.sendKeys(username);
		passwordField.sendKeys(password);
		wait_in_seconds(5);
		scrollDownToElement(signInButton);
		wait_in_seconds(5);
		signInButton.click();
		wait_in_seconds(5);

		String get_currenturl = driver.getCurrentUrl();
		System.out.println("Current URL is:" + get_currenturl);
		if (get_currenturl.contains("https://dev.kredsafe.net/accept-otp")) {
			System.out.println("The url is  " + get_currenturl);
			accessYopmaiforOTP(username);

		}

	}*/
//.......................Switch to email ...................//
	
	private void accessYopmaiforOTP(String username2) {
		// TODO Auto-generated method stub
		
	}

	@FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    WebElement gnextbtn;
	@FindBy(xpath = "//*[@id=\"identifierId\"]")
    WebElement gmail;
	@FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    WebElement gpwd;
    @SuppressWarnings("resource")
	
	public void accessGmail() throws InterruptedException {
         
	        driver.manage().window().maximize();
	        driver.get("https://gmail.com/");
	        WebElement emailField = driver.findElement(By.xpath("//input[@id='identifierId']"));
	        emailField.sendKeys("vvaidya@tiuconsulting.com");
	        WebElement emailNxtBtn = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
	        emailNxtBtn.click();
	        wait_in_seconds(10);
	        WebElement emailPwd = driver.findElement(By.xpath("//input[@name='Passwd']"));
	        emailPwd.sendKeys("Tiuc@123");
	        WebElement emailnxt = driver.findElement(By.xpath("//span[normalize-space()='Next']"));
	        emailnxt.click();
	        wait_in_seconds(5);
	        driver.get("https://gmail.com/");
	         }
	// ......................................//

	@FindBy(xpath = "//*[@id=\"opensearchbox\"]/i")
	public static WebElement clickSearchIcon;

	public void Search() {
		ActionDriver.click(driver, clickSearchIcon);
	}

	@FindBy(xpath = "//*[@id=\"s\"]")
	public static WebElement textSearch;

	public void TextSrc() {
		ActionDriver.scrollByVisibiltyOfElement(driver, textSearch);
	}

	// ......................................//

	// Fill in required text fields

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_2\"]")
	public static WebElement submitterName1;

	public void FirstName() {
		ActionDriver.click(driver, submitterName1);
		submitterName1.sendKeys("Vrushali");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_2-last\"]")
	public static WebElement submitterName2;

	public void LastName() {
		ActionDriver.click(driver, submitterName2);
		submitterName2.sendKeys("Vaidya");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_73\"]")
	public static WebElement subemail;

	public void EmailPhoto() {
		ActionDriver.click(driver, subemail);
		subemail.sendKeys("vvaidya@tiuconsulting.com");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_92\"]")
	public static WebElement affiliation;

	public void AffilateWithJRGOS() {
		ActionDriver.click(driver, affiliation);
		affiliation.sendKeys("volunteer");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_93\"]")
	public static WebElement photoTitle;

	public void PhotoDescription() {
		ActionDriver.click(driver, photoTitle);
		photoTitle.sendKeys("Photo Title/Description");

	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_98\"]")
	public static WebElement photoLocation;

	public void PhotoLoc() {
		ActionDriver.click(driver, photoLocation);
		photoLocation.sendKeys("Hudson Ohio");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_88-container\"]/div")

	public static WebElement photoUpload;

	public void PhotoUp() {
		// Create a File object pointing to the image
		File uploadFile = new File("C:\\Users\\Admin\\OneDrive\\Pictures\\download (2).jpg");

		// Locate the file input element and upload
		// WebElement fileInput =
		// driver.findElement(By.cssSelector("input[type='file']"));
		// fileInput.sendKeys(uploadFile.getAbsolutePath());

		ActionDriver.click(driver, photoUpload);
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_91\"]")
	public static WebElement caption;

	public void PhotoCaption() {
		ActionDriver.click(driver, caption);
		caption.sendKeys("Caption check");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-3093-field_97_1\"]")
	public static WebElement checkBoxClick;

	public void CheckBox() {
		ActionDriver.click(driver, checkBoxClick);
	}
	// *[@id="wpforms-3093-field_97"]/li/label

	@FindBy(xpath = "//*[@id=\"wpforms-submit-3093\"]")
	public static WebElement photoClickSubmit;

	public void PhotoSubmit() {
		ActionDriver.click(driver, photoClickSubmit);

	}

	// ............................................................//

	// ..........Login window..................//

	@FindBy(xpath = "//*[@id=\"user_login\"]")
	public static WebElement emailLogin;

	public void LoginByEmail() throws InterruptedException {
		ActionDriver.click(driver, emailLogin);
		emailLogin.sendKeys("vvaidya@tiuconsulting.com");
		Thread.sleep(5000);
	}

	@FindBy(xpath = "//*[@id=\"user_pass\"]")
	public static WebElement pwdLogin;

	public void PwdEmail() throws InterruptedException {
		ActionDriver.click(driver, pwdLogin);
		pwdLogin.sendKeys("Tiu@gladden1");
		Thread.sleep(5000);
	}

	@FindBy(xpath = "//*[@id=\"wp-submit\"]")
	public static WebElement submitLogin;

	public void SubmitEmail() {
		ActionDriver.click(driver, submitLogin);
	}

	// ............. Match Video submmition.............//

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_52\"]")
	public static WebElement prefix;

	public void PrefixMatch() {
		ActionDriver.click(driver, prefix);
		prefix.sendKeys("Dr.");
	}
	// driver.findElement(By.name("your-name")).sendKeys("Vrushali Test");
	// driver.findElement(By.name("your-email")).sendKeys("vrushali@example.com");

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_56\"]")
	public static WebElement medSchool;

	public void MedicalSchool() {
		ActionDriver.click(driver, medSchool);
		medSchool.sendKeys("TIU Consulting School");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_1\"]") // *[@id="wpforms-2709-field_1"]
	public static WebElement fName;

	public void VideoFName() {
		ActionDriver.click(driver, fName);
		fName.sendKeys("Vrushhali");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_1-last\"]")
	public static WebElement lName;

	public void VideoLName() {
		ActionDriver.click(driver, lName);
		lName.sendKeys("Vaidya");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_57\"]")
	public static WebElement whereMatch;

	public void VideoMatch() {
		ActionDriver.click(driver, whereMatch);
		whereMatch.sendKeys("Hudson Stadium, Ohio 44235");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_55\"]")
	public static WebElement suffix;

	public void VideoSuffix() {
		ActionDriver.click(driver, suffix);
		suffix.sendKeys("Stadium Match");
	}

	// @FindBy(xpath = "//*[@id=\"wpforms-2709-field_58-container\"]/div/div")
	// @FindBy(xpath =
	// "//div[@id='wpforms-2709-field_60-container']//div[@class='dz-message']")
	// @FindBy(xpath =
	// "//div[@id='wpforms-2709-field_64-container']//span[@class='modern-title'][normalize-space()='Click
	// or drag files to this area to upload.']")
	// @FindBy(xpath =
	// "//div[@id='wpforms-2709-field_65-container']//span[@class='modern-title'][normalize-space()='Click
	// or drag files to this area to upload.']")
	// public static WebElement videoUp;

	public void VideoUpload(String xpath) throws AWTException {

		File video = new File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_01_02-1.webm");
		File video1 = new File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_05_13-1.webm");
		String[] Filepaths = { video.getAbsolutePath(), video1.getAbsolutePath() };

		// Join all file paths with newline separator
		// String allFiles = String.join("\n", Filepaths);
		// List<WebElement> fileInputs =
		// driver.findElements(By.xpath("//input[@type='file']"));

		// Loop through each input and upload the same file
		/*
		 * for (WebElement input : fileInputs) { input.sendKeys(Filepaths); }
		 * 
		 */
		// ActionDriver.click(driver, videoUp);
		// WebElement videoUp =
		// driver.findElement(By.cssSelector("//input[@type='file']"));

		// WebElement videoUp =
		// driver.findElement(By.xpath("(//div[@class='dz-message'])[1]"));
		// WebElement videoUp1 =
		// driver.findElement(By.xpath("(//div[@class='dz-message'])[2]"));
		// WebElement videoUp2 =
		// driver.findElement(By.xpath("(//div[@class='dz-message'])[3]"));
		// WebElement videoUp3 =
		// driver.findElement(By.xpath("(//div[@class='dz-message'])[4]"));
		// WebElement videoAdditional =
		// driver.findElement(By.cssSelector("input[type='file']"));

		// WebElement videouploadProgram =
		// driver.findElement(By.cssSelector("div[id='wpforms-2709-field_65-container']
		// div[class='dz-message']"));

		// *[@id="wpforms-2709-field_58-container"]/div/div/span[1]
		// upload.sendKeys("C:\\Users\\Admin\\Videos\\Icecream Screen
		// Recorder\\Video_2025_01_02-1.webm");
		// videoUp.sendKeys("C:\\Users\\Admin\\Videos\\Icecream Screen
		// Recorder\\Video_2025_01_02-1.webm");

		// ActionDriver.scrollByVisibiltyOfElement(driver, uploadTeamsPhoto);
		// videoUp.sendKeys(allFiles);

		// ActionDriver.uploadMultipleFiles(videoUp1, Filepaths);
		// videoUp.sendKeys(video.getAbsolutePath());
		// videoUp.sendKeys(video1.getAbsolutePath());

//	 		Robot ro = new Robot();
//	        ro.keyPress(KeyEvent.VK_ESCAPE);
//     		ro.keyRelease(KeyEvent.VK_ESCAPE);
		// driver.findElement(By.cssSelector("input[type='submit']")).click();
		// videoUp.sendKeys("Stadium Match");

		// ..................................//

	}

	public void uploadVideoFiles(String xpath) {
		// WebElement videoUpload =
		// driver.findElement(By.cssSelector("input[type='file']#58"));
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("$('.wpforms-uploader.dz-clickable[data-field-id=\"58\"]').css('border',
		// '2px solid blue');");
		WebElement videoUpload = driver
				.findElement(By.cssSelector(".wpforms-uploader.dz-clickable[data-field-id='58']"));

		File video = new File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_01_02-1.webm");

		videoUpload.sendKeys(video.getAbsolutePath());

		/*
		 * File video = new
		 * File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_01_02-1.webm"
		 * ); File video1 = new
		 * File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_05_13-1.webm"
		 * ); String[] Filepaths = { video.getAbsolutePath(),video1.getAbsolutePath() };
		 * WebElement videoUp = driver.findElement(By.xpath("input[type='file']"));
		 * ActionDriver.uploadMultipleFiles(videoUp, Filepaths);
		 */

	}

	// ................Video sub example.....//
	@FindBy(xpath = "(//div[@class='dz-message'])[1]")
	WebElement sub1;
	@FindBy(xpath = "(//div[@class='dz-message'])[2]")
	WebElement sub2;
	@FindBy(xpath = "(//div[@class='dz-message'])[3]")
	WebElement sub3;
	@FindBy(xpath = "(//div[@class='dz-message'])[4]")
	WebElement sub4;

	@FindBy(xpath = "/html/body/div[1]/div/a[1]")
	WebElement login;

	@FindBy(xpath = "//*[@id=\"user_login\"]")
	WebElement user;

	@FindBy(xpath = "//*[@id=\"user_pass\"]")
	WebElement pass;
	@FindBy(xpath = "//*[@id=\"wp-submit\"]")
	WebElement submitg;

	@FindBy(xpath = "//a[@id=\"sm-17512864765323154-15\"]/@href")
	WebElement sg;

	@FindBy(xpath = "(//a[@href='https://www.gladdensociety.org/match-day-video-submission/' and text()='Match Day Video Submission'])[1]")
	WebElement mg;

	public void submissin() throws InterruptedException, AWTException {
		//wait_for_page_load(5);
		// wait_for_element_present(login);

		click_Element_Using_JS(login);
		user.sendKeys("vvaidya@tiuconsulting.com");
		pass.sendKeys("Tiu@gladden1");
		click_Element_Using_JS(submitg);
		waitInSeconds(10);
		// sg.click();
		// click_Element_Using_JS(sg);
		//wait_in_seconds(20);
		click_Element_Using_JS(mg);
		wait_in_seconds(5);

		// sub.click();
		click_Element_Using_JS(sub1);
		wait_in_seconds(10);
		// profilepicture.click();
		// wait_in_seconds(10);
		Actions act = new Actions(driver);
		WebElement upload = driver.findElement(By.xpath("(//div[@class='dz-message'])[1]"));
		// WebElement upload = driver.findElement(By.xpath("//i[@class='fa
		// fa-camera']"));
		act.moveToElement(upload).click().perform();
		// For Negative testing change the upload file path and file types.
		// file_upload("\"D:\\VRUSHALI\\Office\\Videos_Icecream\\Video_2025_04_16-1.webm\"");
		file_upload("\"D:\\VRUSHALI\\Office\\Videos_Icecream\\Screenshot_2025_06_17-2.png\"");
		wait_in_seconds(5);

		click_Element_Using_JS(sub2);
		wait_in_seconds(10);
		// profilepicture.click();
		wait_in_seconds(10);
		Actions act1 = new Actions(driver);
		WebElement upload1 = driver.findElement(By.xpath("(//div[@class='dz-message'])[2]"));
		// WebElement upload = driver.findElement(By.xpath("//i[@class='fa
		// fa-camera']"));
		act1.moveToElement(upload1).click().perform();
		// For Negative testing change the upload file path and file types.
		file_upload("\"D:\\VRUSHALI\\Office\\Videos_Icecream\\Screenshot_2025_06_06-1.png\"");
		wait_in_seconds(5);

		click_Element_Using_JS(sub3);
		wait_in_seconds(10);
		Actions act2 = new Actions(driver);
		WebElement upload2 = driver.findElement(By.xpath("(//div[@class='dz-message'])[3]"));
		// WebElement upload = driver.findElement(By.xpath("//i[@class='fa
		// fa-camera']"));
		act2.moveToElement(upload2).click().perform();
		// For Negative testing change the upload file path and file types.
		file_upload("\"C:\\Users\\Admin\\OneDrive\\Desktop\\download (1).jpg\"");
		wait_in_seconds(5);

		click_Element_Using_JS(sub4);
		wait_in_seconds(10);
		Actions act3 = new Actions(driver);
		WebElement upload3 = driver.findElement(By.xpath("(//div[@class='dz-message'])[4]"));
		act3.moveToElement(upload3).click().perform();
		file_upload("D:\\VRUSHALI\\Office\\Videos_Icecream\\Screenshot_2025_06_06-2.png");
		wait_in_seconds(5);

	}

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_2\"]")
	public static WebElement vEmail;

	public void VideoEmail() {
		ActionDriver.click(driver, vEmail);
		vEmail.sendKeys("vvaidya@tiuconsulting.com");
	}

	// @FindBy(xpath = "//*[@id=\"wpforms-2709-field_43_1\"]")
	@FindBy(xpath = "//input[@type='radio' and @value='Yes']")
	public static WebElement radioSel;

	// Example: Select radio button (e.g., "Yes" for permission)
	public void VideoRedioSelection() {

		// if (!radioYes.isSelected()) { radioYes.click(); }

		ActionDriver.click(driver, radioSel);
		radioSel.sendKeys("vvaidya@tiuconsulting.com");

		WebElement radioYes = driver.findElement(By.xpath("//input[@type='radio' and @value='Yes']"));

	}

	// ...........................................................//

	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/span[1]")

	public static WebElement uploadTeamsPhoto;

	public void clickOnUploadTeamsPhotos(String[] filePath) {
		ActionDriver.scrollByVisibiltyOfElement(driver, uploadTeamsPhoto);
		ActionDriver.uploadMultipleFiles(uploadTeamsPhoto, filePath);
	}

	// .............Facebook..............//

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_61\"]")
	public static WebElement fbVideo;

	public void VideoFacebook() {
		ActionDriver.click(driver, fbVideo);
		fbVideo.sendKeys("Facebook Handle");
	}

	// ............Instagram......................//

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_63\"]")
	public static WebElement instaVideo;

	public void VideoInstagram() {
		ActionDriver.click(driver, instaVideo);
		instaVideo.sendKeys("Insta Handle");
	}

	// ..................Youtube video...........//

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_67\"]")
	public static WebElement youtubeVideo;

	public void VideoYoutube() {
		ActionDriver.click(driver, youtubeVideo);
		youtubeVideo.sendKeys("https://www.gladdensociety.org/");
	}

	// ...................X Handle............//

	@FindBy(xpath = "//*[@id=\"wpforms-2709-field_62\"]")
	public static WebElement xVideo;

	public void VideoX() {
		ActionDriver.click(driver, xVideo);
		xVideo.sendKeys("X Handle");
	}

	// ................Submit...............//

	@FindBy(xpath = "//*[@id=\"wpforms-submit-2709\"]")
	public static WebElement submitVideo;

	public void VideoSubmit() {
		ActionDriver.click(driver, submitVideo);
	}

	// ................Rss Form....................//

	@FindBy(xpath = "//*[@id=\"wpforms-2948-field_2\"]")
	public static WebElement fieldName1;

	public void RSSFName() {
		ActionDriver.click(driver, fieldName1);
		fieldName1.sendKeys("Vrushali");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2948-field_2-last\"]")
	public static WebElement fieldName2;

	public void RSSLName() {
		ActionDriver.click(driver, fieldName2);
		fieldName2.sendKeys("Vaidya");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2948-field_73\"]")
	public static WebElement fieldEmail;

	public void RSSEmail() {
		ActionDriver.click(driver, fieldEmail);
		fieldEmail.sendKeys("vvaidya@tiuconsulting.com");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2948-field_80\"]")
	public static WebElement programName;

	public void RSSProgramName() {
		ActionDriver.click(driver, programName);
		programName.sendKeys("Test Program from TIU Consulting");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2948-field_86\"]")
	public static WebElement describeBriefly;

	public void RSSBrief() {
		ActionDriver.click(driver, describeBriefly);
		describeBriefly.sendKeys(
				"Briefly describe the concern(s) that brings you to the Resident Support & Success Committee ");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-2948-field_87\"]")
	public static WebElement addressUrConcern;

	public void RSSConcerns() {
		ActionDriver.click(driver, addressUrConcern);
		addressUrConcern.sendKeys("Step 1,2,3,..... ");
	}

	@FindBy(xpath = "//*[@id=\"wpforms-submit-2948\"]")
	public static WebElement rssbtnSubmit;

	public void RSSSubmit() {
		ActionDriver.click(driver, rssbtnSubmit);
	}

	// Seperate xpath not requried in single upload functionality
	@FindBy(xpath = "//div[@class='dz-message']")
	WebElement sub;

	public void rssVideoUpload() throws InterruptedException, AWTException {
		// wait_for_page_load(5);
		// sub.click();
		// click_Element_Using_JS(sub);
		wait_in_seconds(10);
		// profilepicture.click();
		// wait_in_seconds(10);
		Actions act = new Actions(driver);
		// Provided xpath here only
		WebElement upload = driver.findElement(By.xpath("//div[@class='dz-message']"));
		act.moveToElement(upload).click().perform();
		// file_upload("\"D:\\VRUSHALI\\Office\\Videos_Icecream\\Video_2025_04_16-1.webm\"");
		file_upload("\"D:\\VRUSHALI\\Office\\Videos_Icecream\\Screenshot_2025_06_17-2.png\"");
		wait_in_seconds(5);

	}

	/*
	 * public void rssVideoFiles(String xpath) throws InterruptedException {
	 * 
	 * File video = new
	 * File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_01_02-1.webm"
	 * ); File video1 = new
	 * File("C:\\\\Users\\\\Admin\\\\Videos\\\\Icecream Screen Recorder\\\\Video_2025_05_13-1.webm"
	 * ); String[] Filepaths = { video.getAbsolutePath(),video1.getAbsolutePath() };
	 * WebElement videoUp =
	 * driver.findElement(By.xpath("//div[@class='dz-message']"));
	 * wait_in_seconds(10); //div[@class='dz-message'] }
	 */

	public void rssPGYDropdown() {
		// PGY Level (Dropdown)
		Select pgyDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"wpforms-2948-field_84\"]")));
		pgyDropdown.selectByVisibleText("PGY2");

	}

	@FindBy(xpath = "//input[@type='radio' and @value='Yes']")
	public static WebElement rssradioSel;

	public void rssRadioBtn() {

		// Membership Radio Button
		ActionDriver.click(driver, rssradioSel);
		WebElement memberYes = driver.findElement(By.xpath("//*[@id=\"wpforms-2948-field_75_1\"]"));
		// *[@id="wpforms-2948-field_75_1"]
		if (!memberYes.isSelected())
			memberYes.click();
	}

	// .............Social Media Submission............//

	@FindBy(xpath = "//input[@id='wpforms-2741-field_2']")//input[@id='wpforms-2741-field_2']

	WebElement socialFName;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_2-last']")
	WebElement socialLName;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_52']")
	WebElement socialOrgName;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_66']")
	WebElement socialOrgWebsite;

	@FindBy(xpath = "//textarea[@id='wpforms-2741-field_72']")
	WebElement socialOrgInfo;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_67']")
	WebElement socialInsta;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_69']")
	WebElement socialFB;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_68']")
	WebElement socialXHandle;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_53']")
	WebElement socialMember;

	@FindBy(xpath = "//input[@id='wpforms-2741-field_70']")
	WebElement socialMedia;

	@FindBy(xpath = "//button[@id='wpforms-submit-2741']")
	WebElement socialSubmit;

	// @FindBy(xpath = "/html/body/div[1]/div/a[1]") WebElement login;

	// @FindBy(xpath = "//*[@id=\"user_login\"]") WebElement user;

	// @FindBy(xpath = "//*[@id=\"user_pass\"]") WebElement pass;

	// @FindBy(xpath = "//*[@id=\"wp-submit\"]") WebElement submitg;

	@FindBy(xpath = "(//ul[@id='sm-17514606233675134-16']//a[@class='elementor-sub-item'][normalize-space()='Social Media Submission'] and text()='Social Media Submission'])[3]")
	WebElement sm;

	public void socialMediaSb() throws InterruptedException, AWTException {
		wait_for_page_load(5);

		//wait_in_seconds(5);
		socialFName.click();
		socialFName.sendKeys("Vrushali");
		socialLName.sendKeys("Vaidya");
		socialOrgName.sendKeys("TIU Consulting");
		socialOrgWebsite.sendKeys("https://www.gladdensociety.org/jrgos-content-application/");
		socialOrgInfo.sendKeys("any information that you would like distributed");
		socialInsta.sendKeys("Instagram");
		socialFB.sendKeys("Facebook");
		socialXHandle.sendKeys("X handle");
		socialMember.sendKeys("socialMember");
		socialMedia.sendKeys("Media");

		wait_in_seconds(10);

		Actions act = new Actions(driver);
		// Provided xpath here only
		WebElement upload = driver.findElement(By.xpath("//div[@class='dz-message']"));

		act.moveToElement(upload).click().perform();

		file_upload("\"C:\\Users\\Admin\\OneDrive\\Pictures\\download.jpg\"");
		wait_in_seconds(5);
		// socialSubmit.click();

	}

	/*
	 * public void negativeSocialMediaSb() throws InterruptedException {
	 * 
	 * //scrollDownToElement(socialSubmit); wait_in_seconds(10);
	 * //click_Element_Using_JS(socialSubmit); socialSubmit.click(); }
	 */

	/*
	 * @FindBy(xpath = "//a[text()=\"Submit Your Social Media Content\"]")
	 * WebElement ssm;
	 */

	@FindBy(xpath = "//button[@id=\"wpforms-submit-2741\" and @type=\"submit\" and text()=\"Submit\"]")
	WebElement ssmsubmit;

	public void ssm() throws InterruptedException, AWTException {
		wait_for_page_load(5);
		click_Element_Using_JS(ssmsubmit);
	}

	// .............Case Corner Submission............//

	// 📧 Entering Email
	@FindBy(id = "wpforms-2739-field_2")
	WebElement caseFName;

	@FindBy(id = "wpforms-2739-field_2-last")
	WebElement caseLName;

	@FindBy(id = "wpforms-2739-field_6")
	WebElement caseEmail;

	@FindBy(id = "wpforms-2739-field_7")
	WebElement casePhone;

	@FindBy(id = "wpforms-2739-field_52")
	WebElement caseProcedure;

	@FindBy(id = "wpforms-2739-field_72")
	WebElement case2ndFName;

	@FindBy(id = "wpforms-2739-field_72-last")
	WebElement case2ndLName;

	@FindBy(id = "wpforms-2739-field_83")
	WebElement case2ndEmail;

	@FindBy(id = "wpforms-2739-field_73")
	WebElement case3rdFName;

	@FindBy(id = "wpforms-2739-field_73-last")
	WebElement case3rdLName;

	@FindBy(id = "wpforms-2739-field_85")
	WebElement case3rdEmail;

	@FindBy(id = "wpforms-2739-field_64")
	WebElement caseDiagnosis;

	@FindBy(id = "wpforms-2739-field_65")
	WebElement casePresentation;

	@FindBy(xpath = "//input[@name='wpforms[fields][93_633]']")
	WebElement casePreopImg;

	@FindBy(id = "wpforms-2739-field_97-1741")
	WebElement caseIntraOp;

	@FindBy(id = "wpforms-2739-field_102-2514")
	WebElement casePostOp;

	@FindBy(id = "wpforms-2739-field_103")
	WebElement casePostOpPlan;

	@FindBy(id = "wpforms-2739-field_104")
	WebElement caseClassification;

	@FindBy(id = "wpforms-2739-field_68")
	WebElement casePearls;

	// @FindBy(id="wpforms-submit-2739")
	@FindBy(xpath = "//button[@id='wpforms-submit-2739']")

	WebElement caseSubmit;

	// input[@id='wpforms-2739-field_93-8487']

	public void caseCornerSub() throws InterruptedException, AWTException {
		// wait_for_page_load(5);
		caseFName.click();
		caseFName.sendKeys("Vrushali TIU ");
		caseLName.click();
		caseLName.sendKeys("Test");
		caseEmail.sendKeys("vvaidya@tiuconsulting.com");
		casePhone.sendKeys("2021252321");
		caseProcedure
				.sendKeys("I plan to visit a leading center to observe advanced orthopedic techniques and procedure.");
		case2ndFName.sendKeys("TIU Test");
		case2ndLName.sendKeys("Account");
		case3rdFName.sendKeys("Test");
		case3rdLName.sendKeys("TIU");
		case3rdEmail.sendKeys("vvaidya@tiuconsulting.com");
		case2ndEmail.sendKeys("vrushaalivaidya@gmail.com");
		caseDiagnosis.sendKeys("NA");
		casePresentation.sendKeys("Case Presentation");
		// casePreopImg.click();
		scrollDownToElement(casePreopImg);
		casePreopImg.sendKeys("Preop Image Caption test TIU");
		caseIntraOp.sendKeys("IntraOp Image Caption/");
		casePostOp.sendKeys("PostOp Image Caption");
		casePostOpPlan.sendKeys("PostOp Plan");
		caseClassification.sendKeys("Classification System Text");
		casePearls.sendKeys("Pearls/Hot Tips");
		// caseSubmit.click();

	}

	// ................................................................................//

	@FindBy(xpath = "//input[@name='wpforms[fields][102_3414]']")

	WebElement pic;

	@FindBy(xpath = "//*[@id=\"wpforms-2739-field_91-container\"]/div/div[1]/div/div[1]/div/div[2]/ul/li[1]/i")

	WebElement pictek;
	// *[@id="wpforms-2739-field_91-container"]/div/div[1]/div/div[1]/div/div[2]/ul/li[1]/i
	@FindBy(xpath = "//a[@href=\"https://www.gladdensociety.org/jrgos-case-corner-submission/\" and text()=\"JRGOS Case Corner Submission\"]")
	WebElement cms;

	// input[@id='wpforms-2739-field_93-633']

	@FindBy(xpath = "(//a[normalize-space(text()[1])='Content Submission']/@href)[1]")
	WebElement cs;

	@FindBy(xpath = "//*[@id=\"gray-belowbanner\"]/div/div/div[2]/div[8]/div/a")
	WebElement cst;

	/*
	 * @FindBy(xpath = "//*[@id=\"wpforms-submit-2739\"]") WebElement finalS;
	 */

	@FindBy(xpath = "//*[@id=\"wpforms-2739-field_64\"]")
	WebElement Diagnosis;

	@FindBy(xpath = "//*[@id=\"wpforms-2739-field_68\"]")
	WebElement perl;

	public void negativecasecorner() throws InterruptedException, AWTException {
		// wait_for_page_load(5);
		// wait_for_element_present(login);
		/*
		 * click_Element_Using_JS(login); wait_for_element_present(user);
		 * user.sendKeys("vvaidya@tiuconsulting.com"); pass.sendKeys("Tiu@gladden1");
		 * click_Element_Using_JS(submitg);
		 */
		// waitInSeconds(10);
		// click_Element_Using_JS(cs);

		// click_Element_Using_JS(cms);
		// wait_in_seconds(10);
		// scrollDownToElement(cst);
		// click_Element_Using_JS(cst);
		// driver.get("https://www.gladdensociety.org/jrgos-case-corner-submission-application/");
		// wait_for_page_load(10);
		Diagnosis.sendKeys("Tiu@gladden1");
		// pic.sendKeys("Tiu@gladden1");
		perl.sendKeys("Tiu@gladden1");
		// scrollDownToElement(caseSubmit);
		wait_in_seconds(5);
		click_Element_Using_JS(caseSubmit);

		// caseSubmit.click();

		/*
		 * //WebElement submitBtn = driver.findElement(By.id("wpforms-submit-2739")); //
		 * // submitBtn.click(); wait_for_element_present(ChangePasswordBtn);
		 * scrollDownToElement(ChangePasswordBtn); caseSubmit.click();
		 * 
		 * 
		 * WebElement errorMsg =
		 * driver.findElement(By.id("wpforms-2739-field_6-error")); // Adjust locator
		 * assert errorMsg.isDisplayed();
		 */
	}

	public void orgDropdown() {
		// Organization (Dropdown) - 1st
		Select orgDropdown = new Select(driver.findElement(By.xpath("//select[@id='wpforms-2739-field_81']")));
		orgDropdown.selectByVisibleText("Institution");

	}

	public void caseDropdown() {
		// Membership (Dropdown)- 1st
		Select caseDropdown = new Select(driver.findElement(By.xpath("//*[@id=\"wpforms-2739-field_82\"]")));
		caseDropdown.selectByVisibleText("Fellow Membership");

	}
	// ..................//

	public void org2ndDropdown() {
		// Organization (Dropdown) - 2nd
		Select orgDropdown = new Select(driver.findElement(By.xpath("//select[@id='wpforms-2739-field_84']")));
		orgDropdown.selectByVisibleText("Medical School");

	}

	public void org3rdDropdown() {
		// Organization (Dropdown) - 3rd
		Select orgDropdown = new Select(
				driver.findElement(By.xpath("//div[@id='wpforms-2739-field_87-container']//div[@class='dz-message']")));
		orgDropdown.selectByVisibleText("Program");

	}

	// 📎 Uploading Case File
	// WebElement fileUpload =
	// driver.findElement(By.xpath("//*[@id=\"wpforms-2739-field_87-container\"]/div[1]/div"));
	// fileUpload.sendKeys("\"C:\\Users\\Admin\\OneDrive\\Desktop\\Invoice-20250416-072753.pdf\"");
	// // Ensure valid path on your system

	// 🔘 Consent Checkbox
	/**/

	// ✅ Submit Form
	// driver.findElement(By.cssSelector("form button[type='submit']")).click();

//...................................TC018_FellowshipGrantFormTest.........................................//

	@FindBy(id = "wpforms-3589-field_2")
	WebElement grantFName;

	@FindBy(id = "wpforms-3589-field_2-middle")
	WebElement grantMName;

	@FindBy(id = "wpforms-3589-field_2-last")
	WebElement grantLName;

	@FindBy(id = "wpforms-3589-field_6")
	WebElement grantEmail;

	@FindBy(id = "wpforms-3589-field_67")
	WebElement grantAmt;

	@FindBy(id = "wpforms-3589-field_68")
	WebElement grantBudget;

	@FindBy(id = "wpforms-3589-field_52")
	WebElement grantInstitute;

	@FindBy(id = "wpforms-3589-field_64")
	WebElement grantDescribe;

	@FindBy(id = "wpforms-3589-field_7")
	WebElement grantPhone;

	@FindBy(id = "wpforms-3589-field_53")
	WebElement grantMember;

	@FindBy(id = "wpforms-3589-field_65")
	WebElement grantCareer;

	@FindBy(id = "wpforms-submit-3589")
	WebElement grantSubmit;

	// @FindBy(xpath ="//div[@class='dz-message']")
	// @FindBy(xpath ="//div[@class='dz-message'])[1]")

	// WebElement grantUpload;

	public void GrantUploads() throws InterruptedException, AWTException {
		grantFName.sendKeys("Vrushali");
		grantMName.sendKeys("TIU");
		grantLName.sendKeys("Vaidya");
		grantEmail.sendKeys("vvaidya@tiuconsulting.com");
		grantAmt.sendKeys("5000");
		grantBudget.sendKeys("Approx");
		grantInstitute.sendKeys("TIU Institute");
		grantDescribe.sendKeys("Describe");
		grantPhone.sendKeys("212121212020");
		grantMember.sendKeys("5 members");
		grantCareer.sendKeys("Career");
		// grantSubmit.click();
		// click_Element_Using_JS(grantUpload);
		wait_in_seconds(10);
		Actions act = new Actions(driver);
		// Upload CV (ensure the file path is correct)
		WebElement EleUpload = driver.findElement(By.xpath("//div[@class='dz-message']"));
		act.moveToElement(EleUpload).click().perform();
		// EleUpload.sendKeys("\"C:\\Users\\Admin\\OneDrive\\Desktop\\Invoice-20250416-072753.pdf\"");
		file_upload("C:\\Users\\Admin\\OneDrive\\Desktop\\Invoice-20250416-072753.pdf\\");
		wait_in_seconds(5);

		/*
		 * //Sample Code// click_Element_Using_JS(sub1); wait_in_seconds(10);
		 * //profilepicture.click(); wait_in_seconds(10); Actions act = new
		 * Actions(driver); WebElement upload =
		 * driver.findElement(By.xpath("(//div[@class='dz-message'])[1]")); //WebElement
		 * upload = driver.findElement(By.xpath("//i[@class='fa fa-camera']"));
		 * act.moveToElement(upload).click().perform(); //For Negative testing change
		 * the upload file path and file types.
		 * file_upload("C:\\Users\\Admin\\Desktop\\Tesst Data\\surecafetest.jpg");
		 */
	}

//....................................Reimbursement Form Application..................................................//
	@FindBy(xpath = "//input[@id='wpforms-2740-field_2']")
	WebElement reimbursFName;

	@FindBy(xpath = "//input[@id='wpforms-2740-field_2-last']")
	WebElement reimbursLName;

	@FindBy(xpath = "//input[@id='wpforms-2740-field_6']")
	WebElement reimbursEmail;

	@FindBy(xpath = "//input[@id='wpforms-2740-field_7']")
	WebElement reimbursCell;

	@FindBy(xpath = "//select[@id='wpforms-2740-field_80']")
	WebElement reimbursMemTypeDropDwn;

	@FindBy(xpath = "//label[@for='wpforms-2740-field_79_1']")
	WebElement reimbursProgramRadioBtn;

	@FindBy(xpath = "//div[@id='wpforms-2740-field_72-container']//div[@class='dz-message']")
	WebElement reimbursW9Upload;

	@FindBy(xpath = "//div[@id='wpforms-2740-field_73-container']//div[@class='dz-message']")
	WebElement reimbursReceiptsUpload;

	@FindBy(xpath = "//button[@id='wpforms-submit-2740']")
	WebElement reimbursSubmit;

	public void fillReimbursementForm() {
		wait_for_page_load(5);
		reimbursFName.sendKeys("Vrushali");
		reimbursLName.sendKeys("Vaidya");
		reimbursEmail.sendKeys("vvaidya@tiuconsulting.com");

		// Example: Select Category (if dropdown)
		Select categorySelect = new Select(driver.findElement(By.xpath("//select[@id='wpforms-2740-field_80']")));
		categorySelect.selectByVisibleText("Resident Membership");

		// Example: Upload a file (if available)
		WebElement upload = driver
				.findElement(By.xpath("//div[@id='wpforms-2740-field_72-container']//div[@class='dz-message']"));
		upload.sendKeys("C:\\Users\\Admin\\OneDrive\\Desktop\\Invoice-20250416-072753.pdf\\");

		// Example: Upload a file (if available)
		WebElement upload1 = driver
				.findElement(By.xpath("//div[@id='wpforms-2740-field_72-container']//div[@class='dz-message']"));
		upload1.sendKeys("\"C:\\Users\\Admin\\Downloads\\Sample Img.png\"");

		// Example: Submit the form
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}

}