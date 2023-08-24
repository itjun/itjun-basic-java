package io.itjun.basic.core.day08;
/*
需求：
电脑运行实例，
电脑运行基于主板。
*/

interface PCI {
    void open();

    void close();
}

class MainBoard {
    public void run() {
        System.out.println("mainboard run ");
    }

    public void usePCI(PCI p)// PCI p = new NetCard()//接口型引用指向自己的子类对象。
    {
        if (p != null) {
            p.open();
            p.close();

        }
    }
}

class NetCard implements PCI {
    @Override
    public void open() {
        System.out.println("netcard open");
    }

    @Override
    public void close() {
        System.out.println("netcard close");
    }

}

class SoundCard implements PCI {
    @Override
    public void open() {
        System.out.println("SoundCard open");
    }

    @Override
    public void close() {
        System.out.println("SoundCard close");
    }
}

/*
 * class MainBoard { public void run() { System.out.println("mainboard run"); }
 * public void useNetCard(NetCard c) { c.open(); c.close(); } }
 *
 * class NetCard { public void open() { System.out.println("netcard open"); }
 * public void close() { System.out.println("netcard close"); } }
 */
public class DuoTaiDemo5 {
    public static void main(String[] args) {
        MainBoard mb = new MainBoard();
        mb.run();
        mb.usePCI(null);
        mb.usePCI(new NetCard());
        mb.usePCI(new SoundCard());

    }
}
