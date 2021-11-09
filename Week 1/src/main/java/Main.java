import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
            //JDABuilder builder = new JDABuilder(NULL, AccountType.BOT);

            // REPLACE THIS STRING WITH THE TOKEN THAT WAS SENT IN DISCORD
            String token = "";
            JDA jda = JDABuilder.createDefault(token).build();
            jda.addEventListener(new Main());
            jda.addEventListener(new BotIn());


    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        System.out.println("Received a message from " + event.getAuthor().getName() +
                ": " + event.getMessage().getContentDisplay());

        if(event.getMessage().getContentRaw().equals("!ping")){
            event.getChannel().sendMessage("Hello world!").queue();
        }

        // PLEASE ADD AN IF STATEMENT TO RECOGNIZE YOUR USERNAME
        if(event.getAuthor().getName().equals("rae")){
            event.getChannel().sendMessage("Hello Rachel!").queue();
        }
    }
}
