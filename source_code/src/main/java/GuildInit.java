import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class GuildInit extends ListenerAdapter {
    String welcome = "Welcome to the server! I hope that you are ready to have some fun - before you begin your journey, " +
            "please know that you will have limited access to the server as a new member for the next 2 hours. After that, you " +
            "will have access to the server based on your background and history. Head over to the 'welcome' text channel to begin!";

    class removeNewRole extends TimerTask{
        // constructor
        GuildMemberJoinEvent event;
        Role newMember;
        Role guest;
        removeNewRole(GuildMemberJoinEvent e){
            this.event = e;
            this.newMember = e.getGuild().getRolesByName("New Member", true).get(0);
            this.guest = e.getGuild().getRolesByName("Guest", true).get(0);
        }

        public void run(){
            event.getGuild().addRoleToMember(event.getMember(), guest).queue();
            event.getGuild().removeRoleFromMember(event.getMember(), newMember).queue();

            if(event.getMember().getRoles().get(0) == null){
                // if they have no roles assigned currently, they have already been authorized.
                event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                        channel.sendMessage("Your new member restriction has been removed - have fun on the server :)")).queue();
            } else {
                event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                        channel.sendMessage("Your new member restriction has been removed, but you still haven't agreed to server rules. " +
                                "Please follow the instructions in the authorization channel to get access to the server!")).queue();
            }
        }
    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event){
        //JDA api = event.getJDA();
        Member member = event.getMember();
        Guild guild = event.getGuild();
        Timer timer = new Timer();
        // current delay is in seconds
        int delay = 60;
        timer.schedule(new removeNewRole(event), delay*1000);

        Role newMember = guild.getRolesByName("New Member", true).get(0);
        Role unauth = guild.getRolesByName("unauth", true).get(0);
        guild.addRoleToMember(member, newMember).queue();
        guild.addRoleToMember(member, unauth).queue();

        event.getMember().getUser().openPrivateChannel().flatMap(channel ->
                channel.sendMessage(welcome)).queue();
    }
}