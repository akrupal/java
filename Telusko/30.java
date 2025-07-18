import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
// import java.util.Collection;

class Demo{
    public static void main(String a[]){

        Set<Integer> nums2 = new HashSet<Integer>();

        nums2.add(62);
        nums2.add(54);
        nums2.add(82);
        nums2.add(21);
        nums2.add(54);

        //set does not support index vale

        for(int n:nums2){
            System.out.println(n);
        }
        //for small values it may appear sorted try bigger values and
        //as you can see for HashSet the values are not sorted
        // if we want the values to be sorted we can use TreeSet

        Set<Integer> nums3 = new TreeSet<Integer>();
        //Set<Integer> nums3 can also be written as
        //Collection<Intger> nums3 Collections being the parent

        nums3.add(62);
        nums3.add(54);
        nums3.add(82);
        nums3.add(21);
        nums3.add(54);

        //set does not support index vale

        for(int n:nums3){
            System.out.println(n);
        }

        //using iterators
        Iterator<Integer> values=nums3.iterator();
        while(values.hasNext()){
            System.out.println(values.next());
        }
    }
}