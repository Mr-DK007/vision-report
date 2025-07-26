package com.visionreport.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import com.visionreport.exception.VisionReportException;

/**
 * Represents a media attachment (e.g., a screenshot) for a {@link LogEntry}.
 * <p>
 * This class provides static factory methods to create media objects from a
 * file path, a URL, or a Base64 string. It handles the necessary validation and
 * conversion, ensuring that all media is in a report-ready format (either a URL
 * or a Base64 data URI).
 * </p>
 *
 * @author Vision-Report Team
 * @version 0.0.1-SNAPSHOT
 * @since 0.0.1
 */
public class Media {

	private final String data;

	/**
	 * Private constructor to enforce the use of the static factory methods.
	 * 
	 * @param data The report-ready media data (a URL or a Base64 data URI).
	 */
	private Media(String data) {
		this.data = data;
	}

	/**
	 * Gets the processed media data, ready for embedding in a report.
	 * 
	 * @return A string containing either a URL or a Base64 data URI.
	 */
	public String getData() {
		return data;
	}

	/**
	 * Creates a Media object from a file path.
	 * <p>
	 * Reads the file, converts it to a Base64 data URI, and returns a Media object.
	 * </p>
	 * 
	 * @param path The relative or absolute path to the image file.
	 * @return A new {@link Media} instance containing the Base64 data.
	 * @throws VisionReportException if the path is invalid or the file cannot be
	 *                               read.
	 */
	public static Media fromPath(String path) throws VisionReportException {
		try {
			Path filePath = Paths.get(path);
			if (!Files.exists(filePath) || !Files.isReadable(filePath)) {
				throw new VisionReportException("Media file does not exist or is not readable at path: " + path);
			}
			byte[] fileBytes = Files.readAllBytes(filePath);
			String base64String = Base64.getEncoder().encodeToString(fileBytes);
			String mimeType = Files.probeContentType(filePath);
			if (mimeType == null) {
				mimeType = "application/octet-stream"; // A sensible default
			}
			return new Media("data:" + mimeType + ";base64," + base64String);
		} catch (InvalidPathException e) {
			throw new VisionReportException("Invalid media file path: " + path, e);
		} catch (IOException e) {
			throw new VisionReportException("Failed to read media file at path: " + path, e);
		}
	}

	/**
	 * Creates a Media object from a URL.
	 * 
	 * @param url The absolute URL of the media.
	 * @return A new {@link Media} instance.
	 * @throws VisionReportException if the URL is malformed.
	 */
	public static Media fromUrl(String url) throws VisionReportException {
		if (url == null || !(url.startsWith("http://") || url.startsWith("https://"))) {
			throw new VisionReportException("Invalid media URL. Must start with 'http://' or 'https://'. URL: " + url);
		}
		return new Media(url);
	}

	/**
	 * Creates a Media object from an existing Base64 data URI.
	 * 
	 * @param base64Data The Base64 data URI (e.g., "data:image/png;base64,...").
	 * @return A new {@link Media} instance.
	 * @throws VisionReportException if the string is not a valid data URI.
	 */
	public static Media fromBase64(String base64Data) throws VisionReportException {
		if (base64Data == null || !base64Data.trim().startsWith("data:")) {
			throw new VisionReportException(
					"Invalid Base64 data. Must be a valid data URI (e.g., 'data:image/png;base64,...').");
		}
		return new Media(base64Data);
	}
}