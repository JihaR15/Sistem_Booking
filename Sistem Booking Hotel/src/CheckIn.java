import java.util.Scanner;

public class CheckIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String kmr1 = "Single", kmr2 = "Double", kmr3 = "Suite", nama;
        int hargaKmr1 = 50000, hargaKmr2 = 80000, hargaKmr3 = 100000, perMalam;

        System.out.println("\n====== KATEGORI KAMAR ======");
        System.out.println("| "+ kmr1 + " - Rp." + hargaKmr1 + "/malam  |");
        System.out.println("| "+ kmr2 + " - Rp." + hargaKmr2 + "/malam  |");
        System.out.println("| "+ kmr3 + " - Rp." + hargaKmr3 + "/malam  |");
        System.out.println("============================");
        System.out.println("\nKamar yang anda plih yaitu: ");
        System.out.println("1. " + kmr1 + " - Rp." + hargaKmr1 + "/malam");
        System.out.print("\nAtas nama siapa: ");
        nama = sc.nextLine();
        System.out.print("Halo " + nama +", Berapa malam Anda ingin menginap: ");
        perMalam = sc.nextInt();
        int totalHarga = hargaKmr1 * perMalam;
        System.out.println("Total harga untuk " + kmr1 + " selama " + perMalam + " malam adalah Rp." + totalHarga);
        System.out.println(" ");

    }
}
