import java.util.Date;
import java.util.Scanner;
public class Pembayaran {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        Scanner sci = new Scanner (System.in);
        Date date = new Date();
        String nama, pilihKamar, cetakNota, pesanKembali;
        String [] tipeKamar = {"Standard", "Deluxe", "Suite"};
        int [] hargakamar = { 50000, 80000, 100000 };
        int  perMalam = 0,totalHarga=0, statusCustomer, kamar = -1;
        double diskon = 0, bayar = 0;
        boolean isTrue =  false;

       do {
        System.out.print("Masukkan nama Anda                        : ");
        nama = sc.nextLine();
        
        System.out.println("============= KATEGORI KAMAR =============");
        for (int i = 0; i < tipeKamar.length; i++) {
            System.out.println("| "  + tipeKamar[i] + " \tRp." + hargakamar[i] + " \t/malam \t | ");
            
        }
        System.out.println("==========================================");

        System.out.print("Pilih tipe kamar (Standard/Deluxe/Suite)  : ");
        pilihKamar = sc.nextLine();
        for (int i = 0; i < tipeKamar.length; i++) {
            if (tipeKamar[i].equals(pilihKamar)) {
                kamar = i ;
                break;
            }
        }
        if (kamar != -1) {
        System.out.print("Masukkan jumlah malam                     : ");
        perMalam = sci.nextInt();
        totalHarga = hargakamar[kamar] * perMalam;
        System.out.println("Status Pelanggan");
        System.out.println("1. Member");
        System.out.println("2. Non Member");
        System.out.print("Status Pelanggan                          : ");
        statusCustomer =  sci.nextInt();
        if (statusCustomer == 1) {
            if (perMalam >= 3 ) {
                diskon = 0.20 * totalHarga;
            }
            else if (perMalam >= 7) {
                diskon = 0.50 * totalHarga;
            }
        }
        else if (statusCustomer == 2){
            if (perMalam >= 3) {
                diskon = 0.10* totalHarga;
            }
            else if (perMalam >= 7) {
                diskon = 0.25 * totalHarga;
            }
        }
        bayar = totalHarga - diskon; 

        System.out.println("Apakah anda ingin mencetak nota ? (ya/tidak)");
        cetakNota = sc.nextLine();
        if (cetakNota.equals("ya")) {
            System.out.println("\n======================= NOTA PEMBAYARAN =======================");
            System.out.println("Tanggal Pembayaran              : " + date.toString());
            System.out.println("Nama Anda                       : " + nama);
            System.out.println("Tipe Kamar yang Anda Pilih      : " + pilihKamar);
            System.out.println("Lama Menginap                   : " + perMalam);
            System.out.println("Status Pelanggan                : " + statusCustomer);
            System.out.println("Total Harga                     : " + totalHarga);
            System.out.println("Diskon Anda Menginap            : " + diskon);
            System.out.println("Anda harus membayar             : " + bayar);
            System.out.println("===============================================================");
        }

        }
        System.out.println("Apakah Anda Ingin Memesan Lagi? (ya/tidak)");
        pesanKembali =sc.nextLine();
       } 
        while (pesanKembali.equalsIgnoreCase("ya"));
        
        
        

    }
}
