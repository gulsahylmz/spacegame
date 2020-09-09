import java.awt.Polygon;
import java.awt.Rectangle;

@SuppressWarnings("serial")
class jmermi extends Polygon{
	int ogenislik = joyunalani.oyunalanigenislik;
	int oyukseklik =joyunalani.oyunalaniyukseklik;
	

	private double ortalax =0, ortalay=0;
	
	public static int[] cokgenxa ={-3,3,3,-3,-3};
	public static int[] cokgenya  ={-3,-3,3,3,-3};
	
	
	private int mermigenislik = 6 , mermiyukseklik=6;
	public boolean ekranda = false;
	private double hareketacisi=0;
	private double xhiz =5,yhiz=5;
	
	jmermi(double ortalax,double ortalay,double hareketacisi){
		super(cokgenxa,cokgenya,5);
		
				this.ortalax=ortalax;
				this.ortalay=ortalay;
				this.hareketacisi=hareketacisi;
				this.ekranda=true;		
				this.setxhiz(this.mermixhareketacisi(hareketacisi)*30);
				this.setyhiz(this.mermiyhareketacisi(hareketacisi)*30);
 
	}	
			public double getxortala(){ return ortalax;}
			public double getyortala(){ return ortalay;}
			
			public void setxortala(double ortalax){this.ortalax=ortalax;}
			public void setyortala(double ortalay){this.ortalay=ortalay;}
	
			public void xposdegistir(double arttir){this.ortalax += arttir;}
			public void yposdegistir(double arttir){this.ortalay += arttir;}
			
			public double getxhiz(){ return xhiz;}
			public double getyhiz(){ return yhiz;}
			
			public void setxhiz(double xhiz){this.xhiz=xhiz;}
			public void setyhiz(double yhiz){this.yhiz=yhiz;}
			
			public int getgenislik(){return mermigenislik; }
			public int getyukseklik(){ return mermiyukseklik;}
			
			public void sethareketacisi(double hareketacisi){this.hareketacisi=hareketacisi;} 
			public double gethareketacisi(){ return hareketacisi;}
			
			public Rectangle getsekme(){ 
			
				return new Rectangle((int) getxortala()-6,(int) getyortala()-6,getgenislik(),getyukseklik());
				
			}
			

			public double mermixhareketacisi(double xhareketacisi){
				return (double)(Math.cos(xhareketacisi * Math.PI/180));
				
			}
			
			public double mermiyhareketacisi(double yhareketacisi){
				return (double)(Math.sin(yhareketacisi * Math.PI/180));
				
			}
			public void hareketet(){ 
				
				if(this.ekranda){
					this.xposdegistir(this.getxhiz());
					if(this.getxortala()<0){
						this.ekranda=false;
					}else
						if(this.getxortala()> ogenislik){
							this.ekranda=false;
							
						}else 
							if(this.getyortala()<0){
								this.ekranda=false;
							}else
								if(this.getyortala() > oyukseklik){
									this.ekranda=false;
									
								}
					
					}
				}
			}
	
	
