import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class nota {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner sclogin = new Scanner(System.in);
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // buat tanggal
        String tanggal = dateFormat.format(date);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); // buat waktu
        String waktu = timeFormat.format(date);

        String[] user = new String[10];
        String[] pass = new String[10];
        String[] nama = new String[10];

        //dataku
        
        int[] harga = {50000, 80000, 150000};
        
        
        String[] kamar = {"Single", "Double", "Suite"};
        
        

        // admin dari indeks 0 - 4
        user[0] = "admin1"; // username admin
        user[1] = "admin2";

        pass[0] = "admin1"; // password admin
        pass[1] = "admin2";

        nama[0] = "Alexander"; // nama admin
        nama[1] = "Surya";

        // customer dari indeks 5 - 9
        user[5] = "customer1"; // username customer
        user[6] = "customer2";

        pass[5] = "customer1"; // password customer
        pass[6] = "customer2";

        nama[5] = "Gunawan"; // nama customer
        nama[6] = "Wicaksono";

        String username, password;
        boolean login = true;

        while (login) {

            

            System.out.println("\n=================================================");
            System.out.println("\t\t    Login \t\t");
            System.out.println("=================================================");

            System.out.print("Username  \t: ");
            username = sclogin.nextLine();

            System.out.print("Password  \t: ");
            password = sclogin.nextLine();

            if (username.equals(user[0])) {
                if (password.equals(pass[0])) {

                    System.out.println("\n------- Selamat Datang, " + username + "! -------");

                    System.out.println("\n=================================================");
                    System.out.println("\t\t    ADMIN MENU \t\t");
                    System.out.println("=================================================");
                    System.out.print(" 1. Informasi Login");
                    System.out.println("\t\t5. Histori Pemesanan");
                    System.out.print(" 2. Cek Ketersediaan Kamar");
                    System.out.println("\t6. Daftar Nama Pengguna");
                    System.out.print(" 3. Input Kamar Baru");
                    System.out.println("\t\t7. Logout");
                    System.out.print(" 4. Pemesanan Kamar");
                    System.out.println("\t\t8. Tutup Program");
                    System.out.println("=================================================");
                    System.out.print("Silahkan pilih menu (1-8)     : ");
                    int menu = sc.nextInt();
                    switch (menu) {
                        case 1:
                            System.out.println("=================================================");
                            System.out.println("\t\t Informasi Login \t\t");
                            System.out.println("=================================================");
                            System.out.println("Username \t: " + user[0]);
                            System.out.println("Nama \t\t: " + nama[0]);
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
                            System.out.println("\t\t  Input Kamar Baru \t\t");
                            System.out.println("=================================================");
                            break;
                        case 4:
                            System.out.println("=================================================");
                            System.out.println("\t\t  Pemesanan Kamar \t\t");
                            System.out.println("=================================================");
                            break;
                        case 5:
                            System.out.println("\n=================================================");
                            System.out.println("\t\t  Histori Pemesanan \t\t");
                            System.out.println("=================================================");
                            break;
                        case 6:
                            System.out.println("=================================================");
                            System.out.println("\t\t  Daftar Nama Pengguna \t\t");
                            System.out.println("=================================================");
                            break;
                        case 7:
                            System.out.println("Anda Telah Log-Out");
                            return;
                        case 8:
                            System.out.println("\nTerima Kasih telah menggunakan layanan kami!\n");
                            System.exit(0);
                    }
                } else {
                    System.out.println("=== Password Salah ===");
                }
            } else if ((username.equals(user[5]))) {
                if (password.equals(user[5])) {
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
                    // data
            int pilihanKamar;
int perMalam;
int totalPrice;
                    switch (menu) {

                        
                        case 1:
                            System.out.println("=================================================");
                            System.out.println("\t\t Informasi Login \t\t");
                            System.out.println("=================================================");
                            System.out.println("Username \t: " + user[5]);
                            System.out.println("Nama \t\t: " + nama[5]);
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

                            

                            
        

        System.out.println("Silakan pilih jenis kamar yang ingin Anda pesan:");
        System.out.println("1. " + kamar[0] + " - Rp." + harga[0] + "/malam");
        System.out.println("2. " + kamar[1] + " - Rp." + harga[1] + "/malam");
        System.out.println("3. " + kamar[2] + " - Rp." + harga[2] + "/malam");

        System.out.print("Pilihan Anda (1/2/3): ");
         pilihanKamar = sc.nextInt();

        if (pilihanKamar < 1 || pilihanKamar > 3) {
            System.out.println("Pilihan tidak valid. Harap pilih antara 1, 2, atau 3.");
            sc.close();
            return;
        }

        System.out.print("Berapa malam Anda ingin menginap: ");
        perMalam = sc.nextInt();

        totalPrice = harga[pilihanKamar - 1] * perMalam;
        System.out.println("Total harga untuk " + kamar[pilihanKamar - 1] + " selama " + perMalam + " malam adalah Rp." + totalPrice);
                            // abis ini haruse ditambahi cetak data pembelian
                            break;

                        case 4:
                        totalPrice = harga[pilihanKamar - 1] * perMalam;
                        int statusCustomer;
                        double diskon = 0;
                        String cetakNota;
                        double bayar = 0;
                        bayar = totalPrice - diskon;
                            System.out.println("=================================================");
                            System.out.println("\t\t  Pembayaran \t\t");
                            
                            System.out.println("=================================================");
                            
                            System.out.println("Status Pelanggan");
                            System.out.println("1. Member");
                            System.out.println("2. Non Member");
                            System.out.println("Silahkan Pilih Status Anda: ");
                            statusCustomer = sc.nextInt();

                            if (statusCustomer == 1) {
                             if (perMalam >= 3) {
                                diskon = 0.20 * totalPrice;
                             } else if (perMalam >= 7) {
                                diskon = 0.50 * totalPrice;
                             }
                        }   else if (statusCustomer == 2) {
                                if (perMalam >= 3) {
                                    diskon = 0.10 * totalPrice;
                                } else if (perMalam >= 7) {
                                    diskon = 0.25 * totalPrice;
                                }
                        }

                        System.out.println("Apakah anda ingin mencetak nota ? (ya/tidak)");
        cetakNota = sc.nextLine();
        if (cetakNota.equals("ya")) {
            System.out.println("\n======================= NOTA PEMBAYARAN =======================");
            System.out.println("Tanggal Pembayaran              : " + date.toString());
            System.out.println("Nama Anda                       : " + nama);
            System.out.println("Tipe Kamar yang Anda Pilih      : " + pilihanKamar);
            System.out.println("Lama Menginap                   : " + perMalam);
            System.out.println("Status Pelanggan                : " + statusCustomer);
            System.out.println("Total Harga                     : " + totalPrice);
            System.out.println("Diskon Anda Menginap            : " + diskon);
            System.out.println("Anda harus membayar             : " + bayar);
            System.out.println("===============================================================");
        }
            System.out.println("Masukkan Uang Anda: ");
            int membayar = sc.nextInt();

            double kembalian = 0;
            kembalian = membayar - bayar;

            if (membayar - bayar == 0) {
                System.out.println("Pembayaran Anda Berhasil");
            }else if (membayar - bayar > 0) {
                System.out.println("Kembalian Anda: " +kembalian);
            } else if (membayar - bayar < 0) {
                System.out.println("Uang Anda Kurang");
                System.out.println("Silahkan Bayar Dengan Tepat");
            }
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

            } else {
                System.out.println("Username dan Password Anda Salah");
                System.out.println("Silahkan Coba Lagi!");

            }
        }

        sclogin.close();
        sc.close();
        
}

    