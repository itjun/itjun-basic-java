package io.itjun.basic.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class QRCode {

    public static void main(String[] args) throws WriterException, IOException {
        QRCode obj = new QRCode();
        obj.encode();
        obj.decode();
    }

    /**
     * 生成图像
     *
     * @throws WriterException
     * @throws IOException
     */
    public void encode() throws WriterException, IOException {
        String filePath = ".\\";
        String fileName = "zxing.png";

        String url = "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing";
        System.out.println(url);

        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型

        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

        // 生成矩阵
        BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath, fileName);

        // 输出图像
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        System.out.println("输出成功.");
    }

    /**
     * 解析图像
     */
    public void decode() {
        String filePath = ".\\zxing.png";
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码

            String content = result.getText();
            System.out.println("图片中内容");
            System.out.println(content);
            System.out.println("图片中格式");
            System.out.println("encode： " + result.getBarcodeFormat());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

}
