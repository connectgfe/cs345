import java.io.*;



public class TestProj3 {


  public static void main(String[] args) throws IOException{


    Proj03_BST_student test1 = new Proj03_BST_student();

/*
    test1.insert(8,"m");
    test1.insert(6,"m");
 
    test1.insert(10,"m");
    test1.insert(12,"m");
    test1.insert(11,"m");
    test1.insert(14,"m");
*/

    test1.insert(8,"m");
    test1.insert(7,"m");
 
    test1.insert(5,"m");
    test1.insert(6,"m");
    test1.insert(4,"m");
    test1.insert(9,"m");




    test1.printPreOrder();
    System.out.println();



//   test1.rotateRight(7);


//   test1.rotateRight(5);

//    test1.printPreOrder();

//    System.out.println();



//    Proj03_GenDotFile t1 = new Proj03_GenDotFile();
//    t1.gen(test1.root,"test_3.dot");

    Proj03_GenDotFile.gen(test1.root,"test_3.dot");



/*    
//    test1.genDebugDot("test_2.dot"); 

    test1.insert(0,"three");
    test1.insert(10,"eight");
    test1.insert(20,"nine");

//    test1.printPreOrder();
*/


/*
    PrintWriter writer = new PrintWriter("test_it_graph.dot");   

                writer.println("digraph M {");
                writer.println("a -> b -> c;");
                writer.println("b -> d;");
                writer.println("}");
         
        writer.close();
        
*/
  }


}
