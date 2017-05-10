package entities;

import java.util.ArrayList;
import java.util.List;

public class Book 
{
	int id;
	String title;
	String author;
	String language;
	List<String> cities = new ArrayList<String>();
	
	public Book(int id, String title,String author, String language)
	{
		this.id=id;
		this.title=title;
		this.author=author;
		this.language=language;
	}
	public Book(int id)
	{
		this.id=id;
	}
	
	public void addCity(String city)
	{
		if (!cities.contains(city)) cities.add(city);
	}
	
	public void setTitle(String title)
	{
		this.title=title;
	}
	
	public void setAuthor(String author)
	{
		this.author=author;
	}
	
	public void setLanguage(String language)
	{
		this.language=language;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", language=" + language + ", cities="
				+ "("+citiesToString()+")" + "]";
	}
	
	public String citiesToString()
	{
		String container=cities.get(0);
		for (int i=1;i<cities.size();i++) container+=", "+cities.get(i);
		return container;
	}
	
//	public String toString()
//	{
//		return author;
//		
//	}
	
	
	
}
