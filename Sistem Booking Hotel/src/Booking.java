import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Booking {
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

                            String kmr1 = "Single", kmr2 = "Double", kmr3 = "Suite", namacust;
                            int hargaKmr1 = 50000, hargaKmr2 = 80000, hargaKmr3 = 100000, perMalam, pilihanKamar;
                            System.out.println("====== KATEGORI KAMAR ======");
                            System.out.println("|1. " + kmr1 + " - Rp." + hargaKmr1 + "/malam  |");
                            System.out.println("|2. " + kmr2 + " - Rp." + hargaKmr2 + "/malam  |");
                            System.out.println("|3. " + kmr3 + " - Rp." + hargaKmr3 + "/malam  |");
                            System.out.println("============================");

                            System.out.print("Kamar yang anda plih yaitu: ");
                            pilihanKamar = sc.nextInt();

                            if (pilihanKamar <= 3) {
                                if (pilihanKamar == 1)
                                    System.out.println("1. " + kmr1 + " - Rp." + hargaKmr1 + "/malam");
                                else if (pilihanKamar == 2)
                                    System.out.println("2. " + kmr2 + " - Rp." + hargaKmr2 + "/malam");
                                else
                                    System.out.println("3. " + kmr3 + " - Rp." + hargaKmr3 + "/malam");
                            } else
                                System.out.println("Pilihan Anda Tidak Sesuai");
                            System.out.print("\nAtas nama siapa: ");
                            namacust = sc.next();
                            System.out.print("Halo " + namacust + ", Berapa malam Anda ingin menginap: ");
                            perMalam = sc.nextInt();
                            if (pilihanKamar <= 3) {
                                if (pilihanKamar == 1)
                                    System.out.println("Total harga untuk " + kmr1 + " selama " + perMalam
                                            + " malam adalah Rp." + hargaKmr1 * perMalam);
                                else if (pilihanKamar == 2)
                                    System.out.println("Total harga untuk " + kmr2 + " selama " + perMalam
                                            + " malam adalah Rp." + hargaKmr2 * perMalam);
                                else
                                    System.out.println("Total harga untuk " + kmr3 + " selama " + perMalam
                                            + " malam adalah Rp." + hargaKmr3 * perMalam);
                            } else
                                System.out.println(" ");

                            // abis ini haruse ditambahi cetak data pembelian
                            break;

                        case 4:
                            System.out.println("=================================================");
                            System.out.println("\t\t  Pembayaran \t\t");
                            System.out.println("=================================================");
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

        sc.close();
    }
}
