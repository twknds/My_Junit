import error.Assert;

public class TestMain {
    public static void main(String[] args){
        new TestMain().runTest();
    }
    public void runTest(){
        long sum = 10+10;
        Assert.assertTest(sum==20);
    }
}
