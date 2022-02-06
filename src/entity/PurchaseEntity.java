package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "purchase", schema = "main")
public class PurchaseEntity {
    private short id;
    private String dateStamp;
    private short count;

    @Id
    @Column(name = "id", nullable = false)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_stamp", nullable = false, length = -1)
    public String getDateStamp() {
        return dateStamp;
    }

    public void setDateStamp(String dateStamp) {
        this.dateStamp = dateStamp;
    }

    @Basic
    @Column(name = "count", nullable = false)
    public short getCount() {
        return count;
    }

    public void setCount(short count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseEntity that = (PurchaseEntity) o;
        return id == that.id &&
                count == that.count &&
                Objects.equals(dateStamp, that.dateStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateStamp, count);
    }
}
