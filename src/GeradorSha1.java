import java.math.BigInteger;
import java.security.MessageDigest;

public class GeradorSha1 {

	public String gerarSha1(String txt) {
		try {
	        MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(txt.getBytes("utf8"));
	        return String.format("%040x", new BigInteger(1,digest.digest()));
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }
	
	
}
