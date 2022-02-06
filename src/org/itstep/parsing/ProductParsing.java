package org.itstep.parsing;

import com.opencsv.CSVWriter;
import org.itstep.model.Product;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductParsing {
    private static List<Product> products = null;

    public static void main(String[] args) {
        String fileName = "src/org/itstep/data/khity-prodazh.csv";
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            products = stream
                    .map(s -> s.split(";"))
                    .map(s -> new Product(parseName(s[3]), parsePrice(s[6])))
                    .collect(Collectors.toList());

            //for (Product product:products) System.out.println(product);
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file = new File("src/org/itstep/data/product.csv");
        try (FileWriter fileWriter = new FileWriter(file)) {
            CSVWriter writer = new CSVWriter(fileWriter);

            // adding header to csv
            String[] header = {"name", "price"};
            writer.writeNext(header);

            products.stream()
                    .map(p -> new String[]{p.getName(), Integer.toString(p.getPrice())})
                    .forEach(writer::writeNext);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int parsePrice(String s) {
        int result = 0;
        try {
            //System.out.println(s.replaceAll("[^0-9]+",""));
            result = Integer.parseInt(s.replaceAll("[^0-9]+", ""));
        } catch (Exception e) {
        }
        return result;
    }

    public static String parseName(String s) {
        return s.replaceAll("[\"]+", "\'");
    }
}

