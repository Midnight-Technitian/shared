package dev.glabay.logging;

import io.sentry.Sentry;

/**
 * @author Glabay | Glabay-Studios
 * @project backend
 * @social Discord: Glabay
 * @since 2025-10-25
 */
public class SentryConfig {
    private static final String ENVIRONMENT_PROD = "production";
    private static final String ENVIRONMENT_DEV = "development";
    private static final String ENVIRONMENT_TEST = "test";

    private static final String SENTRY_HOST =  System.getenv("SENTRY_HOST");
    private static final String SENTRY_ENVIRONMENT =  System.getenv("SENTRY_ENVIRONMENT");
    private static final String SENTRY_SERVER_RELEASE =  "1.0.0";
    private static final String SENTRY_SERVER_NAME =  "midnight-technician";

    public static void initialize() {
        Sentry.init(options -> {
            // Set the DSN explicitly
            options.setDsn(SENTRY_HOST);
            // Environment-specific configuration
            options.setEnvironment(ENVIRONMENT_PROD);
            options.setRelease(SENTRY_SERVER_RELEASE);
            options.setServerName(SENTRY_SERVER_NAME);

            // Performance and sampling
            if (ENVIRONMENT_PROD.equals(SENTRY_ENVIRONMENT)) {
                options.setTracesSampleRate(0.1); // Sample 10% in production
                options.setProfilesSampleRate(0.1);
            }
            else {
                options.setTracesSampleRate(1.0); // Sample all in dev/test
                options.setProfilesSampleRate(1.0);
            }

            // Error filtering
            options.setBeforeSend((event, _) -> {
                // Filter out non-critical errors in production
                if (ENVIRONMENT_PROD.equals(SENTRY_ENVIRONMENT))
                    return filterProductionErrors(event);
                return event;
            });

            // Breadcrumb filtering
            options.setBeforeBreadcrumb((breadcrumb, _) -> {
                // Filter sensitive data from breadcrumbs
                return filterSensitiveBreadcrumbs(breadcrumb);
            });

            // Set in-app packages
            options.addInAppInclude("dev.glabay");

            // Additional settings
            options.setAttachStacktrace(true);
            options.setSendDefaultPii(false);
            options.setMaxBreadcrumbs(100);
        });
    }

    private static io.sentry.SentryEvent filterProductionErrors(io.sentry.SentryEvent event) {
        // Add logic to filter out non-critical errors in production
        // For example, skip certain exception types or messages
        return event;
    }

    private static io.sentry.Breadcrumb filterSensitiveBreadcrumbs(io.sentry.Breadcrumb breadcrumb) {
        // Remove or mask sensitive data from breadcrumbs
        String message = breadcrumb.getMessage();
        if (message != null) {
            // Example: mask potential passwords or sensitive data
            message = message.replaceAll("password=\\w+", "password=***");
            message = message.replaceAll("token=\\w+", "token=***");
            breadcrumb.setMessage(message);
        }
        return breadcrumb;
    }
}
