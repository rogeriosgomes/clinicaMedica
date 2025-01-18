package com.clinicaMedica.clinicaMedica.Enum;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SimNaoDeserializer extends JsonDeserializer<SimNao> {
    @Override
    public SimNao deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        var id = jsonParser.getIntValue();
        return SimNao.fromId(id);
    }
}
