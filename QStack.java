


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
class QStack 
{
	int curr_size;

		// Two built in queues to exhibit LIFO
		QueueSelf q1 = new QueueSelf();
		QueueSelf q2 = new QueueSelf();   
	    
	 	//maintain current number of elements
        QStack()
        {
            curr_size = 0;
        }
        void push(Character x)
        {
            curr_size++;
            // Push x first in empty q2
            q2.pushQ(x);
  
            // Push all the remaining
            // elements in q1 to q2.
            while (!q1.isEmptyQ())
            {
                q2.pushQ(q1.get());
                q1.popQ();
            }
            // swap the names of two queues
            QueueSelf q = q1;
            q1 = q2;
            q2 = q;
        }
  
        Character pop()
        {
            // if no elements are in q1
            if (q1.isEmptyQ())
                return null;

            curr_size--;
            return q1.popQ();
        }
  
        Character peek()
        {
            if (q1.isEmptyQ())
                return null;
            return q1.get();
        }
  
        int size()
        {
            return curr_size;
        }
        boolean isEmpty()
        {
        	return curr_size == 0;

        }
        void clear()
        {
        	while(q1.isEmptyQ() == false)
        	{
        		pop();
        	}
        }
}
