package FunTryOuts;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreFun {
	public static void main(String[] args) {  
		  
        /*����һ���̳߳�*/  
        ExecutorService executorService = Executors.newCachedThreadPool();
        
        final int maxThread = 5;
        /*����һ���źŵƶ���*/  
        final Semaphore semaphore = new Semaphore(maxThread);  
          
        for (int i=0; i<10;i++){  
              
            Runnable runnable = new Runnable() {  
                  
                @Override  
                public void run() {  
                /*************��ȡһ���źŵ�************/  
                    try {  
                        semaphore.acquire();  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                      
                    System.out.println(Thread.currentThread().getName() +", ���룬��ǰ���� " + (maxThread - semaphore.availablePermits()) +"����");  
                      
                /************����******************/  
                    try {  
                        Thread.sleep(1000);  
                    } catch (InterruptedException e) {  
                        e.printStackTrace();  
                    }  
                      
                /**************�ͷ��źŵ�*************/    
                    System.out.println(Thread.currentThread().getName() +"�����뿪");  
                      
                    semaphore.release();//�ͷ��źŵ�  
                    System.out.println(Thread.currentThread().getName() +", ���뿪����ǰ���� " + (maxThread - semaphore.availablePermits()) +"����");  
                      
                }  
            };  
              
            /*ִ��*/  
            executorService.execute(runnable);  
        }  
    }  
}