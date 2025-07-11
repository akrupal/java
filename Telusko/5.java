class Human{
    private String name;
    private int age;

    // default constructor
    // even if we don't provide this there will be a blank constructor provided by default
    public Human(){
        name = "Ajinkya";
        age = 28;
    }

    // parameterised constructor
    public Human(int age, String name){
        this.name=name;
        this.age=age;
    }

    public String GetName(){
        return name;
    }

    public int GetAge(){
        return age;
    }
}

class Main{
    public static void main(String a[]){
        Human a1=new Human();
        System.out.println(a1.GetAge()+":"+a1.GetName());
        Human a2=new Human(12,"abc");
        System.out.println(a2.GetAge()+":"+a2.GetName());
    }
}