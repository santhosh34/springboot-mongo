package com.aureole.tradeflow.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

@Configuration
public class MongoDbBotBuilderConfiguration {

    private final ObjectMapper objectMapper;

    public MongoDbBotBuilderConfiguration() {
        this.objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .findAndRegisterModules();
        this.objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator());
    }

    @Bean
    public MongoCustomConversions getMongoCustomConversions() {
        return new MongoCustomConversions(
                List.of(
                        new JsonNodeToDocumentConverter(),
                        new DocumentToJsonNodeConverter())
        );
    }

    @WritingConverter
    class JsonNodeToDocumentConverter implements Converter<JsonNode, Document> {
        @Override
        public Document convert(final JsonNode source) {
            return Document.parse(source.toString());
        }
    }

    @ReadingConverter
    class DocumentToJsonNodeConverter implements Converter<Document, JsonNode> {
        @Override
        public JsonNode convert(Document source) {
            try {
                return objectMapper.readTree(source.toJson());
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Unable to parse Document to JsonNode", e);
            }
        }
    }

}