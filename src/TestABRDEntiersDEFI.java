
public class TestABRDEntiersDEFI {
	
	public static ABRDEntiers arbreEnonce(){
		ABRDEntiers a = new ABRDEntiers();
		a.insere(8);
		a.insere(4);
		a.insere(2);
		a.insere(6);
		a.insere(5);
		a.insere(7);
		a.insere(12);
		a.insere(9);
		a.insere(11);
		return a;
	}
	
	
	public static ABRDEntiers arbreVide(){
		return new ABRDEntiers();
	}

	public static void main(String[] args) {
		System.out.println();
		System.out.println("test toArray()");
		System.out.println("test1 : arbre enonce");
		ABRDEntiers a = arbreEnonce();
		int[] t = a.toArray();
		int[] tSol = {2,4,5,6,7,8,9,11,12};
		if(t.length!=9){
			System.out.println("test1 ko");
			System.exit(0);
		}
		for (int i = 0; i < t.length; i++) {
			if(t[i]!=tSol[i]){
				System.out.println("test1 ko");
				System.exit(0);
			}
		}

		System.out.println("test2 : arbre vide");
		a = arbreVide();
		t = a.toArray();
		if(t.length!=0){
			System.out.println("test2 ko");
			System.exit(0);
		}
		
		System.out.println();
		System.out.println("Tous les tests proposes ont reussi");
		
	}
}
