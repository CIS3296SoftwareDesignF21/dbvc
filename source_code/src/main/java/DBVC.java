import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.IOException;
import java.util.EnumSet;
import java.util.List;

public class DBVC extends ListenerAdapter {

    static RoleAssignment roleAssign = new RoleAssignment();

    String conditions;
    DBVC(String a){
        conditions = a;
    }

  public static void main(String[] args) throws LoginException, IOException {
        ReadConfig myConfig = new ReadConfig();
        String token = myConfig.getToken();
        String conditions = myConfig.getConditions();

        JDA jda = JDABuilder.createDefault(token).build();
        JDA jda2 = JDABuilder.createDefault(token, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES, GatewayIntent.GUILD_MEMBERS).build();

        jda.addEventListener(new DBVC(conditions));
        jda.addEventListener(roleAssign);
        //try without commandClientBuilder commandClientBuilder.build(),
        jda.addEventListener(new CurseWordFilter());
        jda2.addEventListener(new GuildInit());
        jda.addEventListener(new ClearCommand());
    }

    public void initialize(Guild g){
        // all permissions for server management
        if(g.getRolesByName("Admin", true).isEmpty()){
            g.createRole()
                    .setName("Admin")
                    .setColor(new Color(153, 0,0))
                    .setPermissions(Permission.ADMINISTRATOR)
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
        g.getRolesByName("@everyone", true).get(0).getManager()
                .setPermissions(0L)
                .complete();

        long newID = g.getRolesByName("New Member", true).get(0).getIdLong();
        long unauthID = g.getRolesByName("unauth", true).get(0).getIdLong();
        long sageID = g.getRolesByName("Sage Witch", true).get(0).getIdLong();
        long babyID = g.getRolesByName("Baby Witch", true).get(0).getIdLong();
        long guestID = g.getRolesByName("Guest", true).get(0).getIdLong();
        long everyoneID = g.getRolesByName("@everyone", true).get(0).getIdLong();
        EnumSet<Permission> allow, deny;

        // Create categories for text channels
        if(g.getCategoriesByName("general text channels",true).isEmpty()){
            deny = EnumSet.of(Permission.MESSAGE_WRITE);
            EnumSet<Permission> denyAuth = EnumSet.of(Permission.VIEW_CHANNEL);
            allow = EnumSet.of(Permission.MESSAGE_READ, Permission.MESSAGE_HISTORY, Permission.MESSAGE_ADD_REACTION);
            g.createCategory("general text channels").complete();

            g.createTextChannel("welcome", g.getCategoriesByName("general text channels", true).get(0))
                    .addRolePermissionOverride(newID, allow, null)
                    .addRolePermissionOverride(unauthID, allow, null)
                    .addRolePermissionOverride(guestID, allow, null)
                    .addRolePermissionOverride(babyID, null, deny)
                    .addRolePermissionOverride(sageID, null, deny)
                    .complete();

            g.createTextChannel("roles", g.getCategoriesByName("general text channels", true).get(0))
                    .addRolePermissionOverride(sageID, null, deny)
                    .addRolePermissionOverride(babyID, null, deny)
                    .addRolePermissionOverride(guestID, allow, null)
                    .addRolePermissionOverride(newID, null, denyAuth)
                    //.addRolePermissionOverride(everyoneID, allow, null)
                    .complete();
            g.createTextChannel("general-chat", g.getCategoriesByName("general text channels", true).get(0))
                    .complete();
            g.createTextChannel("bot-commands", g.getCategoriesByName("general text channels", true).get(0))
                    .complete();

            String welcomeMsg = "Welcome to the server! Before you get access, you need to agree to the terms and conditions of this server."+
                    " Please react with the \u270D emoji to acknowledge the server terms and conditions. After you acknowledge terms and " +
                    "conditions and have been a member of the server for at least 10 minutes, you will gain access to the rest of the server! " +
                    "If you remove your authorization reaction from this message, you will no longer have access to the server contents.";
            g.getTextChannelsByName("welcome", true).get(0).sendMessage(welcomeMsg).queue();
            g.getTextChannelsByName("welcome", true).get(0).sendMessage(conditions).queue();

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
        }

        if(g.getCategoriesByName("guest channels", true).isEmpty()){
            allow = EnumSet.of(Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_WRITE, Permission.MESSAGE_READ, Permission.MESSAGE_HISTORY);
            g.createCategory("guest channels")
                    .addRolePermissionOverride(guestID, allow, null).complete();
            g.createTextChannel("general", g.getCategoriesByName("guest channels", true).get(0))
                    .complete();
            g.createTextChannel("questions", g.getCategoriesByName("guest channels", true).get(0))
                    .complete();
        }

        if(g.getCategoriesByName("baby witch channels", true).isEmpty()){
            deny = EnumSet.of(Permission.VIEW_CHANNEL);
            g.createCategory("baby witch channels")
                    .addRolePermissionOverride(guestID, null, deny)
                    .complete();
            g.createTextChannel("general", g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
            g.createTextChannel("questions", g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
            g.createTextChannel("all-about-paganism", g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
            g.createVoiceChannel("voice chat", g.getCategoriesByName("baby witch channels", true).get(0))
                    .complete();
        }

        if(g.getCategoriesByName("sage witch channels", true).isEmpty()){
            deny = EnumSet.of(Permission.VIEW_CHANNEL);
            g.createCategory("sage witch channels")
                    .addRolePermissionOverride(babyID, null, deny)
                    .addRolePermissionOverride(guestID, null, deny)
                    .complete();
            g.createTextChannel("general", g.getCategoriesByName("sage witch channels", true).get(0))
                    .complete();
            g.createTextChannel("questions", g.getCategoriesByName("sage witch channels", true).get(0))
                    .complete();
            g.createVoiceChannel("voice chat", g.getCategoriesByName("sage witch channels", true).get(0))
                    .complete();
        }

        if(g.getCategoriesByName("admin channels", true).isEmpty()){
            deny = EnumSet.of(Permission.VIEW_CHANNEL);
            g.createCategory("admin channels")
                    .addRolePermissionOverride(babyID, null, deny)
                    .addRolePermissionOverride(sageID, null, deny)
                    .addRolePermissionOverride(guestID, null, deny)
                    .complete();
            g.createTextChannel("general", g.getCategoriesByName("admin channels", true).get(0))
                    .complete();
            g.createTextChannel("role-log", g.getCategoriesByName("admin channels", true).get(0))
                    .complete();
            g.createTextChannel("naughty-list", g.getCategoriesByName("admin channels", true).get(0))
                    .complete();
            g.createTextChannel("message-clear-report", g.getCategoriesByName("admin channels", true).get(0))
                    .complete();
            g.createVoiceChannel("voice chat", g.getCategoriesByName("admin channels", true).get(0))
                    .complete();
        }


        /**
        allow = EnumSet.of(Permission.MESSAGE_ADD_REACTION, Permission.MESSAGE_READ, Permission.MESSAGE_HISTORY);
        if(g.getTextChannelsByName("welcome", true).isEmpty()){
            g.createTextChannel("welcome")
                    .setName("welcome")
                    .setParent(g.getCategoriesByName("general text channels", true).get(0))
                    .addRolePermissionOverride(newID, allow, null)
                    .addRolePermissionOverride(unauthID, allow, null)
                    .complete();
        }

        /**
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
         **/
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event){
        String message = event.getMessage().getContentRaw();
        Message messageObj = event.getMessage();
        String[] commandInput = message.split(" ");
        Guild guild = event.getGuild();

        if(event.getAuthor().isBot()){
            return;
        }
        System.out.println("Received a message from " + event.getAuthor().getName() +
                ": " + event.getMessage().getContentDisplay());

        String reason = "";
        Member member = null;
        Role role = null;
        int days = -1;

        if(event.getMember().isOwner()){
            if(message.equals("!start")){
                initialize(guild);
            }
        }

        if(event.getMember().hasPermission(Permission.ADMINISTRATOR)){
            if(event.getMessage().getMentionedMembers().size() != 0){
                member = event.getMessage().getMentionedMembers().get(0);
            }

            if(event.getMessage().getMentionedRoles().size() != 0){
                role = event.getMessage().getMentionedRoles().get(0);
            }

            TextChannel roleLog = guild.getTextChannelsByName("role-log", true).get(0);
            TextChannel naughtyLog = guild.getTextChannelsByName("naughty-list", true).get(0);

            switch(commandInput[0]){
                case "!promote":
                    if(member == null || commandInput.length != 2){
                        roleLog.sendMessage("Usage error: !promote @USER").queue();
                    } else {
                        guild.addRoleToMember(member.getIdLong(), guild.getRolesByName("admin", true).get(0)).queue();
                        roleLog.sendMessage("Added " + member.getAsMention() + " to admin role.").queue();
                        System.out.println("Added user to admin role");
                    }
                    break;
                case "!demote":
                    if(member == null || commandInput.length != 2){
                        roleLog.sendMessage("Usage error: !demote @USER").queue();
                    } else {
                        guild.removeRoleFromMember(member.getIdLong(), guild.getRolesByName("admin", true).get(0)).queue();
                        roleLog.sendMessage("Removed " + member.getAsMention() + " from admin role.").queue();
                        System.out.println("Removed user to admin role");
                    }
                    break;
                case "!kick":
                    if(commandInput.length < 3 || member == null){
                        naughtyLog.sendMessage("Usage error: !kick @USER -REASON").queue();
                    } else {
                        for(int i = 2; i < commandInput.length; i++){
                            reason+=commandInput[i] + " ";
                        }

                        guild.kick(member, reason.toString()).queue();
                        String finalReason = reason.toString();
                        member.getUser().openPrivateChannel().flatMap(privateMessage ->
                                privateMessage.sendMessage("You have been kicked from the server for this reason: " + finalReason)).queue();
                        naughtyLog.sendMessage("Kicked " + member.getAsMention() + " for this reason " + reason).queue();
                        System.out.println("Kicked user: " + member.getAsMention());
                    }
                    break;
                case "!mute":
                    if(member == null || commandInput.length != 2){
                        naughtyLog.sendMessage("Usage error: !mute @USER").queue();
                    } else {
                        guild.mute(member, true).queue();
                        naughtyLog.sendMessage("Muted " + member.getAsMention()).queue();
                        member.getUser().openPrivateChannel().flatMap(privateMessage ->
                                privateMessage.sendMessage("You have been muted")).queue();
                    }
                    break;
                case "!unmute":
                    if(member == null || commandInput.length != 2){
                        naughtyLog.sendMessage("Usage error: !unmute @USER").queue();
                    } else {
                        guild.mute(member, false).queue();
                        naughtyLog.sendMessage("Unmuted " + member.getAsMention()).queue();
                        member.getUser().openPrivateChannel().flatMap(privateMessage ->
                                privateMessage.sendMessage("You have been unmuted")).queue();
                    }
                    break;
                case "!ban":
                    if(member == null || commandInput.length < 4){
                        naughtyLog.sendMessage("Usage error: !ban @USER -REASON -NUM_DAY(S)").queue();
                    } else {
                        try{
                            days = Integer.parseInt(commandInput[commandInput.length-1]);
                        } catch (Exception e){
                            naughtyLog.sendMessage("Usage error: !ban @USER -REASON -NUM_DAY(S)").queue();
                            break;
                        }


                        for(int i = 2; i < commandInput.length-1; i++){
                            reason+=commandInput[i] + " ";
                        }

                        guild.ban(member, days, reason).queue();
                        int finalDays = days;
                        String finalReason1 = reason;
                        member.getUser().openPrivateChannel().flatMap(privateMessage ->
                                privateMessage.sendMessage("You have been banned from the server for " + finalDays + " days " +
                                        "for this reason: " + finalReason1)).queue();
                        naughtyLog.sendMessage(event.getAuthor().getAsMention() + " banned " + member.getAsMention() +
                                " for " + days + " days for this reason: " + reason).queue();
                        System.out.println("Banned user: " + member.getAsMention());
                    }
                    break;
                case "!removeRole":
                    if(member == null || role == null || commandInput.length != 3){
                        roleLog.sendMessage("Usage error: !removeRole @ROLE @USER").queue();
                    } else {
                        guild.removeRoleFromMember(member.getIdLong(), role).queue();
                        roleLog.sendMessage("Removed " + member.getAsMention() + " from " + role.getAsMention()).queue();
                        System.out.println("Removed " + member.getAsMention() + " from " + role.getAsMention());
                    }
                    break;
                case "!addRole":
                    if(member == null || role == null || commandInput.length != 3){
                        naughtyLog.sendMessage("Usage error: !addRole @ROLE @USER").queue();
                    } else {
                        guild.addRoleToMember(member.getIdLong(), role).queue();
                        roleLog.sendMessage("Added " + member.getAsMention() + " to " + role.getAsMention()).queue();
                        System.out.println("Added " + member.getAsMention() + " to " + role.getAsMention());
                    }
                    break;
                case "!deleteChannels":
                    List<Category> allCategories = guild.getCategories();
                    for(Category c : allCategories){
                        c.delete().queue();
                    }
                    List<TextChannel> allTextChannels = guild.getTextChannels();
                    for(TextChannel t : allTextChannels){
                        if(!t.getName().equalsIgnoreCase("general-chat")){
                            t.delete().queue();
                        }
                    }
                    List<VoiceChannel> allVoiceChannels = guild.getVoiceChannels();
                    for(VoiceChannel v : allVoiceChannels){
                        v.delete().queue();
                    }
                    break;
                case "!deleteRoles":
                    List<Role> allRoles = guild.getRoles();
                    for(Role r : allRoles){
                        if(!r.getName().equalsIgnoreCase("DBVC") && !r.getName().equalsIgnoreCase("admin")){
                            r.delete().queue();
                        }
                    }
                case "!createRole":
                    System.out.println(event.getAuthor().getName() + " is trying to create a new role: " + event.getMessage().getContentDisplay());
                    roleAssign.createRoleCommand(guild, commandInput, messageObj);
                default:
                    break;
            }
        }

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
                TextChannel rolesChannel = guild.getTextChannelsByName("roles", true).get(0);

                event.getChannel().sendMessage("Here are all the commands available for you to try: ").queue();
                event.getChannel().sendMessage("!online - this will tell you the number of users currently online").queue();
                event.getChannel().sendMessage("!roles - list all available roles for server and your assigned roles").queue();
                event.getChannel().sendMessage("ADMIN ONLY COMMANDS\n"+
                        "!promote @USER - give administrator privileges\n!demote @USER - remove administrator privileges\n"+
                        "!kick @USER -REASON - remove user from server due to reason\n"+
                        "!ban @USER -REASON -NUMDAY(S) - ban user from server due to reason for numday(s)\n"+
                        "!unban @USER - remove user ban from server\n" +
                        "!mute @USER - mute user on voice channels\n!unmute @USER - unmute user on voice channels\n"+
                        "!addRole @ROLE @USER - manually add role to user\n!removeRole @ROLE @USER - manually remove role from user\n"+
                        "!deleteRoles - manually delete all roles from server\n"+
                        "!deleteChannels - manually delete all roles from server\n" +
                        "!createRole ROLE EMOJI - create a new role with an emoji attached to it\n" +
                        "!clear @CHANNEL NUM_MESSAGES REASON - clear specific channel by a certain number of messages for specified reason\n").queue();
                event.getChannel().sendMessage("SERVER OWNER ONLY COMMANDS\n"+
                        "!start - initialize empty server with preset roles, channels, and permissions").queue();
                event.getChannel().sendMessage("Looking for role assignments? Head to " + rolesChannel.getAsMention() + " to update roles.").queue();
                event.getChannel().sendMessage("Need manual permissions help or have concerns? DM an admin!").queue();
                break;
            case "!online":
                if (event.getMessage().getContentRaw().equals("!online")) {
                    guild.retrieveMetaData().map(Guild.MetaData::getApproximatePresences).map(count ->
                            Activity.playing("ONLINE PEOPLE  " + count)).queue(activity -> event.getJDA().getPresence().setActivity(activity));
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
            default:
                break;
        }

        // checking for !createrole command
        if (commandInput[0].equals("!createrole")) {
            System.out.println(event.getAuthor().getName() + " is trying to create a new role: " + event.getMessage().getContentDisplay());
            roleAssign.createRoleCommand(guild, commandInput, messageObj);
        }
    }
}
