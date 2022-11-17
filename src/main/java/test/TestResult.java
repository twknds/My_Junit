package test;

import error.TestError;
import error.TestFailure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    private static final Logger logger = LoggerFactory.getLogger(TestResult.class);
    private int runTestCount;
    private List<TestFailure> failures;
    private List<TestError> errors;
    public TestResult() {
        this.runTestCount = 0;
        this.failures = new ArrayList<>();
        this.errors = new ArrayList<>();
    }
    public synchronized void startTest() {
        this.runTestCount++;
    }
    public synchronized void renewCount(TestResult testResult) {
        this.runTestCount += testResult.getRunTestCount();
    }
    public synchronized void addFailure(Test test){
        this.failures.add(new TestFailure(test));
    }
    public synchronized void addError(Test test,Exception e){
        this.errors.add(new TestError(test,e));
    }
    public int getRunTestCount(){
        return runTestCount;
    }
    public void printCount(){
        logger.info("Total Test Count: {}", runTestCount);
        logger.info("Total Test Success : {}",runTestCount - failures.size() - errors.size());
        logger.info("Total Test Failure : {}",failures.size());
        logger.info("Total Test Error : {}",errors.size());
    }
}
