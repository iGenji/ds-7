
public class ArbreDEntiers {
	private NoeudEntier racine; 
	private int taille;
	
	public ArbreDEntiers() {
		this.racine=null ;
		this.taille=0;
	}

	public ArbreDEntiers(int entier) {
		this.racine=new NoeudEntier(entier) ;
		this.taille=1;
	}
	
	public ArbreDEntiers(ArbreDEntiers sousArbreGauche, int entier, ArbreDEntiers sousArbreDroit) {
		this.racine=new NoeudEntier(sousArbreGauche,entier,sousArbreDroit) ;
		this.taille= 1 + sousArbreGauche.taille + sousArbreDroit.taille;
	}

	public NoeudEntier racine(){
		return racine;
	}
	
	public boolean estVide(){
		return  this.racine == null;
	}

	public int taille(){
		return taille;
	}
	
	public ArbreDEntiers filsGauche(){
		return this.racine.sousArbreGauche;
		
	}
	
	public ArbreDEntiers filsDroit(){
		return this.racine.sousArbreDroit;	
	}
	
	public class NoeudEntier {
		private int entier; 
		private ArbreDEntiers sousArbreGauche;
		private ArbreDEntiers sousArbreDroit;


		private NoeudEntier(int entier){
			this.entier = entier;
			this.sousArbreGauche = new ArbreDEntiers();
			this.sousArbreDroit = new ArbreDEntiers();
		}
		
		private NoeudEntier(ArbreDEntiers g,int entier,ArbreDEntiers d){
			this.entier = entier;
			this.sousArbreGauche = g;
			this.sousArbreDroit = d;
		}
		
		public int element() {
			return entier;
		}
	}
}
