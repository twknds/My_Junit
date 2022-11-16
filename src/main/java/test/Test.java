package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class Test {
    protected String testName;
    private TestResult testResult;
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public Test(String testName){
        this.testName=testName;
    }
    public TestResult run(){
        getResultInstance();
        run(testResult);
        return testResult;
    }
    public void run(TestResult testResult){
        testResult.startTest();
        before();
        runTest();
        after();
    }
    private void getResultInstance(){
        try {
            if (testResult.equals(null)==true) {
                 testResult = new TestResult();
            }
        }catch (NullPointerException e){
            testResult = new TestResult();
        }
    }
    protected void before(){}
    protected void after(){}
    private void runTest(){
        try{
            logger.info("{} execute ",testName);
            Method method = this.getClass().getMethod(testName,null);
            method.invoke(this,null);
        } catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
