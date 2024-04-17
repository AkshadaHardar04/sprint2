    package PageFactory;
    
    import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
    import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
    import java.time.Duration;
    import java.util.Set;
    import org.apache.poi.ss.usermodel.Sheet;
    import org.apache.poi.ss.usermodel.Workbook;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.interactions.Actions;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
    
    public class PaintsAndColourPageFac {	
	private WebDriver driver;
	private WebElement image;
	Actions act;
	Robot r;
	Workbook w;
	Sheet s;
	JavascriptExecutor js;
	WebDriverWait wait;
	
//-------------------------------XPATH FOR LOCATING THE ELEMENTS-----------------------------------//
	
	@FindBy(xpath="//li[@class=\"nav-item\"][1]/a[2]/span")
	WebElement paintsAndColours;
	
	@FindBy(xpath="//a[text()=\"Colour Catalogue\"]")
	WebElement ColourCatalogue;
	
	@FindBy(xpath="//a[@href=\"https://www.asianpaints.com/catalogue/colour-catalogue/grey-wall-colours.html\"]")
	WebElement GreyButton;
	
	@FindBy(xpath="//div[@style=\"background-color: #E3E3DC\"]")
	WebElement WhiteGold ;
	
	@FindBy(xpath="(//a[@href=\"https://www.asianpaints.com/catalogue/colour-catalogue/grey-wall-colours/white-gold.html\"])[1]")
	WebElement KnowMore;
	
	@FindBy(id="checkPincode")
	WebElement pincode;
	
	@FindBy(id="add-to-cart-click")
	WebElement Cart;
	
	@FindBy(xpath="//p[@class=\"continueshoppinglink\"]")
	WebElement text;
	
	@FindBy(xpath="//a[@href=\"https://www.asianpaints.com/catalogue/royale-play-textures.html\"]")
	WebElement InteriorTexture ;
	
	@FindBy(xpath="//a[@href=\"https://www.asianpaints.com/catalogue/interior-textures.html?f=product%3Aroyale%2520play%2520stucco%2520mirror%2Croyale%2520play%2520calcecruda%2Croyale%2520play%2520archi%2520concrete%2Croyale%2520play%2520fuso\"]")
	WebElement ViewTextures;
	
	@FindBy(xpath="//span[text()=\"Living Room\"]")
	WebElement Roomtype;
	
	@FindBy(xpath="//div[text()=\"Kitchen\"]")
	WebElement kitchen;
	
	@FindBy(id="cityTextbox")
	WebElement City;
	
	@FindBy(id="locatebtn")
	WebElement Locator;
	
	@FindBy(xpath="(//p[text()=\"City:Mumbai\"])[1]")
	WebElement CityName;
	
	@FindBy(xpath="//a[text()=\"Paint Budget Calculator\"]")
	WebElement PaintBudgetCalculator;
	
	@FindBy(id="fresh-painting")
	WebElement FreshPainting;
	
	@FindBy(id="interior")
	WebElement Interior;
	
	@FindBy(id="area")
	WebElement Area;
	
	@FindBy(id="calculate-now")
	WebElement CalculateButton;
	
	@FindBy(name="ENQUIRE_NAME")
	WebElement Name;
	
	@FindBy(name="ENQUIRE_EMAIL")
	WebElement Email;
	
	@FindBy(id="enquire-mobile")
	WebElement Mobile;
	
	@FindBy(name="ENQUIRE_PINCODE")
	WebElement Pincode;
	
	@FindBy(xpath="(//button[@data-current-step=\"1\"])[1]")
	WebElement GetAnEstimate;
	
	@FindBy(xpath="//a[text()=\"Exterior Textures\"]")
	WebElement ExteriorTexture;
	
	@FindBy(xpath="//div[text()=\"Phone number is invalid\"]")
	WebElement error;
	
	@FindBy(xpath="//span[text()=\"purples & pinks\"]")
	WebElement pinks;
	
	@FindBy(xpath="//h3[text()=\"Createx Scratch Finish Ocean Pattern\"]")
	WebElement verify;
	
//----METHODS FOR NAVIGATING TO ASIAN PAINTS HOMEPAGE AND HOVER ON PAINTS AND COLOUR----------------//
	
	//THIS METHOD IS USED TO OPEN BROWSER
	public PaintsAndColourPageFac(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//THIS METHOD USED TO HOVER ON PAINTS AND COLOURS
	public void hover()
	{
		act=new Actions(driver);
		act.moveToElement(paintsAndColours).build().perform();	
	}
	
//----------------SCENARIO1(METHODS FOR ADD COLOR SHADES IN CART)-----------------------------------//
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void click()
	{
		ColourCatalogue.click();
	}
	
	//THIS METHOD IS USED TO SCROLL DOWN THE PAGE
	public void scrollDownToGreyButton()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,800)");
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickGreyButton()
	{
		GreyButton.click();
	}
	
	//THIS METHOD IS USED TO SCROLL DOWN THE PAGE
	public void scrollDownToWhiteGold() throws AWTException
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,700)");

	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickWhiteGold() throws AWTException
	{
		WhiteGold.click();
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickKnowMore()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", KnowMore);
	}
	
	//THIS METHOD USED FOR FETCH THE VALUE FROM EXCEL SHEET
	public void enterPincode() throws IOException
	{
		File file = new File ("C:\\Users\\ASHANKAR\\OneDrive\\HiddenWord\\.metadata\\PaintsAndColours\\src\\test\\resource\\Features\\Excel Data\\pincode.xlsx");
		FileInputStream fis = new FileInputStream(file);
		w = new XSSFWorkbook(fis);
		s = w.getSheetAt(0);
		double pincodeValue = s.getRow(0).getCell(0).getNumericCellValue();
		String pincodeString= String.valueOf((int) pincodeValue);
		pincode.sendKeys(pincodeString);	 
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickButton() 
	{
		Cart.click();	
	}
	
	//THIS METHOD IS USED TO GET TEXT
	public String text1()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,700)");
		String msg = text.getText();
		System.out.println(text);
		return msg;	
	}
	
