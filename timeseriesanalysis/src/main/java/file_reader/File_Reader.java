package file_reader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class File_Reader {

    public List<Double> getData() {

        List<Double> result = new ArrayList<>();

        try(RandomAccessFile randomAccessFile = new RandomAccessFile("one_year_data2.csv", "r")) {

            String line;
            boolean isFirstLine = true;

            while((line = randomAccessFile.readLine()) != null) {
                String[] split = line.split(",");
                if (!isFirstLine) {
                    result.add(Double.valueOf(split[7]));
                }
                isFirstLine = false;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
