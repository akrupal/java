import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.function.Consumer;

class Demo{
    public static void main(String a[]){
        List<Integer> nums = Arrays.asList(4,5,7,3,2,6);
        //instead of defining an ArrayList and then doing .add()
        //for each number we can use the above shortcut

        // to print all the elements in the above loop we have 3 different options
        // for(int i=0;i<nums.size();i++){
        //     System.out.println(nums.get(i));
        // }
        // for(int n:nums){
        //     System.out.println(n);
        // }
        // nums.forEach(n->System.out.println(n));

        //actually the way forEach works is
        //if you go inside foEach it impliments a functional interface Consumer so
        // Consumer<Integer> con = new Consumer<Integer>(){
        //     public void accept(Integer n){
        //         System.out.println(n);
        //     }
        // };
        //simplifying we get
        Consumer<Integer> con = n->System.out.println(n);

        nums.forEach(con);
        // which is the same as the 3th option of print done above


        //lets say we want to double the even nums out of above list and calculate their sum
        int sum=0;
        for(int n:nums){
            if(n%2==0){
                n*=2;
                sum+=n;
            }
        }
        System.out.println(sum);

        //same thing as above using stream
        Stream<Integer> s1 = nums.stream();
        //s1 will have all the values in num and whatever operation we perform on s1
        //it wont affect nums
        // s1.forEach(n->System.out.println(n));//commenting otherwise I wont be able to use it further
        //once the stream is used it cannot be used once again
        //if we try to reuse we'll get some error saying the stream has already been operated upon or closed

        Stream<Integer> s2 = s1.filter(n->n%2==0);
        // s2.forEach(n->System.out.println(n));

        Stream<Integer> s3=s2.map(n->n*2);
        // s3.forEach(n->System.out.println(n));

        int result=s3.reduce(0,(c,e)->c+e);
        System.out.println(result);

        //this complete thing can be written as
        int result1 = nums.stream()
                        .filter(n->n%2==0)
                        .map(n->n*2)
                        .reduce(0,(c,e)->c+e);

        System.out.println(result1);

        //all the above .stream, .filter etc have a functional interface that they impliment
        //to test we can create an object of the same type implement the method and pass it as
        //parameter to .stream, .filter etc
        //if we go on to simplify the functional interface implementation they become lambda expression
        //and finally can be written as above
        //see video 102 for more elaborate process

        //if we just want to print the sorted values
        Stream<Integer> s4 = nums.stream()
                                .filter(n->n%2==0)
                                .sorted();

        //if we want to use mutiple threads we can use parallelStream() instead of stream()
        //but dont use sorted() there as it will need all the elements to sort at a time
        //sorted() does not make sense with muti threading

        s4.forEach(n->System.out.println(n));
    }
}