public class TriViaABR {
	private ABRNoms[] tableABR;

	public TriViaABR() {
		this.tableABR = new ABRNoms[26];
		for (int i = 0; i < 26; i++) {
			this.tableABR[i] = new ABRNoms();
		}
	}

	/**
	 * tri des noms re�us en parametre
	 * 
	 * @param noms table a trier
	 * @return table contenant les noms tries
	 */
	public String[] trier(String[] noms) {
		repartirDonnees(noms);
		return remplirTableTriee(noms.length);
	}

	/**
	 * 1ere etape du tri : repartition des noms dans les ABR
	 * 
	 * @param noms table a trier
	 */
	private void repartirDonnees(String[] noms) {
		if (noms == null)
			throw new IllegalArgumentException();
		for (int i = 0; i < noms.length; i++) {
			int indexAbr = (int) noms[i].charAt(0) - 'a';
			tableABR[indexAbr].insere(noms[i]);
		}
	}

	/**
	 * 2eme etape du tri : 
	 * 
	 * @param taille nombre de noms 
	 * @return table contenant les noms tries
	 */
	private String[] remplirTableTriee(int taille) {
		String[] listeTriee = new String[taille];
		int j = 0;
		for (int i = 0; i < 26; i++) {
			while (!tableABR[i].estVide()) {
				listeTriee[j] = tableABR[i].supprimeMin();
				j++;
			}
		}
		return listeTriee;
	}
	
	// POURRAIT SERVIR POUR DEBUGGER
	public String toString() {
		String aRenvoyer = "";
		for (int i = 0; i < 26; i++) {
			if (!tableABR[i].estVide()) {
				aRenvoyer += " " + tableABR[i].toString();
			}
		}
		return aRenvoyer;
	}
}
