package com.igortauhan.prbase.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "tb_tagsh")
public class TagsHValues {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty
    private Integer classWithoutH;
    private String classh;
    private String value;
    private String valueh;

    @ManyToOne
    @JoinColumn(name = "records_id")
    private Records records;
}
