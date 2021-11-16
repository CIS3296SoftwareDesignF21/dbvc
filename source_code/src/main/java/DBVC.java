import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class DBVC extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, IOException {
        //ReadConfig myConfig = new ReadConfig();
        //String token = myConfig.getToken();
        String token = "OTA0OTAyMTI1NzQwNTExMjYz.YYCRxw.xJ7_UJOj1Rm-hPz0HzK3NfoOtM4";

        JDA jda = JDABuilder.createDefault(token).build();
        JDA jda2 = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_MEMBERS).build();
        jda.addEventListener(new DBVC());
        jda.addEventListener(new RoleAssignment(jda));
        jda2.addEventListener(new GuildInit());
    }


    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Member member = event.getMember();
        Guild guild = member.getGuild();

        System.out.println("Received a message from " + event.getAuthor().getName() +
                ": " + event.getMessage().getContentDisplay());

        if (event.getMessage().getContentRaw().equals("!ping")) {
            event.getChannel().sendMessage("Hello world!").queue();
        }

        // PLEASE ADD AN IF STATEMENT TO RECOGNIZE YOUR USERNAME
        if (event.getAuthor().getName().equals("rae")) {
            event.getChannel().sendMessage("Hello Rachel!").queue();
        }

        if(event.getAuthor().getName().equals("dobey101")){
            event.getChannel().sendMessage("Hello Anya!").queue();
        }
        if(event.getAuthor().getName().equals("ears1723")){
            event.getChannel().sendMessage("Hello Lin Li!").queue();
        }
                if(event.getAuthor().getName().equals("Sssss")){
            event.getChannel().sendMessage("Hello Chenxuan!").queue();
        }

        if (event.getMessage().getContentRaw().equals("!online")) {
            guild.retrieveMetaData().map(Guild.MetaData::getApproximatePresences).map(count ->
                    Activity.playing("ONLINE PEOPLE  " + count)).queue(activity -> jda.getPresence().setActivity(activity));
        }
    }
}
