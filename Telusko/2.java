class Calculator{
    int a;

    //method overloading
    public int add(int n1, int n2, int n3){
        return n1+n2+n3;
    }
    public int add(int n1,int n2){
        int r = n1+n2;
        return r;
    }
    public double add(double n1, int n2){
        return n1+n2;
    }
}

class Demo {
    public static void main(String a[]){

        int num1=4;
        int num2=5;

        Calculator calc = new Calculator();

        int result=calc.add(num1,num2);

        System.out.println(result);

    }
}