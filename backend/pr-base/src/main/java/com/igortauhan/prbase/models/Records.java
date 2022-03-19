package com.igortauhan.prbase.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_records")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Records {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String systemid;
    private String owner;
    private String storageid;
    private Boolean instore;
    private Integer size;
    private Integer accesslevel;
    private Integer type;
    private Integer media;
    private Date added;
    private Date date;
    private String name;
    private String description;
    private Integer xscore;
    private String simhash;
    private String bucket;
    private String tags;
    private String accesslevelh;
    private String mediah;
    private String simhashh;
    private String typeh;
    private String randomid;
    private String bucketh;
    private String indexfile;
    private String historyfile;
    private Boolean perfectmatch;
    private String group;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    @OneToMany(mappedBy = "records")
    private List<KeyValue> keyvalues = new ArrayList<>();

    @OneToMany(mappedBy = "records")
    private List<Relations> relations = new ArrayList<>();

    @OneToMany(mappedBy = "records")
    private List<TagsHValues> tagsh = new ArrayList<>();
}
