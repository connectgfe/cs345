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



  public Proj04_234Node insertHelper(Proj04_234Node node, int key, String value){

     if (node == null){
          
       return (new Proj04_234Node(key,value));
     }

 
       return node;


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

