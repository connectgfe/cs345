public class Merge
{


  public static void main(String[] args){

   int[] vals = {1,2,2,3,3,432,2,32,32,23};

   sortUD(vals);

   for(int i : vals){

    System.out.printf("%d\n",i);
   }

  }


public static void sortUD(int[] a)
 {
 int N = a.length;
 int[] aux = new int[N];
 for (int sz = 1; sz < N; sz = sz+sz)
 for (int lo = 0; lo < N-sz; lo += sz+sz)
 merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
 }



private static void merge(int[] a, int[] aux, int lo, int mid, int hi)
{
 for (int k = lo; k <= hi; k++)
 aux[k] = a[k];
 int i = lo, j = mid+1;
 for (int k = lo; k <= hi; k++)
 {
 if (i > mid) a[k] = aux[j++];
 else if (j > hi) a[k] = aux[i++];
 else if ((aux[j] < aux[i])) a[k] = aux[j++];
 else a[k] = aux[i++];
 }
} 




 private static void sort2(int[] a, int[] aux, int lo, int hi)
 {
 if (hi <= lo) return;
 int mid = lo + (hi - lo) / 2;
 sort2(a, aux, lo, mid);
 sort2(a, aux, mid+1, hi);
 merge(a, aux, lo, mid, hi);
 }

 public static void sort(int[] a)
 {
 int[] aux = new int[a.length];
 sort2(a, aux, 0, a.length - 1);
 }


}
