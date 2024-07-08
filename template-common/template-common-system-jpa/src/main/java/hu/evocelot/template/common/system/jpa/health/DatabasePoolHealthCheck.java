package hu.evocelot.template.common.system.jpa.health;

import hu.icellmobilsoft.coffee.jpa.health.DatabasePoolHealth;
import hu.icellmobilsoft.coffee.se.logging.Logger;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

/**
 * Health check for database pool availability.
 *
 * @author mark.danisovszky
 * @since 0.1.0
 */
@ApplicationScoped
public class DatabasePoolHealthCheck {

    /**
     * persistence.xml dialect.
     */
    public static final String H2_DIALECT = "org.hibernate.dialect.H2Dialect";

    /**
     * key from persistence settings.
     */
    public static final String HIBERNATE_DIALECT = "HIBERNATE_DIALECT";

    @Inject
    private Logger logger;

    @Inject
    private DatabasePoolHealth databasePoolHealth;

    @Inject
    private Config config;

    private String builderName;

    /**
     * Init the health builderName by using the given database dialect.
     */
    @PostConstruct
    public void initHealthConfig() {
        String dialect = config.getValue(HIBERNATE_DIALECT, String.class);
        if (dialect.contains(H2_DIALECT)) {
            builderName = "h2";
        } else {
            builderName = "other";
        }
    }

    /**
     * Checking database pool usage.
     *
     * @return The created {@link HealthCheckResponse} contains information about whether the database connection pool usage is below the desired
     *         threshold.
     */
    public HealthCheckResponse checkDatabase() {
        try {
            return databasePoolHealth.checkDatabasePoolUsage(builderName);
        } catch (Throwable e) {
            // we catch every exception and error so that the probe doesn't encounter any unhandled errors or exceptions
            logger.error("Error occured while checking database pool resource.", e);
            return HealthCheckResponse.builder().name(builderName).up().build();
        }
    }

    /**
     * Adding to health/ready endpoint.
     *
     * @return - with the health values.
     */
    @Produces
    @Readiness
    public HealthCheck produceDatabaseStartup() {
        return this::checkDatabase;
    }
}
