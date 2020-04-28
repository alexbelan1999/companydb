import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameOfFifteen extends JPanel {

    private int size;
    private int numberoftiles;
    private int dimension;
    private static final Color FOREGROUND_COLOR = new Color(218, 165, 32); 
    private static final Random RANDOM = new Random();
    private int[] tiles;
    private int tilesize;
    private int blankposition;
    private int margin;
    private int gridsize;
    private boolean gameover;

    public GameOfFifteen(int size, int dim, int mar) {
        this.size = size;
        dimension = dim;
        margin = mar;
        numberoftiles = size * size - 1;
        tiles = new int[size * size];
        gridsize = (dim - 2 * margin);
        tilesize = gridsize / size;

        setPreferredSize(new Dimension(dimension, dimension + margin));
        setBackground(Color.WHITE);
        setForeground(FOREGROUND_COLOR);
        setFont(new Font("TimesRoman", Font.BOLD, 50));
        gameover = true;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (gameover) {
                    newgame();
                } else {
                    int ex = e.getX() - margin;
                    int ey = e.getY() - margin;

                    if (ex < 0 || ex > gridsize || ey < 0 || ey > gridsize)
                        return;

                    int c1 = ex / tilesize;
                    int r1 = ey / tilesize;

                    int c2 = blankposition % size;
                    int r2 = blankposition / size;

                    int clickposition = r1 * size + c1;

                    int dir = 0;

                    if (c1 == c2 && Math.abs(r1 - r2) > 0)
                        dir = (r1 - r2) > 0 ? size : -size;
                    else if (r1 == r2 && Math.abs(c1 - c2) > 0)
                        dir = (c1 - c2) > 0 ? 1 : -1;

                    if (dir != 0) {
                        do {
                            int newblankposition = blankposition + dir;
                            tiles[blankposition] = tiles[newblankposition];
                            blankposition = newblankposition;
                        } while (blankposition != clickposition);

                        tiles[blankposition] = 0;
                    }

                    gameover = isSolved();
                }

                repaint();
            }
        });
        newgame();
    }

    private void newgame() {
        do {
            reset();
            shuffle();
        } while (!isSolvable());

        gameover = false;
    }

    private void reset() {
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = (i + 1) % tiles.length;
        }
        blankposition = tiles.length - 1;
    }

    private void shuffle() {
        int n = numberoftiles;

        while (n > 1) {
            int r = RANDOM.nextInt(n--);
            int tmp = tiles[r];
            tiles[r] = tiles[n];
            tiles[n] = tmp;
        }
    }

    private boolean isSolvable() {
        int countinversions = 0;

        for (int i = 0; i < numberoftiles; i++) {
            for (int j = 0; j < i; j++) {
                if (tiles[j] > tiles[i])
                    countinversions++;
            }
        }

        return countinversions % 2 == 0;
    }

    private boolean isSolved() {
        if (tiles[tiles.length - 1] != 0)
            return false;

        for (int i = numberoftiles - 1; i >= 0; i--) {
            if (tiles[i] != i + 1)
                return false;
        }
        return true;
    }

    private void drawGrid(Graphics2D g) {
        for (int i = 0; i < tiles.length; i++) {
            int r = i / size;
            int c = i % size;

            int x = margin + c * tilesize;
            int y = margin + r * tilesize;

            if (tiles[i] == 0) {
                if (gameover) {
                    g.setColor(FOREGROUND_COLOR);
                    g.setFont(getFont().deriveFont(Font.BOLD, 25));
                    drawCenteredString(g, "win", x, y);
                }
                continue;
            }
            g.setColor(getForeground());
            g.fillRect(x, y, tilesize, tilesize);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, tilesize, tilesize);
            g.setColor(Color.WHITE);
            drawCenteredString(g, String.valueOf(tiles[i]), x, y);
        }
    }

    private void drawStartMessage(Graphics2D g) {
        if (gameover) {
            g.setFont(getFont().deriveFont(Font.BOLD, 18));
            g.setColor(FOREGROUND_COLOR);
            String s = "Нажмите, чтобы начать новую игру";
            g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2, getHeight() - margin);
        }
    }

    private void drawCenteredString(Graphics2D g, String s, int x, int y) {
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s, x + (tilesize - fm.stringWidth(s)) / 2, y + (asc + (tilesize - (asc + desc)) / 2));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2D);
        drawStartMessage(g2D);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("GameOfFifteen");
            frame.setResizable(false);
            frame.add(new GameOfFifteen(4, 650, 25), BorderLayout.CENTER);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
