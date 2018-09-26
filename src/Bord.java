import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bord extends JPanel {
	
	BufferedImage queen;
	
	Bord() {
		
		InputStream in = ClassLoader.getSystemResourceAsStream("queen-of-chess.png");
		try {
			queen = ImageIO.read(in);
		}
		catch (IOException e) {}
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D pen = (Graphics2D) g;
		
		for(int i=0 ; i<MainFrame.N ; i++)
			for(int j=0 ; j<MainFrame.N ; j++)
				if(MainFrame.value[i][j] == 0) {
					
					pen.setColor(Color.WHITE);
					pen.fillRect(i*100, j*100, 100, 100);
				}
				else if(MainFrame.value[i][j] == 1) {
					
					pen.setColor(Color.BLACK);
					pen.fillRect(i*100, j*100, 100, 100);
				}
		
		for(Dimension q : Queens.position)
			pen.drawImage(queen, null, q.height*100, q.width*100);
	}
}
