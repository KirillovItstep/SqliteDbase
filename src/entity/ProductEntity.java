package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "main")
public class ProductEntity {
    private short id;
    private String name;
    private short price;

    @Id
    @Column(name = "id", nullable = false)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public short getPrice() {
        return price;
    }

    public void setPrice(short price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return id == that.id &&
                price == that.price &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
