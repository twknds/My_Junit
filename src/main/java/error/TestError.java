package error;

import test.Test;

public class TestError{
    private Test test;
    private Exception exception;

    public TestError(Test testCase, Exception exception) {
        this.test = testCase;
        this.exception = exception;
    }

    public String getTestName() {
        return test.getTestName();
    }

    public Exception getException() {
        return exception;
    }
}
