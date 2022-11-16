import java.util.Scanner;

public class TestArbresDEntiersPlus {
	
	private static Scanner scanner = new Scanner(System.in);
	
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
	
	public static ArbreDEntiersPlus arbreVide(){
		return new ArbreDEntiersPlus();
	}
	
	public static ArbreDEntiersPlus arbreEnonce(){
		ArbreDEntiersPlus ag = new ArbreDEntiersPlus(11);
		ArbreDEntiersPlus ad = new ArbreDEntiersPlus(17);
		ad = new ArbreDEntiersPlus(ag,15,ad);
		ag = new ArbreDEntiersPlus(2);	
		ArbreDEntiersPlus a = new ArbreDEntiersPlus(ag,7,ad);
		ad = new ArbreDEntiersPlus(11);
		ag = new ArbreDEntiersPlus(arbreVide(),8,ad);
		ad = new ArbreDEntiersPlus(ag,6,arbreVide());
		a = new ArbreDEntiersPlus(a,10,ad);
		return a;
	}

	public static ArbreDEntiersPlus arbreEnonceAvecDoublon(){
		ArbreDEntiersPlus ag = new ArbreDEntiersPlus(11);
		ArbreDEntiersPlus ad = new ArbreDEntiersPlus(17);
		ad = new ArbreDEntiersPlus(ag,15,ad);
		ag = new ArbreDEntiersPlus(2);	
		ArbreDEntiersPlus a = new ArbreDEntiersPlus(ag,7,ad);
		ad = new ArbreDEntiersPlus(11);
      ag = new ArbreDEntiersPlus(6);	
		ag = new ArbreDEntiersPlus(ag,8,ad);
		ad = new ArbreDEntiersPlus(ag,6,arbreVide());
		a = new ArbreDEntiersPlus(a,10,ad);
		return a;
	}

	public static ArbreDEntiersPlus arbreEnonceAvecPermutation(){
		ArbreDEntiersPlus ag = new ArbreDEntiersPlus(17);
		ArbreDEntiersPlus ad = new ArbreDEntiersPlus(11);
		ad = new ArbreDEntiersPlus(ag,15,ad);
		ag = new ArbreDEntiersPlus(2);	
		ArbreDEntiersPlus a = new ArbreDEntiersPlus(ag,7,ad);
		ad = new ArbreDEntiersPlus(11);
		ag = new ArbreDEntiersPlus(arbreVide(),8,ad);
		ad = new ArbreDEntiersPlus(ag,6,arbreVide());
		a = new ArbreDEntiersPlus(a,10,ad);
		return a;
	}
	
	public static ArbreDEntiersPlus arbreEnonceAvecUnNegatif(){
		ArbreDEntiersPlus ag = new ArbreDEntiersPlus(-11);
		ArbreDEntiersPlus ad = new ArbreDEntiersPlus(17);
		ad = new ArbreDEntiersPlus(ag,15,ad);
		ag = new ArbreDEntiersPlus(2);	
		ArbreDEntiersPlus a = new ArbreDEntiersPlus(ag,7,ad);
		ad = new ArbreDEntiersPlus(11);
		ag = new ArbreDEntiersPlus(arbreVide(),8,ad);
		ad = new ArbreDEntiersPlus(ag,6,arbreVide());
		a = new ArbreDEntiersPlus(a,10,ad);
		return a;
	}
	
	public static ArbreDEntiersPlus arbreEnonceAvecDeuxNegatifs(){
		ArbreDEntiersPlus ag = new ArbreDEntiersPlus(11);
		ArbreDEntiersPlus ad = new ArbreDEntiersPlus(-17);
		ad = new ArbreDEntiersPlus(ag,15,ad);
		ag = new ArbreDEntiersPlus(2);	
		ArbreDEntiersPlus a = new ArbreDEntiersPlus(ag,7,ad);
		ad = new ArbreDEntiersPlus(11);
		ag = new ArbreDEntiersPlus(arbreVide(),-8,ad);
		ad = new ArbreDEntiersPlus(ag,6,arbreVide());
		a = new ArbreDEntiersPlus(a,10,ad);
		return a;
	}
   
