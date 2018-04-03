import java.util.LinkedList;



public class Btree_test{


/**
 * This is the {@link btree.Btree} class. We define the necessary variables and methods that we need to build the {@link btree.Btree}
 * data structure.
 * This class contains the following methods:
 * 1) The constructor of the B tree.
 * 2) Insert Method.
 * 3) Insert in None Full Node.
 * 4) Split Child Method.
 * 5) Delete Method.
 * 6) Search Method.
 * 7) Print Method.
 * @see Node
 * 
 * for CS 380 - Final Project: Implementation of B-Tree Data Structure
 * @since 12/01/2011
 * @author Abdulrhman Alkhodiry, Ahmed Alsalama
 */
    /**
     * Create a public root node
     */
    public Proj04_234Node root;

    /**
     * The B Tree Constructor.
     *  Create new root, assign the root node to be a isLeaf,and initial the key value in the root to -1 (null)
     */
    public Btree_test() {
        // new root
        root = new Proj04_234Node();
        // assign the root node to be a isLeaf
    //    root.isLeaf = true;
        root.numKeys = 0;
        // initial the key value in the root to -1 (null)
      //  root.key[0] = -1;
 //        root.key1 = -1;

    }


    public boolean isLeaf(Proj04_234Node root){

      if((root.childA == null) && (root.childB == null) && (root.childC == null) && (root.childD == null)){ return true;}
     
       return false;

    }

    /**
     * The Insert Method:
     * This method insert a key k into a B Tree.
     * The insert method takes one argument
     * The run time of the Insert Method is O(t log n)
     * 
     * @param k is the key that will be inserted into the node in the B Tree
     */
    public void insert(int k)
    {
        // root node r
        Proj04_234Node r = root;
        /* If the root node r is full, the root will be splited and the new node s will be the root
         * The new root ndoe s will have two children.
         * The height of the B Tree will grow by one when the root node r gets split
         */
        if (r.numKeys == 3) {
            // Create a new node s
            Proj04_234Node nn = new Proj04_234Node();
            // the new node s will become a new root node after root node r gets spilt
            // the new root node is no longer a isLeaf
        //    s.isLeaf = false;
         //   s.children[0] = r;

            root = nn;

            nn.numKeys=0;

            nn.childA = r;
            //Call the split method to split the node r because it is full
            splitChild(nn,0, r);

            insertNonFull(nn, k);



            //Call the insert in none full node method to insert the key k into the new node s

 //           insertNonfull(nn, k);
        } // If the root r node is not full, just insert the key k into it by calling the insert in none full node method
        else {
            insertNonFull(r, k);
        }
    }

    /**
     * The Insert in none full node Method:
     * This method insert a key k into a node that is already full.
     * The insert method takes two arguments: Node x, and integer k as a value
     * The run time of the Insert in None Full Node algorithm is: O(t log n).
     * 
     * 
     * @param node that the value will be inserted in.
     * @param value the value to be inserted
     */
    public void insertNonFull(Proj04_234Node x, int key) {
        // Alocate the node 
//         LinkedList<Proj04_234Node> nodeList = childArr(x);
//         int[] kArr = keyArr(x);

 
        int i = x.numKeys;
        // if the node is a isLeaf, we insert the value into the node 
        if (isLeaf(x)) {
           
           insertHelperA(x,key); 
                       
           x.numKeys++;
         }else{ 

         Proj04_234Node[] nodeArr = childArr(x);
         int[] kArr = keyArr(x);

/*
            while (i >= 1 && key < kArr[i - 1]) {
                i--;
            }
            i++;
            // if the node is full, split it.
            if (nodeList.get(i - 1).numKeys == 3) {
                // call the Split child method to split the node to two nodes
                splitChild(x, i, nodeList.get(i - 1));
                // Determine which of the two children is now the correct one to descend to.
                if (key > kArr[i - 1]) {
                    i++;
                }
            }
            // Recursive Call
            insertNonFull(nodeList.get(i - 1), key);
        }
    }

*/
         int j = 0;
          while(j < i  && key > kArr[j])//find spot to recurse
          {                  //on correct child     
          j++;
          }

    //  i++;

          if(nodeArr[j].numKeys == 3)
          {
           splitChild(x,j,nodeArr[j]);//call split on node x's ith child

           if(key > kArr[j])
             {
                j++;
             }
           }

           insertNonFull(nodeArr[j],key);//recurse
        }
  }



/*

//          if the node is not a isLeaf, the value will be inserted into the appropriate isLeaf node in the subtree. Also, it will be checking if the node is full; if yes then split the node.
        
            else {
            while (i >= 1 && value < node.key[i - 1]) {
                i--;
            }
            i++;
            // if the node is full, split it.
            if (node.children[i - 1].numberOfNodes == 3) {
                // call the Split child method to split the node to two nodes
                splitChild(node, i, node.children[i - 1]);
                // Determine which of the two children is now the correct one to descend to.
                if (value > node.key[i - 1]) {
                    i++;
                }
            }
            // Recursive Call
            insertNonfull(node.children[i - 1], value);
        }
*/


