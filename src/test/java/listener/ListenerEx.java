package listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public class ListenerEx implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Catching the failure");
    }
}
