import java.util.LinkedList;





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
             table.add(i,new Proj05_HashTableEntry(0,"")); 
     }
    
     table_size=k;

   }


    public void insert(int key, String value){

      if(2*cnt==table_size){

          LinkedList<Proj05_HashTableEntry> temp= table;
          resizeTable(2*table_size);
        
          
      }


      insertToLink(table.get((key*3721)%table_size), key, value);


    }



  public void insertToLink(Proj05_HashTableEntry head, int key, String value){

System.out.println("insert "+key);


   if(head==null){
System.out.println("insert set head");

      head = new Proj05_HashTableEntry(key,value);
      cnt++;

    }else if(head.key>key){
System.out.println("insert change head");


      Proj05_HashTableEntry entry  = new Proj05_HashTableEntry(key,value);
      entry.next=head;
      head=entry;
      cnt++;

    }else{

      insertHelper(head,key,value);

    }

  }



  public void insertHelper( Proj05_HashTableEntry head, int key, String value){
System.out.println("insert helper "+key);


    Proj05_HashTableEntry cur  = head;

    Proj05_HashTableEntry entry  = new Proj05_HashTableEntry(key,value);

    Proj05_HashTableEntry beg = null;

    Proj05_HashTableEntry temp;

    while(cur.next!=null){

System.out.println("cur.key "+cur.key);
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
  public void printInOrder(){


//   for(int i=0;i<table_size;i++){
   for(int i=0;i<4;i++){


     if(table.get(i)!=null){
       printHelper(table.get(i));
     }
   }
  
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
  public void printPreOrder(){}




  /* void printPostOrder()
   *
   * Same as printInOrder(), except that it performs a post-order
   * traversal.
   */
  public void printPostOrder(){}


  /* void genDebugDot(String)
   *
   * Generates a \texttt{.dot} file which represents the tree; the
   * String is the name of the file to generate.
   */
  public void genDebugDot(String filename){}












}
