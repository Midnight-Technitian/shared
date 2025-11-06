package dev.glabay.logging;

import io.sentry.Sentry;
import io.sentry.SentryLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;


/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-10-25
 */
public class MidnightLogger implements Logger {
    private final Logger logger;

    public MidnightLogger(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }

    public static MidnightLogger getLogger(Class<?> clazz) {
        return new MidnightLogger(clazz);
    }

    private String formatMessage(String message, Object... args) {
        if (args == null || args.length == 0)
            return message;

        var result = message;
        for (Object arg : args) {
            if (arg instanceof Throwable) continue;
            int index = result.indexOf("{}");
            if (index != -1) {
                String argString = String.valueOf(arg);
                result = result.substring(0, index) + argString + result.substring(index + 2);
            }
        }
        return result;
    }

    @Override
    public void error(String s, Throwable throwable) {
        Sentry.addBreadcrumb(s, "error");
        Sentry.captureException(throwable);
        logger.error(s, throwable);
    }

    @Override
    public void error(String message) {
        if (isCriticalError(message))
            Sentry.captureMessage(message, SentryLevel.ERROR);
        logger.error(message);
    }

    @Override
    public void error(String s, Object o) {
        if (o instanceof Throwable)
            error(s, (Throwable) o);
        else {
            var formattedMessage = s.replace("{}", String.valueOf(o));
            if (isCriticalError(formattedMessage))
                Sentry.captureMessage(formattedMessage, SentryLevel.ERROR);
            logger.error(s, o);
        }
    }

    @Override
    public void error(String s, Object o, Object o1) {
        if (o1 instanceof Throwable) {
            var formattedMessage = s.replace("{}", String.valueOf(o));
            error(formattedMessage, (Throwable) o1);
        }
        else {
            var formattedMessage = s.replace("{}", String.valueOf(o)).replace("{}", String.valueOf(o1));
            if (isCriticalError(formattedMessage))
                Sentry.captureMessage(formattedMessage, SentryLevel.ERROR);
            logger.error(s, o, o1);
        }
    }

    @Override
    public void error(String s, Object... objects) {
        // Check if last object is a throwable
        Throwable throwable = null;
        Object[] args = objects;

        if (objects.length > 0 && objects[objects.length - 1] instanceof Throwable) {
            throwable = (Throwable) objects[objects.length - 1];
            args = new Object[objects.length - 1];
            System.arraycopy(objects, 0, args, 0, args.length);
        }

        var formattedMessage = formatMessage(s, args);

        if (throwable != null)
            error(formattedMessage, throwable);
        else {
            if (isCriticalError(formattedMessage))
                Sentry.captureMessage(formattedMessage, SentryLevel.ERROR);
            logger.error(s, objects);
        }
    }

    private boolean isCriticalError(String message) {
        if (message == null) return false;
        var lowerMessage = message.toLowerCase();
        return  lowerMessage.contains("exception") ||
            lowerMessage.contains("failed") ||
            lowerMessage.contains("error") ||
            lowerMessage.contains("critical") ||
            lowerMessage.contains("fatal");
    }

    @Override
    public void warn(String message) {
        Sentry.addBreadcrumb(message, "warning");
        Sentry.captureMessage(message, SentryLevel.WARNING);
        logger.warn(message);
    }

    @Override
    public void warn(String s, Object o) {
        Sentry.addBreadcrumb(s.replace("{}", String.valueOf(o)), "warning");
        Sentry.captureMessage(s.replace("{}", String.valueOf(o)), SentryLevel.WARNING);
        logger.warn(s, o);
    }

    @Override
    public void warn(String s, Object... objects) {
        Sentry.addBreadcrumb(formatMessage(s, objects), "warning");
        Sentry.captureMessage(formatMessage(s, objects), SentryLevel.WARNING);
        logger.warn(s, objects);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        String formatted = s.replace("{}", String.valueOf(o)).replace("{}", String.valueOf(o1));
        Sentry.addBreadcrumb(formatted, "warning");
        Sentry.captureMessage(formatted, SentryLevel.WARNING);
        logger.warn(s, o, o1);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        Sentry.addBreadcrumb(s, "warning");
        Sentry.captureException(throwable);
        logger.warn(s, throwable);
    }

    // EVERYTHING BELOW IS JUST DEFAULT OVERRIDES

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String s, Object o) {
        logger.info(s, o);
    }

    @Override
    public void info(String s, Object o, Object o1) {
        logger.info(s, o, o1);
    }

    @Override
    public void info(String s, Object... objects) {
        logger.info(s, objects);
    }

    @Override
    public void info(String s, Throwable throwable) {
        logger.info(s, throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String s) {
        logger.info(marker, s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        logger.info(marker, s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        logger.info(marker, s, o, o1);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        logger.info(marker, s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        logger.info(marker, s, throwable);
    }
    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String s, Object o) {
        logger.debug(s, o);
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        logger.debug(s, o, o1);
    }

    @Override
    public void debug(String s, Object... objects) {
        logger.debug(s, objects);
    }

    @Override
    public void debug(String s, Throwable throwable) {
        logger.debug(s, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(Marker marker, String s) {
        logger.debug(marker, s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        logger.debug(marker, s, o);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        logger.debug(marker, s, o, o1);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        logger.debug(marker, s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        logger.debug(marker, s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled();
    }

    @Override
    public void warn(Marker marker, String s) {
        logger.warn(marker, s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        logger.warn(marker, s, o);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        logger.warn(marker, s, o, o1);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        logger.warn(marker, s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        logger.warn(marker, s, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled();
    }

    @Override
    public void error(Marker marker, String s) {
        logger.error(marker, s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        logger.error(marker, s, o);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        logger.error(marker, s, o, o1);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        logger.error(marker, s, objects);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        logger.error(marker, s, throwable);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String s) {
        logger.trace(s);
    }

    @Override
    public void trace(String s, Object o) {
        logger.trace(s, o);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        logger.trace(s, o, o1);
    }

    @Override
    public void trace(String s, Object... objects) {
        logger.trace(s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        logger.trace(s, throwable);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(Marker marker, String s) {
        logger.trace(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        logger.trace(marker, s, o);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        logger.trace(marker, s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        logger.trace(marker, s, objects);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        logger.trace(marker, s, throwable);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }
}