//----------SCENARIO2(METHODS FOR FILTERS TEXTURES BY SELECTING LIVING ROOM OPTION)-----------------//

	//THIS METHOD IS USED TO CLICK BUTTON
	public void click1()
	{
		InteriorTexture.click();
	}
	
	//THIS METHOD IS USED TO SCROLL DOWN THE PAGE
	public void scrollDownToViewTexture()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,600)");
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickViewTexture() throws AWTException
	{
		r = new Robot();
		r.delay(1000);
		ViewTextures.click();
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickRoomType()
	{
		Roomtype.click();
	}

//--------------SCENARIO3(METHODS FOR LOCATING STORES IN THE SPECIFIED CITY)-----------------------//
	
	//THIS METHOD IS USED TO SCROLL DOWN THE PAGE
	public void scrollDownKitchen()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,5000)");
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON AND WINDOW HANDLE
	public void clickKitchen()
	{
		kitchen.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String parentWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	//THIS METHOD IS USED TO SCROLL DOWN THE PAGE
	public void scrollDownToLocator() 
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,4000)");	
	}
	
    //THIS METHOD USED TO SEND THE NAME
	public void enterCity(String name)
	{
		City.sendKeys(name);	
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickOnLocator()
	{
		Locator.click();	
	}
	
	//THIS METHOD IS USED TO GET TEXT
	public String city1() {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,4500)");
		String msg = CityName.getText();
		System.out.println(CityName);
		return msg;
	}
	
//------SCENARIO4(METHODS FOR NAVIGATING TO EXPERT RECOMMENDATION PAGE WITH VALID CREDENTIALS)------//

	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickPaintBudgetCalculator()
	{
		PaintBudgetCalculator.click();
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickFreshPainting()
	{
		FreshPainting.click();
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickInterior()
	{
		Interior.click();
	}
	
	//THIS METHOD USED TO SEND THE VALUE
	public void enterArea(String value)
	{
		Area.sendKeys(value);
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickCalculateButton()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,200)");
		CalculateButton.click();
	}
	
	//THIS METHOD USED TO SEND THE VALUE
	public void enterValue1(String uname,String email,String mobile,String pincode)
	{
		Name.sendKeys(uname);
		Email.sendKeys(email);
		Mobile.sendKeys(mobile);
		Pincode.sendKeys(pincode);
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickGetInstantButton()
	{
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,300)");
		GetAnEstimate.click();
	}	

//------SCENARIO5(METHODS FOR NAVIGATING TO EXPERT RECOMMENDATION PAGE WITH INVALID CREDENTIALS)---//

	//THIS METHOD IS USED TO GET TEXT
	public String errorMessage()
	{
		String msg= error.getText();
		return msg;
	}
	
//------SCENARIO6(METHODS FOR VERIFY PURPLE AND PINKS COLOUR TEXTURE)------------------------------//

	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickExteriorTexture()
	{
		ExteriorTexture.click();
	}
	
	//THIS METHOD IS USED TO CLICK BUTTON
	public void clickPinks()
	{
		pinks.click();
	}
	
	//THIS METHOD IS USED TO GET TEXT
	public String check()
	{
		String colourName = verify.getText();
		System.out.println(verify);
		return colourName;
	}	
    }
