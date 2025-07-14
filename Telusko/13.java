abstract class A{
    public abstract void show();
    public abstract void config();
    public void read(){
        System.out.println("Reading data");
    }
}

class Demo{
    public static void main(String a[]){
        A obj = new A(){
            public void show(){
                System.out.println("in new show");
            }
            public void config(){
                System.out.println("reading configs");
            }
        };
        obj.show();
        obj.config();
        obj.read();
    }
}