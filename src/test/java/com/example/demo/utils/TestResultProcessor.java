package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.example.demo.Exception.TestExecutionException;

public class TestResultProcessor implements TestExecutionListener {
	public static boolean allTestsPassed = true;
	// 텍스트 파일이 출력되었는지 확인하기 위한 플래그
	private static boolean isReported = false;

	/**
	 * JUnit 테스트 실행 계획이 끝난 후 호출되는 메서드
	 * @param testPlan - 현재의 TestPlan 객체
	 */
	@Override
	public void testPlanExecutionFinished(TestPlan testPlan) {
		// 텍스트 파일이 아직 출력되지 않았다면 출력한다.
		if (!isReported) {
			try {
				printTextFile();
			} catch (IOException e) {
				throw new TestExecutionException("Failed to print text file", e);
			}
			isReported = true;
		}
	}

	/**
	 * 텍스트 파일을 콘솔에 출력하는 메서드
	 * @throws IOException 파일을 읽는 도중 발생할 수 있는 예외
	 */
	private void printTextFile() throws IOException {
		Resource resource = new ClassPathResource("testchachu.txt");
		try (InputStream inputStream = resource.getInputStream();
			 BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
