package goit.configFlyway;

import goit.App;
import org.flywaydb.core.Flyway;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class FlywayConfiguration {
    public void dbStart() throws IOException {
        // Create the Flyway instance and point it to the database
        Properties prop = new Properties();
        prop.load(new FileReader(App.class.getClassLoader().getResource("hibernate.properties").getPath()));
        Flyway flyway = Flyway
                .configure()
                .dataSource(
                        (String) prop.get(URL),
                        (String) prop.get(USER),
                        (String) prop.get(PASS))
                .baselineOnMigrate(true)
                .failOnMissingLocations(true)
                .locations("db/migration")
                .load();

        // Start the migration
        flyway.migrate();

    }


}
