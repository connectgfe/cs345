import java.util.ArrayList;
import java.util.Scanner;



public class Proj02_Main{


  public static void main(String[] args){

     Proj02_DataPair[] vals = readInput();
    
     Proj02_HeapSort.sort(vals);

//     Proj02_CountingSort.sort2(vals,1);



  }

        private static Proj02_DataPair[] readInput()
        {
                ArrayList<Proj02_DataPair> vals_in = new ArrayList<Proj02_DataPair>();

                Scanner in = new Scanner(System.in);
                while (in.hasNextInt())
                {
                        Proj02_DataPair next = new Proj02_DataPair();
                        next.key   = in.nextInt();
                        next.value = in.next();      // a String

                        if (next.key < 0 || next.key >= 1000*1000)
                        {
                                System.out.printf("ERROR in the input: the key is out of range.  Min: 0   Max: 999,999   Actual: %d\n", next.key);
                                continue;
                        }

                        vals_in.add(next);
                }

                Proj02_DataPair[] vals = new Proj02_DataPair[vals_in.size()];
                for (int i=0; i<vals.length; i++)
                        vals[i] = vals_in.get(i);

                for (Proj02_DataPair v: vals)
                        System.out.printf("%d %s\n", v.key, v.value);
                System.out.printf("\n");

                return vals;
        }




}
