import java.sql.*;

public class userDB {
    Connection connection; //Laver et object at connection.
    private String username = "root";
    //change password
    private String password = "Mevgamor970";
    String query3 = "INSERT INTO users (users)" + "VALUES(?)";

    //change table name, (jflix). "?" is still needed.
    String url = "jdbc:mysql://localhost:3306/ms?" + "autoReconnect=true&useSSL=false";



    public void connect(){ //Laver forbindelse til databaseserveren.
        try {
            this.connection = DriverManager.getConnection(url,username,password); //Driver manager finder server objectet connection skal connectes til.
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}