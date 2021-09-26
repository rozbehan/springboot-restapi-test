package com.rayvn.incident.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import lombok.SneakyThrows;

public class IncidentSerializer extends StdSerializer<Incident> {
    public IncidentSerializer() {
        this(null);
    }
    public IncidentSerializer(Class<Incident> t) {
        super(t);
    }

    @SneakyThrows
    @Override
    public void serialize(
            Incident incident,
            JsonGenerator generator,
            SerializerProvider provider)
            throws IOException, JsonProcessingException {

        incident.setTasks(null);
        generator.writeObject(incident);
    }
}