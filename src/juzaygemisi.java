import java.awt.Polygon;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class juzaygemisi extends Polygon {
	
	private double xhiz = 0 , yhiz =0;
	int ogenislik=joyunalani.oyunalanigenislik;
	int oyukseklik=joyunalani.oyunalaniyukseklik;
	private double ortalax = ogenislik/2;
	private double ortalay =oyukseklik/2;
	

	
	public static int[] cokgenxar ={-13,14,-13,-5,-13};
	public static int[] cokgenyar ={-15,0,15,0,-15};
	
	private int gemigenislik = 35 , gemiyukseklik=30;
	
	private double ustsolxpos = getxortala() + juzaygemisi.cokgenxar[0];
	private double ustsolypos = getyortala() + juzaygemisi.cokgenyar[0];
	
	private double yonacisi=0 , hareketacisi=0;
	
	public juzaygemisi () {
		super(cokgenxar,cokgenyar,5);
		
	}
	
	public double getxortala(){return ortalax;}
	public double  getyortala(){return ortalay;}
	
	public void setxortala(double ortx){this.ortalax=ortx;}
	public void setyortala(double orty){this.ortalay=orty;}
	
	public void xposart (double posArt){this.ortalax=posArt;}
	public void yposart (double posArt){this.ortalay=posArt;}
	
	public double getustsolxpos() {return ustsolxpos;}
	public double getustsolypos() {return ustsolypos;}
	
	public void setustsolxpos( double ustxpos) {this.ustsolxpos=ustxpos;}
	public void setustsolypos( double ustypos) {this.ustsolypos=ustypos;}
	
	public int getgemigenislik(){return gemigenislik;}
	public int getgemiyukseklik(){return gemiyukseklik;}
	
	public double getxhiz(){return xhiz;}
	public double getyhiz(){return yhiz;}
	
	public void setxhiz(double xhiz){this.xhiz=xhiz;}
	public void setyhiz(double yhiz){this.yhiz=yhiz;}
	
	public void xhizarttir(double xhizart){this.xhiz +=xhizart;}
	public void yhizarttir(double yhizart){this.yhiz +=yhizart;}
	
	public void xhizazalt(double xhizazalt){this.xhiz -=xhizazalt;}
	public void yhizazalt(double yhizazalt){this.yhiz -=yhizazalt;}
	
	
	public void setHareketacisi(double hareketacisi){this.hareketacisi=hareketacisi;}
	public double getHareketacisi(){return hareketacisi;}
	
	public void hareketacisiarttir(double hareketacisi ){this.hareketacisi += hareketacisi;}

	public double gemixhareketacisi(double xhareketacisi){
		
		return (double) (Math.cos(xhareketacisi * Math.PI/180));
		
	}
public double gemiyhareketacisi(double yhareketacisi){
		
		return (double) (Math.sin(yhareketacisi * Math.PI/180));
		
	}

public double getYonacisi(){return yonacisi;}

 public void yonacisiarttir(){
	 if(getYonacisi() >= 330){ yonacisi= 0; }
	 else {yonacisi += 5 ;}
 }
	
 
 public void yonacisiazalt(){
	 if(getYonacisi() < 0){ yonacisi= 330; }
	 else {yonacisi -= 5 ;}
 }
	public Rectangle getsekme(){
		
    return new Rectangle((int) getxortala() - 14, (int) getyortala() -14, getgemigenislik(), getgemiyukseklik());
		
	}
	
	public double getgemiburunx(){
		return this.getxortala() + Math.cos(yonacisi)*14 ;
		
	} 
	public double getgemiburuny(){
		return this.getyortala() + Math.sin(yonacisi)*14 ;
		
	}
	
	public void hareketEt(){
		
		this.xposart(this.getxhiz());
		if(this.getxortala() < 0){ this.setxortala(ogenislik);}
		
		else if(this.getxortala() > ogenislik )
		{ this.setxortala(0);
		
		}
			
			
			this.yposart(this.getyhiz());
			if(this.getyortala() < 0){ this.setyortala(oyukseklik);}
			
			else if(this.getyortala() > oyukseklik )
			{ this.setyortala(0);}
			
		
		
		
	}
	
	
	
	
	}

	
