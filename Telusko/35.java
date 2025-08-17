class Alien{
    private final int id;
    private final String name;
    public Alien(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Alien [id=" + id + ", name=" + name + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alien other = (Alien) obj;
        if (id != other.id)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    
}

// for a simple class just to write the basic stuff we need all the above things
// there is one way to make it smaller and the behaviour remains the same
// use record

// record NewAlien(int id, String name){}

record NewAlien(int id, String name){// id and name are private and final so no setters
    // cannot extend any other record class
    // it  by default exteds a Record class
    // but interfaces can be implimented as
    // record NewAlien(int id, String name) implements Clonable{}
    //by default there wont be any default constructor as we have mentioned parameters
    // if you want to create your own constructor which needs to have a different behaviour you can do that
    public NewAlien(){
        this(0,"default");//this will call the parametrised constructor
    }
    // a parametrised constructor will exist by default but if we want to change the behaviour
    // this is also called a cannonical constructor as the parameters are same as record
    // public NewAlien(int id, String name){
    //     if(id==0)
    //         throw new IllegalArgumentException("id cannot be 0");
    //     this.id=id;
    //     this.name=name;
    // }
    //lets create a compact canonical constructor
    public NewAlien{
        if(id==0)
            throw new IllegalArgumentException("id cannot be 0");
    }

    //other than these above we can create normal, static methods
    public void show(){}

    static int num; //static variables are allowed
    // int age; //instance variables are not allowed they can be passed with record at the time of creation
    // as record NewAlien(int id, String name,....){}
}

class Demo {
    public static void main(String a[]) {
        Alien a1 = new Alien(1, "Ajinkya");
        Alien a2 = new Alien(1, "Ajinkya");

        System.out.println(a1.equals(a2));

        NewAlien na1 = new NewAlien(1, "Ajinkya");
        NewAlien na2 = new NewAlien(1, "Ajinkya");

        System.out.println(na1.name());//the variable name methods are available for records to get value

        System.out.println(na1.equals(na2));

        NewAlien na3 = new NewAlien();
        System.out.println(na3);
    }
    
}
