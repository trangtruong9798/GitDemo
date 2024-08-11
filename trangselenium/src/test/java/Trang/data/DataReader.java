package Trang.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.HashMap;
import org.apache.commons.io.FileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class DataReader {
public  List<HashMap<String, String>> getJasonDataToMap() throws IOException {
	//read json to string
	String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+ "\\src\\test\\java\\Trang\\data\\PurchaseOrder.json"),
			StandardCharsets.UTF_8);
	//String to hashmap jackson databind
	
	ObjectMapper mapper = new ObjectMapper();
	List <HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		
	});
	return data;
}
}
