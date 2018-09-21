package org.aplatanao.graphql.dom;

public class Element {

    private org.jsoup.nodes.Element _element;

    private org.jsoup.nodes.Element _null = new org.jsoup.nodes.Element("<null>");

    public Element(org.jsoup.nodes.Element element) {
        _element = element;
    }

    private org.jsoup.nodes.Element first(String selector) {
        if (selector != null) {
            org.jsoup.nodes.Element element = _element.select(selector).first();
            if (element == null) {
                return _null;
            }
            return element;
        }
        return _element;
    }

    public Elements select(String selector) {
        return new Elements(_element.select(selector));
    }

    public String attr(String selector, String key) {
        return first(selector).attr(key);
    }

    public String text(String selector) {
        return first(selector).text();
    }

    public String html(String selector) {
        return first(selector).html();
    }
}
