package org.datasource;

import jakarta.persistence.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBJPAConnection {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    private static Connection conn = null;

    public static EntityManager getInstance() {
        // you need to add synchronization if you run in a multithreaded environment

        if (em==null) {
            if (emf==null) {
                emf = Persistence.createEntityManagerFactory("CurrencyConverterMariaDBUnit");
            }
            em = emf.createEntityManager();
        }
        return em;
    }
}