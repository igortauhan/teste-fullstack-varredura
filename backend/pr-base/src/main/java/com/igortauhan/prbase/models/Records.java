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
    private String systemId;
    private String owner;
    private String storageId;
    private Boolean inStore;
    private Integer size;
    private Integer accessLevel;
    private Integer type;
    private Integer media;
    private Date added;
    private Date currentDate;
    private String name;
    private String description;
    private Integer xStore;
    private BigInteger simHash;
    private String bucket;
    private String tags;
    private String accessLevelH;
    private String mediaH;
    private String simHashH;
    private String typeH;
    private String tagsH;
    private String randomId;
    private String bucketH;
    private String indexFile;
    private String historyFile;
    private Boolean perfectMatch;
    private String groupField;

    @ManyToOne
    @JoinColumn(name = "ativo_id")
    private Ativo ativo;

    @OneToMany(mappedBy = "records")
    private List<KeyValue> keyValue = new ArrayList<>();

    @OneToMany(mappedBy = "records")
    private List<Relations> relations = new ArrayList<>();

    @OneToMany(mappedBy = "records")
    private List<TagsHValues> tagsh = new ArrayList<>();
}
