package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "main")
public class CommentEntity {
    private short id;
    private String comment;

    @Id
    @Column(name = "id", nullable = false)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "comment", nullable = false, length = -1)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return id == that.id &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment);
    }
}
