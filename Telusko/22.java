class AjinkyaException extends Exception{
    public AjinkyaException(String str){
        super(str);//tell the parent we are accepting a string
    }
}

class Demo{
    public static void main(String a[]){
        int i=20;
        int j=0;
        try{
            j=18/i;
            if (j==0){
                throw new AjinkyaException("Value of j can't be zero");
            }

        }
        catch(AjinkyaException e){
            System.out.println("Cannot divide by 0 "+ e);
        }
        catch(Exception e){ //this Exception is the parent class of all exceptions and can handle anything
            System.out.println("Something went wrong. " + e);
        }

        System.out.println(j);
        
    }
}