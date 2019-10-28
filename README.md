Joshua Rosenthal
Assignment 4

For our fourth project, we were assigned to create a game that has multiple screens, with one being a leaderboard. I decided to 
create a math game, which would give you random equations (with addition, subtraction, multiplication, or division), and you will
answer these questions until you get 3 strikes. If you're score is large enough, it gets added to the leaderboard, which is big
enough for 6 players. I was inspired to make this game from one of the Jackbox minigames, which has a similar gameplay of answering
simple equations as fast as you can. If I had more time, I would likely have added a timer to my game to make it even more like
the minigame.

I used a default android studio start style that has 3 screens that I could work with, called Home, Dashboard, and Notifications.
I used these fragments to create my game, which is why they have those names in my code. Home simply welcomes the player to the
game, but Dashboard has been converted to the game screen and Notifications has been converted to the leaderboard. In the game
fragment, the player types in their name and hits the answer button. Randomly generated math problems will be given to the player,
and each correct answer adds to your score. Once 3 mistakes are made the game will end, and if the score is larger than the lowest
score on the leaderboard, it will be added to the leaderboard and placed in the correct spot, with everything shifted down.

Here is a documentation of my git commits:

10/14: Initial commit to create project
10/17: Modified dashboard and notification fragments to be game and leaderboard.
10/19: Added code to implement math game
10/20: Create the view for the game screen and code to change it
10/21: Added button to game screen to implement game
10/23: Created view for leaderboard
10/25: Added code to implement the leaderboard
10/26: Bug fixes and style changes to leaderboard
10/27: Update leaderboard on game end and other final touches
