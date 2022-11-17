package test;

import error.AssertionFailedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Test implements TestInterface{
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
    @Override
    public void run(TestResult testResult){
        testResult.startTest();
        before();
        try {
            runTest();
        }catch (InvocationTargetException ite) {
            if(isAssertionFailed(ite)) {
                logger.info("into Exception1");
                testResult.addFailure(this);
            }else{
                testResult.addError(this,ite);
            }
        }catch (Exception e){
            testResult.addError(this,e);
        }finally {
            after();
        }
    }
    private boolean isAssertionFailed(InvocationTargetException e){
        return e.getTargetException() instanceof AssertionFailedError;
    }
    private void getResultInstance(){
        try {
            if (testResult.equals(null)) {
                 testResult = new TestResult();
            }
        }catch (NullPointerException e){
            testResult = new TestResult();
        }
    }
    protected void before(){}
    protected void after(){}
    private void runTest() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException{
        logger.info("{} execute ",testName);
        Method method = this.getClass().getMethod(testName,null);
        method.invoke(this,null);
    }
    public String getTestName(){
        return testName;
    }
}
