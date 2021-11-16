import java.util.HashMap;
import java.util.List;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

public class RoleAssignment extends ListenerAdapter {
    private long rolesChannelID;
    private HashMap<String, Long> roleIdPairs = new HashMap<>();
    private JDA jda;

    public RoleAssignment(JDA jda) {
        this.jda = jda;
    }

    public HashMap<String, Long> createRolesMap() {
        HashMap<String, Long> map = new HashMap<>();
        List<Role> roles = jda.getRoles();

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

    public long getRolesChannelId() {
        return jda.getTextChannelsByName("roles", false).get(0).getIdLong();
    }

    // when a user reacts to a message in the roles channel, they are added to the associated role
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        roleIdPairs = createRolesMap();
        rolesChannelID = getRolesChannelId();

        if (event.getChannel().getIdLong() == rolesChannelID) {
            System.out.println("channel id: " + event.getTextChannel());
            System.out.println(event.getUser().getName() + " just reacted to a message");
            String reaction = event.getReactionEmote().toString();

            System.out.println("Adding role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Baby Witch"))).queue();
                System.out.println("Added user to baby witch role");
            } else if (reaction.equals("RE:U+1f337")) { // guest
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Guest"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+1f34e")) { // she/her
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "she/her"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+1f350")) { // he/him
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "he/him"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+1f34a")) { // they/them
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "they/them"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2648")) { // aries
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Aries"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2649")) { // taurus
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Taurus"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264a")) { // gemini
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Gemini"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264b")) { // cancer
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Cancer"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264c")) { // leo
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Leo"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264d")) { // virgo
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Virgo"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264e")) { // libra
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Libra"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+264f")) { // scorpio
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Scorpio"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2650")) { // sagittarius
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Sagittarius"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2651")) { // capricorn
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Capricorn"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2652")) { // aquarius
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Aquarius"))).queue();
                System.out.println("Added user to guest role");
            } else if (reaction.equals("RE:U+2653")) { // pisces
                event.getGuild().addRoleToMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Pisces"))).queue();
                System.out.println("Added user to guest role");
            }
        }
    }

    // if a user removes their reaction from a message in the roles channel, they will be removed from the associated role
    public void onMessageReactionRemove (MessageReactionRemoveEvent event) {
        roleIdPairs = createRolesMap();
        rolesChannelID = getRolesChannelId();
        if (event.getChannel().getIdLong() == rolesChannelID) {
            String reaction = event.getReactionEmote().toString();
            System.out.println("Removing role based on reaction: " + reaction);
            if (reaction.equals("RE:U+1f98b")) { // baby witch
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Baby Witch"))).queue();
            } else if (reaction.equals("RE:U+1f337")) { // guest
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Guest"))).queue();
            } else if (reaction.equals("RE:U+1f34e")) { // she/her
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "she/her"))).queue();
            } else if (reaction.equals("RE:U+1f350")) { // he/him
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "he/him"))).queue();
            } else if (reaction.equals("RE:U+1f34a")) { // they/them
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "they/them"))).queue();
            } else if (reaction.equals("RE:U+2648")) { // aries
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Aries"))).queue();
            } else if (reaction.equals("RE:U+2649")) { // taurus
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Taurus"))).queue();
            } else if (reaction.equals("RE:U+264a")) { // gemini
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Gemini"))).queue();
            } else if (reaction.equals("RE:U+264b")) { // cancer
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Cancer"))).queue();
            } else if (reaction.equals("RE:U+264c")) { // leo
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Leo"))).queue();
            } else if (reaction.equals("RE:U+264d")) { // virgo
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Virgo"))).queue();
            } else if (reaction.equals("RE:U+264e")) { // libra
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Libra"))).queue();
            } else if (reaction.equals("RE:U+264f")) { // scorpio
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Scorpio"))).queue();
            } else if (reaction.equals("RE:U+2650")) { // sagittarius
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Sagittarius"))).queue();
            } else if (reaction.equals("RE:U+2651")) { // capricorn
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Capricorn"))).queue();
            } else if (reaction.equals("RE:U+2652")) { // aquarius
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Aquarius"))).queue();
            } else if (reaction.equals("RE:U+2653")) { // pisces
                event.getGuild().removeRoleFromMember(event.getUserId(), event.getJDA().getRoleById(getRoleId(roleIdPairs, "Pisces"))).queue();
            }
        }
    }
}
