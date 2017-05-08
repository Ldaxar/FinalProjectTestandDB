package utilities;

import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;


public class DataScrapper {

    public static void main(String[] args) throws IOException {
        String target_dir = "/Users/Stargarth/Desktop/testBook";
        File dir = new File(target_dir);
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File[] files = dir.listFiles(textFilter);


        
        for (File f : files) {
        	//System.out.println(f.getName() +" new file");
            if(f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(
                            new FileReader(f));
                    String line;
                    String city="";

                    while ((line = inputStream.readLine()) != null) 
                    {
                    //	System.out.println(line + " line");
                    	int length=line.length();
                    	for(int i=0;i<length;i++)
                    	{
                    		int as2=(int)line.charAt(i);
                    		
                    		int asciiValue=(int)line.charAt(i);
                    		if (asciiValue>=65 && asciiValue<=90)
							{
								int index=i+1;
								if (index>=length) break;
								city+=line.charAt(i);
								asciiValue=(int)line.charAt(index);
								// ((asciiValue>=65 && asciiValue<=90) || (asciiValue>=97 && asciiValue<=122))
								//while(line.charAt(index)!=' ')
								while((asciiValue>=65 && asciiValue<=90) || (asciiValue>=97 && asciiValue<=122))
								{
									city+=line.charAt(index);
									index+=1;
									if (index>=length) break;
									asciiValue=(int)line.charAt(index);
								}
								System.out.println(city);
								city="";
								i=i+(index-i);
							}
                    	}



                      //  System.out.println(line);
                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            }
        }
    }

}
