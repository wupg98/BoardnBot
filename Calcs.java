
//Here the calculations take place
	public void actionPerformed(ActionEvent e){
		JButton o=(JButton)e.getSource();
		ArrayList<Integer> possibleMoves=board.findPossibleMoves(-1);
		if(possibleMoves.size()>0){
			int i=0;
			for(i=0;i<64;i++){
				if(buttons[i]==o){
					try{
						board.move(-1,i/8,i%8);
					}
					catch(Exception exception){
						JOptionPane.showMessageDialog(null,exception.getMessage());
						return;
					}
					update(board);
					break;
				}
			}
		}
		boolean flag=true;
		while(flag){
			int count=0;
			possibleMoves=board.findPossibleMoves(1);
			if(possibleMoves.size()>0){
				System.out.println("Bot's move");
				int pos=Game.bot.think(board,possibleMoves);
				int x=pos/8;
				int y=pos%8;
				try{
					board.move(1,x,y);
				}
				catch(Exception exception){
					System.out.println(exception.getMessage());
				}
				update(board);
			}
			else
				count++;
			possibleMoves=board.findPossibleMoves(-1);
			if(possibleMoves.size()>0)
				flag=false;
			else
				count++;
			if(count==2){
				board.displayResult();
				board=new Board();
				update(board);
				return;
			}
		}
		System.out.println("Your move");
	}

	
