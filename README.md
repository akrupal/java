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

boolean is true or false and here true in not 1 and false is not 0

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

main method is static because if it was not we would first need to create an instance of that object and only then the main method could be called but main is the start of execution and this creates a deadlock so main is static which means it does not need an instance to be called

when we have a static variable in our class and we want to initilise it we can use a static block the static block will only run once no matter how many objects are created or how many times the constructor is called
when the class loading happens first the static block is called

if there is no instance of object created the class loader would never be called hence the class is not loaded into the class loader
if you want that even without creating a class object the class should be loaded you can do as in 4.java