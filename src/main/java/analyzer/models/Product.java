package analyzer.models;

import javax.persistence.*;

@Entity
@Table(name = "Products", schema = "public")
public class Product {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Id
    @SequenceGenerator(name = "product_seq", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(generator = "product_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    public Product() {
    }

    public Product(String name, String description, long id) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}

    public String getDescription() {
        return description;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
