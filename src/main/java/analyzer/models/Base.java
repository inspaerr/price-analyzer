package analyzer.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Base", schema = "public")
public class Base {
    @Column(name = "price")
    private Long price;
    @Column(name = "time")
    private Date time;

    @Id
    @SequenceGenerator(name = "base_seq", sequenceName = "base_sequence", allocationSize = 1)
    @GeneratedValue(generator = "base_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "product_in_base",
            joinColumns = { @JoinColumn(name = "base_id") },
            inverseJoinColumns = { @JoinColumn(name = "product_id") }
    )
    List<Product> products;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "shop_in_base",
            joinColumns = { @JoinColumn(name = "base_id") },
            inverseJoinColumns = { @JoinColumn(name = "shop_id") }
    )
    List<Shop> shops;


    public Base() {
    }

    public Base(Long price, Date time, List<Shop> shops, List<Product> products, long id) {
        this.price = price;
        this.time = time;
        this.shops = shops;
        this.products = products;
        this.id = id;
    }

    public Base(Long price, Date time, List<Shop> shops, List<Product> products) {
        this.price = price;
        this.time = time;
        this.shops = shops;
        this.products = products;
    }

}