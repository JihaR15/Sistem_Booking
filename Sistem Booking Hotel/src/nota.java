import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class nota {

     // scanner
     static Scanner sc = new Scanner(System.in);
     static Scanner sclogin = new Scanner(System.in);
 
     // tgl & waktu
     static Date date = new Date();
     static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // buat tanggal
     static String tanggal = dateFormat.format(date);
     static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); // buat waktu
     static String waktu = timeFormat.format(date);
 
     // user, pw sama nama
     static String[][] user = new String[10][10];
     static String[][] pass = new String[10][10];
     static String[][] nama = new String[10][10];
 
     // array dari kamar
     static String[] tipeKamar = { "Standard", "Deluxe", "Suite" };
     static int[] hargaKamar = { 50000, 80000, 100000 };
     static int[] kamarTersedia = { 10, 10, 5 };
     static int perMalam = 0, totalHarga = 0, inputstatusCustomer, kamar = -1;
     static double diskon = 0, bayar = 0;
     static String cetakNota, pesanKembali, statusCust;
     static int pilihKamar;
 
     // buat batas booking = history booking
     static String[] namaCustomer = new String[50];
     static String[] tipeKamarBooked = new String[50];
     static int[] malamBooking = new int[50];
     static String[] statusCustomerBooked = new String[50];
     static int[] totalHargaBooked = new int[50];
     static double[] diskonBooked = new double[50];
     static double[] bayarBooked = new double[50];
     static int bookingCount = 0;
     static String statusBayar = "Belum Terbayar";
 
     static String username, password, namacust;
     static String customerName;
    
    public static void main(String[] args) {

         // userAdm = admin
         user[0][0] = "admin1"; // username admin
         user[0][1] = "admin2";
 
         pass[0][0] = "admin1"; // password admin
         pass[0][1] = "admin2";
 
         nama[0][0] = "Alexander"; // nama admin
         nama[0][1] = "Surya";
 
         // customer dari indeks 5 - 9
         user[5][0] = "customer1"; // username customer
         user[5][1] = "customer2";
 
         pass[5][0] = "customer1"; // password customer
         pass[5][1] = "customer2";
 
         nama[5][0] = "Gunawan"; // nama customer
         nama[5][1] = "Wicaksono";
 
         while (true) {
 
             System.out.println("\n=================================================");
             System.out.println("\t\t    Login \t\t");
             System.out.println("=================================================");
 
             System.out.print("Username  \t: ");
             username = sclogin.nextLine();
 
             System.out.print("Password  \t: ");
             password = sclogin.nextLine();
 
             for (int i = 0; i < 10; i++) {
                 if (username.equals(user[0][i])) {
                     if (password.equals(pass[0][i])) {
 
                         System.out.println("\n------- Selamat Datang, " + username + "! -------");
 
                         while (true) {
                             System.out.println("\n=================================================");
                             System.out.println("\t\t    ADMIN MENU \t\t");
                             System.out.println("=================================================");
                             System.out.print(" 1. Informasi Login");
                             System.out.println("\t5. Histori Pemesanan");
                             System.out.print(" 2. Ketersediaan Kamar");
                             System.out.println("\t6. Pembayaran");
                             System.out.print(" 3. Input Kamar Baru");
                             System.out.println("\t7. Logout");
                             System.out.print(" 4. Pemesanan Kamar");
                             System.out.println("\t8. Tutup Program");
                             System.out.println("=================================================");
                             System.out.print("Silahkan pilih menu (1-8)     : ");
                             int menu = sc.nextInt();
                             sc.nextLine();
                             switch (menu) {
                                 case 1:
                                     while (true) {
                                         System.out.println("=================================================");
                                         System.out.println("\t\t Informasi Login \t\t");
                                         System.out.println("=================================================");
                                         System.out.println("Username \t: " + username);
                                         System.out.println("Nama \t\t: " + nama[0][i]);
                                         System.out.println("Login pada \t: " + tanggal);
                                         System.out.println("Waktu login \t: " + waktu);
                                         System.out.println("=================================================");
 
                                         System.out.print("\nApakah anda ingin kembali ke menu ? (y) : ");
                                         String kembali = sc.next();
                                         if (kembali.equalsIgnoreCase("y")) {
                                             break;
                                         } else {
                                             System.out.println("input tidak sesuai");
                                         }
 
                                     }
                                 case 2:
                                     System.out.println("=================================================");
                                     System.out.println("\t     Cek Ketersediaan Kamar \t\t");
                                     System.out.println("=================================================");
                                     break;
                                 case 3:
                                     System.out.println("=================================================");
                                     System.out.println("\t\t  Input Kamar Baru \t\t");
                                     System.out.println("=================================================");
                                     break;
                                 case 4:
                                     System.out.println("=================================================");
                                     System.out.println("\t\t  Pemesanan Kamar \t\t");
                                     System.out.println("=================================================");
 
                                     for (int j = 0; j < tipeKamar.length; j++) {
                                         System.out.println((j + 1) + ". " + tipeKamar[j] + " = " + "Rp. "
                                                 + hargaKamar[j] + "/ malam, "
                                                 + kamarTersedia[j] + " kamar tersedia");
                                     }
                                     System.out.println("==========================================");
 
                                     System.out.print(
                                             "Pilih tipe kamar (1-" + tipeKamar.length + ") (0 untuk kembali):  ");
                                     pilihKamar = sc.nextInt();
 
                                     if (pilihKamar >= 1 && pilihKamar <= tipeKamar.length) {
                                         int indexKamar = pilihKamar - 1;
 
                                         System.out.print("Masukkan nama Anda: ");
                                         String customerName = sc.next();
 
                                         System.out.print("Masukkan jumlah malam : ");
                                         perMalam = sc.nextInt();
 
                                         totalHarga = hargaKamar[indexKamar] * perMalam;
 
                                         System.out.println("Status Pelanggan");
                                         System.out.println("1. Member");
                                         System.out.println("2. Non Member");
                                         System.out.print("Status Pelanggan : ");
                                         inputstatusCustomer = sc.nextInt();
                                         sc.nextLine();
 
                                         if (inputstatusCustomer == 1) {
                                             statusCust = "Member";
                                             if (perMalam >= 3) {
                                                 diskon = 0.20 * totalHarga;
                                             } else if (perMalam >= 7) {
                                                 diskon = 0.50 * totalHarga;
                                             }
 
                                         } else if (inputstatusCustomer == 2) {
                                             statusCust = "Non Member";
                                             if (perMalam >= 3) {
                                                 diskon = 0.10 * totalHarga;
                                             } else if (perMalam >= 7) {
                                                 diskon = 0.25 * totalHarga;
                                             }
                                         }
                                         bayar = totalHarga - diskon;
 
                                         System.out.print("Apakah anda ingin mencetak nota ? (y/t)");
                                         cetakNota = sc.nextLine();
                                         if (cetakNota.equals("y")) {
                                             System.out.println(
                                                     "\n======================= NOTA PEMESANAN =======================");
                                             System.out.println("Tanggal Pembayaran              : " + date.toString());
                                             System.out.println("Nama Anda                       : " + customerName);
                                             System.out.println("Tipe Kamar yang Anda Pilih      : " + pilihKamar);
                                             System.out.println("Lama Menginap                   : " + perMalam);
                                             System.out.println("Status Pelanggan                : " + statusCust);
                                             System.out.println("Total Harga                     : " + totalHarga);
                                             System.out.println("Diskon Anda Menginap            : " + diskon);
                                             System.out.println("Anda harus membayar             : " + bayar);
                                             System.out.println(
                                                     "===============================================================");
                                         }
                                         System.out.println("Silahkan membayar di menu pembayaran.");
 
                                         kamarTersedia[indexKamar]--;
 
                                         // Simpan info pemesanan
                                         namaCustomer[bookingCount] = customerName;
                                         tipeKamarBooked[bookingCount] = tipeKamar[indexKamar];
                                         malamBooking[bookingCount] = perMalam;
                                         statusCustomerBooked[bookingCount] = statusCust;
                                         totalHargaBooked[bookingCount] = totalHarga;
                                         diskonBooked[bookingCount] = diskon;
                                         bayarBooked[bookingCount] = bayar;
                                         bookingCount++;
 
                                         while (true) {
 
                                             System.out.print("\nApakah Anda Ingin Memesan Lagi? (y/t)");
                                             pesanKembali = sc.nextLine();
                                             if (pesanKembali.equalsIgnoreCase("y")) {
                                                 return;
                                             } else if (pesanKembali.equalsIgnoreCase("t")) {
                                                 System.out.println("Terima Kasih sudah memesan!");
                                                 break;
                                             } else {
                                                 System.out.println("input tidak sesuai");
 
                                             }
                                         }
                                     }
                                     break;
                                 case 5:
                                     System.out.println("\n=================================================");
                                     System.out.println("\t\t  Histori Pemesanan \t\t");
                                     System.out.println("=================================================");
                                     
                                     if (bookingCount == 0) {
                                         System.out.println("Belum ada pemesanan.");
                                         
                                     } 
                                         for (int j = 0; j < bookingCount; j++) {
                                             System.out.println("No.              : " + (j + 1));
                                             System.out.println("Nama             : " + namaCustomer[j]);
                                             System.out.println("Tipe Kamar       : " + tipeKamarBooked[j]);
                                             System.out.println("Malam menginap   : " + malamBooking[j]);
                                             System.out.println("waktu pemesanan  : " + waktu + " pada tgl " + tanggal);
                                             System.out.println("Status pelanggan : " + statusCustomerBooked[j]);
                                             System.out.println("Total Harga      : " + totalHargaBooked[j]);
                                             System.out.println("Diskon           : " + diskonBooked[j]);
                                             System.out.println("Bayar            : " + bayarBooked[j]);
                                             System.out.println("Status pembayaran:" + statusBayar);
                                             System.out.println("==========================");
                                         
 
                                     }
 
                                     while (true) {
                                         System.out.print("\nApakah anda ingin kembali ke menu ? (y) : ");
                                         String kembali = sc.next();
                                         if (kembali.equalsIgnoreCase("y")) {
                                             break;
                                         } else {
                                             System.out.println("input tidak sesuai");
                                         }
                                     }
                                     break;
 
                                 case 6:
                                     System.out.println("=================================================");
                                     System.out.println("\t\t  Pembayaran \t\t");
                                     System.out.println("=================================================");
 
                                     if (bookingCount == 0) {
                                         System.out.println("Belum ada pemesanan.");
                                     }
 
 
                                     for (int j = 0; j < bookingCount; j++) {
                                     if (bayarBooked[j] == 0) {
                                         System.out.println("Belum ada pemesanan.");
                                         break;
                                     }
                                     System.out.println("Anda harus membayar : " + bayarBooked[j]);
                                     System.out.println("Masukkan Nominal yang ingin dibayarkan : ");
                                     int bayarTunai = sc.nextInt();
                                     if (bayarTunai >= bayarBooked[j]) {
                                         double kembalian = bayarTunai - bayarBooked[j];
                                         System.out.println("Kembalian : " + kembalian);
                                         System.out.println("Terima kasih telah membayar");
                                         statusBayar = "Terbayar";
                                         bayarBooked[j] = 0;
                                         kembalian = 0;                      
                                         
                                     } else {
                                         System.out.println("Uang yang anda masukkan kurang");
                                         
                                     }
                                     
                                 }
                                 break;
                                 case 7:
                                     System.out.println("Anda Telah Log-Out");
                                     return;
                                 case 8:
                                     System.out.println("\nTerima Kasih telah menggunakan layanan kami!\n");
                                     System.exit(0);
                             }
                         }
                     } else {
                         System.out.println("=== Password Salah ===");
                     }
 
                 }
 
                 for (int j = 0; j < 10; j++) {
                     if ((username.equals(user[5][j]))) {
                         if (password.equals(pass[5][j])) {
                             System.out.println("------- Selamat Datang, " + username + "! -------");
                             System.out.println("\n=================================================");
                             System.out.println("\t\t    MENU \t\t");
                             System.out.println("=================================================");
                             System.out.print("1. Informasi Login");
                             System.out.println("\t\t5. Histori Pemesanan");
                             System.out.print("2. Cek Ketersediaan Kamar");
                             System.out.println("\t6. Logout");
                             System.out.print("3. Pemesanan Kamar");
                             System.out.println("\t\t7. Tutup Program");
                             System.out.println("4. Pembayaran");
                             System.out.println("=================================================");
                             System.out.print("Silahkan pilih menu (1-7)     : ");
                             int menu = sc.nextInt();
                             switch (menu) {
                                 case 1:
                                     System.out.println("=================================================");
                                     System.out.println("\t\t Informasi Login \t\t");
                                     System.out.println("=================================================");
                                     System.out.println("Username \t: " + username);
                                     System.out.println("Nama \t\t: " + nama[5][j]);
                                     System.out.println("Login pada \t: " + tanggal);
                                     System.out.println("Waktu login \t: " + waktu);
                                     System.out.print("Apakah anda ingin kembali ke menu ? (y/t) : ");
                                     String kembali = sc.next();
                                     if (kembali.equalsIgnoreCase("y")) {
                                         break;
                                     }
                                     break;
                                 case 2:
                                     System.out.println("=================================================");
                                     System.out.println("\t     Cek Ketersediaan Kamar \t\t");
                                     System.out.println("=================================================");
                                     break;
                                 case 3:
                                     System.out.println("=================================================");
                                     System.out.println("\t\t  Pemesanan Kamar \t\t");
                                     System.out.println("=================================================");
 
                                     for (int k = 0; k < tipeKamar.length; k++) {
                                         System.out.println((k + 1) + ". " + tipeKamar[k] + " = " + "Rp. "
                                                 + hargaKamar[k] + "/ malam, "
                                                 + kamarTersedia[k] + " kamar tersedia");
                                     }
                                     System.out.println("==========================================");
 
                                     System.out.print(
                                             "Pilih tipe kamar (1-" + tipeKamar.length + ") (0 untuk kembali):  ");
                                     pilihKamar = sc.nextInt();
 
                                     if (pilihKamar >= 1 && pilihKamar <= tipeKamar.length) {
                                         int indexKamar = pilihKamar - 1;
 
                                         System.out.print("Masukkan nama Anda: ");
                                         String customerName = sc.next();
 
                                         System.out.print("Masukkan jumlah malam : ");
                                         perMalam = sc.nextInt();
 
                                         totalHarga = hargaKamar[indexKamar] * perMalam;
 
                                         System.out.println("Status Pelanggan");
                                         System.out.println("1. Member");
                                         System.out.println("2. Non Member");
                                         System.out.print("Status Pelanggan : ");
                                         inputstatusCustomer = sc.nextInt();
                                         sc.nextLine();
 
                                         if (inputstatusCustomer == 1) {
                                             statusCust = "Member";
                                             if (perMalam >= 3) {
                                                 diskon = 0.20 * totalHarga;
                                             } else if (perMalam >= 7) {
                                                 diskon = 0.50 * totalHarga;
                                             }
 
                                         } else if (inputstatusCustomer == 2) {
                                             statusCust = "Non Member";
                                             if (perMalam >= 3) {
                                                 diskon = 0.10 * totalHarga;
                                             } else if (perMalam >= 7) {
                                                 diskon = 0.25 * totalHarga;
                                             }
                                         }
                                         bayar = totalHarga - diskon;
 
                                         System.out.print("Apakah anda ingin mencetak nota ? (y/t)");
                                         cetakNota = sc.nextLine();
                                         if (cetakNota.equals("y")) {
                                             System.out.println(
                                                     "\n======================= NOTA PEMESANAN =======================");
                                             System.out.println("Tanggal Pembayaran              : " + date.toString());
                                             System.out.println("Nama Anda                       : " + customerName);
                                             System.out.println("Tipe Kamar yang Anda Pilih      : " + pilihKamar);
                                             System.out.println("Lama Menginap                   : " + perMalam);
                                             System.out.println("Status Pelanggan                : " + statusCust);
                                             System.out.println("Total Harga                     : " + totalHarga);
                                             System.out.println("Diskon Anda Menginap            : " + diskon);
                                             System.out.println("Anda harus membayar             : " + bayar);
                                             System.out.println(
                                                     "===============================================================");
                                         }
                                         System.out.println("Silahkan membayar di menu pembayaran.");
 
                                         kamarTersedia[indexKamar]--;
 
                                         // Simpan info pemesanan
                                         namaCustomer[bookingCount] = customerName;
                                         tipeKamarBooked[bookingCount] = tipeKamar[indexKamar];
                                         malamBooking[bookingCount] = perMalam;
                                         statusCustomerBooked[bookingCount] = statusCust;
                                         totalHargaBooked[bookingCount] = totalHarga;
                                         diskonBooked[bookingCount] = diskon;
                                         bayarBooked[bookingCount] = bayar;
                                         bookingCount++;
 
                                         while (true) {
 
                                             System.out.print("\nApakah Anda Ingin Memesan Lagi? (y/t)");
                                             pesanKembali = sc.nextLine();
                                             if (pesanKembali.equalsIgnoreCase("y")) {
                                                 return;
                                             } else if (pesanKembali.equalsIgnoreCase("t")) {
                                                 System.out.println("Terima Kasih sudah memesan!");
                                                 break;
                                             } else {
                                                 System.out.println("input tidak sesuai");
 
                                             }
                                         }
                                     }
                                         break;
 
                                 case 4:
                                     int membayar=0;
                                     


                                      System.out.println(
                                                     "\n======================= NOTA PEMESANAN =======================");
                                             System.out.println("Tanggal Pembayaran              : " + date.toString());
                                             System.out.println("Nama Anda                       : " + customerName);
                                             System.out.println("Tipe Kamar yang Anda Pilih      : " + pilihKamar);
                                             System.out.println("Lama Menginap                   : " + perMalam);
                                             System.out.println("Status Pelanggan                : " + statusCust);
                                             System.out.println("Total Harga                     : " + totalHarga);
                                             System.out.println("Diskon Anda Menginap            : " + diskon);
                                             System.out.println("Anda harus membayar             : " + bayar);
                                             System.out.println("Status Pembayaran Anda          : " + statusBayar);
                                             System.out.println(
                                                     "===============================================================");
                                                System.out.println("Tagihan Anda Sebesar        : " + bayar);
                                             System.out.println("Masukkan Uang Anda : ");
                                             membayar = sc.nextInt();

                                             if (membayar == bayar) {
                                                System.out.println("Tagihan Anda Sudah Lunas Selamat Menginap");
                                             } else if (membayar < bayar) {
                                                System.out.println("Maaf Uang Anda Kurang Sebesar : " + (bayar - membayar));
                                             } else if (membayar > bayar) {
                                                System.out.println("Tagihan Anda Sudah Lunas");
                                                System.out.println("Kembalian Anda Sebesar : " + (membayar - bayar));
                                             } else 
                                                System.out.println("Anda Masih Mempunyai Tagihan Yang Belum Dibayar");







                                        
                                     break;
                                 case 5:
                                     System.out.println("\n=================================================");
                                     System.out.println("\t\t  Histori Pemesanan \t\t");
                                     System.out.println("=================================================");
                                     break;
                                 case 6:
                                     System.out.println("Anda Telah Log-Out");
                                     return;
                                 case 7:
                                     System.out.println("\nTerima Kasih telah menggunakan layanan kami!\n");
                                     System.exit(0);
 
                             }
 
                         } else {
                             System.out.println("== Password Customer Salah ");
                         }
 
                     }
                 }
             }
             
             System.out.println("Username dan Password Anda Salah");
             System.out.println("Silahkan Coba Lagi!");
 
         }

    }
}