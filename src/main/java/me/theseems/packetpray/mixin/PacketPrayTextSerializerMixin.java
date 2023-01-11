package me.theseems.packetpray.mixin;

import com.google.gson.*;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.text.TextContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.lang.reflect.Type;

@Mixin(Text.Serializer.class)
@Implements({
        @Interface(iface = JsonSerializer.class, prefix = "pp$"),
        @Interface(iface = JsonDeserializer.class, prefix = "ppd$")})
public abstract class PacketPrayTextSerializerMixin {
    private static final Logger LOGGER = LogManager.getLogger(PacketPrayTextSerializerMixin.class);

    @Shadow
    public abstract JsonElement serialize(Text src, Type typeOfSrc, JsonSerializationContext context);

    @Shadow
    public abstract MutableText deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException;

    public JsonElement pp$serialize(Object srcObj, Type typeOfSrc, JsonSerializationContext context) {
        Text src = (Text) srcObj;
        try {
            return serialize(src, typeOfSrc, context);
        } catch (Exception e) {
            LOGGER.warn("Caught exception serializing '" + src.getContent().toString() + "': " + e.getMessage());
            e.printStackTrace();

            JsonObject object = new JsonObject();
            object.addProperty("text", "!UNK-S");
            return object;
        }
    }

    public Object ppd$deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        try {
            return deserialize(json, typeOfT, context);
        } catch (Exception e) {
            LOGGER.warn("Caught exception deserializing '" + json.toString() + "': " + e.getMessage());
            e.printStackTrace();

            return MutableText.of(new TextContent() {
                public String toString() {
                    return "!UNK-D";
                }
            });
        }
    }
}
