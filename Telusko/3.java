class Phone{
    String model;
    int price;
    static String name;

    public void printName(){
        System.out.println(model+" : "+price+" : "+name);
    }

    public static void show(){
        System.out.println(name);
    }
}

class main{
    public static void main(String a[]){
        Phone p = new Phone();
        p.model = "iPhone";
        p.price = 1500;
        Phone.name = "SmartPhone";

        p.printName();

        Phone.show();

    }
}