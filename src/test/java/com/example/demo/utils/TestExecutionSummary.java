package com.example.demo.utils;

public class TestExecutionSummary {
    private final boolean allTestsPassed;

    public TestExecutionSummary(boolean allTestsPassed) {
        this.allTestsPassed = allTestsPassed;
    }

    public void printSummary() {
        if (allTestsPassed) {
            System.out.println("All tests succeeded.");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}
