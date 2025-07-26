package com.visionreport.core;

/**
 * Defines the contract for any class that can generate a report.
 * <p>
 * This interface decouples the report generation logic from the main API,
 * allowing for different types of report generators (e.g., HTML, PDF, JSON) to
 * be implemented and used interchangeably.
 * </p>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public interface ReportGenerator {

	/**
	 * Generates the report based on the provided configuration and test data.
	 * <p>
	 * The implementation of this method is responsible for processing the data,
	 * rendering it into the final format (e.g., an HTML file), and saving it to the
	 * specified output location.
	 * </p>
	 *
	 * @throws Exception if any error occurs during the report generation process,
	 *                   such as a template loading failure or an I/O error.
	 *                   Specific implementations should throw more concrete
	 *                   exceptions.
	 */
	void generate() throws Exception;

}