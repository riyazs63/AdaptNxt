package com.assign;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Assignment {
	
	
	
	public static void main(String[] args) throws IOException {

	Document doc = Jsoup.connect("https://www.staples.com/Computer-office-desks/cat_CL210795/663ea?icid=BTS:2020:STUDYSPACE:DESKS").get();
		Elements body = doc.select(".grid__row");
		//System.out.println(body.select("div").size());
		
		//System.out.println(body.html());
		FileWriter fw = new FileWriter("Assignment.csv");
		String[] head = {"Product name","Product price"};
		fw.write(String.join(",", head)+"\n");
		for(Element e : body.select("div"))
		{
			String text = e.select("div.standard-tile__title a").text();
			
			System.out.println(text);
			String price = e.select("div.standard-tile__price_wrapper span.").text();
			System.out.println(price);
		
			
			String [] row = {text,price};
			fw.write(String.join(",",row));
	
		}
		
		
		
	}

}
