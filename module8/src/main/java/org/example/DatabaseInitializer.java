package org.example;



import org.flywaydb.core.Flyway;


public class DatabaseInitializer {

    public static void main(String[] args) {
        migrateDatabase();
    }

    public static void migrateDatabase() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:C:/Users/these/Desktop/db/workers", "sa", "")
                .locations("classpath:db/migration")
                .load();

        flyway.migrate();

        System.out.println("Базу даних успішно ініціалізовано та оновлено за допомогою Flyway.");
    }
}



