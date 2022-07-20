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
