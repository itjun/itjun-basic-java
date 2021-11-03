
package io.itjun.examples.java17;

import com.google.gson.Gson;

public class Switch {
    record FavoriteFruit(String name, FruitType fruit) {
    }

    public static void main(String[] args) {
        FavoriteFruit f1 = new FavoriteFruit("itjun", FruitType.APPLE);
        System.out.println(new Gson().toJson(f1));

        FavoriteFruit f2 = new FavoriteFruit("john", FruitType.ORANGE);
        System.out.println(new Gson().toJson(f2));

//        oldStyleWithoutBreak(FruitType.APPLE);
//        withSwitchExpression(FruitType.APPLE);
//        withSwitchExpression(FruitType.AVOCADO);
//        withYield(FruitType.APPLE);
        oldStyleWithYield(FruitType.APPLE);
    }

    private static void oldStyleWithoutBreak(FruitType fruit) {
        System.out.println("""
                ***************************
                * Old style without break *
                ***************************""");
        switch (fruit) {
        case APPLE, PEAR:
            System.out.println("Common fruit");
        case ORANGE, AVOCADO:
            System.out.println("Exotic fruit");
        default:
            System.out.println("Undefined fruit");
        }
    }

    public enum FruitType {
        APPLE, PEAR, ORANGE, AVOCADO;

    }

    private static void withSwitchExpression(FruitType fruit) {
        System.out.println("""
                **************************
                * With switch expression *
                **************************""");
        switch (fruit) {
        case APPLE, PEAR -> System.out.println("Common fruit");
        case ORANGE, AVOCADO -> System.out.println("Exotic fruit");
        default -> System.out.println("Undefined fruit");
        }
    }

    private static void withReturnValue(FruitType fruit) {
        System.out.println("""
                *********************
                * With return value *
                *********************""");
        String text = switch (fruit) {
            case APPLE, PEAR -> "Common fruit";
            case ORANGE, AVOCADO -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }

    /**
     * 当您需要在 case 中做不止一件事情时，您会怎么做？
     * 在这种情况下，您可以使用方括号来表示 case 块，并在返回值时使用关键字 yield。
     */
    private static void withYield(FruitType fruit) {
        System.out.println("""
                **************
                * With yield *
                **************""");
        String text = switch (fruit) {
            case APPLE, PEAR -> {
                System.out.println("the given fruit was: " + fruit);
                yield "Common fruit";
            }
            case ORANGE, AVOCADO -> "Exotic fruit";
            default -> "Undefined fruit";
        };
        System.out.println(text);
    }

    private static void oldStyleWithYield(FruitType fruit) {
        System.out.println("""
                ************************
                * Old style with yield *
                ************************""");
        System.out.println(switch (fruit) {
            case APPLE, PEAR:
                yield "Common fruit";
            case ORANGE, AVOCADO:
                yield "Exotic fruit";
            default:
                yield "Undefined fruit";
        });
    }

}
