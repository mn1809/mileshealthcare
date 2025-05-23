package com.milesHC.PageLibRepo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import java.time.Duration;

import com.milesHC.PageObjectRepo.ATSCounselingObj;
import com.milesHC.PageObjectRepo.ATSUniversityObj;
import com.milesHC.PageObjectRepo.AdminPageObj;
import com.milesHC.PageObjectRepo.OPTPageObj;
import com.milesHC.PageObjectRepo.atspageObj;
import com.milesHC.Utilities.MilesUtilities;

import org.openqa.selenium.support.ui.WebDriverWait;


public class HCATSUniversityLib extends ATSUniversityObj

{	
//	  public ATSPageLib(WebDriver driver, String env) {
//	        super(driver, env);  // Pass driver and env to Libpage constructor
//	    }

	public HCATSUniversityLib   (WebDriver driver) 
	{
		super(driver);
	
	//	PageFactory.initElements(driver, this); 
		// TODO Auto-generated constructor stub
	}

	

	    
	    
	public void ClearMyCandidateFilter() throws InterruptedException
	{
		Thread.sleep(3);
		driver.findElement((By.xpath("//*[contains(@class, 'o_facet_remove oi oi-close btn btn-link opacity-50 opacity-100-hover text-900')]"))).click();
	}
	
	public void CandidateData() throws InterruptedException
	{
		driver.findElement(By.className("o_searchview_input")).click();
		Thread.sleep(1000);
		driver.findElement(By.className("o_searchview_input")).sendKeys("Automation-User1");
		Thread.sleep(3000);
	}
	
	
	public void CandidateData1() throws InterruptedException
	
	{
		driver.findElement(By.xpath("//*[contains(@class, 'btn btn-light o_switch_view o_list oi oi-view-list')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("o_searchview_input")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("o_searchview_input")).sendKeys("Automation-User1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name, 'can_id')]")).click();
	}
	
