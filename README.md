"# 100dayOfCode" 
# 100dayOfCode

100daysOfCode challenge:
https://github.com/rajguruatul/100dayOfCode.git

AIM to learn:
	1) Learn framework Designing
	2) selenium frameworks:
		- POM
		- keywork
		- DataDriven
		- BDD
	3) TestNG
	4) ExtentReports
	5) ExcelReadWrite
	6) CoreJava
	7) Collections - JAVA
	8) Java 8 features
	9) selenium 4 features
	10) Implementing as many selenium concepts as possible.
	11) GIT



------------------------------
Day 1/100:
------------------------------

**Referring Raghav Pal tutuorial for this:

Started creating a POM framework for Selenium with Java:	

-----------
Application facebook:
----------
Installed a new IDE intellij  - wanted to try something new other than eclipse
Created a Maven Project with following Dependencies:
	- selenium jars
	- WebDriverManager
	- TestNG
	- extentReports

------------------------------
created the following flow:
------------------------------

Test file -> BaseSetup -> page-> ChromeDriver -> test execution -> testNG report for fail/pass status

	- BaseSetup(include initialising the webdriver and closing after the test is performed)
	- Test file -> with actual test
	- Pages - where the Webelements are located for everypage along with common actions like enter details/pressKey/verify some element /verify some actions
	
Progress till now:	
	
Login and Home Pages are created as of now.
also was able to post "HelloWorld" status on Homepage.


	
----------------
Day 2/100:
----------------
Code:
	
	Started again with CORE JAVA concepts
	(Referring Bhanu Paratp's Core Java tutuorials)
	 Created java function to read Excel File using javaApache POI jars
	 
----------------
Day 3/100:
----------------
Code:
	- Learned TestNG implementation 
		@test level - using @Test tag in java class
		@Class level - using @Listeners (listeners.TestNGListener.class) before Javal class declaration
		@Class level - using multiple class tags
						    <class name="listeners.TestNGDemo"></class>
							<class name="listeners.TestNGDemo1"></class>
		@Package level - using the TestNG XML file
		Used @DataProvider(name="testData") and     @Test(dataProvider = "testData") for ExcelUtils
	 
----------------
Day 4/100:
----------------
Code:
	- Learned TestNG implementation 
			- learned to use priority parameter and
			- also how to use parameterized values for tests
	 
----------------
Day 5/100:
----------------
Code:
		More on TestNG - Groups:
			parallel Execution 
			executing tests from groups
			include / exclude groups
			creating MetaGroups
			using regular expression
			using groups at class level
	 
----------------
 Day 6/100:
----------------
Code:
		TestNG Dependencies
		@Ignore tag
		Rerun failed tests
		

----------------
 Day 7/100:
----------------
Code:
	Selenium Wait:
		Thread.sleep
		Implicit wait
		Explicit wait
		Fluent wait
		
		All waits are implemented using examples

----------------
 Day 8/100:
----------------
Code:
	Headless Browser
	Automation Engineer Level1
	
----------------
 Day 9/100:
----------------
Code:
	AutoIt example - used javascriptExecutor to click a <input> tag
	Bhanu Pratap videos for 
		Constructor
		this keyword
		static keyword
		
----------------		
Day 10/100: #100DaysOfCode
----------------
Code:
			Implemented #Actions class for handling mouse and keyboard events :
			- DoubleClick
			- RighClick
			- DragAndDrop
			- ToolTip
			- Keyboard commands

also created a quickie info page for #Actions class - zoom for details
		
----------------		
Day 11-12/100: #100DaysOfCode
----------------
Code:
		Working on datePicker 

	

		
		

