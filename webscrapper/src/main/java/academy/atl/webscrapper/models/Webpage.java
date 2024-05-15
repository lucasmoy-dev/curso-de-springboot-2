package academy.atl.webscrapper.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "webpage")
public class Webpage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String domain;
    private String url;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;
    private String picture;
    private Integer rank;

}
