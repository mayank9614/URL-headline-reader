import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebPageHeadline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the URL: ");
        String url = scanner.nextLine();
        scanner.close();

        try {
            Document document = Jsoup.connect(url).get();
            Elements headlines = document.select("h1, h2, h3, h4, h5, h6");

            System.out.println("Headlines:");
            System.out.println("---------------------");
            System.out.println("| Index |  Headline  |");
            System.out.println("---------------------");

            for (int i = 0; i < headlines.size(); i++) {
                Element headline = headlines.get(i);
                System.out.printf("|  %-5d |  %-10s |\n", i + 1, headline.text());
            }

            System.out.println("---------------------");
        } catch (IOException e) {
            System.out.println("An error occurred while retrieving the webpage.");
            e.printStackTrace();
        }
    }
}
