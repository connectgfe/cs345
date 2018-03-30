import java.io.*;



public class testM{


 public static Proj03_BSTNode root;



 public static void main(String[] args){

     
 
  insert(10,"");
  insert(4,"");
  insert(16,""); 
  insert(9,"");
  insert(1,"");
  insert(14,"");

  try{
  Proj03_GenDotFile.gen(root,"test1");
  }catch(IOException e){}

 
  inordP(root);
   
  rotR(4);

  try{
  Proj03_GenDotFile.gen(root,"test2");
  }catch(IOException e){}




  inordP(root);
 

 }

  public static void rotR(int key){

    root=rr(root,key);

  }

  public static Proj03_BSTNode rr(Proj03_BSTNode root, int key) {

    if(root.left.key==key){

System.out.println("Got L");

    if(root.left.left==null){
System.out.println("Cant rr due to key LC == null");
       return root; 
    }

    Proj03_BSTNode temp1=root.left.left;
    Proj03_BSTNode temp2=root.left;

    temp2.left=null;
    temp1.right = temp2;
    root.left = temp1;

//    root.left = temp1;

      
        return root;


    }

    if(root.right.key==key){

System.out.println("Got R");

    if(root.right.left==null){
System.out.println("Cant rr due to key LC == null");
       return root; 
    }




        return root;
    }

    if(root.key<key){
        rr(root.right,key);
    }else{
        rr(root.left,key);
    }  

   return root;


  }


  public static void insert(int key, String value){

/*
        if(search(key)!=null){
          throw new IllegalArgumentException("Attempt to insert a duplicate key '"+key+"'");
         }else{
*/
          root = insertNode(root, key, value);

//       }


  }


   public static Proj03_BSTNode insertNode(Proj03_BSTNode root, int key, String value) {

        if (root == null) {
            root = new Proj03_BSTNode(key, value);
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, key, value);
        else if (key > root.key)
            root.right = insertNode(root.right, key, value);

        return root;
   }


 


  public static void inordP(Proj03_BSTNode root){

    if(root!=null){
      inordP(root.left);
      System.out.println(root.key);
      inordP(root.right);

    }
 }


}

