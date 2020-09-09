import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;//klavye tuşları yakalaması için
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;



import javax.sound.sampled.*; // Ses efektleri verebilmek için
import java.io.IOException;
import java.net.*;
import java.nio.charset.MalformedInputException;

import javax.swing.*;
@SuppressWarnings("serial")
public class joyunalani extends JFrame {
	
	
	public static int oyunalanigenislik=800;
	public static int oyunalaniyukseklik=800;
	public static boolean tus=false;
	public static int tuskodu;
	public static ArrayList<jmermi> mermiler =new ArrayList<jmermi>() ;
	
	String ilerlemesesi="file:./src/Frog.aiff";
	String atesetme="file:./src/Purr.aiff";
	
	
	
	
	public static void main(String[] args) {
		new joyunalani();
		
		
	}
	
	
	public joyunalani(){
			
			this.setSize(oyunalanigenislik,oyunalaniyukseklik);
			this.setTitle("Gulsah Yılmaz- Hale Sahin Oyun");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//key listener tuş takip
			
			addKeyListener(new KeyListener(){
				
			

				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
					
					if(e.getKeyCode()==87){
						
						efekt(ilerlemesesi);
						
						System.out.println("ileri");
						tuskodu=e.getKeyCode();
						tus=true;
						
						
					}else if (e.getKeyCode()==83){
						
						
						System.out.println("geri");
						
						
					}else if (e.getKeyCode()==68){
						
						
						System.out.println("sağa");
						tuskodu=e.getKeyCode();
						tus=true;
						
						
					}else if (e.getKeyCode()==65){
						
						
						System.out.println("sola");
						tuskodu=e.getKeyCode();
						tus=true;
						
					}
						else if (e.getKeyCode()==KeyEvent.VK_ENTER){
							efekt(atesetme);
							mermiler.add(new jmermi (oyuncizmepanel.gemi.getgemiburunx(),oyuncizmepanel.gemi.getgemiburuny(),
									oyuncizmepanel.gemi.getYonacisi()));
						
						
						}
				}

				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					
					tus=false;
						
					}
					
				
				
			});
			
			oyuncizmepanel oyunpanel = new oyuncizmepanel();
			
			this.add(oyunpanel,BorderLayout.CENTER);
			ScheduledThreadPoolExecutor calistir = new ScheduledThreadPoolExecutor (5);
			
			
			calistir.scheduleAtFixedRate(new ekranitemizle(this), 0L,20L,TimeUnit.MILLISECONDS);
			this.setVisible(true);
			
		}
	
	public static void efekt (String ses){
		
		URL seskonum;
		try{
			seskonum = new URL(ses);
			Clip klib = null;
			klib= AudioSystem.getClip();
			AudioInputStream inputstream;
			inputstream = AudioSystem.getAudioInputStream(seskonum);
			klib.open(inputstream);
			klib.loop(0);
			klib.start();
		}
		catch (MalformedInputException e1){
			e1.printStackTrace();
				
			
		}
		catch(UnsupportedAudioFileException e1 ) {
			e1.printStackTrace();
			
			
		}
		catch(LineUnavailableException e1){
			e1.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		}
}

		
		class ekranitemizle implements Runnable{
			joyunalani oyunalani;
			public ekranitemizle(joyunalani oyunalani){
				
				this.oyunalani = oyunalani;
				
			}
			public void run() {
				
				oyunalani.repaint();
			}
			
			
		}
		
		@SuppressWarnings("serial")
		class oyuncizmepanel extends JComponent{
			public static ArrayList<jgoktasi>goktaslari = new ArrayList<jgoktasi>(); 
			int[] cokgenax = jgoktasi.hbcokgenxa;
			int[] cokgenay = jgoktasi.hbcokgenya;
			
			static juzaygemisi gemi = new juzaygemisi(); 
			
int genislik =joyunalani.oyunalanigenislik;
int yukseklik =joyunalani.oyunalaniyukseklik;

public oyuncizmepanel() {
	for(int i=0;i<10;i++){
		
		int rastbasposx =(int)(Math.random() * (joyunalani.oyunalanigenislik -40)+1);
		int rastbasposy =(int)(Math.random() * (joyunalani.oyunalaniyukseklik -40)+1);

		
		goktaslari.add(new jgoktasi(jgoktasi.getcokxa(rastbasposx),jgoktasi.getcokya(rastbasposy),
				13, rastbasposx,rastbasposy ));
		
		jgoktasi.goktaslari= goktaslari;
		
		
	}
	
}
public void paint(Graphics g) {
	
	Graphics2D grafikayarlari = (Graphics2D) g;
	
	AffineTransform id= new AffineTransform();
	
	grafikayarlari.setColor(Color.BLACK);
	grafikayarlari.fillRect(0,0,getWidth(),getHeight());

	
	grafikayarlari.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	grafikayarlari.setPaint(Color.WHITE);
	
	
	for(jgoktasi tas: goktaslari){
		if(tas.ekranda){
			
		tas.hareketet(gemi , joyunalani.mermiler);
		grafikayarlari.draw(tas);
		
		}
			}
	if(joyunalani.tus==true && joyunalani.tuskodu==68){
		
		gemi.yonacisiarttir();
		System.out.println("gemi açısı" + gemi.getYonacisi());
		
	}else if(joyunalani.tus==true && joyunalani.tuskodu==65){
		
		gemi.yonacisiarttir();
		System.out.println("gemi açısı" + gemi.getYonacisi());
		
		
	}else if(joyunalani.tus==true && joyunalani.tuskodu==87){
		gemi.setHareketacisi(gemi.getYonacisi());{
			gemi.xhizarttir(gemi.gemixhareketacisi(gemi.getHareketacisi())* 10);
			gemi.yhizarttir(gemi.gemiyhareketacisi(gemi.getHareketacisi())*10);
		}
		
	} 
	
	
			gemi.hareketEt();
			grafikayarlari.setTransform(id);
			grafikayarlari.translate(gemi.getxortala(), gemi.getyortala());
			grafikayarlari.rotate(Math.toRadians(gemi.getYonacisi()));
			grafikayarlari.draw(gemi);
			
			for(jmermi mermim : joyunalani.mermiler){
				mermim.hareketet();
				if(mermim.ekranda){
					grafikayarlari.setTransform(id);
					grafikayarlari.translate(mermim.getxortala(), mermim.getyortala());
					grafikayarlari.draw(mermim);
				
				}
			}
			
		
		}
			
	}
	
	
	
