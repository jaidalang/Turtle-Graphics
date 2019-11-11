//J.Langham
//HW 1 - turtle graphics
//This program uses TurtleGraphics.java file as well.
//This program will receive multiple directional commands from a user and output the results per program exit 
// via a 20x20 array

public class Turtle
{
	public static void main (String[] args)
	{
		//print out command options
		printMenu(); 
		//create TurtleGraphics object
		TurtleGraphics drawing = new TurtleGraphics();
		drawing.Input();
	} // end of main
	
	private static void printMenu() {
		System.out.println("Commands List:\n\n"
						+ "\t1 Pen up\n"
						+ "\t2 Pen down\n"
						+ "\t3 Turn right\n"
						+ "\t4 Turn left\n"
						+ "\t5 Move forward spaces based on next input number\n"
						+ "\t6 Display the 20-by-20 array\n"
						+ "\t7 Display the 20-by-20 array with a surprise twist\n"
						+ "\t8 Display the original 20-by-20 array in binary form\n"
						+ "\t9 END OF COMMAND ENTRY - DISPLAY AND QUIT\n"
						+ "\t MAXIMUM OF 200 COMMANDS ALLOWED\n"
						+ "\tFor some fun.. try: 1  5,5  2  5,5  3  5,12  3  5,5  3  5,2,  1, 7, 9\n\n"
						+ "What letter do you see.......? (: \n");
	}//end of method
}// end of Turtle class
