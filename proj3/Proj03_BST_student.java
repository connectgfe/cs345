import java.io.*;
import java.util.LinkedList;
/* Proj03_BST
 *
 * Author: Russ Lewis
 *
 * Represents a single node in a BST.  Carries both a key and satellite data.
 * For simplicity, I have not made this a generic - though I might add that
 * later.  And since students will be using this as a utility class (rather
 * than modifying it for themselves), it does not have any methods.
 */

public class Proj03_BST_student implements Proj03_BST
{


   Proj03_BSTNode root;
   LinkedList<Proj03_BSTNode> nodeList;
   PrintWriter writer;
 
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


  public Proj03_BST_student(){

     root = null;
     nodeList = new LinkedList<Proj03_BSTNode>();

  }

 

  public void debug(String val) {

    makeList(root, nodeList);


/*
    for(Proj03_BSTNode node : nodeList){

     if(node.left !=null){// || node.right !=null){   
        System.out.println(node.key+" ->  "+node.left.key+";");}
     if(node.right !=null){  
        System.out.println(node.key+" ->  "+node.right.key+";");}
       
    
    }

*/


    try{
    writer = new PrintWriter(val);
    }catch(FileNotFoundException fne){
    }

    writer.println("digraph M {");


    for(Proj03_BSTNode node : nodeList){

      if(node.left !=null){// || node.right !=null){   
        writer.println(node.key+" ->  "+node.left.key+" [label=\"L\"] ;");}
      if(node.right !=null){  
        writer.println(node.key+" ->  "+node.right.key+" [label=\"R\"] ;");}
           
    }

/*

    for(Proj03_BSTNode node : nodeList){

     if(node.left !=null || node.right !=null){   
        writer.print(node.key);
         if(node.left !=null){ writer.println(" ->  "+node.left.key+" ;");}
         if(node.right !=null){  writer.print(node.key);
         writer.print(" ->  "+node.right.key+" ;");}
       writer.println();
      } 
    
    }

*/

    writer.println("}");
    writer.close();



  }

 
  public void insert(int key, String value){

    root = insertNode(root, key, value);

  }

     
   Proj03_BSTNode insertNode(Proj03_BSTNode root, int key, String value) {
 
        if (root == null) {
            root = new Proj03_BSTNode(key, value);
            return root;
        }
 
        if (key < root.key)
            root.left = insertNode(root.left, key, value);
        else if (key > root.key)
            root.right = insertNode(root.right, key, value);
 
        return root;
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
    

System.out.println("value result from search: "+val);
   return val;

  }


  public Proj03_BSTNode searchTree(Proj03_BSTNode root, int key){
    // Base Cases: root is null or key is present at root
    if (root==null || root.key==key)
        return root;
 
    // val is greater than root's key
    if (root.key > key)
        return searchTree(root.left, key);
 
    // val is less than root's key
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
     deleteNode(root,key);
   }else{
System.out.println("can't delete");
   }

  }
 /* A recursive function to insert a new key in BST */

  Proj03_BSTNode deleteNode(Proj03_BSTNode root, int key){
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.key = minKeyValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteNode(root.right, root.key);
        }
 
        return root;
    }

    public int minKeyValue(Proj03_BSTNode root)
    {
        int minValue = root.key;
        while (root.left != null)
        {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

 

  /* void rotateLeft(int)
   *
   * Searches the tree for a given key, and then performs a rotate left
   * at that location.  A "rotate left" means that the selected node
   * moves down, and the right child of that node moves up to be the new
   * root.
   *
   * Throws IllegalArgumentException if the key does not exist.
   * Throws IllegalArgumentException if the selected node does not have
   * a right child.
   */
  public  void rotateLeft (int at){

        Proj03_BSTNode x = searchTree(root,at); 
        if(x==null || x.right==null){ 
           throw new IllegalArgumentException();
         }  

        Proj03_BSTNode y = x.right;
        Proj03_BSTNode yLc = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = yLc;

  }


  /* void rotateRight(int)
   *
   * Same as rotateLeft, except that it rotates right.
   */
  public  void rotateRight(int at){

        Proj03_BSTNode x = searchTree(root,at); 
 
        if(x==null || x.left==null){ 
           throw new IllegalArgumentException();
         }  



        
// good code 
        Proj03_BSTNode temp = root;
        Proj03_BSTNode y = root.left;

        if(y.right!=null){        
          Proj03_BSTNode yRc = y.right;
          temp.left = yRc;
        }
       
        y.right = temp;
        root = y;

 
/*
        Proj03_BSTNode y = x.left;
        Proj03_BSTNode yRc = y.right;
 
        // Perform rotation
        y.right = x;
        x.left = yRc;
*/

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

     inorderPrint(root);
  }

  void inorderPrint(Proj03_BSTNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(" "+root.key+":'"+root.value+"'");
            inorderPrint(root.right);
        }
    }

  public void printPreOrder(){

     preorderPrint(root);

  }

  void preorderPrint(Proj03_BSTNode root) {
        if (root != null) {
            System.out.print(root.key+" "+root.value);
            preorderPrint(root.left);
// System.out.println("end left");
 
            preorderPrint(root.right);
// System.out.println("end right");
 
        }
    }

  void makeList(Proj03_BSTNode root, LinkedList<Proj03_BSTNode> nodeList) {

        if (root != null) {
            nodeList.add(root);
            makeList(root.left, nodeList);
            makeList(root.right, nodeList);
 
        }
    }




  /* void printPostOrder()
   *
   * Same as printInOrder(), except that it performs a post-order
   * traversal.
   */
  public void printPostOrder(){

     postorderPrint(root);

  }
  void postorderPrint(Proj03_BSTNode root) {
        if (root != null) {
            postorderPrint(root.left);
// System.out.println("end left");
 
            postorderPrint(root.right);
// System.out.println("end right");
 
            System.out.print(" "+root.key+":'"+root.value+"'");
        }
    }



  /* void genDebugDot(String)
   *
   * Generates a \texttt{.dot} file which represents the tree; the
   * String is the name of the file to generate.
   */
  public void genDebugDot(String filename){

     debug(filename);
   }
}

