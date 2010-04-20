package no.java.cms.tags.cms;

import java.util.*;

public class AtomDocument {
    public List<AtomEntry> entries;

    public AtomDocument(List<AtomEntry> entries) {
        this.entries = entries;
    }

    public List<AtomEntry> getEntries() {
        return entries;
    }
}
