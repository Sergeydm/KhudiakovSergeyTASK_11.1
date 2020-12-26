public class Lucky {
    static int count = 0;
    private static ObjectBasic ObjectBasic;

    static class LuckyThread extends Thread {
        public LuckyThread(ObjectBasic object) {
            ObjectBasic = object;
        }

        @Override
        public void run() {
            ObjectBasic.run();
            count = ObjectBasic.getCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectBasic stateObject = new ObjectBasic();
        Thread t1 = new LuckyThread(stateObject);
        Thread t2 = new LuckyThread(stateObject);
        Thread t3 = new LuckyThread(stateObject);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Total: " + count);
    }
}
