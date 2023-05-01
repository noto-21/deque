/*
 * May 1st, 2023
 */

public class Deque
{
	public static void main (String[] args)
	{
		DoubleQueue doub = new DoubleQueue(5);//Create DoubleQueue object with max limit of 5 nodes

		//Prints information regarding data in queue
		System.out.print(doub.Info());

		//Adds Nodes to the queue *NOTE:  ASSUMING POSITIVE VALUES ONLY*
		doub.AddFront(2);
		doub.AddFront(3);
		doub.AddFront(4);
		doub.AddRear(1);
		doub.AddRear(0);
		//Can't add, since limit is five nodes
		doub.AddRear(7);
		doub.AddFront(99);

		//Prints information regarding data in queue
		System.out.print("\n" + doub.Print() + "\n" + doub.Info());

		//Reverses queue
		doub = doub.Reverse();

		//Prints information regarding data in queue
		System.out.print("\n\n" + doub.Print() + "\n" + doub.Info());

		//Delete first two and last nodes
		doub.DeleteFront();
		doub.DeleteFront();
		doub.DeleteRear();

		//Prints information regarding data in queue
		System.out.print("\n\n" + doub.Print() + "\n" + doub.Info());

		//Reverses queue
		doub = doub.Reverse();

		//Prints information regarding data in queue
		System.out.print("\n\n" + doub.Print() + "\n" + doub.Info());
	}
}
