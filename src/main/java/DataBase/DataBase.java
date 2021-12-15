package DataBase;

import Сonfiguration.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;

public class DataBase {
    Config configFile = new Config();

    public void insetrtIntoDB (List<CSVPriseList> contentCSV){
        Statement stmt = null;
        stmt = connectionDB(stmt);
        SymbolsActions symbolsActions = new SymbolsActions();
        for (CSVPriseList data:contentCSV) {
            String vendor = data.getBrand();
            String number = data.getCatalogNumber();
            String svendor = symbolsActions.searchLine(data.getBrand());
            String snumber = symbolsActions.searchLine(data.getCatalogNumber());
            String description = symbolsActions.lineReduction(data.getDescription());
            String price = symbolsActions.forDecimal(data.getPrice());
            String count = symbolsActions.deletingSymbols(data.getAvailability());
            System.out.println("Загружаем данные в БД");
            String sql = sqlQuery(vendor, number, svendor, snumber,description, price, count);
            System.out.println("Данные успешно загруженны в БД");
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private Statement connectionDB (Statement stmt) {
        //Получаем значения из config.properties в соответствии с указанным ключем
        String driver = configFile.getValue("jdbc.driver");
        String url = configFile.getValue("jdbc.url");
        String user = configFile.getValue("jdbc.user");
        String password = configFile.getValue("jdbc.password");
        Connection conn = null;

        try {
            Class.forName(driver);
            System.out.println("Подключение к БД...");
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Подключение прошло успешно.");
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
    private String sqlQuery(String vendorCSV, String numberCSV, String searchVendorCSV, String searchNumberCSV, String descriptionCSV, String priceCSV,  String countCSV){
        String vendor = configFile.getValue("db.column.vendor");
        String number = configFile.getValue("db.column.number");
        String searchVendor = configFile.getValue("db.column.searchVendor");
        String searchNumber = configFile.getValue("db.column.searchNumber");
        String description = configFile.getValue("db.column.description");
        String price = configFile.getValue("db.column.Price");
        String count = configFile.getValue("db.column.count");
        String query = "INSERT INTO PriceList.PriceItem ("+vendor+", " + number + ", "+ searchVendor+", "+searchNumber+", "+description+", "+price+", "+count+")"+
                "VALUES('"+vendorCSV+"', '" +
                numberCSV+"', '" +
                searchVendorCSV+"', '" +
                searchNumberCSV+"', '" +
                descriptionCSV+"', '" +
                Float.parseFloat(priceCSV)+"', " +
                Integer.parseInt(countCSV)+");";
        return query;
    }
}

