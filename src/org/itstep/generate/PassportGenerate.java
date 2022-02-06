package org.itstep.generate;

import com.opencsv.CSVWriter;
import org.itstep.model.Purchase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class PassportGenerate {
    public static void main(String[] args) {
        writeToCsv();
    }

    public static void writeToCsv() {
        File file = new File("src/org/itstep/data/passport.csv");
        try (FileWriter outputfile = new FileWriter(file)) {
            CSVWriter writer = new CSVWriter(outputfile);
            // adding header to csv
            String[] header = {"number"};
            writer.writeNext(header);

            new Random().ints(1000, 1000000, 9999999)
                    .mapToObj(r -> new String[]{"MP" + Integer.toString(r)})
                    .forEach(writer::writeNext);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);
        return new Date(randomMillisSinceEpoch);
    }
}
