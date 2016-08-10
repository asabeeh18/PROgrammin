package internetutilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.jsoup.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class AnimeDownloader {

    
    public static void main(String ar[]) throws IOException
    {
        int err = 0;
        String domain = "https://www.kissanime.to";
        Document mainList = null;
        try
        {
            System.setProperty("javax.net.ssl.trustStore", "kissanime.jks");
            mainList = Jsoup.connect("https://www.kissanime.to")
                    .timeout(3000000)
                    .followRedirects(true)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36")
                    .get();
            //Adjusting to the new site format

        } catch (Exception e)
        {
            System.out.println("FATAL ERROR!! Enter the URL <");
            e.printStackTrace();
        }
        //System.out.println(" "+mainList.toString());
        Elements mangaList = mainList.getElementsByClass("browseDescription");
        Element videoTag = mainList.getElementById("my_video_1_html5_api");
        Elements vidUrl = videoTag.getElementsByAttribute("src");
        String url = vidUrl.get(0).toString();

        File dir = new File("folder");
        dir.mkdir();

    }
}
