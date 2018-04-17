/* Homework 3 - Main file for the CoolSort algorithm
 *
 * Each CoolSort object represents a single instance of the algorithm.
 * When constructed, it is an empty collection.  You can use the insert()
 * method to add new keys to the collection.  The isEmpty() and count()
 * methods allow you to check to see if the collection has any values in
 * it, and if so how many; the get() method extracts the minimum value
 * from the collection.  (get() supports two "modes:" mode 0 was my
 * original design, which has terrible performance; mode 1 is a lot
 * smarter, and a lot faster.)
 */
import java.io.*;
import java.util.*;

public class Hw03_CoolSort
{
	public static Hw03_CoolSortNode root;
	  // defaults to null


	public void insert(int key)
	{
		root = new Hw03_CoolSortNode(key, root);
	}



	public boolean isEmpty()
	{
		return root == null;
	}
	public int count()
	{
		if (root == null)
			return 0;
		return root.count;
	}



	public int get(int mode)
	{
		if (root == null)
			throw new IllegalArgumentException("Cannot get() from an empty CoolSort");

		if (root.unsorted != null)
		{
			if (mode == 0)
			{
				while (root.unsorted != null){
					root = transform(root);
System.out.println("in get doing print");
printCool();
        }

			}
			else if (mode == 1)
				root = recursiveTransform(root);
			else
			{
				throw new IllegalArgumentException("Unsupported mode in get()");
			}
		}

		int retval = root.key;
		root = root.sorted;
		return retval;
	}



	public static Hw03_CoolSortNode transform(Hw03_CoolSortNode oldRoot)
	{


		// A -> B
		// |
		// C -> D
		// |
		// E

		if (oldRoot.unsorted == null)
			throw new IllegalArgumentException("transform(): The unsorted node is null");

System.out.println("**** tranform on : "+oldRoot.key);

		Hw03_CoolSortNode A = oldRoot;
		Hw03_CoolSortNode B = oldRoot.  sorted;
		Hw03_CoolSortNode C = oldRoot.unsorted;
		Hw03_CoolSortNode D = oldRoot.unsorted.  sorted;
		Hw03_CoolSortNode E = oldRoot.unsorted.unsorted;

		if (A.key < C.key)
		{
			// A -> C -> D
			// |    |
			// E    B
			A.  sorted = C;
			A.unsorted = E;
			C.unsorted = B;

			C.recalcCount();
			A.recalcCount();

System.out.println("r.k < r.u.k ret "+A.key);
			return A;
		}
		else
		{
			// C -> A -> B
			// |    |
			// E    D
			C.  sorted = A;
			C.unsorted = E;
			A.unsorted = D;

			A.recalcCount();
			C.recalcCount();
System.out.println("r.k > r.u.k ret "+C.key);
	

	
			return C;
		}
	}


	public static Hw03_CoolSortNode recursiveTransform(Hw03_CoolSortNode oldRoot)
	{
		Hw03_CoolSortNode curRoot = oldRoot;

System.out.println("rT: curRoot.key: "+curRoot.key);

		while (curRoot.unsorted != null &&
		       curRoot.unsorted.count > curRoot.count/2)
		{

System.out.println("In while do transf_1 on key: "+curRoot.key);


			curRoot = transform(curRoot);
		}

System.out.println("Out while now curRoot.key: "+curRoot.key);






		if (curRoot.unsorted != null)
		{
System.out.println("perform rec on curR.u.key: "+curRoot.unsorted.key);


			curRoot.unsorted = recursiveTransform(curRoot.unsorted);
System.out.println("In if do transf_2 on key: "+curRoot.key);


			curRoot = transform(curRoot);


		}
System.out.println("return curRoot cr.k= "+curRoot.key);

//printCool();

   if(curRoot.sorted!=null && curRoot.sorted.key==7){

 try{
  Hw03_GenDotFile.gen(root,"test2_pic_C");
  }catch(IOException e){}

//    System.exit(1);
   }


		return curRoot;
	}



	public void debug(String filename)
	{
		throw new UnsupportedOperationException("debug(): TODO: implement me");
	}


  public static void printCool(){

   if(root!=null){

   System.out.println("root.key: "+root.key);
   } 


   printIt(root);
   
  }

  public static void printIt(Hw03_CoolSortNode root){

   if(root==null){return;}

//     System.out.println("unsort");
     printIt(root.unsorted);


     System.out.print(root.key+" "+root.count);

     if(root.unsorted!=null){
       System.out.print(" r.unsrt.k: "+root.unsorted.key);
     }else{
       System.out.print(" no unsorted child");   
     }

     if(root.sorted!=null){
       System.out.print(" r.srt.k: "+root.sorted.key);
     }else{
       System.out.print(" no sorted child");   
     }

     System.out.println();


//     System.out.println("sort");
     printIt(root.sorted);
 
//     System.out.println("end");
 

   

  }


  public void callTransform(){

    root=transform(root);

  }


}

