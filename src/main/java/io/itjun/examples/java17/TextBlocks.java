package io.itjun.examples.java17;

public class TextBlocks {

    public static void main(String[] args) {
//        oldStyle();
        emptyBlock();
    }

    private static void oldStyle() {
        System.out.println("""
                {
                "name": "John Doe",
                "age": 45,
                "address": "Doe Street, 23, Java Town"
                }
                """);
        String text = "{\n" +
                "  \"name\": \"John Doe\",\n" +
                "  \"age\": 45,\n" +
                "  \"address\": \"Doe Street, 23, Java Town\"\n" +
                "}";
        System.out.println(text);
    }

    private static void emptyBlock() {
        System.out.println("""
                ***************
                * Empty Block *
                ***************""");
        String text = """
                {
                "name": "John Doe",
                "age": 45,
                "address": "Doe Street, 23, Java Town"
                }
                """;
        System.out.println("|" + text + "|");
    }

}
