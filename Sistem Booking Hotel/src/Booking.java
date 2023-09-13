import java.util.Scanner;

public class Booking {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String[] kamar = {"single", "Double", "Suite"};
        int [] harga = {50000, 80000, 150000};
        System.out.println("Silakan pilih jenis kamar yang anda inginkan:");
        System.out.println("1. " + kamar[0] + " - Rp." + harga[0] + "/malam");
        System.out.println("2. " + kamar[1] + " - Rp." + harga[1] + "/malam");
        System.out.println("3. " + kamar[2] + " - Rp." + harga[2] + "/malam");
    }
}
