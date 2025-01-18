package com.clinicaMedica.clinicaMedica.Enum;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SimNaoSerializer extends JsonSerializer<SimNao> {
    @Override
    public void serialize(SimNao simNao, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(simNao.getId());
    }
}
