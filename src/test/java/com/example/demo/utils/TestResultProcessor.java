package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestResultProcessor implements TestExecutionListener {

	private final TestStatusTracker statusTracker = new TestStatusTracker();

	@Override
	public void testPlanExecutionStarted(TestPlan testPlan) {
		// Counting total tests
		statusTracker.incrementTotalTests();
	}

	@Override
	public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
		// If the test has failed, increment the failed tests counter
		if (testIdentifier.isTest() && testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
			statusTracker.incrementFailedTests();
		}
	}

	/**
	 * JUnit 테스트 실행 계획이 끝난 후 호출되는 메서드
	 * @param testPlan - 현재의 TestPlan 객체
	 */
	@Override
	public void testPlanExecutionFinished(TestPlan testPlan) {
		// Print text file if all tests succeeded
		asciiArtFiles resultFile = statusTracker.allTestsPassed() ? asciiArtFiles.SUCCESS : asciiArtFiles.FAILURE;
		try {
			printTextFile(resultFile.getFileName());
		} catch (IOException e) {
			System.err.println("Error reading the text file: " + e.getMessage());
		}
	}

	/**
	 * 텍스트 파일을 콘솔에 출력하는 메서드
	 * @throws IOException 파일을 읽는 도중 발생할 수 있는 예외
	 */
	private void printTextFile(String testFile) throws IOException {
		Resource resource = new ClassPathResource(testFile);
		try (InputStream inputStream = resource.getInputStream();
			 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
