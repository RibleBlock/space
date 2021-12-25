package spase;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	public static BufferedImage imagem;
	/***/
	public static BufferedImage[] player = new BufferedImage[3];
	public static BufferedImage playerDano;
	
	public SpriteSheet() {
		try {
			imagem = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//////////////////////////////////////////////////////////////////////
		
		player[0] = getSprite(0, 0, 33, 13);
		player[1] = getSprite(34, 0, 33, 13);
		player[2] = getSprite(68, 0, 33, 13);
		playerDano = getSprite(102, 0, 33, 13);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return imagem.getSubimage(x, y, width, height);
	}
	
}
