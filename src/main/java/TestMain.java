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
        testResult.renewCount(new TestMain("runTest").run());
        testResult.renewCount(new TestMain("runTest_2").run());
        testResult.printCount();
        /* run메서드 파라미터를 건드리는 경우
        TestResult testResult = new TestResult();
        new TestMain("runTest").run(testResult));
        new TestMain("runTest_2").run(testResult));
        testResult.printCount();
         */
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
