import com.fasterxml.jackson.databind.ObjectMapper;

public class Principal {
	
	public static void main(String[] args) throws Exception {
		
	
		RequisicaoHTTP rh = new RequisicaoHTTP();
		String json = rh.get("https://api.codenation.dev/v1/challenge/dev-ps/generate-data?"
				+ "token=fea03e5ee88ee1a7a6781050f536d87d733cc6cc");
		
		ObjectMapper mapper = new ObjectMapper();
		DadosArquivoJS dados = mapper.readValue(json, DadosArquivoJS.class);
	
		
		CryptDescrypt dec = new CryptDescrypt();
		dados.setDecifrado(dec.decrypt(dados.getCifrado(), dados.getNumeroCasas()));
		
		
		GeradorSha1 sha1 = new GeradorSha1();
		dados.setResumoCriptografico(sha1.gerarSha1(dados.getDecifrado()));
		
		GenerateJson gj = new GenerateJson();
		gj.generateJsonFile(dados);
		    
		rh.post();
		
		
	}

}
