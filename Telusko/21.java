class Demo{
    public static void main(String a[]){
        int i=20;
        int j=0;
        try{
            j=18/i;
            // in this case we dont get an exception but the value of 18/20 = 0 is undesirable and we need to call some catch
            // to do this we use throw
            // throw is used to throw an exception
            if (j==0){
                // throw new ArithmeticException();
                //calling above line will simply call the catch but lets say if we want to pass some message
                throw new ArithmeticException("Value of j can't be zero");
            }

        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by 0 "+ e);
        }
        catch(Exception e){ //this Exception is the parent class of all exceptions and can handle anything
            System.out.println("Something went wrong. " + e);
        }

        System.out.println(j);
        
    }
}