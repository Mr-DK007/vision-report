package com.visionreport.exception;

/**
 * The base exception for all custom exceptions thrown by the Vision-Report
 * library.
 * <p>
 * Catching this exception allows for handling any error originating from the
 * report generation process in a single catch block. Specific subclasses
 * provide more detailed context about the nature of the failure.
 * </p>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public class VisionReportException extends Exception {

	/**
	 * A unique identifier for this exception class during serialization.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new VisionReportException with the specified detail message.
	 *
	 * @param message The detail message. The detail message is saved for later
	 *                retrieval by the {@link #getMessage()} method.
	 */
	public VisionReportException(String message) {
		super(message);
	}

	/**
	 * Constructs a new VisionReportException with the specified detail message and
	 * cause.
	 * <p>
	 * Note that the detail message associated with {@code cause} is <em>not</em>
	 * automatically incorporated in this exception's detail message.
	 * </p>
	 *
	 * @param message The detail message (which is saved for later retrieval by the
	 *                {@link #getMessage()} method).
	 * @param cause   The cause (which is saved for later retrieval by the
	 *                {@link #getCause()} method). (A {@code null} value is
	 *                permitted, and indicates that the cause is nonexistent or
	 *                unknown.)
	 */
	public VisionReportException(String message, Throwable cause) {
		super(message, cause);
	}
}