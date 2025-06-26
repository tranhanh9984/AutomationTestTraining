package autotest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookieUtil {
    private static final String COOKIE_FILE = "cookies.data";

    /** Lưu tất cả cookie hiện tại của driver vào file */
    @SuppressWarnings("unchecked")
    public static void saveCookies(WebDriver driver) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(COOKIE_FILE))) {
            Set<Cookie> cookies = driver.manage().getCookies();
            oos.writeObject(cookies);
            System.out.println("→ Đã lưu " + cookies.size() + " cookie vào " + COOKIE_FILE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Đọc cookie từ file và add vào driver */
    @SuppressWarnings("unchecked")
    public static void loadCookies(WebDriver driver, String baseUrl) {
        File file = new File(COOKIE_FILE);
        if (!file.exists()) {
            System.out.println("Chưa có file cookie, cần login form trước.");
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Set<Cookie> cookies = (Set<Cookie>) ois.readObject();
            driver.get(baseUrl);  // cần vào domain trước khi add
            for (Cookie ck : cookies) {
//            	System.out.println("Add cookie: " + ck.getName() + " | " + ck.getDomain() + " | " + ck.getPath());
//            	System.out.println(ck.getName() + " | " + ck.getDomain() + " | " + ck.getExpiry());
                driver.manage().addCookie(ck);
            }
            driver.navigate().refresh();
            System.out.println("→ Đã load " + cookies.size() + " cookie từ " + COOKIE_FILE);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
