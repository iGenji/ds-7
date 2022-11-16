public class ABRDEntiers {
	
	private NoeudEntier racine;
	private int taille = 0;
	
	public ABRDEntiers() {
		this.racine=null ;
	}
		
	public int taille(){
		// ATTENTION! cette methode est en O(N)
		// cfr DEFI
		return taille;
//		if(this.estVide())
//			return 0;
//		return 1 + this.filsGauche().taille() + this.filsDroit().taille();
	}

	public NoeudEntier racine() {
		return racine;
	}

	public boolean estVide() {
		return this.racine == null;
	}

	public ABRDEntiers filsGauche() {
		return this.racine.sousArbreGauche;

	}

	public ABRDEntiers filsDroit() {
		return this.racine.sousArbreDroit;
	}
	
	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString() {
		if (this.estVide())
			return "";
		if (this.filsGauche().estVide() && this.filsDroit().estVide())
			return "" + this.racine.element();
		if (this.filsGauche().estVide())
			return "" + this.racine.element() + " " + this.filsDroit().toString();
		if (this.filsDroit().estVide())
			return this.filsGauche().toString() + " " + this.racine.element();
		return this.filsGauche().toString() + " " + this.racine.element() + " " + this.filsDroit().toString();
	}

	/**
	 * insere un entier dans l'ABR
	 * Les doublons sont acceptes 
	 * @param entier l'entier a inserer
	 */
	public void insere(int entier) {
		taille++;
		if (estVide()) {
			this.racine = new NoeudEntier(entier);
			return;
		}
		if (racine().entier > entier) {
			filsGauche().insere(entier);
		} else { // La meme cle est inseree a droite
			filsDroit().insere(entier);
		}
	}
	
	/**
	 * verifie la presence d'un entier dans l'ABR
	 * @param entier l'entier recherche
	 * @return true si l'entier est present, false sinon
	 */
	public boolean contient(int entier) {
		if (estVide())
			return false;
		if (racine().entier == entier) {
			return true;
		}
		if (racine().entier > entier) {
			return filsGauche().contient(entier);
		}
		return filsDroit().contient(entier);
	}

	/**
	 * supprime le plus petit entier contenu dans l'ABR
	 * @return le plus petit entier
	 * @throws ArbreVideException si l'arbre est vide
	 */
	public int supprimeMin() throws ArbreVideException {
		if (estVide())
			throw new ArbreVideException();
		taille--;
		if (filsGauche().estVide()) {
			int entier = racine().entier;
			racine = filsDroit().racine;
			return entier;
		}
		return filsGauche().supprimeMin();
	}

	/**
	 * supprime un entier de l'ABR
	 * @param entier l'entier a supprimer
	 * @return true si l'entier a pu etre supprime, false sinon
	 */
	public boolean supprime(int entier) {
		if (estVide())
			return false;
		if (racine.entier == entier) {
			if (filsDroit().estVide()) {
				racine = filsGauche().racine;
			} else {
				racine.entier = filsDroit().supprimeMin();
			}
			taille--;
			return true;
		}
		if (racine.entier > entier) {
			if (filsGauche().supprime(entier)) {
				taille--;
				return true;
			}
		}
		if (filsDroit().supprime(entier)) {
			taille--;
			return true;
		}
		return false;
	}
	
	/**
	 * construit une table triee par ordre croissant contenant les entiers de l'ABR
	 * @return la table construite
	 */
	public int[] toArray() {
		int[] t = new int[taille()];
		toArrayInterne(t, 0, taille() - 1);
		return t;
	}

	private void toArrayInterne(int[] t, int i, int j) {
		if (estVide())
			return;
		if (!filsGauche().estVide()) {
			filsGauche().toArrayInterne(t, i, j - filsDroit().taille - 1);
		}
		if (!filsDroit().estVide()) {
			filsDroit().toArrayInterne(t, i + filsGauche().taille + 1, j);
		}
		t[i + filsGauche().taille] = racine.entier;
	}

	public class NoeudEntier {
		private int entier;
		private ABRDEntiers sousArbreGauche;
		private ABRDEntiers sousArbreDroit;

		private NoeudEntier(int entier) {
			this.entier = entier;
			this.sousArbreGauche = new ABRDEntiers();
			this.sousArbreDroit = new ABRDEntiers();
		}

		private NoeudEntier(ABRDEntiers g, int entier, ABRDEntiers d) {
			this.entier = entier;
			this.sousArbreGauche = g;
			this.sousArbreDroit = d;
		}

		public int element() {
			return entier;
		}
	}
}
