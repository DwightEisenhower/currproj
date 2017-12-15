Find a path from (0,0) to (path.length-1, path[0].length-1). Print out the path taken or print out
an error if there is no path.

You are trapped in a dungeon and need to find your way out. You have 3 health. Each spot in the dungeon 
is identified as either 0, 1 or 2. If the spot is identified as 0 it is safe to travel to through. If
the spot is identified as 2 you may NEVER enter the space. If the spot is identified as 1 you may
enter the space but you will take damage and your health will lower by 1. You must find a path from
that successfully takes you from beginning to end without taking so much damage as to lower your health
to 0. This means that you may travel NORTH, SOUTH, EAST, or WEST from any spot.

Systematically check all possible paths using the algorithm we discussed in class. In the spot class,
in addition to storing the row, col and type of each spot, also track the highestHealth. This variable
identifies the highestHealth you have visited the spot with. Thus, when looking for valid moves
you should only consider spots that you can move to that you have never visited OR that you have visited
before but with lower health. (After all if you can get to a spot with higher health than you could
with a different path, the new path is better!)

Extensions:
1. In dungeons without a solution print out whether there is no solution because there is no 
path to the exit or because you can't get there with your limited health.

2. Print out the BEST possible solution to the dungeon. That is, the one that gets you to the end of the
dungeon with the most health remaining.