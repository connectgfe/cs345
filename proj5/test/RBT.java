

public class RBT implements Proj04_Dictionary
{


    Node root;



    /** Color for a red node. */
//    protected static final Color RED = Color.red;
  // color red = 1;  
    
    

    /** Color for a black node. */
//    protected static final Color BLACK = Color.black;
  // color black =0; 

    /**
     * Exception thrown by {@link #blackHeight} if the black-height of
     * a node is ill-defined.
     */
/*
    public static class BlackHeightException extends RuntimeException
    {
    }
*/
    /**
     * Inner class for a red-black tree node.  Extends a binary search
     * tree node with an additional color field.
     */
    class Node extends RedBlackNode
    {
  /** The node's color, either RED or BLACK. */
//  protected Color color;

     Node parent;
     Node right, left;

  /**
   * Initializes a node with the data, makes other pointers nil,
   * and makes the node red.
   *
   * @param data Data to save in the node.
   */
     public Node(int key, String value){
      super(key,value);
      this.color = 1;
     }


    }

    /**
     * Set the sentinel <code>nil</code> to a given node, and make the
     * sentinel black.
     *
     * @param node The node that <code>nil</code> is set to.
     */
/*
    protected void setNil(Node node)
    {
  node.color = BLACK;
  super.setNil(node);
    }
*/
    /**
     * Creates a red-black tree with just a <code>nil</code>, which is
     * the root.
     */
    public RBT()
    {
    root = new Node(0,null);
    root.color=0;
    }


   public void insert(int key, String value) {
       root = insertRec(root,null, key, value);

System.out.println("Inserted: "+key);

       insertFixUp(search2(root,key));

    }
     
    /* A recursive function to insert a new key in BST */
    public Node insertRec(Node root, Node par, int key, String value) {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key,value);
            root.parent=par;
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (key < root.key){

                    root.left = insertRec(root.left, root, key, value);
         }else if (key > root.key){

                    root.right = insertRec(root.right, root , key, value);
         } 
        /* return the (unchanged) node pointer */
        return root;
    }





    /**
     * Performs a left rotation on a node, making the node's right
     * child its parent.
     *
     * @param x The node.
     */


    protected void leftRotate(Node x)
    {
  Node y = (Node) x.right;

  // Swap the in-between subtree from y to x.
  x.right = y.left;
  if (y.left != null)
      y.left.parent = x;

  // Make y the root of the subtree for which x was the root.
  y.parent = x.parent;
  
  // If x is the root of the entire tree, make y the root.
  // Otherwise, make y the correct child of the subtree's
  // parent.
  if (x.parent == null)
      root = y;
  else 
      if (x == x.parent.left)
    x.parent.left = y;
      else
    x.parent.right = y;

  // Relink x and y.
  y.left = x;
  x.parent = y;
    }

    /**
     * Performs a right rotation on a node, making the node's left
     * child its parent.
     *
     * @param x The node.
     */


    protected void rightRotate(Node x)
    {
  Node y = (Node) x.left;

  x.left = y.right;
  if (x.left != null)
      y.right.parent = x;

  y.parent = x.parent;

  y.right = x;
  x.parent = y;

  if (root == x)
      root = y;
  else
      if (y.parent.left == x)
    y.parent.left = y;
      else
    y.parent.right = y;
    }


  


    public Node search2(Node r, int val)

     {


         while (r != null)
         {

             int rval = r.key;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 return r;


             }

             search2(r, val);

         }

         return null;

     } 






    /**
     * Inserts data into the tree, creating a new node for this data.
     *
     * @param data Data to be inserted into the tree.
     * @return A reference to the <code>Node</code> object created.
     * The <code>Node</code> class is opaque to methods outside this
     * class.
     */
/*
    public Object insert(Comparable data)
    {
  Node z = new Node(data);
  treeInsert(z);

  return z;
    }

*/

    /**
     * Inserts a node into the tree.
     *
     * @param z The node to insert.
     */

