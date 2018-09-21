package org.aplatanao.graphql.dom;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Configuration
public class GraphQL {

    @Value("classpath:dom.graphqls")
    private Resource schemaFile;

    private String getSchema() throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(schemaFile.getInputStream()))) {
            return buffer.lines().collect(Collectors.joining("\n"));
        }
    }

    @Bean
    GraphQLSchema schema(Query query) throws IOException {
        return SchemaParser.newParser()
                .schemaString(getSchema())
                .resolvers(query)
                .build().makeExecutableSchema();
    }
}
