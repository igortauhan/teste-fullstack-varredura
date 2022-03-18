package com.igortauhan.prbase.models;

import javax.persistence.*;

@Entity
@Table(name = "tb_keyvalues")
public class KeyValues {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String key;
    private String value;

    public KeyValues() {

    }

    public KeyValues(Long id, String key, String value) {
        this.id = id;
        this.key = key;
        this.value = value;
    }
}
