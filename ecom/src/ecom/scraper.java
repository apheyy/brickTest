package ecom;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class scraper {
	public static void main(String[] args) throws IOException{
		//generate data from weblink
		Document doc = Jsoup.connect("https://www.tokopedia.com/p/handphone-tablet/handphone")
				.timeout(6000).get();
		
		//move weblink menjadi element
		Elements name = doc.select(".css-1wtrxts");
		Elements price = doc.select(".css-o5uqvq");
		Elements description = doc.select(".css-1wtrxts");
		Elements image = doc.select(".css-t8frx0");
		Elements rating = doc.select(".css-177n1u3");
		Elements merchant = doc.select(".css-1kr22w3");
		
		String line = name.text() + "," + price.text() + "," + description.text() + "," + image.text() + "," 
						+ rating.text() + "," + merchant.text();
		
		
		//convert data to csv file
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("scrapper.csv"), "UTF-8")); 
		StringBuffer oneLine = new StringBuffer();
		oneLine.append(line);
		bw.write(oneLine.toString());
        bw.newLine();
	}
}
