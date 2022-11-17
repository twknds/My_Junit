import error.Assert;
import org.slf4j.LoggerFactory;
import test.Test;
import test.TestResult;
import org.slf4j.Logger;
import test.TestSuite;

public class TestMain extends Test {
    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);
    public TestMain(String testName) {
        super(testName);
    }
    public static void main(String[] args){
        TestSuite testSuite = new TestSuite();
        TestResult testResult = new TestResult();
        testSuite.addTests(new TestMain("runTest"));
        testSuite.addTests(new TestMain("runTest_2"));
        testSuite.run(testResult);
        testResult.printCount();
    }
    public void runTest(){
        long sum = 10+10;
        Assert.assertTest(sum==20);
    }
    public void runTest_2() {
        long minus = 100-1;
        Assert.assertTest(minus == 90);
    }
}
