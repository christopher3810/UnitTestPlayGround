package com.example.demo.utils;

public class TestStatusTracker {
    private int totalTests = 0;
    private int failedTests = 0;

    public void incrementTotalTests() {
        totalTests++;
    }

    public void incrementFailedTests() {
        failedTests++;
    }

    public boolean allTestsPassed() {
        return totalTests > 0 && failedTests == 0;
    }
}
