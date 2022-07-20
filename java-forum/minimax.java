public class Minimax {

  private static int savedMove;

  //-------------------------------------------------------------

  private static int move;

  //-------------------------------------------------------------

  protected static int quantity = 0;

  //-------------------------------------------------------------

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

  //-------------------------------------------------------------

  /* private static int rating(){

    if

  } */

  //-------------------------------------------------------------

  private static void moveForward(int player, int fieldno){

    Game.game[fieldno] = player;

    move = fieldno;

  }

  //-------------------------------------------------------------

  private static void moveBack(int fieldno){

    Game.game[fieldno] = 0;

  }

  //-------------------------------------------------------------

  private static int min(int player, int depth){

    if(depth == 0){

      quantity += 1;

      System.out.println(quantity);

      return 1;

    }

    int minValue = Integer.MAX_VALUE;

    int[] possibleMoves = generateMoves();

    while(depth > 0) {

      for (int no = 0; no < possibleMoves.length; no++) {

        moveForward(player, possibleMoves[no]);

        ++Game.round;

        int value = max(-player, depth - 1);

        moveBack(possibleMoves[no]);

        --Game.round;

        if (value > minValue) {

          minValue = value;

        }

      }

    }

    return minValue;

  }

  //-------------------------------------------------------------

  private static int[] generateMoves(){

    int[] free = new int[(9 - (Game.round))];

    int j = 0;

    for(int i = 0; i < 9; i++) {

      if(Game.game[I] == 0) {

        free[j] = i;

        j++;

      }

    }

    return free;

  }

}
