# java
Learning java

to check if java is installed do
java --version
javac --version

there is something called as javashell that you can use to test out lines of code like
System.out.print(6);
you wont need to write complete class etc.

to compile java code do
javac Hello.java
this will create .class files
to run
java Demo
where Demo is the class name

there is a shortcut
java Hello.java
but I was not able to run it when we had multiple classes maybe look into it
the normal compile+run method specified above works

char is 2 bytes in java

boolean is true or false and here true is not 1 and false is not 0

byte b=127;
int a=12;

a=b;                  b=(byte)a;
implicit              type casting

byte a=10;
byte b=30;

int res=a*b; here type promotion will happen
officially byte*byte should be a byte but since it goes out of range
java will promote it and make it int

/ gives quotient
% gives remainder

switch(n){
    case 1:

        break;
    default:
}

in order to avoid writing break

switch(){
    case 1->  ;
    case 2->  ;
}

you can't mix : and -> use any one at a time

to get back return values from switch

String result="";
result = switch(day){
    case "Saturday","Sunday"->"6am";
    case "Monday"->"8am";
    default->"7am";
};

since we are assigning the value from switch its a statement and hence will require the closing ; as above
for older versions you might need to write it as
-> return "6am";
if you want to use : when using switch then instead of return use yield

when doing method overloading the name and parameters will matter even if the return type is different but the method name and parameters are same type it will give error

arrays
int nums[] = {3,4,5,7};
for dynamic allocation
int nums[] = new int[4];
this gives 0 initialised values

for multidimentional arrays
int nums[][] = new int[3][4];
                      row col
|[0][0][0][0]|
|[0][0][0][0]|
|[0][0][0][0]|

to get random number you can use Math.random()
this will give you a double with value from 0-1

for printing values you can use the normal for loop or
for(int n[]:nums)
{
    for(int m:n)
    {

    }
}

if you need to do something like the number of columns in every row is different you can do it using
int nums[][] = new int[3][];

int nums[0] = new int[3];
int nums[1] = new int[4];
int nums[2] = new int[2];
this is called a jagged array
to fill array using normal for loop
for(int i=0;i<nums.length;i++){
    for(int j=0;j<nums[i].length;j++){}
}
the advanced for loop will work normally

String in java is also a class
so you can do something like
String name = new String(); this will create an empty string
String name = new String("Ajinkya"); here we give a parameter to constructor
String name = "Ajinkya"; this will also work and create an object for you

for strings if you already have a string in the string constant pool a new object wont be created instead they would both be pointing to the same reference

String s1 = "Ajinkya";
String s2 = "Ajinkya";

the string constant pool will check for every new string object creation if it already exsists and return the reference if it exists

when you do somthing like string concatination ex
String a = "Ajinkya";
a=a+" Krupal";
all you are doing is creating a new object in the string constant pool and a changes its reference to the new object and the old one becomes eligible for garbage collection

the above strings were immutable

now for mutable strings
StringBuffer sb = new StringBuffer("Ajinkya");
here sb.length = 7;
but the capacity will be greater than 7 as if we need to change it need a contiguos block of memory
to append use
sb.append(" Krupal");

String s = sb.toString();
sb.setLength(30);
explore other methods like insert delete
the only difference between StringBuffer and StringBuilder is that StringBuffer is thread safe

if you declare a static variable in a class its value will remain same across all instances of the class objects
the static variable belongs to the class not the object
it can be accessed using the object but that is not correct and it should always be accessed using class
the non static method can access static variable

a static method can only be accessed by the class not the object
also the static method will only have access to static variables
ex 3.java

if you need access to the other normal object variables you can pass the object as a parameter

main method is static because if it was not we would first need to create an instance of that object and only then the main method could be called but main is the start of execution and this creates a deadlock so main is static which means it does not need an instance to be called

when we have a static variable in our class and we want to initilise it we can use a static block the static block will only run once no matter how many objects are created or how many times the constructor is called
when the class loading happens first the static block is called

if there is no instance of object created the class loader would never be called hence the class is not loaded into the class loader
if you want that even without creating a class object the class should be loaded you can do as in 4.java

when creating setters if you have something like this