/*
    protected void treeInsert(Node z)
    {
  super.treeInsert(z);
  insertFixup(z);
    }
*/

    /**
     * Restores the red-black conditions of the tree after inserting a
     * node.
     *
     * @param z The node inserted.
     */

    public  void insertFixUp(Node z)
    {
  Node y = null;

  while (((Node) z.parent).color == 1) {
      if (z.parent == z.parent.parent.left) {
    y = (Node) z.parent.parent.right;
    if (y.color == 1) {
        ((Node) z.parent).color = 0;
        y.color = 0;
        ((Node) z.parent.parent).color = 1;
        z = (Node) z.parent.parent;
    }
    else {
        if (z ==  z.parent.right) {
      z = (Node) z.parent;
      leftRotate(z);
        }
        
        ((Node) z.parent).color = 0;
        ((Node) z.parent.parent).color = 1;
        rightRotate((Node) z.parent.parent);
    }
      }
      else {
    y = (Node) z.parent.parent.left;
    if (y.color == 1) {
        ((Node) z.parent).color = 0;
        y.color = 0;
        ((Node) z.parent.parent).color = 1;
        z = (Node) z.parent.parent;
    }
    else {
        if (z ==  z.parent.left) {
      z = (Node) z.parent;
      rightRotate(z);
        }
        
        ((Node) z.parent).color = 0;
        ((Node) z.parent.parent).color = 1;
        leftRotate((Node) z.parent.parent);
    }
      }
  }
  ((Node) root).color = 0;
    }


    /**
     * Returns the number of black nodes from a given node down to any
     * leaf.  The value should be the same for all paths.
     *
     * @param z The node.
     * @throws BlackHeightException if the number of black nodes on a
     * path from the left child down to a leaf differs from the number
     * of black nodes on a path from the right child down to a leaf.
     */
/*
    public int blackHeight(Node z)
    {
  if (z == nil)
      return 0;

  int left = blackHeight((Node) z.left);
  int right = blackHeight((Node) z.right);
  if (left == right)
      if (z.color == BLACK)
    return left + 1;
      else
    return left;
  else
      throw new BlackHeightException();
    }
*/
    /**
     * Returns the number of black nodes from the root down to any
     * leaf.  The value should be the same for all paths.
     *
     * @param z The node.
     * @throws BlackHeightException if the number of black nodes on a
     * path from the left child down to a leaf differs from the number
     * of black nodes on a path from the right child down to a leaf.
     */
/*
    public int blackHeight()
    {
  return blackHeight((Node) root);
    }
}
*/

// $Id: RedBlackTree.java,v 1.1 2003/10/14 16:56:20 thc Exp $
// $Log: RedBlackTree.java,v $
// Revision 1.1  2003/10/14 16:56:20  thc
// Initial revision.
//

     public void printInOrder()

     {

         inorder1(root.right);

         System.out.println();

     }

     private void inorder1(Node r)

     {


//System.out.println("in inorder()");


         if (r != null)

         {

             inorder1(r.left);

             char c = 'b';

             if (r.color == 0)

                 c = 'r';

            System.out.print(" "+"("+c+")"+":"+r.key+":'"+r.value+"'");


             inorder1(r.right);

         }

     }


 public void genDebugDot(String filename){}


 public String search(int key){ return "";}


 public void delete(int key){}


 public void printPreOrder(){}

 public void printPostOrder(){}


}
///////////////////////////////////////////////////


import java.util.ArrayList;
import java.util.List;

/**
   This class implements a red-black tree whose
   nodes hold objects that implement the Comparable
   interface.
*/
public class RedBlackTree
{  
   Node root; // Package access, for testing

   static final int BLACK = 1;
   static final int RED = 0;
   private static final int NEGATIVE_RED = -1;
   private static final int DOUBLE_BLACK = 2;

   /**
      Constructs an empty tree.
   */
   public RedBlackTree()
   {  
      root = null;
   }
   
   /**
      Inserts a new node into the tree.
      @param obj the object to insert
   */
   public void add(Comparable obj) 
   {  
      Node newNode = new Node();
      newNode.data = obj;
      newNode.left = null;
      newNode.right = null;
      if (root == null) { root = newNode; }
      else { root.addNode(newNode); }
      fixAfterAdd(newNode);
   }

   /**
      Tries to find an object in the tree.
      @param obj the object to find
      @return true if the object is contained in the tree
   */
   public boolean find(Comparable obj)
   {
      Node current = root;
      while (current != null)
      {
         int d = current.data.compareTo(obj);
         if (d == 0) { return true; }
         else if (d > 0) { current = current.left; }
         else { current = current.right; }
      }
      return false;
   }
   
