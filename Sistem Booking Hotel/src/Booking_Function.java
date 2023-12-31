import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


public class Booking_Function {

    // scanner
    static Scanner sc = new Scanner(System.in);
    static Scanner sclogin = new Scanner(System.in);

    // tgl & waktu
    static Date date = new Date();
    static LocalDate today = LocalDate.now();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy") /* buat tanggal*/
                        ,   timeFormat = new SimpleDateFormat("HH:mm:ss"); // buat waktu
    static String tanggal = dateFormat.format(date)
                , waktu = timeFormat.format(date);

    // user, pw sama nama
    static String[][] user = new String[2][50];
    static String[][] pass = new String[2][50];
    static String[][] nama = new String[2][50];

    // array dari kamar
    static String[][] tipeDetailKamar = new String[2][10]; // 0 = tipe kamar, 1 = detail kamar
    static int[][] hargaKamarTersedia = new int[2][10]; // 0 = harga, 1 = kamar tersedia

    // buat batas booking = history booking 
    //==================================================================================================================   
    static int MaxBooking = 50; // batas bookingnya
    /*  0 = nama customer, 1 = username konfirmasi, 2 = tipe kamar, 3 = status customer, 4 = check in, 5 = check out */
    static String[][] historyBooking = new String[6][MaxBooking];
    
    static int[] malamBooking = new int[MaxBooking];
    /* 0 = total harga, 1 = diskon, 2 = bayar */
    static double[][] hargaHistoryBooking = new double[3][MaxBooking];
    
    static Boolean[] statusBayarBooked = new Boolean[MaxBooking];

    static Boolean statusBayar = true;
    static int bookingCount = 0, bayarCount;
    //==================================================================================================================   
    
    static int perMalam = 0, inputstatusCustomer, kamar = -1, pilihKamar, menu;
    static double diskon = 0, bayar = 0, totalHarga = 0, totalPendapatan = 0;
    static String cetakNota, pesanKembali, statusCust, checkOut;
    static String username, password, namacust, ulangiPass, newUsername, newPassword,customerName, newNama, currentLoggedUser = "";

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

        tipeDetailKamar[0][0] = "Standard";
        tipeDetailKamar[0][1] = "Double";
        tipeDetailKamar[0][2] = "Suite";

        tipeDetailKamar[1][0] = "-Ranjang \t-kamar mandi \n-TV \t\t-AC \n-telepon";
        tipeDetailKamar[1][1] = "(+ Fasilitas Standar)\n-Ruang duduk \n-peralatan elektronik tambahan \n-perlengkapan mandi lengkap";
        tipeDetailKamar[1][2] = "(+ Fasilitas Standar & Deluxe)\n-Ruang tamu \t-dapur kecil \n-layanan kamar 24 jam ";

        hargaKamarTersedia[0][0] = 50000;
        hargaKamarTersedia[0][1] = 80000;
        hargaKamarTersedia[0][2] = 100000;

        hargaKamarTersedia[1][0] = 10;
        hargaKamarTersedia[1][1] = 10;
        hargaKamarTersedia[1][2] = 5;

        

