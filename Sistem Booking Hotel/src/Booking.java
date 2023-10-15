import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String username, password;
        boolean login = false;
        while (login == false) {
        System.out.println("=========== LOGIN ==========");
        System.out.print("Username  : ");
        username =sc.nextLine();
        System.out.print("Password  : ");
        password = sc.nextLine();
        if (username.equals("admin")) {
            if (password.equals("admin")){
            System.out.println("------- Selamat Datang, " + username + "! -------");
            System.out.println("\n=================================================");
            System.out.println("\t\t    ADMIN MENU \t\t");
            System.out.println("=================================================");
            System.out.print(" 1. Informasi Login");
            System.out.println("\t\t5. Histori Pemesanan");
            System.out.print(" 2. Cek Ketersediaan Kamar");  
            System.out.println("\t6. Daftar Nama Pengguna");
            System.out.print(" 3. Input Kamar Baru");
            System.out.println("\t\t7. Logout");
            System.out.print(" 4. Input Pengguna Baru");
            System.out.println("\t\t8. Tutup Program");
            System.out.println("=================================================");
            System.out.print("Silahkan pilih menu (1-8)     : ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("=================================================");
                    System.out.println("\t\t  Informasi Login \t\t");
                    System.out.println("=================================================");
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
                    System.out.println("\t\t  Input Pengguna Baru \t\t");
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
                    System.out.println("=================================================");
                    System.out.println("\t\t  Logout \t\t");
                    System.out.println("=================================================");
                    break;
                case 8:
                    System.out.println("=================================================");
                    System.out.println("   Terima Kasih Telah Menggunakan Layanan Kami   ");
                    System.out.println("=================================================");

                default:
                    break;
            }
            }else{
                System.out.println("=== Password Admin Salah ===");
            }
        }else if ((username.equals("customer"))) {
            if (password.equals("customer1")) {
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
                     System.out.println("\t\t  Informasi Login \t\t");
                     System.out.println("=================================================");
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
                   
        String kmr1 = "Single", kmr2 = "Double", kmr3 = "Suite", nama;
        int hargaKmr1 = 50000, hargaKmr2 = 80000, hargaKmr3 = 100000, perMalam, pilihanKamar;
        System.out.println("\n====== KATEGORI KAMAR ======");
        System.out.println("|1. "+ kmr1 + " - Rp." + hargaKmr1 + "/malam  |");
        System.out.println("|2. "+ kmr2 + " - Rp." + hargaKmr2 + "/malam  |");
        System.out.println("|3. "+ kmr3 + " - Rp." + hargaKmr3 + "/malam  |");
        System.out.println("============================");


        System.out.println("\nKamar yang anda plih yaitu: ");
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
        nama = sc.next();
        System.out.print("Halo " + nama +", Berapa malam Anda ingin menginap: ");
        perMalam = sc.nextInt();
        if (pilihanKamar <= 3) {
            if (pilihanKamar == 1)
            System.out.println("Total harga untuk " + kmr1 + " selama " + perMalam + " malam adalah Rp." + hargaKmr1 * perMalam);
            else if (pilihanKamar == 2)
            System.out.println("Total harga untuk " + kmr2 + " selama " + perMalam + " malam adalah Rp." + hargaKmr2 * perMalam);
            else 
            System.out.println("Total harga untuk " + kmr3 + " selama " + perMalam + " malam adalah Rp." + hargaKmr3 * perMalam);
        } else
        System.out.println(" ");
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
                     System.out.println("=================================================");
                     System.out.println("\t\t  Logout \t\t");
                     System.out.println("=================================================");
                     break;
                 case 7:
                     System.out.println("=================================================");
                     System.out.println("   Terima Kasih Telah Menggunakan Layanan Kami   ");
                     System.out.println("=================================================");
 
                 default:
                     break;
             }
             
            }else{
                System.out.println("== Password Customer Salah");
            }
            
        }else {
            System.out.println("Username dan Password Anda Salah");
            System.out.println("Silahkan Coba Lagi!");

        }
        }
       
        
       sc.close();
    }
}