	public void EnteringGraduationDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@name, 'education_details')]")).click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'o_ChatterTopbar_button o_ChatterTopbar_buttonSendMessage btn text-nowrap me-2 btn-odoo')]"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer btn-primary')]")).click();
		
		driver.findElement(By.id("graduation_level")).click();
		
		//Alternative way to select the other options//
			WebElement paymentDropdown = driver.findElement(By.id("graduation_level"));

		    // Create a Select object for the dropdown
		    Select select = new Select(paymentDropdown);

		    // Select the option by value
		    select.selectByValue("\"ug\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here

		    // OR: Select the option by visible text     // select.selectByVisibleText("Self support");

		    WebElement selectedOption = select.getFirstSelectedOption();
		    System.out.println("Selected option is: " + selectedOption.getText());
		    Thread.sleep(3000);
		    //-------------------------Graduation--------------------//
		    driver.findElement(By.id("graduation_id")).click();
		    driver.findElement(By.id("graduation_id")).sendKeys("Bachelor of Engineering");
		    Thread.sleep(2000);
		    List <WebElement> Graduation = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
		    Graduation.get(0).click();
		    
			//-------------------------Unversity--------------------------//
			
			 driver.findElement(By.id("university_id")).click();
			 driver.findElement(By.id("university_id")).sendKeys("Acharya Nagarjuna University, Guntur (Id: U-0003)");
			 Thread.sleep(2000);
			  List <WebElement> Unversity = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
			  Unversity.get(0).click();
			    
			  
			  
			  //-----------------------------Course Duration---------------------//
			  
			  driver.findElement(By.id("graduation_year")).click();
			  Thread.sleep(2000);
			  WebElement Course = driver.findElement(By.id("graduation_year"));
		 	    Select select6 = new Select(Course);
		 	    
		 	   select6.selectByValue("\"4\""); 
		 	   
		 	  WebElement selectedOption6 = select6.getFirstSelectedOption();
		 	    System.out.println("Selected option is: " + selectedOption6.getText());
		 	    Thread.sleep(3000);
			 
			  

			//----------------------------------------Year of Graduation-------------------------------//    
			  
			  driver.findElement(By.id("year_of_graduation_date")).click();
			  driver.findElement(By.xpath("//*[contains(@class, 'year old')]")).click();
			     Thread.sleep(2000);
			     driver.findElement(By.xpath("//span[@data-action='selectMonth' and @class='month']")).click();
			     Thread.sleep(2000); 
			     driver.findElement(By.xpath("//*[contains(@data-day, '01/18/2019')]")).click();
			     Thread.sleep(2000); 
			   //----------------------------------------------NAAC Grade------------------------//  
			     
			     driver.findElement(By.id("naac_grade")).click();
			 		WebElement NAAC = driver.findElement(By.id("naac_grade"));
			 	    Select select1 = new Select(NAAC);

			 	    select1.selectByValue("\"app\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption1 = select1.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption1.getText());
			 	    Thread.sleep(3000);
		//-------------------------------------------------GraduatioStatus---------------------------//	     
			 	   driver.findElement(By.id("graduation_status")).click();
			 		WebElement GraduatioStatus = driver.findElement(By.id("graduation_status"));
			 	    Select select2 = new Select(GraduatioStatus);

			 	    select2.selectByValue("\"2\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption2 = select2.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption2.getText());
			 	    Thread.sleep(3000);   
			 	    
		//----------------------------------------Rank------------------------------//
			 	    
			 	   driver.findElement(By.id("graduation_rank")).click();
			 		WebElement Rank = driver.findElement(By.id("graduation_rank"));
			 	    Select select3 = new Select(Rank);

			 	    select3.selectByValue("\"1\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption3 = select3.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption3.getText());
			 	    Thread.sleep(3000);  

			 	//------------------------------------------------------Division-------------------//
			 	    
			 	   driver.findElement(By.id("graduation_rank_id")).click();
			 	  
			 	 driver.findElement(By.id("graduation_rank_id")).sendKeys("First Division");
			 	   Thread.sleep(3000); 
			 	List <WebElement> Division = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
			 	Division.get(0).click();
			    Thread.sleep(3000); 
			
			    
			  //-----------------------------------------------------Overall Percentage%-------------------------------//    
			    WebElement Percentage = driver.findElement(By.id("graduation_percentage"));
				Percentage.click();
				 Thread.sleep(2000);
				Percentage.clear();
				
				Percentage.sendKeys("85");
			 	//---------------------------------NAACSTATUS---------------------------//    
			 	   driver.findElement(By.id("naac_status")).click();
			 		WebElement NAACSTATUS = driver.findElement(By.id("naac_status"));
			 	    Select select5 = new Select(NAACSTATUS);

			 	    select5.selectByValue("\"yes\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption5 = select5.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption5.getText());
			 	    Thread.sleep(3000);    
			 	    
			 	   
			 	 driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary o_form_button_save')]")).click();  
	}
	
	
	
	public void EnteringPGGraduationDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@name, 'education_details')]")).click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'o_ChatterTopbar_button o_ChatterTopbar_buttonSendMessage btn text-nowrap me-2 btn-odoo')]"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer btn-primary')]")).click();
		 Thread.sleep(2000);
		driver.findElement(By.id("graduation_level")).click();
		
		//Alternative way to select the other options//
			WebElement paymentDropdown = driver.findElement(By.id("graduation_level"));

		    // Create a Select object for the dropdown
		    Select select = new Select(paymentDropdown);

		    // Select the option by value
		    select.selectByValue("\"pg\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here

		    // OR: Select the option by visible text     // select.selectByVisibleText("Self support");

		    WebElement selectedOption = select.getFirstSelectedOption();
		    System.out.println("Selected option is: " + selectedOption.getText());
		    Thread.sleep(3000);
		    //-------------------------Graduation--------------------//
		    driver.findElement(By.id("graduation_id")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.id("graduation_id")).sendKeys("Master of Engineering");
		    Thread.sleep(2000);
		    List <WebElement> Graduation = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
		    Graduation.get(0).click();
		    
			//-------------------------Unversity--------------------------//
			
			 driver.findElement(By.id("university_id")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.id("university_id")).sendKeys("Acharya Nagarjuna University, Guntur (Id: U-0003)");
			 Thread.sleep(2000);
			  List <WebElement> Unversity = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
			  Unversity.get(0).click();
			  
			  
			  
			  //-----------------------------Course Duration---------------------//
			  
			  driver.findElement(By.id("graduation_year")).click();
			  Thread.sleep(2000);
			  WebElement Course = driver.findElement(By.id("graduation_year"));
		 	    Select select6 = new Select(Course);
		 	    
		 	   select6.selectByValue("\"2\""); 
		 	   
		 	  WebElement selectedOption6 = select6.getFirstSelectedOption();
		 	    System.out.println("Selected option is: " + selectedOption6.getText());
		 	    Thread.sleep(3000);
			    
			//----------------------------------------Years of Graduation-------------------------------//    
			  
			  driver.findElement(By.id("year_of_graduation_date")).click();
			  Thread.sleep(2000);
			//  driver.findElement(By.xpath("//*[contains(@class, 'year old')]")).click();//span[normalize-space()='2021']
			   driver.findElement(By.xpath("//span[normalize-space()='2021']")).click(); 
			  Thread.sleep(2000);
			     driver.findElement(By.xpath("//span[@data-action='selectMonth' and @class='month']")).click();
			     Thread.sleep(2000); 
			     driver.findElement(By.xpath("//*[contains(@data-day, '01/18/2021')]")).click();
			     Thread.sleep(2000); 
			   //----------------------------------------------NAAC Grade------------------------//  
			     
			     driver.findElement(By.id("naac_grade")).click();
			     Thread.sleep(2000);
			 		WebElement NAAC = driver.findElement(By.id("naac_grade"));
			 	    Select select1 = new Select(NAAC);

			 	    select1.selectByValue("\"app\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption1 = select1.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption1.getText());
			 	    Thread.sleep(3000);
		//-------------------------------------------------GraduatioStatus---------------------------//	     
			 	   driver.findElement(By.id("graduation_status")).click();
			 	  Thread.sleep(2000);
			 		WebElement GraduatioStatus = driver.findElement(By.id("graduation_status"));
			 	    Select select2 = new Select(GraduatioStatus);

			 	    select2.selectByValue("\"2\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption2 = select2.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption2.getText());
			 	    Thread.sleep(3000);   
			 	    
		//----------------------------------------Rank------------------------------//
			 	    
			 	   driver.findElement(By.id("graduation_rank")).click();
			 	  Thread.sleep(2000);
			 		WebElement Rank = driver.findElement(By.id("graduation_rank"));
			 	    Select select3 = new Select(Rank);

			 	    select3.selectByValue("\"1\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption3 = select3.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption3.getText());
			 	    Thread.sleep(3000);  

			 	//------------------------------------------------------Division-------------------//
			 	    
			 	   driver.findElement(By.id("graduation_rank_id")).click();
			 	  Thread.sleep(2000);
			 	 driver.findElement(By.id("graduation_rank_id")).sendKeys("First Division");
			 	   Thread.sleep(3000); 
			 	List <WebElement> Division = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
			 	Division.get(0).click();
			    Thread.sleep(3000); 
			
			    //-----------------------------------------------------Overall Percentage%-------------------------------//
			WebElement Percentage = driver.findElement(By.id("graduation_percentage"));
			Percentage.click();
			 Thread.sleep(2000);
			Percentage.clear();
			
			Percentage.sendKeys("85");
			    
			 	//---------------------------------NAACSTATUS---------------------------//    
			 	   driver.findElement(By.id("naac_status")).click();
			 		WebElement NAACSTATUS = driver.findElement(By.id("naac_status"));
			 	    Select select5 = new Select(NAACSTATUS);

			 	    select5.selectByValue("\"yes\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here
			 	    WebElement selectedOption5 = select5.getFirstSelectedOption();
			 	    System.out.println("Selected option is: " + selectedOption5.getText());
			 	    Thread.sleep(3000);    
			 	    
			 	   
			 	 driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary o_form_button_save')]")).click();  
	}
	
	public void VerifyHomeMenuOptionsProd()
	{
	
		driver.findElement(By.className("dropdown-toggle")).click();
		
		List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'dropdown-item o_app')]")));
	
		{
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'dropdown-item o_app')]")).isDisplayed());
		
		Assert.assertEquals(Options.get(0).getText(), "USP Eligibility");
		Assert.assertEquals(Options.get(1).getText(), "Miles ATS");
		Assert.assertEquals(Options.get(2).getText(), "Miles Recruitments");
		Assert.assertEquals(Options.get(3).getText(), "Helpdesk");
		Assert.assertEquals(Options.get(4).getText(), "Discuss");
		Assert.assertEquals(Options.get(5).getText(), "Calendar");
		Assert.assertEquals(Options.get(6).getText(), "Contacts");
		Assert.assertEquals(Options.get(7).getText(), "Employees");
		Assert.assertEquals(Options.get(8).getText(), "Apps");
		Assert.assertEquals(Options.get(9).getText(), "Settings");
		}
		
		}

	public void VerifyHomeMenuOptionsStage()
	{
	
		driver.findElement(By.className("dropdown-toggle")).click();
		
		List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'dropdown-item o_app')]")));
	
		{
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'dropdown-item o_app')]")).isDisplayed());
		
		Assert.assertEquals(Options.get(0).getText(), "USP Eligibility");
		Assert.assertEquals(Options.get(1).getText(), "Miles ATS");
		Assert.assertEquals(Options.get(2).getText(), "Miles Recruitments");
		Assert.assertEquals(Options.get(3).getText(), "Helpdesk");
		Assert.assertEquals(Options.get(4).getText(), "Discuss");
		Assert.assertEquals(Options.get(5).getText(), "Calendar");
		Assert.assertEquals(Options.get(6).getText(), "My Dashboard");
		Assert.assertEquals(Options.get(7).getText(), "Job Queue");
		Assert.assertEquals(Options.get(8).getText(), "Contacts");
		Assert.assertEquals(Options.get(9).getText(), "Dashboards");
		Assert.assertEquals(Options.get(10).getText(), "Employees");
		Assert.assertEquals(Options.get(11).getText(), "Apps");
		Assert.assertEquals(Options.get(12).getText(), "Settings");
		}
		
		}

	
	public void VerifyInitiateATSPage() throws InterruptedException
	{
		driver.findElement(By.className("dropdown-toggle")).click();
		List <WebElement> Options = driver.findElements(By.xpath("//*[contains(@class, 'dropdown-item o_app')]"));
		Options.get(1).click();

		Thread.sleep(4000);
	}

	public void VerifyATSCOnfigurationOptionsStage() throws InterruptedException
	{
		 try {
             WebElement plusElement = driver.findElement(By.xpath("//*[contains(@title, 'More Menu')]"));
             
             // If the element is displayed, click it
             if (plusElement.isDisplayed()) {
                 plusElement.click();
               //  System.out.println("Clicked on the 'More Menu' button.");
                 ListforStageserver();
             }
             
         } catch (Exception e) {
             // If "More Menu" element is not found, fall back to clicking the "Configuration" button
             System.out.println("'More Menu' not found, clicking 'Configuration' button instead.");
             WebElement configButton = driver.findElement(By.xpath("//button[@title= 'Configuration']"));
             configButton.click();
             ListforLocalStage();
             
         }
		 
	}
	public void ListforStageserver()
	{
		 
			List<String> expectedOptions = Arrays.asList(
					"Telephony Call Logs",
				    "Allocation Configuration",
				    "Enrollment Batches",
				    "Enrollment University",
				    "Buckets",
				    "Enrollment Course",
				    "ATS Journey",
				    "LOR Question",
				    "Graduation Division",
				    "Pathway College",
				    "Sessions",
				    "Document Type",
				    "MSA Document Type",
				    "DS-160 Step",
				    "Ineligible Reason",
				    "Loan Provider",
				    "Bank",
				    "Synopsis",
				    "Telephony call Reason",
				    "Visa Slot City",
				    "Questions",
				    "Category",
				    "Journey Decks",
				    "MF Migration",
				    "Student Previous Document History",
				    "NAAC Grade",
				    "University Category Matrix",
				    "University Recommendation Combination",
				    "ATS Terms and Conditions"
				);
			 WebElement configOptions = driver.findElement(By.xpath("//*[contains(@class, 'o-dropdown--menu dropdown-menu d-block')]"));
			 List<WebElement>OptionsIteam = configOptions.findElements(By.className("dropdown-item"));
			 
			 for (int i = 0; i < OptionsIteam.size();i++)
			 {
				 System.out.println(OptionsIteam.get(i).getText());
				 Assert.assertEquals(OptionsIteam.get(i).getText(), expectedOptions.get(i));
				 
			 }
	}
	
	public void ListforLocalStage()
	{
		 
			List<String> expectedOptions = Arrays.asList(
				    "Allocation Configuration",
				    "Enrollment Batches",
				    "Enrollment University",
				    "Buckets",
				    "Enrollment Course",
				    "ATS Journey",
				    "LOR Question",
				    "Graduation Division",
				    "Pathway College",
				    "Sessions",
				    "Document Type",
				    "MSA Document Type",
				    "DS-160 Step",
				    "Ineligible Reason",
				    "Loan Provider",
				    "Bank",
				    "Synopsis",
				    "Telephony call Reason",
				    "Visa Slot City",
				    "Questions",
				    "Category",
				    "Journey Decks",
				    "MF Migration",
				    "Student Previous Document History",
				    "NAAC Grade",
				    "University Category Matrix",
				    "University Recommendation Combination",
				    "ATS Terms and Conditions"
				);
			 WebElement configOptions = driver.findElement(By.xpath("//*[contains(@class, 'o-dropdown--menu dropdown-menu d-block')]"));
			 List<WebElement>OptionsIteam = configOptions.findElements(By.className("dropdown-item"));
			 
			 for (int i = 0; i < OptionsIteam.size();i++)
			 {
				 System.out.println(OptionsIteam.get(i).getText());
				 Assert.assertEquals(OptionsIteam.get(i).getText(), expectedOptions.get(i));
				 
			 }
	}


	
	
	
	public void VerifyATSCOnfigurationOptionsProd() throws InterruptedException
	{
		 try {
            WebElement plusElement = driver.findElement(By.xpath("//*[contains(@title, 'More Menu')]"));
            
            // If the element is displayed, click it
            if (plusElement.isDisplayed()) {
                plusElement.click();
                System.out.println("Clicked on the 'More Menu' button.");
                Listforprodserver();
            }
            
        } catch (Exception e) {
            // If "More Menu" element is not found, fall back to clicking the "Configuration" button
            System.out.println("'More Menu' not found, clicking 'Configuration' button instead.");
            WebElement configButton = driver.findElement(By.xpath("//button[@title= 'Configuration']"));
            
            configButton.click();
            Thread.sleep(2000);
            ListforLocalProd();
            
        }
		 
	}
	
	public void ListforLocalProd()
	{
		//driver.findElement(By.xpath("//button[@title= 'Configuration']")).click();
		// Expected options
		List<String> expectedOptions = Arrays.asList(
			    "Allocation Configuration",
			    "Enrollment Batches",
			    "Enrollment University",
			    "Buckets",
			    "Enrollment Course",
			    "ATS Journey",
			    "LOR Question",
			    "Graduation Division",
			    "Pathway College",
			    "Sessions",
			    "Document Type",
			    "MSA Document Type",
			    "DS-160 Step",
			    "Ineligible Reason",
			    "Loan Provider",
			    "Bank",
			    "Synopsis",
			    "Telephony call Reason",
			    "Visa Slot City",
			    "Journey Decks",
			    "Student Previous Document History",
			    "NAAC Grade",
			    "University Grade Matrix",
			    "University Recommendation Combination",
			    "ATS Terms and Conditions"
			);
		
		 WebElement configOptions = driver.findElement(By.xpath("//*[contains(@class, 'o-dropdown--menu dropdown-menu d-block')]"));
		 List<WebElement>OptionsIteam = configOptions.findElements(By.className("dropdown-item"));
		 
		 for (int i = 0; i < OptionsIteam.size();i++)
		 {
			 System.out.println(OptionsIteam.get(i).getText());
			 Assert.assertEquals(OptionsIteam.get(i).getText(), expectedOptions.get(i));
			 
		 }
	}

	
	public void Listforprodserver()
	{
		//driver.findElement(By.xpath("//button[@title= 'Configuration']")).click();
		// Expected options
		List<String> expectedOptions = Arrays.asList(
			    "Allocation Configuration",
			    "Enrollment Batches",
			    "Enrollment University",
			    "Buckets",
			    "Enrollment Course",
			    "ATS Journey",
			    "LOR Question",
			    "Graduation Division",
			    "Pathway College",
			    "Sessions",
			    "Document Type",
			    "MSA Document Type",
			    "DS-160 Step",
			    "Ineligible Reason",
			    "Loan Provider",
			    "Bank",
			    "Synopsis",
			    "Telephony call Reason",
			    "Visa Slot City",
			    "Journey Decks",
			    "Student Previous Document History",
			    "NAAC Grade",
			    "University Grade Matrix",
			    "University Recommendation Combination",
			    "ATS Terms and Conditions"
			);
		 WebElement configOptions = driver.findElement(By.xpath("//*[contains(@class, 'o-dropdown--menu dropdown-menu d-block')]"));
		 List<WebElement>OptionsIteam = configOptions.findElements(By.className("dropdown-item"));
		 
		 for (int i = 0; i < OptionsIteam.size();i++)
		 {
			 System.out.println(OptionsIteam.get(i).getText());
			 Assert.assertEquals(OptionsIteam.get(i).getText(), expectedOptions.get(i));
			 
		 }
	}
	
	public void EnteringCertificationDetails() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@name, 'professional_details')]")).click();
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'o_ChatterTopbar_button o_ChatterTopbar_buttonSendMessage btn text-nowrap me-2 btn-odoo')]"))).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer btn-primary')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("professional_id")).click();
	
		driver.findElement(By.id("professional_id")).sendKeys("Financial Risk Manager");
		Thread.sleep(2000);
	 	List <WebElement> Division = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	 	Division.get(0).click();
	 	
	 	//--------------------------------------------Year Of Certifications---------------------------------------//
		  
		  driver.findElement(By.id("year_of_graduation_date")).click();
		  driver.findElement(By.xpath("//*[contains(@class, 'year old')]")).click();
		     Thread.sleep(2000);
		     driver.findElement(By.xpath("//span[@data-action='selectMonth' and @class='month']")).click();
		     Thread.sleep(2000); 
		     driver.findElement(By.xpath("//*[contains(@data-day, '01/18/2019')]")).click();
		     Thread.sleep(2000);
		     
		//----------------------------------Professional Qualification Status----------------------------------------//
		     
		     driver.findElement(By.id("professional_status")).click();
		 		WebElement ProfessionalStatus = driver.findElement(By.id("professional_status"));
		 	    Select select2 = new Select(ProfessionalStatus);

		 	    select2.selectByValue("\"completed\""); 
		 	    WebElement selectedOption2 = select2.getFirstSelectedOption();
		 	    System.out.println("Selected option is: " + selectedOption2.getText());
		 	    Thread.sleep(3000);  
		 	    
		 	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary o_form_button_save')]")).click();  
		     
	}
	
	
	
	public void EnteringWorkExperience() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@name, 'work_experience')]")).click();
		 Thread.sleep(3000); 
		driver.findElement(By.id("has_experience")).click();
		Thread.sleep(2000);
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'o_ChatterTopbar_button o_ChatterTopbar_buttonSendMessage btn text-nowrap me-2 btn-odoo')]"))).perform();
		Thread.sleep(2000);
		
		WebElement workexpyear = driver.findElement(By.id("total_experience"));
		workexpyear.click();
		Thread.sleep(2000);
		workexpyear.clear();
		Thread.sleep(2000);
		workexpyear.sendKeys("4");
		
		 Thread.sleep(3000); 
		 
		WebElement workexpmonth = driver.findElement(By.id("total_experience_month"));
		workexpmonth.click();
		Thread.sleep(2000);
		workexpmonth.clear();
		Thread.sleep(1000);
		workexpmonth.sendKeys("5");
		
		 Thread.sleep(2000);
		 
		 WebElement CurrentCompany = driver.findElement(By.id("current_company"));
		 CurrentCompany.click();
		 Thread.sleep(2000);
		 CurrentCompany.clear();
		 Thread.sleep(1500);
		 CurrentCompany.sendKeys("Miles Automation Company");
		 Thread.sleep(3000);
		 
		 driver.findElement(By.className("save_button")).click();
	
	}
	
	
	public void AutoRecommendUniversity() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
		Thread.sleep(3000);
		
		driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(0).isDisplayed();
		System.out.println("1st Recommended University is "+driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(0).getText());
		
		driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(1).isDisplayed();
		System.out.println("2nd Recommended University is "+driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(1).getText());
		
		driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(2).isDisplayed();
		System.out.println("3rd Recommended University is "+driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(2).getText());	
	
		driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(3).isDisplayed();
		System.out.println("4th Recommended University is "+driver.findElements(By.xpath("//*[contains(@name, 'university_id')]")).get(3).getText());
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[contains(@name, 'action_recommend_university')]")).click();
		Thread.sleep(3000);
