import java.io.*;



public class TestProj3 {


  public static void main(String[] args) throws IOException{


    Proj03_BST_student test1 = new Proj03_BST_student();


    test1.insert(3,"three");
    test1.insert(8,"eight");
    test1.insert(9,"nine");
    test1.insert(5,"five");
    test1.insert(1,"one");

/*

    test1.printInOrder();
    System.out.println();

    test1.printPostOrder();
    System.out.println();

    test1.printPreOrder();
//    test1.search(18);
    System.out.println();
*/

    Proj03_GenDotFile t1 = new Proj03_GenDotFile();
    t1.gen(test1.root,"test_3.dot");

    
//    test1.genDebugDot("test_2.dot"); 
/*
    test1.insert(0,"three");
    test1.insert(10,"eight");
    test1.insert(20,"nine");
*/
//    test1.printPreOrder();



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
