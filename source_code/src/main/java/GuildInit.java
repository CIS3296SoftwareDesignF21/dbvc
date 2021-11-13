import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class GuildInit extends ListenerAdapter {
    String welcome = "Welcome to the server! I hope that you are ready to have some fun - before you begin your journey," +
            "please know that you will have limited access to the server as a new member for the next 2 hours. After that, you " +
            "will have access to the server based on your background and history.";

    class removeNewRole extends TimerTask{
        // constructor
        GuildMemberJoinEvent event;
        Role role;
        removeNewRole(GuildMemberJoinEvent e){
            this.event = e;
            this.role = e.getGuild().getRolesByName("New Member", true).get(0);
        }

        public void run(){
            event.getGuild().removeRoleFromMember(event.getMember(), role).queue();
            event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                    channel.sendMessage("Removing restriction - have fun :)")).queue();
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        //JDA api = event.getJDA();

        if(event.getGuild().getRolesByName("New Member", true).isEmpty()){
            event.getGuild().createRole()
                    .setName("New Member")
                    .setColor(Color.PINK)
                    .setPermissions(0L)
                    .setHoisted(true)
                    .complete();
        }
        Timer timer = new Timer();
        // current delay is in seconds
        int delay = 60;
        timer.schedule(new removeNewRole(event), delay*1000);

        Role newMember = event.getGuild().getRolesByName("New Member", true).get(0);
       //System.out.println("role: " + newMember.getName());
        event.getGuild().addRoleToMember(event.getMember(), newMember).queue();

        String user = event.getMember().getAsMention();
        // ADD FUNCTIONALITY TO ADD USER TO NEW MEMBER ROLE

        List<TextChannel> channels = event.getGuild().getTextChannelsByName("general", true);
        for(TextChannel channel : channels){
            channel.sendMessage("Let's all welcome " + user + "!").queue();
        }

        List<Role> roles = event.getGuild().getRoles();
        event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                channel.sendMessage(welcome)).queue();
        for(Role role : roles){
            event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                    channel.sendMessage(role.getName())).queue();
        }
    }
}