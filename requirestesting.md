//still might need testing

//https://gamedev.net/forums/topic/706443-othello-heuristic-method/5424386
//Synonym für evaluate() =bewerten()
  int getHeuristic() {
        // give each square a certain value
        // corners are most valuable

        int[][] values = {
                {10, 2, 7, 7, 7, 7, 2, 10},
                {2, -4, 1, 1, 1, 1, -4, 2},
                {7, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 7},
                {7, 1, 1, 1, 1, 1, 1, 7},
                {2, -4, 1, 1, 1, 1, -4, 2},
                {10, 2, 7, 7, 7, 7, 2, 10}};

        int theHeuristic = 0;

        for (int y = 0; y < 8; y++)
            for (int x = 0; x < 8; x++) {
                if (boardColors[x][y] == 'b') theHeuristic += values[y][x];
                if (boardColors[x][y] == 'w') theHeuristic -= values[y][x];

            }

        return theHeuristic;
    }
