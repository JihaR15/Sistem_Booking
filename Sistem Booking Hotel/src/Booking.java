import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String username, password;

        System.out.println("=========== LOGIN ==========");
        System.out.print("Username  : ");
        username =sc.nextLine();
        System.out.print("Password  : ");
        password = sc.nextLine();
        if (username.equals("admin") && password.equals("12345")) {
            System.out.println("------- Login Sukses -------");
            System.out.println("\n=========================================");
            System.out.println("|\t       MENU UTAMA \t\t|");
            System.out.println("=========================================");
            System.out.print("    1. Profil User");
            System.out.println("\t5. -");
            System.out.print("    2. Check-In");
            System.out.println("\t\t6. -");
            System.out.print("    3. Check-Out");
            System.out.println("\t7. Logout");
            System.out.print("    4. -");
            System.out.println("\t\t8. Tutup Program");
            System.out.println("=========================================");
            System.out.print("Silahkan pilih menu (1-8)     : ");
            int menu = sc.nextInt();
            // dikarenakan belum boleh if level 2 jadi dipisah filenya, di MenuUtama.java
        } else {
            System.out.println("-------- Login Gagal -------");

        }
        
       
    }
}
