//since we want this to be functional interface we can add that check by adding an annotation as below
@FunctionalInterface
interface A{
    void show();
}

class B implements A{
    public void show(){
        System.out.println("in show");
    }
}

class Demo{
    public static void main(String a[]){
        A obj = new B();
        obj.show();

        // other than doing the above thing by implementing the interface we can also use anonymous inner class
        A obj1 = new A(){
            public void show(){
                System.out.println("in inner show");
            }
        };
        obj1.show();

        // in order to make the code more readable we can make the code even more shorter using lambda expression
        // and the same above code can be written as
        A obj2 = () -> {
                System.out.println("in lambda ex show");
            };
        //this is just syntactic sugar
        obj2.show();

        //since there is only one statement it can be further reduced to
        A obj3 = () -> System.out.println("short lambda ex show");
        obj3.show();

        // in case you want to pass some parameters to show just change the definaltion and in all the above 4 cases just add the same parameters in ()
        // and while making the call .show(int i, int j); pass the parameters
    }
}