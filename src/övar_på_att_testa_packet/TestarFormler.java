package �var_p�_att_testa_packet;

public class TestarFormler {

	public static void main(String[] args) {
		String v�nster = "kalle";
		String h�ger = "Eva";
		String diagram = "";
		
		for (int i = 0; i < v�nster.length(); i++) {
			for (int k = 0; k < (v�nster.length()*2); k++) {
				if((v�nster.length()/(i+1)) == k)
					diagram += "/\n";
				else {
					diagram += " ";
				}
			}
//			System.out.println(diagram);
		}
		System.out.println(diagram);

	}

}