//-----------------------For Manual Recommendation--------------//
//	    WebElement button = driver.findElement(By.xpath("//a[@role='button' and text()='Add a line']"));
//	    button.click();
//	    Thread.sleep(2000);
//	    WebElement addline =   driver.findElement(By.xpath("//div[@name='university_id']//input[@role='combobox']"));
//		//div[@name='university_id']//input[@role='combobox']
//	    addline.click();
//	    addline.sendKeys("DePaul University");
//	    Thread.sleep(2000);
//	    List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
//		Options1.get(0).click();
	

	}

	
	public void RecommendationCompleted() throws InterruptedException
	{
		Actions act = new Actions(driver);
		Thread.sleep(2000);
		act.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'nav-link active undefined')]"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@name='student_application_line']")).click();//a[@name='student_application_line']
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Recommendation Completed']")).click();
		Thread.sleep(3000);
		
		act.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]"))).perform();
		//span[normalize-space()='Recommendation Completed']
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	}


	public void TabsbuttonOnU7Enrolled() throws InterruptedException
	{
		
		CandidateData();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
		
		driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
		System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
		System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
		System.out.println("Red Button 1 is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
		System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
		
		driver.findElements(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).get(1).isDisplayed();
		System.out.println("Red Button 2 is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
		
//		driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
//		System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
		
	}
	
	
	public void ReAllocate() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[contains(@title, 'Lead Allocation')]")).click();
		Thread.sleep(4000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@data-menu-xmlid='miles_ats_student.menu_miles_ats_student_gm_spoc_vise_allocate_spocs']")));

		WebElement element = driver.findElement(By.xpath("//a[@data-menu-xmlid='miles_ats_student.menu_miles_ats_student_gm_spoc_vise_allocate_spocs']"));
		element.click();

		//b[normalize-space()='Student']
	//	driver.findElement(By.xpath("//a[text()='Reallocate the Spocs']")).click();
		Thread.sleep(4000);
		driver.findElement(By.className("o_searchview_input")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.className("o_searchview_input")).sendKeys("Automation-User1");
	
		Thread.sleep(4000);
		
		driver.findElement((By.xpath("//b[normalize-space()='Student']"))).click();
		 Thread.sleep(4000);
		
		 
		driver.findElement(By.id("checkbox-comp-1")).click();
		 Thread.sleep(3000);
		 
		driver.findElement(By.xpath("//*[contains(@name, 'open_wiz_allocate_gm_spoc_to_lead')]")).click();
		Thread.sleep(3000);

	WebElement Gm =	driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(0);   //------------ADDING GENERAL MANAGER-------------//
	Gm.click();
	Thread.sleep(2000);
	Gm.sendKeys("Manoj Expert");
	Thread.sleep(2000);
	List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options1.get(0).click();
	
	Thread.sleep(2000);
	
	WebElement Spoc = driver.findElement(By.id("gm_spoc_id"));        //--------------ADDING GM SPOC------------//
	Spoc.click();
	Thread.sleep(2000);
	Spoc.sendKeys("Manoj Spoc");
	Thread.sleep(2000);
	List <WebElement> Options2 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options2.get(0).click();
	
	Thread.sleep(2000);
	
	WebElement UniveristyExpert = driver.findElement(By.id("university_expert_id"));		//----------------ADDING UNIVERSITY EXPERT----------//
	UniveristyExpert.click();
	Thread.sleep(2000);
	UniveristyExpert.sendKeys("Manoj University Expert");
	Thread.sleep(2000);
	List <WebElement> Options3 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options3.get(0).click();
	Thread.sleep(2000);
	
	
	WebElement UniveristySpoc = driver.findElement(By.id("university_spoc_id"));        //--------------ADDING UNIVERSITY SPOC------------//
	UniveristySpoc.click();
	Thread.sleep(2000);
	UniveristySpoc.sendKeys("Manoj University Spoc");
	Thread.sleep(2000);
	List <WebElement> Options4 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options4.get(0).click();
	
	
	WebElement LoanExpert = driver.findElement(By.id("loan_expert_id"));        //--------------ADDING Loan Expert------------//
	LoanExpert.click();
	Thread.sleep(2000);
	LoanExpert.sendKeys("Aishu loan support expert");
	Thread.sleep(2000);
	List <WebElement> Options5 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options5.get(0).click();
	
	
	WebElement LoanSpoc = driver.findElement(By.id("loan_spoc_id"));        //--------------ADDING Loan Spoc------------//
	LoanSpoc.click();
	Thread.sleep(2000);
	LoanSpoc.sendKeys("Aishu loan support spoc");
	Thread.sleep(2000);
	List <WebElement> Options6 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options6.get(0).click();
	
	
	WebElement VisaExpert = driver.findElement(By.id("visa_expert_id"));		//---------------------------ADDING VISA EXPERT-----------------//
	VisaExpert.click();
	Thread.sleep(2000);
	VisaExpert.sendKeys("Syed Pasha");
	Thread.sleep(2000);
	List <WebElement> Options7 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options7.get(0).click();
	Thread.sleep(2000);
	
	
	WebElement VisaSPOC = driver.findElement(By.id("visa_expert_id"));		//---------------------------ADDING VISA Spoc-----------------//
	VisaSPOC.click();
	Thread.sleep(2000);
	VisaSPOC.sendKeys("Debasmita Ray");
	Thread.sleep(2000);
	List <WebElement> Options8 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options8.get(0).click();
	Thread.sleep(2000);
	
	
	WebElement ContentSpoc = driver.findElement(By.id("content_spoc_id"));   //----------------------------ADDING CONTENT SPOC-------------//
	ContentSpoc.click();
	Thread.sleep(2000);
	ContentSpoc.sendKeys("Manoj ContentWriter");
	Thread.sleep(2000);
	List <WebElement> Options9 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options9.get(0).click();
	Thread.sleep(2000);
	
	
		driver.findElement((By.xpath("//*[contains(@name, 'action_allocate_gm_to_leads')]"))).click();  //-----------------------Final OK ALLOCTING---------------------//
		Thread.sleep(10000);
	}
	
	
	
	
	public void TooBookExpertSessionProd() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[contains(@title, 'Meetings')]")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//*[contains(@role, 'menuitem')]")).get(2).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary o_list_button_add')]")).click();
		Thread.sleep(3000);
	
	
			 driver.findElement(By.id("job_position")).click();
			 Thread.sleep(3000);
			//input[@id='job_position']
				driver.findElement(By.id("job_position")).sendKeys("Counselling Expert");
				List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
				Options1.get(0).click();
