import java.util.LinkedList;
import java.util.Queue;


/*
 *  $Id:  IntegerStack.java $
 *
 *  Copyright 2011, The Johns Hopkins UniversityWhiting School of Engineering
 *      All rights reserved.
 *      This material may be used, modified and reproduced by faculty,
 *      staff, and students of The Johns Hopkins University for instruction, 
 *      evaluation, and grading purposes.  For any other permission, please 
 *      contact The Johns Hopkins University Whiting School of Engineering.
 */
class QueueSelf 
{//sets up the variables used 
	private Node front;
	private Node rear;
	int curr_size2;

	private class Node
	{//sets nodes up and input info
		Character data;
		Node next;
	}
 
	    
	 	//construct for the variables used
        QueueSelf()
        {
        	front = null;
        	rear = null;
            curr_size2 = 0;
        }
        //this is my peek basically
        Character get()
        {
			return front.data;
        }
        //how i push the items 
        void pushQ(Character x)
        {
        	Node temp = rear;
        	rear = new Node();
        	rear.data = x;
        	if(isEmptyQ())
        	{
        		front = rear;
        	}
        	else
        	{
        		temp.next = rear;
        	}  
        	curr_size2++;
        }
        //how i remove the items 
        Character popQ()
        {
        	if (isEmptyQ())
                return null;
        	Character data = front.data;
        	if(front == rear)
        	{
        		rear = rear.next;
        	}
        	front = front.next;
        	curr_size2--;
        	return data;
        }
        //need to clear the inputs before going to the next one 
        void clearQ()
        {
        	while(isEmptyQ() == false)
        	{
        		popQ();
        	}
        }
        //checks to see if empty 
        boolean isEmptyQ()
        {
        	return curr_size2 == 0;

        }
       
}
