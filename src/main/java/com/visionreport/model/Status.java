package com.visionreport.model;

/**
 * Represents the execution status of a test case or a log entry.
 * <p>
 * This enum provides a standardized set of outcomes that are used throughout
 * the reporting model to categorize results. Each status is a singleton
 * instance.
 * </p>
 * 
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public enum Status {

	/**
	 * Indicates that the test case or operation completed successfully without any
	 * errors.
	 */
	PASS,

	/**
	 * Indicates that the test case or operation encountered an error or assertion
	 * failure. This is typically a critical status that requires attention.
	 */
	FAIL,

	/**
	 * Indicates that the test case or operation was intentionally skipped. This is
	 * not considered a failure.
	 */
	SKIP,

	/**
	 * Indicates a noteworthy event or piece of information that is not a pass,
	 * fail, or skip. Useful for providing context or supplementary details in the
	 * report.
	 */
	INFO,

	/**
	 * Indicates that the test case or operation produced a warning. This is less
	 * severe than a FAIL but indicates a potential issue.
	 */
	WARNING;

}