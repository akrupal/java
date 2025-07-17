class A{
    // public void show(){
    //     try{
    //         Class.forName("V");
    //         // this statement has a checked exception and needs to be written in a try catch block
    //     }
    //     catch(ClassNotFoundException e){
    //         System.out.println("unable to find and load class "+e);
    //     }
    // }
    // in case we dont want to write the Class.forName in try catch we can use throws
    public void show()throws ClassNotFoundException{
        Class.forName("V");
    }
}

class Demo{
    public static void main(String a[]){
        A obj = new A();
        // obj.show();//if you are using throws this statement goes into try catch
        try{
            obj.show();
        }
        catch(ClassNotFoundException e){
            System.out.println("unable to find and load class "+e);
            e.printStackTrace();
        }
        //if this was not main we could avoid using try catch here too and just do throws Exception and handle it in parent function which calls this function
        //actually we can write the throws here too for main its just that if we dont handle it in main its parent is jvm
        // and if we ask jvm to handle exception it will just stop executing the code thus defeating the purpose of exception handling
    }
}