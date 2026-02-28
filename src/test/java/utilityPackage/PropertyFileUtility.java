package utilityPackage;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility
{
    public String getData(String key) throws Exception
    {

            FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFolder/ShoppersStackProperty.properties");

            Properties property =new Properties();

            property.load(fis);

            return property.getProperty(key);
    }
}
