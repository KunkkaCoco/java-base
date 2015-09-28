package com.io;



import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * Created by chenweichao on 15-9-28.
 */
public class FileRWSpeedCompare {
    private FileRWSpeedCompare() {}

    /**
     * 单纯对文件的复制来比较io，nio和commons-io的读写速度
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String in = "/home/maximus/tmp/include"+"/20150909/2538183_c.html";
        String out = "/home/maximus/tmp/copyto"+"/20150909/2538183_c.html";

        long s = System.currentTimeMillis();
        //rw1(in, out);//Cost: 59797ms
        //rw2(in, out);//Cost: 4875ms
        rw3(in, out);//Cost: 8796ms
        long e = System.currentTimeMillis();
        System.out.println("Cost: " + (e - s) + "ms");
        System.out.println("***************************");
    }

    /**
     * 基本IO
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void rw1(String inputPath, String outputPath) throws IOException {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(inputPath))));
            String temp = "";
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(outputPath))));

            while ((temp = reader.readLine()) != null) {
                writer.write(temp + "\n");
                writer.flush();
            }
        } finally {
            if (reader != null)
                reader.close();
            if (writer != null)
                writer.close();
        }
    }

    /**
     * NIO (http://www.cnblogs.com/focusj/archive/2011/11/03/2231583.html)
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void rw2(String inputPath, String outputPath) throws IOException {
        FileInputStream ins = new FileInputStream(inputPath);
        FileOutputStream outs = new FileOutputStream(outputPath);
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        FileChannel inc = ins.getChannel();
        FileChannel outc = outs.getChannel();
        Charset chs = Charset.forName("UTF-8");

        CharsetDecoder dec = chs.newDecoder();
        CharsetEncoder enc = chs.newEncoder();

        while (true) {
            buffer.clear();

            CharBuffer cb = dec.decode(buffer);
            ByteBuffer bb = enc.encode(cb);

            int temp = inc.read(bb);
            if (temp == -1) break;

            bb.flip();
            outc.write(bb);
        }
    }

    /**
     * 使用FileUtils的copyFile方法，事实上这个方法就是用nio的Buffer和Channel实现的
     * @param inputPath
     * @param outputPath
     * @throws IOException
     */
    public static void rw3(String inputPath, String outputPath) throws IOException {
        FileUtils.copyFile(new File(inputPath), new File(outputPath));
    }
}