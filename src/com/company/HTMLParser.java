package com.company;

import jdk.nashorn.internal.runtime.ParserException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTMLParser
{
    private static String wort = "Борисов";

    public void HTMLParser() throws IOException {
        Document doc = null;
        Element next_game;
        Elements dats;
        try
        {
            doc = Jsoup.connect("http://fcbate.by/fan-zone").get();
        }catch (IOException e)
        {
            System.out.println("Can't connect to HTML page :(");
        }

        try
        {
            next_game = doc.select("#next_game").first();
            dats = next_game.getElementsByTag("p");
            for (Element data : dats)
            {
                String text = data.text();
                if (text.indexOf(wort)!= -1)
                {
                    String secondComand = next_game.select("class.sec-team").text();
                    String firstComand = next_game.select("class.first-team").text();
                    String TimeAndPlace = dats.text();
                }
            }
        }catch (ParserException e)
        {
            System.out.println("Error, can't Parse the Page :(");
        }

    }
}
