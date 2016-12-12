package com.mozovw.oatmeal.jodd.log;

import jodd.log.Logger;
import jodd.log.LoggerFactoryInterface;
import jodd.log.impl.SimpleLoggerFactory;
import jodd.log.impl.Slf4jLoggerFactory;

public class JoddLoggerUtil {
	public enum LoggerType {
		SIMPLE(1), SLF4J(2);
		@SuppressWarnings("unused")
		private final int value;

		LoggerType(int value) {
			this.value = value;
		}
	}
	
	static LoggerType type = LoggerType.SLF4J;
	static LoggerFactoryInterface loggerFactoryInterface = null;
	static jodd.log.Logger debugLogger = getDebugLogger("JoddLoggerUtil");
	static jodd.log.Logger errorLogger = getErrorLogger("JoddLoggerUtil");

	public static Logger getDebugLogger(String name) {
		Logger logger = null;
		if (loggerFactoryInterface == null) {
			if (type == LoggerType.SIMPLE) {
				loggerFactoryInterface = new SimpleLoggerFactory(
						Logger.Level.DEBUG);
			} else if (type == LoggerType.SLF4J) {
				loggerFactoryInterface = new Slf4jLoggerFactory();
			}
		}
		logger = loggerFactoryInterface.getLogger(name);
		return logger;
	}

	public static Logger getErrorLogger(String name) {
		Logger logger = null;
		if (loggerFactoryInterface == null) {
			if (type == LoggerType.SIMPLE) {
				loggerFactoryInterface = new SimpleLoggerFactory(
						Logger.Level.ERROR);
			} else if (type == LoggerType.SLF4J) {
				loggerFactoryInterface = new Slf4jLoggerFactory();
			}
		}
		logger = loggerFactoryInterface.getLogger(name);
		return logger;
	}

	public static void debug(String message) {
		if (debugLogger.isDebugEnabled())
			debugLogger.debug(message);
	}

	public static void error(String message, Throwable throwable) {
		errorLogger.error(message, throwable);
	}

	public static void error(String message) {
		if (errorLogger.isErrorEnabled())
			errorLogger.error(message);
	}
}
