class A{
    public void Show(){
        System.out.println("In A Show");
    }
}

class B extends A{
    public void Show(){
        System.out.println("In B Show");
    }
}

class C extends A{
    public void Show(){
        System.out.println("In C Show");
    }
}

class Demo{
    public static void main(String a[]){
        A obj = new A();
        obj.Show();

        obj = new B();
        obj.Show();

        obj = new C();
        obj.Show();
    }
}