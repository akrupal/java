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

in c++ normally you would create something like this to achieve polymorphism
class Base{
    public:
    virtual void show(){
        cout<<"Base Show"<<endl;
    }
};

class Derived : public Base{
    public:
    void show(){
        cout<<"Derived Show"<<endl;
    }
}

int main(){
    Base* ptr= new Derived();
    ptr->show();
    //since it is a base pointer show in Base would be called and it would only show base till virtual is added
    //once you add virtual to base show it uses Dynamic binding and the call is resolved to method of the actual object which is derived
}

unlike c++ where you have to explicitly write virtual, in java you get dynamic dispatch automatically for instance methods so its something like the methods are virtual by default(non static, static methods are compile time based) thats why 7.java works

if you are thinking what happens if you use normals objects instead of pointers in C++ it does not work
int main(){
    Derived d;
    //you cant do d=new Derived(); as it returns memory address and d would need to be a pointer
    Base b = d; // object slicing happes here meaning it would loose the extra Derived data and the dynamic dispatch
    b.show(); // base show would be called even though its virtual
}

so in java for run time ploymorphism the type of variable does not matter the type of object is what will matter(obviously they need to be superclass and subclass)

for creating constants we can use the final keyword
final int num = 8;
if you make you class final no other class will be able to extend it
if the class is not final but you make a method inside the class final then the class can be inherited/extended but you wont be able to override the final method in new class

whenever you try to print some object it by default calls toString method from Object
8.java

upcasting and downcasting 9.java

wrapper classes
for every primitive type we'll have a class for it
int -> Integer class
char -> Charecter class
double -> Double class
.
.
etc

in some framework if it only supports objects we can use these classes
java offers the primitive types for performance

int num = 7;
// Integer num1 = new Integer(8); // old method depricated
Integer num1 = 8;

Integer num1 = new Integer(num);
//taking a primitive value and storing it into an object this is called boxing
Integer num1 = num; //same as above line just the difference being this is called autoboxing

int num2 = num1.intValue(); //this is called unboxing
int num2 = num1; // here since it happens automatically its called auto-unboxing

String str = "12";
int num = Integer.parseInt(str);
System.out.println(num3*2);

abstract keyword
lets say we have a class in which there is a method that we dont know how to impliment yet so what we can do is just declare it there with the abstract keyword but the thing is the class should also be abstract because only abstract classes can have abstract methods
now its the responsibility of the class that extends this abstract class to impliment it if we dont it will start giving an error
you cant create object of an abstract class
but you can define an object of type abstract class and let it reference to the child object like we did in polymorphism

it is compulsory that an abstract method is written in an abstract class
but it is not necessary that if a class is abstract it necessarily needs to have abstract methods

in case you have a class that extends an abstract class but is not able to impliment some method in abstract class it will have to be made abstract
now even the new abstract class cant be created as an object so you will have to create another class which extends the latest abstract class impliment the other abstract method and you will be good

the classes which are not abstract are called concrete classes
objects can only be created with concrete classes
10.java

inner class
11.java

anonymous inner class
usually what we have been doing is if we want to override a class method we'll create another class which extends this class and create a method with same name that overrides it
but lets say we dont want to do that then we can use anonymous inner class where you can just define this method that you want to change
12.java

we can also create abstract anonymous inner class such that we define our abstract methods in the anonymous inner class
normally we cant create an object of abstract class but here since we define it with the inner class it will work
13.java

use inner class when you know that the new class that would have been created would not be used at more than one place
the inner class you create is only usable at that place the class is lost then as it has no name(hence anonumous)

interfaces
lets say we have an abstract classes but it only has abstract methods then we have an option to use interface instead of abstract class
abstract class A{
    public abstract void show();
    public abstract void config();
}
interface A{
    void show();
    void config();
}
interface is not a class
the methods in interface are public abstract by default so we dont need to mention it
we cannot instantiate an interface (new A();)
we can create a reference or type as A obj;

interface is like a set of instructions that need to be implimented
we can impliment them using classes
14.java
you can skip implimentaing some methods in a class that impliments interface but then the class would become abstract

