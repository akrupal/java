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
