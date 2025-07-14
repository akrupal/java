interface A{
    void show();
}

interface B{
    void run();
}

interface X extends B{
//any class that impliments X will need to impliment the method from B
//and any other methods if mentioned in X
}

class C implements A,X{
    public void show(){
        System.out.println("show");
    }
    public void run(){
        System.out.println("run");
    }
}

class D{
    public static void main(String a[]){
        A obj;
        obj = new C();
        obj.show();
        // obj.run();//you wont be able to call this with object type A

        X obj1;
        obj1 = new C();
        obj1.run();
        // obj1.show();//same as above you wont be able to call show with object type X
    }
}