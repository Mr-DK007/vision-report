package com.visionreport.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a single, executable test case within a test suite.
 * <p>
 * This class is the core data model for a test. It holds all relevant
 * information, including its ID, name, description, status, and execution
 * timing. It is designed to be a simple Plain Old Java Object (POJO).
 * </p>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public class TestCase {

	private String testId;
	private String name;
	private String description;
	private Status status = Status.SKIP; // Default status is SKIP until set otherwise
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Duration duration;
	private Set<String> tags;

	// private List<LogEntry> logs; // To be implemented in a later step

	/**
	 * Constructs a new TestCase with a specified name. The start time is set to the
	 * moment of instantiation.
	 *
	 * @param name The official name of the test case. Cannot be null.
	 */
	public TestCase(String name) {
		this.name = name;
		this.startTime = LocalDateTime.now();
		this.tags = new HashSet<>();
		// this.logs = new ArrayList<>(); // To be implemented in a later step
	}

	// --- Getters and Setters ---

	/**
	 * Gets the unique identifier for this test case.
	 * 
	 * @return The test case ID (e.g., "TC-001").
	 */
	public String getTestId() {
		return testId;
	}

	/**
	 * Sets the unique identifier for this test case.
	 * 
	 * @param testId The test case ID to set.
	 */
	public void setTestId(String testId) {
		this.testId = testId;
	}

	/**
	 * Gets the name of the test case.
	 * 
	 * @return The test case name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the test case.
	 * 
	 * @param name The test case name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the detailed description of the test case.
	 * 
	 * @return The test case description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the detailed description of the test case.
	 * 
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the final execution status of the test case.
	 * 
	 * @return The {@link Status} of the test case.
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Sets the final execution status of the test case.
	 * 
	 * @param status The {@link Status} to set.
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Gets the timestamp when the test case started execution.
	 * 
	 * @return The start time as a {@link LocalDateTime}.
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * Sets the timestamp when the test case started execution.
	 * 
	 * @param startTime The start time to set.
	 */
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the timestamp when the test case finished execution.
	 * 
	 * @return The end time as a {@link LocalDateTime}.
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	/**
	 * Sets the timestamp when the test case finished execution.
	 * 
	 * @param endTime The end time to set.
	 */
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the total execution time of the test case.
	 * 
	 * @return The duration as a {@link Duration} object.
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * Sets the total execution time of the test case.
	 * <p>
	 * This is typically calculated by the reporting engine after the test has
	 * finished by comparing the start and end times.
	 * </p>
	 * 
	 * @param duration The duration to set.
	 */
	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	/**
	 * Gets the set of tags associated with this test case for categorization.
	 * 
	 * @return A {@link Set} of string tags.
	 */
	public Set<String> getTags() {
		return tags;
	}

	/**
	 * Sets the set of tags for this test case.
	 * 
	 * @param tags A {@link Set} of string tags.
	 */
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
}