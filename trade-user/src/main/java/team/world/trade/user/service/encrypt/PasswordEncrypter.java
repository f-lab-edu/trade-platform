package team.world.trade.user.service.encrypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import org.springframework.stereotype.Service;
import team.world.trade.user.service.encrypt.salt.SaltRepository;

@Service
public class PasswordEncrypter {

    private final SaltRepository saltRepository;

    public PasswordEncrypter(SaltRepository saltRepository) {
        this.saltRepository = saltRepository;
    }

    public String encrypt(String username, String password) {
        String salt = salt();
        storeSalt(username, salt);
        return DefaultEncoder.encoding(password.getBytes(), salt);
    }

    public String findEncrypted(String username, String password) {
        String salt = findSaltByUsername(username);
        return DefaultEncoder.encoding(password.getBytes(), salt);
    }

    public String salt() {
        return DefaultEncoder.salt();
    }

    public void storeSalt(String username, String salt) {
        saltRepository.save(username, salt);
    }

    public String findSaltByUsername(String username) {
        return saltRepository.findSaltByUsername(username);
    }


    private static class DefaultEncoder {
        private static final int SALT_SIZE = 16;

        public static String encoding(byte[] password, String salt) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                for (int i = 0; i < 10000; i++) {
                    String temp = new String(password, StandardCharsets.UTF_8) + salt;
                    md.update(temp.getBytes());
                    password = md.digest();
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            return new String(password, StandardCharsets.UTF_8);
        }

        public static String salt() {
            SecureRandom rnd = new SecureRandom();
            byte[] temp = new byte[SALT_SIZE];
            rnd.nextBytes(temp);
            return new String(temp, StandardCharsets.UTF_8);
        }
    }
}