	public static ArbreDEntiersPlus arbreEnonceAvecUnNoeudEnMoins(){
		ArbreDEntiersPlus ag = new ArbreDEntiersPlus(11);
		ArbreDEntiersPlus ad = new ArbreDEntiersPlus();
		ad = new ArbreDEntiersPlus(ag,15,ad);
		ag = new ArbreDEntiersPlus(2);	
		ArbreDEntiersPlus a = new ArbreDEntiersPlus(ag,7,ad);
		ad = new ArbreDEntiersPlus(11);
		ag = new ArbreDEntiersPlus(arbreVide(),8,ad);
		ad = new ArbreDEntiersPlus(ag,6,arbreVide());
		a = new ArbreDEntiersPlus(a,10,ad);
		return a;
	}
	public static void main(String[] args) {
		System.out.println("******************************");
		System.out.println("Programme Test Arbres Binaires");
		System.out.println("******************************");
		int choix= 0;
		do {
			System.out.println("1 -> Tester la methode nombreOccurrences()");
			System.out.println("2 -> Tester la methode estPresent()");
			System.out.println("3 -> Tester la methode nombrePositifs()");
			System.out.println("4 -> Tester la methode tousPositifs()");
			System.out.println("5 -> Tester la methode nombreFeuilles()");
			System.out.println("6 -> Tester la methode nombreNoeudsInternes()");
			System.out.println("7 -> Tester la methode equals()");
			System.out.println("8 -> Tester la methode toString()");
		//	System.out.println("9 -> Tester la methode contientExAequos()");	
		//	System.out.println("10 -> Tester la methode maximum()");
		//	System.out.println("11 -> Tester la methode minimum()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix=scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreOccurrences();	
				break;
			case 2:
				testEstPresent();
				break;	
			case 3:
				testNombrePositifs();
				break;
			case 4:
				testTousPositifs();
				break;
			case 5:
				testNombreFeuilles();
				break;
			case 6:
				testNombreNoeudsInternes();
				break;
			case 7:
				testEquals();
				break;
			case 8:
				testToString();
				break;
//			case 9:
//				testContientExAequos();
//				break;
//			case 10:
//				testMaximum();
//				break;
//			case 11:
//				testMinimum();
//				break;
	
			default:
				break;
			}
		}while (choix >= 1 && choix <= 11);
	}
	
		
	

	private static void testTousPositifs() {
		System.out.println("test 1 : arbre vide");
		assertEquals("tousPositifs ko ",true,arbreVide().tousPositifs());
		System.out.println("test 2 : arbre propose");
		ArbreDEntiersPlus a = arbreEnonce();
		assertEquals("tousPositifs ko ",true,a.tousPositifs());
		System.out.println("test 3 : arbre avec un negatif");
		a = arbreEnonceAvecUnNegatif();
		assertEquals("tousPositifs ko ",false,a.tousPositifs());		
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
	}

	private static void testNombrePositifs() {
		ArbreDEntiersPlus a;
		System.out.println("test 1 : arbre vide");
		a = arbreVide();
		assertEquals("nombrePositifs ko ",0,a.nombrePositifs());
		System.out.println("test 2 : arbre propose");
		a = arbreEnonce();
		assertEquals("nombrePositifs ko ",9,a.nombrePositifs());
		System.out.println("test 3 : arbre avec un negatif");
		a = arbreEnonceAvecUnNegatif();
		assertEquals("nombrePositifs ko ",8,a.nombrePositifs());	
		System.out.println("test 4 : arbre avec deux negatifs");
		a = arbreEnonceAvecDeuxNegatifs();
		assertEquals("nombrePositifs ko ",7,a.nombrePositifs());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
		
	}

	private static void testNombreNoeudsInternes(){
		ArbreDEntiersPlus a;
		System.out.println("test 1 : arbre vide");
		a = arbreVide();
		assertEquals("nombre noeuds internes ko ",0,a.nombreNoeudsInternes());
		System.out.println("test 2 : arbre propose");
		a = arbreEnonce();
		assertEquals("nombre noeuds internes ko ",5,a.nombreNoeudsInternes());
		System.out.println("Tous les tests ont reussi");
		System.out.println();
    }
	
	private static void testNombreFeuilles(){
		ArbreDEntiersPlus a;
		System.out.println("test 1 : arbre vide");
		a = arbreVide();
		assertEquals("nombre feuilles ko ",0,a.nombreFeuilles());
		System.out.println("test 2 : arbre propose");
		a = arbreEnonce();
		assertEquals("nombre feuilles ko ",4,a.nombreFeuilles());
		System.out.println("Tous les tests ont reussi");
		System.out.println();
    }
	
	private static void testEstPresent(){
		System.out.println("test 1 : arbre vide");
		assertEquals("estPresent ko ",false,arbreVide().estPresent(5));
		System.out.println("test 2 : arbre propose");
		ArbreDEntiersPlus a = arbreEnonce();
		assertEquals("estPresent 5 ko ",false,a.estPresent(5));
		assertEquals("estPresent 10 ko ",true,a.estPresent(10));
		assertEquals("estPresent 11 ko ",true,a.estPresent(11));
		assertEquals("estPresent 17 ko ",true,a.estPresent(17));
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}
	
	private static void testNombreOccurrences(){
		System.out.println("test 1 : arbre vide");
		assertEquals("nombre occurrences ko ",0, arbreVide().nombreOccurrences(5));	
		System.out.println("test 2 : arbre propose");
		ArbreDEntiersPlus a = arbreEnonce();
		assertEquals("nombre occurrences 5 ko ",0,a.nombreOccurrences(5));
		assertEquals("nombre occurrences 6 ko ",1,a.nombreOccurrences(6));
		assertEquals("nombre occurrences 17 ko ",1,a.nombreOccurrences(17));
		assertEquals("nombre occurrences 11 ko ",2,a.nombreOccurrences(11));
      ArbreDEntiersPlus b = arbreEnonceAvecDoublon();
      assertEquals("nombre occurrences 6 ko ",2,b.nombreOccurrences(6));
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}


