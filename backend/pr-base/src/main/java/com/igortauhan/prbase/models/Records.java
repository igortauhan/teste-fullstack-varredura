package com.igortauhan.prbase.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_records")
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

    public Records() {

    }

    public Records(Long id, String systemId, String owner, String storageId, Boolean inStore, Integer size,
                   Integer accessLevel, Integer type, Integer media, Date added, Date currentDate, String name,
                   String description, Integer xStore, BigInteger simHash, String bucket, String tags, String accessLevelH,
                   String mediaH, String simHashH, String typeH, String tagsH, String randomId, String bucketH,
                   String indexFile, String historyFile, Boolean perfectMatch, String groupField, Ativo ativo) {
        this.id = id;
        this.systemId = systemId;
        this.owner = owner;
        this.storageId = storageId;
        this.inStore = inStore;
        this.size = size;
        this.accessLevel = accessLevel;
        this.type = type;
        this.media = media;
        this.added = added;
        this.currentDate = currentDate;
        this.name = name;
        this.description = description;
        this.xStore = xStore;
        this.simHash = simHash;
        this.bucket = bucket;
        this.tags = tags;
        this.accessLevelH = accessLevelH;
        this.mediaH = mediaH;
        this.simHashH = simHashH;
        this.typeH = typeH;
        this.tagsH = tagsH;
        this.randomId = randomId;
        this.bucketH = bucketH;
        this.indexFile = indexFile;
        this.historyFile = historyFile;
        this.perfectMatch = perfectMatch;
        this.groupField = groupField;
        this.ativo = ativo;
    }
}
