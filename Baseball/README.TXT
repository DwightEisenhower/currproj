You work as a statistician for the New York Yankees. You have been given a file of statistics on the players
with the highest SLG (slugging) and you have been asked to generate information on who the team should
try to trade for from this list. 

Read in the file and output a NEW file with the following changes made. Nothing needs to be displayed to
the console, although you may do so as you work to assist you with the project.

1. Kansas City (KC) will not trade with us as we are in the same division. 
    Remove all of their players. We are the Yankees (NYY) and won’t be trading for our own players so they 
    may be removed as well.

2. We made a mistake calculating SLG and need to add .052 to each player’s SLG.

3. Players with under 200 at bats (AB) are not reliable. Remove all of them.

4. We are interested in power hitters, that is players who can get triples (3B) and home runs (HR). 
    Delete the 3B column and add it to the HR column. Rename the HR column PW for power.

5. Remove all players whose average (AVG) is below .275.

6. Update the RK number so that they count consecutively from 1 on up.

Challenge:
Sort the remaining players by AVG and output them to the file in that order.

NOTE: If you place a regular expression inside of a String, you will need to escape the \ character.
For example, "\n" inside of a String indicates a new line. If you want to create a string that literally
has the text "\n" in it, you will need to write "\\n". The "\\" escapes the "\" symbol and places one 
in its place.