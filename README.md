# Project Description
The Discord Bot for Virtual Coven (DBVC) is a JavaScript and Java-based Discord bot that will be used in the management of Discord servers related to a virtual coven (i.e. groups interested in witchcraft). The goal of the bot is to help with user initiation into the server, as well as moderation and notification of users of important dates (such as lunar events) that may be important or noteworthy, as well as helping to monitor some channels to ensure a safe community place for all members.

# Installation Instructions
Clone the existing repository onto your local device. Due to the secret token used for authorization of the Discord bot, the executable Java program to run the bot must be rebuilt on a local machine with the real token in order to activate the bot. In the future, we hope to host the bot online so that this is not necessary in order to demonstrate its execution.

# Build Instructions
Download the repository onto your local machine. In Intellij, open the repository Main.java file found in the src folder. Update the String token with the unique token identifier posted in the DBVC Discord channgel. Then, navigate to the "Gradle" tab on the far right. Under tasks, navigate to shadow, then shadowJar. Double click to create the executable .jar file. In the CMD, execute ```java -jar "absolute_path\dbvc\Week 1\build\libs\dbvc-1-all.jar"``` where ```absolute_path``` is replaced by the path from your directory to the repository's folder. Upon execution, the Java program is now running and the LunaMod bot is active on the server where you can now interact with it.

# Project Proposal

# Vision Statement

# Personas
- Persona 1: Server Owner
Server creator: Jack, 29 years old, is a college student who loves witchcraft, he was born in the city and dreamed of becoming a witch when he was a kid, so he studied witchcraft in college and created this discord server when he was 27 years old, with the initial intention of helping people who love witchcraft to be able to meet new people. New users can check any information about Wicca and then can discuss with others in the server that he likes to organize events, so they can organize any event they want by contacting him, provided that they pass his requirements, such as: whether the content of the event is legal, whether there is violence, etc.. And he has the highest rights in the whole server and can kick anyone or join any new rules.
- Persona 2: Baby Witch - New Member
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
Maria, age 34, is a current grad student studying philosophy. She comes from Boston, MA, but relocated to Indiana for graduate study. She recently has been interested in learning more about witchcraft but has not been able to find a welcoming community in her current location, and the COVID-19 pandemic has made traveling to meet with others more difficult. She is interested in finding some sort of community online that would be welcoming and easily accessible. Maria has never used Discord for instant messaging, video calls, or text messaging, and her main forms of online communication are simply emails. If Maria used the Luna Bot, she would be able to easily connect with a community that would make her feel welcome in her new interests.

# Weekly Reviews
- [Week 1](https://github.com/CIS3296SoftwareDesignF21/dbvc/blob/readMeEdits/Week1.md)
