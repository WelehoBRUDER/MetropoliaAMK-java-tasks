package Module_3_4.Task_1;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {
    public static final String fileUrl = "https://users.metropolia.fi/~jarkkov/temploki.csv";
    public static final int column = 1;
    public static double averageTemp = 0;
    public static int count = 0;

    public static void main(String[] args) {
        int tempsNeeded = 24 * 6; // 10-min increments so 1 day is 24 times 6 since 60min = 1 hour and 24 hours = 1 day.
        // first, create the url
        URL myUrl;
        try {
            myUrl = new URL(fileUrl);
        } catch (MalformedURLException e) {
            System.err.println(e);
            return;
        }

        try {
            // open the connection and get the input stream
            // it will automatically generate HTTP GET-request
            InputStream istream = myUrl.openStream();

            // jump to character streams
            InputStreamReader istreamreader = new InputStreamReader(istream);

            // and to buffered reader for efficiency
            BufferedReader reader = new BufferedReader(istreamreader);

            // we use StringBuilder for efficiency, concatenating ordinary Strings is slow and
            // generates unnecessary objects
            String line;
            StringBuilder response = new StringBuilder();

            // here we read the content of the web page line by line
            // + 1 because the first line contains the titles, not values.
            while ((line = reader.readLine()) != null && count < tempsNeeded + 1) {
                //response.append(line);
                String[] values = line.split(";");
                if (count > 0) {
                    averageTemp += Double.parseDouble(values[column].replace(",", "."));
                }
                count++;
            }

            averageTemp /= tempsNeeded;

            // now it is time to print the result
            reader.close();
            System.out.println("Average temperature: " + String.format("%.3f", averageTemp) + "C");
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
