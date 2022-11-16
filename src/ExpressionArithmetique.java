public class ExpressionArithmetique extends ArbreDeCaracteres{
	
	
	/**
	 * Cree une expression arithmetique a partir d'un arbre de caracteres
	 * @param a
	 */
	public ExpressionArithmetique(ArbreDeCaracteres a) {
		super(a);		
	}

	public ExpressionArithmetique() {
		super();
	}

	public ExpressionArithmetique(char c) {
		super(c, new ExpressionArithmetique(), new ExpressionArithmetique());
	}

	public ExpressionArithmetique(char c, ExpressionArithmetique ag, ExpressionArithmetique ad) {
		super(c, ag, ad);
	}

	/**
	 * Cree un arbre de caracteres contenant l'expression arithmetique
	 * @param infixe
	 */
	public ExpressionArithmetique(String infixe){
		// DEFI cfr enonce
	}
	
	
	public ExpressionArithmetique filsGauche(){
		return (ExpressionArithmetique)super.filsGauche();
	}
	
	public ExpressionArithmetique filsDroit(){
		return (ExpressionArithmetique)super.filsDroit();
	}
	
	public double resultat() {
		if (estVide())
			return 0;
		if (racine().element() == '*') {
			return filsGauche().resultat() * filsDroit().resultat();
		}
		if (racine().element() == '+') {
			return filsGauche().resultat() + filsDroit().resultat();
		}
		if (racine().element() == '-') {
			return filsGauche().resultat() - filsDroit().resultat();
		}
		if (racine().element() == '/') {
			return filsGauche().resultat() / filsDroit().resultat();
		}
		return racine().element() - 48;
	}

	public String notationInfixe() {
		if (estVide())
			return "";
		int val = racine().element() - 48;
		if (val > 9 || val < 0) {
			return "(" + filsGauche().notationInfixe() + racine().element() + filsDroit().notationInfixe() + ")";
		}
		return racine().element() + "";
	}
} 

