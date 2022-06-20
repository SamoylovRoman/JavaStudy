package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleField extends JPanel {
    private GameWindow gameWindow;

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    int cellWidth;
    int cellHeight;


    public BattleField(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.ORANGE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

//                System.out.println(cellY + " " + cellX);

                if (!Logic.isFinishedGame) {
                    Logic.humanTurn(cellX, cellY);
                }
                repaint();
                if (Logic.isFinishedGame) {
                    //repaint();

                    JDialog dialog = new JDialog(gameWindow, true);
                    dialog.setTitle("Результат игры");
                    JLabel winText = new JLabel();

                    if (Logic.isAiWon) {
                        winText.setText("Победил компьютер!");
                    }
                    if (Logic.isHumWon) {
                        winText.setText("Вы победили!");
                    }
                    if (Logic.isNotWinner) {
                        winText.setText("Ничья!");
                    }
                    dialog.add(winText);

                    dialog.setBounds(gameWindow.getX() + gameWindow.getHeight() / 3,
                            gameWindow.getY() + gameWindow.getHeight() / 3, 200, 100);
                    dialog.setVisible(true);

                }
                //repaint();
            }
        });
    }

    public void startNewGame(int mode, int fieldSize, int winningLength) {
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!isInit) {
            return;
        }

        cellWidth = getWidth() / fieldSize;
        cellHeight = getHeight() / fieldSize;


        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        // вызов метода отрисовки победной линии
        if (Logic.isFinishedGame && !Logic.isNotWinner) {
            drawWinLine(g);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g, j, i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g, j, i);
                }
            }
        }


    }

    private void drawO(Graphics g, int cellX, int cellY) {
//        g.setFont(new Font("Arial", Font.BOLD, 30));
//        g.drawString("O", cellX * cellWidth + (cellWidth / 2), cellY * cellHeight + (cellHeight / 2));
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.CYAN);
        g.drawOval(cellX * cellWidth + cellWidth / 10, cellY * cellHeight + cellHeight / 10,
                cellWidth - cellWidth / 5, cellHeight - cellHeight / 5);
    }

    private void drawX(Graphics g, int cellX, int cellY) {
        ((Graphics2D) g).setStroke(new BasicStroke(5));
        g.setColor(Color.BLUE);
        g.drawLine(cellX * cellWidth + cellWidth / 10, cellY * cellHeight + cellHeight / 10,
                (cellX + 1) * cellWidth - cellWidth / 10, (cellY + 1) * cellHeight - cellHeight / 10);
        g.drawLine((cellX + 1) * cellWidth - cellWidth / 10, cellY * cellHeight + cellHeight / 10,
                cellX * cellWidth + cellWidth / 10, (cellY + 1) * cellHeight - cellHeight / 10);

    }

    // метод отрисовки победной линии
    private void drawWinLine(Graphics g) {
        //((Graphics2D) g).setStroke(new BasicStroke(10));
        g.setColor(Color.YELLOW);
        for (int i = 0; i < Logic.DOTS_TO_WIN; i++) {
            g.fillRect(Logic.winLineArray[i][0] * cellWidth+1, Logic.winLineArray[i][1] * cellHeight+1,
                    cellWidth-1, cellHeight-1);

        }
    }

}
