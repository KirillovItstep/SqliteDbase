package org.itstep.model;

import com.ibm.icu.text.Transliterator;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//com.ibm.icu:icu4j:70.1
//org.xerial:sqlite-jdbc:3.35.0.1
//com.opencsv:opencsv:5.1
//org.glassfish.jaxb:jaxb-jxc:2.3.2
//org.springframework.boot:spring-boot-starter-data-jpa:1.1.0.RELEASE
//com.github.gwenn:sqlite-dialect:0.1.2
//ORM->JPA->Hibernate. Spring boot включает Hibernate
public class User extends Person {

    private String login;
    private String passwordMD5;

    public User(String surname, String name, String patronymic) {
        super(surname, name, patronymic);
        generateLoginPass();
    }

    //Сгенерировать логин и пароль
    public void generateLoginPass() {
        var CYRILLIC_TO_LATIN = "Russian-Latin/BGN";
        Transliterator russianToLatin = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        StringBuilder sb = new StringBuilder();
        sb.append(getSurname());
        sb.append(getName().substring(0, 1));
        sb.append(getPatronymic().substring(0, 1));
        login = russianToLatin.transliterate(sb.toString().toLowerCase());

        String myPassword = "user";

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(myPassword.getBytes());
        byte[] digest = md.digest();
        this.passwordMD5 = DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public String getLogin() {
        return login;
    }

    public String getPasswordMD5() {
        return passwordMD5;
    }

    public boolean isEquals(String password) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();

        return DatatypeConverter.printHexBinary(digest).toUpperCase().equals(getPasswordMD5());
    }
}
