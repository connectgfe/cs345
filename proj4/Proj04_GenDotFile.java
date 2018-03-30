/*Author: G Esposito
* Function: takes bst node and creates dot file
*
*/

import java.io.*;
import java.util.LinkedList;

public class Proj04_GenDotFile
{


   private static LinkedList<Proj04_BSTNode> nodeList;
 

   public Proj04_GenDotFile(){

  }


  public static void gen(Proj04_BSTNode rt, String val) throws IOException{ 

    PrintWriter writer = null;

    nodeList = new LinkedList<Proj04_BSTNode>();


//    prePrint(root);

    makeList(rt, nodeList);

    try{
    writer = new PrintWriter(val);
    }catch(FileNotFoundException fne){
    }

    writer.println("digraph M {");


    for(Proj04_BSTNode node : nodeList){

      if(node.left !=null){   
        writer.println(node.key+" ->  "+node.left.key+" [label=\"L\"] ;");}
      if(node.right !=null){  
        writer.println(node.key+" ->  "+node.right.key+" [label=\"R\"] ;");}
           
    }

    writer.println("}");
    writer.close();

  }


    static void  makeList(Proj04_BSTNode root, LinkedList<Proj04_BSTNode> nodeList) {

        if (root != null) {

            nodeList.add(root);

            makeList(root.left, nodeList);
            makeList(root.right, nodeList);
 
        }
    }

 public static void prePrint(Proj04_BSTNode root){

   preorderPrint(root);
 }

  public static void preorderPrint(Proj04_BSTNode root) {
        if (root != null) {
            System.out.print(root.key+" "+root.value);
            preorderPrint(root.left);
// System.out.println("end left");

            preorderPrint(root.right);
// System.out.println("end right");

        }
    }




}


