package com.milesHC.Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dBHandler
{ 
    // init database constants
    private static final String DATABASE_DRIVER = "software.aws.rds.jdbc.mysql.Driver";//"com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql:aws://fourthfrontier-laravel-enc-production-cluster.cluster-ro-crvox5eg5qg3.us-west-2.rds.amazonaws.com:3306/FFlaravel";
    private static final String USERNAME = "FFlaravel";
    private static final String PASSWORD = "ruQ-@-Q7ukLndbXR";
    private static final String MAX_POOL = "250";

    // init connection object
    private Connection connection;
    // init properties object
    private Properties properties;

    // create properties
    private Properties getProperties() 
    {
        if (properties == null)
        {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
            properties.setProperty("MaxPooledStatements", MAX_POOL);
        }
        return properties;
    }

    // connect database
    public Connection connect()
    {
        if (connection == null) 
        {
            try
            {
                Class.forName(DATABASE_DRIVER);
                connection = DriverManager.getConnection(DATABASE_URL,getProperties());
            } catch (ClassNotFoundException | SQLException e)
            {
                e.printStackTrace();
            }
        }
        return connection;
    }

    // disconnect database
    public void disconnect() 
    {
        if (connection != null) 
        {
            try 
            {
                connection.close();
                connection = null;
            } catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
