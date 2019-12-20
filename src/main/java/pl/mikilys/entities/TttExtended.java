package pl.mikilys.entities;

//@Data
//@Entity
public class TttExtended {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @OneToMany
//    private List<TttMove> move;
//
//    public int currentPlayerMark;
//
//    @OneToMany
//    private List<TttGame> boardExt;
//
//    private int partialWinner;
//    private int winner;
//
//    public TttExtended() {
//
//        init();
//
//    }
//
//    public void init() {
//        boardExt = new ArrayList<>();
//        for (int i = 0 ; i<9 ; i++) {
//            boardExt.add(new TttGame());
//        }
//    }
//
//    public int[][] getGlobalBoard() {
//
//        int[][] global = new int[3][3];
//        for(int i = 0 ; i < 9 ; i ++) {
//            int row = i / 3;
//            int col = i % 3;
//            global[row][col] = boardExt.get(i).getCurrentSmallWinner();
//        }
//
//        return global;
//
//    }
//
//    public void playTheGame(TttMove ruszek) {
//
//        globalBoard = new int[3][3];
//        if (!TttUtilities.isBoardFull(globalBoard)) {
//            for (int i=0; i<3; i++) {
//                for (int j=0; j<3; j++) {
//                    globalBoard[i][j] = smallGamePlay(ruszek);
//                }
//            }
//        } else if (TttUtilities.isBoardFull(globalBoard)) {
//            winner = TttUtilities.checkForWin(globalBoard);
//        } else {
//            winner = TttUtilities.finalWinner(globalBoard);
//        }
//
//    }
//
//    public int smallGamePlay(TttMove ruszek) {
//
//        markTttMoveOnBoard(ruszek);
//
//        int row = ruszek.getRow();
//        int i = row / 3;
//        int col = ruszek.getCol();
//        int j = col / 3;
//
//        if (!TttUtilities.isBoardFull(boardExt[i][j].getBoard())) {
//            return partialWinner = TttUtilities.checkForWin(boardExt[i][j].getBoard());
//        } else {
//            return partialWinner = TttUtilities.finalWinner(boardExt[i][j].getBoard());
//        }
//
//    }
//
//    public void markTttMoveOnBoard(TttMove ruszek) {
//
//        int row = ruszek.getRow();
//        int i = row / 3;
//        int col = ruszek.getCol();
//        int j = col / 3;
//        int mark = ruszek.getMark();
//
//        this.boardExt[i][j].placeMark(row, col, mark);
//
//    }
//
//    public void changePlayer() {
//
//        if (currentPlayerMark == 1) {
//            currentPlayerMark = 0;
//        } else {
//            currentPlayerMark = 1;
//        }
//
//    }

}
