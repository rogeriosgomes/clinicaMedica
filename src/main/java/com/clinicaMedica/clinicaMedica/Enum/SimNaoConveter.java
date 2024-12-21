package com.clinicaMedica.clinicaMedica.Enum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SimNaoConveter implements AttributeConverter<SimNao, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SimNao simNao) {
        return simNao != null ? simNao.getId() : null ;
    }

    @Override
    public SimNao convertToEntityAttribute(Integer id) {
        return id != null ? SimNao.fromId(id): null;
    }
}
