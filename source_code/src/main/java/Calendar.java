//going to use this file to work on calendar integration
//Info about calendar with pagan holidays:
/*
Calendar ID
0mg32m49ugjvmgjnu7b71jfh4o@group.calendar.google.com
https://calendar.google.com/calendar/embed?src=0mg32m49ugjvmgjnu7b71jfh4o%40group.calendar.google.com&ctz=America%2FNew_York
Use this URL to access this calendar from a web browser.
<iframe src="https://calendar.google.com/calendar/embed?src=0mg32m49ugjvmgjnu7b71jfh4o%40group.calendar.google.com&ctz=America%2FNew_York" style="border: 0" width="800" height="600" frameborder="0" scrolling="no"></iframe>
Use this code to embed this calendar in a web page.
*/
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.json.gson.GsonFactory;
import java.io.File;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import java.util.Arrays;
import com.google.api.services.calendar.Calendar;

GoogleCredential credentials = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
  .setJsonFactory(new GsonFactory())
  .setServiceAccountId("tuj54384-temple-edu@lunabot-777.iam.gserviceaccount.com")
  .setServiceAccountScopes(Arrays.asList("https://www.googleapis.com/auth/calendar.readonly"))
  .setServiceAccountPrivateKeyFromP12File(new File("106203152447187230835"))
.build();
Calendar pagan = new Calendar.Builder(GoogleNetHttpTransport.newTrustedTransport(), new GsonFactory(), credentials).build();
pagan.events().execute();

