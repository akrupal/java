interface Computer{
    void show();
}

class Laptop implements Computer{
    public void show(){
        System.out.println("laptop provided");
    }
}

class Desktop implements Computer{
    public void show(){
        System.out.println("desktop provided");
    }
}

class Developer {
    public void devApp(Computer c){
        c.show();
    }
}

class Demo{
    public static void main(String a[]){
        Computer lap = new Laptop();
        Computer desk = new Desktop();

        Developer dev = new Developer();
        dev.devApp(lap);
        dev.devApp(desk);
    }
}

