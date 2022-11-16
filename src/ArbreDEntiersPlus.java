import java.util.HashSet;

public class ArbreDEntiersPlus<V> extends ArbreDEntiers {

	public ArbreDEntiersPlus() {
		super();
	}

	public ArbreDEntiersPlus(ArbreDEntiersPlus sousArbreGauche, int entier, ArbreDEntiersPlus sousArbreDroit) {
		super(sousArbreGauche, entier, sousArbreDroit);
	}

	public ArbreDEntiersPlus(int entier) {
		super(new ArbreDEntiersPlus(), entier, new ArbreDEntiersPlus());
	}

	public ArbreDEntiersPlus filsGauche() {
		return (ArbreDEntiersPlus) super.filsGauche();
	}

	public ArbreDEntiersPlus filsDroit() {
		return (ArbreDEntiersPlus) super.filsDroit();
	}
	
	/**
	 * totalise les entiers compris dans l'arbre
	 * @return la somme des entiers compris dans l'arbre
	 */
	public int somme() {
		if (this.estVide())
			return 0;
		return this.racine().element() + this.filsGauche().somme() + this.filsDroit().somme();
	}
	
	/**
	 * renvoie le nombre de fois qu'apparait un entier dans l'arbre 
	 * @param entier l'entier recherche
	 * @return le nombre d'occurrence
	 */
	public int nombreOccurrences(int entier) {
		if (estVide())
			return 0;
		if (racine().element() == entier)
			return 1 + filsGauche().nombreOccurrences(entier) + filsDroit().nombreOccurrences(entier);
		return filsGauche().nombreOccurrences(entier) + filsDroit().nombreOccurrences(entier);
	}
	
	
	/**
	 * verifie la presence d'un entier dans l'arbre
	 * @param entier l'entier recherche
	 * @return true si l'entier est present, false sinon
	 */
	public boolean estPresent(int entier){
		if (estVide())
			return false;
		if (racine().element() == entier) 
			return true;
		return filsGauche().estPresent(entier) || filsDroit().estPresent(entier);
	}
	
	/**
	 * calcule le nombre d'entiers positifs compris dans l'arbre
	 * @return le nombre d'entiers positifs compris dans l'arbre
	 */
	public int nombrePositifs(){
		if (estVide())
			return 0;
		if (racine().element() > 0)
			return 1 + filsGauche().nombrePositifs() + filsDroit().nombrePositifs();
		return filsGauche().nombrePositifs() + filsDroit().nombrePositifs();
	}
	
	/**
	 * verifie si tous les entiers compris dans l'arbre sont tous positifs
	 * @return true si tous les entiers sont positifs, false sinon
	 */
	public boolean tousPositifs(){
		if (estVide())
			return true;
		if (racine().element() < 0)
			return false;
		return filsGauche().tousPositifs() && filsDroit().tousPositifs();
	}
  
	/**
	 * calcule le nombre de feuilles contenues dans l'arbre
	 * @return le nombre de feuilles contenues dans l'arbre
	 */
	public int nombreFeuilles(){
		if (estVide())
			return 0;
		if (filsGauche().estVide() && filsDroit().estVide()) 
			return 1 + filsGauche().nombreFeuilles() + filsDroit().nombreFeuilles();
		return filsGauche().nombreFeuilles() + filsDroit().nombreFeuilles();
	}

	/**
	 * calcule le nombre de feuilles contenues dans l'arbre
	 * @return le nombre de feuilles contenues dans l'arbre
	 */
	public int nombreNoeudsInternes(){
		if (estVide())
			return 0;
		if (!(filsGauche().estVide() && filsDroit().estVide()))
			return 1 + filsGauche().nombreNoeudsInternes() + filsDroit().nombreNoeudsInternes();
		return filsGauche().nombreNoeudsInternes() + filsDroit().nombreNoeudsInternes();
	}

	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArbreDEntiersPlus a = (ArbreDEntiersPlus)obj;
		return this.equals(a);
	}

	public boolean equals(ArbreDEntiersPlus a){
		if (this == a)
			return true;
		if (estVide() && a.estVide())
			return true;
		if (estVide() != a.estVide())
			return false;
		if (racine().element() != a.racine().element())
			return false;
		return (filsGauche().equals(a.filsGauche()) && filsDroit().equals(a.filsDroit()));
	}

	public String toString() {
		if (estVide())
			return " ";
		if (filsGauche().estVide() && filsDroit().estVide()) {
			return "" + racine().element();
		}
		return "(" + filsGauche().toString() + "," + racine().element() + "," + filsDroit().toString() + ")";
	}

	public boolean contientExAequos() {
		return contientHelper(new HashSet<>());
	}
	
	private boolean contientHelper(HashSet<Integer> map) {
		if (estVide())
			return false;
		int element = racine().element();
		if (map.contains(element))
			return true;
		map.add(element);
		return filsGauche().contientHelper(map) || filsDroit().contientHelper(map);
	}

	// renvoie -1 si l'arbre est vide
	public int maximum() {
		if (estVide())
			return -1;
		return Math.max(racine().element(), Math.max(filsGauche().maximum(), filsDroit().maximum()));
	}

	// renvoie -1 si l'arbre est vide
	public int minimum() {
		if (estVide())
			return -1;
		int min = racine().element();
		if (filsGauche() != null) {
			int nombre = Math.min(min, filsGauche().minimum());
			if (nombre != -1)
				min = nombre;
		}
		if (filsDroit() != null) {
			int nombre = Math.min(min, filsDroit().minimum());
			if (nombre != -1)
				min = nombre;
		}
		return min;
	}
}
