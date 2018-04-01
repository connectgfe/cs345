/* Proj04_AVL_studend
 *
 * Author: Giulio Esposito
 *
 */

public class Proj04_234_student implements Proj04_Dictionary{


   Proj04_BSTNode root;


   public Proj04_234_student(){

    root=null;

   }



	/* void insert(int,String)
	 *
	 * Inserts a given (key,value) pair into the tree.
	 *
	 * This call may assume that the key is non-negative, and that the
	 * value is not null.  (It may, but is not required to, enforce
	 * these assumptions.)
	 *
	 * Throws IllegalArgumentException if the key already exists in
	 * the tree.
	 */
	public void insert(int key, String value){

   root = insertHelper(root,key,value);

  }



  public Proj04_BSTNode insertHelper(Proj04_BSTNode node, int key, String value){

     if (node == null){
          
       return (new Proj04_BSTNode(key,value));
     }

 
        if (key < node.key){
            node.left = insertHelper(node.left, key, value);
        }else if (key > node.key){
            node.right = insertHelper(node.right, key, value);
        }else{ // Equal keys not allowed
            return node;
        } 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
           node to check whether this node became
           Wunbalanced */
        int bal = getBal(node);
 
        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (bal > 1 && key < node.left.key)
            return rightRotate(node);
 
        // Right Right Case
        if (bal < -1 && key > node.right.key)
            return leftRotate(node);
 
        // Left Right Case
        if (bal > 1 && key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        // Right Left Case
        if (bal < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;


  }


  public int height(Proj04_BSTNode n){

   if(n==null){return 0;}
   return n.height;

  }

  public int max(int a, int b){

   return (a > b) ? a : b;    
 
  }

  public Proj04_BSTNode rightRotate(Proj04_BSTNode y)
    {
        Proj04_BSTNode x = y.left;
        Proj04_BSTNode m = x.right;
 
        // Perform rotation
        x.right = y;
        y.left = m;
 
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
 
        // Return new root
        return x;
    }
 
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    public Proj04_BSTNode leftRotate(Proj04_BSTNode x)
    {
        Proj04_BSTNode y = x.right;
        Proj04_BSTNode m = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = m;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }


    public int getBal(Proj04_BSTNode n){

     if(n==null){ return 0;}

     return height(n.left) - height(n.right);


    }

	/* String search(int)
	 *
	 * Searches the tree for a given key; returns the associated String
	 * if the key is found, or null if it is not found.
	 */
	public String search(int key){



  return "";

  }

	/* void delete(int)
	 *
	 * Removes a given node from the tree, found by the key.
	 *
	 * Throws IllegalArgumentException if the key does not exist.
	 */
	public void delete(int key){



  }

	/* void printInOrder()
	 *
	 * Performs an in-order traversal of the tree, and prints out all of
	 * the nodes.  It does *not* print out a trailing newline.
	 *
	 * For each node, it prints both the key and the value, separated by
	 * a colon; the various nodes are separated by a space.  (There is
	 * also a space before the first node.)
	 *
	 * If the tree is empty, then it will not print out anything.
	 */
	public void printInOrder(){




  }

	/* void printPreOrder()
	 *
	 * Same as printInOrder(), except that it performs a pre-order
	 * traversal.
	 */
	public void printPreOrder(){

    printPre(root);

  }

  public void printPre(Proj04_BSTNode root){

    if (root != null)
        {
            System.out.print(root.key + " ");
            printPre(root.left);
            printPre(root.right);
        }


  }


	/* void printPostOrder()
	 *
	 * Same as printInOrder(), except that it performs a post-order
	 * traversal.
	 */
	public void printPostOrder(){



  }

	/* void genDebugDot(String)
	 *
	 * Generates a \texttt{.dot} file which represents the tree; the
	 * String is the name of the file to generate.
	 */
	public void genDebugDot(String filename){


  }


}

