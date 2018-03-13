import java.io.*;



public class TestProj3 {


  public static void main(String[] args) throws IOException{


    Proj03_BST_student test1 = new Proj03_BST_student();

    test1.insert(3,"three");
    test1.insert(8,"eight");
    test1.insert(9,"nine");
    test1.insert(5,"five");

    test1.printInOrder();

    test1.search(18);

    test1.delete(8);

    test1.printInOrder();
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