   /**
      Tries to remove an object from the tree. Does nothing
      if the object is not contained in the tree.
      @param obj the object to remove
   */
   public void remove(Comparable obj)
   {
      // Find node to be removed

      Node toBeRemoved = root;
      boolean found = false;
      while (!found && toBeRemoved != null)
      {
         int d = toBeRemoved.data.compareTo(obj);
         if (d == 0) { found = true; }
         else 
         {
            if (d > 0) { toBeRemoved = toBeRemoved.left; }
            else { toBeRemoved = toBeRemoved.right; }
         }
      }

      if (!found) { return; }

      // toBeRemoved contains obj

      // If one of the children is empty, use the other

      if (toBeRemoved.left == null || toBeRemoved.right == null)
      {
         Node newChild;
         if (toBeRemoved.left == null) { newChild = toBeRemoved.right; }
         else { newChild = toBeRemoved.left; }

         fixBeforeRemove(toBeRemoved); 
         replaceWith(toBeRemoved, newChild);
         return;
      }
      
      // Neither subtree is empty

      // Find smallest element of the right subtree

      Node smallest = toBeRemoved.right;
      while (smallest.left != null)
      {
         smallest = smallest.left;
      }

      // smallest contains smallest child in right subtree
         
      // Move contents, unlink child

      toBeRemoved.data = smallest.data;
      fixBeforeRemove(smallest);
      replaceWith(smallest, smallest.right);
   }
   
   /**
      Yields the contents of the tree in sorted order
      @return all data items traversed in inorder, with a space after each item
   */
   public String toString()
   {  
      return toString(root);
   }  

   /**
      Yields the contents of the subtree with the given root in sorted order
      @param parent the root of the subtree
      @return all data items traversed in inorder, with a space after each item
   */
   private static String toString(Node parent)
   {  
      if (parent == null) { return ""; }
      return toString(parent.left) + parent.data + " " + toString(parent.right);
   }

   /**
      A node of a red-black tree stores a data item and references
      of the child nodes to the left and to the right. The color
      is the "cost" of passing the node; 1 for black or 0 for red.
      Temporarily, it may be set to 2 or -1. 
   */
   static class Node
   {  
      public Comparable data;
      public Node left;
      public Node right;
      public Node parent;
      public int color;
      
      /**
         Constructs a red node with no data.
      */
      public Node() {}
      
      /**
         Sets the left child and updates its parent reference.
         @param child the new left child
      */
      public void setLeftChild(Node child)
      {
         left = child;
         if (child != null) { child.parent = this; }
      }
      
      /**
         Sets the right child and updates its parent reference.
         @param child the new right child
      */
      public void setRightChild(Node child)
      {
         right = child;
         if (child != null) { child.parent = this; }
      }
      
      /**
         Inserts a new node as a descendant of this node.
         @param newNode the node to insert
      */
      public void addNode(Node newNode)
      {  
         int comp = newNode.data.compareTo(data);
         if (comp < 0)
         {  
            if (left == null) 
            {
               left = newNode;
               left.parent = this;
            }
            else { left.addNode(newNode); }
         }
         else if (comp > 0)
         {  
            if (right == null) 
            {
               right = newNode;
               right.parent = this;
            }
            else { right.addNode(newNode); }
         }
      }
   }

   /**
      Updates the parent's and replacement node's links when this node is replaced.
      Also updates the root reference if it is replaced.
      @param toBeReplaced the node that is to be replaced
      @param replacement the node that replaces that node
   */
   private void replaceWith(Node toBeReplaced, Node replacement)
   {
      if (toBeReplaced.parent == null) 
      { 
         replacement.parent = null; 
         root = replacement; 
      }
      else if (toBeReplaced == toBeReplaced.parent.left) 
      { 
         toBeReplaced.parent.setLeftChild(replacement); 
      }
      else 
      { 
         toBeReplaced.parent.setRightChild(replacement); 
      }
   }

   /**
      Restores the tree to a red-black tree after a node has been added.
      @param newNode the node that has been added
   */
   private void fixAfterAdd(Node newNode)
   {
      if (newNode.parent == null) 
      { 
         newNode.color = BLACK; 
      }
      else
      {
         newNode.color = RED;
         if (newNode.parent.color == RED) { fixDoubleRed(newNode); }
      }
   }

   /**  
     Fixes the tree so that it is a red-black tree after a node has been removed.
     @param toBeRemoved the node that is to be removed
   */
   private void fixBeforeRemove(Node toBeRemoved)
   {
      if (toBeRemoved.color == RED) { return; }

      if (toBeRemoved.left != null || toBeRemoved.right != null) // It is not a leaf
      {
         // Color the child black
         if (toBeRemoved.left == null) { toBeRemoved.right.color = BLACK; }
         else { toBeRemoved.left.color = BLACK; }
      }    
      else { bubbleUp(toBeRemoved.parent); }
   }
   
