package app.main.wangliwei.enablehands.http;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by wlw on 2018/4/12.
 */

public class DoubleDefaul0Adapter implements JsonSerializer<Double>,JsonDeserializer<Double> {
    @Override
    public Double deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if(json.getAsString().equals(""))return 0.00;
            if(json.getAsString().equals(null))return 0.00;
        }catch (Exception igone) {}

        try {
            return json.getAsDouble();
        }catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Double src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src);
    }
}
