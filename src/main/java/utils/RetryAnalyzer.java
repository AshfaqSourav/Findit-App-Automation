package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 1; // 🔁 Retry once on failure

    @Override
    public boolean retry(ITestResult result) {
        return retryCount++ < maxRetryCount;
    }
}
