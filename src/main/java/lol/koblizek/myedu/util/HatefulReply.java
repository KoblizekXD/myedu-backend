package lol.koblizek.myedu.util;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Data
public class HatefulReply {

    private final Type type;

    @Nullable
    private final String message;

    public HatefulReply(@NotNull String message) {
        this.message = message;
        this.type = Type.FAIL;
    }

    public HatefulReply(Type type, @Nullable String message) {
        this.type = type;
        this.message = message;
    }

    public HatefulReply() {
        this.type = Type.SUCCEED;
        this.message = null;
    }

    public static HatefulReply ok() {
        return new HatefulReply();
    }

    public static HatefulReply notOk(@NotNull String message) {
        return new HatefulReply(message);
    }

    public static HatefulReply warned(@Nullable String message) {
        return new HatefulReply(Type.SUCCEED_WITH_WARNING, message);
    }

    public enum Type {
        SUCCEED,
        FAIL,
        SUCCEED_WITH_WARNING
    }

    public boolean equals(HatefulReply another) {
        return another.type == this.type && (this.message == null || this.message.equals(another.message));
    }
}
