
public class TestABRDEntiers {
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a reçu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" reçu="+recu);
			System.exit(0);			
		}
	}
	public static void main(String[] args) {
		System.out.println("Tests methode insere()");
        ABRDEntiers a = new ABRDEntiers();
        a.insere(12);
        assertEquals("insere 12 contenu ko", "12", a.toString());
        assertEquals("insere 12 taille ko", 1, a.taille());
        a.insere(5);
        assertEquals("insere 5 contenu ko", "5 12", a.toString());
        assertEquals("insere 5 taille ko", 2, a.taille());
        a.insere(8);
        assertEquals("insere 8 contenu ko", "5 8 12", a.toString());
        a.insere(17);
        assertEquals("insere 17 contenu ko", "5 8 12 17", a.toString());
        a.insere(2);
        assertEquals("insere 2 contenu ko", "2 5 8 12 17", a.toString());
        a.insere(15);
        assertEquals("insere 15 contenu ko", "2 5 8 12 15 17", a.toString());
        a.insere(25);
        assertEquals("insere 25 contenu ko", "2 5 8 12 15 17 25", a.toString());
        a.insere(6);
        assertEquals("insere 6 contenu ko", "2 5 6 8 12 15 17 25", a.toString());
        a.insere(3);
        assertEquals("insere 3 contenu ko", "2 3 5 6 8 12 15 17 25", a.toString());
        a.insere(1);
        assertEquals("insere 1 contenu ko", "1 2 3 5 6 8 12 15 17 25", a.toString());
        a.insere(30);
        assertEquals("insere 30 contenu ko","1 2 3 5 6 8 12 15 17 25 30" , a.toString());
        a.insere(16);
        assertEquals("insere 16 contenu ko", "1 2 3 5 6 8 12 15 16 17 25 30", a.toString());
        System.out.println("Tous les tests ont reussi.");
        
        System.out.println("Tests methode contient()");
        assertEquals("contient 16 ko",true ,a.contient(16) );
        assertEquals("contient 16 contenu ko", "1 2 3 5 6 8 12 15 16 17 25 30", a.toString());
        assertEquals("contient 1 ko",true ,a.contient(12) );
        assertEquals("contient 2 ko",true ,a.contient(12) );
        assertEquals("contient 3 ko",true ,a.contient(12) );
        assertEquals("contient 5 ko",true ,a.contient(12) );
        assertEquals("contient 6 ko",true ,a.contient(12) );
        assertEquals("contient 8 ko",true ,a.contient(12) );
        assertEquals("contient 12 ko",true ,a.contient(12) );
        assertEquals("contient 15 ko",true ,a.contient(12) );
        assertEquals("contient 17 ko",true ,a.contient(12) );
        assertEquals("contient 25 ko",true ,a.contient(12) );
        assertEquals("contient 30 ko",true ,a.contient(12) );
        assertEquals("contient 7 ko",false ,a.contient(7) );
        assertEquals("contient 22 ko",false ,a.contient(22) );
        System.out.println("Tous les tests ont reussi.");
        
        System.out.println("Tests methode supprimeMin()");
        try {
			assertEquals("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko",1 ,a.supprimeMin() );
			assertEquals("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 taille ko", 11 ,a.taille());
		} catch (ArbreVideException e) {
			System.out.println("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 : il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "2 3 5 6 8 12 15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 2 3 5 6 8 12 15 16 17 25 30 contenu ko",2 ,a.supprimeMin() );
			assertEquals("supprimeMin 2 3 5 6 8 12 15 16 17 25 30 taille ko",10 ,a.taille());
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "3 5 6 8 12 15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 3 5 6 8 12 15 16 17 25 30 contenu ko",3 ,a.supprimeMin() );
			assertEquals("supprimeMin 3 5 6 8 12 15 16 17 25 30 taille ko",9 ,a.taille() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 3 5 6 8 12 15 16 17 25 30 contenu ko", "5 6 8 12 15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 5 6 8 12 15 16 17 25 30 ko",5 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 5 6 8 12 15 16 17 25 30 contenu ko", "6 8 12 15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 6 8 12 15 16 17 25 30 ko",6 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 6 8 12 15 16 17 25 30 contenu ko", "8 12 15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 8 12 15 16 17 25 30 ko",8 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 8 12 15 16 17 25 30 contenu ko", "12 15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 12 15 16 17 25 30 ko",12 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 12 15 16 17 25 30 contenu ko", "15 16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 15 16 17 25 30 ko",15 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 15 16 17 25 30 contenu ko", "16 17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 16 17 25 30 ko",16 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 16 17 25 30 contenu ko", "17 25 30", a.toString());
        try {
			assertEquals("supprimeMin 17 25 30 ko",17 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 17 25 30 contenu ko", "25 30", a.toString());
        try {
			assertEquals("supprimeMin 25 30 ko",25 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 25 30 contenu ko", "30", a.toString());
        try {
			assertEquals("supprimeMin 30 ko",30 ,a.supprimeMin() );
		} catch (ArbreVideException e) {
			System.out.println("Il ne fallait pas d'exception");
			System.exit(0);
		}
        assertEquals("supprimeMin 30 contenu ko", "", a.toString());
        try {
			a.supprimeMin();
			System.out.println("Il fallait une exception");
			System.exit(0);
		} catch (ArbreVideException e) {
			assertEquals("supprimeMin arbre vide contenu ko", "", a.toString());
			assertEquals("supprimeMin arbre vide taille ko",0, a.taille());
		}
        System.out.println("Tous les tests ont reussi.");
        
        System.out.println("Tests methode supprime()");
        a.insere(12);
        a.insere(5);
        a.insere(8);
        a.insere(17);
        a.insere(2);
        a.insere(15);
        a.insere(25);
        a.insere(6);
        a.insere(3);
        a.insere(1);
        a.insere(30);
        a.insere(16);
        assertEquals("supprime 3 dans 1 2 3 5 6 8 12 15 16 17 25 30",true ,a.supprime(3) );
        assertEquals("supprime 3 dans 1 2 3 5 6 8 12 15 16 17 25 30 contenu ko", "1 2 5 6 8 12 15 16 17 25 30", a.toString());
        assertEquals("supprime 3 dans 1 2 3 5 6 8 12 15 16 17 25 30 taille ko",11, a.taille());
        assertEquals("supprime 25 dans 1 2 5 6 8 12 15 16 17 25 30",true ,a.supprime(25) );
        assertEquals("supprime 25 dans 1 2 5 6 8 12 15 16 17 25 30 contenu ko", "1 2 5 6 8 12 15 16 17 30", a.toString());
        assertEquals("supprime 25 dans 1 2 5 6 8 12 15 16 17 25 30 taille ko", 10, a.taille());
        assertEquals("supprime 12 dans 1 2 5 6 8 12 15 16 17 30",true ,a.supprime(12) );
        assertEquals("supprime 12 dans 1 2 5 6 8 12 15 16 17 30 contenu ko", "1 2 5 6 8 15 16 17 30", a.toString());
        assertEquals("supprime 12 dans 1 2 5 6 8 12 15 16 17 30 taille ko", 9, a.taille());
        assertEquals("supprime 7 dans 1 2 5 6 8 15 16 17 30",false ,a.supprime(7) );
        assertEquals("supprime 7 dans 1 2 5 6 8 15 16 17 30 contenu ko", "1 2 5 6 8 15 16 17 30", a.toString()); 
        assertEquals("supprime 7 dans 1 2 5 6 8 15 16 17 30 taille ko",9, a.taille()); 
        assertEquals("supprime 17 dans 1 2 5 6 8 15 16 17 30",true ,a.supprime(17) );
        assertEquals("supprime 17 dans 1 2 5 6 8 15 16 17 30 contenu ko", "1 2 5 6 8 15 16 30", a.toString());
        assertEquals("supprime 17 dans 1 2 5 6 8 15 16 30",false ,a.supprime(17) );
        assertEquals("supprime 17 dans 1 2 5 6 8 15 16 30 contenu ko", "1 2 5 6 8 15 16 30", a.toString());
        assertEquals("supprime 1 dans 1 2 5 6 8 15 16 30",true ,a.supprime(1) );
        assertEquals("supprime 1 dans 1 2 5 6 8 15 16 30 contenu ko", "2 5 6 8 15 16 30", a.toString());
        assertEquals("supprime 8 dans 2 5 6 8 15 16 30",true ,a.supprime(8) );
        assertEquals("supprime 8 dans 2 5 6 8 15 16 30 contenu ko", "2 5 6 15 16 30", a.toString());
        assertEquals("supprime 15 dans 2 5 6 15 16 30",true ,a.supprime(15) );
        assertEquals("supprime 15 dans 2 5 6 15 16 30 contenu ko", "2 5 6 16 30", a.toString());
        assertEquals("supprime 30 dans 2 5 6 16 30",true ,a.supprime(30) );
        assertEquals("supprime 30 dans 2 5 6 16 30 contenu ko", "2 5 6 16", a.toString());
        assertEquals("supprime 2 dans 2 5 6 16",true ,a.supprime(2) );
        assertEquals("supprime 2 dans 2 5 6 16 contenu ko", "5 6 16", a.toString());
        assertEquals("supprime 5 dans 5 6 16",true ,a.supprime(5) );
        assertEquals("supprime 5 dans 5 6 16 contenu ko", "6 16", a.toString());
        assertEquals("supprime 6 dans 6 16",true ,a.supprime(6) );
        assertEquals("supprime 6 dans 6 16 contenu ko", "16", a.toString());
        assertEquals("supprime 16 dans 16",true ,a.supprime(16) );
        assertEquals("supprime 16 dans 16 contenu ko", "", a.toString());
        assertEquals("supprime 3 dans arbre vide",false ,a.supprime(3) );
        assertEquals("supprime 3 dans arbre vide contenu ko", "", a.toString());
        System.out.println("Tous les tests ont reussi.");
            
	}
}
