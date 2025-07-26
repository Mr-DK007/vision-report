package com.visionreport.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.visionreport.model.ReportType;
import com.visionreport.model.TestCase;

/**
 * The main entry point for creating and managing a Vision-Report.
 * <p>
 * This class acts as a fluent builder to configure rich report metadata and
 * aggregate test cases. The lifecycle of a report begins by instantiating this
 * class with a specific {@link ReportType}, followed by chaining configuration
 * methods.
 * </p>
 *
 * <pre>
 * {@code
 * VisionReport report = new VisionReport(ReportType.UI_TESTING).setProjectName("Vision-Report Demo");
 *
 * TestCase test1 = report.addTest("Successful Login");
 * test1.setStatus(Status.PASS);
 *
 * report.flush();
 * }
 * </pre>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public class VisionReport {

	// Report Metadata
	private final ReportType reportType;
	private String reportTitle;
	private String projectName;
	private String appName;
	private String environment;
	private String domain;
	private String testerName;
	private final Set<String> businessAnalysts;

	// Report Data
	private final List<TestCase> testCases;
	private int testCaseCounter = 0;

	public VisionReport(ReportType reportType) {
		if (reportType == null) {
			throw new IllegalArgumentException("ReportType cannot be null.");
		}
		this.reportType = reportType;
		this.testCases = new ArrayList<>();
		this.businessAnalysts = new HashSet<>();
		setDefaultValues();
	}

	private void setDefaultValues() {
		this.reportTitle = this.reportType.getDefaultTitle();
		this.projectName = "N/A";
		this.appName = "N/A";
		this.environment = "N/A";
		this.domain = "N/A";
		this.testerName = "N/A";
	}

	private String generateNextTestId() {
		return "TC" + String.format("%03d", ++testCaseCounter);
	}

	// --- Test Case Creation API ---

	/**
	 * Creates and adds a new test case with an auto-generated ID.
	 * 
	 * @param name The mandatory name of the test case.
	 * @return The created {@link TestCase} object for further configuration.
	 */
	public TestCase addTest(String name) {
		TestCase testCase = new TestCase(name);
		testCase.setTestId(generateNextTestId());
		this.testCases.add(testCase);
		return testCase;
	}

	/**
	 * Creates and adds a new test case with a custom ID.
	 * 
	 * @param testId The custom identifier for the test case.
	 * @param name   The mandatory name of the test case.
	 * @return The created {@link TestCase} object for further configuration.
	 */
	public TestCase addTest(String testId, String name) {
		TestCase testCase = new TestCase(name);
		testCase.setTestId(testId);
		this.testCases.add(testCase);
		return testCase;
	}

	/**
	 * Creates and adds a new test case with a custom ID and description.
	 * 
	 * @param testId      The custom identifier for the test case.
	 * @param name        The mandatory name of the test case.
	 * @param description A detailed description of the test's purpose.
	 * @return The created {@link TestCase} object for further configuration.
	 */
	public TestCase addTest(String testId, String name, String description) {
		TestCase testCase = addTest(testId, name);
		testCase.setDescription(description);
		return testCase;
	}

	/**
	 * Creates and adds a new test case with a name and tags. Uses an auto-generated
	 * ID.
	 * 
	 * @param name The mandatory name of the test case.
	 * @param tags A comma-separated string of tags (e.g., "Smoke, Regression").
	 * @return The created {@link TestCase} object for further configuration.
	 */
	public TestCase addTestWithTags(String name, String tags) {
		TestCase testCase = addTest(name);
		if (tags != null) {
			testCase.setTags(tags.split(","));
		}
		return testCase;
	}

	/**
	 * Creates and adds a new test case with a custom ID, description, and tags.
	 * 
	 * @param testId      The custom identifier for the test case.
	 * @param name        The mandatory name of the test case.
	 * @param description A detailed description of the test's purpose.
	 * @param tags        A comma-separated string of tags (e.g., "Smoke,
	 *                    Regression").
	 * @return The created {@link TestCase} object for further configuration.
	 */
	public TestCase addTest(String testId, String name, String description, String tags) {
		TestCase testCase = addTest(testId, name, description);
		if (tags != null) {
			testCase.setTags(tags.split(","));
		}
		return testCase;
	}

	// --- Fluent Configuration Methods ---

	public VisionReport setReportTitle(String reportTitle) {
		if (reportTitle != null && !reportTitle.trim().isEmpty()) {
			this.reportTitle = reportTitle;
		}
		return this;
	}

	public VisionReport setProjectName(String projectName) {
		if (projectName != null && !projectName.trim().isEmpty()) {
			this.projectName = projectName;
		}
		return this;
	}

	public VisionReport setApplicationName(String appName) {
		if (appName != null && !appName.trim().isEmpty()) {
			this.appName = appName;
		}
		return this;
	}

	public VisionReport setEnvironment(String environment) {
		if (environment != null && !environment.trim().isEmpty()) {
			this.environment = environment;
		}
		return this;
	}

	public VisionReport setDomain(String domain) {
		if (domain != null && !domain.trim().isEmpty()) {
			this.domain = domain;
		}
		return this;
	}

	public VisionReport setTesterName(String testerName) {
		if (testerName != null && !testerName.trim().isEmpty()) {
			this.testerName = testerName;
		}
		return this;
	}

	public VisionReport addBusinessAnalyst(String name) {
		if (name != null && !name.trim().isEmpty()) {
			this.businessAnalysts.add(name);
		}
		return this;
	}

	// --- Getters ---

	public ReportType getReportType() {
		return reportType;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getApplicationName() {
		return appName;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getDomain() {
		return domain;
	}

	public String getTesterName() {
		return testerName;
	}

	public Set<String> getBusinessAnalysts() {
		return businessAnalysts;
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}
}