you can create variables inside an interface but they are static and final

when there is a function that needs some class as an input but it might change depending on the requirement what we paas that time you can create an interface make the classes impliment the interface and then the parameter type will be interface and it will accept any class that impliments the interface
15.java

1 class can implement multiple interfaces the only condition is it should impliment all the methods of all the interfaces
interfaces can extentd interfaces like classes
16.java

class extends a class
class implements an interface
interface extends an interface

enums
enum Status{
    Running, Failed, Pending, Success;
}

Status s = Status.Running;
System.out.println(s); // Running
System.out.println(s.ordinal()); // 0 (this is index)

//if you need all the values inside enum
Status[] ss = Status.values(); //returns an array
for (Status e:ss){
    System.out.println(e+":"+e.ordinal());
}

status is a class and Running, Failed etc are all objects of status
objects in enums are named constants

we use enums to check some sort of status so what we can do is
if (s==status.Running)
    System.out.println("All good");
else if(s==status.Failed)
    System.out.println("Try again");
else if(s==status.Pending)
    System.out.println("Please wait");
else
    System.out.println("Done");

we can also use it in switch as
switch(s){
    case Running:
        System.out.println("All good");
        break;
    case Failed:
        System.out.println("Try again");
        break;
    case Pending:
        System.out.println("Please wait");
        break;
    default:
        System.out.println("Done");
}

even though we said enum is a class we cannot extend it
by default any enum class you create extends an enum class in java you can verify that using
s.getClass().getSuperclass();

enum class 17.java

annotations
these are like checks that ensure we write the name of the function correctly
we'll put @Override in the child class on the method we want to override and the compiler will check for us if the parent class has a method with the same name

types of interface
Normal
functional/SAM(Single Abstract Method)
Marker

avery method in an interface is public abstract by default

(After java8 we also have the option to define methods inside an interface but for now we'll just keep in mind that we can declare methods in an interface)

if an interface has 2 or more methods its called normal methods
an interface is called functional/SAM when it has only one method
marker if the interface has no methods i.e. an empty interface

marker interfaces are used when we need to update something to the compiler saying please allow this
in java we have a concept of serialization which means you can take the values of an object and store tham in the hard drive
this can be used when we need to recreate the object (ex: save game) using the data from hard drive this process is de-sereialization

by default not every object is not allowed to do serialization and de-serilisation so in order to give the permission we create a class and give permissions using the marker interface

functional interface and lambda expression
18.java

lambda expression with return value
19.java

lambda expression will work only with functional interface

exception handling in java
errors
1)compile time
2)run time
3)logical

compile time errors will be shown by compiler and could wont build unless we fix them
ligical errors need to be fixed by doing heavy testing
run time issues need to be handled using exeptions

run time error examples(we try to open a file that does not exist, dividing by 0)
20.java

usually when the code encounters an error it breaks out without going forward
but there can be times when even if something is not right you might need to go forward
when we dont know if something is going to run properly or not we use try catch so that we catch the exception and move forward with the code

heirarchy of classes
Object
   |
   V
Throwable
   |
 -------
|       |
V       V
Error   Exception--------------------------------------------------------
|                                                                       |
V                                                                       V
-------------------------------------                -------------------------------
|                |                  |                |                |            |
V                V                  V                V                V            V
thread error virtual-machine error I/O error      Runtime exception | SQL exception I/O exception ...
                |                                       Arithmatic  |
                V                                       Array index |
              out of memory error                       Null pointer|   
                                                        .           |
                                                        .           |
                                                        .           |
                                                                    |
                                                        unchecked   |   checked

for the Runtime exceptions its up to us and the compiler will not force us to write checks hence they are called unchecked
for any other line where the compiler sees that it can raise other exception the compiler will ask you to write a check and handle the exception

throw 21.java

custom exception 22.java

d(){
    try{some critical statement}
    catch(){}
}
e(){
    try{some critical statement}
    catch(){}
}
c(){
    d();
    e();
}
in above example we handle try catch in individual functions but this can be made easier using throws

