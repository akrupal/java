interface A{
    int age = 27;
    String name = "Ajinkya";

    void show();
    void config();
}

class B implements A{
    public void show(){
        System.out.println("in B show");
    }
    public void config(){
        System.out.println("reading B configs");
    }
}

class Demo{
    public static void main(String a[]){
        A obj = new B();
        obj.show();
        obj.config();

        System.out.println(A.name+":"+A.age); // we can directly access using A as these are static

        // A.age = 23; //this wont work as its constant
    }
}