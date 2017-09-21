import java.util.*;
import java.lang.*;

public class PDA 
{
	public static void main(String[] args)
	{
		boolean cont = true;//used in loop
		String inp = "";//initialize input
		Stack st = new Stack();//initialize stack
		
		while(cont)//loop until valid input (y or n)
		{
			Scanner read = new Scanner(System.in);//initialize scanner
			System.out.println("Would you like to enter a string? (y/n): ");
			inp = read.nextLine();//read input
			
			if(inp.equals("y"))//if y
			{
				System.out.println("Please enter a string: ");
				inp = read.nextLine();//read string
				System.out.println("Input String: " + inp);//print string
				testString(inp, st);//test if string is valid
			}
			else if(inp.equals("n"))//if n
			{
				cont = false;//exit program
			}
			else
			{
				System.out.println("You must enter 'y' for yes, or 'n' for no.");//print error for invalid input
			}
		}
	}
	
	public static void testString (String test, Stack st)
	{
		char[] chars = test.toCharArray();//read string into array of char
		
		int state = 1;//start state		
		System.out.println("Starting state: q1");//print start state
		
		for(char i: chars)//cycle through characters
		{
			//to avoid inaccurate print statements
			char tmp = ' ';
			char temp = ' ';
			
			/**
			 * if the stack is not empty, set
			 * temp to top character in stack
			 * 
			 * used to print accurate statement
			 * in event of pop function
			 */
			if(!st.empty())
			{
				temp = (Character)st.peek();
			}
			
			/**
			 * underscores are read in as
			 * white spaces by scanner
			 * 
			 * if white space is found, set
			 * back to underscore
			 */
			if(i == ' ')
				i = '_';
			
			System.out.println("Current character: " + i);//print current char
			
			/**
			 * if state is 1 and the first
			 * character is not a '$', reject
			 * string.
			 * 
			 * if '$' is read, push onto stack
			 * and transition to state 2
			 */
			if(state == 1)
			{
				if(i != '$')
				{
					state = -1;
					printState(state, i, tmp);
				}
				else
				{
					state = 2;
					st.push(i);
					printState(state, i, tmp);
				}
			}
			/**
			 * if state is 2 and letter or underscore
			 * is read, transition to state 5
			 * 
			 * if integer is read, transition to
			 * state 3
			 * 
			 * if left paren is read, push onto
			 * stack and transition to state 4
			 * 
			 * else reject string
			 */
			else if(state == 2)
			{
				if(Character.isLetter(i) || i == '_')
				{
					state = 5;
					printState(state, i, tmp);
				}
				else if(Character.isDigit(i))
				{
					state = 3;
					printState(state, i, tmp);
				}
				else if(i == '(')
				{
					state = 4;
					st.push(i);
					printState(state, i, tmp);
				}
				else
				{
					state = -1;
					printState(state, i, tmp);
				}
			}
			/**
			 * if state is 3 and int is read,
			 * transition back to state 3
			 * 
			 * if operator is read, transition
			 * to state 4
			 * 
			 * if right paren is read, pop
			 * left paren and transition back
			 * to state 3
			 * 
			 * if '$' is read, pop '$' off stack
			 * and transition to accept state
			 * 
			 * else reject string
			 */
			else if(state == 3)
			{
				if(Character.isDigit(i))
				{
					state = 3;
					printState(state, i, tmp);
				}
				else if (i == '+' || i == '-' || i == '*' || i == '/')
				{
					state = 4;
					printState(state, i, tmp);
				}
				else if(i == ')')
				{
					state = 3;
					Character c = (Character) st.pop();
					printState(state, i, temp);
				}
				else if(temp == '$')
				{
					state = 6;
					Character c = (Character) st.pop();
					printState(state, i, temp);
				}
				else
				{
					state = -1;
					printState(state, i, tmp);				
				}
			}
			/**
			 * if state is 4 and letter or 
			 * underscore are read, transition
			 * to state 5
			 * 
			 * if left paren is read, push onto
			 * stack and transition back to 
			 * state 4
			 * 
			 * if int is read, transition to 
			 * state 3
			 * 
			 * else reject string
			 */
			else if(state == 4)
			{
				if(Character.isLetter(i) || i == '_')
				{
					state = 5;
					printState(state, i, tmp);
				}
				else if(i == '(')
				{
					state = 4;
					st.push(i);
					printState(state, i, tmp);
				}
				else if(Character.isDigit(i))
				{
					state = 3;
					printState(state, i, tmp);
				}
				else
				{
					state = -1;
					printState(state, i, tmp);
				}
			}
			/**
			 * else if state is 5 and letter or
			 * underscore are read, transition
			 * back to state 5
			 * 
			 * if operator is read, transition to
			 * state 4
			 * 
			 * if right paren is read, pop left
			 * parent and transition back to 
			 * state 5
			 * 
			 * if int is read, transition back to
			 * state 5
			 * 
			 * if '$' is read, pop '$' and transition
			 * to state 6
			 * 
			 * else reject string
			 */
			else if(state == 5)
			{
				if(Character.isLetter(i) || i == '_')
				{
					state = 5;
					printState(state, i, tmp);
				}
				else if(i == '+' || i == '-' || i == '-' || i == '*' || i == '/')
				{
					state = 4;
					printState(state, i, tmp);
				}
				else if(i == ')')
				{
					state = 5;
					Character c = (Character) st.pop();
					printState(state, i, temp);
				}
				else if(Character.isDigit(i))
				{
					state = 5;
					printState(state, i, tmp);
				}
				else if(temp == '$')
				{
					state = 6;
					Character c = (Character) st.pop();
					printState(state, i, temp);
				}
				else
				{
					state = -1;
					printState(state, i, tmp);				
				}
			}

		}
		
		
		/**
		 * if ended in state 6 the string is accepted
		 * else the string is rejected
		 */
		if(state == 6)
			System.out.println("String accepted.");
		else
			System.out.println("String rejected.");
	}
	
	
	/**
	 * printState is used to print which state
	 * the process is currently in and make the user
	 * aware when a pop or push function is used
	 * 
	 * it is also used to check if the string was 
	 * put into a rejected state, in this case the
	 * user is told the string is rejected and the
	 * program is terminated
	 *  
	 * @param state
	 * @param ch
	 * @param c
	 */
	public static void printState(int state, char ch, char c)
	{
		if(state == -1)
		{
			System.out.println("String rejected.");
			System.exit(0);
		}
		else
		{
			if(c == '$' || c == '(')
			{
				System.out.println("Symbol popped off of stack: " + c);
			}
			if((ch == '$' && c != '$') || ch == '(')
			{
				System.out.println("Symbol pushed onto stack: " + ch);
			}
			System.out.println("State: q" + state);
		}
	}
}
