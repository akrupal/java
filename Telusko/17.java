enum Laptop{
    Macbook(850), XPS(800), Surface(700), Thinkpad(300);
    //if we want to mention the price too write it in brackets after object
    //the above objects will act like a constructor now
    // in case you want to add an object for which you dont want to give the price something like Dell
    //that wont directly work as we have specified a constructor
    //so you would need to create a default constructor like
    private Laptop(){
        this.price=500;//this is optional if you want to give some default value you can or else skip
        // but with this you can add something like Dell with without specifying value as Dell(800)
    }
    //the objects are created inside the class itself so the constructors will always be private
    private int price;
    private Laptop(int price){
        this.price=price;
    }
    //since price is a private variable if we want access we'll need to create getters and setters
    public int getPrice(){
        return price;
    }
    public void setPrice(int price){
        this.price=price;
    }
}

class Demo{
    public static void main(String a[]){

        Laptop lap = Laptop.Macbook;
        System.out.println(lap+":"+lap.getPrice());

        for (Laptop lape: Laptop.values()){
            System.out.println(lape+":"+lape.getPrice());
        }

    }
}