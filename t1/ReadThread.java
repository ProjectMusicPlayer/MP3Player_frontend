package test.yubei.com.app.t1;

public class ReadThread implements Runnable{
    public Thread t;
    private String threadName;
    boolean suspended=false;
    
    public ReadThread(String threadName){
        this.threadName=threadName;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
      for(int i = 10; i > 0; i--) {
        System.out.println("Thread: " + threadName + ", " + i);
        // Let the thread sleep for a while.
        try {
            Thread.sleep(300);
            synchronized(this) {
                while(suspended) {
                   wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
      }
    }
    
    /**
     * ¿ªÊ¼
     */
    public void start(){
        System.out.println("Starting " +  threadName );
        if(t==null){
            t=new Thread(this, threadName);
            t.start();
        }
    }
    
    /**
     * ÔÝÍ£
     */
     void suspend(){
        suspended = true;
    }
     
     /**
      * ¼ÌÐø
      */
     synchronized void resume(){
         suspended = false;
         notify();
     }
}