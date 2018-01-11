package com.alldiancan.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.InputStream;

/**
 * Created by laliu on 1/11/2018.
 */
public class JsonConverter<T> {

    final  static ObjectMapper mapper = new ObjectMapper();

    static  {
        // SerializationFeature for changing how JSON is written
        // to enable standard indentation ("pretty-printing"):
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        // to allow serialization of "empty" POJOs (no properties to serialize)
        // (without this setting, an exception is thrown in those cases)
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // to write java.util.Date, Calendar as number (timestamp):
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        // DeserializationFeature for changing how JSON is read as POJOs:
        // to prevent exception when encountering unknown property:
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // to allow coercion of JSON empty String ("") to null Object value:
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // JsonParser.Feature for configuring parsing settings:
        // to allow C/C++ style comments in JSON (non-standard, disabled by default)
        // (note: with Jackson 2.5, there is also `mapper.enable(feature)` / `mapper.disable(feature)`)
        mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        // to allow (non-standard) unquoted field names in JSON:
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // to allow use of apostrophes (single quotes), non standard
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // JsonGenerator.Feature for configuring low-level JSON generation:
        // to force escaping of non-ASCII characters:
        mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }

    /**
     * 将Json 字符串转换成 POJO 对象
     * @param jsonStr
     * @param type
     * @param <T>
     * @return
     * @throws Exception
     */
    public static  <T> T converToPOJOFromPlainTxt(String jsonStr,Class<T> type) throws Exception{
       return mapper.readValue(jsonStr,type);
    }

    /**
     * 将Json 字符串转换成 POJO 对象
     * @param inputStream
     * @param type
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T converToPOJOFromInputStream(InputStream inputStream,Class<T> type) throws Exception{
        return mapper.readValue(inputStream,type);
    }

    /**
     * 将 POJO对象转换成 JSON
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    public static String converToPlainTxtFromPoJo(Object object) throws JsonProcessingException {
        return  mapper.writeValueAsString(object);
    }

    /**
     * 将 POJO对象转换成 bytes
     * @param value
     * @return
     * @throws JsonProcessingException
     */
    public static byte[] converToBytesFromPoJo(Object value) throws JsonProcessingException {
        return mapper.writeValueAsBytes(value);
    }
}
