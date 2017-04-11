package com.mkyong.datastat.model;

/**
 * Created by Roman_Frolov on 12/28/2016.
 */
public class TableSpaceInfo {

    private String name;
    private String spaceTotal;
    private String spaceUsed;
    private String spaceFree;
    private String spaceFreePct;

    public TableSpaceInfo(String name, String spaceUsed, String spaceFree, String spaceTotal, String spaceFreePct) {
        this.name = name;
        this.spaceUsed = spaceUsed;
        this.spaceFree = spaceFree;
        this.spaceTotal = spaceTotal;
        this.spaceFreePct = spaceFreePct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpaceTotal() {
        return spaceTotal;
    }

    public void setSpaceTotal(String spaceTotal) {
        this.spaceTotal = spaceTotal;
    }

    public String getSpaceUsed() {
        return spaceUsed;
    }

    public void setSpaceUsed(String spaceUsed) {
        this.spaceUsed = spaceUsed;
    }

    public String getSpaceFree() {
        return spaceFree;
    }

    public void setSpaceFree(String spaceFree) {
        this.spaceFree = spaceFree;
    }

    public String getSpaceFreePct() {
        return spaceFreePct;
    }

    public void setSpaceFreePct(String spaceFreePct) {
        this.spaceFreePct = spaceFreePct;
    }

    @Override
    public String toString() {
        return "TableSpaceInfo{" +
                "name='" + name + '\'' +
                ", spaceTotal='" + spaceTotal + '\'' +
                ", spaceUsed='" + spaceUsed + '\'' +
                ", spaceFree='" + spaceFree + '\'' +
                ", spaceFreePct='" + spaceFreePct + '\'' +
                '}';
    }

}