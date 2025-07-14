class A{
    int i;
    public void show(){
        System.out.println("show A");
    }
    class B{
        public void show(){
            System.out.println("show B");
        }
    }
    static class C{
        public void show(){
            System.out.println("show C");
        }
    }
}

class Demo{
    public static void main(String a[]){    
        A obj = new A();
        obj.show();

        A.B obj1 = obj.new B();
        obj1.show();

        A.C obj2 = new A.C();//since C is a static class it does not need an object
        obj2.show();

        //static classes will alwasys be inner class
        // we cannot make outer class static
    }
}