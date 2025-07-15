class Demo{
    public static void main(String a[]){
        int i=2;
        int j=0;
        int nums[]=new int[5];
        String str = null;
        try{
            j=18/i;
            System.out.println(nums[4]);
            str.length();
        }
        // catch(Exception e){
        //     System.out.println("Something went wrong. " + e);
        //     // we did this to see what kind of exception we get now we can write catch to check specific exceptions
        // }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by 0");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Trying to access out of bounds element");
        }
        // we can go on adding multiple catch statements depending on what could go wrong
        // the code will always give out the first exception it encounters and step out of try catch
        // other than the above catch statements if you dont know what kind of exception you might get you can just add
        catch(Exception e){ //this Exception is the parent class of all exceptions and can handle anything
            System.out.println("Something went wrong. " + e);
        }
        // the parent expection should be at the last otherwise it would just go into the general exception and not check for rest

        System.out.println(j);
        
    }
}