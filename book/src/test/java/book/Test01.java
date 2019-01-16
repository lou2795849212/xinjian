package book;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import com.oracle.book.util.MD5Util;

public class Test01 {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String str="admin";
		System.out.println(MD5Util.getEncryptedPwd(str));

	}

}
