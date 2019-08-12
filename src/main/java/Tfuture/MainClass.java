package Tfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MainClass implements Callable<String> {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        System.out.println("do task !");
        return null;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        for (int j = 0; j < 3; j++) {
            int k = 2000;
            ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(k);
            if (j == 1) {
                k = 3000;
                newFixedThreadPool = Executors.newFixedThreadPool(k);
            }
            if (j == 2) {
                k = 4000;
                newFixedThreadPool = Executors.newFixedThreadPool(k+100);
            }
            for (int i = 0; i < k; i++) {
                System.out.println("开始做事！");
                FutureTask<String> futureTask = new FutureTask<>(new MainClass("1"));
                newFixedThreadPool.submit(futureTask);
            }
            System.out.println("异步返回！");
            newFixedThreadPool.shutdown();
        }

    }

    public MainClass(String id) {
        // TODO Auto-generated constructor stub
    }

}
