package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {


    String url;
    String userName;
    String password;

    PropertyFileReader propertyFileReader = new PropertyFileReader();
    Connection connection;
    PreparedStatement preparedStatement;

    ResultSet resultSet;

    public void connectToDatabase() {

        url = propertyFileReader.getValue("test.jdbc.url");
        userName = propertyFileReader.getValue("test.jdbc.username");
        password = propertyFileReader.getValue("test.jdbc.password");

        try {
            connection = DriverManager.getConnection(url, userName, password);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<String> getColumnData(String columnName, String query) throws SQLException {

        List<String> columnData = new ArrayList<String>();

        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String result = resultSet.getString(columnName);
            columnData.add(result);

        }
        return columnData;
    }

}
