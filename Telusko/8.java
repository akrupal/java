class A{
    String name;
    int price;

    public String toString(){
        return name+":"+price;
    }

    public boolean equals(A other){
        return (this.name.equals(other.name)&&this.price==other.price);
        // for string equals has been implimented properly so it can be used directly
    }

    // usually we dont define methods like equals by ourself instead what we can do is
    //right click source action generate hashcode() and equals()
    // its not working in codespace maybe try with the extension
    
}

class Main{
    public static void main(String a[]){
        A obj = new A();
        obj.name = "Aj";
        obj.price = 27;
        // System.out.println(obj);
        // calling the above statement is same as calling
        // System.out.println(obj.toString());
        // if you dont like this output and want to create you own you can create a toString function in a class and it will be overridden as above
        A obj1 = new A();
        obj1.name="Aj";
        obj1.price=27;

        boolean res = obj==obj1;
        boolean res1 = obj.equals(obj1);//this compares the 2 objects by their hexades number but we dont want that
        // so we create a equal method of our own as above and it will be overridden

        System.out.println(res);
        System.out.println(res1);

    }
}