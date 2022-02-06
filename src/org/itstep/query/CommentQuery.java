package org.itstep.query;

import org.itstep.model.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Использование JDBC
public class CommentQuery {
    public static void main(String[] args) {
        List<Comment> comments = getComments();
        comments.stream().forEach(c -> System.out.println(c.getComment()));
    }

    public static List<Comment> getComments() {
        List<Comment> comments = new ArrayList<Comment>();
        Comment comment = null;
        Connection conn = Connector.connect();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from comment limit(10);");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment(rs.getString(2), rs.getInt(3));
                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
