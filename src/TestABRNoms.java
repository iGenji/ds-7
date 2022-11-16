public class TestABRNoms {
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur
	 *            message a afficher en cas de probleme
	 * @param attendu
	 *            la valeur qu'on s'attendait a recevoir
	 * @param recu
	 *            la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu,
			Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println(messageErreur + ". \n Attendu = " + attendu
						+ " \n Reçu = " + recu);
				System.exit(0);
			}
		} else {
			if (attendu instanceof Character && recu instanceof String) {
				attendu = "" + attendu;
			}
			if (attendu instanceof String && recu instanceof Character) {
				recu = "" + recu;
			}
			if (!attendu.equals(recu)) {
				System.out.println(messageErreur + ". \n Attendu = " + attendu
						+ " \n Reçu = " + recu);
				System.exit(0);
			}
		}
	}
	public static void main(String[] args) {
		System.out.println("Tests methode insere");
		System.out.println("-------------------------");
		ABRNoms a = new ABRNoms();
		a.insere("antoine");
		assertEquals("test ko : ajout d'antoine dans l'arbre vide ","antoine", a.toString());
        a.insere("aurelie");
        assertEquals("test ko : ajout d'aurelie dans l'arbre qui contient antoine ","antoine aurelie", a.toString());
        a.insere("adrien");
        assertEquals("test ko : ajout d'adrien dans l'arbre qui contient antoine aurelie","adrien antoine aurelie", a.toString());
        a.insere("adeline");
        assertEquals("test ko : ajout d'adeline dans l'arbre qui contient adrien antoine aurelie","adeline adrien antoine aurelie", a.toString());
        a.insere("amelie");
        assertEquals("test ko : ajout d'amelie dans l'arbre qui contient adrien antoine aurelie","adeline adrien amelie antoine aurelie", a.toString());
        a.insere("anouk");
        assertEquals("test ko : ajout d'anouk dans l'arbre qui contient adrien amelie antoine aurelie","adeline adrien amelie anouk antoine aurelie", a.toString());
        a.insere("aymeric");
        assertEquals("test ko : ajout d'aymeric dans l'arbre qui contient adrien amelie anouk antoine aurelie","adeline adrien amelie anouk antoine aurelie aymeric", a.toString());
        a.insere("amandine");
        assertEquals("test ko : ajout d'amandine dans l'arbre qui contient adrien amelie anouk antoine aurelie aymeric","adeline adrien amandine amelie anouk antoine aurelie aymeric", a.toString());
		
       
        System.out.println("Tous les tests de la methode insere ont reussi.");
        System.out.println();
		System.out.println("Tests methode supprimeMin");
		System.out.println("-------------------------");
		
		// test 1
        ABRNoms a1 = new ABRNoms();
        assertEquals("test 1 ko : l'arbre est vide ",null, a1.supprimeMin());
		
		// test 2
        ABRNoms a2 = new ABRNoms();
        a2.insere("manon");
        assertEquals("test 2 ko : l'arbre contient un noeud ","manon", a2.supprimeMin());
        assertEquals("test 2 ko : l'arbre contient un noeud, il n'a pas ete supprime ","", a2.toString());
        
        // test 3
        ABRNoms a3 = new ABRNoms();
        a3.insere("antoine");
        a3.insere("aurelie");
        a3.insere("adrien");
        a3.insere("adeline");
        a3.insere("amelie");
        a3.insere("anouk");
        a3.insere("aymeric");
        a3.insere("amandine");
        assertEquals("test 3 ko : l'arbre avant suppression du min contient adeline adrien amandine amelie anouk antoine aurelie aymeric","adeline", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient adeline adrien amandine amelie anouk antoine aurelie aymeric","adrien amandine amelie anouk antoine aurelie aymeric", a3.toString());
        
        assertEquals("test 3 ko : l'arbre avant suppression du min contient adrien amandine amelie anouk antoine aurelie aymeric","adrien", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient adrien amandine amelie anouk antoine aurelie aymeric","amandine amelie anouk antoine aurelie aymeric", a3.toString());
        
        assertEquals("test 3 ko : l'arbre avant suppression du min contient amandine amelie anouk antoine aurelie aymeric","amandine", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient amandine amelie anouk antoine aurelie aymeric","amelie anouk antoine aurelie aymeric", a3.toString());

        assertEquals("test 3 ko : l'arbre avant suppression du min contient amelie anouk antoine aurelie aymeric","amelie", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient amelie anouk antoine aurelie aymeric","anouk antoine aurelie aymeric", a3.toString());
        
        assertEquals("test 3 ko : l'arbre avant suppression du min contient anouk antoine aurelie aymeric","anouk", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient anouk antoine aurelie aymeric","antoine aurelie aymeric", a3.toString());
     
        assertEquals("test 3 ko : l'arbre avant suppression du min contient antoine aurelie aymeric","antoine", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient antoine aurelie aymeric","aurelie aymeric", a3.toString());
        
        assertEquals("test 3 ko : l'arbre avant suppression du min contient aurelie aymeric","aurelie", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient aurelie aymeric","aymeric", a3.toString());
        
        assertEquals("test 3 ko : l'arbre avant suppression du min contient aymeric","aymeric", a3.supprimeMin());
        assertEquals("test 3 ko : l'arbre avant suppression du min contient aymeric","", a3.toString());
        
        System.out.println("Tous les tests de la methode supprimeMin ont reussi.");

	}
}