//
//		driver.findElement(By.id("emp_id")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.id("emp_id")).sendKeys("Manoj Expert");
//		Thread.sleep(3000);
//		
//		List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
//		Options.get(0).click();
//		 
//		 
//		Thread.sleep(2000);
//		driver.findElement((By.xpath("//*[contains(@class, 'o_datepicker_input o_input datetimepicker-input')]"))).click();
//		Thread.sleep(2000);
//
//
//	 // Get tomorrow's date
//	    LocalDate tomorrow = LocalDate.now().plusDays(1);
//	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//	    String tomorrowDate = tomorrow.format(formatter);
//
//	    //XPath using the calculated date
//	    String xpath = String.format("//td[@data-action='selectDay' and @data-day='%s']", tomorrowDate);
//
//
//	    WebElement dateElement = driver.findElement(By.xpath(xpath));
//	    dateElement.click();
	  
	}
	
	
	public void TooBookExpertSessionStage() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[contains(@title, 'Meetings')]")).click();
		Thread.sleep(2000);
		driver.findElements(By.xpath("//*[contains(@role, 'menuitem')]")).get(1).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary o_list_button_add')]")).click();
		Thread.sleep(3000);
	
			 
			 driver.findElement(By.id("job_position")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.id("job_position")).clear();
			 Thread.sleep(3000);
			 driver.findElement(By.id("job_position")).click();
			 Thread.sleep(2000);
				driver.findElement(By.id("job_position")).sendKeys("Counselling Expert");
				 Thread.sleep(2000);
				List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
				Options.get(0).click();
				 Thread.sleep(3000);
		driver.findElement(By.id("emp_id")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("emp_id")).sendKeys("Manoj counselling Expert");
		Thread.sleep(3000);
		
		List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
		Options1.get(0).click();
		 
		 
		Thread.sleep(2000);
		driver.findElement((By.xpath("//*[contains(@class, 'o_datepicker_input o_input datetimepicker-input')]"))).click();
		Thread.sleep(2000);


	 // Get tomorrow's date
	    LocalDate tomorrow = LocalDate.now().plusDays(1);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    String tomorrowDate = tomorrow.format(formatter);

	    //XPath using the calculated date
	    String xpath = String.format("//td[@data-action='selectDay' and @data-day='%s']", tomorrowDate);


	    WebElement dateElement = driver.findElement(By.xpath(xpath));
	    dateElement.click();
	  
	}
	

public void TooBookTimeSlot() throws InterruptedException, AWTException
{  
	WebElement button = driver.findElement(By.xpath("//a[@role='button' and text()='Add a line']"));
    button.click();
    Thread.sleep(2000);
    WebElement session =  driver.findElement((By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_many2one o_required_modifier')]")));
    session.click();
    Thread.sleep(3000);
 
    driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(2).sendKeys("Expert Counselling");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@class='dropdown-item ui-menu-item-wrapper text-truncate ui-state-active']")).click();

    //	List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
//	Options.get(0).click();
	
	//a[@class='dropdown-item ui-menu-item-wrapper text-truncate ui-state-active']
    //driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')]")).click(); //
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[contains(@class, 'o_form_button_save btn btn-light py-0')]")).click();//To Save Button//
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[contains(@name, 'action_confirm_allocation')]")).click(); //To confimring Allocation//
    Thread.sleep(2000);
    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click(); //Final Confirmation //
    
    
}


public void RandomClickonScreen() throws AWTException
{
	Robot robot = new Robot();
	robot.mouseMove(100, 200); // Adjust the coordinates as needed
   robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
}

public void TabsbuttonOnU7PlusEnrolled() throws InterruptedException
{
		CandidateData() ;
	
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).isDisplayed();
	System.out.println("Blue Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).getText());
	
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Blue Button 2 is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button  is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button  is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button  is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

}

public void ScrollToMeetingTab() throws InterruptedException 
{
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'student_meeting_line')]"))).perform();
	driver.findElement(By.xpath("//*[contains(@name, 'student_meeting_line')]")).click();
	Thread.sleep(2000);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'nav-link active undefined')]"))).perform();
	Thread.sleep(2000);
	
}

public void ScrollToBasicDetails() 
{
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'student_card')]"))).perform();
	System.out.println("Eligibilty Code of candidate is "+driver.findElement(By.xpath("//*[contains(@name, 'eligibility_code')]")).getText());
	
	//driver.findElement(By.className("fa fa-plus")).click();
}

public void ScrollTillElement(WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", element);

}
	

public void StartMeeting() throws InterruptedException

{
	System.out.println("Meeting Info is "+driver.findElement(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char o_readonly_modifier')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary btn-sm')]")).click(); //Go to Booking in Main Bucket Screem//
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[contains(@name, 'meeting_attendees_line')]")).click(); //Normal CLick.
	Thread.sleep(3000);
//	driver.findElement(By.xpath("//*[contains(@name, 'action_start_meeting')]")).click(); //Click Operation for Start Meeting. //
//	Thread.sleep(6000);
//	
//	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click(); //Start Meeting OK COnfirmation.
//	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_join_meeting')]")).click();///Click to OK Button before Joining Meeting.//
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn btn-success')]")).click(); //Click Operation for Join Meeting.//
		Thread.sleep(5000);
}

public void SwitchtoGoogleMeetButton() throws InterruptedException
{
	MilesUtilities.SwitchTab(1, driver); //BIg BLUE WINDOW.// //Google Meet Button//
	Thread.sleep(7000);

	

//	driver.findElement(By.xpath("//*[contains(@class, 'sc-dJjYzT gbVgVx md buttonWrapper sc-eJwWfJ wxIrW')]")).click();	
//	
//	Thread.sleep(3000);
//	driver.findElement(By.xpath("//*[contains(@class, 'sc-dJjYzT gbVgVx md buttonWrapper sc-bUKjYF kULnRS')]")).click();	
//		
//	Thread.sleep(3000);
//	List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-root sc-lheXJl fwmlKu css-1vsvrdy')]")));
//	Options.get(8).click();
//	Thread.sleep(4000);
//	driver.findElement(By.xpath("//*[contains(@class, 'sc-dlVxhl jQxUMv sc-jnbWvw eysmcT')]")).click();
	MilesUtilities.SwitchTab(0, driver);
	Thread.sleep(4000);
	
}


public void EndMeeting() throws InterruptedException
{
	List <WebElement> Options = driver.findElements(By.xpath("//*[contains(@class, 'btn btn-danger')]"));
	Options.get(0).click();
	Thread.sleep(3000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();	
	Thread.sleep(3000);
}


public void U7PLusEligibleTheCandidate() throws InterruptedException

{
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(2000);
//	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(4).click();
	driver.findElement(By.xpath("//button[normalize-space()='Ok']")).click();
	Thread.sleep(3000);
	
	WebElement intakeBatch=driver.findElements(By.xpath("//*[contains(@class, 'o_cell o_wrap_input flex-grow-1 flex-sm-grow-0 text-break')]")).get(13);
	intakeBatch.click();
	Thread.sleep(2000);
//	intakeBatch.clear();
//	Thread.sleep(2000);
	//intakeBatch.sendKeys("Spring 2025");
	
	Thread.sleep(3000);
	
	List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options.get(0).click();
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_student_ineligible_reason')]")).click();  //-----SUBMIT Button---//
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='Ok']")).click();  //---------AND OK -------//
	Thread.sleep(2000);
}//button[@class='btn btn-primary'][normalize-space()='Ok']


public void Recommenduniversity() throws InterruptedException, AWTException
{
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary btn-sm')]")).click();
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-success btn-sm')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-success btn-sm')]")).getText());
	
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-danger btn-sm')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-danger btn-sm')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-warning btn-sm')]")).isDisplayed();
	System.out.println("Yellow Blue Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-warning btn-sm')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-info btn-sm')]")).isDisplayed();
	System.out.println("Light Blue Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-info btn-sm')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-danger btn-sm')]")).isDisplayed();
	System.out.println("Red2 Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-danger btn-sm')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary btn-sm')]")).isDisplayed();
	System.out.println("Purple Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary btn-sm')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@name, 'action_recommend_university')]")).click();
	
	Thread.sleep(3500);
	
    WebElement button = driver.findElement(By.xpath("//a[@role='button' and text()='Add a line']"));
    button.click();
 
    Thread.sleep(3000);
    
   driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(0).sendKeys("Michigan State University");
   
   Thread.sleep(4000);
   
   driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(1).sendKeys("Masters in Accounting");

   Thread.sleep(4000);
   driver.findElements(By.xpath("//*[contains(@name, 'action_recommend_university')]")).get(1).click();
   
   Thread.sleep(3000);
   driver.findElement(By.xpath("//*[contains(@name, 'action_goto_lead')]")).click();
   
   
}

public void U8bucket() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).isDisplayed();
	System.out.println("Blue Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
//	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());	
}
	


public void MSASigned() throws InterruptedException, AWTException
{
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.id("msa_doc_type_id")).click();
	Thread.sleep(2000);
	 driver.findElement(By.id("msa_doc_type_id")).sendKeys("JAGSoM (Opt-IN)");//---------Giving MAS Documnet Input----------//
	 Thread.sleep(2000);

		
		driver.findElement(By.xpath("//a[@class='dropdown-item ui-menu-item-wrapper text-truncate ui-state-active']")).click();		

		Thread.sleep(5000);

        
    	//driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(0).click();	
    	Thread.sleep(2000);
    	WebElement AgreementDocument = driver.findElements(By.className("o_file_input_trigger")).get(0);
    	AgreementDocument.click();
    	
    	  Thread.sleep(5000);  
    	    
    	    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
    	// fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
    	    fileInput1.sendKeys("C:\\Users\\Miles\\Pictures\\Screenshots\\Frotedn-1.PNG");
    	    
    	    
    		  Thread.sleep(8000);  
    		  
    			WebElement OptinDocument = driver.findElements(By.className("o_file_input_trigger")).get(1);
    			OptinDocument.click();
    	    	
    	    	  Thread.sleep(5000);  
    	    	    
    	    	    WebElement fileInput2 = driver.findElements(By.xpath("//input[@type='file']")).get(1);
    	    	// fileInput2.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
    	    		 fileInput2.sendKeys("C:\\Users\\Miles\\Pictures\\Screenshots\\Frotedn-1.PNG");
    		 
    	    	//	 C:\Users\Miles\Pictures\Screenshots\Frotedn-1.PNG
    	    	 
        // Add any further actions if needed, such as submitting the form
	Thread.sleep(10000);

	driver.findElement(By.xpath("//span[normalize-space()='Submit']")).click();
	
	Thread.sleep(4000);
	
}


