package spase;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bullet {
	
	public double dir = -1;
	public double x,y,speed = 1.2;
	public int width, height;
	public int frames = 0;
	
	
	public Bullet() {
		this.x = Main.WIDTH;
		this.y = new Random().nextInt(Main.HEIGHT);
		width = 30;
		height = 2;


	}
	
	public void tick() {
		x += dir*speed;
		

		// pontua��o //
		if(this.x + width < 0) {
			Player.pontuacao += 10;
		}
			
		// REMOVER BULLETS //
		
		frames++;
		if(frames == 80) {
			Player.bullets.remove(this);
		}
		
		
		// ColiS�O //
		Rectangle bounds = new Rectangle((int)(x += dir*speed),(int)y, width,height);
		Rectangle boundsPlayer = new Rectangle((int)(Player.x),(int)(Player.y), Player.width,Player.height);
		
		if(bounds.intersects(boundsPlayer)) {
			Player.vida -= 5;
			Player.dano = true;
			Player.bullets.remove(this);
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, width, height);
	}
	
	public static void descancar() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
