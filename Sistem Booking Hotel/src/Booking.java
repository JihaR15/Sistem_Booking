import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String kamar = "Suite", nama ;
        int harga = 50000, perMalam;

        System.out.println("\nKamar yang anda plih yaitu: ");
        System.out.println("1. " + kamar + " - Rp." + harga + "/malam");

        System.out.print("\nAtas nama siapa: ");
        nama = sc.nextLine();

        System.out.print("Halo " + nama +", Berapa malam Anda ingin menginap: ");
        perMalam = sc.nextInt();

        int totalHarga = harga * perMalam;
        System.out.println("Total harga untuk " + kamar + " selama " + perMalam + " malam adalah Rp." + totalHarga);
        System.out.println(" ");
    }
}
