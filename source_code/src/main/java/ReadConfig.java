import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    String token = "OTA0OTAyMTI1NzQwNTExMjYz.YYCRxw.8a0weGMDBmBlSYN3Yn922I5h3FU";
    // won't take string with file
    String file = "config.properties";
    FileInputStream inputStream = null; //new FileInputStream(file);
    Properties prop = new Properties();


    public String getToken() throws IOException {
        try{
             inputStream = new FileInputStream(file);
            //inputStream = getClass().getClassLoader().getResourceAsStream(file);
            prop.load(inputStream);
            token = prop.getProperty("token");
            //System.out.println("Token: " + token);
        } catch (Exception e){
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return token;
    }
}
