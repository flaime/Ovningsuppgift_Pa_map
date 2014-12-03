package övar_på_att_testa_packet;

public class TestarFormler {

	public static void main(String[] args) {
		String vänster = "kalle";
		String höger = "Eva";
		String diagram = "";
		
		for (int i = 0; i < vänster.length(); i++) {
			for (int k = 0; k < (vänster.length()*2); k++) {
				if((vänster.length()/(i+1)) == k)
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
