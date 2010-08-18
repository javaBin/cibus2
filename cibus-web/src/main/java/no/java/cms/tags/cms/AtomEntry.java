package no.java.cms.tags.cms;

import java.util.*;

import static java.util.Collections.unmodifiableMap;

public class AtomEntry {
    public final Date published;
    public final Date updated;
    public final String title;
    public final String summary;
    public final Map<String, AtomLink> linksByRel;

    public AtomEntry(Date published, Date updated, String title, String summary, Map<String, AtomLink> linksByRel) {
        this.published = published;
        this.updated = updated;
        this.title = title;
        this.summary = summary;
        this.linksByRel = unmodifiableMap(new HashMap<String, AtomLink>(linksByRel));
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

    public Map<String, AtomLink> getLinksByRel() {
        return linksByRel;
    }

    public static class AtomLink {
        public final String rel;
        public final String type;
        public final String href;

        public AtomLink(String rel, String type, String href) {
            this.rel = rel;
            this.type = type;
            this.href = href;
        }

        public String getRel() {
            return rel;
        }

        public String getType() {
            return type;
        }

        public String getHref() {
            return href;
        }
    }
}
