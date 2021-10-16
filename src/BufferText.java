public final class BufferText {

    private volatile static String text;

    public static void setText(String text) {
        synchronized (BufferText.class) {
            BufferText.text = text;
        }
    }

    public static String getText() {
        synchronized (BufferText.class) {
            return BufferText.text;
        }
    }

}
