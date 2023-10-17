import java.util.Scanner;
public class InputPemesanan {
           public static void main(String[] args) {
              String nama, nomerTelp, tipeKamar, kmr1 = "standard", kmr2 = "deluxe", kmr3 = "suite", pilKonfirmasi;
               int jumlahOrg, jumlahKmr, perMalam,totalHarga, hargaKmr1 = 50000, hargaKmr2 = 80000, hargaKmr3 = 100000;
               boolean isConfirmed;
               Scanner scanner = new Scanner(System.in);
       
               System.out.println("Selamat datang di hotel kami!");
               System.out.print("Masukkan nama Anda                : ");
               nama = scanner.nextLine();
               System.out.print("Masukkan nomor telepon Anda       : ");
               nomerTelp = scanner.nextLine();
               System.out.print("Masukkan jumlah orang             : ");
               jumlahOrg = scanner.nextInt();
               System.out.print("Masukkan jumlah malam             : ");
               perMalam = scanner.nextInt();
               System.out.print("Masukkan jumlah kamar yang dipesan: ");
               jumlahKmr = scanner.nextInt();
               scanner.nextLine();

               System.out.println("\n====== KATEGORI KAMAR ======");
               System.out.println("| "+ kmr1 + " - Rp." + hargaKmr1 + "/malam  |");
               System.out.println("| "+ kmr2 + " - Rp." + hargaKmr2 + "/malam  |");
               System.out.println("| "+ kmr3 + " - Rp." + hargaKmr3 + "/malam  |");
               System.out.println("============================");
               System.out.println("Pilih tipe kamar (standard/deluxe/suite): ");
                tipeKamar = scanner.nextLine();
                switch (tipeKamar) {
                   case "standard":
                       totalHarga =   hargaKmr1 * perMalam;
                       int total = totalHarga * jumlahKmr;
                       System.out.println("Total harga untuk " + kmr1 + " selama " + perMalam + " jumlah kamar " + jumlahKmr +" adalah  Rp." + total);
                       break;
                   case "deluxe":
                       totalHarga =   hargaKmr2 * perMalam;
                       System.out.println("Total harga untuk " + kmr1 + " selama " + perMalam + " malam adalah Rp." + totalHarga);
                       break;
                   case "suite":
                       totalHarga =   hargaKmr3 * perMalam;
                       System.out.println("Total harga untuk " + kmr1 + " selama " + perMalam + " malam adalah Rp." + totalHarga);
                       break;
                   default:
                       break;
               }
   
               System.out.println("\nRincian Reservasi:");
               System.out.print("Apakah Anda ingin mengkonfirmasi reservasi ini? (ya/tidak): ");
               pilKonfirmasi = scanner.nextLine();
       
               if (pilKonfirmasi.equalsIgnoreCase("ya")) {
                   
                   System.out.println("Reservasi telah dikonfirmasi.");
               } else {
                   System.out.println("Reservasi tidak dikonfirmasi.");
               }
       
               System.out.println("\nTerima kasih telah reservasi di hotel kami!");
               scanner.close();
           }
  }     
   
    
