package spase;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public static int vida = 50;
	public static boolean dano = false;
	public static int x, y, speed = 2;
	public boolean up, down, left, right;
	public static int width, height;
	public static int pontuacao = 0;
	public static int best; /*melhor pontua��o*/
	
	public int framed = 0;
	
	public int frames = 0;
	public int maxFrames = 10;
	public int curAnimation = 0;
	
	public static List<Bullet> bullets = new ArrayList<>();
	public boolean shoot = false;
	
	public int contador = 0;
	
	public Player(int x, int y) {
		vida = 50;
		this.x = x;
		this.y = y;
		
		width = 33;
		height = 13;
		if(pontuacao > best) { 
			best = pontuacao;
		}
		pontuacao = 0;
	}
	
	public void tick() {
		
		if(up) {
			y-=speed;
		} else if(down) {
			y+=speed;
		}
		if(left) {
			x-=speed;
		} else if(right) {
			x+=speed;
		}
		
		//if(shoot) {	
		contador++;
		if(contador == 15) {
			contador = 0;
			bullets.add(new Bullet());
				
		}
		

		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
		// LIMITES //
		if(y + height > Main.HEIGHT) {
			y = Main.HEIGHT - height;
		} else if(y <= 0) {
			y = 0;
		}
		if(x + width >= Main.WIDTH) {
			x = Main.WIDTH - width;
		} else if(x < 0) {
			x = 0;
		}
		
		// verifica vida //
		if(vida <= 0) {
			new Main();
			bullets.clear();
			return;
		}
		
		// ANIMA��O //
		frames++;
		if(frames >= maxFrames) {
			frames = 0;
			curAnimation++;
			if(curAnimation == SpriteSheet.player.length) {
				curAnimation = 0;
			}
		}
	}
	
	public void render(Graphics g) {
		if(!dano) {
			g.drawImage(SpriteSheet.player[curAnimation], x, y, width, height, null);
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
		if(dano) {
			g.drawImage(SpriteSheet.playerDano, x, y, width, height, null);
			framed++;
			if(framed == 20) {
				framed = 0;
				dano = false;
			}
		}
	}
	
}
