/* Author: Giulio Eposito
*  Program: RedBlack tree
*  Function: create a standard Red Black Tree with insert only
*/

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

// blank node for insertion
        	Node val = insertHelper(key, value);
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


/*
*  rotate functions are slightly modified to make use of parent pointer
*  
*/
    private void rotateLeft(Node rot) {

    	Node helper = rot.right;


    	rot.right = helper.left;

    	if (helper.left != null)

    	    helper.left.parent = rot;

    	helper.parent = rot.parent;

    	if (rot.parent == null)

    		root = helper;

// System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);
    	else {

    	    if (rot == rot.parent.left)


    	        rot.parent.left = helper;

      	    else

    	        rot.parent.right = helper;
    	}
// System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);
    	helper.left = rot;

    	rot.parent = helper;

// System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);
    }


    private void rotateRight(Node rot) {

    	Node helper = rot.left;

    	rot.left = helper.right;

    	if (helper.right != null)

// System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);
    	    helper.right.parent = rot;

    	helper.parent = rot.parent;

    	if (rot.parent == null)

    	    root = helper;
    	else {
// System.out.println("helper.key rot.key: "+helper.key+" "+rot.key);


    	    if (rot == rot.parent.left)
    	        rot.parent.left = helper;

    	    else
// System.out.println("helper.key rot.key: "+helper.key+" "+rot.key);



    	        rot.parent.right = helper;
    	}

    	helper.right = rot;
    	rot.parent = helper;
    }


/*
*  compare is a baby version of Comparable
*  uses convention val= (boolean) ?  x : y  
*/
    public int compare(int x, int y){

     if(x<y) { return -1;}

      return 1;

    }


    private int color(Node val) {
    	if (val == null)
    	    return BLACK;
    	else
    	    return (val.color);
    }


/*
*  insert2 places node in bst fashion, assigns parent pointer
*  
*/
    private Node insert2(Node ins) {


    	Node temp = root;

    	Node helper = null;
    	int	i;


    	while (temp != null) {

    	    helper = temp;

    	    temp = (compare(temp.key, ins.key) > 0) ? temp.left : temp.right;
// System.out.println("helper.key temp.key: "+helper.key+" "+temp.key);


       	}
  

  	ins.parent = helper;
     	if (helper == null) {

    	    root = ins;
    	} else {

    	    i = compare(helper.key, ins.key);
// System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);


    	    if (i > 0)
    	        helper.left = ins;

    	    else if (i < 0)

 // System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);

       		helper.right = ins;

    	    else { 

        		String t = ins.value;		

        		ins.value = helper.value;

        		helper.value = t;
// System.out.println("helper.key ins.key: "+helper.key+" "+ins.key);


        		return (ins);		
    	    }
    	}
    	return (null);
    }


/*
*  insertHelper handles the fix-up with many checks 
*  to node.parent and grand
*
*/
    private  Node insertHelper(int key, String value) {

    	Node val = new Node(key, value);
// System.out.println("val.key: "+val.key);
    	Node temp;


    	Node temp2 = null;

    	temp2 =insert2(val);
    	if (temp2 != null) {
    	    return (temp2);
    	}
    	val.color= RED;

    	while ((val!= root) && (val.parent.color== RED)) {

// System.out.println("val.key temp.key: "+val.key+" "+temp.key);
 	    if (val.parent== val.parent.parent.left) {
 
       		temp =val.parent.parent.right;
// System.out.println("val.key temp.key: "+val.key+" "+temp.key);

      		if ((temp!= null) && (temp.color== RED)) {
    
       		    val.parent.color =BLACK;

        		    temp.color =BLACK;
 // System.out.println("val.key: "+val.key);

 
        		    val.parent.parent.color= RED;
        		    val =val.parent.parent;

      		}else{
        		  
           if (val ==val.parent.right) {
            			val= val.parent;
            			rotateLeft(val);
        		    }

 // System.out.println("val.key temp.key: "+val.key+" "+temp.key);

      
   		    val.parent.color =BLACK;
 
  
      		    val.parent.parent.color= RED;

        		    rotateRight(val.parent.parent);

        		}

    	    }else{

        		temp =val.parent.parent.left;
// System.out.println("val.key: "+val.key);


        		if ((temp!= null) && (temp.color== RED)) {
 
        		    val.parent.color =BLACK;

          		    temp.color =BLACK;

        		    val.parent.parent.color= RED;

        		    val =val.parent.parent;


          		}else{
// System.out.println("val.key: "+val.key);


        		    if (val ==val.parent.left) {

            			val =val.parent;

            			rotateRight(val);
        		    }

        		    val.parent.color =BLACK;

           		    val.parent.parent.color= RED;

        		    rotateLeft(val.parent.parent);
        		  }
    	    
          }
       	}
// System.out.println("val.key: "+val.key);

     // recolor root
             	root.color= BLACK;

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
