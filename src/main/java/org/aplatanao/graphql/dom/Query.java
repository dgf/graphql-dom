package org.aplatanao.graphql.dom;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Query implements GraphQLQueryResolver {

    public Response get(String url) throws IOException {
        return new Response(Jsoup.connect(url));
    }
}
