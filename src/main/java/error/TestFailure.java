package error;

import test.Test;

public class TestFailure {
    private Test test;
    public TestFailure(Test test){
        this.test=test;
    }
    public String getTestName(){
        return test.getTestName();
    }
}
