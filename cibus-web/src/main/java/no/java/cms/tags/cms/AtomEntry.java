package no.java.cms.tags.cms;

import java.util.*;

public class AtomEntry {
    public Date published;
    public Date updated;
    public String title;
    public String summary;

    public AtomEntry(Date published, Date updated, String title, String summary) {
        this.published = published;
        this.updated = updated;
        this.title = title;
        this.summary = summary;
    }

    public Date getPublished() {
        return published;
    }

    public Date getUpdated() {
        return updated;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }
}
