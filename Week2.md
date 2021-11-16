## WEEK 2: Task Updates

List all accomplishments from the week for each team member. Remember that **every week**, each team member should have contributed to **at least one** task of consisting of writing code and **at least one** task of writing or reviewing texts or diagrams

### Anna
- I was out sick this week and was not able to actively contribute to the project
- I kept in contact with the team to help in smaller ways and provide advice about the scrum format
### Rachel
- Worked to create issues on Project Board and assign to team members
- Created ReadConfig class to read from config file with token to resolve token deactivation errors 
- Updated installation instructions on README.md with workflow for users to generate their own token
- Updated bot to public and created instructions for users to add bot to servers directly
- Created additional server administrator persona based on project feedback
- Created GuildInit class to recognize user joining server and set up private messaging interface with new user
- Updated UML Class Diagram with ReadConfig, GuildInit, ListenerAdaptor classes and EventListener interface
- Updated Week2.md
### Lin Li
- Created several of the issues in the GitHub Project board and assigned them to team members
- Created RoleAssignments class
- Created onMessageReactionAdd and onMessageReactionRemove, which listen for reactions added and removed
from the Roles text channel, and adds or removes the role associated with the specific emoji reaction
- Created UML Class Diagram for DBVC and added main class and RoleAssignment class
- Added first draft of UML class diagram to readme
- Updated Week2.md
### Chenxuan
- Created BotIn class
- Created onGuildMessageReceived, user can use command: "!join","!leave" to let bot in or out the channel.
- Make BotIn class drawio
- Updated Week2.md

## Looking Forward: Week 3
What are you working on until the next meeting? What is getting in your way or keeping you from doing your job?

### Anna
- I'm looking into connecting a calendar with the bot so that the bot can then read those events and announce them into the server
- I also am generating a more thorough outline regarding the initiation survey/process
- My blocker is that I am still not feeling well so that's certainly making it difficult to get work done but I am doing my best to contribute more this week especially since I was not able to help a lot this last week.
### Rachel
- I'm going to combine the role assignment with the guild initialization, and try to bot monitoring of user roles with a time interface (ie. let new users join, immediately assign them a role with limited access, and after a certain amount of time, give access to that new role)
### Lin Li
- I will probably have to find a more generalized approach to adding roles to users based on associated emojis. Currently
the emojis are mapped to role IDs that are specific to our test server. I want to look into adding a place for
server owners to add their own role IDs into a configuration file and then using environmental variables within the code itself.
### Chenxuan
