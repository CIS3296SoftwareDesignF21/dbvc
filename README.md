# Project Description
The Discord Bot for Virtual Coven (DBVC) is a JavaScript and Java-based Discord bot that will be used in the management of Discord servers related to a virtual coven (i.e. groups interested in witchcraft). The goal of the bot is to help with user initiation into the server, as well as moderation and notification of users of important dates (such as lunar events) that may be important or noteworthy, as well as helping to monitor some channels to ensure a safe community place for all members.

# UML Diagram
![dbvc uml diagram](/DBVC.drawio.png)

# Installation Instructions
In order to build and run the program own machine, you first need to create a Discord Bot token from the Discord developer site. The steps are below: 
1. First navigate to the [Discord Developer Portal](https://discord.com/developers/applications) and log in with your existing username and password 
2. Under 'Applications,' create a new application for LunaBot
3. Under 'Settings,' navigate to the 'Bot' tab and create a new bot. Copy the secret token to your clipboard. 
4. Download the most recent release from the tab in the releases section of this repository. 
5. In the same folder as the downloaded release, create a file called "config.properties"
6. Add 'token' variable to config.properties file like so: ```token=YOURSECRETTOKENHERE```
7. In the command line, execute ```java -jar "absolute_path\RELEASENAME.jar"```

In order to simply add the bot to your server (rather than build and deploy it on your machine), use the link below and log in with your Discord credentials to authorize access to your server.
* https://discord.com/api/oauth2/authorize?client_id=904902125740511263&permissions=8&scope=bot

# Build Instructions
In order to build the executable release, follow steps 1-3 and 5 in the above installation instructions to create the bot token and config.properties file. Next, download the repository onto your local machine. In Intellij, open the repository Main.java file found in the src folder. Then, navigate to the "Gradle" tab on the far right. Under tasks, navigate to shadow, then shadowJar. Double click to create the executable .jar file. Retrieve the generated .jar file (found under ```absolute_path\dbvc\Week 1\build\libs\dbvc-1-all.jar"```) and place it in the same directory as the config.properties file that was generated. In the command line, execIn the CMD, execute ```java -jar "absolute_path\dbvc-1-all.jar"```. Upon execution, the Java program is now running and the LunaMod bot is active on the server where you can now interact with it.

# Project Proposal
For this project, we would like to create a Discord Bot that will manage and moderate server that will serve as a Virtual Coven to the community of people that wish to participate in it. This bot would have multiple functionalities that occur at specified points of time, either based on the calendar date/time or server events such as a new member joining. One of the functionalities would be to lead a new member through a questionnaire/assessment that would decide which channels of the server they have access to as well as any roles that they should have assigned to them (ranging from pronouns, to whether they are pagan or a baby witch, etc.). Additionally, this bot would announce any current events or holidays that are important to the community, such as moon phases and pagan/wiccan holidays. Lastly, the bot will be able to monitor the chat on all or most channels to ensure that the community remains a safe and comfortable place for all members.

We believe that this project will help fulfill the education goals set forth due to the multiple aspects that this bot has in terms of ideal functionality. Especially since there are multiple features we would like to develop for this bot, Test Driven Development will help us ensure that as we add functionality, our overall code is still correct and works in conjunction with any new additions. The format of this project is also well suited to involve our small team working in tandem while taking advantage of proper version control and change management, seeing as there are features that can be separated from each other.

Discord API allows for collaboration with a multitude of languages, but from what we've seen so far, we plan to use a combination of JavaScript (including JSON) and Java to code the Discord bot. While Python is a popular coding language when it comes to developing Discord bots, the clearer / more well defined coding structure involved in Java is more ideal for this project, particularly since this is going to be a bot that multiple people work on at the same time. We believe using JavaScript and Java will be ideal in terms of their integration into the Discord API as well as their use in collaboration.

# Vision Statement
For owners of discord servers that serve as virtual covens, who are looking for a way to initiate new members and moderate their servers, the Luna Bot is a server management tool that would automate the initation, moderation, and management of new and aging members of the coven. Unlike the owner being required to moderate the server on their own 24/7, the Luna Bot would give the server owner a significant amount of time back into their lives.

# Personas
- Persona 1: Server Owner
Server creator: Jack, 29 years old, is a college student who loves witchcraft, he was born in the city and dreamed of becoming a witch when he was a kid, so he studied witchcraft in college and created this discord server when he was 27 years old, with the initial intention of helping people who love witchcraft to be able to meet new people. New users can check any information about Wicca and then can discuss with others in the server that he likes to organize events, so they can organize any event they want by contacting him, provided that they pass his requirements, such as: whether the content of the event is legal, whether there is violence, etc.. And he has the highest rights in the whole server and can kick anyone or join any new rules.
- Persona 2: Baby Witch - New Member
Cameron, age 23, has spent the last 5 years after high school trying to figure out what he wants to do with the rest of his life. He has studied various trades and taken a few classes at trade schools but nothing really stuck to him. Once the COVID-19 Pandemic started, his oppurtunities became even more limited and so he decided to take some time off to relax and play video games. Through this, Cameron became an avid discord user and ended up hearing about a server that served as a virtual coven. Having never really looked into witch craft before, he starting searching on the internet to discover more and found himself significantly intrigued and wanting to learn more about how to become involved in witchcraft. Cameron decided he wanted to join this Discord Server that functioned as a virtual coven to become more involved in the community and discover more about the craft. With the Luna Bot, Cameron will be able to become integrated into the coven/server easily and will be encouraged to do more learning from listening and observing and without it being an overwhelming process by having a slightly more limited array of channels to explore and more restrictions regarding sending messages and participating in voice chats.
- Persona 3: Sage Witch - Regular Member
Alice, age 20, is a college student who is well practiced in witchcraft, including knowledge about tarot, crystals, and meditation.
She grew up in a smaller town in which more niche interests are often overlooked or not present within the community.
When she got to college, she was able to meet other witches and people with interest in witchcraft.
She loves to share her knowledge with others and is also interested in learning from more experienced witches. She is familiar
with Discord and knows how to send messages, add friends, and join servers. With Luna Bot, Alice is an official and regular member
of a virtual coven. She has been a member of the virtual coven for long enough that her status is Sage Witch, in which
she has the permission to send messages in any of the text channels and is able to join exclusive voice channels. She is free
to discuss witchcraft and rituals throughout the server.
- Persona 4: Observing User - New Member with limited access
Maria, age 34, is a current grad student studying philosophy. She comes from Boston, MA, but relocated to Indiana for graduate study. She recently has been interested in learning more about witchcraft but has not been able to find a welcoming community in her current location, and the COVID-19 pandemic has made traveling to meet with others more difficult. She is interested in finding some sort of community online that would be welcoming and easily accessible. Maria has never used Discord for instant messaging, video calls, or text messaging, and her main forms of online communication are simply emails. As a new member with limited access, Maria can familiarize herself with the community and the discord technology environment without the pressure to interact on the server.
- Persona 5: Server Administrator
Sally, age 40, is a single mother of 2 kids who has been interested in witchcraft and a pagan community for the majority of her lifetime. She has been active on a Discord server for an online community and recently got promoted to an administrative role due to her background, knowledge, and enthusiasm for the community. However, she has a busy schedule and responsibilities outside of this activity, and she does not have the time to constantly moderate the server while also handling her job and family. With the addition of Luna Bot to her server, role creation is automated and moderation is less taxing, and she is able to focus on fostering her community without the extra tax of time commitment. 

# Weekly Reviews
- [Week 1](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week1.md)
- [Week 2](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week2.md)
