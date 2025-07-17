import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

class Demo{
    public static void main(String a[])throws IOException{
        System.out.println("Enter a number");
        // int num = System.in.read();//this returns the ascii value of the number entered in terminal and is not a good way
        //also it limits the input
        //normally above statement should be in try catch but as we are learning lets just use throws with main
        // System.out.println(num-48);

        // InputStreamReader in = new InputStreamReader(System.in);
        // BufferedReader bf = new BufferedReader(in);

        // int num = Integer.parseInt(bf.readLine());
        // System.out.println(num);

        // //using bf we can open a file or access a network so its our duty to close it after we are done
        // bf.close();

        //this above method is very lengthy so we can go for a new method
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num);
    }
}