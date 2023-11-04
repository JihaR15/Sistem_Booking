import java.util.Scanner;

public class searching {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String [] tipeKamar = {"Standard", "Deluxe", "Suite"};
        int [] hargakamar = { 50000, 80000, 100000 };
        int [] kamarTersedia = { 10, 10, 5 };

        System.out.println("============= KATEGORI KAMAR =============");
        for (int i = 0; i < tipeKamar.length; i++) {
            System.out.println("| "+ (i+1) + ". " + tipeKamar[i] + " \tRp." + hargakamar[i] + " \t/malam \t | ");
        }
        System.out.println("==========================================");
        System.out.println("Untuk melihat kamar yang tersedia.. ");
        System.out.print("Pilih tipe kamar (Standard/Deluxe/Suite)  : ");
        String cari = sc.nextLine();

        for (int i = 0; i < tipeKamar.length; i++) {
            if (tipeKamar[i].equalsIgnoreCase(cari)) {
                System.out.println("Tipe kamar " + tipeKamar[i] + " tersedia sebanyak " + kamarTersedia[i] + " Kamar.");
                break;
            }
        }
        
    }
}