//	private static void testMinimum(){
//		ArbreDEntiers a;
//		System.out.println("test 1 : arbre vide");
//		a = arbreVide();
//		assertEquals("minimum ko ",-1,a.minimum());
//		System.out.println("test 2 : arbre propose");
//		a = arbreEnonce();
//		assertEquals("minimum ko ",2,a.minimum());
//		System.out.println("Tous les tests ont reussi");
//		System.out.println();
//	}
//
//	private static void testMaximum(){
//		ArbreDEntiers a;
//		System.out.println("test 1 : arbre vide");
//		a = arbreVide();
//		assertEquals("maximum ko ",-1,a.maximum());
//		System.out.println("test 2 : arbre propose");
//		a = arbreEnonce();
//		assertEquals("maximum ko ",17,a.maximum());
//		System.out.println("Tous les tests ont reussi");
//		System.out.println();
//
//	}

	
	private static void testEquals() {
		ArbreDEntiersPlus a1,a2,a3;
		System.out.println("test 1 : arbre vide = arbre vide");
		a1 = arbreVide();
		a2 = arbreVide();
		assertEquals("equals ko ",true,a1.equals(a2));
		System.out.println("test 2 : arbre vide = arbre propose");
		a2 = arbreEnonce();
		assertEquals("equals ko ",false,a1.equals(a2));
		System.out.println("test 3 : arbre propose = arbre vide");
		assertEquals("equals ko ",false,a2.equals(a1));
		System.out.println("test 4 : arbre propose = arbre propose");
		a1 = arbreEnonce();
		assertEquals("equals ko ",true,a1.equals(a2));
		System.out.println("test 5 : arbre propose = arbre propose avec un noeud de moins");
		a1 = arbreEnonce();
		a2 = arbreEnonceAvecUnNoeudEnMoins();
		assertEquals("equals ko ",false,a1.equals(a2));
		System.out.println("test 6 : arbre propose avec un noeud en moins = arbre propose");
		assertEquals("equals ko ",false,a2.equals(a1));
		System.out.println("test 7 : arbre propose avec deux valeurs permutées = arbre propose");
		a2 = arbreEnonce();
		a3 = arbreEnonceAvecPermutation();
		assertEquals("equals ko ",false,a2.equals(a3));
		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testToString() {
		ArbreDEntiersPlus a;
		System.out.println("test 1 : arbre vide");
		a = arbreVide();
		assertEquals("toString() ko "," ",a.toString());
		System.out.println("test 2 : arbre propose");
		a = arbreEnonce();
		assertEquals("toString() ko ","((2,7,(11,15,17)),10,(( ,8,11),6, ))",a.toString());
		System.out.println("Tous les tests ont reussi");
		System.out.println();	
		
	}
	
//	private static void testContientExAequos() {
//		ArbreDEntiers a;
//		System.out.println("test 1 : arbre vide");
//		a = arbreVide();
//		assertEquals("contient ex-aequos ko ",false,a.contientExAequos());
//		System.out.println("test 2 : arbre propose");
//		a = arbreEnonce();
//		assertEquals("contient ex-aequos ko ",true,a.contientExAequos());
//		System.out.println("test 3 : arbre sans ex-aequo");
//		a = arbreEnonceAvecUnNegatif();
//		assertEquals("contient ex-aequos ko ",false,a.contientExAequos());	
//		System.out.println("Tous les tests ont reussi");
//		System.out.println();	
//	}

}
