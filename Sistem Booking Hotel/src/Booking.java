import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String kmr1 = "Single";
        String kmr2 = "Double";
        String kmr3 = "Suite";
        int hargaKamar1 = 50000;
        int hargaKamar2 = 80000;
        int hargaKamar3 = 100000;
        String kamar1 = kmr1 +"\t"+ hargaKamar1;
        String kamar2 = kmr2 +"\t"+ hargaKamar2;
        String kamar3 = kmr3 +"\t\t" +hargaKamar3;

        System.out.println("\n==== KATEGORI KAMAR ====");
        System.out.println("| "+kamar1+"  \t|");
        System.out.println("| "+kamar2+"  \t|");
        System.out.println("| "+kamar3+"\t|");
        System.out.println("========================");

        String kamar = "Suite", nama ;
        int harga = 100000, perMalam;

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
