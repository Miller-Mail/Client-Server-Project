package Server;

public class ConfigPopulator
{
    public static void main(String[] args)
    {
        Config.initializeConfig();
        Config.setConfigFilePath("ServerConfiguration.conf");
        Config.assignDefaultValues();
        try
        {
            Config.setEmailUsername("Jstojkovic@callutheran.edu");
            Config.setEmailPassword("Tor1TheC@t3");
            Config.setDatabaseUsername("csc335");
            Config.setDatabasePassword("");
            Config.setUserDatabaseServerAddress("jdbc:mysql://localhost:3306/userdb");
            Config.setSystemDatabaseServerAddress("jdbc:mysql://localhost:3306/systemdb");
        }
        catch (ConfigNotInitializedException | InvalidAttributeValueException e)
        {
            e.printStackTrace();
        }
        Config.printConfig();
        Config.saveConfig();
    }
}
