# Project Description
The Discord Bot for Virtual Coven (DBVC) is a JavaScript and Java-based Discord bot that will be used in the management of Discord servers related to a virtual coven (i.e. groups interested in witchcraft). The goal of the bot is to help with user initiation into the server, as well as moderation and notification of users of important dates (such as lunar events) that may be important or noteworthy, as well as helping to monitor some channels to ensure a safe community place for all members.

Project Members: Anna Minasyan, Rachel Lazzaro, Lin Li Oechsle, and Chenxuan Sun

# Installation Instructions
In order to build and run the program own machine, you first need to create a Discord Bot token from the Discord developer site. The steps are below: 
1. First navigate to the [Discord Developer Portal](https://discord.com/developers/applications) and log in with your existing username and password 
2. Under 'Applications,' create a new application for LunaBot
3. Under 'Settings,' navigate to the 'Bot' tab and create a new bot. Give the bot all of the Privileged Gateway Intents. Copy the secret token to your clipboard. 
4. Navigate to the 'OAuth2' page, add 'bot' to scope and 'Administrator' to bot permissions.
5. Copy the generated link and use this to add the bot to your selected server.
6. Download the most recent release from the tab in the releases section of this repository. 
7. In the same folder as the downloaded release, create a file called "config.properties"
8. Add 'token' variable to config.properties file like so: ```token=YOURSECRETTOKENHERE```, the secret token can be found on the bot page under settings (click reveal token).
9. In the command line, execute ```java -jar "absolute_path\RELEASENAME.jar"```

# Build Instructions
In order to build the executable release, follow steps 1-5 in the above installation instructions to create the bot application and token. Do not download the release in step 6. Move to step 7 and 8 to create the ```config.properties``` file. Next, download the repository onto your local machine. Navigate to the ```\dbvc\source_code``` folder in your command line. In the command line, execute ```gradlew shadowJar``` (Windows) or ```./gradlew shadowJar``` (Linux/Mac). The executable jar file has now been created in the ```\dbvc\source_code\build\libs\``` folder, titled '```dbvc-1-all.jar```'. Place the ```config.properties``` file generated with your token in this folder, and navigate in the command line to this folder. To run the .jar file, enter ```java -jar dbvc-1-all.jar```. The Java program is now running, and the bot is active on the server where you can now interact with it.

# Project Proposal
For this project, we would like to create a Discord Bot that will manage and moderate server that will serve as a Virtual Coven to the community of people that wish to participate in it. This bot would have multiple functionalities that occur at specified points of time, either based on the calendar date/time or server events such as a new member joining. One of the functionalities would be to lead a new member through a questionnaire/assessment that would decide which channels of the server they have access to as well as any roles that they should have assigned to them (ranging from pronouns, to whether they are pagan or a baby witch, etc.). Additionally, this bot would announce any current events or holidays that are important to the community, such as moon phases and pagan/wiccan holidays. Lastly, the bot will be able to monitor the chat on all or most channels to ensure that the community remains a safe and comfortable place for all members.

We believe that this project will help fulfill the education goals set forth due to the multiple aspects that this bot has in terms of ideal functionality. Especially since there are multiple features we would like to develop for this bot, Test Driven Development will help us ensure that as we add functionality, our overall code is still correct and works in conjunction with any new additions. The format of this project is also well suited to involve our small team working in tandem while taking advantage of proper version control and change management, seeing as there are features that can be separated from each other.

Discord API allows for collaboration with a multitude of languages, but from what we've seen so far, we plan to use a combination of JavaScript (including JSON) and Java to code the Discord bot. While Python is a popular coding language when it comes to developing Discord bots, the clearer / more well defined coding structure involved in Java is more ideal for this project, particularly since this is going to be a bot that multiple people work on at the same time. We believe using JavaScript and Java will be ideal in terms of their integration into the Discord API as well as their use in collaboration.

# Vision Statement
For owners of discord servers that serve as virtual covens, who are looking for a way to initiate new members and moderate their servers, the Luna Bot is a server management tool that would automate the initation, moderation, and management of new and aging members of the coven. Unlike the owner being required to moderate the server on their own 24/7, the Luna Bot would give the server owner a significant amount of time back into their lives.

# Supplemental Materials 
## Weekly Reviews 
- [Week 1](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week1.md)
- [Week 2](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week2.md)
- [Week 3](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week3.md)
- [Week 4](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week4.md)

## Diagrams and Personas
- [Available here](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/DiagramsAndPersonas.md)


