import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfig {
    String token = "";
    InputStream inputStream = null;
    // won't take string with file
    String file = "config.properties";
    Properties prop = new Properties();

    public String getToken() throws IOException{
        try{
            inputStream = getClass().getClassLoader().getResourceAsStream(file);
            prop.load(inputStream);
            token = prop.getProperty("token");
           // System.out.println("Token: " + token);
        } catch (Exception e){
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return token;
    }
}
