package design.patterns.structural.objectpool;

import design.patterns.structural.objectpool.impl.ExecutorThreadPool;
import design.patterns.structural.objectpool.impl.PoolException;
import design.patterns.structural.objectpool.impl.factory.ExecutorTaskFactory;
import design.patterns.structural.objectpool.impl.poolable.ExecutorTask;

public class ObjectPool {

    public static void main(String[] args) {
        final ExecutorThreadPool pool = new ExecutorThreadPool(2, 6, 1000*100, new ExecutorTaskFactory());

        for (int c = 0; c < 10; c++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ExecutorTask task = pool.getObject();
                        task.execute();
                        pool.releaseObject(task);
                    } catch (PoolException e) {
                        System.out.println("Error ==> " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        
        try {
            System.in.read();
            System.out.println(pool);
        } catch (Exception e) {
            System.out.println("Out disponible");
        }

    }
    
}
