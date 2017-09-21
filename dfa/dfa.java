import java.util.Scanner;
import java.lang.*;

public class DFA 
{
	public static void main(String[] args)
	{
		boolean cont = true;
		String inp = "";
		while(cont)
		{
			Scanner read = new Scanner(System.in);
			System.out.println("Would you like to enter a string? (y/n): ");
			inp = read.nextLine();
			
			if(inp.equals("y"))
			{
				System.out.println("Please enter a string: ");
				inp = read.nextLine();
				System.out.println("Input String: " + inp);
				testString(inp);
				cont = false;
			}
			else if(inp.equals("n"))
			{
				cont = false;
			}
			else
			{
				System.out.println("You must enter 'y' for yes, or 'n' for no.");
			}
		}
	}
	
	public static void testString (String test)
	{
		char[] chars = test.toCharArray();
		String currString = "";
		int state = 0;
		
		System.out.println("Starting state: q0");
		for(char i: chars)
		{
			System.out.println("Current character: " + i);
			if(state == 0)
			{
				if(i == 'w')
				{
					state = 1;
					printState(state);
				}
				else if(Character.isLetter(i) && i != 'w')
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 1)
			{
				if(i == 'w')
				{
					state = 2;
					printState(state);
				}
				else if(i =='.')
				{
					state = 6;
					printState(state);
				}
				else if(Character.isLetter(i) && i != 'w')
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 2)
			{
				if(i == 'w')
				{
					state = 3;
					printState(state);
				}
				else if(i =='.')
				{
					state = 6;
					printState(state);
				}
				else if(Character.isLetter(i) && i != 'w')
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 3)
			{
				if(i == '.')
				{
					state = 4;
					printState(state);
				}
				else if(Character.isLetter(i) && i != 'w')
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 4)
			{
				if(i == 'c')
				{
					state = 14;
					printState(state);
				}
				else if(Character.isLetter(i) && i != 'c')
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 5)
			{
				if(i == '.')
				{
					state = 6;
					printState(state);
				}
				else if(Character.isLetter(i))
				{
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 6)
			{
				if(i == 'c')
				{
					state = 7;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 7)
			{
				if(i == 'a')
				{
					state = 8;
					printState(state);
				}
				else if(i == 'o')
				{
					state = 9;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 8)
			{
				if(i == '.' || Character.isLetter(i))
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 9)
			{
				if(i == '.')
				{
					state = 10;
					printState(state);
				}
				else if(i == 'm')
				{
					state = 13;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 10)
			{
				if(i == 'c')
				{
					state = 11;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 11)
			{
				if(i == 'a')
				{
					state = 12;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 12)
			{
				if(i == '.' || Character.isLetter(i))
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 13)
			{
				if(i == '.' || Character.isLetter(i))
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 14)
			{
				if(i == 'o')
				{
					state = 16;
					printState(state);
				}
				else if(i == 'a')
				{
					state = 15;
					printState(state);
				}
				else if(Character.isLetter(i) && (i != 'o' || i != 'a'))
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 15)
			{
				if(Character.isLetter(i))
				{
					state = 5;
					printState(state);
				}
				else if(i == '.')
				{
					state = 6;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 16)
			{
				if(i == '.')
				{
					state = 6;
					printState(state);
				}
				else if(Character.isLetter(i) && i != 'm')
				{
					state = 5;
					printState(state);
				}
				else if(i =='m')
				{
					state = 17;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
			else if(state == 17)
			{
				if(i == '.')
				{
					state = 6;
					printState(state);
				}
				else if(Character.isLetter(i))
				{
					state = 5;
					printState(state);
				}
				else
				{
					state = -1;
					printState(state);
				}
			}
		}
		
		if(state == 8 || state == 12 || state == 13 || state == 15 || state == 17)
			System.out.println("String accepted.");
		else
			System.out.println("String rejected.");
	}
	
	public static void printState(int state)
	{
		if(state == -1)
		{
			System.out.println("String rejected.");
			System.exit(0);
		}
		else
			System.out.println("State: q" + state);
	}
}
