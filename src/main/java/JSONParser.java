import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.file.*;

public class JSONParser {
    public JSONParser() {
    }
    public Config jsonParser(String file) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get(file));
        ObjectMapper objectMapper = new ObjectMapper();
        Config config = null;
        try {
            config = objectMapper.readValue(jsonData, Config.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
