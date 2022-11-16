import error.Assert;
import test.Test;

public class TestMain extends Test {
    public TestMain(String testName) {
        super(testName);
    }
    public static void main(String[] args){
        new TestMain("runTest").run();
        new TestMain("runTest_2").run();
    }
    public void runTest(){
        long sum = 10+10;
        Assert.assertTest(sum==20);
    }
    public void runTest_2() {
        long minus = 100-10;
        Assert.assertTest(minus == 90);
    }
}
