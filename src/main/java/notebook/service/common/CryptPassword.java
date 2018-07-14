package notebook.service.common;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public interface CryptPassword {
    static String crypt(String password) {
        return (new BCryptPasswordEncoder()).encode(password);
    }

    static boolean isEqualPasswords(String rawPassword, String encodedPassword) {
        return (new BCryptPasswordEncoder()).matches(rawPassword, encodedPassword);
    }
}
