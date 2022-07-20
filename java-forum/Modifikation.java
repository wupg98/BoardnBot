//
protected static int max(int player, int depth){

    if(depth == 0){

      quantity += 1;

      System.out.println(quantity);

      return 1;

    }

    int maxValue = Integer.MIN_VALUE;

    int[] possibleMoves = generateMoves();

    while(depth > 0) {

      for (int no = 0; no < possibleMoves.length; no++) {

        moveForward(player, possibleMoves[no]);

        ++Game.round;

        int value = min(-player, depth - 1);

        moveBack(possibleMoves[no]);

        --Game.round;

        if (value > maxValue) {

          maxValue = value;

          if (depth == 1) {

            savedMove = move;

          }

        }

      }

    }

    return maxValue;

  }


private static int[] generateMoves(){

    int[] free = new int[(64 - (Game.round))];

    int j = 0; //1 in R

    for(int i = 0; i < 64; i++) {  //1 in R  <=64

      if(Game.game[i] == 0) { //Game.game[I] == "NULL" 

        free[j] = i;

        j++;

      }

    }
 //Methode muss wahrscheinlich umgeschrieben werden, da nur relevant ist WELCHE FELDER (aber kumulativ nicht bloß diesen Zug) FREI WÄREN...
    return free;

  }
//private static void moveBack(int fieldno){
    //0=Standardwert für Felder  (moveBack nur)
    // (Zweite Modifikation)
