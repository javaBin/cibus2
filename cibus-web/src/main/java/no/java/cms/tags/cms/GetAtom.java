package no.java.cms.tags.cms;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

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
		
		SyndFeedInput input = new SyndFeedInput();
		try {
			SyndFeed feed = input.build(new XmlReader(new URL(url)));

			for (Object element : feed.getEntries()) {
				SyndEntry entry = (SyndEntryImpl) element;
				entries.add(new AtomEntry(entry.getPublishedDate(), entry
						.getUpdatedDate(), entry.getTitle(), entry
						.getDescription().getValue()));

			}
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        

        AtomDocument document = new AtomDocument(entries);
        getJspContext().setAttribute(var, document);
    }
}
