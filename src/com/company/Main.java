package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.lang.Thread.sleep;

public class Main {

    static Document dowURL, spURL, nasdaqURL;
    static Elements price;

    public static void main(String[] args) throws IOException {
        while (true) {
            dow();
            sp500();
            nasdaq();
            time();
            asleep();
        }
    }

    public static void dow() throws IOException {
        dowURL = Jsoup.connect("https://finance.yahoo.com/quote/%5EDJI/?guccounter=1").get();
        Elements price = dowURL.getElementsByAttributeValue("class", "Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)");
        StringBuilder dow = new StringBuilder(price.toString());
        String[] mas = dow.toString().split("");
        dow = new StringBuilder();
        for (int i = 74; i < 83; i++)
            dow.append(mas[i]);
        System.out.println("------------------------");
        System.out.println("DOW JONES " + dow + "$ " );
    }

    public static void sp500() throws IOException {
        spURL = Jsoup.connect("https://finance.yahoo.com/quote/%5EGSPC?p=").get();
        price = spURL.getElementsByAttributeValue("class", "Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)");
        StringBuilder sp = new StringBuilder(price.toString());
        String[] mas = sp.toString().split("");
        sp = new StringBuilder();
        for (int i = 74; i < 82; i++)
            sp.append(mas[i]);
        System.out.println("S&P500 " + sp + "$ " );
    }

    public static void nasdaq() throws IOException {
        nasdaqURL = Jsoup.connect("https://finance.yahoo.com/quote/%5EIXIC?p=").get();
        price = nasdaqURL.getElementsByAttributeValue("class", "Trsdu(0.3s) Fw(b) Fz(36px) Mb(-4px) D(ib)");
        StringBuilder nasdaq = new StringBuilder(price.toString());
        String[] mas = nasdaq.toString().split("");
        nasdaq = new StringBuilder();
        for (int i = 74; i < 83; i++)
            nasdaq.append(mas[i]);
        System.out.println("NASDAQ " + nasdaq + "$ " );
    }

    public static void time(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
    }

    public static void asleep(){
        try {
            sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}