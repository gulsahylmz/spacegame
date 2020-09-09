import java.awt.Polygon;
import java.util.ArrayList;
import java.awt.Rectangle;;
@SuppressWarnings("serial")
class jgoktasi extends Polygon{
	
	
	int ustsolxpos,ustsolypos;
	
	int xyonu=1;
	int yyonu=1;
	int goktasigenislik= 29;
	int goktasiyukseklik=35;
	
	int genislik =joyunalani.oyunalanigenislik;
	int yukseklik =joyunalani.oyunalaniyukseklik;
	
	int[] cokgenxa, cokgenya;

	public boolean ekranda =true;
	String patlamasesi = "file:./src/explosion.wav";
	
	public static int[] hbcokgenxa ={10,17,26,34,27,36,26,14,8,1,5,1,10};
	public static int[] hbcokgenya ={0,5,1,8,13,20,31,28,31,22,16,7,0};
	
	public static ArrayList<jgoktasi>goktaslari = new ArrayList<jgoktasi>(); 
	
	
	public jgoktasi(int[] cokgenxa, int[] cokgenya, int cokgennokta , int rastbasposx , int rastbasposy){

	super(cokgenxa,cokgenya,cokgennokta);
	
	this.xyonu = (int) ( Math.random()*4+1);
	this.yyonu = (int) ( Math.random()*4+1);
	
	this.ustsolxpos= rastbasposx;
	this.ustsolypos=rastbasposy;	
		
	
	
	
}
	// tasları sektireceğiz
	public Rectangle getSekme(){
		return new Rectangle(super.xpoints[0],super.ypoints[0],goktasigenislik,goktasiyukseklik);
		
		
		
	}
	
	
	
	//moving astroid
	public void hareketet(juzaygemisi gemi,ArrayList<jmermi> mermiler){
		
		Rectangle taskont = this.getSekme();
		
		for(jgoktasi tas : goktaslari){
			
			if(tas.ekranda){
				
				
			
	
			Rectangle dtas = tas.getSekme();
			if(tas != this && dtas.intersects(taskont)){
			int rastxyonu = this.xyonu;
			int rastyyonu = this.yyonu;
			
			this.xyonu = tas.xyonu;
			this.yyonu= tas.yyonu;
			
			tas.xyonu=rastxyonu;
			tas.yyonu=rastyyonu;
			}
			
			Rectangle gemikutu= gemi.getsekme();
			if(dtas.intersects(gemikutu)){
				joyunalani.efekt(patlamasesi);
				gemi.setxortala(gemi.ogenislik/2);
				gemi.setyortala(gemi.oyukseklik/2);
				gemi.setxhiz(0);
				gemi.setyhiz(0);
				
			}for(jmermi mermim : mermiler){
				
				if (mermim.ekranda){
					if(dtas.contains(mermim.getxortala(),mermim.getyortala())){
						tas.ekranda=false;
						mermim.ekranda=false;
						System.out.println("vurdu");
						joyunalani.efekt(patlamasesi);
					}
					
				}
			}
			
			}
		}
	
	int ustsolxpos=super.xpoints[0];
	int ustsolypos=super.ypoints[0];
	
	if(ustsolxpos <0 || (ustsolxpos+25) > genislik) {
		xyonu=-xyonu;	
		
	}
	
	if(ustsolypos <0 || (ustsolypos+50) > yukseklik) {
		yyonu=-yyonu;	
		
	}
	
	for (int i=0;i < super.xpoints.length;i++){
		super.xpoints[i] +=xyonu;
		super.ypoints[i] +=yyonu;
	}
	
	}//moving astroid end
	
	// calling x point in pollygon 
	
	public static int[] getcokxa(int rastbasposx){
	int[] rascokxa	=(int[]) hbcokgenxa.clone();
	
			for(int i=0;i<rascokxa.length; i++){
				
				rascokxa[i] += rastbasposx;
			}
	 return rascokxa;
	}
	
	// calling y point in polygon 
//----------------------------------------------------
// calling y point in polygon 
	
	public static int[] getcokya(int rastbasposy){
	int[] rascokya	=(int[]) hbcokgenya.clone();
	
			for(int i=0;i<rascokya.length; i++){
				
				rascokya[i] += rastbasposy;
			}
	 return rascokya;
	}
// calling y point in polygon end
	
}
	