public void U9bucketStage1() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

}

public void UniversitySelection() throws InterruptedException
{
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("selected_university_id")).sendKeys("Michigan State University, Masters in Accounting");
	Thread.sleep(3000);
	List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options.get(0).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_selected_enrolled_university')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='Ok']")).click();
	Thread.sleep(3000);

}


public void U9bucketStage2LOR() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_green_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Brown2 Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

}


public void ScrollToLORatU9() throws InterruptedException 
{
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'student_lor')]"))).perform();
	driver.findElement(By.xpath("//*[contains(@name, 'student_lor')]")).click();
	Thread.sleep(3000);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'action_generate_lor')]"))).perform();
	//driver.findElement(By.className("fa fa-plus")).click();
}



public void StudentLORandSOP() throws InterruptedException
{
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
	Thread.sleep(2000);
//	
//	String text = driver.findElement(By.className("//*[contians(@classname, 'o_readonly')]")).getText();
//
//	if (text != null && !text.trim().isEmpty()) 
//	{
//	    System.out.println(text);
//	}
//	else 
//	{
//	    System.out.println("The text is empty or not found.");
//	    throw new AssertionError("The text is empty or not found.");
//	}
	
	//System.out.println(driver.findElement(By.id("lor_updated")).getText());
	Thread.sleep(3000);
	driver.findElement(By.id("signed_by")).click();
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(2).sendKeys("Akhila Chandrashekar");
	Thread.sleep(3000);
	
	List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options1.get(0).click();
	Thread.sleep(3000);
    driver.findElement(By.xpath("//*[contains(@name, 'action_update_lor')]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')]")).click();
    Thread.sleep(10000);

	
    ///----------Entrieing Student SOP------------------//
    
	driver.findElement(By.id("sop_updated")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("sop_updated")).sendKeys("Automated Script SOP for Candidate.");
	Thread.sleep(3000);
	 driver.findElements(By.xpath("//*[contains(@name, 'action_update_sop')]")).get(1).click();
	  
	  Thread.sleep(10000);
	

    
	Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'action_lor_submit_wizard')]"))).perform();
	Thread.sleep(3000);
	
	
	
	driver.findElement(By.xpath("//*[contains(@name, 'action_lor_submit_wizard')]")).click();
	
	Thread.sleep(3000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
	Thread.sleep(3000);
//	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_green_color btn-secondary')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')]")).click();
	Thread.sleep(3000);
}


public void U9Stage3() throws InterruptedException, AWTException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_green_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Brown2 Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

}


public void UploadationOfApplicationProof() throws InterruptedException, AWTException

{

	
	driver.findElements(By.xpath("//*[contains(@name, 'action_update_sop')]")).get(0).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')]")).click();
	Thread.sleep(4000);
	//--------------------------------------------------------------------------------------------------------//
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
		Thread.sleep(2000);

	    WebElement SubmissionScreenshot = driver.findElements(By.xpath("//*[contains(@class,'btn btn-secondary o_attach')]")).get(0);
	
	    SubmissionScreenshot.click();
	    
	    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	    fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	    Thread.sleep(15000);
	    
		//---------------------------------------------------------------------------------------------------------//
//	    Actions act1 = new Actions(driver);
//		act1.moveToElement (driver.findElements(By.xpath("//*[contains(@class,'btn btn-secondary o_attach')]"))).get(1).perform();
//		Thread.sleep(2000);

		Actions act1 = new Actions(driver);

		// Get the list of elements matching the XPath
		List<WebElement> attachButtons = driver.findElements(By.xpath("//*[contains(@class,'btn btn-secondary o_attach')]"));

		// Check if the second element exists
		if (attachButtons.size() > 1) {
		    // Move to the second element
		    act1.moveToElement(attachButtons.get(1)).click().perform();
		} else {
		    System.out.println("The second attach button was not found.");
		}
		
		
		
	    WebElement EmailScreenshot = driver.findElements(By.xpath("//*[contains(@class,'btn btn-secondary o_attach')]")).get(1);
		
	    EmailScreenshot.click();
	    
	    WebElement fileInput2 = driver.findElements(By.xpath("//input[@type='file']")).get(1);
	    fileInput2.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	    Thread.sleep(15000);
	    
	    
		//-------------------------------------------------------------------------------------------------------------------//

	    WebElement PaymentScreenshot = driver.findElements(By.xpath("//*[contains(@class,'btn btn-secondary o_attach')]")).get(2);
		
	    PaymentScreenshot.click();
	    
	    WebElement fileInput3 = driver.findElements(By.xpath("//input[@type='file']")).get(2);
	    fileInput3.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	    Thread.sleep(15000);
	    
	    driver.findElement(By.xpath("//*[contains(@name, 'action_selected_enrolled_university')]")).click();  
	    Thread.sleep(1500);
	    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(2).click();
	    Thread.sleep(7000);
	    
}

public void U9PlusBucket() throws InterruptedException

{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
//	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
//	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
//	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
//	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Brown2 Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
}



public void UPPlusReuploading() throws InterruptedException, AWTException
{
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	
	driver.findElement(By.xpath("//*[contains(@name, 'action_student_application_list')]")).click();
	Thread.sleep(1500);
	driver.findElement(By.xpath("//*[contains(@name, 'action_open_document_attachment_state_wizard')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char text-info')]")).get(0).isDisplayed();
	System.out.println("Confirmation Screenshot is "+driver.findElement(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char text-info')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char text-info')]")).get(1).isDisplayed();
	System.out.println("Email Screenshot is "+driver.findElement(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char text-info')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char text-info')]")).get(2).isDisplayed();
	System.out.println("Payment Screenshot is "+driver.findElement(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_char text-info')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@name, 'action_reupload')]")).click();//Adding Remark for COnfirmation Screenshot status.//
	Thread.sleep(2000);
	
	driver.findElement(By.id("remark")).sendKeys("Adding Remark to Check Reupload"); 
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_submit_remark')]")).click();	//CLIKCING SUBMIT//
	Thread.sleep(4000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_edit_application_line_wizard')]")).click();
	Thread.sleep(3000);

	 WebElement RESubmissionScreenshot = driver.findElements(By.xpath("//*[contains(@class,'btn btn-secondary o_attach')]")).get(0);
		
	    RESubmissionScreenshot.click();
	    Thread.sleep(2000);
	    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	    fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	    
	 //  fileInput1.sendKeys("C:\\Users\\Miles\\Pictures\\Screenshots\\Frotedn-1.PNG");    
	    
	    Thread.sleep(15000);    
    
    driver.findElement(By.xpath("//*[contains(@name, 'action_update_line')]")).click();
    Thread.sleep(8000);
}

public void U9VerifyDocuments() throws InterruptedException
{
//---------------------------------Verifying the Documents----------------------//
    
    driver.findElement(By.xpath("//*[contains(@name, 'action_open_document_attachment_state_wizard')]")).click();
    Thread.sleep(3000);
    driver.findElements(By.xpath("//*[contains(@name, 'action_approve')]")).get(0).click();
    Thread.sleep(2000);
    
    driver.findElements(By.xpath("//*[contains(@name, 'action_approve')]")).get(0).click();
    Thread.sleep(2000);
    
    driver.findElements(By.xpath("//*[contains(@name, 'action_approve')]")).get(0).click();
    Thread.sleep(2000);
   
    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(5500);
}

public void U9plusVerifyApplicationSubmitted() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
//	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
//	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
//	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
//	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Brown2 Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
}



public void U9PlusAddingMOI()throws InterruptedException, AWTException
{
	//--------------------------------------ADDING MOI IN EDUCATION ---------------------------//
	
	
		driver.findElement(By.xpath("//*[contains(@name, 'education_details')]")).click();
		
		Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
		Thread.sleep(2000);
		
		
		Actions act2 = new Actions(driver);
		act2.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'action_edit_graduation_line_wizard')]"))).perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(@name, 'action_edit_graduation_line_wizard')]")).click();
		
		WebElement SubmissionScreenshot = driver.findElements(By.className("o_file_input_trigger")).get(2);
		SubmissionScreenshot.click();
		Thread.sleep(3000);
		
		 WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(2);
//		  fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
		
		      fileInput1.sendKeys("C:\\Users\\Miles\\Pictures\\Screenshots\\Frotedn-1.PNG");    
	    Thread.sleep(10000);
	    
		driver.findElement(By.xpath("//*[contains(@name, 'action_update_line')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@name, 'action_selected_enrolled_university')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary'][normalize-space()='Ok']")).click();
		Thread.sleep(3000);
}


public void U10BucketStage1() throws InterruptedException, AWTException

{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).isDisplayed();
	System.out.println("Blue Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).getText());
	
//	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
//	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
//	
//	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
//	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Brown2 Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();	
	Thread.sleep(2000);
	
	
	
	WebElement UpoloadOfferLetter = driver.findElements(By.className("o_file_input_trigger")).get(0);			//----------Will be Uploading offer letter-----------//
	UpoloadOfferLetter.click();
	Thread.sleep(3000);
	
	 WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	  //  fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	    
	    fileInput1.sendKeys("C:\\Users\\Miles\\Pictures\\Screenshots\\Frotedn-1.PNG"); 
    Thread.sleep(10000);
    
    
    driver.findElement(By.xpath("//*[contains(@name, 'action_selected_enrolled_university')]")).click();
    Thread.sleep(3000);
    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(2).click();
  	Thread.sleep(3000);
  	
}

public void U10BucketStage2() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	Thread.sleep(2500);
	 driver.findElement(By.xpath("//*[contains(@name, 'action_student_application_list')]")).click();
	 //----------------------Approveing the documents----------------------------------//
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[contains(@name, 'action_open_document_attachment_state_wizard')]")).click();
	 Thread.sleep(3000);
	    driver.findElements(By.xpath("//*[contains(@name, 'action_approve')]")).get(0).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//span[normalize-space()='Cancel']")).click();
		Thread.sleep(5000);
	
}

