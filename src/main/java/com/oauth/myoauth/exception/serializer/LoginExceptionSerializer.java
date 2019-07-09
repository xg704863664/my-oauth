package com.oauth.myoauth.exception.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.oauth.myoauth.exception.LoginException;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class LoginExceptionSerializer extends StdSerializer<LoginException> {
    protected LoginExceptionSerializer() {
        super(LoginException.class);
    }
    @Override
    public void serialize(LoginException loginException, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("error", String.valueOf(loginException.getHttpErrorCode()));
        jsonGenerator.writeStringField("message", "用户名或密码错误");
        jsonGenerator.writeStringField("timestamp", String.valueOf(new Date().getTime()));
        if (loginException.getAdditionalInformation()!=null) {
            for (Map.Entry<String, String> entry : loginException.getAdditionalInformation().entrySet()) {
                String key = entry.getKey();
                String add = entry.getValue();
                jsonGenerator.writeStringField(key, add);
            }
        }
        jsonGenerator.writeEndObject();
    }
}
