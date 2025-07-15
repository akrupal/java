@FunctionalInterface
interface A{
    void show(int i);
}

@FunctionalInterface
interface B{
    int add(int i, int j);
}

class Demo{
    public static void main(String a[]){
        A obj = i -> System.out.println("short lambda ex show"+i);
        obj.show(5);

        B obj1 = new B(){
            public int add(int i, int j){
                return i+j;
            }
        };
        int result1 = obj1.add(4,5);
        System.out.println(result1);

        B obj2 = (int i, int j)->{
                return i+j;
            };
        int result2 = obj2.add(4,5);
        System.out.println(result2);

        B obj3 = (i, j)->i+j; //when converting it to single statement remove return
        int result3 = obj3.add(4,5);
        System.out.println(result3);
        //we can pass lambda function as an argument too
    }
}