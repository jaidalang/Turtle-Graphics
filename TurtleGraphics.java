//J.Langham
//HW 1 - Turtle Graphics
//create Turtle Graphics object in Turtle.java
//PLAN: taking in all the commands then executing after they have all been acquired then displaying on program exit. 

import java.util.Scanner; // for user input
import java.lang.Math; // for random number generator

public class TurtleGraphics // create TurtleGraphics Class
{
	
	int SIZE = 20; // size of the drawing area	
	int floor[][]; // array representing the floor 
	//int commandArray[];
	int commandArray[][]; // multi dimensional array holding list of commands
	//store commands in a 2d array - Each row is a command via user input, the column will hold forwarding steps (distance tracker) 
	
	int count; // current number of commands, keep track
	int turtx; // xPostion of turtle
	int turty; // yPosition of turtle
	
	public void Input() // create Input method to grab user input
	{
		count = 0; //keep track of executed arrays
		commandArray = new int [200][2]; // hold the commands made by user (200 commands maX)
		floor = new int[20][20]; // 20 x 20 floor
		
		//create scanner for input
        Scanner in = new Scanner(System.in);
		System.out.print("Enter a proper command option (1-9): ");
		int inputCommand = in.nextInt(); // user input variable
		
		//if (inputCommand >= 9 || inputCommand < 1 || count >= 200)
		//{ Execution();} //exception
		
		//program will continue to get commands only if input != 9 
		while( inputCommand != 9) // automatically ends program if == 9. 
		{
			// row of the array will hold an inputted command corresponding with count
			commandArray[count][0] = inputCommand; 
			
			// prompt for number of forward spaces
			if (inputCommand == 5 )
			{
				//column for each command of 5 will hold the inputted forwarding spaces
				System.out.print("Specify number of spaces forward:  ");
				commandArray[count][1]= in.nextInt();
				//commandArray [count, 1 ] = FW; 
			}//end 
			
			count++; // increment count - go to new row
			
			//ERROR DETECTION
			if (inputCommand > 9 || inputCommand < 1)
			{ System.out.println("-----ERROR: Enter a PROPER command-----\n");}
			
			//user enters in command, while loop continues  
			System.out.print("Enter a proper command option (1-9): ");
			inputCommand = in.nextInt();
		}//end of while
		
		//call execution function
		Execution();
	} //end of method
	
