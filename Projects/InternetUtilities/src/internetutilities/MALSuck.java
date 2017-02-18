package internetutilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class MALSuck
{

    private final static int MAX_MANGA = 33000;

    public static void main(String ar[]) throws IOException
    {
        int err = 0;
        String domain = "http://www.myanimelist.net/";
        Document mainList = null;
        System.setProperty("java.net.preferIPv4Stack", "true");
//        final String authUser = "edcguest";
//        final String authPassword = "edcguest";
//
//        Authenticator.setDefault(
//                new Authenticator() {
//                    @Override
//                    public PasswordAuthentication getPasswordAuthentication()
//                    {
//                        return new PasswordAuthentication(
//                                authUser, authPassword.toCharArray());
//                    }
//                }
//        );
//
//        System.setProperty("http.proxyHost", "172.31.103.29");
//        System.setProperty("http.proxyPort", "3128");
        for (int i = 1; i < MAX_MANGA; i++)
        {
            try
            {
                mainList = Jsoup.connect(getNextURL(i))
                        .timeout(50 * 1000)
                        .get();
                //Adjusting to the new site format

            } catch (Exception e)
            {
                System.out.println("FATAL ERROR!! Enter the URL <");
                e.printStackTrace();
                //save URL to document
            }
            Elements table = mainList.getElementsByClass("js-scrollfix-bottom").get(0).getElementsByTag("div");
            //gets table data
            //System.out.println("--"+table.get(10).child(0).ownText()+":"+table.get(10).ownText());
            
            //stats ka link
            Element hz=mainList.getElementById("horiznav_nav");
            Element s=hz.getElementsContainingOwnText("Stats").get(0);
            
            System.out.println(s.attr("href"));
            store(strip(table));
        }
        //System.out.println(" "+mainList.toString());
        

    }

    private static String getNextURL(int i)
    {
        return "https://myanimelist.net/anime/"+i;
        
    }

    private static String strip(Elements table)
    {
        return "p";
    }

    private static void store(String strip)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
