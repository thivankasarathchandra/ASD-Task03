import java.awt.List;

public class DominoUndoStrategy implements UndoStrategy {
    private final IOSpecialist io;
    private final Main mainController;
    private final List<Domino> _g;
    private final int[][] gg;
    private final PictureFrame pf;
    private final int score;

    public DominoUndoStrategy(
            IOSpecialist io,
            MainController mainController,
            List<Domino> _g,
            int[][] gg,
            PictureFrame pf,
            int score
    ) {
        this.io = io;
        this.mainController = mainController;
        this._g = _g;
        this.gg = gg;
        this.pf = pf;
        this.score = score;
    }

    @Override
    public void undoMove() {
        System.out.println("Enter a position that the domino occupies");
        System.out.println("Column?");

        int x13 = -9;
        while (x13 < 1 || x13 > 8) {
            try {
                String s3 = io.getString();
                x13 = Integer.parseInt(s3);
            } catch (Exception e) {
                x13 = -7;
            }
        }
        System.out.println("Row?");
        int y13 = -9;
        while (y13 < 1 || y13 > 7) {
            try {
                String s3 = io.getString();
                y13 = Integer.parseInt(s3);
            } catch (Exception e) {
                y13 = -7;
            }
        }
        x13--;
        y13--;
        Domino lkj = mainController.findGuessAt(x13, y13, _g);
        if (lkj == null) {
            System.out.println("Couldn't find a domino there");
        } else {
            lkj.placed = false;
            gg[lkj.hy][lkj.hx] = 9;
            gg[lkj.ly][lkj.lx] = 9;
            score -= 1000;
            mainController.collateGuessGrid(_g, gg);
            pf.dp.repaint();
        }
    }
}