	public void Execution() //Execution method to execute commands that have been captured
	{
		int commandNumber = 0; //current position in the command Array
		int direction = 90; // direction turt is facing
		int distance = 0; // distance/steps want to travel
		int command; //current command
		boolean penDown = false; //set pen to be facing up
		turtx = 0; //x position for turtle
		turty= 0;  // y position for turtle
		
		command = commandArray[commandNumber][0];//start with first command in array
		while (commandNumber < count) // continue until reach end
		{
			switch( command ) //list of commands coinciding with printed menu 
			{
				case 1: //pen up
					penDown = false; 
					break; 
				case 2: //pen down 
					penDown = true; 
					break;
				case 3: //turn right
					//clockwork / degrees reference in direction
					if (direction == 90)
					{
						direction = 180; 
						//Right -> Down
					}
					else if (direction == 180)
					{
						direction = 270; 
						//Down -> Left
					}
					else if (direction == 270)
					{
						direction = 360; 
						//Left -> Up
					}
					else if (direction == 360)
					{
						direction = 90; 
						//Up -> Right
					}
					
					break;
				case 4: //turn left
					//clockwork / degrees reference in direction
					if (direction == 90)
					{
						direction = 360; 
						//Right -> Up
					}
					else if (direction == 360)
					{
						direction = 270; 
						//Up -> Left
					}
					else if (direction == 270)
					{
						direction = 180; 
						//Left -> Down
					}
					else if (direction == 180)
					{
						direction = 90; 
						//Down -> Right
					}
					
					break; 
				case 5: //move turtle
					//focus on column 1 to take into account number of spaces forward
					distance = commandArray[commandNumber][1];
					MoveTurt (penDown, floor, direction, distance);
					break; 
				case 6: //display
					System.out.print( "\nWALLAH!\n"); 
					Display(floor);
					break; 
				case 7: //display
					System.out.print( "\nSURPRISE!\n"); 
					fancyDisplay(floor);
					break; 
				case 8: //display
					System.out.print( "\nW000AH SURPR1SE!\n"); 
					binaryDisplay(floor);
					break; 
				} // end of switch
		
				command = commandArray[ ++commandNumber][0];// onto the next command in array
			} // end of while
		} // end of method
		

	
	public void MoveTurt( boolean down, int arr[][], int dir, int dist)//move turtle method to actually move the turtle and reflect movements in all coexisting variables
	{
		int m; //move loop variable - keeps track of where turtle is in comparison to its coordinates (x & y) 	
		
		//switch based on direction (90 right,180 down,270 left,360 up) 
		switch (dir)
		{
		//DOWN & RIGHT are positive, so must compare to SIZE (20)
		//UP & LEFT are negative, so must compare to 0 
			
			case 90: // move right = positive
			//while j <= number of steps forward, and yPos + j < 20 (doesnt go off the board)... 
				for (m = 1; m <= dist && turty + m < SIZE; ++m)
				{
					//if pen is down, then change to a 1 to mark turtles path 
					if (down)
					{ arr[turtx][turty+m] = 1; }
				} // end of for
				turty += m - 1; 
				break; 
			case 180:	 // move down = positive
			//while j <= number of steps forward, and xPos + j < 20 (doesnt go off the board)... 
				for (m = 1; m <= dist && turtx + m < SIZE; m++)
				{
					//if pen is down, then change to a 1 to mark turtles path 
					if (down)
					{ arr[turtx + m][turty] = 1; }
				} // end of for
				turtx += m - 1; 
				break; 
	
			case 270: // move left = negative
			//while j <= number of steps forward, and yPos + j < 20 (doesnt go off the board)... 
				for (m = 1; m <= dist && turty - m >=0; m++)
				{
					//if pen is down, then change to a 1 to mark turtles path 
					if (down)
					{ arr[turtx][turty-m] = 1; }
				} // end of for
				turty -= m - 1; 
				break; 
			case 360: // move up = negative
			//while j <= number of steps forward, and yPos + j < 20 (doesnt go off the board)... 
			for (m = 1; m <= dist && turtx - m >=0; m++)
				{
					//if pen is down, then change to a 1 to mark turtles path 
					if (down)
					{ arr[turtx - m][turty] = 1;}
				} // end of for
				turtx -= m - 1; 
				break; 
		} // end of switch
	}// end of method



//Display the array section 
// for loops with i & j are used because arrays are two-dimensional and full iteration is needed to display properly. 
//Currently 20x20 array is comprised of 0s and 1s


//Display with asterisks and spaces 	
	public void Display(int t[][])
	{
		for (int i = 0; i < SIZE; ++i)
		{
				for (int j = 0; j < SIZE ; ++j) // display array
				//if == 1, put an *, if not, put a space
				{System.out.print( (t[i][j] == 1 ? "*": " "));}				
			System.out.println();				
		}
	}//end of method

//Display the array in its original form (0s and 1s) 	
	public void binaryDisplay(int t[][])
	{
		for (int i = 0; i < SIZE; ++i)
		{
				for (int j = 0; j < SIZE ; ++j) // display array
				//if == 1, put an *, if not, put a space
				{System.out.print(t[i][j]);}				
			System.out.println();				
		}
	}//end of method

//Display the array with a surprise	
	public void fancyDisplay(int t[][])
	{
		int number = (int)(Math.random()*3 + 1); //generate random integer from 1-3
		//switch based on number (1,2,3)
		switch (number)
		{
			case 1: 
			for (int i = 0; i < SIZE; ++i)
			{
			for (int j = 0; j < SIZE ; ++j) // display array
				//if == 1, put an @, if not, put a space
				{System.out.print( (t[i][j] == 1 ? "@": " "));}				
			System.out.println();				
		    }
		    break;
		    
		    case 2: 
		    for (int i = 0; i < SIZE; ++i)
			{
			for (int j = 0; j < SIZE ; ++j) // display array
				//if == 1, put an ^, if not, put a space
				{System.out.print( (t[i][j] == 1 ? "^": " "));}				
			System.out.println();				
			}
			break;
			
			case 3:
			for (int i = 0; i < SIZE; ++i)
			{
			for (int j = 0; j < SIZE ; ++j) // display array
				//if == 1, put an $, if not, put a space
				{System.out.print( (t[i][j] == 1 ? "$": " "));}				
			System.out.println();				
			}
			break;
		
		}//end of switch
	
	}//end of method
} // end of TurtleGraphics


					
					
	