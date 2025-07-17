class A implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hi");
            try{
                Thread.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Hello");
            try{
                Thread.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Demo{
    public static void main(String a[]){
        // Runnable obj1=new A();
        // Runnable obj2=new B();

        // in case we want to use anonymous functions instead of using above classes we can do
        // Runnable obj1 = new Runnable(){
        //     public void run(){
        //         for(int i=0;i<5;i++){
        //             System.out.println("Hi");
        //             try{Thread.sleep(1);}
        //             catch(InterruptedException e){e.printStackTrace();}
        //         }
        //     }
        // };

        // Runnable obj2 = new Runnable(){
        //     public void run(){
        //         for(int i=0;i<5;i++){
        //             System.out.println("Hello");
        //             try{Thread.sleep(1);}
        //             catch(InterruptedException e){e.printStackTrace();}
        //         }
        //     }
        // };

        // in case we want to use lambda expression
        Runnable obj1 = () -> {
                for(int i=0;i<5;i++){
                    System.out.println("Hi");
                    try{Thread.sleep(1);}
                    catch(InterruptedException e){e.printStackTrace();}
                }
            };

        Runnable obj2 = ()->{
                for(int i=0;i<5;i++){
                    System.out.println("Hello");
                    try{Thread.sleep(1);}
                    catch(InterruptedException e){e.printStackTrace();}
                }
            };

        // now since .start is a method of thread class
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}