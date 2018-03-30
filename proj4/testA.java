import java.io.*;




public class testA{

  public static void main(String[] args){

   Proj04_AVL_student tree = new Proj04_AVL_student();

   
   tree.insert(5,"five");
   tree.insert(10,"ten");   
   tree.insert(1,"one");
   tree.insert(3,"three");   
   tree.insert(9,"nine");
   tree.insert(7,"seven");   

   tree.printPreOrder();

   try{
  Proj04_GenDotFile.gen(tree.root,"test3");
  }catch(IOException e){}


   tree.insert(16,"sixteen");   


   try{
  Proj04_GenDotFile.gen(tree.root,"test4");
  }catch(IOException e){}


   tree.insert(6,"six");   

   try{
  Proj04_GenDotFile.gen(tree.root,"test5");
  }catch(IOException e){}





  }



}
