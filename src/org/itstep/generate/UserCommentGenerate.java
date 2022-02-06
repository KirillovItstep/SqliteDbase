package org.itstep.generate;

import com.opencsv.CSVWriter;
import org.itstep.model.UserComment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class UserCommentGenerate {
    public static void main(String[] args) {
        writeToCsv();
    }

    public static void writeToCsv() {
        File file = new File("src/org/itstep/data/user_comment.csv");
        try (FileWriter outputfile = new FileWriter(file)) {
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"date_stamp", "user_id", "comment_id"};
            writer.writeNext(header);

            Stream.iterate(1, t -> t++)
                    .map(t -> generate())
                    .limit(10000)
                    .map(p -> new String[]{p.getDate(),
                            Integer.toString(p.getUser_id()), Integer.toString(p.getComment_id())})
                    .forEach(writer::writeNext);

            // closing writer connection
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static UserComment generate() {
        //Случайная дата
        long aDay = TimeUnit.DAYS.toMillis(1);
        long now = new Date().getTime();
        Date tenYearsAgo = new Date(now - aDay * 365 * 10);
        Date tenDaysAgo = new Date(now - aDay * 10);
        Date date = between(tenYearsAgo, tenDaysAgo);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = dateFormat.format(date);

        //Пользователь
        int min = 1, max = 1000;
        int user_id = (int) ((Math.random() * (max - min)) + min);

        //Комментарий
        min = 1;
        max = 8000;
        int comment_id = (int) ((Math.random() * (max - min)) + min);

        UserComment userComment = new UserComment(strDate, user_id, comment_id);
        return userComment;
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
