package no.java.cms.tags.cms;

import org.dom4j.*;
import org.dom4j.io.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.net.*;

public class GetHtml extends SimpleTagSupport {
    public URL url;
    public String var;

    public void setUrl(String url) throws Exception {
        this.url = new URL(url);
    }

    public void setVar(String var) {
        this.var = var;
    }

    // -----------------------------------------------------------------------
    // Simple Tag Implementation
    // -----------------------------------------------------------------------

    public void doTag() throws JspException, IOException {
        System.out.println("GetHtml.doTag");

        try {
            Document document = new SAXReader().read(url);
            System.out.println("var=" + new HtmlDocument(document));
            getJspContext().setAttribute(var, new HtmlDocument(document));
        } catch (DocumentException e) {
            throw new JspException("Unable to read resource", e);
        }
    }
}
