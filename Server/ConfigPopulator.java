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
            Config.setEmailUsername("");
            Config.setEmailPassword("");
            Config.setDatabaseUsername("");
            Config.setDatabasePassword("");
            Config.setUserDatabaseServerAddress("");
            Config.setSystemDatabaseServerAddress("");
        }
        catch (ConfigNotInitializedException | InvalidAttributeValueException e)
        {
            e.printStackTrace();
        }
        Config.printConfig();
        Config.saveConfig();
    }
}
