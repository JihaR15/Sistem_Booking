import java.util.Scanner;

public class nyoba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] kamar = {"Single", "Double", "Suite"};
        int[] harga = {50000, 80000, 150000};

        System.out.println("Silakan pilih jenis kamar yang ingin Anda pesan:");
        System.out.println("1. " + kamar[0] + " - Rp." + harga[0] + "/malam");
        System.out.println("2. " + kamar[1] + " - Rp." + harga[1] + "/malam");
        System.out.println("3. " + kamar[2] + " - Rp." + harga[2] + "/malam");

        System.out.print("Pilihan Anda (1/2/3): ");
        int pilihanKamar = sc.nextInt();

        if (pilihanKamar < 1 || pilihanKamar > 3) {
            System.out.println("Pilihan tidak valid. Harap pilih antara 1, 2, atau 3.");
            sc.close();
            return;
        }

        System.out.print("Berapa malam Anda ingin menginap: ");
        int perMalam = sc.nextInt();

        int totalPrice = harga[pilihanKamar - 1] * perMalam;
        System.out.println("Total harga untuk " + kamar[pilihanKamar - 1] + " selama " + perMalam + " malam adalah Rp." + totalPrice);

        sc.close();
    }
}