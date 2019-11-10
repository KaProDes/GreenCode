import java.nio.file.Files;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
public class LogIn{
  static List<String> results = new ArrayList<String>();
  static File[] files = new File("C:\\Users\\SnowyKay\\Desktop\\desksort\\sourcecodes\\Java\\ClassCodes\\FinalCopy\\Users").listFiles();

  static int existenceOperator(String username){
    for (File file : files) {
      results.add(file.getName());
    }
    int exists = 0;
    username+=".txt";
    for(String s:results){
      if(s.equals(username)){
        exists = 1;
        }
    }
    return exists;
    }
}
