package com.lab.tas.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.HashMap;
import java.util.Map;

public final class JsonUtils {

    /**
     * This method will be used to convert string JSON to Map.
     * @param json String JSON body
     * @param type Maps the JSON to corresponding object class
     * @return the mapped json
     */
    public static <T> Map<String, T> jsonToMap(String json, Class<T> type) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory typeFactory = mapper.getTypeFactory();
        MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, type);
        return mapper.readValue(json, mapType);
    }
}
