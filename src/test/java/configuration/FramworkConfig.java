package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class FramworkConfig {
    private String filename = "framwork.properties";
    private static Properties properties;

    public FramworkConfig() {
        Path path = Paths.get("src/test/resources",filename);
        try{
            InputStream inputStream = new FileInputStream(path.toFile());
            properties=new Properties();
            properties.load(inputStream);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static String getProperties(String key)  {
        if(properties==null){
            new FramworkConfig();
        }

    return properties.getProperty(key);
    }

}
