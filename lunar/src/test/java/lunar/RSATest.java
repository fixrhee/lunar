package lunar;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.RSAPrivateKeySpec;
import java.time.LocalDateTime;

import org.apache.commons.codec.binary.Base64;

public class RSATest {

	private PrivateKey privateKey;

	public void setPrivateKey(BigInteger mod, BigInteger exp) throws Exception {
		KeyFactory rsaKeyFactory = KeyFactory.getInstance("RSA");
		RSAPrivateKeySpec kspec = new RSAPrivateKeySpec(mod, exp);
		privateKey = rsaKeyFactory.generatePrivate(kspec);
	}

	public byte[] sign(String text) throws Exception {
		byte[] cipherText = null;
		final Signature sign = Signature.getInstance("SHA1withRSA");
		sign.initSign(privateKey);
		sign.update(text.getBytes("UTF-8"));
		cipherText = sign.sign();
		return cipherText;
	}

	public static void main(String[] args) {
		try {
			RSATest main = new RSATest();
			main.setPrivateKey(
					new BigInteger(
							"00817f6303b5c322caed2d5fb2246199dd4c31b0de7f590077a6e72be29da8d0c8f588279999f09a4d4b937f11a0a9ed739c3b0ca624699e4d03a68fa216fd8e0954d836401efaccb92010b07399488b0aad6192fadb04faacb107abe5b55aa7dfa90879fee2fd7baa7bd6379d0c6facd90e6cf2bdb42b17a7906d67004f38314d6d5ad31614314e386e38a65ea2b7e4328cc914c961e511292f4c2fdb32d44962c3ad251c61e5ca9f857a0f22b033e1589cc03d19966a5a2d93ba29509eaaeae035ee2c822e4c0fd5720ae1642e0db3c3df640d0b97e84cdf52d7ce6689c7968ebe18dc613ba2a22ce365d708bc0ebcb017af061270134ae7e1052fc3defe3d9f".trim(),
							16),
					new BigInteger(
							"3a73d3afc305b7d8bd4233e5e7421effa2faf3091b9682fd7f5aed9636f0127e034658099f50d975765db787af6bc480e0ce4ea157e24cd01a8bbe5dbddee99410b61f96c5e5132fa4e7a39e2a5c7256797887adafdb098395cd0eac7b35d67cc081d0ff5a5a6ccdc1642a6a3b48d54e8c9264e77841d345918db066955b99f4e299a8d2c780db48967853ac17ebccfec155ca89a9c896a2c0744ff9c8970eb2e91910d0d4a7ba4dfb883cc1be1bf60ae0626c91f50dad26ee3e8ba30575831c53ff818795648cc9739a978910e6479e93e2aba743357ba05d1c37e02925efd9806bee61560b7cc948b3fb83b40a578044e9b882abde16a913f4967ee73d28c1".trim(),
							16));
			System.out.println(Base64.encodeBase64String(main.sign("12200161666651030005627217IDR3750915435".trim())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

}