  public void insertHelperA(Proj04_234Node root, int key){

    if(root.numKeys==0){
      root.key1=key;
//System.out.println("case 1");
 
      return;
    }

    if(root.numKeys==1){
        if(root.key1<key){
            root.key2=key;
        }else{
         root.key2=root.key1;
         root.key1=key;
        }
//System.out.println("case 2");
 
      return;
    } 


    if(root.numKeys==2){

      if(key<root.key1){ 
       root.key3= root.key2;
       root.key2=root.key1;
       root.key1=key; 
       return; 
      }

      if(key<root.key2){ 
       root.key3= root.key2;
       root.key2=key;
 
       return;
      }
 
      root.key3=key;
//System.out.println("case 3");

     }
 
     
    }


    /**
     * The Split Child Method
     * It takes three arguments: Node x, int i, Node y
     * The Basic idea of split child is: if we want to insert a key value into a node we should 
     * check if the node is not full ( node can have at most 2*t-1 keys). If it is full, then we must
     * split the node into two node.
     * The Run Time of splitChild algorithm is: O(t), where t is a constant
     * Node y: is x’s i th child.
     * 
     * @param parentNode the Parent Node
     * @param childIndex The index of the element
     * @param newChild  
     */

    public void splitChild(Proj04_234Node x, int i, Proj04_234Node y) {
        // Create a new node z, z will be the new child of node x
        Proj04_234Node z = new Proj04_234Node();
     //   z.isLeaf = newChild.isLeaf;
        z.key1 = y.key3;
        z.numKeys = 1;   // fix it to t-1
        // if node y is not a isLeaf, assign the largest t-1 keys and child to the node z.
        if (!isLeaf(y)) {
            z.childB = y.childD;
            z.childA = y.childC;
        //    y.childD=null;
        //    y.childC=null;
        }

        

        if(i+1==1){x.childB=z;}
        if(i+1==2){x.childC=z;}
        if(i+1==3){x.childD=z;}

        insertHelperA(x,y.key2); 

        y.key2=0;
        y.key3=0;
      
        y.numKeys=y.numKeys-2;
    
        x.numKeys++;

   }

/*
   public LinkedList<Proj04_234Node> childArr(Proj04_234Node root){

    LinkedList<Proj04_234Node> list = new LinkedList<Proj04_234Node>();

    if(root.childA!=null){list.add(root.childA);}
    if(root.childB!=null){list.add(root.childB);}
    if(root.childC!=null){list.add(root.childC);}
    if(root.childD!=null){list.add(root.childD);}

    return list;

    }
*/

   public Proj04_234Node[] childArr(Proj04_234Node root){

    Proj04_234Node[] arr = new Proj04_234Node[4];

    arr[0]=root.childA;
    arr[1]=root.childB;
    arr[2]=root.childC;
    arr[3]=root.childD;

    return arr;



    }



    public int[] keyArr(Proj04_234Node root){

     int[] arr = new int[3];
     arr[0]= root.key1;
     arr[1]= root.key2;
     arr[2]= root.key3;
 
     return arr;

    }


    /**
     * The Search Method
     * The Search method is a straightforward method. If the key k is in the B Tree
     * , the method returns true. Otherwise return false.
     * The run time of the Search algorithm is : O(t log n).
     * 
     * @param node The node do be searched
     * @param value the value to search for.
     * @return True if found and false otherwise.
     */

/*
    public boolean search(Node node, int value) {
        // initial i to be equal to 1

        int i = 1;
        // find the smallest index i such that k<= x.keyi, or else set i to x.n ++
        while (i <= node.numberOfNodes && value > node.key[i - 1]) {
            //increment i
            i++;
        }
        // check if the key k is found
        if (i <= node.numberOfNodes && value == node.key[i - 1]) {
            // return true if the key k is found in the B Tree
            return true;
        }
        // if the x node is an internal node, terminate the search unsuccessful or recurse to search the appropriate subtree of node x.
         
        // if the x node is not a isLeaf
        if (!node.isLeaf) {
            // recursive call to search in the subtree of the node x
            return search(node.children[i - 1], value);
        }
        // return false if the key k is not found in the B Tree
        return false;
    }
/*
    /**
     * This method is use to make the search easier. We start the search from the root and going down to subtress
     * @param k the value to be searched for.
     * @return True if found and false otherwise.
     */

/*
    public boolean search(int k) {
        // assign the node x to be the root and start search from the root
        Node x = root;
        // send the root x and the key k as an arguments to the the method search above
        return search(x, k);
    }
*/


   public void printPreOrder(){


    printPre(root);

    System.out.println();

   }

  public void printPre(Proj04_234Node root){

    if (root != null)
        {
            if(root.numKeys==3){
             System.out.print(root.key1+" "+root.key2+" "+root.key3);
            }
            if(root.numKeys==2){
             System.out.print(root.key1+" "+root.key2);
            }
            if(root.numKeys==1){
             System.out.print(root.key1+" ");
            }

            printPre(root.childA);
            printPre(root.childB);
            printPre(root.childC);
            printPre(root.childD);


         }


  }

  



}
