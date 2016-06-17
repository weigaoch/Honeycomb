package com.polycom.rest;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;

/**
 * Created by wgao on 6/16/2016.
 */
public class JsonUtils {
    private static JsonUtils ourInstance = new JsonUtils();

    public static JsonUtils getInstance() {
        return ourInstance;
    }

    private final Gson gson;

    private JsonUtils() {
        gson = new GsonBuilder().setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {
                XmlElement v_annotation = f.getAnnotation(XmlElement.class);
                return (v_annotation != null && !v_annotation.name().equals("##default")) ? v_annotation.name() : f.getName();
            }
        }).create();
    }

    public String toJson(Object src) {
        return gson.toJson(src);
    }

    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }
}
