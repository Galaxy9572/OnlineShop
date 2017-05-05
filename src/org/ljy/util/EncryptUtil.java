package org.ljy.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author 廖俊瑶
 *
 */
public class EncryptUtil {
	private static MessageDigest md5;

	/**
	 * MD5加密
	 * @param 明文
	 * @return 返回32位小写数字加字母
	 */
	public static String encrypt(String plain) {
		String re_md5 = new String();
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(plain.getBytes("utf-8"));
			byte b[] = md5.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			re_md5 = buf.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return re_md5;
	}
}
