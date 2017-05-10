package utilities;

import java.io.File;
import java.io.FilenameFilter;

public class FileHelper 
{
	public static File[] getTxtFilesFromFolder (String target_dir)
	{
        File dir = new File(target_dir);
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        return dir.listFiles(textFilter);
	}

}
