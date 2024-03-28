package design.patterns.structural.objectpool.impl.poolable;

public class ExecutorTask implements IPooledObject {
    
    private int uses;
    private static int invalidate;
    private static int counter;

    public void execute() {
        int c = ++counter ;
        uses++;
        System.out.println("execute ==> " + c);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
        }
        System.out.println("execute end ==> " + c);
    }

    @Override
    public boolean validate() {
        return uses < 2;
    }

    @Override
    public void invalidate() {
        invalidate++;
        System.out.println("Invalidate Counter ==> " + invalidate);
    }
    
}