        while (true) {
            System.out.println("\n=================================================");
            System.out.println("|\t   Selamat Datang Di Hotel 1C   \t|");
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
                    currentLoggedUser = username;
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
                        System.out.print("Silahkan pilih menu (1-10)     : ");
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
                                inputKamar();
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
                    currentLoggedUser = username;
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
            System.out.println("Apakah anda ingin melanjutkan registrasi? (ya/tidak)");
            String pilihan = sclogin.nextLine();
            if (pilihan.equals("ya")) {
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
            } else if (pilihan.equals("tidak")) {
                return;
            } else {
                System.out.println("Input tidak sesuai");
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
        for (int k = 0; k < tipeDetailKamar[0].length; k++) {
            if (tipeDetailKamar[0][k] != null) {
                System.out.println("[" + (k + 1) + "] " + tipeDetailKamar[0][k] + "\t: " + hargaKamarTersedia[1][k]+ " kamar tersedia");               
            }
        }
        int count = 0;
        for (int i = 0; i < tipeDetailKamar[0].length; i++) {
            if (tipeDetailKamar[0][i] != null) {
                count++;
            }
        }
        System.out.println("=================================================");
        System.out.println("Untuk Melihat Informasi Kamar... (0 untuk kembali)");
        System.out.print("Masukkan nomor kamar yang ingin dilihat : ");
        int kamar = sc.nextInt();
        for (int i = 0; i < tipeDetailKamar[0].length; i++) {
            if (kamar == 0) {
                if (tipeDetailKamar[0][kamar] != null) {
                    return;                    
                }
            }
        }
        if (kamar >= count) {
            System.out.println("Kamar tidak tersedia");
            
        }          


        for (int k = 0; k < tipeDetailKamar[0].length; k++) {
            if (tipeDetailKamar[0][k] == null) {
                continue;                             
            }
            if (tipeDetailKamar[0][k] == tipeDetailKamar[0][kamar - 1]) {
                System.out.println("=================================================");
                System.out.println("                Informasi Kamar  ");
                System.out.println("=================================================");
                System.out.println("Tipe Kamar \t: " + tipeDetailKamar[0][k]);
                System.out.println("Harga Kamar \t: Rp." + hargaKamarTersedia[0][k] + " / malam");
                System.out.println("Ketersediaan \t: " + hargaKamarTersedia[1][k]);
                System.out.println("-----------------------------------------");
                System.out.println("|\t\tFasilitas\t\t|");
                System.out.println("-----------------------------------------");
                System.out.println(tipeDetailKamar[1][k]);
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
        System.out.println("=================================================");
        System.out.println("\t\t  Input Kamar Baru \t\t");
        System.out.println("=================================================");
        System.out.println("\t     **ketik '0' untuk kembali**");

        System.out.print("Tipe Kamar Baru   : ");
        String tipeKamarBaru = sc.next();
        if (tipeKamarBaru.equalsIgnoreCase("0")) {
            return;
        }

        System.out.print("Harga per Malam   : ");
        int hargaKamarBaru = sc.nextInt();
        if (hargaKamarBaru == 0) {
            return;
        }

        System.out.print("Jumlah Kamar Baru : ");
        int kamarTersediaBaru = sc.nextInt();
        if (kamarTersediaBaru == 0) {
            return;
        }

        System.out.print("Fasilitas Kamar Baru: ");
        String fasilitasKamarBaru = sc.next();
        if (fasilitasKamarBaru.equalsIgnoreCase("0")) {
            return;
        }

        for (int i = 0; i < tipeDetailKamar[0].length; i++) {
            if (tipeDetailKamar[0][i] == null) {
                tipeDetailKamar[0][i] = tipeKamarBaru;
                hargaKamarTersedia[0][i] = hargaKamarBaru;
                hargaKamarTersedia[1][i] = kamarTersediaBaru;
                tipeDetailKamar[1][i] = fasilitasKamarBaru;
                break;
            }
        }
        System.out.println("Kamar " + tipeKamarBaru + " telah ditambahkan sebanyak " + kamarTersediaBaru + " kamar.");
        while (true) {
            System.out.print("\nApakah anda ingin menginput kamar baru lagi ? (y/t) : ");
            String kembali = sc.next();
            if (kembali.equalsIgnoreCase("y")) {
                inputKamar();
            } else if (kembali.equalsIgnoreCase("t")) {
                return;
            } else {
                System.out.println("input tidak sesuai");
            }
        }
    }

    public static void pemesananKamar() {
        System.out.println("=================================================");
        System.out.println("\t\t Pemesanan Kamar \t\t");
        System.out.println("=================================================");
        int count = 0;
        boolean ketersediaan = true;
        
        for (int index = 0; index < historyBooking.length; index++) {
            for (int i = 0; i < historyBooking[index].length; i++) {
                if (historyBooking[index][i] != null){
                    ketersediaan = false;
                } else {
                    ketersediaan = true;
                }
            }
        }

        for (int index = 0; index < hargaKamarTersedia.length; index++) {
            for (int i = 0; i < hargaKamarTersedia[1].length; i++) {
                if (hargaKamarTersedia[1][i] == 0){
                    if (tipeDetailKamar[0][i] != null){
                        tipeDetailKamar[0][i] = null;
                        hargaKamarTersedia[0][i] = 0;
                    }
                } else {
                    ketersediaan = true;
                    
                }
            }
        }

        if (ketersediaan == true) {

        for (int i = 0; i < tipeDetailKamar[0].length; i++) {
            if (tipeDetailKamar[0][i] != null) {
                count++;
            }
        }

            for (int j = 0; j < tipeDetailKamar[0].length; j++) {
                if (tipeDetailKamar[0][j] != null) {
                    System.out.println("[" + (j + 1) + "] " + tipeDetailKamar[0][j] + " \t= " + "Rp. "+ hargaKamarTersedia[0][j] + " / malam ");
                }
            }
            
            System.out.println("=================================================");

            System.out.print("Pilih tipe kamar (1-" + count + ") (0 untuk kembali):  ");
            pilihKamar = sc.nextInt();

            if (pilihKamar >= 1 && pilihKamar <= count) {
                int indexKamar = pilihKamar - 1;

                System.out.print("Masukkan nama Anda    : ");
                customerName = sc.next();

                System.out.print("Masukkan jumlah malam : ");
                perMalam = sc.nextInt();

                totalHarga = hargaKamarTersedia[0][indexKamar] * perMalam;

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
                    } else {
                        diskon = 0;
                    }

                } else if (inputstatusCustomer == 2) {
                    statusCust = "Non Member";
                    if (perMalam >= 3) {
                        diskon = 0.10 * totalHarga;
                    } else if (perMalam >= 7) {
                        diskon = 0.25 * totalHarga;
                    } else {
                        diskon = 0;
                    }
                }

                if (diskon > totalHarga) {
                    diskon = 0;
                 }

                System.out.println("(Untuk Konfirmasi..)");
                System.out.println("Silahkan masukkan username anda :");
                String usernameKonfirmasi = sclogin.nextLine();

                if (usernameKonfirmasi.equals(currentLoggedUser)) {

                    bayar = totalHarga - diskon;
                    System.out.println("Total biaya Pemesanan : " + bayar);
                    System.out.print("Tanggal Check-In (dd-MM-yyyy): ");
                    String checkInDate = sclogin.nextLine();

                    LocalDate checkIn = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    if (checkIn.isBefore(today)) {
                        System.out.println("Maaf, Check-In hanya dapat dilakukan pada hari ini atau setelahnya.");
                        return;
                    }

                    // check-out
                    LocalDate checkOutLocalDate = LocalDate.parse(checkInDate, DateTimeFormatter.ofPattern("dd-MM-yyyy")).plusDays(perMalam);
                    // Konversi ke format yang diinginkan (dd-MM-yyyy)
                    checkOut = checkOutLocalDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                    System.out.print("Apakah anda ingin mencetak nota ? (y/t) : ");
                    cetakNota = sc.nextLine();

                    if (cetakNota.equalsIgnoreCase("y")) {
                        System.out.println("\n======================= NOTA PEMESANAN =======================");
                        System.out.println("Tanggal Pemesanan               : " + date.toString());
                        System.out.println("Username                        : " + usernameKonfirmasi);
                        System.out.println("Nama Anda                       : " + customerName);
                        System.out.println("Tipe Kamar yang Anda Pilih      : " + tipeDetailKamar[0][indexKamar]);
                        System.out.println("Lama Menginap                   : " + perMalam);
                        System.out.println("Status Pelanggan                : " + statusCust);
                        System.out.println("Tanggal Check-In                : " + checkInDate);
                        System.out.println("Tanggal Check-Out               : " + checkOut);
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
                        hargaKamarTersedia[1][indexKamar]--;

                        // Simpan info pemesanan
                        historyBooking[0][bookingCount] = customerName;
                        historyBooking[1][bookingCount] = usernameKonfirmasi;
                        historyBooking[2][bookingCount] = tipeDetailKamar[0][indexKamar];
                        malamBooking[bookingCount] = perMalam;
                        historyBooking[3][bookingCount] = statusCust;
                        hargaHistoryBooking[0][bookingCount] = totalHarga;
                        hargaHistoryBooking[1][bookingCount] = diskon;
                        hargaHistoryBooking[2][bookingCount] = bayar;
                        historyBooking[4][bookingCount] = checkInDate;
                        historyBooking[5][bookingCount] = checkOut;

                        statusBayarBooked[bookingCount] = statusBayar;
                        bookingCount++;

                        System.out.println("Apakah anda ingin memesan kembali ? (y/t) : ");
                        String kembali = sc.nextLine();
                        if (kembali.equalsIgnoreCase("y")) {
                            pemesananKamar();
                        } else if (kembali.equalsIgnoreCase("t")) {
                            return;
                        } else {
                            System.out.println("input tidak sesuai");
                        }
                    } else if (pilKonfirmasi.equalsIgnoreCase("tidak")) {
                        System.out.println("Reservasi tidak dikonfirmasi.");
                    } else {
                        System.out.println("Pilihan tidak valid.");

                    }

                } else if (pilihKamar == 0) {
                    return;
                } else {
                    System.out.println("Username tidak sesuai.");
                    pemesananKamar();
                }

            }
        } else if (ketersediaan == false) {
            System.out.println("Mohon Maaf, Pesanan Sudah Penuh!");
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
            if (historyBooking[1][j].equals(currentLoggedUser)) {
                System.out.println("No.                 : " + (j + 1));
                System.out.println("Username            : " + historyBooking[1][j]);
                System.out.println("Nama                : " + historyBooking[0][j]);
                System.out.println("Tipe Kamar          : " + historyBooking[2][j]);
                System.out.println("Malam menginap      : " + malamBooking[j]);
                System.out.println("waktu pemesanan     : " + waktu + " pada tgl " + tanggal);
                System.out.println("Status pelanggan    : " + historyBooking[3][j]);
                System.out.println("Tanggal Check-In    : " + historyBooking[4][j]);
                System.out.println("Tanggal Check-Out   : " + historyBooking[5][j]);
                System.out.println("Total Harga         : " + hargaHistoryBooking[0][j]);
                System.out.println("Diskon              : " + hargaHistoryBooking[1][j]);
                System.out.println("Bayar               : " + (hargaHistoryBooking[0][j] - hargaHistoryBooking[1][j]));
                System.out.println("Status pembayaran   : " + statusBayarBooked[j]);
                System.out.println("=================================================");              
            }

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
            if (historyBooking[1][j].equals(currentLoggedUser)) {

                if (hargaHistoryBooking[2][j] == 0) {
                    System.out.println("Belum ada pemesanan..");
                    break;
                }
                System.out.println("Untuk Pesanan Atas nama : " + historyBooking[0][j]);
                System.out.println("Anda harus membayar : " + hargaHistoryBooking[2][j]);
    
                while (true) {
                    System.out.println("Masukkan Nominal yang ingin dibayarkan : ");
                    double bayarTunai = sc.nextInt();
    
                    if (bayarTunai >= hargaHistoryBooking[2][j]) {
                        double kembalian = bayarTunai - hargaHistoryBooking[2][j];
                        System.out.println("Kembalian : " + kembalian);
                        System.out.println("Terima kasih telah membayar!!");
                        statusBayarBooked[j] = true;
                        statusBayar = true;
                        hargaHistoryBooking[2][j] = 0;
                        break;
                    } else {
                        System.out.println("Uang yang anda masukkan kurang");
                        System.out.println("Apakah anda ingin membayar ulang? (y/t)");
                        String ulang = sc.next();
                        if (ulang.equalsIgnoreCase("y")) {
                            continue;
                        } else if (ulang.equalsIgnoreCase("t")) {
                            return;
                        }
                    }
                }
                bayarCount++;
            }
        }
    }

    public static void laporan() {
        System.out.println("==================================================================================================================================================");
        System.out.println("\t\t\t\t\t\t      Laporan Bulanan \t\t\t");
        System.out.println("==================================================================================================================================================");;  
        System.out.println("Bulan   : " + getBulan()); 
        System.out.println("Tahun   : " + getTahun());
        System.out.println("Tanggal pembuatan laporan : " + date.toString());
    
        if (bookingCount > 0) {
            totalPendapatan = 0;
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-15s | %-10s | %-7s | %-10s | %-12s | %-10s | %-10s | %-15s | %-15s | %-15s |\n",
            "Nama Customer", "Tipe Kamar", "Malam", "Status", "Total Harga", "Diskon", "Bayar", "Check In", "Check Out", "Status Bayar");
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
            for (int i = 0; i < bookingCount; i++) {
                hargaHistoryBooking[2][i] = hargaHistoryBooking[0][i] - hargaHistoryBooking[1][i];
                System.out.printf("| %-15s | %-10s | %-7s | %-10s | %-12s | %-10s | %-10s | %-15s | %-15s | %-15s |\n",
                        historyBooking[0][i], historyBooking[2][i],
                        malamBooking[i], historyBooking[3][i], hargaHistoryBooking[0][i], hargaHistoryBooking[1][i], hargaHistoryBooking[2][i], historyBooking[4][i], historyBooking[5][i], statusBayarBooked[i]);
                        if (statusBayarBooked[i] == true) {
                            totalPendapatan += hargaHistoryBooking[2][i];    
                        }

                    }
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
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
