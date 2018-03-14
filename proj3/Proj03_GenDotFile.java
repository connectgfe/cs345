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

public class Proj03_GenDotFile
{


   Proj03_BSTNode root;
   LinkedList<Proj03_BSTNode> nodeList;
   PrintWriter writer;
 

  public Proj03_GenDotFile(){

     root = null;
     nodeList = new LinkedList<Proj03_BSTNode>();

  }


  public void gen(Proj03_BSTNode root, String val){ 

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


  void makeList(Proj03_BSTNode root, LinkedList<Proj03_BSTNode> nodeList) {

        if (root != null) {
            nodeList.add(root);
            makeList(root.left, nodeList);
            makeList(root.right, nodeList);
 
        }
    }

}


