/*Author: G Esposito
* Function: bst, can rotate
*
*/
import java.io.*;
import java.util.LinkedList;

public class Proj03_BST_student implements Proj03_BST
{


   Proj03_BSTNode root;
   LinkedList<Proj03_BSTNode> nodeList;
   PrintWriter writer;
 

  public Proj03_BST_student(){

     root = null;

  }

 

  public void debug(String val) {


    nodeList = new LinkedList<Proj03_BSTNode>();

    makeList(root, nodeList);


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


    writer.println("}");
    writer.close();


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

          root = insertNode(root, key, value);

       }


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
    
   return val;

  }


  public Proj03_BSTNode searchTree(Proj03_BSTNode root, int key){

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
      deleteNode(root,key);
    }else{
       throw new IllegalArgumentException("ERROR: key "+key+"DNE");
    }

  }


  Proj03_BSTNode deleteNode(Proj03_BSTNode root, int key){
        if (root == null)  return root;
 
        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
 
        else
        {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            root.key = minKeyValue(root.right);
 
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

 


/*
  public  void rLeft(int at){

        Proj03_BSTNode x = searchTree(root,at); 
 
        if(x==null || x.right==null){ 
           throw new IllegalArgumentException();           
         }else{

            while(true){
//  System.out.println(root.key);
 
     
              if(root.key==at){            
// good code 
                Proj03_BSTNode temp = root;
                Proj03_BSTNode y = temp.right;

                Proj03_BSTNode yLc = y.left;
                temp.right = yLc;
       
                y.left = temp;
                root = y;

//  System.out.println("at break");
                break;
              }
   
        if(root.key>at){ 

              if(root.left!=null){            
                if(root.left.key==at){            
// good code 
                Proj03_BSTNode temp = root.left;
                Proj03_BSTNode y = temp.right;

                Proj03_BSTNode yLc = y.left;
                temp.right = yLc;
       
                y.left = temp;
                root.left = y;

//  System.out.println("at break");
                break;
               }
              }

               root=root.left;
              
//  System.out.println("<-- left");
 
             }else{

              if(root.right!=null){            
               if(root.right.key==at){            

// good code 
                Proj03_BSTNode temp = root.right;
                Proj03_BSTNode y = temp.right;

                Proj03_BSTNode yLc = y.left;
                temp.right = yLc;
       
                y.left = temp;
                root.right = y;
                

//  System.out.println("at break");
                break;
               }
               }


               root=root.right;
//  System.out.println("--> right");
 
             }
 
          }  // end while

        } // end else

// System.out.println("at end");
 

  }

*/


  /* void rotateRight(int)
   *
   * Same as rotateLeft, except that it rotates right.
   */

  public  void rotateRight(int at){

        if(search(at)==null){
 

          throw new IllegalArgumentException("ERROR: Cannot rotate right at key "+at+", because the key is not present in the tree.");
         }



        Proj03_BSTNode x = searchTree(root,at); 
 
        if(x.left==null){ 

           throw new IllegalArgumentException("ERROR: The node with key "+at+" does not have a left child, so a rotate right is not possible.");
  

         }else{


         rrNode(root,at);
         }
  }


  Proj03_BSTNode rrNode(Proj03_BSTNode root, int key){
        if (root == null)  return root;
 
        if (key < root.key)
            root.left = rrNode(root.left, key);
        else if (key > root.key)
            root.right = rrNode(root.right, key);
 
        else
        {
                Proj03_BSTNode temp = root;
                Proj03_BSTNode y = temp.left;

                Proj03_BSTNode yRc = y.right;
                temp.left = yRc;
       
                y.right = temp;
                root = y;

        }
 
        return root;
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


  public  void rotateLeft(int at){

        if(search(at)==null){
 

          throw new IllegalArgumentException("ERROR: Cannot rotate right at key "+at+", because the key is not present in the tree.");
         }



        Proj03_BSTNode x = searchTree(root,at); 
 
        if( x.right==null){ 


           throw new IllegalArgumentException("ERROR: Cannot rotate left at key "+at+" because the key is not present in the tree.");           


         }else{
           lrNode(root,at);
         }

  }




  Proj03_BSTNode lrNode(Proj03_BSTNode root, int key){
        if (root == null)  return root;
 
        if (key < root.key)
            root.left = lrNode(root.left, key);
        else if (key > root.key)
            root.right = lrNode(root.right, key);
 
        else
        {

                Proj03_BSTNode temp = root;
                Proj03_BSTNode y = temp.right;

                Proj03_BSTNode yLc = y.left;
                temp.right = yLc;
       
                y.left = temp;
                root = y;


        }
 
        return root;
    }





/*

  public  void rRight(int at){

        Proj03_BSTNode x = searchTree(root,at); 
 
        if(x==null || x.left==null){ 
           throw new IllegalArgumentException();           
         }else{

            while(true){
  System.out.println("1 "+root.key);
 
     
              if(root.key==at){            
  System.out.println("atRT "+root.key);
 

// good code 
                Proj03_BSTNode temp = root;
                Proj03_BSTNode y = temp.left;

                Proj03_BSTNode yRc = y.right;
                temp.left = yRc;
       
                y.right = temp;
                root = y;

//  System.out.println("at break");
                break;
              }
   
        if(root.key<at){ 
  System.out.println("R "+root.key);
 
              if(root.right!=null){            
                if(root.right.key==at){            
// good code 
                Proj03_BSTNode temp = root.right;
                Proj03_BSTNode y = temp.left;

                Proj03_BSTNode yRc = y.right;
                temp.left = yRc;
       
                y.right = temp;
                root.right = y;

  System.out.println("at break");
                break;
               }
              }

               root=root.right;
              
  System.out.println("--> right");
 
             }

        if(root.key>at){ 
 

  System.out.println("L "+root.key);
 
              if(root.left!=null){            
               if(root.left.key==at){            

// good code 
                Proj03_BSTNode temp = root.left;
                Proj03_BSTNode y = root.left.left;

                Proj03_BSTNode yRc = y.right;
                root.left.left = yRc;
       
                y.right = root.left;
                root.left = y;
                

  System.out.println("at break");
                break;
               }
               }


               root=root.left;
  System.out.println("<-- left");
 
             }
 
          }  // end while

        } // end else

 System.out.println("at end");
 

  }

*/


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

