class A{
    public A(){
        System.out.println("constructed A");
    }
    public A(int n){
        System.out.println("p constructed A");
    }
}

class B extends A{
    public B(){
        System.out.println("constructed B");
    }
    public B(int n){
        // super(); // even if you dont write this its always there this is what calls constructor of A
        super(n); //if you need to call some other constructor other than default constuctor pass parameters
        System.out.println("p constructed B");
    }
}

class Main{
    public static void main(String a[]){
        B obj = new B();
        B obj1 = new B(1);
    }
}