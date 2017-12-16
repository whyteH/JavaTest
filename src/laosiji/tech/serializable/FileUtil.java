package laosiji.tech.serializable;

import java.io.*;

/**
 * 文本写入写出工具
 */
public class FileUtil {
    private static final String TAG = FileUtil.class.getSimpleName();

    /**
     * 将本地文件以字符串的形式读出
     *
     * @param file
     * @return
     */
    public static String readTextFile(File file) {
        if (!file.exists()) {
            return null;
        }
        InputStream is = null;
        String data = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            long contentlength = file.length();
            ByteArrayOutputStream outstream = new ByteArrayOutputStream(
                    contentlength > 0 ? (int) contentlength : 1024);
            byte[] buffer = new byte[4096];
            int len;
            while ((len = is.read(buffer)) > 0) {
                outstream.write(buffer, 0, len);
            }
            outstream.close();
            data = outstream.toString();
            // byte[] ba = outstream.tobytearray();
            // ret = new string(ba);
        } catch (Exception e) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                }
            }
        }
        if (data != null)
            return data;
        return null;
    }

    /*
     * public static void writeTextToFile(File file, String data) {
     * RandomAccessFile dos = null; try { if (!file.getParentFile().exists())
     * file.getParentFile().mkdirs(); if (!file.exists()) file.createNewFile();
     * dos = new RandomAccessFile(file.getAbsolutePath(), "rw");
     * dos.write(data.getBytes()); Logger.d("FileUtil",
     * "writeTextToFile Over : " ); } catch (IOException e) {
     * Logger.e("FileUtil", "writeTextToFile Error : " + e); }finally { try {
     * dos.close(); } catch (IOException e) { // TODO Auto-generated catch block
     * // e.printStackTrace(); } } }
     */

    /**
     * 向目标文件写入String
     *
     * @param file
     * @param data
     */
    public static void writeTextToFile(File file, String data) {
        File parentFile = new File(file.getParent());
        if (!parentFile.exists())
            parentFile.mkdirs();
        OutputStream outStream = null;
        try {
            if (file.exists())
                file.delete();
            outStream = new FileOutputStream(file);
            outStream.write(data.getBytes());
        } catch (Exception e) {
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
            }
        }
    }

    /**
     * 向目标文件写入bytes
     *
     * @param file
     * @param bytes
     */
    public static boolean writeBytesToFile(File file, byte[] bytes) {
        boolean result = true;

        File parentFile = new File(file.getParent());
        if (!parentFile.exists())
            parentFile.mkdirs();
        OutputStream outStream = null;
        try {
            if (file.exists())
                file.delete();
            outStream = new FileOutputStream(file);
            outStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            try {
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
            }
        }

        return result;
    }

    public static byte[] input2byte(InputStream inStream)
            throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[100];
        int rc = 0;
        while ((rc = inStream.read(buff, 0, 100)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        byte[] in2b = swapStream.toByteArray();
        return in2b;
    }

    public static boolean writeBytesToFile(File file, InputStream inStream) {
        boolean result = true;
        try {
            byte[] bytes = input2byte(inStream);
            result = writeBytesToFile(file, bytes);
        } catch (IOException e) {
            e.printStackTrace();
            result = false;
        } finally {
            if (inStream != null) {
                try {
                    inStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 写对象到本地文件
     */
    public static void writeObjectToFile(File file, Object object) {
        File parentFile = new File(file.getParent());
        if (!parentFile.exists())
            parentFile.mkdirs();
        FileOutputStream os = null;
        ObjectOutputStream objectos = null;
        try {
            if (file.exists())
                file.delete();
            os = new FileOutputStream(file);
            objectos = new ObjectOutputStream(os);
            objectos.writeObject(object);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
                if (objectos != null)
                    objectos.close();
            } catch (Exception e) {

            }
        }
    }

    /**
     * 从本地文件获取对象
     */
    public static Object readObjectFromFile(File file) {
        FileInputStream in = null;
        ObjectInputStream objectin = null;
        Object getObject = null;
        try {
            in = new FileInputStream(file);
            objectin = new ObjectInputStream(in);
            getObject = objectin.readObject();

        } catch (Exception e) {

        } finally {
            try {
                if (in != null)
                    in.close();
                if (objectin != null)
                    objectin.close();
            } catch (Exception e) {

            }
        }
        return getObject;
    }

}