import com.fasterxml.jackson.databind.*;

import java.io.*;
import java.nio.file.*;

public class JacksonTester {
    public static void main(String args[]) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        //String jsonString = "{\"xSize\":10, \"ySize\":21}";

        byte[] jsonString = Files.readAllBytes(Paths.get("test.txt"));
        //map json to student
        try {
            Config config = mapper.readValue(jsonString, Config.class);

            System.out.println(config.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}