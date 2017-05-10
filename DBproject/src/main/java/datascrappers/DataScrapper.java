package datascrappers;

import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.BufferedReader;
import java.io.IOException;

import cityutilities.CityArray;
import entities.Book;

import java.io.File;


public class DataScrapper {

    public static void main(String[] args) throws IOException {
    	CityArray ca = new CityArray("/Users/Stargarth/Desktop/cities");
    	String target_dir = "/Users/Stargarth/Desktop/books";
        File dir = new File(target_dir);
        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };
        File[] files = dir.listFiles(textFilter);

        int idCounter=0;
        
        for (File f : files) {
            if(f.isFile()) {
            	idCounter++;
            	Book book = new Book(idCounter);
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(
                            new FileReader(f));
                    String line;
                    String word="";
                    boolean authorFlag=true;
                    boolean languageFlag=true;
                    boolean titleFlag=true;

                    while ((line = inputStream.readLine()) != null) 
                    {
                    	int length=line.length();
                    	for(int i=0;i<length;i++)
                    	{
                    		int as2=(int)line.charAt(i);
                    		
                    		int asciiValue=(int)line.charAt(i);
                    		if (asciiValue>=65 && asciiValue<=90)
							{
								int index=i+1;
								if (index>=length) break;
								word+=line.charAt(i);
								asciiValue=(int)line.charAt(index);
								while((asciiValue>=65 && asciiValue<=90) || (asciiValue>=97 && asciiValue<=122) || (asciiValue==58))
								{
									word+=line.charAt(index);
									index+=1;
									if (index>=length) break;
									asciiValue=(int)line.charAt(index);
								}
								if (ca.contains(word)) book.addCity(word);
								else if (word.toLowerCase().equals("author:") && authorFlag) 
								{
									book.setAuthor(line.substring(8, line.length()));
									authorFlag=false;
								}
								else if (word.toLowerCase().equals("title:") && titleFlag) 
								{
									book.setTitle(line.substring(7, line.length()));
									titleFlag=false;
								}
								else if (word.toLowerCase().equals("language:") && languageFlag) 
								{
									book.setLanguage(line.substring(10, line.length()));
									languageFlag=false;
								}
								word="";
								i=i+(index-i);
							}
                    	}



                    }
                }
                finally {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                System.out.println(book.toString());
                System.out.println("----------------------------------------------------");
            }
        }
    }

}
