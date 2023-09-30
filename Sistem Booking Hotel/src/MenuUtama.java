import java.util.Scanner;

public class MenuUtama {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
    
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
        switch (menu) {
            case 1:
                System.out.println("=========================================");
                System.out.println("|\t       Profil User \t\t|");
                System.out.println("=========================================");
                // menampilkan profil user 
                break;
            case 2:
                System.out.println("=========================================");
                System.out.println("|\t       Check-In \t\t|");
                System.out.println("=========================================");
                // menampilkan check-in yang ada pada check in.java
                break;
            case 3:
                System.out.println("=========================================");
                System.out.println("|\t       Check-Out \t\t|");
                System.out.println("=========================================");
                // menampilkan check-out 
                break;
            case 4:
                System.out.println("=========================================");
                System.out.println("|\t       - \t\t|");
                System.out.println("=========================================");
                break;
            case 5:
                System.out.println("=========================================");
                System.out.println("|\t       - \t\t|");
                System.out.println("=========================================");
                break;
            case 6:
                System.out.println("=========================================");
                System.out.println("|\t       - \t\t|");
                System.out.println("=========================================");
                break;
            case 7:
                System.out.println("=========================================");
                System.out.println("|\t       Logout \t\t|");
                System.out.println("=========================================");
                // kembali ke tampilan login seperti pada booking.java
                break;
            case 8:
                System.out.println("===========================================");
                System.out.println("Terima Kasih telah menggunakan Layanan kami ");
                System.out.println("===========================================");
                // menutup aplikasi
                break;
            default:
                break;
        }
    }
}
