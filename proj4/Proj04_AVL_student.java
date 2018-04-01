/* Proj04_AVL_studend
 *
 * Author: Giulio Esposito
 *
 */

import java.io.*;

public class Proj04_AVL_student implements Proj04_Dictionary{


   Proj04_BSTNode root;


   public Proj04_AVL_student(){

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

        if(search(key)!=null){


          throw new IllegalArgumentException("Attempt to insert a duplicate key '"+key+"'");

         }else{

          root = insertHelper(root, key, value);

       }



  }



  public Proj04_BSTNode insertHelper(Proj04_BSTNode node, int key, String value){

     if (node == null){


       Proj04_BSTNode val = new Proj04_BSTNode(key,value);
       val.height = 1; 

       return (val);
 
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

   String val;
   if( searchTree(root,key) == null){
     val = null;
   }else{
     val = searchTree(root,key).value;
   }

   return val;

  }


  public Proj04_BSTNode searchTree(Proj04_BSTNode root, int key){

    if (root==null || root.key==key)
        return root;

    if (root.key > key)
        return searchTree(root.left, key);

    if (root.key < key)
        return searchTree(root.right, key);

    return null;
  }






	/* void delete(int)
	 *
	 * Removes a given node from the tree, found by the key.
	 *
	 * Throws IllegalArgumentException if the key does not exist.
	 */
	public void delete(int key){

    if( search(key)!=null ){
      root =  deleteNode(root,key);
    }else{
       throw new IllegalArgumentException("ERROR: key "+key+"DNE");
    }


  }


  Proj04_BSTNode deleteNode(Proj04_BSTNode root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;
 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);
 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
 
        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
 
            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Proj04_BSTNode temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else   // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            }
            else
            {
 
                // get predessor 
                Proj04_BSTNode temp = maxVal(root.left);
 
                root.key = temp.key;
 
                root.left = deleteNode(root.left, temp.key);
            }
        }
 
        // If the tree had only one node then return
        if (root == null)
            return root;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBal(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBal(root.left) >= 0)
            return rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && getBal(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBal(root.right) <= 0)
            return leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && getBal(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
 
        return root;
    }
 

    Proj04_BSTNode maxVal(Proj04_BSTNode node){
        Proj04_BSTNode cur = node;
 
        /* loop down to find the leftmost leaf */
        while (cur.right != null)
           cur = cur.right;
 
        return cur;
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

   printIn(root);


  }

  public void printIn(Proj04_BSTNode root){

    if (root != null)
        {
            printIn(root.left);
            System.out.print(" "+root.key+":'"+root.value+"'");
 

            printIn(root.right);
        }


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
            System.out.print(root.key+" "+root.value);
   
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

    printPost(root);

  }

  public void printPost(Proj04_BSTNode root){

    if (root != null)
        {
            printPost(root.left);
            printPost(root.right);

            System.out.print(" "+root.key+":'"+root.value+"'");
 

        }


  }






	/* void genDebugDot(String)
	 *
	 * Generates a \texttt{.dot} file which represents the tree; the
	 * String is the name of the file to generate.
	 */
	public void genDebugDot(String filename){


  try{
  Proj04_GenDotFile.gen(root,filename);
  }catch(IOException e){}




  }


}

