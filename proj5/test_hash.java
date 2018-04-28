

public class test_hash{


  public static void main(String[] args){

   Proj05_HashTable_student hash = new Proj05_HashTable_student();
/*
   hash.insert(5,"");
   hash.insert(15,"");
   hash.insert(35,"");
   hash.insert(21,"");

   hash.insert(52,"");

   hash.insert(95,"");

   hash.insert(23,"");
   hash.insert(91,"");
   hash.insert(50,"");
   hash.insert(9,"");
   hash.insert(34,"");
   hash.insert(99,"");
   hash.insert(28,"");
   hash.insert(88,"");
   hash.insert(20,"");
   hash.insert(29,"");
*/

   hash.insert( 12," nine(tree_0)");
   hash.insert( 16," nine(tree_0)");
   hash.insert( 22," nine(tree_0)");
   hash.insert( 6," fun(tree_0)");
   hash.insert( 23," nine(tree_0)");
   hash.insert( 15," nine(tree_0)");
   hash.insert( 7," nine(tree_0)");












//   System.out.println(hash.table_size);

//   hash.printTable();
   hash.printInOrder();
   System.out.println();
   hash.delete(16);
   hash.delete(6);



   hash.printInOrder();
   System.out.println();
 

  


  }




}

