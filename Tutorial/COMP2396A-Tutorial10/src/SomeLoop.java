public class SomeLoop implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i){
            System.out.print(i);
        }
        
    }

    static public void main(String[] args){
        Thread t1 = new Thread(new SomeLoop());
        Thread t2 = new Thread(new SomeLoop());
        t1.start();
        t2.start();
    }
    
}
