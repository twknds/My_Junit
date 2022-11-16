package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class Test {
    protected String testName;
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    public Test(String testName){
        this.testName=testName;
    }
    public void run(){
        before();
        runTest();
        after();
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
