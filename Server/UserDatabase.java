package Server;

import Common.User;

//A class that provides all the interaction methods for the user database
class UserDatabase extends Database{
    //Default Constructor
    protected UserDatabase(){};
    //Overloaded constructor
    protected UserDatabase(String url, String username, String password){
        super(url,username,password);
    }
    // method to get a user
    protected User getUser(String username){

        return new User();
    }
    //method to login a user
    protected void login(User usr){

    }
    //method to log out a user
    protected void logout(User usr){

    }
    //method to return the number of locked out users
    protected int getNumberOfLockedOut(){
        return 0;
    }
    //method to reset a user's lock count
    protected void resetLockCount(User usr){

    }

    public static void main(String[] args) throws ConfigNotInitializedException {
//        ConfigPopulator.populate();
        Config.initializeConfig("ServerConfiguration.conf");
        UserDatabase usrDB = new UserDatabase(Config.getUserDatabaseServerAddress(),Config.getDatabaseUsername(),Config.getDatabasePassword());
        usrDB.printResultSet(usrDB.query("SELECT * FROM users;"));
    }

}