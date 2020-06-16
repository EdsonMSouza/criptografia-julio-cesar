import java.io.FileWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
 
public class GenerateJson {
 
	public void generateJsonFile(DadosArquivoJS dados) {
		
		try {
			

			FileWriter writer = new FileWriter("answer.json");

			ObjectMapper mapper = new ObjectMapper();
			
			String json = mapper.writeValueAsString(dados);
			
			
			writer.append(json);
			
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
	