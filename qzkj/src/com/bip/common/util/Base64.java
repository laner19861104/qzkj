/*
 * Created on 2003-4-7
 */
package com.bip.common.util;

public class Base64 {

    private static String lineSeparator = System.getProperty("line.separator");

    // 编码每行的长度。这里我们不需要进行换行工作。
    private static int lineLength = 0;

    private Base64() {
    }

    public static String base64Encode(byte[] b, int length) {
        if (length > b.length)
            length = b.length;

        int outputLength = ((length + 2) / 3) * 4;
        if (lineLength != 0) {
            int lines = (outputLength + lineLength - 1) / lineLength - 1;
            if (lines > 0) {
                outputLength += lines * lineSeparator.length();
            }
        }
        StringBuffer sb = new StringBuffer(outputLength);
        int linePos = 0;
        int len = (length / 3) * 3;
        int leftover = length - len;
        for (int i = 0; i < len; i += 3) {
            linePos += 4;
            if (linePos > lineLength) {
                if (lineLength != 0)
                    sb.append(lineSeparator);
                linePos = 4;
            }
            int combined = b[i + 0] & 0xff;
            combined <<= 8;
            combined |= b[i + 1] & 0xff;
            combined <<= 8;
            combined |= b[i + 2] & 0xff;

            int c3 = combined & 0x3f;
            combined >>>= 6;
            int c2 = combined & 0x3f;
            combined >>>= 6;
            int c1 = combined & 0x3f;
            combined >>>= 6;
            int c0 = combined & 0x3f;

            sb.append(valueToChar[c0]);
            sb.append(valueToChar[c1]);
            sb.append(valueToChar[c2]);
            sb.append(valueToChar[c3]);
        }

        switch (leftover) {
        case 0:
        default:
            break;
        case 1:
            linePos += 4;
            if (linePos > lineLength) {
                if (lineLength != 0) {
                    sb.append(lineSeparator);
                }
                linePos = 4;
            }

            sb
                    .append(base64Encode(new byte[] { b[len], 0, 0 })
                            .substring(0, 2));
            sb.append("==");
            break;

        case 2:
            linePos += 4;
            if (linePos > lineLength) {
                if (lineLength != 0) {
                    sb.append(lineSeparator);
                }
                linePos = 4;
            }
            sb.append(base64Encode(new byte[] { b[len], b[len + 1], 0 })
                    .substring(0, 3));
            sb.append("=");
            break;
        }

        if (outputLength != sb.length()) {
            System.out
                    .println("oops: minor program flaw: output length mis-estimated");
            System.out.println("estimate:" + outputLength);
            System.out.println("actual:" + sb.length());
        }
        return sb.toString();
    }

    /**
     * 把字符串编码成 base64数据
     * @param b
     * @return
     */
    public static String base64Encode(byte[] b) {
        return base64Encode(b, b.length);
    } // end encode

    /**
     * 把base64编码的数据 解码
     * decode a well-formed complete Base64 string back into an array of bytes.
     * It must have an even multiple of 4 data characters (not counting \n),
     * padded out with = as needed.
     */
    public static String base64DecodeToStr(String s)throws ArrayIndexOutOfBoundsException {
    	return new String( base64Decode(s));
    }
    
    
    public static byte[] base64Decode(String s)
            throws ArrayIndexOutOfBoundsException {
        byte[] b = new byte[(s.length() / 4) * 3];
        int cycle = 0;
        int combined = 0;
        int j = 0;
        int len = s.length();
        int dummies = 0;
        for (int i = 0; i < len; i++) {
            int c = s.charAt(i);
            int value = (c <= 255) ? charToValue[c] : IGNORE;
            switch (value) {
            case IGNORE:
                break;
            case PAD:
                value = 0;
                dummies++;
            default:
                switch (cycle) {
                case 0:
                    combined = value;
                    cycle = 1;
                    break;
                case 1:
                    combined <<= 6;
                    combined |= value;
                    cycle = 2;
                    break;
                case 2:
                    combined <<= 6;
                    combined |= value;
                    cycle = 3;
                    break;
                case 3:
                    combined <<= 6;
                    combined |= value;
                    b[j + 2] = (byte) combined;
                    combined >>>= 8;
                    b[j + 1] = (byte) combined;
                    combined >>>= 8;
                    b[j] = (byte) combined;
                    j += 3;
                    cycle = 0;
                    break;
                }
                break;
            }
        } // end for
        if (cycle != 0)
            throw new ArrayIndexOutOfBoundsException(
                    "Input to decode not an even multiple of 4 characters; pad with =.");
        j -= dummies;
        if (b.length != j) {
            byte[] b2 = new byte[j];
            System.arraycopy(b, 0, b2, 0, j);
            b = b2;
        }
        return b;
    } // end decode
    
    public void setLineLength(int length) {
        lineLength = (length / 4) * 4;
    }

    public void setLineSeparator(String value) {
        lineSeparator = value;
    }

    static final char[] valueToChar = new char[64];

    static final int[] charToValue = new int[256];

    static final int IGNORE = -1;

    static final int PAD = -2;

    static {
        for (int i = 0; i <= 25; i++)
            valueToChar[i] = (char) ('A' + i);
        for (int i = 0; i <= 25; i++)
            valueToChar[i + 26] = (char) ('a' + i);
        for (int i = 0; i <= 9; i++)
            valueToChar[i + 52] = (char) ('0' + i);
        valueToChar[62] = '+';
        valueToChar[63] = '/';

        for (int i = 0; i < 256; i++)
            charToValue[i] = IGNORE;
        for (int i = 0; i < 64; i++)
            charToValue[valueToChar[i]] = i;

        charToValue['='] = PAD;
    }

    public static void show(byte[] b) {
        for (int i = 0; i < b.length; i++) {
            System.out.print(Integer.toHexString(b[i] & 0xff) + " ");
        }
        System.out.println();
    }

    public static void display(byte[] b) {
        for (int i = 0; i < b.length; i++)
            System.out.print((char) b[i]);
        System.out.println();
    }

    public static void main(String[] agrs) {
        System.out.println(Base64.base64Encode("admin".getBytes()));
        System.out.println(new String(Base64
                .base64Decode("c2Rmc2RmLS0t")));
    }
}
