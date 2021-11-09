import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class GuildInit extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        //JDA api = event.getJDA();
        String user = event.getMember().getAsMention();
        System.out.println("user just landed: " + user);

        List<TextChannel> channels = event.getGuild().getTextChannelsByName("general", true);

        for(TextChannel channel : channels){
            channel.sendMessage("New member joined: " + user).queue();
        }

        event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                channel.sendMessage("Welcome to the server, " + event.getMember().getAsMention())).queue();
    }
}