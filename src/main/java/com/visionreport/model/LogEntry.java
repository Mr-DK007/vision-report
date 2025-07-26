package com.visionreport.model;

import java.time.LocalDateTime;

public class LogEntry {

	private String logId;
	private String name;
	private String message;
	private final Status status;
	private final LocalDateTime timestamp;
	private Media media; // New field

	LogEntry(Status status, String name) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.name = name;
		this.message = "No message available.";
	}

	// Getters
	public String getLogId() {
		return logId;
	}

	public String getName() {
		return name;
	}

	public String getMessage() {
		return message;
	}

	public Status getStatus() {
		return status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public Media getMedia() {
		return media;
	} // New getter

	// Fluent Setters
	LogEntry setLogId(String logId) {
		this.logId = logId;
		return this;
	}

	public LogEntry setMessage(String message) {
		if (message != null && !message.trim().isEmpty()) {
			this.message = message;
		}
		return this;
	}

	/**
	 * Attaches a media object (e.g., screenshot) to this log entry.
	 * 
	 * @param media The {@link Media} object to attach.
	 * @return The current {@link LogEntry} instance for method chaining.
	 */
	public LogEntry attachMedia(Media media) {
		this.media = media;
		return this;
	}
}