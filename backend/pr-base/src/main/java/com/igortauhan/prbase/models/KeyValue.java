package com.igortauhan.prbase.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_keyvalues")
public class KeyValue {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String key;
    private String value;

    @ManyToOne
    @JoinColumn(name = "records_id")
    private Records records;

    public KeyValue() {

    }

    public KeyValue(Long id, String key, String value, Records records) {
        this.id = id;
        this.key = key;
        this.value = value;
        this.records = records;
    }
}
