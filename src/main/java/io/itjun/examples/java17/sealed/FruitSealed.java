package io.itjun.examples.java17.sealed;

/**
 * 子类需要指明它们是 final、 sealed 还是 non-sealed。超类无法控制子类是否可以扩展以及如何扩展。
 *
 *
 * permits 控制哪些子类可以扩展父类
 */
public abstract sealed class FruitSealed permits AppleSealed, PearSealed {
}
