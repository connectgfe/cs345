

public class Proj05_RedBlack_student implements Proj04_Dictionary {


   class Node extends Proj05_RedBlackNode{

     Node parent;
     Node right, left;
     int color;

     public Node(int key, String value){
       super(key,value);
       this.color=0;


     }

    }



    private Node root;
    private final int RED = 0;
    private final int BLACK = 1;


    public Proj05_RedBlack_student() {
 
       root=null;

    }


   public boolean isEmpty() {
	    return (root == null);
    }


    public void insert(int key, String value) {

       if(search(key)!=null){


          throw new IllegalArgumentException("Attempt to insert a duplicate key '"+key+"'");

         }else{



    	Node x = insertHelper(key, value);
        }

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


  public Node searchTree(Node root, int key){

    if (root==null || root.key==key)
        return root;

    if (root.key > key)
        return searchTree(root.left, key);

    if (root.key < key)
        return searchTree(root.right, key);

    return null;
  }








    private void rotateLeft(Node x) {
    	Node y = x.right;

    	x.right = y.left;
    	if (y.left != null)
    	    y.left.parent = x;

    	y.parent = x.parent;
    	if (x.parent == null)
    		root = y;
    	else {
    	    if (x == x.parent.left)
    	        x.parent.left = y;
      	    else
    	        x.parent.right = y;
    	}
    	y.left = x;
    	x.parent = y;
    }


    private void rotateRight(Node y) {
    	Node x = y.left;

    	y.left = x.right;

    	if (x.right != null)
    	    x.right.parent = y;

    	x.parent = y.parent;

    	if (y.parent == null)
    	    root = x;
    	else {
    	    if (y == y.parent.left)
    	        y.parent.left = x;
    	    else
    	        y.parent.right = x;
    	}

    	x.right = y;
    	y.parent = x;
    }


    public int compare(int x, int y){

     if(x<y) { return -1;}

      return 1;

    }


    private int color(Node x) {
    	if (x == null)
    	    return BLACK;
    	else
    	    return (x.color);
    }



    private Node insert2(Node z) {
    	Node x = root;
    	Node y = null;
    	int	i;

    	while (x != null) {
    	    y = x;
    	    x = (compare(x.key, z.key) > 0) ? x.left : x.right;
    	}
    	z.parent = y;
    	if (y == null) {
    	    root = z;
    	} else {
    	    i = compare(y.key, z.key);
    	    if (i > 0)
    	        y.left = z;
    	    else if (i < 0)
        		y.right = z;
    	    else { 
        		String t = z.value;		
        		z.value = y.value;
        		y.value = t;
        		return (z);		
    	    }
    	}
    	return (null);
    }



    private  Node insertHelper(int key, String val) {
    	Node x = new Node(key, val);
    	Node y;
    	Node v = null;

    	v = insert2(x);
    	if (v != null) {
    	    return (v);
    	}
    	x.color = RED;

    	while ((x != root) && (x.parent.color == RED)) {

    	    if (x.parent == x.parent.parent.left) {
        		y = x.parent.parent.right;
        		if ((y != null) && (y.color == RED)) {
        		    x.parent.color = BLACK;
        		    y.color = BLACK;
        		    x.parent.parent.color = RED;
        		    x = x.parent.parent;
        		} else {
        		    if (x == x.parent.right) {
            			x = x.parent;
            			rotateLeft(x);
        		    }
        		    x.parent.color = BLACK;
        		    x.parent.parent.color = RED;
        		    rotateRight(x.parent.parent);
        		}
    	    } else {
        		y = x.parent.parent.left;
        		if ((y != null) && (y.color == RED)) {
        		    x.parent.color = BLACK;
        		    y.color = BLACK;
        		    x.parent.parent.color = RED;
        		    x = x.parent.parent;
        		} else {
        		    if (x == x.parent.left) {
            			x = x.parent;
            			rotateRight(x);
        		    }
        		    x.parent.color = BLACK;
        		    x.parent.parent.color = RED;
        		    rotateLeft(x.parent.parent);
        		}
    	    }
    	}
    	root.color = BLACK;
    	return null;
    }



     public void printInOrder()

     {

         inorder1(root);

     }

     private void inorder1(Node r)

     {


         if (r != null)

         {

             inorder1(r.left);

             char c = 'r';

             if (r.color == 1)

                 c = 'b';

            System.out.print(" "+"("+c+")"+":"+r.key+":'"+r.value+"'");


             inorder1(r.right);

         }

     }

     public void printPreOrder()

     {

         preorder1(root);

     }

     private void preorder1(Node r)

     {


         if (r != null)

         {


             char c = 'r';

             if (r.color == 1)

                 c = 'b';

            System.out.print(" "+"("+c+")"+":"+r.key+":'"+r.value+"'");


             preorder1(r.left);
             preorder1(r.right);

         }

     }


     public void printPostOrder()

     {

         postorder1(root);

     }

     private void postorder1(Node r)

     {


         if (r != null)

         {

             postorder1(r.left);

             postorder1(r.right);
             char c = 'r';

             if (r.color == 1)

                 c = 'b';

            System.out.print(" "+"("+c+")"+":"+r.key+":'"+r.value+"'");



         }

     }









 public void genDebugDot(String filename){}




 public void delete(int key){}





}
