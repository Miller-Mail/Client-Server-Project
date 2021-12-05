package Server;

import Common.User;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Locale;

//A class that provides all the interaction methods for the user database
class UserDatabase extends Database {

    //Default Constructor
    protected UserDatabase() {
    }

    //Overloaded constructor
    protected UserDatabase(String url, String username, String password) {
        super(url, username, password);
    }

    // method to get a user
    // throws a sql exception that will be dealt with by the server depending on
    // the exception
    protected User getUser(String username) throws SQLException {
        username = username.toLowerCase(Locale.ROOT);
        rset = this.query("SELECT * FROM users WHERE username = '" + username + "';");
//        this.printResultSet(rset);
        ResultSetMetaData rsmd = rset.getMetaData();
        User usr = new User();
        int numberOfColumns = rsmd.getColumnCount(); // get the number of columns in the result set
        String data;
        while (rset.next()) { // I don't know why this while loop has to be here but it does
            // -- loop through the columns of the ResultSet
            for (int i = 1; i <= numberOfColumns; ++i) {
//                System.out.print(rset.getString(i) + "\t\t");
                data = rset.getString(i);
                if(i == 1){
                    usr.setUsername(data);
//                    System.out.println(usr.getUsername());
                }
                else if (i == 2){
                    usr.setPassword(data);
//                    System.out.println(usr.getPassword());
                }
                else if (i == 3){
                    usr.setEmail(data);
//                    System.out.println(usr.getEmail());
                }
                else if(i == 4){
                    usr.setLockCount(Integer.parseInt(data));
//                    System.out.println(usr.getLockCount());
                }
                else{
                    usr.setLoggedIn(Integer.parseInt(data));
//                    System.out.println(usr.getLoggedIn());
                }

            }
            usr.print();
//            System.out.println(usr.getUsername());
//            System.out.println(rset.getString(numberOfColumns));
        }
        return usr;
    }

    //method to login a user
    protected void login(User usr) {
//        System.out.println(usr.getLoggedIn());
        usr.setLoggedIn(usr.getLoggedIn() + 1);
//        System.out.println(usr.getLoggedIn());
//        this.update("UPDATE users SET `loggedIn` = '" + usr.getLoggedIn() + "' WHERE (`username` = '" + usr.getUsername() +"');");
//        System.out.println(usr.getUsername());
        this.update("UPDATE `users` SET `loggedIn` = '" + usr.getLoggedIn() + "' WHERE (`username` = '"+ usr.getUsername() + "');");
    }

    //method to log out a user
    protected void logout(User usr) {
        int loggedIn = usr.getLoggedIn();
        if(loggedIn > 0) {
            usr.setLoggedIn(loggedIn - 1);
            this.update("UPDATE `userdb`.`users` SET `loggedIn` = '" + usr.getLoggedIn() + "' WHERE (`username` = '" + usr.getUsername() + "');");
        }
    }

    //method to return the number of locked out users
    protected int getNumberOfLockedOut() {
        return 0;
    }

    //method to reset a user's lock count
    protected void resetLockCount(User usr) {

    }

    public static void main(String[] args) throws ConfigNotInitializedException {
//        ConfigPopulator.populate();
        Config.initializeConfig("ServerConfiguration.conf");
        UserDatabase usrDB = new UserDatabase(Config.getUserDatabaseServerAddress(), Config.getDatabaseUsername(), Config.getDatabasePassword());
//        usrDB.printResultSet(usrDB.query("SELECT * FROM users;"));
        try {
            User user = usrDB.getUser("jstojkovic");
            usrDB.login(user);
            usrDB.getUser("jstojkovic");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}