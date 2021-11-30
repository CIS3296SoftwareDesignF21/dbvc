import java.awt.Color;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;

public class RoleAssignment extends ListenerAdapter {
    private long rolesChannelID;
    private long welcomeID;
    private HashMap<String, Long> roleIdPairs = new HashMap<>();
    private final static String FILE = "src/main/java/custom_roles.txt";
    private HashMap<String, Long> customRolesMap = new HashMap<String, Long>();

    public RoleAssignment() {
        createCustomRolesMap();
    }

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

    public void createCustomRolesMap() {
        // initialize custom roles map

        File file = new File(FILE);

        try {
            BufferedReader buff = new BufferedReader(new FileReader(file));
            String line;
            
            while ((line = buff.readLine()) != null) {
                String[] keyValuePairs = line.split(" ");
    
                // put(emojiInUnicodeFormat, roleIdInLongFormat)
                customRolesMap.put(keyValuePairs[0], Long.parseLong(keyValuePairs[1]));
            }
    
            buff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public String toUnicode (String emojiAsString) {
        String unicode = "RE:U+";
        Stream<String> stream = emojiAsString.codePoints().mapToObj(Integer::toHexString);

        //emojiAsString.codePoints().mapToObj(Integer::toHexString).forEach(System.out::println);

        List<String> list = stream.collect(Collectors.toList());
        //System.out.println("String before return: " + list.toString());

        return unicode+list.get(0).toString();
    }

    public long getRoleIdByEmoji(String emojiUnicode) {

        return customRolesMap.get(emojiUnicode);
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
            } else { // adding a custom role
                //reaction
                Role role = g.getRoleById(getRoleIdByEmoji(reaction));
                System.out.println("Adding custom role to user " + event.getUser().getName() + ": " + role);
                g.addRoleToMember(event.getUserId(), role).queue();

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
            } else { // removing a custom role
                Role role = g.getRoleById(getRoleIdByEmoji(reaction));
                //System.out.println("Removing custom role from user " + event.getUser().getName() + ": " + role.toString());
                if(role!=null)
                    g.removeRoleFromMember(event.getUserId(), role).queue();
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

    // custom roles reaction removal
    public void onMessageReactionRemove2 (MessageReactionRemoveEvent event) {
        Guild g = event.getGuild();
        System.out.println("Entered onmessagereactionremove2");

        String reaction = event.getReactionEmote().toString();
        Role role = g.getRoleById(getRoleIdByEmoji(reaction));
        System.out.println("Removing custom role from user " + event.getUser().getName() + ": " + role.toString());
        if(role!=null)
            g.removeRoleFromMember(event.getUserId(), role).queue();
    }

    public void writeNewRoletoFile (String emojiUnicode, long roleId) {
        File file = new File(FILE);
        BufferedWriter bf = null;
        
        try {
            bf = new BufferedWriter(new FileWriter(file, true));
            bf.append(emojiUnicode + " " + roleId);
            bf.newLine();
            /*
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                bf.write(entry.getKey() + " "
                        + entry.getValue());

                bf.newLine();
            }*/
            bf.flush();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // creates new role with basic permissions
    public void createRoleCommand(Guild g, String[] commandInput, Message messageObj) {
        String roleName = commandInput[1];
        String emojiUnicode = toUnicode(commandInput[2]);
        System.out.println("Emoji codepoints: " + emojiUnicode);
        
        try {
            // create the role
            if(g.getRolesByName(roleName, true).isEmpty() && !customRolesMap.containsKey(emojiUnicode)){
                g.createRole()
                        .setName(roleName)
                        .setColor(new Color(221, 238,221))
                        .setPermissions(0L)
                        .setHoisted(false)
                        .complete();

                System.out.println("Created role");

                // add role to customRolesMap
                customRolesMap.put(emojiUnicode, g.getRolesByName(roleName, false).get(0).getIdLong());

                // add role mapping to the file
                writeNewRoletoFile(emojiUnicode, g.getRolesByName(roleName, false).get(0).getIdLong());
                System.out.println("Emoji reaction to be added to " + roleName + ": " + emojiUnicode);

                // add role reaction information to roles channel
                String output = roleName + " - " + commandInput[2];
                g.getTextChannelsByName("roles", false).get(0).sendMessage(output).queue();
            } else {
                System.out.println("A role with this name or reaction emoji already exists and could not be created.");
            }
        } catch (Exception e) {
            System.out.println("Error: the role could not be created because the command did not use the correct format");
        }

    }

}
