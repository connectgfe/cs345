import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.*;
import java.lang.*;
import java.io.*; 




public class Proj05_HashTable_student implements Proj04_Dictionary{


   LinkedList<Proj05_HashTableEntry> table;
   int table_size;
   int cnt;
   

   public Proj05_HashTable_student(){

     table= new LinkedList<Proj05_HashTableEntry>();

     resizeTable(4);     
 
   }


   public void resizeTable(int k){

     table = new LinkedList<Proj05_HashTableEntry>();

     for(int i=0;i<k;i++){
             table.add(i,null); 
     }
    
     table_size=k;
     cnt=0;

   }


    public void insert(int key, String value){

      if(2*cnt==table_size){

//System.out.println("table pre resize, table_size table.size(): "+table_size+" "+table.size());
//printTable2();

          LinkedList<Proj05_HashTableEntry> temp= table;
          resizeTable(2*table_size);
//System.out.println("new table_size, temp "+table_size+" "+temp.size());


       for(int i=0;i<temp.size();i++){

          Proj05_HashTableEntry cur = temp.get(i);

          if(cur!=null){

//System.out.println("resinserting from head of list: "+cur.key);
              insert2(cur.key,cur.value);

           while(cur.next!=null){

           
             cur=cur.next;

//System.out.println("resinserting after head: "+cur.key);
             insert2(cur.key,cur.value);
           
            }
          } 
        }
    
      insert2(key,value);

           
      }else{
        insert2(key,value);
       

      }

  }


    public void insert2(int key, String value){



       if(table.get((key*3721)%table_size)==null){
//System.out.println("insert set head: "+key);

         table.set((key*3721)%table_size, new Proj05_HashTableEntry(key,value));
 

         cnt++;

       }else{

         insertToLink(table.get((key*3721)%table_size), key, value);
       }

    }






  public void insertToLink(Proj05_HashTableEntry head, int key, String value){

//System.out.println("insert "+key);

      if(head.key>key){
//System.out.println("insert change head");


      Proj05_HashTableEntry entry  = new Proj05_HashTableEntry(head.key,head.value);

      entry.next=head.next;
      head.next=entry;
      head.key=key;
      head.value=value;
      cnt++;


    }else{

      insertHelper(head,key,value);

    }

  }



  public void insertHelper( Proj05_HashTableEntry head, int key, String value){
//System.out.println("insert helper "+key);


    Proj05_HashTableEntry cur  = head;

    Proj05_HashTableEntry entry  = new Proj05_HashTableEntry(key,value);

    Proj05_HashTableEntry beg = null;

    Proj05_HashTableEntry temp;

    while(cur.next!=null){

//System.out.println("cur.key "+cur.key);
      //insert
      if(cur.next.key>=key){

        temp=cur.next;

        cur.next=entry;

        entry.next=temp;

        cnt++;

        return;
      }
      cur=cur.next;

    }

    cur.next=entry;
    cnt++;
   
    return;

  }






  /* String search(int)
   *
   * Searches the tree for a given key; returns the associated String
   * if the key is found, or null if it is not found.
   */
  public String search(int key){ return "";}


  /* void delete(int)
   *
   * Removes a given node from the tree, found by the key.
   *
   * Throws IllegalArgumentException if the key does not exist.
   */
  public void   delete(int key){}


  /* void printInOrder()
   *
   * Performs an in-order traversal of the tree, and prints out all of
   * the nodes.  It does *not* print out a trailing newline.
   *
   * For each node, it prints both the key and the value, separated by
   * a colon; the various nodes are separated by a space.  (There is
   * also a space before the first node.)
   *
   * If the tree is empty, then it will not print out anything.
   */


  public void sort(){

      LinkedList<Proj05_HashTableEntry> sort = new  LinkedList<Proj05_HashTableEntry>(); 


        for(int i=0;i<table.size();i++){

          Proj05_HashTableEntry cur = table.get(i);

          if(cur!=null){

             sort.add(cur);

             while(cur.next!=null){
      
               cur=cur.next;

               sort.add(cur);

             }
           } 
         }



 Collections.sort(sort, (a, b) -> a.key < b.key ? -1 :  1);



      printList(sort); 
      
  }


  public void printTable2(){



        for(int i=0;i<table.size();i++){

          Proj05_HashTableEntry cur = table.get(i);

          if(cur!=null){

    System.out.println("head: "+cur.key);

             while(cur.next!=null){
      
               cur=cur.next;

    System.out.println(cur.key);

             }

           }else{
    System.out.println("no head "+0);

           }

         }

  }




  public void printList( LinkedList<Proj05_HashTableEntry> list){

    for( Proj05_HashTableEntry r : list ){
    
//      System.out.println(val.key+" "+val.value);

        System.out.print(" "+r.key+":'"+r.value+"'");



    }


  }




  public void printTable(){


//   for(int i=0;i<table_size;i++){
   for(int i=0;i<table_size;i++){

     if(table.get(i)==null){
     System.out.println(0);
     }
 

     if(table.get(i)!=null){
       printHelper(table.get(i));
     }
   }

System.out.println();
  
  }



  public Proj05_HashTableEntry printHelper(Proj05_HashTableEntry head){


      if(head.next== null){ 
         System.out.println(head.key);
         return head;
       }

      System.out.println(head.key);
     
      return printHelper(head.next);


  }


  /* void printPreOrder()
   *
   * Same as printInOrder(), except that it performs a pre-order
   * traversal.
   */
  public void printPreOrder(){

    sort();
  }


  public void printInOrder(){

    sort();
   }



  /* void printPostOrder()
   *
   * Same as printInOrder(), except that it performs a post-order
   * traversal.
   */
  public void printPostOrder(){

    sort();
   }


  /* void genDebugDot(String)
   *
   * Generates a \texttt{.dot} file which represents the tree; the
   * String is the name of the file to generate.
   */
  public void genDebugDot(String filename){}












}
