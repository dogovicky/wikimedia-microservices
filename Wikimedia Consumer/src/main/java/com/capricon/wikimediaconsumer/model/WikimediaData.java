package com.capricon.wikimediaconsumer.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "wikimedia_data")
@Data
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob // Used when storing large datasets
    private String wikiEventData;

}
