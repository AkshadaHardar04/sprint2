    package StepDefination;
    
    import java.awt.AWTException;
    import java.io.IOException;
    import java.util.List;
    import org.openqa.selenium.OutputType;
    import org.openqa.selenium.TakesScreenshot;
    import org.openqa.selenium.WebDriver;
    import org.testng.Assert;
    import DriverSetup.SetupDriver;
    import PageFactory.PaintsAndColourPageFac;
    import io.cucumber.datatable.DataTable;
    import io.cucumber.java.AfterStep;
    import io.cucumber.java.Scenario;
    //import io.cucumber.java.Scenario;
    import io.cucumber.java.en.And;
    import io.cucumber.java.en.Given;
    import io.cucumber.java.en.Then;
    import io.cucumber.java.en.When;
    
    
    
    public class StepDefinationPnc {
    
    	static WebDriver driver;
    	PaintsAndColourPageFac pf;
    
//----------------------------------SCENARIO-1------------------------------------------------------//
	
	@Given("user is on the homepage of Asian Paints website and hover over the Paints and Colors menu")
	public void user_is_on_the_homepage_of_asian_paints_website_and_hover_over_the_paints_and_colors_menu() {
		driver=SetupDriver.chromedriver();
		pf=new PaintsAndColourPageFac(driver);
	    pf.hover();
	}

	@When("click on the Colour Catalogue option")
	public void click_on_the_colour_catalogue_option(){
	    pf.click();
	}

	@And("scroll down the page to locate Grey button")
	public void scroll_down_the_page_to_locate_grey_button() {
	   pf.scrollDownToGreyButton();
	}

	@And("click on the Grey button")
	public void click_on_the_grey_button() {
	    pf.clickGreyButton();
	}

	@And("scroll down the page to view Grey colours")
	public void scroll_down_the_page_to_view_grey_colours() throws AWTException{
	    pf.scrollDownToWhiteGold();
	}

	@And("click on the White Gold shade")
	public void user_should_see_shades_of_grey_colours() throws AWTException {
		
		pf.clickWhiteGold();
	}
	
	@And("click on the Know More button")
	public void click_on_the_know_more_button(){
	    pf.clickKnowMore();
	}
	
	@When("enter the pincode")
	public void enter_the_pincode() throws IOException{
	    pf.enterPincode();
	}


	@And("click on the ADD TO CART button")
	public void click_on_the_add_to_cart_button() {
	    pf.clickButton();
	}

	@Then("the message will be displayed")
	public void the_message_will_be_displayed(){
		String verifyMessage="Added To Cart Successfully.";
	    String message=pf.text1();
	    Assert.assertEquals(verifyMessage,message);
	}
	
//----------------------------------SCENARIO-2-----------------------------------------------------//
	
	@When("click on Interior Texture from the dropdown")
	public void click_on_interior_texture_from_the_dropdown() {
	    pf.click1();
	}

	@And("scroll down to the View Textures button")
	public void scroll_down_to_the_view_textures_section(){
	    pf.scrollDownToViewTexture();
	}

	@And("click on View Textures button")
	public void click_on_view_textures() throws AWTException{
	    pf.clickViewTexture();
	}

	@And("click on Living Room from the room type options")
	public void choose_living_room_from_the_room_type_options() {
	    pf.clickRoomType();
	}

	@Then("user should see images of interior textures filtered for the living room")
	public void user_should_see_images_of_interior_textures_filtered_for_the_living_room() {
		String url="https://www.asianpaints.com/catalogue/interior-textures/living-room.html";
	    Assert.assertEquals(url,driver.getCurrentUrl());
	}

//----------------------------------SCENARIO-3-----------------------------------------------------//
	
	@When("scroll down to the Kitchen button")
	public void scroll_down_to_the_kitchen_button(){
	    pf.scrollDownKitchen();
	}
	
	@When("click on the Kitchen button")
	public void click_on_the_kitchen_button() {
	    pf.clickKitchen();
	}

	@And("scroll down to the Locator button")
	public void click_on_the_store_locator_option(){
		pf.scrollDownToLocator();
	}

	@And("Enter the city {string} in the search field")
	public void enter_the_city_in_the_search_field(String string,DataTable dataTable){
		List<List<String>> cells = dataTable.cells();
		pf.enterCity(cells.get(0).get(0));
	}
	
	@And("click on Locator button")
	public void click_on_locator_button() {
	    pf.clickOnLocator();
	}

	@Then("it should locate the stores in the specified city")
	public void it_should_locate_the_stores_in_the_specified_city(){
	    String cityInfo="City:Mumbai";
	    String cityName=pf.city1();
	    Assert.assertTrue(cityName.contains(cityName));
	}

//----------------------------------SCENARIO-4-----------------------------------------------------//	

	@When("click on Paints Budget Calculator")
	public void click_on_paints_budget_calculator() {
	    pf.clickPaintBudgetCalculator();
	}

	@And("click on Fresh Painting radio button")
	public void click_on_fresh_painting_radio_button() {
	    pf.clickFreshPainting();
	}

	@And("click on interior radio button")
	public void click_on_interior_radio_button() {
	    pf.clickInterior();
	}

	@And("^enter (.*) as the carpet area")
	public void enter_as_the_carpet_area(String value) {
	    pf.enterArea(value);
	}

	@And("click on Calculate Now button")
	public void click_on_calculate_now_button() {
	    pf.clickCalculateButton();;
	}
	
	@And("^Enter the details (.*),(.*),(.*),(.*)")
	public void enter_the_details(String name, String email, String mobile, String pincode) {
	    pf.enterValue1(name, email, mobile, pincode);
	}

	@And("click on get an estimate button")
	public void click_on_get_an_estimate_button(){
	    pf.clickGetInstantButton();
	}
	
	@Then("user should be redirected to the Our Expert Recommendation page")
	public void user_should_be_redirected_to_the_our_expert_recommendation_page() {
		String url="https://www.asianpaints.com/resources/tools/paint-budget-calculator.html";
	    Assert.assertEquals(url,driver.getCurrentUrl());
	}
	
//----------------------------------SCENARIO-5-----------------------------------------------------//	

	@Then("the error message will be displayed")
	public void the_error_message_will_be_displayed() {
	    String exp="Phone number is invalid";
	    String act=pf.errorMessage();
	    Assert.assertTrue(exp.contains(act));
	}

//----------------------------------SCENARIO-6-----------------------------------------------------//	

	@When("user click on the Exterior Texture")
	public void user_click_on_the_exterior_texture() {
	    pf.clickExteriorTexture();
	}

	@And("user attempt to click on the purples and pinks option")
	public void user_attempt_to_click_on_the_purples_and_pinks_option() {
	    pf.clickPinks();
	}

	@Then("user should able to see the shades of purple and pinks colour")
	public void the_button_should_be_clickable_and_show_shades_of_purple_and_pinks_colour() {
		String expected="kadambari-n";
	    String Actual=pf.check();
	    Assert.assertEquals(Actual,expected);
	}
	
	@AfterStep
	public static void takeScreendown(Scenario scenerio) {
		   TakesScreenshot ts= (TakesScreenshot) driver;
		   final byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		   scenerio.attach(src, "image/png",scenerio.getName());	


    }
}

//-------------------------------------------------------------------------------------------------//