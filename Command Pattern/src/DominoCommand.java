public class DominoCommand implements Command {
    private IOSpecialist io;
    private int[][] gg;
    private PictureFrame pf;
    private int score;
    private Main mainController;

    public DominoCommand(IOSpecialist io, int[][] gg, PictureFrame pf, int score) {
        this.io = io;
        this.gg = gg;
        this.pf = pf;
        this.score = score;
    }

    @Override
    public void execute() {
    	System.out.println(
                "Enter a position that the domino occupies"
              );
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
              Domino lkj = mainController.findGuessAt(x13, y13);
              if (lkj == null) {
                System.out.println("Couln't find a domino there");
              } else {
                lkj.placed = false;
                gg[lkj.hy][lkj.hx] = 9;
                gg[lkj.ly][lkj.lx] = 9;
                score -= 1000;
                mainController.collateGuessGrid();
                pf.dp.repaint();
              }
    }
}
