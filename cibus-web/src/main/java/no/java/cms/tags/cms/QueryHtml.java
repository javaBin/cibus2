package no.java.cms.tags.cms;

import org.dom4j.*;
import org.dom4j.io.*;
import org.jaxen.*;
import org.jaxen.XPath;
import org.jaxen.dom4j.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class QueryHtml extends SimpleTagSupport {
    public HtmlDocument document;
    public String var;
    public String expression;

    public void setDocument(HtmlDocument document) {
        this.document = document;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    // -----------------------------------------------------------------------
    // Simple Tag Implementation
    // -----------------------------------------------------------------------

    public void doTag() throws JspException, IOException {
        System.out.println("QueryHtml.doTag");

        System.out.println("document = " + document);
        System.out.println("var = " + var);
        System.out.println("expression = " + expression);

        Node node = document.document.getRootElement();
        XPath path;
        try {
            path = new Dom4jXPath(expression);
        } catch (JaxenException e) {
            throw new JspException("Unable to compile xpath expression '" + expression + "'.", e);
        }
        try {
            Object result = path.selectSingleNode(node);
            System.out.println("result = " + result);
            new XMLWriter(getJspContext().getOut()).write(result);
        } catch (JaxenException e) {
            throw new JspException("Unable to run xpath expression '" + expression + "'.", e);
        }
    }
}
