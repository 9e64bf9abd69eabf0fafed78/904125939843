package test;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.UUID;


/**
 * @date :  18.11.30  17:12
 */
public class StringTest {
    private static final char[] HEX = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] HEX1 = new char[]{'0', '1', '2',};

    public static void main(String[] args) throws Exception {

    }
    private static String getPw(String pw, String id) throws NoSuchAlgorithmException {
        System.out.println((pw + id));
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = instance.digest((pw + id).getBytes());
        int nBytes = bytes.length;
        char[] result = new char[2 * nBytes];
        int j = 0;
        for (byte aByte : bytes) {
            result[j++] = HEX[(240 & aByte) >>> 4];
            result[j++] = HEX[15 & aByte];
        }
        return new String(result);
    }

    private static String[] getP(Integer a, Integer b) {
        if (a == null || b == null || a == 0 || b == 0) return new String[]{"0%", "100%"};
        if (a >= b) return new String[]{"100%", "0%"};
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMaximumFractionDigits(1);
        String left = percent.format(new BigDecimal((double) a / b).setScale(3, RoundingMode.HALF_UP).doubleValue());
        return new String[]{left, percent.format(new BigDecimal((double) (b - a) / b).doubleValue())};
    }


    private static void uuid() {
        String origin = UUID.randomUUID().toString();
        String sessionId = origin.substring(0, 8) + new SecureRandom().nextInt(9) + origin.substring(24, 36);
        System.out.println(origin);
        System.out.println(sessionId);
    }

    private static void cast() {
        Integer a = null;
        System.out.println(Long.parseLong(0 + ""));
        String s = null;
        String ss = null + "";
        System.out.println(s.toString());
    }

    private static void spilt(String s, String regex) {
        String[] wareIds = s.split(regex);
        System.out.println(wareIds.length);
        System.out.println(Arrays.toString(Arrays.stream(wareIds).toArray()));
        System.out.println("".equals(wareIds[0]));
    }

    static private void substring(String s, int begin, int end) {
        System.out.println(s.substring(begin, end));
    }

    static private void equal(String s, int i) {
        System.out.println(s.equals(i + ""));
    }

    static private String file(String originalFilename) {
        if (illegalLinuxFileName(originalFilename)) {
            throw new NullPointerException("文件名不合法");
        }
        String originName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        if (originName.length() > 254) {
            originName = originalFilename.substring(0,254);
        }
        String finalName = originName+ originalFilename.substring(originalFilename.lastIndexOf("."));
        assert !illegalLinuxFileName(finalName);
        return System.currentTimeMillis() + "/" + finalName;
    }

    public static boolean illegalLinuxFileName(String nameWithFormat) {
        return nameWithFormat == null || nameWithFormat.length() == 0 || nameWithFormat.length() > 255 || nameWithFormat.contains("/") || !nameWithFormat.contains(".");
    }
}
