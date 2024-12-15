# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.


I started this project mostly by editing and building on the code i had made for the Ghost class in assignment 8, and adding to other classes when it seemed relevant, then shifting to coding the gameplay loop and making sure the classes could interact appropriately with it. I had initially thought that figuring out how to use graphs seemed too complicated to be worth doing given the simple layout of my house, but apparently the way that I approached making the navigation is actually a simplified version of this. One of my biggest challenges in this was having issues with making methods that would work, because I kept getting errors about making static reference to non-static variables, and I didn't really understand well enough the difference between static and non-static or the syntax of java to know the best way to address this. I ended up making a bunch of static Hashtables to store information about the different classes, which seems like it is probably not the most efficient way to do this, but the only way that I could figure out that would make the code work. This is something that I would have liked to do differently if I had more time to figure out a more elegant and efficient way to do this. 
If I had more time, I think my first priority would be making the game respond more specifically to commands that don't work, giving the player more helpful information and making the interface of playing the game more interesting. The feedback I got the most from my friends playing this game was that it is not very intuitive, which I definitely agree with. I think I would have given myself the advice to think through the structure of the game more before starting coding so that there would be more logic behind everything. Despite this, I am still happy with this game and the work that I did, and I think the game can make sense if you know how to play.