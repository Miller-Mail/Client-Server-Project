package Server;

import Common.User;

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
     };

     public static void main(String[] args) throws ConfigNotInitializedException {
         ConfigPopulator.populate();
         UserDatabase usrDB = new UserDatabase(Config.getUserDatabaseServerAddress(),Config.getDatabaseUsername(),Config.getDatabasePassword());
         usrDB.printResultSet(usrDB.query("SELECT * FROM users;"));
     }

}
