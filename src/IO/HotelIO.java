package IO;

import Manager.Hotel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HotelIO {
    static File file = new File("hotel.txt");

    public static void writerHotel(List<Hotel> hotels) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Hotel h : hotels) {
                bufferedWriter.write(h.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Hotel> readerHotel(List<Hotel> hotels) {
        List<Hotel> hotelList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str;
                while ((str = bufferedReader.readLine()) !=null) {
                    String[] arr = str.split("-");
                    Hotel hotel = new Hotel(
                            Integer.parseInt(arr[0]),
                            arr[1], arr[2], arr[3]);
                    hotels.add(hotel);
                }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelList;
    }
}
