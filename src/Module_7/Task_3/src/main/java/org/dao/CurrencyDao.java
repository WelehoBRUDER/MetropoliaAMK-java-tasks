package org.dao;

import org.entity.Currency;
import java.sql.*;
import org.datasource.MariaDBConnection;
import java.util.*;

public class CurrencyDao {

    public List<Currency> getAllCurrencies() {
        List<Currency> currencies = new ArrayList<Currency>();
        try {
            Connection conn = MariaDBConnection.getConnection();
            String sql = "SELECT abbreviation, name, conversion, symbol FROM currency";

            try {
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery(sql);

                while (rs.next()) {
                    String abbreviation = rs.getString(1);
                    String name = rs.getString(2);
                    double conversionRate = rs.getDouble(3);
                    String symbol = rs.getString(4);
                    Currency curr = new Currency(abbreviation, name, conversionRate, symbol);
                    currencies.add(curr);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
            return currencies;

    }
}