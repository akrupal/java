class A{
    public void Show1(){
        System.out.println("Show A");
    }
}

class B extends A{
    public void Show2(){
        System.out.println("Show B");
    }
}

class Demo{
    public static void main(String a[]){
        A obj = (A) new B(); //this is upcasting
        // actually the (A) does not even need to be mentioned and will be done implicitly
        // and the same thing can be written as
        // A obj = new B();

        // in the above example if you check even though the object type is B
        // the variable type being A you wont be able to call Show2
        // to solve this problem we have downcasting

        B obj1 = (B) obj;
        obj1.Show2();
    }
}