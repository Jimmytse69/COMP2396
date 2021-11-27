public class Ex {
    static class F1 implements Runnable{
        public void run() {
            System.out.print(12);
        }
    }
    static class F2 implements Runnable{
        public void run() {
            System.out.print(34);
        }
    }

    static public void main(String[] args) {
        Thread t1 = new Thread(new F1());
        Thread t2 = new Thread(new F2());
        t1.start();
        t2.start();
    }
}
