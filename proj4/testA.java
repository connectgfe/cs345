import java.io.*;




public class testA{

  public static void main(String[] args){


//   Proj04_AVL_student tree = new Proj04_AVL_student();
   Btree_test tree = new Btree_test();
   
   tree.insert(1);
   tree.insert(10);   
   tree.insert(15);

   tree.printPreOrder();

   tree.insert(30);
   tree.insert(23);
//  tree.insert(85);   
   tree.insert(44);

   tree.printPreOrder();



/*
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




*/
  }



}