public void U10BucketStage3() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();

	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(2000);
	
    driver.findElement(By.xpath("//*[contains(@name, 'action_selected_enrolled_university')]")).click();
    Thread.sleep(2000);
    
    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(2).click();
  	Thread.sleep(2000); 
}



public void U11BucketStage1() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

	//funding_type
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(2000);
	
	  WebElement paymentDropdown = driver.findElement(By.id("funding_type"));

      // Create a Select object for the dropdown
      Select select = new Select(paymentDropdown);

      // Select the option by value
      select.selectByValue("\"0\""); // Ensure to include the exact value here

      // OR: Select the option by visible text
      // select.selectByVisibleText("Self Payment");

      // Optional: Print selected option to verify
      WebElement selectedOption = select.getFirstSelectedOption();
      System.out.println("Selected option is: " + selectedOption.getText());
  Thread.sleep(2000);
      driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(1500); 
    
}

public void ScrollToVisaSlotU15() throws InterruptedException 
{

	Actions act = new Actions(driver);
	act.moveToElement(driver.findElements(By.xpath("//*[contains(@name, 'visa_slot')]")).get(1)).perform();
	driver.findElements(By.xpath("//*[contains(@name, 'visa_slot')]")).get(1).click();
	Thread.sleep(2000);
	
	Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
	Thread.sleep(2000);
}

public void ScrollToFundingU11() throws InterruptedException 
{
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'funding')]"))).perform();
	driver.findElement(By.xpath("//*[contains(@name, 'funding')]")).click();
	Thread.sleep(3000);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'action_open_payment_wizard')]"))).perform();
	//driver.findElement(By.className("fa fa-plus")).click();
}


public void U11BucketStage2() throws InterruptedException
{
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	Thread.sleep(3000);
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

	ScrollToFundingU11();
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@name, 'action_open_select_finance_fee_wizard')]")).get(1).click();
	Thread.sleep(4000);
	
	//Alternative way to select the other options//
	WebElement paymentDropdown = driver.findElement(By.id("funding_type"));
	
Thread.sleep(2000);
    // Create a Select object for the dropdown
    Select select = new Select(paymentDropdown);

    // Select the option by value
    select.selectByValue("\"0\""); //Loan Support in edit Miles Pathway Funding // Ensure to include the exact value here

    // OR: Select the option by visible text     // select.selectByVisibleText("Self support");

    WebElement selectedOption = select.getFirstSelectedOption();
    System.out.println("Selected option is: " + selectedOption.getText());

    ///---------------------Fee Recevied Status----------------------------------------//
    Thread.sleep(5000);
	//Alternative way to select the other options//
	WebElement feeReceivedstatus = driver.findElement(By.id("fee_received_status"));

    // Create a Select object for the dropdown
    Select selectstatus = new Select(feeReceivedstatus);
    Thread.sleep(2000);
    // Select the option by value
    selectstatus.selectByValue("\"2\""); //Payment Completed in edit Miles Pathway Funding // Ensure to include the exact value here



    WebElement selectedStatus = select.getFirstSelectedOption();
    System.out.println("Selected option is: " + selectedStatus.getText());
    Thread.sleep(4000);
    
    driver.findElement(By.xpath("//*[contains(@name, 'action_finance_fee_manage_submit')]")).click();
	Thread.sleep(2000);
	
	//------------------------Final Confirmation of Stage2 U11 Bucket--------------//
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_field_widget o_readonly_modifier o_required_modifier o_field_selection')]")).isDisplayed();
	System.out.println("Final Funding Type selected by Automation script is "+driver.findElement(By.xpath("//*[contains(@class, 'o_field_widget o_readonly_modifier o_required_modifier o_field_selection')]")).getText());
	Thread.sleep(2000);
	
	//--------------------------------Fee collect Date-------------------------//
//	driver.findElements(By.xpath("//*[contains(@class, 'o_datepicker_input o_input datetimepicker-input')]")).get(1).click();
	driver.findElement(By.id("ctp_fee_collect_date")).click();
	//input[@id='ctp_fee_collect_date']
	Thread.sleep(2000);

     driver.findElement(By.xpath("//*[contains(@class, 'day today')]")).click();
     Thread.sleep(4000);
     driver.findElement(By.xpath("//*[contains(@class,'o_field_widget o_readonly_modifier o_required_modifier o_field_selection')]")).click();
     Thread.sleep(2000);
     
//     driver.findElement(By.id("ctp_fee_collect_date")).isDisplayed();
//     
//     System.out.println("The Collected Date is"+driver.findElement(By.id("ctp_fee_collect_date")).getText());
   
     //--------------------------------Loan Sanction Date--------------------//
//     	driver.findElements(By.xpath("//*[contains(@class, 'o_datepicker_input o_input datetimepicker-input')]")).get(1).click();
// 		Thread.sleep(2000);
//
// 		driver.findElement(By.xpath("//*[contains(@class, 'day today')]")).click();
// 		Thread.sleep(2000);
 
 		driver.findElement(By.xpath("//*[contains(@name, 'action_finance_fee_manage_submit')]")).click();
 		Thread.sleep(4000);
}

public void U15BucketStage3ApprovingVISADetails() throws InterruptedException
{
	CandidateData1();
	Thread.sleep(5000);

	ScrollToVisaSlotU15();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(2500);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	
	Actions act = new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]"))).perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(3000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(2500);
	
	
}

public void U12BucketUSFundingType() throws InterruptedException
{	
	CandidateData();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_kanban_record_subtitle  kanban_tiles_subtitle')]")).click();
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	
	
	 WebElement paymentDropdown = driver.findElement(By.id("funding_type"));

     // Create a Select object for the dropdown
     Select select = new Select(paymentDropdown);

     // Select the option by value
     select.selectByValue("\"0\""); // Ensure to include the exact value here
     // select.selectByVisibleText("Self Payment");

     // Optional: Print selected option to verify
     WebElement selectedOption = select.getFirstSelectedOption();
     System.out.println("Selected option is: " + selectedOption.getText());
     
     //--------------------US Funding Status Selections----------------//
     Thread.sleep(5000);
     WebElement USFundingStatus = driver.findElement(By.id("fee_received_status_us"));

     // Create a Select object for the dropdown
     Select selectdropdown = new Select(USFundingStatus);

     // Select the option by value
     selectdropdown.selectByValue("\"2\""); // Ensure to include the exact value here
     // select.selectByVisibleText("Payment Completed");

     // Optional: Print selected option to verify
     WebElement selectedropoption = selectdropdown.getFirstSelectedOption();
     System.out.println("Selected option is: " + selectedropoption.getText());
     
    //------------------------Selecting Bank Name---------------------//
     
     driver.findElement(By.id("bank_id")).click();
     Thread.sleep(2000);
     driver.findElement(By.id("bank_id")).sendKeys("SBI");
     Thread.sleep(2000);
 	List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
 	Options.get(0).click();
 	Thread.sleep(2000);
 	 driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
     Thread.sleep(3500); 
     
}

public void U13ABucketStage1USFunding() throws InterruptedException, AWTException 
{
	CandidateData1();
	
	Thread.sleep(3000);

	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
     
}


public void DocumentCollectionforUSFundingDocuments() throws InterruptedException, AWTException

{	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();

//--------------------------------------Uploading Documents for Passport---------------------//
	driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(0).click();	
	
//	WebElement passportDocument = driver.findElement(By.className("o_file_input_trigger"));
//	passportDocument.click();
	
	
	WebElement passportDocument = driver.findElements(By.className("o_file_input_trigger")).get(0);			//----------Will be Uploading passport Document-----------//
	passportDocument.click();
	Thread.sleep(3000);
	
	 WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	 fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	 Thread.sleep(10000);

	    
		//-----------------------------------------Loan Sanction Letter----------------------------------------------------------------//
	 driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(2).click();	
	 WebElement LoanSanctionLetter = driver.findElements(By.className("o_file_input_trigger")).get(0);
	 LoanSanctionLetter.click();
	 Thread.sleep(3000);
	
	 WebElement fileInput2 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	 fileInput2.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	 Thread.sleep(10000);
	    
		//---------------------------------------------------Bank Balance Certificate-----------------------------------------------//
	    driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(4).click();	
	    WebElement BankBalanceCertificate = driver.findElements(By.className("o_file_input_trigger")).get(0);
	    BankBalanceCertificate.click();
	    Thread.sleep(3000);
	    
	    WebElement fileInput3 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
		 fileInput3.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
		 Thread.sleep(10000);
	
	//---------------------------------------------Financial Affidavit---------------------------------------------------------//
		
	    driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(6).click();	
	    WebElement FinancialAffidavit = driver.findElements(By.className("o_file_input_trigger")).get(0);
	    FinancialAffidavit.click();
	    Thread.sleep(5000);  
	    
	    WebElement fileInput4 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
		 fileInput4.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
		
	    Thread.sleep(10000);
	    
	    
	    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
	     Thread.sleep(1500);   
	    
}


public void U13ABucketStage2USFunding() throws InterruptedException, AWTException
{
	CandidateData1();
	
	Thread.sleep(2000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
     
}

public void ApprovingCollectedDocumentsU13A() throws InterruptedException
{
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();

	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(2000); 

    		//--------------------Negative Flow where not able to save without Verifying the Documents------------------------//
	driver.findElements(By.xpath("//*[contains(@class, 'modal-body')]")).get(1).isDisplayed();
	System.out.println("Error Message is "+driver.findElements(By.xpath("//*[contains(@class, 'modal-body')]")).get(1).getText());
	Thread.sleep(1000);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary o-default-button')]")).get(1).click();
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
    Thread.sleep(2500); 
    
    //----------------------------------Back to Positive Flow where approving the Documents--------------------//
  
    driver.findElement(By.xpath("//*[contains(@name, 'student_document_line')]")).click();
   Thread.sleep(2000);
   
    Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
	Thread.sleep(2000);
	
	//--------------------------Verifying Uploaded BankBalance--------------------------//
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(1500);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	
	//--------------------------Verifying Uploaded Passport--------------------------//
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(1500);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	
	//--------------------------Verifying Uploaded Loan Sanction--------------------------//
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(1500);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	
	//--------------------------Verifying Uploaded Financial Affidavit--------------------------//
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000); 
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(1500);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
 
    Actions act2 = new Actions(driver);
   	act2.moveToElement(driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]"))).perform();
   	Thread.sleep(2000);
 
   	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_student_document_collection_submit')]")).click();
    Thread.sleep(3500);
   	
}
public void U13BBucketSkipFinancialStage1() throws InterruptedException

{

	CandidateData1();
		
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_orange_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_orange_color btn-secondary')]")).click();
	
    Thread.sleep(1500);
}

