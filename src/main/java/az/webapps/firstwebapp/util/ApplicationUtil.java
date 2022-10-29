//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package az.webapps.firstwebapp.util;

import java.sql.SQLException;
import java.util.Objects;
import java.util.Scanner;

public class ApplicationUtil {

    public static int validateStringInputAndReturnNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException var2) {
            printError("Invalid input.");
            return -1;
        }
    }

    public static void printError(String errorMessage) {
        System.err.println("\t ! ! ! ATTENTION ! ! !");
        System.out.println(errorMessage);
    }


    public static boolean validateLoginInformation(String username, String password) {
        return username.equals("ADMIN") && password.equals("123");
    }
}
