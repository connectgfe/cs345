/*Author: G Esposito
* Function: takes bst node and creates dot file
*
*/

import java.io.*;
import java.util.LinkedList;

public class Hw03_GenDotFile
{


   private static LinkedList<Hw03_CoolSortNode> nodeList;
 

   public Hw03_GenDotFile(){

  }




  public static void gen(Hw03_CoolSortNode rt, String val) throws IOException{ 

    PrintWriter writer = null;

    nodeList = new LinkedList<Hw03_CoolSortNode>();


//    prePrint(root);

    makeList(rt, nodeList);

    try{
    writer = new PrintWriter(val);
    }catch(FileNotFoundException fne){
    }

    writer.println("digraph M {");


    for(Hw03_CoolSortNode node : nodeList){

      if(node.unsorted !=null){   
        writer.println(node.key+" ->  "+node.unsorted.key+" [label=\"U\"] ;");}
      if(node.sorted !=null){  
        writer.println(node.key+" ->  "+node.sorted.key+" [label=\"S\"] ;");}
           
    }

    writer.println("}");
    writer.close();

  }


    static void  makeList(Hw03_CoolSortNode root, LinkedList<Hw03_CoolSortNode> nodeList) {

        if (root != null) {

            nodeList.add(root);

            makeList(root.unsorted, nodeList);
            makeList(root.sorted, nodeList);
 
        }
    }

 public static void prePrint(Hw03_CoolSortNode root){

   preorderPrint(root);
 }

  public static void preorderPrint(Hw03_CoolSortNode root) {
        if (root != null) {
            System.out.print(root.key+" ");
            preorderPrint(root.unsorted);
// System.out.println("end left");

            preorderPrint(root.sorted);
// System.out.println("end right");

        }
    }




}


