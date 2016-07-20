import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iciuta on 7/19/2016.
 */
public class FileReverser {
    private static final String SPACE = " ";
    private static final String REVERSE_LABEL = "reversed_";

    public static void reverse(String filename) {
        List<String> content = fileToLines(filename);
        List<String> reversedContent = reverseLines(content);
        linesToFile(filename, reversedContent);
    }

    private static List<String> fileToLines(String filename) {
        List<String> fileLines = new ArrayList<>();

        try(FileReader fileReader = new FileReader(filename)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                fileLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileLines;
    }

    private static void linesToFile(String filename, List<String> lines) {
        String newFilename = REVERSE_LABEL + filename;
        try(FileWriter fileWriter = new FileWriter(newFilename)) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.append(System.lineSeparator());
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> reverseLines(List<String> lines) {
        List<String> reversedFile = new ArrayList<>();

        for(int i = lines.size() - 1; i >= 0; i--) {
            reversedFile.add(reverseLine(lines.get(i)));
        }

        return reversedFile;
    }

    private static String[] splitLine(String line) {
        return line.split(SPACE);
    }

    private static String reverseLine(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = splitLine(line);

        for(int i = words.length - 1; i >= 0; i--)
            stringBuilder.append(words[i]).append(SPACE);

        return stringBuilder.toString();
    }
}
