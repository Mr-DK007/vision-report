package com.visionreport.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Represents a single, executable test case within a test suite.
 * <p>
 * This class is the core data model for a test. It holds all relevant
 * information and provides a fluent API for configuration and adding logs.
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
	private Status status = Status.SKIP;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Duration duration;
	private Set<String> tags;
	private final List<LogEntry> logs;
	private int logCounter = 0;

	public TestCase(String name) {
		this.name = name;
		this.startTime = LocalDateTime.now();
		this.tags = new HashSet<>();
		this.logs = new ArrayList<>();
		this.description = "No description available.";
	}

	private String generateNextLogId() {
		return "Log #" + ++logCounter;
	}

	// --- Log Creation API ---

	/**
	 * Creates and adds a new log entry to this test case. Uses an auto-generated
	 * ID.
	 * 
	 * @param status The mandatory {@link Status} of the log (e.g., PASS, FAIL).
	 * @param name   The mandatory name/title of the log step.
	 * @return The created {@link LogEntry} object for further configuration.
	 */
	public LogEntry addLog(Status status, String name) {
		LogEntry log = new LogEntry(status, name);
		log.setLogId(generateNextLogId());
		this.logs.add(log);
		return log;
	}

	/**
	 * Creates and adds a new log entry with a custom ID.
	 * 
	 * @param status The mandatory {@link Status} of the log.
	 * @param logId  The custom identifier for the log step.
	 * @param name   The mandatory name/title of the log step.
	 * @return The created {@link LogEntry} object for further configuration.
	 */
	public LogEntry addLog(Status status, String logId, String name) {
		LogEntry log = new LogEntry(status, name);
		log.setLogId(logId);
		this.logs.add(log);
		return log;
	}

	/**
	 * Creates and adds a new log entry with a custom ID and detailed message.
	 * 
	 * @param status  The mandatory {@link Status} of the log.
	 * @param logId   The custom identifier for the log step.
	 * @param name    The mandatory name/title of the log step.
	 * @param message A detailed message for the log.
	 * @return The created {@link LogEntry} object for further configuration.
	 */
	public LogEntry addLog(Status status, String logId, String name, String message) {
		LogEntry log = addLog(status, logId, name);
		log.setMessage(message);
		return log;
	}

	/**
	 * Creates and adds a new log entry with a message and a media attachment.
	 * 
	 * @param status  The mandatory {@link Status} of the log.
	 * @param name    The mandatory name/title of the log step.
	 * @param message A detailed message for the log.
	 * @param media   The {@link Media} object to attach.
	 * @return The created {@link LogEntry} object.
	 */
	public LogEntry addLog(Status status, String name, String message, Media media) {
		LogEntry log = addLog(status, name);
		log.setMessage(message);
		log.attachMedia(media);
		return log;
	}

	// --- Getters ---

	public String getTestId() {
		return testId;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Status getStatus() {
		return status;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public Duration getDuration() {
		return duration;
	}

	public Set<String> getTags() {
		return tags;
	}

	public List<LogEntry> getLogs() {
		return logs;
	}

	// --- Fluent Setters ---

	public TestCase setTestId(String testId) {
		this.testId = testId;
		return this;
	}

	public TestCase setName(String name) {
		this.name = name;
		return this;
	}

	public TestCase setDescription(String description) {
		if (description != null && !description.trim().isEmpty()) {
			this.description = description;
		}
		return this;
	}

	public TestCase setStatus(Status status) {
		this.status = status;
		return this;
	}

	public TestCase setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
		return this;
	}

	public TestCase setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
		return this;
	}

	public TestCase setDuration(Duration duration) {
		this.duration = duration;
		return this;
	}

	public TestCase addTag(String tag) {
		if (tag != null && !tag.trim().isEmpty()) {
			this.tags.add(tag.trim());
		}
		return this;
	}

	public TestCase setTags(String... tags) {
		this.tags = Arrays.stream(tags).filter(tag -> tag != null && !tag.trim().isEmpty()).map(String::trim)
				.collect(Collectors.toSet());
		return this;
	}
}