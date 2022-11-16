
public class TestExpressionArithmetique {
	
	public static void main(String[] args) {
		 
		ExpressionArithmetique ag = new ExpressionArithmetique('3');
		ExpressionArithmetique ad = new ExpressionArithmetique('2');
		ExpressionArithmetique a = new ExpressionArithmetique('-',ag,ad);
			
		ag = new ExpressionArithmetique('9');
		ad = new ExpressionArithmetique('3');		
		ad = new ExpressionArithmetique('/',ag,ad);
		ag = new ExpressionArithmetique('4');
		ad = new ExpressionArithmetique('*',ag,ad);
		a = new ExpressionArithmetique('+',a,ad);
		
		ExpressionArithmetique ex = a;
		System.out.println("l'expression est : "+ ex.notationInfixe());
		System.out.println("le resultat est : "+ ex.resultat());
		
		// DEFIS
		
//		ex = new ExpressionArithmetique("");
//		System.out.println("l'expression est : "+ ex.notationInfixe());
		
//		System.out.println("exp KO1");
//		ag = new ArbreDeCaracteres('3');
//		ad = new ArbreDeCaracteres();	// operateur unaire
//		a = new ArbreDeCaracteres('-',ag,ad);
//			
//		ag = new ArbreDeCaracteres('9');
//		ad = new ArbreDeCaracteres('3');		
//		ad = new ArbreDeCaracteres('/',ag,ad);
//		ag = new ArbreDeCaracteres('4');
//		ad = new ArbreDeCaracteres('*',ag,ad);
//		a = new ArbreDeCaracteres('+',a,ad);
//		try{
//		ExpressionArithmetique exKO1 = new ExpressionArithmetique(a);
//		}catch (IllegalArgumentException e){
//			System.out.println("IllegalArgumentException");
//		}
//		
//		System.out.println("exp KO2");
//		ag = new ArbreDeCaracteres('3');
//		ad = new ArbreDeCaracteres('2');	
//		a = new ArbreDeCaracteres('-',ag,ad);
//			
//		ag = new ArbreDeCaracteres('9');
//		ad = new ArbreDeCaracteres('3');		
//		ad = new ArbreDeCaracteres('7',ag,ad); // chiffre dans un noeud
//		ag = new ArbreDeCaracteres('4');
//		ad = new ArbreDeCaracteres('*',ag,ad);
//		a = new ArbreDeCaracteres('+',a,ad);
//		try{
//		ExpressionArithmetique exKO12 = new ExpressionArithmetique(a);
//		}catch (IllegalArgumentException e){
//			System.out.println("IllegalArgumentException");
//		}
//     
//		
//		System.out.println("exp KO3");
//		ag = new ArbreDeCaracteres('3');
//		ad = new ArbreDeCaracteres('2');	
//		a = new ArbreDeCaracteres('-',ag,ad);
//			
//		ag = new ArbreDeCaracteres('9');
//		ad = new ArbreDeCaracteres('3');		
//		ad = new ArbreDeCaracteres('/',ag,ad); 
//		ag = new ArbreDeCaracteres('4');
//		ad = new ArbreDeCaracteres('*',ag,ad);
//		a = new ArbreDeCaracteres('!',a,ad); //pas un operateur connu
//		try{
//		ExpressionArithmetique exKO3 = new ExpressionArithmetique(a);
//		}catch (IllegalArgumentException e){
//			System.out.println("IllegalArgumentException");
//		}
//     
      }
}
