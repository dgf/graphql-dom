package org.aplatanao.graphql.dom;

public class Document {

    private org.jsoup.nodes.Document _document;

    public Document(org.jsoup.nodes.Document document) {
        _document = document;
    }

    public String location() {
        return _document.location();
    }

    public String title() {
        return _document.title();
    }

    public Elements select(String selector) {
        return new Elements(_document.select(selector));
    }
}
