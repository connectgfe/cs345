 /* Class RBTree */

public  class Proj05_RedBlack_student implements Proj04_Dictionary

 {

     private RedBlackNode current;

     private RedBlackNode parent;

     private RedBlackNode grand;

     private RedBlackNode great;

     private RedBlackNode header;    

     private static RedBlackNode nullNode;

     /* Black - 1  RED - 0 */


static{
         nullNode = new RedBlackNode(0,null);

         nullNode.left = nullNode;

         nullNode.right = nullNode;
}



     static final int BLACK = 1;    

     static final int RED   = 0;

 

     /* Constructor */

     public Proj05_RedBlack_student()

     {

/*
         nullNode = new RedBlackNode(0,null);

         nullNode.left = nullNode;

         nullNode.right = nullNode;
*/
         header = new RedBlackNode(0,null);

         header.left = nullNode;

         header.right = nullNode;

     }

     /* Function to check if tree is empty */

     public boolean isEmpty()

     {

         return header.right == nullNode;

     }

     /* Make the tree logically empty */

     public void makeEmpty()

     {

         header.right = nullNode;

     }

     /* Function to insert item */

     public void insert(int item , String val)

     {
System.out.println("in");
 
//System.out.println("inserted "+item+":"+val);
         current = parent = grand = header;

         nullNode.element = item;
         nullNode.value = val;


         while (current.element != item)

         {            

System.out.println("while1");
 
             great = grand; 

             grand = parent; 

             parent = current;

             if(item < current.element){

                 current =  current.left;

             }else{

                 current = current.right;
             }

//             current = item < current.element ? current.left : current.right;




             // Check if two red children and fix if so            

             if (current.left.color == RED && current.right.color == RED)

System.out.println("while2");
 

                 handleReorient( item );

         }

         // Insertion fails if already present

         if (current != nullNode){

             return;
         }

         current = new RedBlackNode(item, val, nullNode, nullNode);

         // Attach to parent

         if (item < parent.element)

             parent.left = current;

         else

             parent.right = current;        

         handleReorient( item );

     }

     private void handleReorient(int item)

     {

         // Do the color flip

         current.color = RED;

         current.left.color = BLACK;

         current.right.color = BLACK;

 

         if (parent.color == RED)   

         {

             // Have to rotate

             grand.color = RED;

             if (item < grand.element != item < parent.element)

                 parent = rotate( item, grand );  // Start dbl rotate

             current = rotate(item, great );

             current.color = BLACK;

         }

         // Make root black

         header.right.color = BLACK; 
printInOrder();



     }      

     private RedBlackNode rotate(int item, RedBlackNode parent)

     {

         if(item < parent.element){

             if(item < parent.left.element){
   
                return parent.left =  rotateWithLeftChild(parent.left);
             }else{
        
               return parent.left = rotateWithRightChild(parent.left) ;  
             }

//             return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  

          }else{

             if(item < parent.right.element){

               return parent.right = rotateWithLeftChild(parent.right);
             }else{
 

             return parent.right =  rotateWithRightChild(parent.right);  
             }
 
          
//             return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  

         } 



     }

     /* Rotate binary tree node with left child */

     private RedBlackNode rotateWithLeftChild(RedBlackNode k2)

     {

         RedBlackNode k1 = k2.left;

         k2.left = k1.right;

         k1.right = k2;

         return k1;

     }

     /* Rotate binary tree node with right child */

     private RedBlackNode rotateWithRightChild(RedBlackNode k1)

     {

         RedBlackNode k2 = k1.right;

         k1.right = k2.left;

         k2.left = k1;

         return k2;

     }

     /* Functions to count number of nodes */

     public int countNodes()

     {

         return countNodes(header.right);

     }

     private int countNodes(RedBlackNode r)

     {

         if (r == nullNode)

             return 0;

         else

         {

             int l = 1;

             l += countNodes(r.left);

             l += countNodes(r.right);

             return l;

         }

     }

     /* Functions to search for an element */




     public String search(int val)

     {

         return search2(header.right, val);

     }

     private String search2(RedBlackNode r, int val)

     {


         while (r != nullNode) 
         {

             int rval = r.element;

             if (val < rval)

                 r = r.left;

             else if (val > rval)

                 r = r.right;

             else

             {

                 return r.value;


             }

             search2(r, val);

         }

         return null;

     }

     /* Function for inorder traversal */ 

     public void printInOrder()

     {

         inorder1(header.right);

         System.out.println();

     }

     private void inorder1(RedBlackNode r)

     {


//System.out.println("in inorder()");


         if (r != nullNode)

         {

             inorder1(r.left);

             char c = 'b';

             if (r.color == 0)

                 c = 'r';

            System.out.print(" "+"("+c+")"+":"+r.element+":'"+r.value+"'");


             inorder1(r.right);

         }

     }

     /* Function for preorder traversal */

     public void printPreOrder()

     {

         preorder1(header.right);

         System.out.println();

     }

     private void preorder1(RedBlackNode r)

     {

         if (r != nullNode)

         {

             char c = 'b';

             if (r.color == 0)

                 c = 'r';

            System.out.print(" "+"("+c+")"+":"+r.element+":'"+r.value+"'");


             preorder1(r.left);             

             preorder1(r.right);

         }

     }

     /* Function for postorder traversal */

     public void printPostOrder()

     {

         postorder1(header.right);

         System.out.println();

     }

     private void postorder1(RedBlackNode r)

     {

         if (r != nullNode)

         {

             postorder1(r.left);             

             postorder1(r.right);

             char c = 'b';

             if (r.color == 0)

                 c = 'r';

            System.out.print(" "+"("+c+")"+":"+r.element+":'"+r.value+"'");


         }

     }     

     public void genDebugDot(String file){}

 
     public void delete(int key){}





 }
