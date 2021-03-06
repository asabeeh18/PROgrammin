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

class MangaDownloader {

    public static void main(String ar[]) throws IOException
    {
        int err = 0;
        String domain = "http://www.hbrowse.com/";
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

        try
        {
            mainList = Jsoup.connect("http://www.hbrowse.com/browse/role/tutor/rank/DESC")
                    .cookie("thumbnails", 2 + "")
                    .timeout(50 * 1000)
                    .get();
            //Adjusting to the new site format

        } catch (Exception e)
        {
            System.out.println("FATAL ERROR!! Enter the URL <");
            e.printStackTrace();
        }
        //System.out.println(" "+mainList.toString());
        Elements mangaList = mainList.getElementsByClass("browseDescription");

        for (int i = 0; i < 10; i++)
        {

            //PrintWriter writer = new PrintWriter("manga"+i, "UTF-8");
            Element manga = mangaList.get(i);

            Elements link = manga.getElementsByAttribute("href");
            String desc = link.get(0).toString();
            String folder = desc.substring(81, desc.length() - 11) + " " + i;

            File dir = new File(folder);
            dir.mkdir();

            String code = desc.substring(32, 37) + "/";
            //System.out.println(code+"");
            //s=f.getAttribute("href")
            Document inManga = Jsoup.connect(domain + code).get();

            Elements countChapters = inManga.getElementsByClass("listRight");
            for (int j = 0; j < countChapters.size(); j++)
            {
                Elements href = countChapters.get(j).getElementsByAttribute("href");
                String thumbUrl = href.toString().substring(9, 55);
                // System.out.println(thumbUrl);
                Document thumbs;
                try
                {
                    thumbs = Jsoup.connect(thumbUrl).get();
                } catch (IOException e)
                {
                    e.printStackTrace();
                    System.out.println("Error at Manga: " + i + " Chapter: " + j + " URL:" + thumbUrl);
                    continue;
                }
                Elements smallPics = thumbs.select("img[src^=" + domain + "data/" + code + "]");
                //("src", "http://www.hbrowse.com/data/10350/");
                //System.out.println(smallPics.get(0).toString());
                for (int k = 0; k < smallPics.size(); k++)
                {
                    int start = smallPics.get(k).toString().indexOf("http");
                    int end = smallPics.get(k).toString().lastIndexOf(".jp");
                    StringBuffer imgUrl = new StringBuffer(smallPics.get(k).toString().substring(start, end + 4));

                    int index = imgUrl.indexOf("zzz");
                    String finalUrl = imgUrl.delete(index, index + 4).toString();
                    //writer.println(finalUrl);
                    //System.out.println(finalUrl);
                    while (true)
                    {
                        try (InputStream in = new URL(finalUrl).openStream())
                        {
                            System.out.println("Downloaded " + j + "c" + k + ".jpg");
                            Files.copy(in, Paths.get(folder + "/" + j + "c" + k + ".jpg"));
                            break;
                        } catch (Exception e)
                        {
                            err++;
                            e.printStackTrace();
                            System.out.println("HAGA NA---error count: " + err + "-- " + i + " " + j + " " + k);
                        }
                    }

                    //alert(countChapters+"");
                }
                //System.out.println();
            }
            //System.out.println("\n");
            //System.out.println("\n");
            //writer.close();
        }
    }
}
