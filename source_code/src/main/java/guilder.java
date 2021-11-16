import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class guilder  extends ListenerAdapter {
    String token = "OTA0OTAyMTI1NzQwNTExMjYz.YYCRxw.xJ7_UJOj1Rm-hPz0HzK3NfoOtM4";
    JDA jda = JDABuilder.createDefault(token).enableIntents(GatewayIntent.GUILD_PRESENCES).enableIntents(GatewayIntent.GUILD_MEMBERS).build();
    public guilder() throws LoginException {

    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        event.getGuild().retrieveMetaData().map(Guild.MetaData::getApproximatePresences)
                .map(count -> Activity.playing(count + " members online"))
                .queue(activity -> jda.getPresence().setActivity(activity));
    }
}
