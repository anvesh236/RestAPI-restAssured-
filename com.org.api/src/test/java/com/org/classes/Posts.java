package com.org.classes;

public class Posts {

	private String id;
	private String title;
	private String author;
	private Info info;
	
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info)
	{
		this.info = info;
	}
	public String getID()
	{
		return id;
	}
	public void setID(String id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
		
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public  String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		this.author =author;
	}
}
