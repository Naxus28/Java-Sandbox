/**
 * 
 * @author gabrielferraz
 * Steps to turn on assertions:
 
  	Turning assertions on per project:
	1.	In the main horizontal menu, select “Run”
	2.	Within the “Run” menu, select “Run Configurations”
	3.	In the dialog box that opens, select “Java Application” on the left hand menu
	4.	Press the “new” button (represented by an icon of a file with the “+” sign) on the top of the menu. This will open a set of tabs on the right hand side that will allow us to create a new launch configuration for this Java project 
	5.	Click on tab “Arguments” and on the text area labeled “VM arguments” enter this argument “-ea”
	6.	Apply the changes (if you have an assertion on your project you can click “Run” to test if the new launch configuration is working)
	
	Turning assertions on globally:
	1.	open the “eclipse” tab on the main horizontal menu
	2.	click on “preferences”
	3.	click on the “Java” option
	4.	click in “Installed JREs”
	5.	select the JRE installed and click “edit”
	6.	on the window that opens, add “-ea” to the input field “Default VM arguments”
	7.	click “finish”

 */


public class AssertionTests {

	public static void main(String[] args) {
		System.out.println("Testing assertions: ");
		assert false : "this line will print if assertions are turned on";
	}

}
