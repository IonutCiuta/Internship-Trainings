import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by iciuta on 7/19/2016.
 */
public class FolderViewer {
    private static final String TAB = "\t";
    private static final String EMPTY = " ";
    private static final int BASE_LEVEL = 0;
    private static final String OUTPUT = "out.txt";

    public static void display(String dirname) {
        File start = new File(dirname);
        String result = explore(start, BASE_LEVEL);

        try (FileWriter fileWriter = new FileWriter(OUTPUT)) {
            fileWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String explore(File file, int level) {
        String buffer = getIndent(level) + file.getName() + System.lineSeparator();

        if(file.isDirectory()) {
            File[] content = file.listFiles();
            for(File subfile : content) {
                buffer += explore(subfile, level + 1);
            }
        }

        return buffer;
    }

    private static String getIndent(int level) {
        String indent = EMPTY;
        while(level > 0) {
            indent += TAB;
            level--;
        }
        return indent;
    }
}
