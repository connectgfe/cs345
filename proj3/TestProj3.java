import java.io.*;



public class TestProj3 {


  public static void main(String[] args) throws IOException{

    PrintWriter writer = new PrintWriter("test_it_graph.dot");   

                writer.println("digraph M {");
                writer.println("a -> b -> c;");
                writer.println("b -> d;");
                writer.println("}");
         
        writer.close();
        

  }


}
