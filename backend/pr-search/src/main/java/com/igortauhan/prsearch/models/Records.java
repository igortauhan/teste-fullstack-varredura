package com.igortauhan.prsearch.models;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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


    public Records() {

    }

    public Records(Long id, String systemId, String owner, String storageId, Boolean inStore, Integer size,
                   Integer accessLevel, Integer type, Integer media, Date added, Date currentDate, String name,
                   String description, Integer xStore, BigInteger simHash, String bucket, String tags, String accessLevelH,
                   String mediaH, String simHashH, String typeH, String randomId, String bucketH,
                   String indexFile, String historyFile, Boolean perfectMatch, String groupField) {
        this.id = id;
        this.systemid = systemId;
        this.owner = owner;
        this.storageid = storageId;
        this.instore = inStore;
        this.size = size;
        this.accesslevel = accessLevel;
        this.type = type;
        this.media = media;
        this.added = added;
        this.date = currentDate;
        this.name = name;
        this.description = description;
        this.xscore = xStore;
        this.simhash = simHash;
        this.bucket = bucket;
        this.tags = tags;
        this.accesslevelh = accessLevelH;
        this.mediah = mediaH;
        this.simhashh = simHashH;
        this.typeh = typeH;
        this.randomid = randomId;
        this.bucketh = bucketH;
        this.indexfile = indexFile;
        this.historyfile = historyFile;
        this.perfectmatch = perfectMatch;
        this.group = groupField;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSystemid() {
        return systemid;
    }

    public void setSystemid(String systemid) {
        this.systemid = systemid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStorageid() {
        return storageid;
    }

    public void setStorageid(String storageid) {
        this.storageid = storageid;
    }

    public Boolean getInstore() {
        return instore;
    }

    public void setInstore(Boolean instore) {
        this.instore = instore;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(Integer accesslevel) {
        this.accesslevel = accesslevel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getXscore() {
        return xscore;
    }

    public void setXscore(Integer xscore) {
        this.xscore = xscore;
    }

    public BigInteger getSimhash() {
        return simhash;
    }

    public void setSimhash(BigInteger simhash) {
        this.simhash = simhash;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAccesslevelh() {
        return accesslevelh;
    }

    public void setAccesslevelh(String accesslevelh) {
        this.accesslevelh = accesslevelh;
    }

    public String getMediah() {
        return mediah;
    }

    public void setMediah(String mediah) {
        this.mediah = mediah;
    }

    public String getSimhashh() {
        return simhashh;
    }

    public void setSimhashh(String simhashh) {
        this.simhashh = simhashh;
    }

    public String getTypeh() {
        return typeh;
    }

    public void setTypeh(String typeh) {
        this.typeh = typeh;
    }

    public String getRandomid() {
        return randomid;
    }

    public void setRandomid(String randomid) {
        this.randomid = randomid;
    }

    public String getBucketh() {
        return bucketh;
    }

    public void setBucketh(String bucketh) {
        this.bucketh = bucketh;
    }

    public String getIndexfile() {
        return indexfile;
    }

    public void setIndexfile(String indexfile) {
        this.indexfile = indexfile;
    }

    public String getHistoryfile() {
        return historyfile;
    }

    public void setHistoryfile(String historyfile) {
        this.historyfile = historyfile;
    }

    public Boolean getPerfectmatch() {
        return perfectmatch;
    }

    public void setPerfectmatch(Boolean perfectmatch) {
        this.perfectmatch = perfectmatch;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<KeyValue> getKeyvalues() {
        return keyvalues;
    }

    public void setKeyvalues(List<KeyValue> keyvalues) {
        this.keyvalues = keyvalues;
    }

    public List<Relations> getRelations() {
        return relations;
    }

    public void setRelations(List<Relations> relations) {
        this.relations = relations;
    }
}
