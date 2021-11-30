//class to moderate language used on server

//mute members who violate guidelines

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.entities.Role;


import java.util.Objects;

public class muteMember extends ListenerAdapter {
    public void onGuildMessageReceivedEvent(GuildMessageReceivedEvent event){
        String args[] = event.getMessage().getContentRaw().split(" ");

        if(args[0].equalsIgnoreCase("!silence") && Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
            if(args.length <= 1) {
                errorMessage(event.getChannel(), event.getMember());
            } else {
                Member target = event.getMessage().getMentionedMembers().get(0);
                Role muted = event.getGuild().getRolesByName("Silenced", true).get(0);
                event.getGuild().addRoleToMember(target, muted);

                if(args.length >= 3) {
                    String reason = "";
                    for (int i = 2; i <args.length; i++) {
                        reason += args[i] + " ";
                    }
                    log(target, event.getMember(), reason, event.getGuild().getTextChannelsByName("naughty-list", true));
                }
                log(target, event.getMember(), "", event.getGuild().getTextChannelsByName("naughty-list", true));
            }
        }
    }

    public void log(Member muted, Member muter, String reason, List<TextChannel> textChannelsByName) {
        SimpleDateFormat year = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        EmbedBuilder build = new EmbedBuilder();
        build.setTitle("Mute Report");
        build.setColor(Color.decode("#0652DD"));
        build.addField("Muted User", muted.getAsMention(), false);
        build.addField("Muter", muter.getAsMention(), false);
        build.addField("Reason", reason, false);
        build.addField("Date", year.format(date), false);
        build.addField("Time", time.format(date), false);
    }

    public void errorMessage(TextChannel channel, Member member) {
        EmbedBuilder build = new EmbedBuilder();
        build.setTitle("Invalid Usage!");
        build.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        build.setDescription("() = Required, [] = Optional");
        build.addField("Proper usage: !silence (@user) [reason]", "", false);
        channel.sendMessageEmbeds(build.build(), new MessageEmbed[0]).complete().delete().queueAfter(20, TimeUnit.SECONDS);
    }
}






