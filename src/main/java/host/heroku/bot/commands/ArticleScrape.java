package host.heroku.bot.commands;

import java.util.*;
import java.util.*;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.entity.Icon;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.entity.user.User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Random;

import java.awt.*;
public class ArticleScrape{
	private String article;
	private String link;
	private String title;
	private String articleText;
	private Document document;
	public ArticleScrape() {
		this.article = "placeholder";
		this.title = "placeholder";
		this.link = "placeholder";
		this.articleText = "placeholder";
		readyArticle();
	}
	/*This is method fetches the summary of the article*/
	public String getText(){
		return this.articleText;
	}
	public void setArticleText(Document document){
		String text = "";

		if (getLink().contains("wsj")){
			text = getDocument().select(".wsj-snippet-body").select("p").text();
		} else {
			text = getDocument().select(".Article").select("p").text();
		}
		String[] summary = text.split("\\s+");
		String[] temp = new String[summary.length];
		StringBuffer sum = new StringBuffer();
		int j = 0;
		while ( j < temp.length && j < 60){
			temp[j] = summary[j];
			j++;
		}
		for(int i = 0; i < temp.length; i++) {
			if ( i >= 60){
				break;
			}
			sum.append(temp[i]+" ");
		}
		text = sum.toString();
		this.articleText = text;
	}
	/* For each article or Scrapper should obtain the following:
	 * 1. Title
	 * 2. Summary
	 * 3. Link to article
	 **/
	public void readyArticle() {
		String title = "";
		String summary = "";
		String url1 = "https://apnews.com/"; //a href
		String url2 = "https://www.nbcnews.com/us-news";
		String url3 = "https://www.wsj.com/";
		String url4 = "https://www.reuters.com/world/";
		String url5 = "https://www.bbc.com/news";
		Random rand = new Random();
		int max = 3;
		int min = 1;
		int random = rand.nextInt((max-min)+1)+ min;
		//System.out.println(random);
		try {
			/*This chooses the article based on the random number generated*/
			switch (random){
				case 1: setArticle(url1);
					break;
				case 2: setArticle(url2);
					break;
				case 3: setArticle(url3);
					break;
				case 4: setArticle(url4);
					break;
				case 5: setArticle(url5);
					break;
			}
			setDocument(getArticle());
			Elements allLinks = null;
			int size = 0;
			switch (random){
				//where does apnews & wsj keep their articles
				case 1:
				case 3:
					allLinks = getDocument().select("a[href*=article]");
					size = allLinks.size();
					break;
					//where does nbc news keep their articles
				case 2:
					allLinks = getDocument().select("a[href*=news/us-news]");
					size = allLinks.size();
					break;
					//where does wsj news lkeep their articles
				case 4:
					allLinks = getDocument().select("a[href*=americas]");
					break;
				case 5:
					break;

			}
			 //what does this part do??? DOES THIS GET ALL THE LINKS IN THE LANDING PAGE
			//IF SO WE COULD LOOK AT THE TIME AND CHOOSE THE MOSt recent one :) THEN we can get set the link, find the summary
			// set the summary and have our final thingy to present
			String absoluteUrl = "";
			int newMax = 0;
			int newMin = 1;
			for (int z = 0; z < size; z++){
				newMax++;
			}
			if ( size != 0) {
				random = rand.nextInt((newMax - newMin) + 1) + newMax;
			} else {
				random = 0;
			}
			int k = 0;
			for (Element link : allLinks) {
				//System.out.println("Ypp");
				absoluteUrl = link.attr("abs:href"); //DOES THIS GET ALL THE LINKS ON THE LANDING PAGE
				//System.out.println("Absolute URL: " + absoluteUrl);//print out all links obtained
				if (k == random ) {
					break;
				}
				k++;
					//break;
			}

			//Step 1 set link of article
			setLink(absoluteUrl);
			setArticle(absoluteUrl);
			//System.out.println("Absolute URL: " + absoluteUrl);//print out all links obtained
			//Step 2 set document get title & Summary of article
			setDocument(getArticle());
			//Step 3 set text & title
			setTitle(getDocument());
			setArticleText(getDocument());
			//Now article is ready :)

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*Gets article*/
	public String getArticle(){
		return this.article;
	}
	
	/*Sets article*/
	public void setArticle(String article){
		this.article = article;
	}
	
	/*Sets document*/
	public void setDocument(String article){
		try {
			this.document = Jsoup.connect(article).get();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/*return document*/
	public Document getDocument() { return this.document; }
	
	/*sets article title*/
	public void setTitle(Document document){
		this.title = document.title();
	}
	
	/*gets articles title*/
	public String getTitle(){
		return this.title;
	}
	
	/*gets link of article*/
	public String getLink(){
		return this.link;
	}

	/*sets link of article*/
	public void setLink(String link){
		this.link = link;
	}
}
