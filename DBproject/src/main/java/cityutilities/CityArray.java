package cityutilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

import utilities.FileHelper;

public class CityArray 
{
	Hashtable<String, ArrayList<String>> alphabeticCities = new Hashtable<String, ArrayList<String>>();
	
	public CityArray(String target_dir) throws IOException
	{
		File[] files = FileHelper.getTxtFilesFromFolder(target_dir);
		for (File f : files) {
            if(f.isFile()) {
                BufferedReader inputStream = null;

                try {
                    inputStream = new BufferedReader(
                            new FileReader(f));
                    String line;
                    String city="";
                    String key="a";
                    String firstChar;
                    ArrayList<String> currCities=null;
                    
                    while ((line = inputStream.readLine()) != null) 
                    {
                    	//System.out.println("1 "+line);
                    	firstChar=line.charAt(0)+"";
                    	if(!key.equals(firstChar)) 
                    	{
                    		if (currCities!=null) alphabeticCities.put(key, currCities);
                    		currCities= new ArrayList<String>();
                    		key=firstChar;	
                    	}
                    	else
                    	{
                    		if (currCities!=null)
                    		{
                    			currCities.add(line);
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
	
	public void addCities (String key, ArrayList<String> cities)
	{
		alphabeticCities.put(key, cities);
	}
	
	public boolean contains(String city)
	{
		ArrayList subCollection= alphabeticCities.get(city.charAt(0)+"");
		if (subCollection!=null) return subCollection.contains(city);
		return false;
			
		
		//return alphabeticCities.get(city.charAt(0)+"").contains(city);
		

		
	}
	
	public ArrayList<String> getCities (String key)
	{
		return alphabeticCities.get(key);
	}
	
	public void printColection()
	{
		Set<String> keys = alphabeticCities.keySet();
        for(String key: keys)
        {
        	ArrayList<String> al = alphabeticCities.get(key);
            System.out.println("SECTION " +key);
            for (String object : al) {
				System.out.println("	"+object);
			}
        }
	}
	
}
