
public class CryptDescrypt {
	

	public String decrypt(String cifrado, int numCasas) {

		char[] ch = cifrado.toLowerCase().toCharArray();

		String decript = "";

		for (char c : ch) {

			if (c != ' ' && c != ',' && c != '.') {
				for (int i = 0; i < 5; i++) {
					if (c == 'a') {
						c = 'z';
					} else {
						c--;
					}
				}
			}
			decript += c;
		}
		return decript;

	}

}
