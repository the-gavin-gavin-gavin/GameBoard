public class GameBoard {

  // instance variables
  private String [][] gameBoard;
  private int row;
  private int col;

  /* GameBoard constructor - sets the dimension of the board.
  boardWidth defines the number of horizontal spaces.
  boardHeight defines the number of vertical spaces.
  boardWidth * boardHeight gives the number of spaces on your
  gameboard.  Constructor also fills all spaces of the board
  with "[ ]", sets row = 0 and col = 0, and finally places a
  player piece in position (0, 0) by setting that location
  to "[X]".
  */
  public GameBoard(int boardWidth, int boardHeight) {
    gameBoard = new String [boardHeight][boardWidth];
    for (int row = 0; row<gameBoard.length; row++)
    {
      for (int col = 0; col<gameBoard[0].length; col++)
      {
        gameBoard[row][col] = "[ ]";
      }
    }
    gameBoard[0][0] = "[X]";
    row = 0;
    col = 0;
  }

  // Prints the game board w/ current player piece location.
  public void printGameBoard() {
    for (int row = 0; row<gameBoard.length; row++)
    {
      for (int col = 0; col<gameBoard[0].length; col++)
      {
        System.out.print(gameBoard[row][col]);
      }
    System.out.println();
    }   
  }

  /* Checks if player can move.  Should be programmed so that
  player cannot move off of board.
  */
  private boolean checkIfCanMove(String moveCommand) {
    if (col<=0 && moveCommand.equals("L")){
      return false;
    }
    else if (row<=0 && moveCommand.equals("U")){
      return false;
    }
    else if (row>=gameBoard.length-1 && moveCommand.equals("D")){
      return false;
    }
    else if (col>=gameBoard[0].length-1 && moveCommand.equals("R")){
      return false;
    }
    else if (!moveCommand.equals("D") && !moveCommand.equals("U") && !moveCommand.equals("L") && !moveCommand.equals("R") && !moveCommand.equals("NM")) {
      return false;
    }
    else {
      return true;
    }
  }

  /* Moves player piece on board and makes a call to
  printGameBoard() method.  Needs to check if a viable
  move is supplied by making a call to checkIfCanMove()
  method.  If "NM" is supplied as an argument, no move
  should take place and game board should be printed out.
  If viable move is supplied, game piece is moved and 
  game board is printed out. If invalid input is supplied
  a message should br printed out to the user letting
  them know that they cannot make that move.
  */
  public void move(String moveCommand) {
  if (checkIfCanMove(moveCommand)==false){
    System.out.println("Your input is invalid. Please try again.");
  }
  else if (moveCommand.equals("NM")){
    printGameBoard();
  }
  else if (moveCommand.equals("R") && checkIfCanMove(moveCommand)==true){
      gameBoard[row][col] = "[ ]";
      col++;
      gameBoard[row][col] = "[X]";
      printGameBoard();
  }
  else if (moveCommand.equals("L") && checkIfCanMove(moveCommand)==true){
      gameBoard[row][col] = "[ ]";
      col--;
      gameBoard[row][col] = "[X]";
      printGameBoard();
  }
  else if (moveCommand.equals("U") && checkIfCanMove(moveCommand)==true){
      gameBoard[row][col] = "[ ]";
      row--;
      gameBoard[row][col] = "[X]";
      printGameBoard();
  }
  else if (moveCommand.equals("D") && checkIfCanMove(moveCommand)==true){
      gameBoard[row][col] = "[ ]";
      row++;
      gameBoard[row][col] = "[X]";
      printGameBoard();
  }
}
}