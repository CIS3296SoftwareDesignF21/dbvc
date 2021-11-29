import java.util.HashMap;
import java.util.List;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

public class RoleAssignment extends ListenerAdapter {
    private long rolesChannelID;
    private long welcomeID;
    private HashMap<String, Long> roleIdPairs = new HashMap<>();
    //private JDA jda;

    //public RoleAssignment(JDA jda) {
    //    this.jda = jda;
    //}

    public HashMap<String, Long> createRolesMap(Guild g) {
        HashMap<String, Long> map = new HashMap<>();
        List<Role> roles = g.getRoles();

        for (Role role : roles) {
            map.put(role.getName(), role.getIdLong());
        }

        // for (HashMap.Entry<String, Long> entry : map.entrySet()) {
        //     System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        // }

        return map;
    }

    public long getRoleId(HashMap<String, Long> map, String roleName) {
        //System.out.println("ENTERED GETROLEID FUNCTION");

        for (HashMap.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getKey().equals(roleName)) {
                //System.out.println("GETTINGROLEIDPROPERLY: " + roleName + ": " + entry.getValue());
                return entry.getValue();
            }
        }
        return 0;
    }

    public long getRolesChannelId(Guild g) {
        return g.getTextChannelsByName("roles", false).get(0).getIdLong();
    }

    public long getWelcomeID(Guild g){
        return g.getTextChannelsByName("welcome", false).get(0).getIdLong();
    }

    // when a user reacts to a message in the roles channel, they are added to the associated role
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        Guild g = event.getGuild();
        roleIdPairs = createRolesMap(g);
        rolesChannelID = getRolesChannelId(g);
        welcomeID = getWelcomeID(g);
        String reaction = event.getReactionEmote().toString();

        if (event.getChannel().getIdLong() == rolesChannelID) {
            System.out.println("channel id: " + event.getTextChannel());
            System.out.println(event.getUser().getName() + " just reacted to a message");

            System.out.println("Adding role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Baby Witch"))).queue();
                System.out.println("Added user to baby witch role");
            } else if (reaction.equals("RE:U+1f337")) { // guest
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Guest"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+1f52e")) { // sage witch
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Sage Witch"))).queue();
            } else if (reaction.equals("RE:U+1f34e")) { // she/her
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "she/her"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+1f350")) { // he/him
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "he/him"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+1f34a")) { // they/them
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "they/them"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2648")) { // aries
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Aries"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2649")) { // taurus
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Taurus"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264a")) { // gemini
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Gemini"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264b")) { // cancer
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Cancer"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264c")) { // leo
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Leo"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264d")) { // virgo
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Virgo"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264e")) { // libra
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Libra"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264f")) { // scorpio
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Scorpio"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2650")) { // sagittarius
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Sagittarius"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2651")) { // capricorn
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Capricorn"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2652")) { // aquarius
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Aquarius"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2653")) { // pisces
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Pisces"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+270d")) { // pisces
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Pisces"))).queue();
                System.out.println("Added user to guest role");
            }
        } else if (event.getChannel().getIdLong() == welcomeID){
            // removing reaction means that they should no longer be allowed access to the server
            if(reaction.equals("RE:U+270dU+fe0f")){
                System.out.println("Removing role based on reaction: " + reaction);
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "unauth"))).queue();
                event.getMember().getUser().openPrivateChannel().flatMap(privateMessage ->
                        privateMessage.sendMessage("Thanks for agreeing to the server conditions - if you remove your acknowledgment " +
                                "reaction, you will no longer have access to the server.")).queue();
            }
        }
    }

    // if a user removes their reaction from a message in the roles channel, they will be removed from the associated role
    public void onMessageReactionRemove (MessageReactionRemoveEvent event) {
        Guild g = event.getGuild();
        roleIdPairs = createRolesMap(g);
        rolesChannelID = getRolesChannelId(g);
        welcomeID = getWelcomeID(g);
        String reaction = event.getReactionEmote().toString();

        if (event.getChannel().getIdLong() == rolesChannelID) {
            System.out.println("Removing role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Baby Witch"))).queue();
            } else if (reaction.equals("RE:U+1f337")) { // guest
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Guest"))).queue();
            } else if (reaction.equals("RE:U+1f52e")) { // sage witch
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Sage Witch"))).queue();
            } else if (reaction.equals("RE:U+1f34e")) { // she/her
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "she/her"))).queue();
            } else if (reaction.equals("RE:U+1f350")) { // he/him
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "he/him"))).queue();
            } else if (reaction.equals("RE:U+1f34a")) { // they/them
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "they/them"))).queue();
            } else if (reaction.equals("RE:U+2648")) { // aries
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Aries"))).queue();
            } else if (reaction.equals("RE:U+2649")) { // taurus
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Taurus"))).queue();
            } else if (reaction.equals("RE:U+264a")) { // gemini
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Gemini"))).queue();
            } else if (reaction.equals("RE:U+264b")) { // cancer
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Cancer"))).queue();
            } else if (reaction.equals("RE:U+264c")) { // leo
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Leo"))).queue();
            } else if (reaction.equals("RE:U+264d")) { // virgo
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Virgo"))).queue();
            } else if (reaction.equals("RE:U+264e")) { // libra
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Libra"))).queue();
            } else if (reaction.equals("RE:U+264f")) { // scorpio
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Scorpio"))).queue();
            } else if (reaction.equals("RE:U+2650")) { // sagittarius
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Sagittarius"))).queue();
            } else if (reaction.equals("RE:U+2651")) { // capricorn
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Capricorn"))).queue();
            } else if (reaction.equals("RE:U+2652")) { // aquarius
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Aquarius"))).queue();
            } else if (reaction.equals("RE:U+2653")) { // pisces
                g.removeRoleFromMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "Pisces"))).queue();
            }
        } else if (event.getChannel().getIdLong() == welcomeID){
            // removing reaction means that they should no longer be allowed access to the server
            if(reaction.equals("RE:U+270dU+fe0f")){
                System.out.println("Adding role based on reaction: " + reaction);
                g.addRoleToMember(event.getUserId(), g.getRoleById(getRoleId(roleIdPairs, "unauth"))).queue();
                event.getMember().getUser().openPrivateChannel().flatMap(privateMessage ->
                        privateMessage.sendMessage("You have removed acknowledgement to server rules, and are no longer authorized. "+
                                "Please react once more to gain access back to the server.")).queue();
            }
        }
    }
}
