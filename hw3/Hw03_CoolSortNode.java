/* Homework 3 - One node (representing one key) in the CoolSort algorithm
 *
 * This represents a single node in the CoolSort tree.  It holds one key,
 * and has references to two other nodes.  The constructor takes a reference
 * to one "old" node, which allows you to build chains as you insert().
 *
 * This has one utility method, which recalculates the count for *this* node;
 * it assumes that both of the pointed-to nodes have correct counts.  It also
 * has a (static) utility method for getting the count of a node (which
 * seamlessly handles the null case).
 *
 * While the constructor for this node will automatically build a new node
 * with the proper links and count, all later modifications of the node are
 * handled by the CoolSort class.  That class will read and write the
 * sorted/unsorted fields directly.  It will also call recalcCount() when/if
 * it necessary to do so.
 */



public class Hw03_CoolSortNode
{
	public int key;

	public Hw03_CoolSortNode unsorted,sorted;
	public int count;


	public Hw03_CoolSortNode(int key, Hw03_CoolSortNode prevNode)
	{
		this.key = key;

		sorted   = null;
		unsorted = prevNode;

		recalcCount();
	}

	public void recalcCount()
	{
		this.count = 1 + getCount(this.sorted) + getCount(this.unsorted);
	}

	public static int getCount(Hw03_CoolSortNode node)
	{
		if (node == null)
			return 0;
		return node.count;
	}
}

