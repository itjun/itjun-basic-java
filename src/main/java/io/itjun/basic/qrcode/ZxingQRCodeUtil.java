package io.itjun.basic.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.multi.GenericMultipleBarcodeReader;
import com.google.zxing.multi.MultipleBarcodeReader;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ZxingQRCodeUtil {

    public static byte[] encode(String text, int width, int height) throws WriterException, IOException {
        return encode(text, width, height, Color.BLACK, Color.WHITE);
    }

    public static byte[] encode(String text, int width, int height, Color foregroundColor, Color backgroundColor)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream,
                new MatrixToImageConfig(foregroundColor.getRGB(), backgroundColor.getRGB()));
        return pngOutputStream.toByteArray();
    }

    public static String decode(String file) throws Exception {
        try (FileInputStream is = new FileInputStream(file)) {
            return decode(is);
        }
    }

    public static String decode(File file) throws Exception {
        try (FileInputStream is = new FileInputStream(file)) {
            return decode(is);
        }
    }

    /**
     * 解析二维码
     *
     * @param is
     * @return 二维码内容
     */
    public static String decode(InputStream is) throws IOException, NotFoundException {
        // 读取图片
        BufferedImage image = ImageIO.read(is);
        if (image == null) {
            return null;
        }
        // 创建 LuminanceSource
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

        // 设置解码提示
        Map<DecodeHintType, Object> hints = new EnumMap<>(DecodeHintType.class);
        hints.put(DecodeHintType.TRY_HARDER, Boolean.TRUE); // 尝试更多模式
        hints.put(DecodeHintType.POSSIBLE_FORMATS, Arrays.asList(BarcodeFormat.values()));// 支持所有格式
        hints.put(DecodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name()); // 设置字符集

        MultipleBarcodeReader reader = new GenericMultipleBarcodeReader(new MultiFormatReader());
        Result[] results = reader.decodeMultiple(bitmap, hints);
        // 没有解析到符合条件的文本
        if (results == null || results.length == 0)
            return null;

        // 抓取第一个二维码内容
        Optional<Result> optional = Stream.of(results)
                .filter(result -> result.getBarcodeFormat() == BarcodeFormat.QR_CODE).findFirst();
        if (optional.isPresent())
            return optional.get().getText();
        return results[0].getText();
    }

    public static void main(String[] args) {
        String imagePath = "C:\\Users\\itjun\\Downloads\\2.png"; // 替换成你的图片路径
        try {
            System.out.println(decode(imagePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
