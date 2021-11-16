import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

public class DBVC extends ListenerAdapter {

    public static void main(String[] args) throws LoginException, IOException {
        ReadConfig myConfig = new ReadConfig();
        String token = myConfig.getToken();

        JDA jda = JDABuilder.createDefault(token).build();
        JDA jda2 = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS).build();
        jda.addEventListener(new DBVC());
        jda.addEventListener(new RoleAssignment(jda));
        jda2.addEventListener(new GuildInit());
    }

    public void initialize(Guild g){
        // all permissions for server management
        if(g.getRolesByName("Admin", true).isEmpty()){
            g.createRole()
                    .setName("Admin")
                    .setColor(new Color(153, 0,0))
                    .setPermissions(8L)
                    .setHoisted(true)
                    .complete();
        }

        // initialize roles with permissions
        // read only on welcome channel
        if(g.getRolesByName("New Member", true).isEmpty()){
            g.createRole()
                    .setName("New Member")
                    .setColor(new Color(255, 178,102))
                    .setPermissions(Permission.MESSAGE_ADD_REACTION)
                    .setHoisted(true)
                    .complete();
        }

        // read only on welcome channel
        if(g.getRolesByName("unauth", true).isEmpty()){
            g.createRole()
                    .setName("unauth")
                    .setColor(new Color(255, 0,0))
                    .setPermissions(Permission.MESSAGE_ADD_REACTION)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Sage Witch", true).isEmpty()){
            g.createRole()
                    .setName("Sage Witch")
                    .setColor(new Color(0, 102,51))
                    .setPermissions(829167488705L)
                    .setHoisted(true)
                    .complete();
        }

        if(g.getRolesByName("Baby Witch", true).isEmpty()){
            g.createRole()
                    .setName("Baby Witch")
                    .setColor(new Color(255, 204,204))
                    .setPermissions(829167488705L)
                    .setHoisted(true)
                    .complete();
        }

        // Read only on all channels
        if(g.getRolesByName("Guest", true).isEmpty()){
            g.createRole()
                    .setName("Guest")
                    .setColor(new Color(229, 204,255))
                    .setPermissions(1088L)
                    .setHoisted(true)
                    .complete();
        }

        // initialize pronoun roles
        if(g.getRolesByName("she/her", true).isEmpty()){
            g.createRole()
                    .setName("she/her")
                    .setColor(Color.PINK)
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("he/him", true).isEmpty()){
            g.createRole()
                    .setName("he/him")
                    .setColor(Color.BLUE)
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("they/them", true).isEmpty()){
            g.createRole()
                    .setName("they/them")
                    .setColor(Color.GREEN)
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        // initialize astrology roles
        if(g.getRolesByName("Aries", true).isEmpty()){
            g.createRole()
                    .setName("Aries")
                    .setColor(Color.cyan)
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Taurus", true).isEmpty()){
            g.createRole()
                    .setName("Taurus")
                    .setColor(Color.magenta)
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }


        if(g.getRolesByName("Gemini", true).isEmpty()){
            g.createRole()
                    .setName("Gemini")
                    .setColor(new Color(0, 153,153))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Cancer", true).isEmpty()){
            g.createRole()
                    .setName("Cancer")
                    .setColor(new Color(255, 255,0))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Leo", true).isEmpty()){
            g.createRole()
                    .setName("Leo")
                    .setColor(new Color(51, 255,153))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Virgo", true).isEmpty()){
            g.createRole()
                    .setName("Virgo")
                    .setColor(new Color(255, 102,102))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Libra", true).isEmpty()){
            g.createRole()
                    .setName("Libra")
                    .setColor(new Color(0, 255,255))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Scorpio", true).isEmpty()){
            g.createRole()
                    .setName("Scorpio")
                    .setColor(new Color(102, 0,102))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Sagittarius", true).isEmpty()){
            g.createRole()
                    .setName("Sagittarius")
                    .setColor(new Color(153, 153,0))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Capricorn", true).isEmpty()){
            g.createRole()
                    .setName("Capricorn")
                    .setColor(new Color(0, 51,102))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Aquarius", true).isEmpty()){
            g.createRole()
                    .setName("Aquarius")
                    .setColor(new Color(102, 178,255))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        if(g.getRolesByName("Pisces", true).isEmpty()){
            g.createRole()
                    .setName("Pisces")
                    .setColor(new Color(204, 255,153))
                    .setPermissions(0L)
                    .setHoisted(false)
                    .complete();
        }

        // set the default permissions to such that no one can do anything
        g.getRolesByName("@everyone", true).get(0).getManager().setPermissions(0L).complete();

        // Create categories for text channels
        if(g.getCategoriesByName("general text channels",true).isEmpty()){
            g.createCategory("general text channels").complete();
        }

        long guestID = g.getRolesByName("Guest", true).get(0).getIdLong();
        EnumSet<Permission> allow = EnumSet.of(Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_WRITE);
        if(g.getCategoriesByName("guest channels", true).isEmpty()){
            g.createCategory("guest channels")
                    .addRolePermissionOverride(guestID, allow, null).complete();
            g.createTextChannel("questions")
                    .setName("questions")
                    .setParent(g.getCategoriesByName("guest channels", true).get(0))
                    .complete();
        }

        if(g.getCategoriesByName("baby witch channels", true).isEmpty()){
            g.createCategory("baby witch channels")
                    .complete();
            g.createTextChannel("questions")
                    .setName("questions")
                    .setParent(g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
            g.createTextChannel("all-about-paganism", g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
            g.createVoiceChannel("voice chat", g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
        }

        if(g.getCategoriesByName("sage witch channels", true).isEmpty()){
            g.createCategory("sage witch channels").complete();
            g.createTextChannel("questions")
                    .setName("questions")
                    .setParent(g.getCategoriesByName("sage witch channels", true).get(0))
                    .complete();
            g.createVoiceChannel("voice chat", g.getCategoriesByName("sage witch channels", true).get(0))
                    .complete();
        }

        long newID = g.getRolesByName("New Member", true).get(0).getIdLong();
        long unauthID = g.getRolesByName("unauth", true).get(0).getIdLong();
        allow = EnumSet.of(Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_READ, Permission.MESSAGE_HISTORY);
        if(g.getTextChannelsByName("welcome", true).isEmpty()){
            g.createTextChannel("welcome")
                    .setName("welcome")
                    .setParent(g.getCategoriesByName("general text channels", true).get(0))
                    .addRolePermissionOverride(newID, allow, null)
                    .addRolePermissionOverride(unauthID, allow, null)
                    .complete();
        }

        String welcomeMsg = "Welcome to the server! Before you get access, you need to agree to the terms and conditions of this server."+
                " Please react with the \u270D emoji to receive acknowledge the server terms and conditions. After you acknowledge terms and " +
                "conditions and have been a member of the server for at least 10 minutes, you will gain access to the rest of the server. ";
        g.getTextChannelsByName("welcome", true).get(0).sendMessage(welcomeMsg).queue();

        if(g.getTextChannelsByName("general", true).isEmpty()){
            g.createTextChannel("general")
                    .setName("general")
                    .setParent(g.getCategoriesByName("general text channels", true).get(0))
                    .complete();
        }

        if(g.getTextChannelsByName("roles", true).isEmpty()){
            g.createTextChannel("roles")
                    .setName("roles")
                    .setParent(g.getCategoriesByName("general text channels", true).get(0))
                    .complete();
        }
        String mainRoles = "Main Role:\n"+"Sage Witch - \uD83D\uDD2E \n" +"Baby Witch - \uD83E\uDD8B \n" + "Guest - \uD83C\uDF37 \n";
        String pronouns = "Pronouns:\n"+ "She/her - \uD83C\uDF4E \n" + "He/him - \uD83C\uDF50 \n" +
                "They/them - \uD83C\uDF4A";
        String astrology = "Astrological Sign:\n" +
                "Aries - \u2648 \n" +
                "Taurus - \u2649 \n" +
                "Gemini - \u264A \n" +
                "Cancer - \u264B \n" +
                "Leo - \u264C \n" +
                "Virgo - \u264D \n" +
                "Libra - \u264E \n" +
                "Scorpio - \u264F \n" +
                "Sagittarius - \u2650 \n" +
                "Capricorn - \u2651 \n" +
                "Aquarius - \u2652 \n" +
                "Pisces - \u2653";

        g.getTextChannelsByName("roles", true).get(0).sendMessage(mainRoles).queue();
        g.getTextChannelsByName("roles", true).get(0).sendMessage(pronouns).queue();
        g.getTextChannelsByName("roles", true).get(0).sendMessage(astrology).queue();

        if(g.getTextChannelsByName("bot-commands", true).isEmpty()){
            g.createTextChannel("bot-commands")
                    .setName("bot-commands")
                    .setParent(g.getCategoriesByName("general text channels", true).get(0))
                    .complete();
        }

    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        Guild guild = event.getGuild();
        System.out.println("Received a message from " + event.getAuthor().getName() +
                ": " + event.getMessage().getContentDisplay());

        switch (message) {
            case "!ping":
                event.getChannel().sendMessage("Hello world!").queue();

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

                break;
            case "!help":
                event.getChannel().sendMessage("Oh no, you seem to be lost! Here are some commands you can try: ").queue();
                event.getChannel().sendMessage("!online - this will tell you the number of users currently online.").queue();
                event.getChannel().sendMessage("Looking for role assignments? Head to the ROLES text channel or try the !roles command.").queue();
                event.getChannel().sendMessage("Need to update your permissions? DM " + event.getGuild().getOwner().getAsMention() +
                        " in order to update your permissions or use the ROLES text channel.").queue();
                break;
            case "!online":
                if (event.getMessage().getContentRaw().equals("!online")) {
                    guild.retrieveMetaData().map(Guild.MetaData::getApproximatePresences).map(count ->
                            Activity.playing("ONLINE PEOPLE  " + count)).queue(activity -> jda.getPresence().setActivity(activity));
                }
                break;
            case "!roles":
                String allRoles = "";
                List<Role> roles = event.getGuild().getRoles();
                for(Role r : roles){
                    if(roles.indexOf(r) != 0){
                        allRoles = String.format("%s, %s", allRoles, r.getName());
                    } else {
                        allRoles = r.getName();
                    }
                }
                event.getChannel().sendMessage("These are the roles available on this server: " + allRoles).queue();
                List<Role> userRoles = event.getMember().getRoles();
                if(userRoles.isEmpty()){
                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + " has not been assigned any roles.").queue();
                } else {
                    for(Role r : userRoles){
                        if(userRoles.indexOf(r) != 0){
                            allRoles = String.format("%s, %s", allRoles, r.getName());
                        } else
                            allRoles = r.getName();
                    }

                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + " has been assigned these roles: " + allRoles).queue();
                }
                break;
            case "!start":
                initialize(guild);
                break;
            default:
                break;
        }
    }
}
