package com.sustc.data.utils;

import java.util.Date;

public class CargoFile {
    private String id;

    private Date created;
    private Date updated;

    private String epc;
    private String raw;
    private String del;

    public CargoFile() {
    }

    public CargoFile(Date created, Date updated, String epc, String raw, String del) {
//        this.id = id;
        this.created = created;
        this.updated = updated;
        this.epc = epc;
        this.raw = raw;
        this.del = del;
    }

    @Override
    public String toString() {
        return "CargoFile{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }
}
