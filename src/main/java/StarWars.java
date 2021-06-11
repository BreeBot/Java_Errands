import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class StarWars {

  public static void main(String[] args) throws IOException {

    //Numbers 1 and 2. ArrayList
    File characterNamesFile = new File("src/main/resources/characters.txt");
    Scanner scanner = new Scanner(characterNamesFile);
    List<String> characterNames = new ArrayList<>();

    while (scanner.hasNextLine()) {
      characterNames.add(scanner.nextLine());
    }
    System.out.println("ArrayList of Character Names: " + characterNames);
    characterNames.add("Biggs");
    characterNames.add("Wedge");
    System.out.println("Updated List with Biggs and Wedge: " + characterNames);
    characterNames.add(1, "Darth Vader");
    System.out.println("checking to make sure han is in the right place: " + characterNames);
    characterNames.remove("Han");
    System.out.println("Sadly removing Han: " + characterNames);
    System.out.println("=================================");

    //Hashmap Love. Creating Hasmaps from ArrayLists. Above will be keys and values will be Unknown
    Map<String,String> nameMap = new HashMap<String,String>();

    for(String name : characterNames) {
      nameMap.put(name, "Unknown");
    }
    System.out.println("Hashmap of ArrayList: " + nameMap);
    System.out.println("=================================");

    //create hashmap from jason file. Update values with lastnames and output result

    File lastNamesFile = new File("src/main/resources/last-names.json");
    Map<String,String> lastNamesMap = new HashMap<String,String>();
    ObjectMapper mapper = new ObjectMapper();
    lastNamesMap = mapper.readValue(lastNamesFile,HashMap.class);
    System.out.println("Last Names from Json file: " + lastNamesMap);

    System.out.println("=================================");


    for (String item : nameMap.keySet()) {
      nameMap.putAll(lastNamesMap);
      //System.out.println("NEW" + nameMap);

    }

    System.out.println("Updated lastName to known values: " + nameMap);
    System.out.println("=================================");

    nameMap.remove("Obi-Wan");
    System.out.println("Removed obi" + nameMap);
    System.out.println("=================================");

    //Using your HashMap output only the key for "Antilles"
    //System.out.println("Key for the value = Antilles");


    System.out.println("last names where the firstnames contain L: result should be Organa and Skywalker");
    String charToCheck = "L";
    for(Map.Entry<String, String> nameL : nameMap.entrySet()) {
      if(nameL.getKey().contains(charToCheck)) {
        System.out.println("Last names: " + nameL.getValue());
      }
    }
    System.out.println("=================================");
    System.out.println("Using your HashMap output only the key for Antilles");
    String valToCheck = "Antilles";
    for(Map.Entry<String, String> nameK : nameMap.entrySet()) {
      if(nameK.getValue().contains(valToCheck)) {
        System.out.println("Key for Antilles is: " + nameK.getKey());
      }
    }

  }

}
