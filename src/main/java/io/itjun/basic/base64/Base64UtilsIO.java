package io.itjun.basic.base64;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

@Slf4j
public class Base64UtilsIO {

    public static void main(String[] args) {
        try {
            // BIO
            File filePath = new File("C:\\Users\\l1091\\Downloads\\yto.pdf");
            String tempBase64Str = Base64UtilsIO.fileToBase64Str(filePath);
            write(tempBase64Str);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    public static String read(String url) {
        String base64Str = null;

        FileInputStream fin = null;

        ByteArrayOutputStream arrayOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fin = new FileInputStream(url);
            FileChannel channel = fin.getChannel();

            arrayOutputStream = new ByteArrayOutputStream();
            bufferedOutputStream = new BufferedOutputStream(arrayOutputStream);

            int capacity = 100;// 字节
            ByteBuffer bf = ByteBuffer.allocate(capacity);

            int length;
            while ((length = channel.read(bf)) != -1) {
                /*
                 * 注意，读取后，将位置置为0，将limit置为容量, 以备下次读入到字节缓冲中，从0开始存储
                 */
                bf.clear();
                byte[] bytes = bf.array();
                bufferedOutputStream.write(bytes, 0, length);
            }

            // 刷新此输出流，强制写出所有缓冲的输出字节
            bufferedOutputStream.flush();

            byte[] bytes = arrayOutputStream.toByteArray();
            // Base64字符编码
            base64Str = Base64.getEncoder().encodeToString(bytes).trim();

            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return base64Str;
    }

    public static void write(String base64) throws IOException {
        // Base64解码到字符数组
        byte[] bytes = Base64.getDecoder().decode(base64);
        Files.write(Paths.get("sf-LasS.pdf"), bytes);
    }

    /**
     * 3. 文件（图片、pdf） 转 Base64字符串
     *
     * @param file 需要转Base64的文件
     * @return Base64 字符串
     */
    public static String fileToBase64Str(File file) throws IOException {
        String base64Str = null;
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream arrayOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            arrayOutputStream = new ByteArrayOutputStream();
            bufferedOutputStream = new BufferedOutputStream(arrayOutputStream);

            // io
            byte[] buffer = new byte[1024];
            int len = bufferedInputStream.read(buffer);
            while (len != -1) {
                bufferedOutputStream.write(buffer, 0, len);
                len = bufferedInputStream.read(buffer);
            }

            // 刷新此输出流，强制写出所有缓冲的输出字节
            bufferedOutputStream.flush();

            byte[] bytes = arrayOutputStream.toByteArray();
            // Base64字符编码
            base64Str = Base64.getEncoder().encodeToString(bytes).trim();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                fileInputStream.close();
                bufferedInputStream.close();
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
        return base64Str;
    }

    /**
     * 4. Base64字符串 转 文件（图片、pdf） -- 多用于测试
     *
     * @param base64Content Base64 字符串
     * @param filePath      存放路径
     */
    public static void base64ContentToFile(String base64Content, String filePath) throws IOException {
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            // Base64解码到字符数组
            byte[] bytes = Base64.getDecoder().decode(base64Content);
            Files.write(Paths.get("path.pdf"), bytes);
            Files.write(Paths.get("C:\\Users\\l1091\\Downloads\\base64-nio.pdf"), bytes);

            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
            bis = new BufferedInputStream(byteInputStream);
            File file = new File(filePath);
            File path = file.getParentFile();
            if (!path.exists()) {
                path.mkdirs();
            }
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            // io
            byte[] buffer = new byte[1024];
            int length = bis.read(buffer);
            while (length != -1) {
                bos.write(buffer, 0, length);
                length = bis.read(buffer);
            }
            // 刷新此输出流，强制写出所有缓冲的输出字节
            bos.flush();
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                bis.close();
                fos.close();
                bos.close();
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    // 测试
    public static void main2(String args[]) {
        // 3.测试：文件 转 Base64
        // 4.测试：Base64 转 文件
        try {
            File filePath = new File("C:\\Users\\l1091\\Downloads\\xy.pdf");
            String tempBase64Str = Base64UtilsIO.fileToBase64Str(filePath);
            System.out.println("文件 转 Base64，完成，使用方法【4】反转验证。");
            Base64UtilsIO.base64ContentToFile(tempBase64Str, "C:\\Users\\l1091\\Downloads\\base64.pdf");
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println("文件与Base64互转，完成，方法【4】通常用于测试。");
    }
}