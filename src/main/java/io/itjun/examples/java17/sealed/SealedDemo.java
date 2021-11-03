package io.itjun.examples.java17.sealed;

public class SealedDemo {
    private static void sealedClasses() {
        AppleSealed apple = new AppleSealed();
        PearSealed pear = new PearSealed();
        Avocado avocado = new Avocado();
        FruitSealed fruit1 = apple;
        FruitSealed fruit2 = pear;
        FruitSealed fruit3 = avocado;
    }
}
