package caching;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Page implements Serializable {

    private String name;
    private String website;
    private long lookupTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getLookupTime() {
        return lookupTime;
    }

    public void setLookupTime(long lookupTime) {
        this.lookupTime = lookupTime;
    }

    @Override
    public String toString() {
        return "Page [name=" + name + ", website=" + website + "]";
    }

}
