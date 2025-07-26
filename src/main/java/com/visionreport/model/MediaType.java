package com.visionreport.model;

/**
 * Defines the type of media attachment for a {@link LogEntry}.
 * <p>
 * This helps the reporting engine determine how to render the media, for
 * example, using a standard {@code <img>} tag for a URL or a data URI for
 * Base64 content.
 * </p>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public enum MediaType {
	/** A relative file path or an absolute URL to an image. */
	URL,

	/** A Base64 encoded string representing the image data. */
	BASE64;
}