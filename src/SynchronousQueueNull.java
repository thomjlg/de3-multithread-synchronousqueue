import java.util.concurrent.SynchronousQueue; 

/** * Java Program to solve Producer Consumer problem using SynchronousQueue. A
 * * call to put() will block until there is a corresponding thread to take() that * element. 
 * * adapted from @author Javin Paul */

public class SynchronousQueueNull{
     public static void main(String args[]) { 
         final SynchronousQueue<String> queue = new SynchronousQueue<String>(); 
         Thread producer = new Thread("PRODUCER") { 
            public void run() { 
                String event = null;
                
                try { queue.put(event); // thread will block here
                    System.out.printf("[%s] published event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) { 
                    e.printStackTrace(); 
                }
            } 
        }; 

        
        Thread consumer = new Thread("CONSUMER") { 
            public void run() {
                try {
                    String event = queue.take(); // thread will block here
                    System.out.printf("[%s] consumed event : %s %n", Thread.currentThread().getName(), event);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    producer.start(); // starting publisher thread
    consumer.start(); // starting consumer thread



    } 
}

