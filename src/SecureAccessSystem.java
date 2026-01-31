import java.util.*;

class SecureAccessSystem {

    private static final String ADMIN_USER = "admin";
    private static final String ADMIN_PASS = "root@123";
    private static int failedAttempts = 0;

    static void systemBanner() {
        System.out.println("=================================");
        System.out.println("  SECURE ACCESS SYSTEM v1.0");
        System.out.println("  Status: MONITORING");
        System.out.println("=================================\n");
    }

    static boolean authenticate(String username, String password) {
        return username.equals(ADMIN_USER) && password.equals(ADMIN_PASS);
    }

    static void intrusionAlert() {
        System.out.println("\n⚠ INTRUSION DETECTED ⚠");
        System.out.println("Too many failed attempts.");
        System.out.println("System locked. Logging incident...\n");
    }

    static void accessGranted() {
        System.out.println("\n✔ ACCESS GRANTED");
        System.out.println("Welcome, Administrator.");
        System.out.println("Root privileges enabled.");
    }

    static void accessDenied() {
        failedAttempts++;
        System.out.println("✖ ACCESS DENIED (" + failedAttempts + "/3)");
        if (failedAttempts >= 3) {
            intrusionAlert();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        systemBanner();

        while (failedAttempts < 3) {
            System.out.print("Username: ");
            String user = sc.nextLine();

            System.out.print("Password: ");
            String pass = sc.nextLine();

            if (authenticate(user, pass)) {
                accessGranted();
                break;
            } else {
                accessDenied();
            }
        }

        System.out.println("System shutting down...");
        sc.close();
    }
}
