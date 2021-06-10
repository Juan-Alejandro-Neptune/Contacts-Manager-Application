import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileIO {
    public static void main(String[] args) {
        Path path = Paths.get("src");
        System.out.println(path);

        Path pathToThisFile = Paths.get("src", "FileIO.java");
        System.out.println(pathToThisFile);
        System.out.println(pathToThisFile.toAbsolutePath());

        Path toOurDataPlace = Paths.get("src/contact");
        Path toOurDataFile = Paths.get(String.valueOf(toOurDataPlace), "contacts.txt");

        try{
            if (Files.notExists(toOurDataPlace)){
                Files.createDirectories(toOurDataPlace);
            }else{
                System.out.println("The " + toOurDataPlace + " directory already exists");
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }

        List<String> animeCharacters = Arrays.asList("Naruto Uzumaki", "Captain Meliodas", "Ban Nanatsu", "Netsuko Kamado", "Tanjiro Kamado");

        try{
            Files.write(toOurDataFile, animeCharacters);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        List<String> currentList = new ArrayList<>();
        try {
            currentList = Files.readAllLines(toOurDataFile);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

}
