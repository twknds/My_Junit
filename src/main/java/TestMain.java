import error.Assert;
import org.slf4j.LoggerFactory;
import test.Test;
import test.TestResult;
import org.slf4j.Logger;

public class TestMain extends Test {
    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);
    public TestMain(String testName) {
        super(testName);
    }
    public static void main(String[] args){
        TestResult testResult = new TestResult();
        new TestMain("runTest1").run(testResult);
        new TestMain("runTest_2").run(testResult);
        testResult.printCount();
    }
    public void runTest(){
        long sum = 10+1;
        Assert.assertTest(sum==20);
    }
    public void runTest_2() {
        long minus = 100-1;
        Assert.assertTest(minus == 90);
    }
}
