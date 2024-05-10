public class ThreadRunnableDemo {
    public static void main(String[] args) {

        Runnable obj1 = () -> {
            for(int i=0; i<10; i++){
                System.out.println(i+": Hello");
                try {
                    Thread.sleep(10);   
                } catch (Exception e) {}
            }
        };

        Runnable obj2 = () -> {
            for(int i=0; i<10; i++){
                System.out.println(i+": Welcome");
                try {
                    Thread.sleep(10);   
                } catch (Exception e) {}
            }
        };

        Thread thread1 = new Thread(obj1);
        Thread thread2 = new Thread(obj2);

        thread1.start();
        thread2.start();
    }
}