public void U13BBucketStage2()throws InterruptedException, AWTException
{
	CandidateData1();
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Stage is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(2000);
	
	driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(0).click();	
	
	WebElement USFinaceProof = driver.findElements(By.className("o_file_input_trigger")).get(0);
	USFinaceProof.click();
    Thread.sleep(5000);  
    
    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	 fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	
   
	Thread.sleep(10000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(1500); 
}

public void U13BBucketStage3() throws InterruptedException
{

	CandidateData1();
	
	Thread.sleep(3000);
	
			//----------------------------------Approvving US Finace Proof------------------------//
	driver.findElement(By.xpath("//*[contains(@name, 'student_document_line')]")).click();
	Thread.sleep(2000);
	   
	    Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
		Thread.sleep(2000);
	
		
		driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
		Thread.sleep(1500);
		driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
		System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
		
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@name, 'action_student_document_collection_submit')]")).click();
		Thread.sleep(3000);	
}


public void U13CBucketStage1() throws InterruptedException, AWTException
{

	CandidateData1();
	Thread.sleep(3000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());

	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	//-----------------------------Uploading Copy Of I20 Documents-----------------//
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(1000);
	
	driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(0).click();	
	Thread.sleep(2000);
	WebElement passportDocument = driver.findElement(By.className("o_file_input_trigger"));
	passportDocument.click();
	
	  Thread.sleep(5000);  
	    
	    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
		 fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
		
	Thread.sleep(10000);
	
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(1500); 
}
public void U13CBucketStage2() throws InterruptedException

{	
	CandidateData1();
	Thread.sleep(3000);
	
	//----------------------------------Approvving US I20 Proof------------------------//
driver.findElement(By.xpath("//*[contains(@name, 'student_document_line')]")).click();
Thread.sleep(2000);
   
    Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
	Thread.sleep(2000);

	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(1500);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[contains(@name, 'action_student_document_collection_submit')]")).click();
	Thread.sleep(3000);	
	
}

public void U14BucketStage1() throws InterruptedException
{
	CandidateData1();
	Thread.sleep(3000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn oe_subtotal_footer button_orange_color btn-secondary')]")).click();
	
	
}

public void U14BucketStage2() throws InterruptedException, AWTException
{
	CandidateData1();
	Thread.sleep(3000);
	
	//-----------------------------Uploading DS160 Documents--------------------//
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(2000);
	
	driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(0).click();	
	
	Thread.sleep(2000);
	
	WebElement DS160Document = driver.findElement(By.className("o_file_input_trigger"));
	DS160Document.click();
	
	  Thread.sleep(5000);  
	    
	    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
		 fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	Thread.sleep(10000);
	
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(1500); 	
	
	
}

public void U14BucketStage3() throws InterruptedException
{
	CandidateData1();
	Thread.sleep(3000);
			//-------------------------------------Approving DS160--------------------------//
	driver.findElement(By.xpath("//*[contains(@name, 'student_document_line')]")).click();
	Thread.sleep(2000);
	   
	    Actions act1 = new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
		Thread.sleep(2000);
	
		driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
		Thread.sleep(1500);
		driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
		System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
		
		
		driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(@name, 'action_student_document_collection_submit')]")).click();
		Thread.sleep(3000);	
}

public void U15BucketStage1MandateFeilds() throws InterruptedException
{
	CandidateData1();
	Thread.sleep(3000);

	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

	//---------------------------------Negative FLow For Mandate Feilds---------------//
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_submit_visa_slot_verification')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@class, 'o_notification o_notification_fade border border-danger bg-white mb-2 position-relative o_notification_fade-enter-active')]")).isDisplayed();
	System.out.println("Error Accored for Mandate Feilds "+driver.findElement(By.xpath("//*[contains(@class, 'o_notification o_notification_fade border border-danger bg-white mb-2 position-relative o_notification_fade-enter-active')]")).getText());
}

public void TooBookVISASlot() throws InterruptedException, AWTException
{
	driver.findElement(By.xpath("//*[contains(@title, 'Meetings')]")).click();
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@role, 'menuitem')]")).get(2).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary o_list_button_add')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("job_position")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("job_position")).clear();
	Thread.sleep(2000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(0).sendKeys("Visa Support Expert");
	Thread.sleep(2000);

	List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options1.get(0).click();
	Thread.sleep(2000);
	
		driver.findElement(By.id("emp_id")).click();
	Thread.sleep(3000);
	driver.findElement(By.id("emp_id")).sendKeys("Syed Pasha");
	Thread.sleep(3000);
	
	List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options.get(0).click();
Thread.sleep(3000);
	
	driver.findElement((By.xpath("//*[contains(@class, 'o_datepicker_input o_input datetimepicker-input')]"))).click();
	Thread.sleep(2000);

 // Get tomorrow's date
    LocalDate tomorrow = LocalDate.now().plusDays(1);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String tomorrowDate = tomorrow.format(formatter);

    //XPath using the calculated date
    String xpath = String.format("//td[@data-action='selectDay' and @data-day='%s']", tomorrowDate);


    WebElement dateElement = driver.findElement(By.xpath(xpath));
    dateElement.click();
  //----------------------------------------------------------------------------------//
    Thread.sleep(2000);
	WebElement button = driver.findElement(By.xpath("//a[@role='button' and text()='Add a line']"));
    button.click();
    Thread.sleep(2000);
    WebElement session =  driver.findElement((By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_list_many2one o_required_modifier')]")));
    session.click();
    Thread.sleep(3000);
 
    driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(2).sendKeys("VISA Mock Session");
    Thread.sleep(3000);
    List <WebElement> ADDLINE = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
    ADDLINE.get(0).click();
    Thread.sleep(3000);

    //----------Changing Slot time---------//
    driver.findElements(By.xpath("//*[contains(@class, 'o_data_cell cursor-pointer o_field_cell o_required_modifier')]")).get(0).click();
    Thread.sleep(2000);
    Actions act = new Actions(driver);
    WebElement DoubleClick =  driver.findElements(By.xpath("//*[contains(@class, 'fa fa-chevron-up')]")).get(0);
    act.doubleClick(DoubleClick).perform();
    

    
    
    
    WebElement Description = driver.findElement(By.id("description"));
    Description.click();
    Thread.sleep(2000);
    Description .sendKeys("Adding Note From Autoamtion Script");
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("//*[contains(@class, 'o_form_button_save btn btn-light py-0')]")).click();//To Save Button//
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[contains(@class, 'btn btn-primary')]")).click(); //To confimring Allocation//
    Thread.sleep(2000);
    driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click(); 
    Thread.sleep(2000);
 
}


public void U16Bucket() throws InterruptedException
{
	CandidateData1();
	Thread.sleep(5000);
	
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).isDisplayed();
	System.out.println("Blue Button 1 is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_blue_color btn-secondary')]")).getText());
	
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());

}


public void U15BucketStage2UploadingVISADetails() throws InterruptedException, AWTException

{
	CandidateData1();
	Thread.sleep(3000);
	
		////-------------------------Uploading VISA SLOT Details and Documents----------------------//
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	
	driver.findElement(By.id("visa_city_id")).click();
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@class, 'o-autocomplete--input o_input')]")).get(2).sendKeys("Dubai");
	Thread.sleep(2000);
	List <WebElement> Options1 = driver.findElements((By.xpath("//*[contains(@class, 'o-autocomplete--dropdown-menu dropdown-menu ui-widget ui-autocomplete show')]")));
	Options1.get(0).click();
	
	
	Thread.sleep(3000);
		//--------------------------------VISA Slot Date-------------------------//
		driver.findElements(By.xpath("//*[contains(@class, 'o_datepicker_input o_input datetimepicker-input')]")).get(1).click();
		Thread.sleep(2000);

	     driver.findElement(By.xpath("//*[contains(@class, 'day today')]")).click();
	     Thread.sleep(2000);
	
	     driver.findElement(By.xpath("//*[contains(@title, 'Close the picker')]")).click(); 
	     Thread.sleep(3000);
	     //---------------------------VISA SLOT PROOF---------------------------//
	     
	 	WebElement VisaSlotDocument = driver.findElement(By.className("o_file_input_trigger"));
	 	VisaSlotDocument.click();
		  Thread.sleep(5000);  
		    
		    WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
			 fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
		Thread.sleep(10000);
	
		driver.findElement(By.xpath("//*[contains(@name, 'action_submit_visa_slot_verification')]")).click();
	    Thread.sleep(1500); 
	     
}


public void U16VisaRecevied() throws InterruptedException
{
	CandidateData1();
	Thread.sleep(5000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).isDisplayed();
	System.out.println("Red Button 1 is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).getText());
	
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).get(1).isDisplayed();
	System.out.println("Red Button 2 is "+driver.findElements(By.xpath("//*[contains(@class, 'btn button_red_color btn-secondary')]")).get(1).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	//---------------------------------------------Visa Received---------------------//
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	
}

public void U17Stage1UploadingVISA() throws InterruptedException, AWTException
{
	CandidateData1();
	Thread.sleep(5000);
	
	driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercase')]")).get(0).isDisplayed();
	System.out.println("Current Candidate is in "+driver.findElements(By.xpath("//*[contains(@class, 'btn o_arrow_button_current o_arrow_button disabled text-uppercas')]")).get(0).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).isDisplayed();
	System.out.println("Light Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn btn-danger btn-primary')]")).isDisplayed();
	System.out.println("Red Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn btn-danger btn-primary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).isDisplayed();
	System.out.println("Yellow Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_yellow_color btn-secondary')]")).getText());
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).isDisplayed();
	System.out.println("Brown Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_brown_color btn-secondary')]")).getText());
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_orange_color btn-secondary')]")).click();
	
	Thread.sleep(2000);
	driver.findElements(By.xpath("//*[contains(@name, 'doc_attachment_ids')]")).get(0).click();	
	
	Thread.sleep(4000);
	
	WebElement VISAProofDocument = driver.findElement(By.className("o_file_input_trigger"));
	VISAProofDocument.click();
	
	 Thread.sleep(5000);  
	    
	 WebElement fileInput1 = driver.findElements(By.xpath("//input[@type='file']")).get(0);
	 fileInput1.sendKeys("C:\\Users\\Automation\\Pictures\\MASATTACHEMENT.jpg");
	 Thread.sleep(10000);

	
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-primary')]")).get(1).click();
    Thread.sleep(1500); 
}

