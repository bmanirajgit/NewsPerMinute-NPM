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
public class ArticleScrape {
	private String article;
	private String link;
	private String articleText;
	private Document document;
	public ArticleScrape() {
		this.article = "placeholder";
		this.link = "placeholder";
		this.articleText = "placeholder";
	}
	
	/*This is method fetches the summary/ a paragraph of the article*/
	public String getText( ){
		/* This is just here to obtain all of the text from the article
		 * using whatever scraping library, doesn't get the excerpt yet */
		/*should add another function for scrapper*/
		String text = "";

		text = getDocument().select(".Article").select("p").text();
		String[] summary = text.split("\\s+");
		String[] temp = new String[summary.length];
		StringBuffer sum = new StringBuffer();
		int j = 0;
		while ( j < 60){
			temp[j] = summary[j];
			j++;
		}
		for(int i = 0; i < 60; i++) {
			sum.append(temp[i]+" ");
		}
		text = sum.toString();
		return text;
	}
	/* For each article or Scrapper should obtain the following:
	 * 1. Title
	 * 2. Summary
	 * 3. Link to article
	 **/
	public void readyArticle() {
		String title = "";
		String summary = "";
		String url1 = "https://apnews.com/hub/trending-news?utm_source=apnewsnav&utm_medium=featured"; //a href
		String url2 = "https://www.nbcnews.com/us-news";
		String url3 = "https://www.wsj.com/news/us?mod=nav_left_section";
		String url4 = "https://www.reuters.com/breakingviews";
		String url5 = "https://www.bbc.com/news";
		Random rand = new Random();
		int max = 5;
		int min = 1;
		int random = rand.nextInt((max-min)+1)+ min;
		//System.out.println(random);
		try {
			/*This chooses the article based on the random number generated*/
			switch (1){
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
			switch (1){
				//where does apnews keep their articles
				case 1:
					allLinks = getDocument().select("a[href*=article]");
					break;
					//where does nbc news keep their articles
				case 2:

					break;
					//where does wsj news lkeep their articles
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;

			}
			 //what does this part do??? DOES THIS GET ALL THE LINKS IN THE LANDING PAGE
			//IF SO WE COULD LOOK AT THE TIME AND CHOOSE THE MOSt recent one :) THEN we can get set the link, find the summary
			// set the summary and have our final thingy to present
			for(Element link: allLinks) {
				String absoluteUrl = link.attr("abs:href"); //DOES THIS GET ALL THE LINKS ON THE LANDING PAGE
				//Step 1 set link of article
				setLink(absoluteUrl);
				setArticle(absoluteUrl);
				//System.out.println("Absolute URL: " + absoluteUrl);//print out all links obtained
				break;
			}
			//Step 2 get title & Summary of article
			setDocument(getArticle());
			title = getDocument().title();
			summary = getText();
			System.out.println(title+"\n"+summary+"\n"+getLink());

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
	public Document getDocument() {
		return this.document;
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
