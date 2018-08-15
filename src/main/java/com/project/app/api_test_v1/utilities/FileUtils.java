package com.project.app.api_test_v1.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.project.app.api_test_v1.models.Filepath;
import com.project.app.api_test_v1.models.Operators;

public class FileUtils {
	
	/**
	 * Read file to FileReader
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public FileReader readFileToPath(final String path) throws FileNotFoundException {
		return new FileReader(Filepath.SYSTEM_PATH.concat(Operators.FORWARD_SLASH_OPERATOR).concat(path));
	}
	
	/**
	 * Initiate File Object with file path
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	
	public File initiateFile(final String path) throws FileNotFoundException {
		return new File(Filepath.SYSTEM_PATH.concat(Operators.FORWARD_SLASH_OPERATOR).concat(path));
	}

	/**
	 * Convert file elements to a StringBuilder String
	 * @param path
	 * @return
	 * @throws IOException
	 */
	
	public String readFileToString(final String path) throws IOException {
		BufferedReader reader = new BufferedReader(readFileToPath(path));
		StringBuilder stringBuilder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line);
			stringBuilder.append(Filepath.LINE_SEPARATOR);
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();

		String content = stringBuilder.toString();
		return content;
	}
	
	/**
	 * Convert file elements to a StringBuilder String from an initiating point
	 * @param path
	 * @return
	 * @throws IOException
	 */
	
	public String readFileToStringFromInitializingPoint(final String path, final String initializingPoint) throws IOException {
		BufferedReader reader = new BufferedReader(readFileToPath(path));
		StringBuilder stringBuilder = new StringBuilder();
		boolean lineMatcherFlag = false;
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.contains(initializingPoint)) {
				lineMatcherFlag = true;
			}
			if (lineMatcherFlag) {
				stringBuilder.append(line);
				stringBuilder.append(Filepath.LINE_SEPARATOR);
			}
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();

		String content = stringBuilder.toString();
		return content;
	}
	
	/**
	 * Convert file elements to a StringBuilder String from an initiating point till concluding Point
	 * @param path
	 * @return
	 * @throws IOException
	 */
	
	public String readFileToStringFromStartPointToEndPoint(final String path, final String initializingPoint, final String concludePoint) throws IOException {
		BufferedReader reader = new BufferedReader(readFileToPath(path));
		StringBuilder stringBuilder = new StringBuilder();
		boolean lineMatcherFlag = false;
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (line.contains(initializingPoint)) {
				lineMatcherFlag = true;
			}
			if (lineMatcherFlag) {
				stringBuilder.append(line);
				stringBuilder.append(Filepath.LINE_SEPARATOR);
				 if (line.contains(concludePoint))
					 break;
			}
		}
		// delete the last new line separator
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		reader.close();

		String content = stringBuilder.toString();
		return content;
	}
	
	/**
	 * Convert property file elements to maps for fetching the elements separately in  maps
	 * @param path
	 * @return
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> getPropertyFileDataStream(final String path) {
		Map<String, Object> propertyDetails = new HashMap<String, Object>();
		Properties properties = new Properties();
		File file;
		FileInputStream inputStream;
		try {
			file = initiateFile(path);
			inputStream = new FileInputStream(file);
			properties.load(inputStream);
		} catch (FileNotFoundException exceptionObject) {
			exceptionObject.printStackTrace();
		} catch (Exception exceptionObject) {
			exceptionObject.printStackTrace();
		}
		propertyDetails = new HashMap<String, Object>((Map) properties);
		return propertyDetails;
	}
}
