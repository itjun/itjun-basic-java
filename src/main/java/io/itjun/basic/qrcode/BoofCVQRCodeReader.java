package io.itjun.basic.qrcode;

import boofcv.abst.fiducial.QrCodeDetector;
import boofcv.alg.fiducial.qrcode.QrCode;
import boofcv.factory.fiducial.FactoryFiducial;
import boofcv.io.image.ConvertBufferedImage;
import boofcv.io.image.UtilImageIO;
import boofcv.struct.image.GrayU8;

import java.awt.image.BufferedImage;
import java.util.List;

public class BoofCVQRCodeReader {

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\itjun\\Downloads\\2.png"; // 替换成你的图片路径
        String result = decodeQRCode(imagePath);

        if (result != null) {
            System.out.println("二维码内容：\n" + result);
        } else {
            System.out.println("未识别到有效二维码。");
        }
    }

    public static String decodeQRCode(String imagePath) {
        BufferedImage buffered = UtilImageIO.loadImage(imagePath);
        if (buffered == null) {
            System.err.println("无法加载图片: " + imagePath);
            return null;
        }

        // 转为灰度图
        GrayU8 gray = ConvertBufferedImage.convertFrom(buffered, (GrayU8) null);

        // 创建二维码检测器
        QrCodeDetector<GrayU8> detector = FactoryFiducial.qrcode(null, GrayU8.class);
        detector.process(gray);

        List<QrCode> codes = detector.getDetections();
        if (codes.isEmpty()) {
            return null;
        }

        // 只取第一个二维码结果
        return codes.getFirst().message;
    }
}