public void U17Stage2ApprovingVISA() throws InterruptedException
{

	CandidateData1();
	Thread.sleep(5000);
	
	//-------------------------------------Approving VISA--------------------------//
driver.findElement(By.xpath("//*[contains(@name, 'student_document_line')]")).click();
Thread.sleep(2000);
   
    Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//*[contains(@name, 'telephony_call_logs')]"))).perform();
	Thread.sleep(2000);

	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-sm btn-warning')]")).get(0).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_approve')]")).click();
	Thread.sleep(2500);
	driver.findElements(By.xpath("//*[contains(@class, 'btn btn-secondary')]")).get(2).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).isDisplayed();
	System.out.println("Green Button is "+driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).getText());
	
	
	driver.findElement(By.xpath("//*[contains(@class, 'btn button_green_color btn-secondary')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[contains(@name, 'action_student_document_collection_submit')]")).click();
	Thread.sleep(3000);
	
}
	public void U17Test() throws InterruptedException
	{
		//driver.findElement(By.xpath("//*[contains(@class, 'btn btn-light o_switch_view o_list oi oi-view-list')]")).click();
		ListView.click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.className("o_searchview_input")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("o_searchview_input")).sendKeys("Automation-User1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class, 'o_menu_item dropdown-item focus')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@name, 'can_id')]")).click();
		Thread.sleep(5000);
	}
	
	
	
	
//	public void VerifyAdminDropdownoptions()
//	{
//		
//		driver.findElement(By.className("dropdown-toggle")).click();
//		List <WebElement> Options = driver.findElements((By.xpath("//*[contains(@class, 'dropdown-item o_app')]")));
//		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class, 'dropdown-item o_app')]")).isDisplayed());
//		
//		Assert.assertEquals(Options.get(0).getText(), "USP Eligibility");
//		Assert.assertEquals(Options.get(1).getText(), "Miles ATS");
//		Assert.assertEquals(Options.get(2).getText(), "Miles Recruitments");
//		Assert.assertEquals(Options.get(3).getText(), "Helpdesk");
//		Assert.assertEquals(Options.get(4).getText(), "Discuss");
//		Assert.assertEquals(Options.get(5).getText(), "Calendar");
//		Assert.assertEquals(Options.get(6).getText(), "My Dashboard");
//		Assert.assertEquals(Options.get(7).getText(), "Job Queue");
//		Assert.assertEquals(Options.get(8).getText(), "Contacts");
//		Assert.assertEquals(Options.get(9).getText(), "Dashboards");
//		Assert.assertEquals(Options.get(10).getText(), "Surveys");
//		Assert.assertEquals(Options.get(11).getText(), "Employees");
//		Assert.assertEquals(Options.get(12).getText(), "Apps");
//		Assert.assertEquals(Options.get(13).getText(), "Settings");
//	}
	/*
	 * Method to click on Add Coach button
	 */
	
//	 public void VerifyUserLevelOptions() throws InterruptedException
//		{
//			Select UserLevelDropDown = new Select(driver.findElement(By.xpath("//*[contains(@title, 'Configuration')]")));
//			
//		
//			List<String> ConvertedList = new ArrayList<String>();
//			
//			
//			List<WebElement> ActualLevelsList=UserLevelDropDown.getOptions();
//			Thread.sleep(2000);
//				
//			for(int i = 0 ;i<ActualLevelsList.size();i++)
//			{
//				// Just print this for Debug purpose
//				System.out.println("Debug : -> Item "+i+" : "+ActualLevelsList.get(i).getText());
//			//	System.out.println("Debug : -> Expected List Item "+i+" : "+ExpectedUserList.get(i));
//				ConvertedList.add(ActualLevelsList.get(i).getText());
//				
//			//Assert.assertTrue(ConvertedList.get(i).equals(ExpectedUserList.get(i)),"Expected is "+ExpectedUserList.get(i)+" Actual is "+ConvertedList.get(i));
//
//			}
//			
//			//Assert.assertTrue(ConvertedList.equals(ExpectedUserList),"Not Equal");
//		
//			for(int j = 0 ;j<ActualLevelsList.size();j++)
//			{
//				Assert.assertTrue(ConvertedList.get(j).equals(ExpectedUserList.get(j)),"Expected is "+ExpectedUserList.get(j)+" Actual is "+ConvertedList.get(j));
//			}	
//		}
//
//	private List<String> ExpectedUserList = Arrays.asList("Allocation Configurations",
//            "Enrollment Batches",
//            "Enrollment University",
//            "Buckets",
//            "Enrollment Course",
//            "ATS Journey",
//            "LOR Question",
//            "Graduation Division",
//            "Pathway College",
//            "Sessions",
//            "Document Type",
//            "MSA Document Type",
//            "DS-160 Step",
//            "Ineligible Reason");
	
//	public void ClickOnAddUserButton()
//	{
//		AddNewUserBtn.click();
//	}
//		
//	
//	
//	public void VerifyIfSearchedUserAppeared(String email)
//	{
//		Assert.assertEquals(UserRecords.get(1) .getText(), email,"User Found");
//	}
//	
//	public void VerifyEmailIdPopUpisDisplayed()
//	{
//		Assert.assertEquals(EmailIdPopUp.getText(),"Email Address","Email ID Pop Up is Displayed");
//	}
//	
//	public void WaitForAdminPageToLoad()
//	{
//		MilesUtilities.WaitForVisibilityOfElement(driver, "id", "addNewTrainerBtn");
//	}
//	
//	public void SelectDisplyedUser()
//	{
//		UserRecords.get(0).click();
//	}
//	public void EnterUserInfo(String info) throws InterruptedException
//	{
//		UserSearchBox.click();
//		UserSearchBox.sendKeys(info);
//		Thread.sleep(1000);	
//		ButtonSearch.click();
//		Thread.sleep(3000);	
//	}
//	public void Enter_FHP_UserInfo(String info) throws InterruptedException
//	{
//		UserSearchBox.click();
//		UserSearchBox.sendKeys(info);
//		Thread.sleep(2000);	
//		
//	}
//	
//	
//	public void SelectDisplayedUser()
//	{
//		EmailFeild.click();
//	}
//	
//	public String getEmailFeildText()
//	{
//		return EmailFeild.getText();
//	}
//	
//	public void GenerateCombinedEDF()
//	{
//		GenerateCombinedEDF.getText();
//	}
//	
//	public void VerifyAdminPanelElement() throws InterruptedException
//	{ 
//		
//		
//	//  Assert.assertTrue(SearchBox.isDisplayed(),"Search box not displayed"); 
//	  Assert.assertTrue(AddNewUserBtn.isDisplayed(),"Add user");
//	  Thread.sleep(2000);
//	  Assert.assertTrue(Tableheader.isDisplayed(),"Tab header"); 
//	  
//	  driver.findElement((By.xpath("//*[contains(@class, 'sidebar-toggle')]"))).click();
//	  Thread.sleep(2000);
//	  
//	  
//	  String LUD = driver.findElement(By.id("liveUserDashboardBtn")).getText();
//	  System.out.println("The Button Text is "+LUD);
//	  Assert.assertEquals(driver.findElement(By.id("liveUserDashboardBtn")).getText(),"Live User Dashboard");
//	  
//	  String CP = driver.findElement(By.xpath("//div[contains(text(),'Cloud Platform')]")).getText(); 
//	  System.out.println ("Text is "+CP); 
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Cloud Platform')]")).getText(),"Cloud Platform");
//	  
//	  String SrlNo = driver.findElement(By.xpath("//div[contains(text(),'S. No.')]")).getText();
//	  System.out.println("Text is "+SrlNo);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'S. No.')]")).getText(),"S. No.");
//	  
//	  String Name = driver.findElement(By.xpath("//div[contains(text(),'Name')]")).getText();
//	  System.out.println("Text is "+Name);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Name')]")).getText(),"Name");
//	  
//	  String Email = driver.findElement(By.xpath("//div[contains(text(),'Email')]")).getText();
//	  System.out.println("Text is "+Email);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Email')]")).getText(),"Email");
//	  
//	  String UL = driver.findElement(By.xpath("//div[contains(text(),'User Level')]")).getText();
//	  System.out.println("Text is "+UL);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'User Level')]")).getText(),"User Level");
//	  
//	  String Report = driver.findElement(By.xpath("//div[contains(text(),'Report')]")).getText();
//	  System.out.println("Text is "+Report);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Report')]")).getText(),"Report");
//	  
//	  String LiveECG = driver.findElement(By.xpath("//div[contains(text(),'Live ECG')]")).getText();
//	  System.out.println("Text is "+LiveECG);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Live ECG')]")).getText(),"Live ECG");
//	  
//	  String MD = driver.findElement(By.xpath("//div[contains(text(),'More Details')]")).getText();
//	  System.out.println("Text is "+MD);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'More Details')]")).getText(),"More Details");
//	  
//	 }	
//	
//	
//	public void Verify_FHP_AdminPanelElement() throws InterruptedException
//	{ 
//	 // Assert.assertTrue(SearchBox.isDisplayed(),"Search box not displayed"); 
//	  Assert.assertTrue(AddNewUserBtn.isDisplayed(),"Add user");
//	  Thread.sleep(2000);
//	 // Assert.assertTrue(LiveUserDashboardBtn.isDisplayed(),"Live user dash board button"); 
//	  
//	  Assert.assertTrue(Tableheader.isDisplayed(),"Tab header"); 
	  
//	  String LUD = driver.findElement(By.id("liveUserDashboardBtn")).getText();
//	  System.out.println("The Button Text is "+LUD);
//	  Assert.assertEquals(driver.findElement(By.id("liveUserDashboardBtn")).getText(),"Live User Dashboard");
//	  
//	 
//	  
//	  String SrlNo = driver.findElement(By.xpath("//div[contains(text(),'S. No.')]")).getText();
//	  System.out.println("Text is "+SrlNo);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'S. No.')]")).getText(),"S. No.");
//	  
//	  String Name = driver.findElement(By.xpath("//div[contains(text(),'Name')]")).getText();
//	  System.out.println("Text is "+Name);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Name')]")).getText(),"Name");
//	  
//	  String Email = driver.findElement(By.xpath("//div[contains(text(),'Email')]")).getText();
//	  System.out.println("Text is "+Email);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Email')]")).getText(),"Email");
//	  
//	  
//	  String LiveECG = driver.findElement(By.xpath("//div[contains(text(),'Live ECG')]")).getText();
//	  System.out.println("Text is  "+LiveECG);
//	  Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Live ECG')]")).getText(),"Live ECG");
//	  
//	 }


	

	
}

