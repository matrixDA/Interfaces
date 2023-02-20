import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister{

    public ShortLister() {
    }

    public static void main(String[] args) {
        {
            JFileChooser chooser = new JFileChooser();
            File selectedFile;
            String rec = "";
            ArrayList<String> lines = new ArrayList<>();

            final int FIELDS_LENGTH = 1;
            ShortWordFilter filter = new ShortWordFilter();

            String print;
            try
            {

                File workingDirectory = new File(System.getProperty("user.dir"));

                chooser.setCurrentDirectory(workingDirectory);

                if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
                {
                    selectedFile = chooser.getSelectedFile();
                    Path file = selectedFile.toPath();

                    InputStream in = new BufferedInputStream(Files.newInputStream(file, CREATE));
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));


                    int line = 0;
                    while(reader.ready())
                    {
                        rec = reader.readLine();
                        lines.add(rec);
                        line++;

                    }
                    reader.close();

                    String[] fields;
                    for(String l: lines)
                    {
                        fields = l.split(" ");

                        for (String w:fields)
                        {
                            if (filter.accept(w))
                            {
                                System.out.println(w.trim());
                            }
                        }

                    }
                    System.out.println();
                }
                else
                {
                    System.out.println("Failed to choose a file to process");
                    System.out.println("Run the program again!");
                    System.exit(0);
                }
            }  // end of TRY
            catch (FileNotFoundException e)
            {
                System.out.println("File not found!!!");
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
    }

}
