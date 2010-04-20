package no.java.cms.tags.cms;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;

public class GetAtom extends SimpleTagSupport {
    public String url;
    public String var;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVar(String var) {
        this.var = var;
    }

    // -----------------------------------------------------------------------
    // Simple Tag Implementation
    // -----------------------------------------------------------------------

    public void doTag() throws JspException, IOException {
        System.out.println("GetAtom.doTag");
        System.out.println("url = " + url);
        List<AtomEntry> entries = new ArrayList<AtomEntry>();
        entries.add(new AtomEntry(new Date(), null, "Trygve er kul", "Ja, det stemmer!"));
        AtomDocument document = new AtomDocument(entries);
        getJspContext().setAttribute(var, document);
    }
}
