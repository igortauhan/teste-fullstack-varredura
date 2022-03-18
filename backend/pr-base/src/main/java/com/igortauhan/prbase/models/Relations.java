package com.igortauhan.prbase.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_relations")
public class Relations {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String target;
    private Integer relation;

    @ManyToOne
    @JoinColumn(name = "records_id")
    private Records records;

    public Relations() {

    }

    public Relations(Long id, String target, Integer relation, Records records) {
        this.id = id;
        this.target = target;
        this.relation = relation;
        this.records = records;
    }
}
