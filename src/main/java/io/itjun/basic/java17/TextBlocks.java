package io.itjun.basic.java17;

public class TextBlocks {

    public static void main(String[] args) {
//        oldStyle();
        emptyBlock();
    }

    private static void oldStyle() {
        System.out.println("""
                [
                    {
                        "partCode": "911001001921",
                        "num": 1,
                        "spare": false,
                        "remark": "",
                        "oriUP": 1
                    },
                    {
                        "partCode": "KS500-ZL40/50",
                        "num": 1,
                        "spare": false,
                        "remark": "",
                        "oriUP": 1
                    },
                    {
                        "partCode": "911001001931",
                        "num": 1,
                        "spare": false,
                        "remark": "",
                        "oriUP": 1
                    }
                ]
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
