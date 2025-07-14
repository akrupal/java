abstract class Car{
    public abstract void drive();
    public abstract void fly();

    public void playMusic(){
        System.out.println("Playing music");
    }
}

abstract class WagonR extends Car{
    public void drive(){
        System.out.println("Driving WagonR");
    }
}

class AdvancedWagonR extends WagonR{
    public void fly(){
        System.out.println("Flying car");
    }
}

class Demo{
    public static void main(String a[]){
        Car obj = new AdvancedWagonR();
        obj.drive();
        obj.playMusic();
        obj.fly();
    }
}