d()throws Exception{}
e()throws Exception{}
c(){
    try{
        d();
        e();
        //in this case both the d and e methods become critical
    }
    catch(){}
}

throws is used when you dont want to handle the exception yourself
if you dont want to handle the exception even in c you can just keep on going up the ladder and the function calling c will have c in try catch block and c will have throws Exception
this is called ducking the exception
23.java

a common interview question println belongs to which class?
println is a method of printStream class
so this means we would need to create an object of printStream in order to use this method?
java already does this for us it creates a statc object out for us from printStream in System class

taking in values from user in java 24.java

try with finally, try with resource 25.java

threads
if we want to run some code in threads
here we run objects in tread and the way to do that is
start by extending your class with Thread now your class is not an ordinary class its a thread
To call some method from a thread class we need to call it as obj.start();
but now that we are calling the method using start even the method name should be start
but no for every thread whenever you call the .start method it will automatically call the .run method so you can change your method name in thread(object class) to run
26.java

its the schedulers job to allow a thread to execute
depending on the number of cores
lets say you have a 2 core machine meaning you can run 2 threads at a time so the scheduler will schedule it such that only 2 threads will run at a time

now once you see the output fron 26.java you will see the code is running in parallel but lets say we want something like one hi followed by a hello
you could
1) give priority to a thread
obj1.setPriority(5);//this number can be anything between 1-10(lowest to highest priority)
obj1.setPriority(Thread.MAX_PRIORITY); //setting this would mean this tread would be executed first
but you will see this does not give very good result and its totally up to the scheduler depending upon the threads its already running it could also give priotiry according to running time
2) after every print statement we could add
try{
    thread.sleep(10);//time in milliseconds
}
catch(InturruptedException e){
    e.printStackTrace();
}
but even with this there is a chance they may not be alternate

other methods of creating thread
lets say we have a class that needs to extend some other class and then it needs to be a thread too but multiple inheritance is not possible in java
class A{}
class B extends A,Thread{}//this is not possible

so now we can use Runnable interface
27.java

race condition
happens if 2 threads try to access the same variable at the same time and try to change the value we might not get the desired value
when you fire threads you can wait for them to complete their execution and return to the main thread using .join() on the thread
but this still does not solve the problem of same time access
to fix that we can add synchronized to the method being accessed by threads
synchronized ensures that the method is being accessed by one thread at a time
28.java

thread states

(when you create 
a new thread)                 .notify() //when this method is called first it will go to scheduler not directly to Runnable
New --------------> Runnable <----- Waiting
        .start()       |          /
                       |.run()   /| .sleep()
                       |        /   .wait()
                       V       /
                      Running --------------> Dead
                                .stop()
                                //stop is depricated now dont use it anymore

even if the thread is in Runnable using stop will send it to dead


Collection API - concept
Collection     - interface and some classes impliment this
Collections    - class 

Iterable
Collection
    List
        ArrayList
        LinkedList
    Queue
        DeQueue
    Set
        HashSet
        LinkedHashSet

this can be followed as a parent to child relation
other than these there are also map, map is not an implementation or does not extend collection interface but is a part of collection API

list 29.java

list supported repeated values but if you dont want repeated values use set
30.java

map 31.java

comparator and comparable 32.java

forEach and stream 33.java

afther java 10 versions we can use the keyword var, the value needs to be specified and assigned so that the compiler can inference the data type
and its allowed only with local variables inside a method

class Demo{
    //var num = 10;//not allowed here
    public static void main(string a[]){
        int a=9;
        var b=8;
        String var = "Ajinkya";//it can also be used as variable name

        int c;
        //var d;//this cant be done it needs to be assigned some value

        int nums[] = new int[10];
        var nums = new int[10];//the bracket is not needed with var
        //if you put it it will give an error

        //can use var for creating class instances as
        var obj = new Alien();
        
    }
}

when you create an abstract class the idea is usually that it will be inherited by some other concrete class which will implement the methods from abstract class
with final the class cannot be inherited

what if we want something in between?
lets say we want inheritance but not every class can inherit this class
here we take the help of sealed classes
34.java

record 35.java