class Phone{
    String model;
    int price;
    static String name;

    static{
        name = "SmartPhone";
        System.out.println("in static block");
    }

    public void printName(){
        System.out.println(model+" : "+price+" : "+name);
    }

    public static void show(){
        System.out.println(name);
    }
}

class main{
    public static void main(String a[])throws ClassNotFoundException{
        Class.forName("Phone");
    }
}