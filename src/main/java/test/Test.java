package test;

public abstract class Test {
    protected String testName;
    public Test(String testName){
        this.testName=testName;
    }
    public abstract void run();
}
