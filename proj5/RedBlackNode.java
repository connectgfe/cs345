 


public class RedBlackNode

 {    

     RedBlackNode left, right;

     int element;

     public String value;

     int color;

 

     /* Constructor */

     public RedBlackNode(int theElement, String val)

     {

         this( theElement, val, null ,null);

     } 

     /* Constructor */

     public RedBlackNode(int theElement, String val, RedBlackNode lt, RedBlackNode rt)

     {

         left = lt;

         right = rt;

         element = theElement;

         color = 1;

         value=val; 
         

     }    

 }