   /**
      Move a charge from two children of a parent
      @param parent a node with two children, or null (in which case nothing is done)
   */
   private void bubbleUp(Node parent)
   {
      if (parent == null) { return; }
      parent.color++;
      parent.left.color--;
      parent.right.color--;
     
      if (bubbleUpFix(parent.left)) { return; }
      if (bubbleUpFix(parent.right)) { return; }

      if (parent.color == DOUBLE_BLACK) 
      { 
         if (parent.parent == null) { parent.color = BLACK; }
         else { bubbleUp(parent.parent); }
      }
   }

   /**
      Fixes a negative-red or double-red violation introduced by bubbling up.
      @param child the child to check for negative-red or double-red violations
      @return true if the tree was fixed
   */
   private boolean bubbleUpFix(Node child)
   {
      if (child.color == NEGATIVE_RED) { fixNegativeRed(child); return true; }
      else if (child.color == RED)
      {
         if (child.left != null && child.left.color == RED) 
         { 
            fixDoubleRed(child.left); return true;
         }
         if (child.right != null && child.right.color == RED) 
         { 
            fixDoubleRed(child.right); return true;
         }
      }
      return false; 
   }
   
   /**
      Fixes a "double red" violation.
      @param child the child with a red parent
   */
   private void fixDoubleRed(Node child)
   {
      Node parent = child.parent;      
      Node grandParent = parent.parent;
      if (grandParent == null) { parent.color = BLACK; return; }
      Node n1, n2, n3, t1, t2, t3, t4;
      if (parent == grandParent.left)
      {
         n3 = grandParent; t4 = grandParent.right;
         if (child == parent.left)
         {
            n1 = child; n2 = parent;
            t1 = child.left; t2 = child.right; t3 = parent.right;
         }
         else
         {
            n1 = parent; n2 = child;
            t1 = parent.left; t2 = child.left; t3 = child.right; 
         }
      }
      else
      {
         n1 = grandParent; t1 = grandParent.left;
         if (child == parent.left)
         {
            n2 = child; n3 = parent;
            t2 = child.left; t3 = child.right; t4 = parent.right;
         }
         else
         {
            n2 = parent; n3 = child;
            t2 = parent.left; t3 = child.left; t4 = child.right; 
         }         
      }
      
      replaceWith(grandParent, n2);      
      n1.setLeftChild(t1);
      n1.setRightChild(t2);
      n2.setLeftChild(n1);
      n2.setRightChild(n3);
      n3.setLeftChild(t3);
      n3.setRightChild(t4);
      n2.color = grandParent.color - 1; 
      n1.color = BLACK;
      n3.color = BLACK;

      if (n2 == root)
      {
         root.color = BLACK;
      }
      else if (n2.color == RED && n2.parent.color == RED)
      {
         fixDoubleRed(n2);
      }
   }
   
   /**
      Fixes a "negative red" violation.
      @param negRed the negative red node
   */
   private void fixNegativeRed(Node negRed)
   {  
      Node parent = negRed.parent;
      Node child;
      if (parent.left == negRed)
      {
         Node n1 = negRed.left;
         Node n2 = negRed;
         Node n3 = negRed.right;
         Node n4 = parent;
         Node t1 = n3.left;
         Node t2 = n3.right;
         Node t3 = n4.right;
         n1.color = RED;
         n2.color = BLACK;
         n4.color = BLACK;

         replaceWith(n4, n3);
         n3.setLeftChild(n2);
         n3.setRightChild(n4);
         n2.setLeftChild(n1);
         n2.setRightChild(t1);
         n4.setLeftChild(t2);
         n4.setRightChild(t3);

         child = n1;
      }
      else // Mirror image
      {
         Node n4 = negRed.right;
         Node n3 = negRed;
         Node n2 = negRed.left;
         Node n1 = parent;
         Node t3 = n2.right;
         Node t2 = n2.left;
         Node t1 = n1.left;
         n4.color = RED;
         n3.color = BLACK;
         n1.color = BLACK;

         replaceWith(n1, n2);
         n2.setRightChild(n3);
         n2.setLeftChild(n1);
         n3.setRightChild(n4);
         n3.setLeftChild(t3);
         n1.setRightChild(t2);
         n1.setLeftChild(t1);

         child = n4;
      }
     
      if (child.left != null && child.left.color == RED) 
      { 
         fixDoubleRed(child.left); 
      }
      else if (child.right != null && child.right.color == RED) 
      { 
         fixDoubleRed(child.right);  
      }
   }
}

















