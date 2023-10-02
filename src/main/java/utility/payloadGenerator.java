package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public   class payloadGenerator {

    public static String generateStringPayload(String filename) throws IOException {
        String filepath = System.getProperty("user.dir") + "//src//main//java//resources//" + filename ;
        return  new String(Files.readAllBytes(Paths.get(filepath)));

    }
}
