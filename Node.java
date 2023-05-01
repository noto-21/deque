public class Node
{
	public int data;//Declares all necessary integers
	public Node nxt, prv;//Declares all necessary Nodes

	//Constructor
	public Node(int val)
	{
		data = val;
		nxt = prv = null;//Initialize Nodes
	}
	
	//Return stored data
	public void printData()
	{
		System.out.print(data + " ");
	}
	
	//Allows for the modification of stored data after Node is initialized
	public void changeData(int nVal)
	{
		data = nVal;
	}
}