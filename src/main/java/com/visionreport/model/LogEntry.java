package com.visionreport.model;

import java.time.LocalDateTime;

/**
 * Represents a single log entry or step within a {@link TestCase}.
 * <p>
 * This class captures a specific event that occurred during a test's execution,
 * including its status, a descriptive message, and the exact time it happened.
 * It is a fundamental component for providing detailed, step-by-step test
 * reports.
 * </p>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public class LogEntry {

	private final LocalDateTime timestamp;
	private final Status status;
	private final String message;

	// private Attachment attachment; // To be implemented in a future step

	/**
	 * Constructs a new LogEntry. The timestamp is automatically set to the moment
	 * of instantiation.
	 *
	 * @param status  The {@link Status} of the log entry (e.g., PASS, FAIL, INFO).
	 * @param message A descriptive message detailing the event.
	 */
	public LogEntry(Status status, String message) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
	}

	// --- Getters ---

	/**
	 * Gets the timestamp when the log entry was created.
	 * 
	 * @return The creation time as a {@link LocalDateTime}.
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets the status of the log entry.
	 * 
	 * @return The {@link Status} of the log.
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Gets the descriptive message for the log entry.
	 * 
	 * @return The log message string.
	 */
	public String getMessage() {
		return message;
	}
}