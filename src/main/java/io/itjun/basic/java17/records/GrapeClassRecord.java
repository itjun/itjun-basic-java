package io.itjun.basic.java17.records;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.awt.*;

public class GrapeClassRecord {

    /**
     * Records 将允许您创建不可变的数据类
     */
    record GrapeRecord(Color color, int nbrOfPits) {
        GrapeRecord {
            /**
             *  在构造函数内部，字段值仍然为 null，
             *  但在打印记录时，它们被分配了一个值。验证也做它应该做的事情，
             *  并在颜色为 null 时抛出 IllegalArgumentException。
             */
            System.out.println("Parameter color=" + color + ", Field color=" + this.color());
            System.out.println("Parameter nbrOfPits=" + nbrOfPits + ", Field nbrOfPits=" + this.nbrOfPits());
            if (color == null) {
                throw new IllegalArgumentException("Color may not be null");
            }
        }

        public static GrapeRecord of(Color color, int nbrOfPits) {
            return new GrapeRecord(color, nbrOfPits);
        }
    }

    public static void main(String[] args) throws JsonProcessingException {
        basicRecord();
    }

    private static void basicRecord() {
        System.out.println("""
                ****************
                * Basic record *
                ****************""");

        GrapeRecord grape1 = GrapeRecord.of(Color.BLUE, 1);
        GrapeRecord grape2 = GrapeRecord.of(Color.BLUE, 1);
        System.out.println("Grape 1 is " + grape1);
        System.out.println("Grape 2 is " + grape2);
        System.out.println("Grape 1 equals grape 2?  " + grape1.equals(grape2));

        GrapeRecord grape1Copy = new GrapeRecord(grape1.color(), grape1.nbrOfPits());
        System.out.println("Grape 1 equals its copy?  " + grape1.equals(grape1Copy));
    }

}