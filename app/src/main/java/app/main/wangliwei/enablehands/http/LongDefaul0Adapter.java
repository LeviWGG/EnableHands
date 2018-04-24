package app.main.wangliwei.enablehands.http;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * Created by wlw on 2018/4/12.
 */

public class LongDefaul0Adapter implements JsonSerializer<Long>,JsonDeserializer<Long> {
    @Override
    public Long deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        try {
            if(json.getAsString().equals(""))return 0l;
            if(json.getAsString().equals("null"))return 0l;
        }catch (Exception igone) {}

        try {
            return json.getAsLong();
        }catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override
    public JsonElement serialize(Long src, Type typeOfSrc, JsonSerializationContext context) {
        return null;
    }
}
