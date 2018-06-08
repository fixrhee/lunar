package com.jpa.optima.lunar.process;

public class SignatureProcessor {

	private RSASecurityUtils rsaUtils;

	public String getSignature(String hash) {
		try {
			return rsaUtils.sign(hash);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public RSASecurityUtils getRsaUtils() {
		return rsaUtils;
	}

	public void setRsaUtils(RSASecurityUtils rsaUtils) {
		this.rsaUtils = rsaUtils;
	}

}
