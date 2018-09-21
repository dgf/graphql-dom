package org.aplatanao.graphql.dom;

import java.util.List;
import java.util.stream.Collectors;

public class Elements {

    private final org.jsoup.select.Elements _elements;

    private org.jsoup.nodes.Element _null = new org.jsoup.nodes.Element("<null>");

    public Elements(org.jsoup.select.Elements elements) {
        _elements = elements;
    }

    private org.jsoup.nodes.Element first(String selector) {
        org.jsoup.nodes.Element element = _null;
        if (selector != null) {
            element = _elements.select(selector).first();
        } else {
            element = _elements.first();
        }
        if (element == null) {
            return _null;
        }
        return element;
    }

    private org.jsoup.select.Elements filter(String filter) {
        if (filter != null) {
            return _elements.select(filter);
        }
        return _elements;
    }

    public List<Element> elements(String filter) {
        return filter(filter).stream().map(Element::new).collect(Collectors.toList());
    }

    public Elements select(String selector) {
        return new Elements(_elements.select(selector));
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
