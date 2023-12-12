import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Booking_Function {

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
    static String[][] user = new String[2][50];
    static String[][] pass = new String[2][50];
    static String[][] nama = new String[2][50];

    // array dari kamar
    static String[] tipeKamar = { "Standard", "Deluxe", "Suite" };
    static String[] detailKamar = { "-Ranjang \t-kamar mandi \n-TV \t\t-AC \n-telepon",
            "(+ Fasilitas Standar)\n-Ruang duduk \n-peralatan elektronik tambahan \n-perlengkapan mandi lengkap",
            "(+ Fasilitas Standar & Deluxe)\n-Ruang tamu besar \t-dapur kecil \n-layanan kamar 24 jam " };
    static int[] hargaKamar = { 50000, 80000, 100000 };
    static int[] kamarTersedia = { 10, 10, 5 };
    static int perMalam = 0, totalHarga = 0, inputstatusCustomer, kamar = -1;
    static double diskon = 0, bayar = 0;
    static String cetakNota, pesanKembali, statusCust;
    static int pilihKamar, menu;

    // buat batas booking = history booking
    static String[] namaCustomer = new String[50];
    static String[] tipeKamarBooked = new String[50];
    static int[] malamBooking = new int[50];
    static String[] statusCustomerBooked = new String[50];
    static int[] totalHargaBooked = new int[50];
    static double[] diskonBooked = new double[50];
    static double[] bayarBooked = new double[50];
    static Boolean[] statusBayarBooked = new Boolean[50];
    static Boolean statusBayar = true;
    static int bookingCount = 0;
    static int bayarCount;

    static String username, password, namacust, ulangiPass, newUsername, newPassword;
    static String customerName, newNama;
    static double totalPendapatan = 0;

    public static void main(String[] args) {
        // userAdm = admin baris ke 1 (indeks 0)
        user[0][0] = "admin1"; // username admin
        user[0][1] = "admin2";

        pass[0][0] = "admin1"; // password admin
        pass[0][1] = "admin2";

        nama[0][0] = "Alexander"; // nama admin
        nama[0][1] = "Surya";

        // customer baris ke 2 (indeks 1)
        user[1][0] = "customer1"; // username customer
        user[1][1] = "customer2";

        pass[1][0] = "customer1"; // password customer
        pass[1][1] = "customer2";

        nama[1][0] = "Gunawan"; // nama customer
        nama[1][1] = "Wicaksono";

        while (true) {
            System.out.println("\n=================================================");
            System.out.println("|\t    Selamat Datang Di Hotel 1C   \t|");
            System.out.println("=================================================");
            System.out.println("| \t\t (1) Login \t\t\t|");
            System.out.println("| \t\t (2) Register\t\t\t|");
            System.out.println("| \t\t (3) Exit\t\t\t|");
            System.out.println("=================================================");
            System.out.print("Silahkan pilih menu (1-3)\t: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("\nTerima Kasih telah menggunakan layanan kami!\n");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void login() {
        System.out.println("\n=================================================");
        System.out.println("|\t\t     Login \t\t        |");
        System.out.println("=================================================");

        System.out.print("Username  \t: ");
        username = sclogin.nextLine();

        System.out.print("Password  \t: ");
        password = sclogin.nextLine();

        if (username.equalsIgnoreCase("0") && (password.equalsIgnoreCase("0"))) {
            return;
        }

        for (int i = 0; i < user[0].length; i++) {
            if (username.equals(user[0][i])) {
                if (password.equals(pass[0][i])) {
                    System.out.println("-------------------------------------------------");
                    System.out.println("    ------- Selamat Datang, " + username + "! -------");
                    while (true) {
                        System.out.println("\n=================================================");
                        System.out.println("|\t\t  ADMIN MENU \t\t        |");
                        System.out.println("=================================================");
                        System.out.println("[1] Informasi Login\t[6] Histori Pemesanan");
                        System.out.println("[2] Ketersediaan Kamar\t[7] Laporan Bulanan");
                        System.out.println("[3] Input Kamar Baru\t[8] Daftar Nama Pengguna");
                        System.out.println("[4] Pemesanan Kamar\t[9] Logout");
                        System.out.println("[5] Pembayaran\t\t[10] Tutup Program");
                        System.out.println("=================================================");
                        System.out.print("Silahkan pilih menu (1-8)     : ");
                        menu = sc.nextInt();
                        switch (menu) {
                            case 1:
                                infoLogin(i);
                                kembali();
                                break;
                            case 2:
                                ketersediaanKamar();
                                break;
                            case 3:
                                System.out.println("=================================================");
                                System.out.println("\t\t  Input Kamar Baru \t\t");
                                System.out.println("=================================================");
                                break;
                            case 4:
                                pemesananKamar();
                                break;
                            case 5:
                                pembayaran();
                                kembali();
                                break;
                            case 6:
                                historiPemesanan();
                                kembali();
                                break;
                            case 7:
                                laporan();
                                kembali();
                                break;
                            case 8:
                                System.out.println("=================================================");
                                System.out.println("\t      Daftar Nama Pengguna \t\t");
                                System.out.println("=================================================");
                                System.out.println("-------------------- Admin -------------------");
                                for (int j = 0; j < user[1].length; j++) {
                                    if (user[0][j] != null) {
                                        System.out.println((j + 1) + ". " + user[0][j]);        
                                    }
                                }
                                System.out.println("-------------------- Customer ------------------");
                                for (int j = 0; j < user[1].length; j++) {
                                    if (user[1][j] != null) {
                                        System.out.println((j + 1) + ". " + user[1][j]);        
                                    }
                                }
                                kembali();
                                break;
                            case 9:
                                System.out.println("Anda Telah Log-Out");
                                return;
                            case 10:
                                System.out.println("\nTerima Kasih telah menggunakan layanan kami!\n");
                                System.exit(0);
                        }
                    }
                }
                // else {
                // System.out.println("=================================================");
                // System.out.println(" === Password Salah ===");
                // }
            }
        }

        for (int j = 0; j < user[1].length; j++) {
            if ((username.equals(user[1][j]))) {
                if (password.equals(pass[1][j])) {
                    System.out.println("------- Selamat Datang, " + username + "! -------");
                    while (true) {
                        System.out.println("\n=================================================");
                        System.out.println("|\t\t      MENU\t\t        |");
                        System.out.println("=================================================");
                        System.out.println("[1] Informasi Login\t[5] Histori Pemesanan");
                        System.out.println("[2] Ketersediaan Kamar\t[6] Logout");
                        System.out.println("[3] Pemesanan Kamar\t[7] Tutup Program");
                        System.out.println("[4] Pembayaran");
                        System.out.println("=================================================");
                        System.out.print("Silahkan pilih menu (1-7)     : ");
                        menu = sc.nextInt();
                        switch (menu) {
                            case 1:
                                infoLoginCust(j);
                                kembali();
                                break;
                            case 2:
                                ketersediaanKamar();
                                break;
                            case 3:
                                pemesananKamar();
                                break;
                            case 4:
                                pembayaran();
                                kembali();
                                break;
                            case 5:
                                historiPemesanan();
                                kembali();
                                break;
                            case 6:
                                System.out.println("=== Anda Telah Log-Out ===");
                                return;

                            case 7:
                                System.out.println("\nTerima Kasih telah menggunakan layanan kami!\n");
                                System.exit(0);
                        }
                    }
                }
                // else {
                // System.out.println("=================================================");
                // System.out.println(" === Password Customer Salah ===");
                // }
            }
        }

        System.out.println("=================================================");
        System.out.println("  === Username & Password Anda Tidak Sesuai ===");
        System.out.println("          === Silahkan Coba Lagi! ===");
        System.out.println("    (Ketik 0 untuk Kembali ke Menu Utama)");
        login();

    }

    public static void register() {
        System.out.println("\n=================================================");
        System.out.println("|\t\t     Register \t\t        |");
        System.out.println("=================================================");
        while (true) {
            System.out.print("Masukkan nama anda     : ");
            newNama = sclogin.nextLine();
            System.out.print("Masukkan username baru : ");
            newUsername = sclogin.nextLine();

            while (true) {
                boolean isUsernameAda = false;

                for (int i = 0; i < user[0].length; i++) {
                    if (newUsername.equals(user[0][i]) || newUsername.equals(user[1][i])) {
                        isUsernameAda = true;
                        break;
                    }
                }

                if (isUsernameAda) {
                    System.out.println("Username sudah digunakan. Silahkan pilih username lain!");
                    System.out.print("Masukkan username baru : ");
                    newUsername = sclogin.nextLine();
                } else {
                    break;
                }
            }

            System.out.print("Masukkan password baru : ");
            newPassword = sclogin.nextLine();

            String isAdminInput;
            do {
                System.out.print("Apakah anda admin? (ya/tidak): ");
                isAdminInput = sclogin.nextLine();

            } while (!isAdminInput.equalsIgnoreCase("ya") && !isAdminInput.equalsIgnoreCase("tidak"));

            if (isAdminInput.equalsIgnoreCase("ya")) {
                for (int i = 0; i < user[0].length; i++) {
                    if (user[0][i] == null) {
                        user[0][i] = newUsername;
                        pass[0][i] = newPassword;
                        nama[0][i] = newNama;
                        System.out.println("=================================================");
                        System.out.println("           === Registrasi berhasil! ===");
                        System.out.println("              Silahkan Login " + newNama + "!");
                        return;
                    }
                }
            } else if (isAdminInput.equalsIgnoreCase("tidak")) {
                for (int j = 0; j < user[1].length; j++) {
                    if (user[1][j] == null) {
                        user[1][j] = newUsername;
                        pass[1][j] = newPassword;
                        nama[1][j] = newNama;

                        System.out.println("=================================================");
                        System.out.println("            Registrasi berhasil!");
                        System.out.println("        Silahkan Login " + newNama + " !");
                        return;
                    }
                }
            } else {
                System.out.println("Masukkan 'ya' atau 'tidak'");
            }
        }
    }

    public static void infoLogin(int i) {
        System.out.println("=================================================");
        System.out.println("\t\t Informasi Login \t\t");
        System.out.println("=================================================");
        System.out.println("Username \t: " + username);
        System.out.println("Nama \t\t: " + nama[0][i]);
        System.out.println("Login pada \t: " + tanggal);
        System.out.println("Waktu login \t: " + waktu);
        System.out.println("=================================================");
    }

    public static void infoLoginCust(int j) {
        System.out.println("=================================================");
        System.out.println("\t\t Informasi Login \t\t");
        System.out.println("=================================================");
        System.out.println("Username \t: " + username);
        System.out.println("Nama \t\t: " + nama[1][j]);
        System.out.println("Login pada \t: " + tanggal);
        System.out.println("Waktu login \t: " + waktu);
        System.out.println("=================================================");
    }

    public static void ketersediaanKamar() {
        System.out.println("=================================================");
        System.out.println("\t     Cek Ketersediaan Kamar \t\t");
        System.out.println("=================================================");
        for (int k = 0; k < tipeKamar.length; k++) {
            System.out
                    .println("[" + (k + 1) + "] " + tipeKamar[k] + "\t: " + kamarTersedia[k]
                            + " kamar tersedia");
        }
        System.out.println("=================================================");
        System.out.println("Untuk Melihat Informasi Kamar... (0 untuk kembali)");
        System.out.print("Masukkan nomor kamar yang ingin dilihat : ");
        int kamar = sc.nextInt();

        if (kamar == 0) {
            return;
        }

        for (int k = 0; k < tipeKamar.length; k++) {
            if (tipeKamar[k] == tipeKamar[kamar - 1]) {
                System.out.println("=================================================");
                System.out.println("                Informasi Kamar  ");
                System.out.println("=================================================");
                System.out.println("Tipe Kamar \t: " + tipeKamar[k]);
                System.out.println("Harga Kamar \t: Rp." + hargaKamar[k] + " / malam");
                System.out.println("Ketersediaan \t: " + kamarTersedia[k]);
                System.out.println("-----------------------------------------");
                System.out.println("|\t\tFasilitas\t\t|");
                System.out.println("-----------------------------------------");
                System.out.println(detailKamar[k]);
                System.out.println("-----------------------------------------");

                System.out.println("=================================================");

                while (true) {
                    System.out.print("kembali? (y) : ");
                    String kembali = sc.next();
                    if (kembali.equalsIgnoreCase("y")) {
                        ketersediaanKamar();
                        break;
                    } else {
                        System.out.println("input tidak sesuai");
                    }
                }
            }
        }
    }

    public static void inputKamar() {

    }

    public static void pemesananKamar() {
        System.out.println("=================================================");
        System.out.println("\t\t Pemesanan Kamar \t\t");
        System.out.println("=================================================");

        if (statusBayar == false) {
            System.out.println("Lakukan pembayaran terlebih dahulu untuk pemesanan sebelumnya!!");
            return;
        } else {
            for (int j = 0; j < tipeKamar.length; j++) {
                System.out.println("[" + (j + 1) + "] " + tipeKamar[j] + " \t= " + "Rp. "
                        + hargaKamar[j] + " / malam ");
            }
            System.out.println("=================================================");

            System.out.print(
                    "Pilih tipe kamar (1-" + tipeKamar.length + ") (0 untuk kembali):  ");
            pilihKamar = sc.nextInt();

            if (pilihKamar >= 1 && pilihKamar <= tipeKamar.length) {
                int indexKamar = pilihKamar - 1;

                System.out.print("Masukkan nama Anda    : ");
                customerName = sc.next();

                System.out.print("Masukkan jumlah malam : ");
                perMalam = sc.nextInt();

                totalHarga = hargaKamar[indexKamar] * perMalam;

                System.out.println("Status Pelanggan");
                System.out.println("[1] Member");
                System.out.println("[2] Non Member");
                System.out.print("Status Pelanggan (1/2) : ");
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

                System.out.println("Total biaya Pemesanan : " + bayar);

                System.out.print("Apakah anda ingin mencetak nota ? (y/t) : ");
                cetakNota = sc.nextLine();

                if (cetakNota.equalsIgnoreCase("y")) {
                    System.out.println("\n======================= NOTA PEMESANAN =======================");
                    System.out.println("Tanggal Pemesanan               : " + date.toString());
                    System.out.println("Nama Anda                       : " + customerName);
                    System.out.println("Tipe Kamar yang Anda Pilih      : " + tipeKamar[indexKamar]);
                    System.out.println("Lama Menginap                   : " + perMalam);
                    System.out.println("Status Pelanggan                : " + statusCust);
                    System.out.println("Total Harga                     : " + totalHarga);
                    System.out.println("Diskon Anda Menginap            : " + diskon);
                    System.out.println("Anda harus membayar             : " + bayar);
                    System.out.println("===============================================================");
                }
                System.out.print("Apakah Anda ingin mengkonfirmasi reservasi ini? (ya/tidak): ");
                String pilKonfirmasi = sc.nextLine();
                if (pilKonfirmasi.equalsIgnoreCase("ya")) {
                    statusBayar = false;
                    System.out.println("Reservasi telah dikonfirmasi.");
                    System.out.println("Terima kasih telah reservasi di hotel kami!");
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

                    statusBayarBooked[bookingCount] = statusBayar;
                    bookingCount++;

                } else if (pilKonfirmasi.equalsIgnoreCase("tidak")) {
                    System.out.println("Reservasi tidak dikonfirmasi.");
                } else {
                    System.out.println("Pilihan tidak valid.");

                }

            }
        }
    }

    public static void historiPemesanan() {
        System.out.println("\n=================================================");
        System.out.println("\t\t  Histori Pemesanan \t\t");
        System.out.println("=================================================");

        if (bookingCount == 0) {
            System.out.println("Belum ada pemesanan.");

        }
        for (int j = 0; j < bookingCount; j++) {
            System.out.println("No.                 : " + (j + 1));
            System.out.println("Nama                : " + namaCustomer[j]);
            System.out.println("Tipe Kamar          : " + tipeKamarBooked[j]);
            System.out.println("Malam menginap      : " + malamBooking[j]);
            System.out.println("waktu pemesanan     : " + waktu + " pada tgl " + tanggal);
            System.out.println("Status pelanggan    : " + statusCustomerBooked[j]);
            System.out.println("Total Harga         : " + totalHargaBooked[j]);
            System.out.println("Diskon              : " + diskonBooked[j]);
            System.out.println("Bayar               : " + (totalHargaBooked[j] - diskonBooked[j]));
            System.out.println("Status pembayaran   : " + statusBayarBooked[j]);
            System.out.println("=================================================");

        }

    }

    public static void pembayaran() {
        System.out.println("=================================================");
        System.out.println("\t\t  Pembayaran \t\t");
        System.out.println("=================================================");

        if (bookingCount == 0) {
            System.out.println("Belum ada pemesanan.");
        }

        for (int j = bayarCount; j < bookingCount; j++) {
            if (bayarBooked[j] == 0) {
                System.out.println("Belum ada pemesanan..");
                break;
            }
            System.out.println("Anda harus membayar : " + bayarBooked[j]);

            while (true) {
                System.out.println("Masukkan Nominal yang ingin dibayarkan : ");
                double bayarTunai = sc.nextInt();

                if (bayarTunai >= bayarBooked[j]) {
                    double kembalian = bayarTunai - bayarBooked[j];
                    System.out.println("Kembalian : " + kembalian);
                    System.out.println("Terima kasih telah membayar!!");
                    statusBayarBooked[j] = true;
                    statusBayar = true;
                    bayarBooked[j] = 0;
                    break;
                } else {
                    System.out.println("Uang yang anda masukkan kurang");
                }
            }
            bayarCount++;
        }
    }

    public static void laporan() {
        System.out.println("==================================================================================================================================");
        System.out.println("\t\t\t  Laporan Bulanan \t\t\t");
        System.out.println("==================================================================================================================================");;  
        System.out.println("Bulan   : " + getBulan()); 
        System.out.println("Tahun   : " + getTahun());
        System.out.println("Tanggal pembuatan laporan : " + date.toString());
    
        if (bookingCount > 0) {
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
            "Nama Customer", "Tipe Kamar", "Malam", "Status", "Total Harga", "Diskon", "Bayar");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < bookingCount; i++) {
                bayarBooked[i] = totalHargaBooked[i] - diskonBooked[i];
                bayarBooked[i] = totalHargaBooked[i] - diskonBooked[i];
                System.out.printf("| %-20s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                        namaCustomer[i], tipeKamarBooked[i],
                        malamBooking[i], statusCustomerBooked[i], totalHargaBooked[i], diskonBooked[i], bayarBooked[i]);
                        totalPendapatan += bayarBooked[i];
                    }
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
                } else {
                    System.out.println("Belum ada data booking untuk bulan ini.");
                }
            System.out.println("============================================================");
            System.out.printf("| %-20s | %-33s |\n", "Total Pendapatan", "Rp. " + totalPendapatan);
            System.out.println("============================================================\n");
        }

        public static String getBulan(){
            String[] namaBulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September",
                              "Oktober", "November", "Desember"};
            return namaBulan[date.getMonth()] ;
        }
        
        static int getTahun() {
            return Integer.parseInt(tanggal.substring(6));
        }

    public static void kembali() {
        while (true) {
            System.out.print("Apakah anda ingin kembali ke menu ? (y) : ");
            String kembali = sc.next();
            if (kembali.equalsIgnoreCase("y")) {
                return;
            } else {
                System.out.println("input tidak sesuai");
            }
        }
    }
}
