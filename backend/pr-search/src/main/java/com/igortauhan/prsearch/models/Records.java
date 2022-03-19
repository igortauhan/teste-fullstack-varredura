package com.igortauhan.prsearch.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Records {

    private static final Long serialVersionUID = 1L;

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
    private BigInteger simhash;
    private String bucket;
    private List<KeyValue> keyvalues = new ArrayList<>();
    private String tags;
    private List<Relations> relations = new ArrayList<>();
    private String accesslevelh;
    private String mediah;
    private String simhashh;
    private String typeh;
    private List<TagsHValues> tagsh = new ArrayList<>();
    private String randomid;
    private String bucketh;
    private String indexfile;
    private String historyfile;
    private Boolean perfectmatch;
    private String group;
}
