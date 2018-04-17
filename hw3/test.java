import java.io.*;

public class test{


  public static void main(String[] args){
  

   Hw03_CoolSort sort = new Hw03_CoolSort();


   sort.insert(10);
   sort.insert(5);
   sort.insert(18);
   sort.insert(7);
   sort.insert(13);
   sort.insert(11);
   sort.insert(6);



  try{
  Hw03_GenDotFile.gen(sort.root,"test1_dub");
  }catch(IOException e){}

   sort.printCool();

   System.out.println("ran mthd");

//   sort.root=sort.recursiveTransform(sort.root);
//     sort.callTransform();

   int val=sort.get(0);

   System.out.println("get_ret 1 :"+val);
/*
   int val2=sort.get(0);

   System.out.println("get_ret 2 :"+val2);
*/

  try{
  Hw03_GenDotFile.gen(sort.root,"test3_pic_A");
  }catch(IOException e){}

   sort.printCool();



   sort.insert(16);
   sort.insert(4);
   sort.insert(8);
   sort.insert(17);
   sort.insert(3);
   sort.insert(1);
   sort.insert(33);



  try{
  Hw03_GenDotFile.gen(sort.root,"test3_pic_B");
  }catch(IOException e){}

   sort.printCool();


   int val3=sort.get(0);

   System.out.println("get_ret 3 :"+val3);

  try{
  Hw03_GenDotFile.gen(sort.root,"test3_pic_C");
  }catch(IOException e){}

   sort.printCool();




/*
   System.out.println("ran mthd");

   sort.callTransform();

  try{
  Hw03_GenDotFile.gen(sort.root,"test1_pic_C");
  }catch(IOException e){}

   sort.printCool();

   System.out.println("ran mthd");

   sort.callTransform();

  try{
  Hw03_GenDotFile.gen(sort.root,"test1_pic_D");
  }catch(IOException e){}

   sort.printCool();

*/


//   System.out.println("ran mthd");
 
//   sort.transform(sort.root);


//   sort.printCool();



  }



}
