// Arbre binaire contenant des caracteres

	public class ArbreDeCaracteres {
		
		private NoeudExpression racine; 
		
		public ArbreDeCaracteres() {
			this.racine=null ;
		}
		
		/**
		 * Cree un arbre a partir d'un arbre.
		 * Attention prend juste la reference, ne fait pas une copie.
		 * @param arbre
		 */
		public ArbreDeCaracteres(ArbreDeCaracteres arbre){
			this.racine = arbre.racine();
		}

		public ArbreDeCaracteres(char caractere) {
			this.racine=new NoeudExpression(caractere) ;
		}
		
		public ArbreDeCaracteres(char caractere, ArbreDeCaracteres sousArbreGauche, ArbreDeCaracteres sousArbreDroit) {
			this.racine=new NoeudExpression(caractere,sousArbreGauche,sousArbreDroit) ;
		}

		public boolean estVide(){
			return  this.racine == null;
		}

		public NoeudExpression racine(){
			return racine;
		}
		public ArbreDeCaracteres filsGauche(){
			return this.racine.sousArbreGauche;
			
		}
		
		public ArbreDeCaracteres filsDroit(){
			return this.racine.sousArbreDroit;
			
		}
		
		
		

	public class NoeudExpression {

		private char caractere; 
		private ArbreDeCaracteres sousArbreGauche;
		private ArbreDeCaracteres sousArbreDroit;


		private NoeudExpression(char caractere){
			this.caractere = caractere;
			this.sousArbreGauche = new ArbreDeCaracteres();
			this.sousArbreDroit = new ArbreDeCaracteres();
		}
		
		private NoeudExpression(char caractere, ArbreDeCaracteres sousArbreGauche, ArbreDeCaracteres sousArbreDroit){
			this.caractere = caractere;
			this.sousArbreGauche = sousArbreGauche;
			this.sousArbreDroit = sousArbreDroit;
		}
		
		public char element() {
			return caractere;
		}	

	} 

}