package game1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class View extends JComponent {
	private Game game;
	Image img =Constants.MILKYWAY1;
	AffineTransform bgTransf;

	public View(Game game) {
		this.game = game;
		double imWidth = img.getWidth(null);
		double imHeight = img.getHeight(null);
		double stretchx = (imWidth > Constants.FRAME_WIDTH ? 1:Constants.FRAME_WIDTH/imWidth);
		double stretchy = (imHeight > Constants.FRAME_HEIGHT ? 1:Constants.FRAME_HEIGHT/imHeight);
		bgTransf = new AffineTransform();
		bgTransf.scale(stretchx, stretchy);
	}
	@Override
	public void paintComponent(Graphics g0) {
		Graphics2D g = (Graphics2D) g0;
		// draw image in the background
		g.drawImage(img,bgTransf,null);
		g.setColor(Color.white);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
		g.drawString("Score: "+game.score,5,20);
		g.drawString("Level: "+game.level,Constants.FRAME_WIDTH/2,20);
		g.drawString("Lives: "+game.live,Constants.FRAME_WIDTH-100,20);


		synchronized (Game.class){
            for (GameObject object : game.objects) {
                object.draw(g);
            }
		}
	}
	@Override
	public Dimension getPreferredSize() {
		return Constants.FRAME_SIZE;
	}
}