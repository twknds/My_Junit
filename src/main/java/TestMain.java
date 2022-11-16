import error.Assert;
import test.Test;

import java.lang.reflect.Method;

public class TestMain extends Test {
    public TestMain(String testName) {
        super(testName);
    }
    public static void main(String[] args){
        new TestMain("runTest").run();
    }
    public void runTest(){
        long sum = 10+10;
        Assert.assertTest(sum==20);
    }
    @Override
    public void run(){
        try{
            Method method = this.getClass().getMethod(super.testName,null);
            method.invoke(this,null);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
