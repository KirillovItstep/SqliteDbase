package org.itstep.model;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Passport {
    private String name;
    private int user_id;

    public Passport(String name, int user_id) {
        this.name = name;
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public int getUser_id() {
        return user_id;
    }
}