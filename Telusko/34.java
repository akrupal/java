//what we are trying to do is only class B and C should be able to inherit class A
//we get compile time error when D tries to inherit A
// sealed class A permits B,C{}
sealed class A extends Thread implements Cloneable permits B,C{}// sequence of extends implements and permits

//the classes that we permit should be sealed, non sealed or final

// sealed class B extends A permits D{}
//if we want it to be something like anyone can inherit it and we dont want to add permit use non sealed
non-sealed class B extends A{}

final class C extends A{}

// final class D extends B{} //will work with sealed B
class D extends B{} //will work with non-sealed B

sealed interface X permits Y{}

non-sealed interface Y extends X{}

class Demo{
    public static void main(String a[]){

    }
}