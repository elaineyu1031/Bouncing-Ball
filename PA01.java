import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  When run as a program, this class opens a window on the screen that
 *  shows a large number of colored disks.  The positions of the disks
 *  are selected at random, and the color is randomly selected from
 *  red, green, or blue.  A black outline is drawn around each disk.
 *  The picture changes every three seconds.
 */
public class PA01 extends JPanel implements ActionListener {

    private int x=0;
    private int x1=5;
	private int y=0;
	private int y2=10;


	public void drawFrame(Graphics g, int frameNumber, int width, int height) {

      //draw the rectangle;
      g.setColor(new Color(frameNumber%255,0,0));
      g.fillRect(frameNumber%400,0,150,10);

      //draw the circle and change its position according to x and y;
      g.setColor(new Color(frameNumber%255,0,0));
      g.fillOval(x,y,22,22);

      //give a text string and change its size;
      Font tr = new Font("TimesRoman", Font.PLAIN, frameNumber%88);
      g.setFont(tr);
      g.drawString("Bouncing Ball",10,60);

    }

    //------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------


    public static void main(String[] args) {

        /* NOTE:  The string in the following statement goes in the title bar
         * of the window.
         */
        JFrame window = new JFrame("Random Disks");

        /*
         * NOTE: If you change the name of this class, you must change
         * the name of the class in the next line to match!
         */
        PA01 drawingArea = new PA01();

        drawingArea.setBackground(Color.WHITE);
        window.setContentPane(drawingArea);

        /* NOTE:  In the next line, the numbers 500 and 500 give the
         * initial width and height of the drawing array.  You can change
         * these numbers to get a different size.
         */
        drawingArea.setPreferredSize(new Dimension(500,500));

        window.pack();
        window.setLocation(100,50);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*
         * Note:  In the following line, you can change false to
         * true.  This will prevent the user from resizing the window,
         * so you can be sure that the size of the drawing area will
         * not change.  It can be easier to draw the frames if you know
         * the size.
         */
        window.setResizable(false);

        /* NOTE:  In the next line, the number 3000 gives the time between
         * calls to drawFrame().  The time is given in milliseconds, where
         * one second equals 1000 milliseconds.  You can change the number
         * to control the animation speed.
         */
        Timer frameTimer = new Timer(20,drawingArea);

        window.setVisible(true);
        frameTimer.start();

    } // end main

    private int frameNum;

    public void actionPerformed(ActionEvent evt) {
        frameNum++;
        x+=x1;
        y+=y2;
        if(y>=510){
        	y2=-10;
        }
        if(x>=500){
        	x1=-5;
        }
        if(y<=0){
        	x1=2;
        }
        if(y<=0){
        	y2=20;
        }
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawFrame(g, frameNum, getWidth(), getHeight());
    }

}
