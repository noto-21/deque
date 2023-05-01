public class DoubleQueue
{
	private int size, cnt;//Declares all necessary integers
	public Node f, r;//Declares all necessary Nodes

	//Constructor
	public DoubleQueue(int sizeIn)
	{
		size = sizeIn;
		cnt = 0;//Initialize count
		f = r = null;//Initialize front/rear nodes
	}

	public boolean IsEmpty()//Check if dequeue is empty
	{
		if (f == null)//If no front node, then queue DNE
			return true;
		else
			return false;
	}
	public boolean IsFull()//Check if dequeue is full
	{
		if (cnt == size)//If counter equals the set size, then queue is full
			return true;
		else
			return false;
	}

	public void AddFront(int valueIn)//Adds to front
	{
		Node nNode = new Node(valueIn);//Declare temporary Node

		if (IsFull())//Will not add new Node if queue is already full
		{
			System.out.println("\n\nQueue is Full!  Cannot enqueue " + valueIn + "!");
			return;
		}

		if (IsEmpty())//Initialize new queue
			r = f = nNode;
		else//Add to front of existing queue
		{
			nNode.nxt = f;
			f.prv = nNode;
			f = nNode;
		}

		cnt++;//Increment counter
	}
	public void AddRear(int valueIn)//Adds to rear
	{
		Node nNode = new Node(valueIn);//Declare temporary Node

		if (IsFull())//Will not add new Node if queue is already full
		{
			System.out.println("\n\nQueue is Full!  Cannot enqueue " + valueIn + "!");
			return;
		}

		if (IsEmpty())//Initialize new queue
			f = r = nNode;
		else//Add to rear of existing queue
		{
			nNode.prv = r;
			r.nxt = nNode;
			r = nNode;
		}

		cnt++;//Increment counter
	}

	public void DeleteFront()//Delete from front
	{
		if (IsEmpty())//Will not delete front node if queue is empty
			return;
		else//Delete front node
		{
			f = f.nxt;

			if (f == null)
				r = null;
			else
				f.prv = null;
		}

		cnt--;//Decrement Counter
	}
	public void DeleteRear()//Delete from rear
	{
		if (IsEmpty())//Will not delete rear node if queue is empty
			return;
		else//Delete rear node
		{
			r = r.prv;

			if (r == null)
				f = null;
			else
				r.nxt = null;
		}

		cnt--;//Decrement Counter
	}

	public int CheckFront()//Return value of front node
	{
		if (IsEmpty())
			return -1;//'Exit' code if queue is empty
		else
			return f.data;
	}
	public int CheckRear()//Return value of rear node
	{
		if (IsEmpty())
			return -1;//'Exit' code if queue is empty
		else
			return r.data;
	}

	public int CheckSize()//Return amount of nodes in queue
	{
		return cnt;
	}

	//Reverses the queue
	public DoubleQueue Reverse()
	{
		DoubleQueue tempDQ = new DoubleQueue(this.size);//Create new DoubleQueue object with same size as original
		Node tempN = f;//Create temporary node

		while (tempN != null)//Runs until end of queue is reached
		{
			tempDQ.AddFront(tempN.data);//Adds the node to the new queue such that it is front-queued as normal
			tempN = tempN.nxt;//Reach next node
		}

		return tempDQ;//Return the new queue
	}

	public String Print()//Print the queue
	{
		String txt = "";//Return string
		Node temp = f;//Temporary node

		while (temp != null)//Until end of queue is reached
		{
			txt += temp.data + "\s";//Print and format data
			temp = temp.nxt;//Reach next node
		}

		return txt;
	}
	public String Info()//Return formatted data regarding queue
	{
		return ("Size: " + CheckSize() +
				"\t\tFront: " + ((CheckFront() == -1) ? "Empty" : CheckFront()) +
				"\tRear: " + ((CheckRear() == -1) ? "Empty" : CheckRear()) +
				"\nEmpty: " + IsEmpty() + 
				"\tFull: " + IsFull());
	}
}