Cibus 2 is the replacement of the CMS for JavaZone.no

It consists of two different webapps.
 * Cibus-CMS-Web
Backend which works as a HTTP repository for .html based content.
 * Cibus-Web
Webpage which styles the .html files served by the CMS backend.

Setting up the environment.
 * Build the project from root with Maven
 ** mvn clean install
 * Start the cibus-cms-web in a new command line window
 ** cd cibus-cms-web
 ** mvn jetty:run
 * Start the cibus-web frontend
 ** cd cibus-web
 ** mvn jetty:run

The web pages can be located by:
http://localhost:8099/cibus-web/about.html
http://localhost:8099/cibus-web/contact.html
And so on.

Note that behind the scenes, tuckey is used for URL rewrite, and sitemesh for layout.
The pages are rendered with content.jspx which accepts the url's from the tuckey rewrite filter.