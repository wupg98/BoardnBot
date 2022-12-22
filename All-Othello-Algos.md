
This is helpull:

https://towardsdatascience.com/how-a-chess-playing-computer-thinks-about-its-next-move-8f028bd0e7b1

Whats important to understand is that the "eval" or "bewerten" or "utility" function has to be written to check out which is the best end-state
Min() and max() do the exact opposite:

https://thesharperdev.com/implementing-minimax-tree-search/ but they take turns
And every turn taken the minimizing and maximizing is preferred.
Its like a maze: You must look were the best possible outcome is and thats where both players want to navigate too
Only that in the end it will be some kind of compromise between them(not every player gets hin absolut minimum/absolut maximum).


https://github.com/wupg98/BoardnBot

https://gamedev.stackexchange.com/questions/45173/reversi-othello-early-game-evaluation-function

https://copyprogramming.com/howto/ideas-for-simple-and-useful-ai-for-othello-game-aka-reversi 
https://www-hlb.cs.umd.edu/sites/default/files/scholarly_papers/Engel.pdf

https://github.com/TaylorKemp/Reversi/blob/master/src/Reversi.java
https://github.com/TaylorKemp/Reversi/blob/master/src/Minimax.java
https://taylorkemp.github.io/jekyll/update/2018/08/24/welcome-to-jekyll.html
