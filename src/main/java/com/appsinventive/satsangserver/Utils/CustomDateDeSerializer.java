package com.appsinventive.satsangserver.Utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateDeSerializer  extends JsonDeserializer<Date> {
    public CustomDateDeSerializer() {
    }

    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String dateAsString = jp.getText();
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try {
            date = formatter.parse(dateAsString);
        } catch (ParseException var7) {
            var7.printStackTrace();
        }

        return date;
    }
}
