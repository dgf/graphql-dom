package org.aplatanao.graphql.dom;

import org.jsoup.Connection;

import java.io.IOException;

public class Response {

    private final Document _document;

    private Connection.Response _response;

    public Response(Connection connection) throws IOException {
        _document = new Document(connection.get());
        _response = connection.response();
    }

    public int statusCode() {
        return _response.statusCode();
    }

    public String statusMessage() {
        return _response.statusMessage();
    }

    public String charset() {
        return _response.charset();
    }

    public String contentType() {
        return _response.contentType();
    }

    public Document document() {
        return _document;
    }
}
