package reversi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class BoardSquare extends JButton {

    // Instance variables to control the square's appearance
    private int borderSize;
    private int diskWidth;
    private int diskHeight;
    private int diskBorderSize;

    private Color drawColour;
    private Color borderColour;
    private Color diskColour;
    private Color diskBorder;

    /**
     * The constructor takes multiple parameters to allow customization of the
     * appearance of the square and disk.
     */
    public BoardSquare(int width, int height, Color colour, int borderWidth, Color borderCol, int circleWidth,
            int circleHeight, Color circleBorder, int circleBorderWidth, Color circleColour, IController controller,
            IModel model) {

        borderSize = borderWidth;
        diskWidth = circleWidth;
        diskHeight = circleHeight;
        diskBorderSize = circleBorderWidth;

        drawColour = colour;
        borderColour = borderCol;
        diskColour = circleColour;
        diskBorder = circleBorder;

        setMinimumSize(new Dimension(width, height));
        setPreferredSize(new Dimension(width, height));
    }

    // Call the other constructor with some default values for a green square with
    // a disk
    public BoardSquare(Color diskColour, Color diskBorder, IController controller, IModel model) {
        this(50, 50, Color.green, 1, Color.black, 36, 36, diskColour, 1, diskBorder, controller, model);
    }

    // Call the other constructor with some default values for an empty green square
    public BoardSquare(IController controller, IModel model) {
        this(50, 50, Color.green, 1, Color.black, 0, 0, null, 0, null, controller, model);
    }

    /**
     * Method to customize the rendering of a 'BoardSquare' object by painting a
     * rectangular background, an optional border, and an optional disk shape in the
     * center of the cell.
     */
    protected void paintComponent(Graphics g) {
        if (borderColour != null) {
            g.setColor(borderColour);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

        if (drawColour != null) {
            g.setColor(drawColour);
            g.fillRect(borderSize, borderSize, getWidth() - borderSize * 2, getHeight() - borderSize * 2);
        }

        if (diskBorder != null) {
            g.setColor(diskBorder);
            g.fillOval((getWidth() - diskWidth) / 2 - diskBorderSize, (getHeight() - diskHeight) / 2 - diskBorderSize,
                    diskWidth + 2 * diskBorderSize, diskHeight + 2 * diskBorderSize);
        }

        if (diskColour != null) {
            g.setColor(diskColour);
            g.fillOval((getWidth() - diskWidth) / 2, (getHeight() - diskHeight) / 2, diskWidth, diskHeight);
        }
    }
}
