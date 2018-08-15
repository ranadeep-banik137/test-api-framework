package com.project.app.api_test_v1.utilities;

import java.util.Random;
import java.util.logging.Logger;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.project.app.api_test_v1.exceptions.IntegerOutOfRangeException;
import com.project.app.api_test_v1.models.Operators;

public class RandomUtils {
	
	private static Logger LOGGER = Logger.getLogger(RandomUtils.class.getName());
	private static int genericCount = 8;
	private final static Random randomObject = new Random();
	
	static {
		LOGGER.info("Entering ".concat(RandomUtils.class.getName()).concat(StringUtils.SPACE.concat("class")));
		LOGGER.entering(RandomUtils.class.getName(), StringUtils.EMPTY);
	}
	
	
	/**
	 * Validates whether the final range provided is within 9999999999 or not.
	 * else the system quits at this point
	 * @param range
	 * @throws IntegerOutOfRangeException
	 */
	
	private static void checkIntegerRange(int range) throws IntegerOutOfRangeException {
		if (range > 999999999) {
			new IntegerOutOfRangeException("Range Is more than 9");
			LOGGER.info("Range Is more than 9");
			System.exit(0);
		}
		LOGGER.info("Range check successful");
	}

	/**
	 * Validates whether the start and the end range is wthin bound or not
	 * else the system performs an exit at this point
	 * @param startRange
	 * @param endRange
	 * @throws NumberFormatException
	 */
	
	private static void checkIntegerComparableRange(int startRange, int endRange) throws NumberFormatException {
		try {
			RandomUtils.checkIntegerRange(endRange);
		} catch (IntegerOutOfRangeException exception) {
			exception.printStackTrace();
		}
		if (startRange >= endRange) {
			new NumberFormatException("Ranges are equal");
			LOGGER.info("Ranges are equal");
			System.exit(0);
		}
		LOGGER.info("Range check successful");
	}
	
	/**
	 * Validates whether the excluded number lies in between the range or not
	 * @param startRange
	 * @param endRange
	 * @param excludeNumber
	 * @throws NumberFormatException
	 */
	
	private static void checkExcludeNumberRange(int startRange, int endRange, int excludeNumber) throws NumberFormatException {
		try {
			RandomUtils.checkIntegerRange(endRange);
		} catch (IntegerOutOfRangeException exception) {
			exception.printStackTrace();
		}
		RandomUtils.checkIntegerComparableRange(startRange, endRange);
		if ((endRange - startRange) == 1 && (excludeNumber <= endRange || excludeNumber >= startRange)) {
			LOGGER.info("Either Exclude Number Is not In Range or out of bound to filtrate");
			System.exit(0);
		}
	}
	
	/**
	 * returns random alphanumeric string of default size 8
	 * @param count
	 * @return
	 */
	
	public static String getRandomDefaultString(int count) {
		return RandomStringUtils.randomAlphanumeric(RandomUtils.getGenericCount());
	}
	
	/**
	 * returns random number with parameter as required digits
	 * @param count
	 * @return
	 */
	
	public static int getRandomNumericWithinCount(int count) {
		int randomInt = 0;
		if (count > 9) {
			try {
				throw new IntegerOutOfRangeException("Range Is more than 9");
			} catch (IntegerOutOfRangeException exceptionObject) {
				exceptionObject.printStackTrace();
			}
		}
		randomInt = Integer.parseInt(RandomStringUtils.randomNumeric(count));
		return randomInt;
	}
	
	/**
	 * returns random integer within range
	 * @param range
	 * @return
	 */
	
	public static int getRandomNumericWithinRange(int range) {
		int randomInt = 0;
		try {
			RandomUtils.checkIntegerRange(range);
		} catch (IntegerOutOfRangeException exception) {
			exception.printStackTrace();
		}
		randomInt = randomObject.nextInt(range);
		return randomInt;
	}
	
	/**
	 * returns random integer within the start and the end range
	 * @param startRange
	 * @param endRange
	 * @return
	 */
	
	public static int getRandomNumericWithinRange(int startRange, int endRange) {
		int randomInt = 0;
		RandomUtils.checkIntegerComparableRange(startRange, endRange);
		do {
			randomInt = randomObject.nextInt(endRange);
		} while (randomInt < startRange);
		return randomInt;
	}
	
	/**
	 * returns a random integer within the start and the end range and also by excluding the number mentioned
	 * @param startRange
	 * @param endRange
	 * @param excludingNumber
	 * @return
	 */
	
	public static int getRandomNumericWithinRangeExcludingValue(int startRange, int endRange, int excludingNumber) {
		int randomInt = 0;
		RandomUtils.checkExcludeNumberRange(startRange, endRange, excludingNumber);
		do {
			randomInt = randomObject.nextInt(endRange);
		} while (randomInt < startRange || randomInt == excludingNumber);
		return randomInt;
	}
	
	/**
	 * returns random number within range by excluding the number mentioned
	 * @param range
	 * @param excludingNumber
	 * @return
	 */
	
	public static int getRandomNumericExcludingValue(int range, int excludingNumber) {
		int randomInt = 0;
		try {
			RandomUtils.checkIntegerRange(range);
			do {
				randomInt = randomObject.nextInt(range);
			} while (randomInt == excludingNumber);
		} catch (Exception exceptionObject) {
			exceptionObject.printStackTrace();
		}
		return randomInt;
	}
	
	/**
	 * returns a string built with random alphanumerics within range
	 * @param count
	 * @return
	 */
	
	public static String getRandomAlphaNumericWithinCount(int count) {
		return RandomStringUtils.randomAlphanumeric(count);
	}
	
	/**
	 * returns alphabetic random string within digit count
	 * @param count
	 * @return
	 */
	
	public static String getRandomAlphabeticWithinCount(int count) {
		return RandomStringUtils.randomAlphabetic(count);
	}
	
	/**
	 * returns ascii random string within digit count
	 * @param count
	 * @return
	 */
	
	public static String getRandomAsciiWithinCount(int count) {
		return RandomStringUtils.randomAscii(count);
	}
	
	/**
	 * returns numeric random string within digit count
	 * @param count
	 * @return
	 */
	
	public static String getRandomNumericInStringWithinCount(int count) {
		return String.valueOf(getRandomNumericWithinCount(count));
	}
	
	/**
	 * returns double random number within range
	 * @param count
	 * @return
	 */
	
	public static double getRandomDoubleWithinRange(final int range) {
		return randomObject.nextDouble();
	}
	
	/**
	 * returns float random number within range
	 * @param count
	 * @return
	 */
	
	public static double getRandomFloatWithinRange(final int range) {
		return randomObject.nextFloat();
	}
	
	/**
	 * returns a random generated double number with mentioned decimal count
	 * @param range
	 * @param decimalCount
	 * @return
	 */
	
	public static double getRandomDoubleNumberWithDecimalRange(final int range, final int decimalCount) {
		double requiredNum = 0.00;
		try {
			RandomUtils.checkIntegerRange(range);
		} catch (IntegerOutOfRangeException exception) {
			exception.printStackTrace();
		}
		requiredNum = Double.valueOf(String.valueOf(new Random().nextInt(range)) + Operators.DOT_OPERATOR + RandomStringUtils.randomNumeric(decimalCount));
		return requiredNum;
	}
	
	/** set generic count */
	public static void setGenericCount(final int genericCount) {
		RandomUtils.genericCount = genericCount;
	}
	
	/** get generic count */
	private static int getGenericCount() {
		return RandomUtils.genericCount;
	}
}
