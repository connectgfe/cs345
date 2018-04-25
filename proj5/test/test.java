

public class test{


  public static void main(String[] args){

    Proj04_Dictionary[] trees = new Proj04_Dictionary[4];
    trees[0] = new RBT(); 

    Proj04_Dictionary tree = trees[0];

 


    tree.insert(3,"tre" );
    tree.insert(8 , "ess");
    tree.insert(9 , "ss");
    tree.insert(5 , "dds");
    tree.insert(11 , "sdd");
    tree.insert(13 , "err");
    tree.insert(82 , "ee");
    tree.insert(90, "teww");
    tree.insert(53, "weew");
    tree.insert(21 ,"eee");
    tree.insert(43 , "ee");
    tree.insert( 18, "ewee");
    tree.insert( 2 , "eee");
    tree.insert( 55, "weew");
    tree.insert( 20, "rer");


    System.out.println("search for 2: "+tree.search(2));


    tree.printInOrder();
    tree.printPostOrder();
    












  }




}
