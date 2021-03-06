package FunTryOuts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreFun {
	public static void main(String[] args) {  
		  
        /*创建一个线程池*/  
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final int maxThread = 5;
        /*创建一个信号灯对象*/  
        final Semaphore semaphore = new Semaphore(maxThread);  
          
        for (int i=0; i<10;i++){  
              
            Runnable runnable = new Runnable() {  
                  
                @Override  
                public void run() {  
                /*************获取一个信号灯************/  
                    try {  
                        semaphore.acquire();  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                      
                    System.out.println(Thread.currentThread().getName() +", 进入，当前已有 " + (maxThread - semaphore.availablePermits()) +"并发");  
                      
                /************休眠******************/  
                    try {  
                        Thread.sleep(1000);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                      
                /**************释放信号灯*************/    
                    System.out.println(Thread.currentThread().getName() +"即将离开");  
                      
                    semaphore.release();//释放信号灯  
                    System.out.println(Thread.currentThread().getName() +", 已离开，当前还有 " + (maxThread - semaphore.availablePermits()) +"并发");  
                      
                }  
            };  
              
            /*执行*/  
            executorService.execute(runnable);  
        }  
    }  
}
