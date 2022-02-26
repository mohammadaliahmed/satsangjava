package com.appsinventive.satsangserver.Utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomDateSerializer  extends JsonSerializer<Date> {
    public CustomDateSerializer() {
    }

    public void serialize(Date dt, JsonGenerator jsonGen, SerializerProvider serProv) throws IOException, JsonProcessingException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String formattedDate = sdf.format(dt);
        jsonGen.writeString(formattedDate);
    }

}