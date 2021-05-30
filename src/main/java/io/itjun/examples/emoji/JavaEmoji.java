package io.itjun.examples.emoji;

import com.vdurmont.emoji.EmojiParser;

public class JavaEmoji {

    public static void main(String[] args) {
//            EmojiManager.getAll().forEach(System.out::print);
//        toEmoji();
        toAliases();
        String name = "🌹☞ 嘿love嘿☜（💘 💤）😀";
        System.out.println(EmojiParser.parseToUnicode(name));
        System.out.println(EmojiParser.parseToAliases(name));
        System.out.println(EmojiParser.removeAllEmojis(name));
        System.out.println(EmojiParser.parseToHtmlDecimal(name));
    }

    private static void toEmoji() {
        String str = "An :grinning:awesome :smiley:string &#128516;with a few :wink:emojis!";
        String result = EmojiParser.parseToUnicode(str);
        System.out.println(result);
// Prints:
// "An 😀awesome 😃string 😄with a few 😉emojis!"
    }

    private static void toAliases() {
        String str = "An 😀awesome 😃string with a few 😉emojis!";
        String result = EmojiParser.parseToAliases(str);
        System.out.println(result);
// Prints:
// "An :grinning:awesome :smiley:string with a few :wink:emojis!"
    }

}
