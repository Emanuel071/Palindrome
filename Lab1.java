
// Java implementation of SpecialStack
// Note : main method for queue based stack implementation 
 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Lab1
{
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
    {

		//initializers 
		Character str;
		FileReader  input = null;
        FileWriter  output = null;
        int compare, c;			//helps to increment and compare via arithmetic
    	
        //inputs via command prompt
        if (args.length != 2) 
        {
            System.out.println("Usage:  java Project1 [input file pathname]" +
                " [output file pathname]");
            System.exit(1);
        }	
		
		//  Open the files that will be used for input and output.
		try 
		{
			input = new FileReader(args[0]); // input file
            output = new FileWriter(args[1]); // output file
            File file = new File(args[0]);
            
            if(file.length() == 0)
            {
            	output.write("NOTHING IN TXT FILE"); 		//in case empty txt file given
            }


            while(input.ready() != false) 					//stops after last line read 
            {  	
            	
            	QStack Stack = new QStack();				//grabs QStack class	
            	QStack Stack2 = new QStack();				//grabs QStack class menat to empty to stack3	
            	QStack Stack3 = new QStack();				//grabs QStack class
                
            	output.write("\nGiven Text: \n");			//first output to file
	            
            	
            	//reads each character           	
            	while ((c = input.read()) != -1 && c != '\n') 
	    		{ // read and process one character
	            	
	            	str = (char) c;	
	            	output.write(str);						//show user given
	            	str = Character.toLowerCase(str);		//puts in lower case 
	            	
	            	if((str >= 'a' && str <= 'z') ||		//input only letters & #'s
	            	   (str >= '0' && str <= '9'))
	            	{
	            		Stack.push(str);					//pushes stack LIFO
	            		Stack2.push(str);					//pushes stack LIFO
	            		System.out.print(Stack.peek());		//for graders use
	            	}
	            	else
	            	{
	            		;
	            	}
	    		}
            	while(Stack2.isEmpty() == false)
            	{
            		Stack3.push(Stack2.pop());             						//emptys 2nd stack for reverse stack3
            	}
            	//runs as long as "stack" is not empty 
	            while (Stack.isEmpty() == false) 								//runs while stack not empty
	    		{
	            	System.out.println();										//for graders use
			    	System.out.println("Size: " + Stack.size());				//for graders use
			    	output.write("\nSize  (letters/numbers): " + Stack.size());
			    	
			    	//in case they decide to be clever and put one letter
			    	if(Stack.size() == 1)
			    	{
			    		System.out.println("Not a palindrome");					//for graders use
		    			output.write("\nNot a palindrome \n");
			    	}
			    	//seperates even inputs from odds
			    	else if(Stack.size()%2 == 0)
			    	{
			    		System.out.println("Even");								//for graders use
			    		compare = Stack.size();        							//places value to variable to compare
			    									   							//when popping
						while(Stack.size() > compare/2)							//we know we are even, so we have 
						{							   							//to be greater than half
							System.out.print(Stack3.peek() + " ");
							System.out.println(Stack.peek());
							if(Stack3.peek() != Stack.peek()) 					//compare reverse LIFO and LIFO
		    				{
		    					System.out.println("Not a palindrome");			//for graders use
		    					output.write("\nNot a palindrome \n");
		    					break;
		    				}
							else if(Stack3.peek() == Stack.peek())
		    				{
								Stack.pop();									//pop both and continue
								Stack3.pop();									//comparing
		    					if(Stack.size() == compare/2)
			    				{
			    					System.out.println("Is a palindrome");		//for graders use
					    			output.write("\nIs a palindrome \n");
			    					break;
			    				}
		    				}//pops 
		    			}//closes loop for pop removal to center of wording 
		    		}//closes run through of checking letters 
			    	
			    	//seperates even inputs from evens, below is the same startin line 86 except odd
			    	else if(Stack.size()%2 != 0)
			    	{
			    		System.out.println("Odd");								//for graders use
			    		if(Stack3.peek() == Stack.peek())
			    		{
			    			compare = Stack.size();
			    			while(Stack.size() > compare/2)
			    			{
			    				System.out.print(Stack3.peek() + " ");			//for graders use
								System.out.println(Stack.peek());				//for graders use
								if(Stack3.peek() != Stack.peek())
			    				{
			    					System.out.println("Not a palindrome");		//for graders use
			    					output.write("\nNot a palindrome \n");
			    					break;
			    				}
								else if(Stack3.peek() == Stack.peek())
			    				{
									Stack.pop();
									Stack3.pop();
			    					if(Stack.size() == compare/2)
				    				{
				    					System.out.println("Is a palindrome");
						    			output.write("\nIs a palindrome \n");
				    					break;
				    				}
			    				}//pops 
			    			}//closes loop for pop removal to center of wording 
			    		}//closes run through of checking letters 
			    		else
			    		{
			    			System.out.println("Not a palindrome");
			    			output.write("\nNot a palindrome \n");
			    		}
			    	}//closes if statement for odd	    	
			    	System.out.println();
			    	Stack.clear(); 												//resets the stack
			    	Stack3.clear(); 											//resets the stack
	    		}// close while of stack 
            }// close while of file 
        }//closes try
		finally 
		{
            if (input != null) input.close();
            if (output != null) output.close();
        }
    }
}
	

    	