class Person{
    int age

    public void setAge(int age){
        age=age;
    }
}

in this case age would be taken as a local variable at it would just be something like age is being reassigned with itself meaning the instance variable remains 0 or whatever its previous value was so we use this.age in such cases and the correct way is

class Person{
    int age;
    public void setAge(int age){
        this.age=age;
    }
}

constructors 5.java

we'll follow camel case
class and interface usually start with capital letters
variable and methods start with small
canstants are all capital

class Object{

}

class Main{
    public static void main(String a[]){
        Object a; //this will only create a space on stack to reference some object on heap

        new Object(); // this will only create object on heap this is also called anonymous object

        a=new Object(); // this will create the object on heap and a will start referencing it
        // meaning stack will have the address to object on heap
        // this will be called referenced object

        // the use of anonymous objects should be minimised and it can be used when lets say there is some method that needs to be called only once like
        new Object().doSomethingOnce();

    }
}

the classes in java files can be seperated into different files
if you compile one .java file it is possible that only one .class file is generated but this means you have only one class in that file and are not using the classes from other files
if you compile one file and it is using some class from other files the other .class files will be created automatically

inheritance
class Calc{}
class AdvancedCalc extends Calc{}

calc     base      subclass    parent
AdvCalc  derrived  superclass  child

calc -> advCalc single level inheritance
calc -> advCalc -> veryAdvCalc multi level inheritance

unlike C++ multiple inheritance is not supported in java
this is mostly because of the ambiguity from same methods in parent classes

when new is called it will call the constructor of both the superclass A as well as subclass B

in every constructor by default there is a method called super(); whether it is written or not
this super is what calls the constructor of the super/parent class
if you see this super(); will by default call the default constructor
if you want to call the parametarised constructor you have to pass the parameters with super
6.java

something to observe from above file is for B its ok A is parent class but what about A
even its constructor will call super but its not extending anything
for this in java every top parent class extends Object
so for A it can be written as
class A extends Object{}
even if the extends Object is not written it is by default in java

this is a multilevel inheritance not mutiple only A will extend Object not B

according to use case you can use this
if you add this(); to your parametrised constructor it will call the default constructor of that class it would be something like
public B(int n){
    this();
    System.out.print..
}
in this case no seperate super runs for the parametrised constructor instead only the super from base constructor would run

method overriding
lets say in class A you had a method show() and config()
then you create a class B that extends A
when you do
B obj = new B();
then do B.show();
it would call the method from A
but if you dont want this you can create a method show() in B
and this method will override the show from A
the method is first searched in the same class if it does not find it, it will go and search for it in the parent class

packages
its better to club similar code and files together in a folder all the files inside the folder will have the same package name as the folder
if the class you need to access is in the same folder it can be accessed directly but if its in a different folder you need to access it using its package

in every file
import java.lang.*;
is already there even if you don't write it
this package will have all the things we use without importing anything like System String

if you have a folder structure like other/tools/<java files>
the usual way to import it would be
import other.tools.*;
this will import all the files inside tools folder
if you think doing
import other.* will do the same thing you are wrong
this statement will only include the classes in the java files at level other

access modifiers
public private protected default

if you are in the same package you can access the variables
if you are in different package you can't access the variables unless you make them public

normally variables will be private and methods will be public

if you make a variable private it cannot be accessed outside the class

if you dont mention anything in front of the variable of method its default and it can be accessed anywhere inside the package but not outside

public can be accessed from anywhere
private can be accessed only inside class
default can be accesses only inside package
protected can be accessed in same package or if you have a protected element in A in some package and in a different package you create a class that extends A you will be able to access the protected element here

try to make your classes public
we cannot have 2 public classes in a file
the general idea is there should be only one class per file
instance variables should be private and the methods most of the time should be public
if you think there is some method that should be accessed by subclass of other packages use protected
avoid using default

polymorphism
compile time  early binding  overloading
run time      late binding   overriding
7.java

for creating constants we can use the final keyword
final int num = 8;
if you make you class final no other class will be able to extend it
if the class is not final but you make a method inside the class final then the class can be inherited/extended but you wont be able to override the final method in new class