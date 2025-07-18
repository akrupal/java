import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import javax.xml.transform.Source;

class Demo{
    public static void main(String a[]){
        Collection nums = new ArrayList();

        nums.add(7);// the 7 in here that are trying to insert is treated like an object not an int
        nums.add(6);
        nums.add(5);
        nums.add(4);
        // nums.add("23");//lets say we try to add something other than an int
        // this wont give any error here as we have out mentioned any object type
        // but this will definately give a run time exception
        // so its better to specify the type of object like has been done in next example

        System.out.println(nums);// here this will work as its a collection
        // we get the warning with above code
        // Note: 29.java uses unchecked or unsafe operations.
        // Note: Recompile with -Xlint:unchecked for details.
        // as we have not declared the type when using collection

        for(Object n:nums){
            // System.out.println(n);
            //if you need to perform some operation on the number you can typecast
            Integer num = (Integer)n;
            System.out.println(num*2);
        }

        Collection<Integer> nums1 = new ArrayList<Integer>();

        nums1.add(7);// the 7 in here that are trying to insert is treated like an int
        nums1.add(6);
        nums1.add(5);
        nums1.add(4);

        System.out.println(nums1);// here this will work as its a collection


        // we can also use advanced for loop
        for(int n:nums1){
            System.out.println(n);
        }

        //ArrayList is a class that impliments list
        // and list does have a method called get
        // use collection if you just want to add values and fetch
        // if we want elements by index we should work with List

        List<Integer> nums2 = new ArrayList<Integer>();

        nums2.add(7);
        nums2.add(6);
        nums2.add(5);
        nums2.add(4);

        System.out.println(nums2.get(2));

    }
}