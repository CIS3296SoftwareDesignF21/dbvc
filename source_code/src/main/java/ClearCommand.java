import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ClearCommand extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");

        if (args[0].equalsIgnoreCase("!clear")) {
            if(args.length<=2){
                ErrorMessage(event.getChannel(),event.getMember());
            }else{
                event.getMessage().delete().queue();
                TextChannel texttarget = event.getMessage().getMentionedChannels().get(0);
                DeleteMessage(texttarget, Integer.parseInt(args[2]));
                if(args.length>3) {
                    String reason ="";
                    for(int i = 3;i< args.length;i++){
                        reason+= args[i]+" ";
                    }
                    log(event.getMember(), args[2], reason,event.getGuild().getTextChannelById("914906046408056882"),texttarget);
                }else {
                    log(event.getMember(), args[2], "",event.getGuild().getTextChannelById("914906046408056882"),texttarget);
                }
            }

        }
    }


    public void ErrorMessage(TextChannel textchannel, Member member){
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Invalid Usage!");
        builder.setAuthor(member.getUser().getName(), member.getUser().getAvatarUrl(), member.getUser().getAvatarUrl());
        builder.setColor(Color.decode("#EA2027"));
        builder.setDescription("() = Required, [] = Optional");
        builder.addField("Proper usage: !clear + (#Channel) + (Number of line you want delete) + [Reason]" ,"",false);
        textchannel.sendMessage(builder.build()).complete().delete().queueAfter(20, TimeUnit.SECONDS);
    }
    public void log(Member clearer, String num, String reason, TextChannel incident, TextChannel cleared){
        SimpleDateFormat year = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        EmbedBuilder builder = new EmbedBuilder();
        builder.setTitle("Message clear Report");
        builder.setColor(Color.decode("#0652DD"));
        builder.addField("Cleared Channel", cleared.getAsMention(),false);
        builder.addField("Number of Messages cleared",num,false);
        builder.addField("Clearer", clearer.getAsMention(), false);
        builder.addField("Reason", reason,false);
        builder.addField("Date",year.format(date),false);
        builder.addField("Time", time.format(date),false);
        incident.sendMessage(builder.build()).queue();
    }
    private void DeleteMessage(TextChannel textchannel, int number){
        MessageHistory history = new MessageHistory(textchannel);
        List<Message> msgs;

        msgs = history.retrievePast(number).complete();
        textchannel.deleteMessages(msgs).queue();
    }
}
