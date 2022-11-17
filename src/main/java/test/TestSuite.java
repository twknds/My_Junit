package test;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements TestInterface{
    private List<Test> tests = new ArrayList<>();
    @Override
    public void run(TestResult testResult){
        for (Test test : this.tests) {
            test.run(testResult);
        }
    }
    public void addTests(Test test){
        tests.add(test);
    }
}
