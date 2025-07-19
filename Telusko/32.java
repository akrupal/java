import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Student{
    int age;
    String name;

    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "Student [age="+age+",name="+name+"]";
    }
}

class Student1 implements Comparable<Student1>{
    int age;
    String name;

    public Student1(int age, String name){
        this.age = age;
        this.name = name;
    }

    public String toString(){
        return "Student [age="+age+",name="+name+"]";
    }

    public int compareTo(Student1 other){
        if(this.age>other.age)
            return 1;
        else
            return -1;
    }
}

class Demo{
    public static void main(String a[]){
        Comparator<Integer> com = new Comparator<Integer>(){
            public int compare(Integer i, Integer j){
                if(i%10>j%10)
                    return 1;
                else
                    return -1;
            }
        };
        
        List<Integer> nums = new ArrayList<>();
        //in the newer versions of java adding the variable type to left side is enough

        nums.add(44);
        nums.add(78);
        nums.add(92);
        nums.add(26);

        // Collections.sort(nums);// this will sort in asc order
        // if we want to have our own comparator
        // lets say something that sorts on the basis of last digit for 2 digit nums
        // we override the compare method as above and pass it as a parameter to sort method

        Collections.sort(nums,com);
        System.out.println(nums);

        //lets work with objects
        List<Student> studs = new ArrayList<>();
        
        studs.add(new Student(27,"Abhi"));
        studs.add(new Student(38,"Ashi"));
        studs.add(new Student(42,"Krat"));
        studs.add(new Student(12,"Clam"));

        // normal sorting wont work here as we are sorting objects
        // we have to make our own comparator
        // Comparator<Student> studCom = new Comparator<Student>(){
        //     public int compare(Student i, Student j){
        //         if(i.age>j.age)
        //             return 1;
        //         else
        //             return -1;
        //     }
        // };
        //the above code can also be used as a lambda expression as Comparator is functional interface
        Comparator<Student> studCom = (i, j)-> i.age>j.age?1:-1;

        Collections.sort(studs,studCom);

        // System.out.println(studs);
        for (Student s:studs){
            System.out.println(s);
        }

        //if you dont want to write a comparator and want that the normal
        // Collections.sort(studs); should work you have to impliment the
        // logic in Student class by implimenting Comparable
        // and adding method compareTo as done with Student1

        List<Student1> studs1 = new ArrayList<>();
        
        studs1.add(new Student1(27,"bhi"));
        studs1.add(new Student1(38,"shi"));
        studs1.add(new Student1(42,"rat"));
        studs1.add(new Student1(12,"lam"));

        Collections.sort(studs1);

        for(Student1 s:studs1){
            System.out.println(s);
        }
    }
}