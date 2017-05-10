package cityutilities;

import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.io.IOException;

import utilities.FileHelper;

import java.io.File;


public class CityScrapper {

    public static void main(String[] args) throws IOException {
      
        File[] files = FileHelper.getTxtFilesFromFolder("/Users/Stargarth/Desktop/cities");
        for (File f : files) {
            if(f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(
                            new FileReader(f));
                    String line;
                    String city="";
                    
                    int count=0;
                    while ((line = inputStream.readLine()) != null) 
                    {
                    	//System.out.println("1 "+line);
                    	count++;
                    	//if (count>=2) break;
                    	int length=line.length();
                    	for(int i=0;i<length;i++)
                    	{                    		
                    		int asciiValue=(int)line.charAt(i);
                    		if (asciiValue==9)
							{
								int index=i+1;
								if (index>=length) break;
								asciiValue=(int)line.charAt(index);
								while(asciiValue!=9 && asciiValue!=44)
								{
									city+=line.charAt(index);
									index+=1;
									if (index>=length) break;
									asciiValue=(int)line.charAt(index);
								}
								System.out.println(city);
								city="";
								break;
								
							}
                    		
                    	}



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
