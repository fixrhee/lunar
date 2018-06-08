package com.jpa.optima.lunar.process;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.RSAPrivateKeySpec;

import org.apache.commons.codec.binary.Base64;

public class RSASecurityUtils {

	private PrivateKey privateKey;

	public RSASecurityUtils() {
	}

	public RSASecurityUtils(String mod, String exp) throws Exception {
		setPrivateKey(new BigInteger(mod, 16), new BigInteger(exp, 16));
	}

	public void setPrivateKey(BigInteger mod, BigInteger exp) throws Exception {
		KeyFactory rsaKeyFactory = KeyFactory.getInstance("RSA");
		RSAPrivateKeySpec kspec = new RSAPrivateKeySpec(mod, exp);
		privateKey = rsaKeyFactory.generatePrivate(kspec);
	}

	public String sign(String text) throws Exception {
		byte[] cipherText = null;
		final Signature sign = Signature.getInstance("SHA1withRSA");
		sign.initSign(privateKey);
		sign.update(text.getBytes("UTF-8"));
		cipherText = sign.sign();
		return Base64.encodeBase64String(cipherText);
	}

}
