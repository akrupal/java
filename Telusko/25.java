import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Demo{
    public static void main(String a[])throws NumberFormatException,IOException {
        // BufferedReader bf = null;
        // try{
        //     bf = new BufferedReader(new InputStreamReader(System.in));

        //     int num = Integer.parseInt(bf.readLine());
        //     System.out.println(num);
        // }
        // // catch(NumberFormatException e){
        // //     System.out.println("Something went wrong. " + e);
        // // }
        // // catch(IOException e){
        // //     System.out.println("Something went wrong. " + e);
        // // }
        // finally{
        //     //the code written here runs irrespective of whether the exception is found or not
        //     //we can do something like resource closing in finally
        //     // catch is optional its ok even it catch block is missing
        //     bf.close();
        // }

        //we can further optimise the above code as in newer versions of java there is something called try with resources
        //here we dont even need to mention finally block
        try(BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in))){
            int num = Integer.parseInt(bf1.readLine());
            System.out.println(num);
        }
        //when using this we dont need to close BufferedReader
        //if you go into BufferedReader it extends Reader
        //Reader impliments Closable which extends AutoCloseable
        //since it is AutoClosable it will be closed automatically once the try block is finished
    }
}