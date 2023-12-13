
import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;

public class Depo {



    public static void anaMenu() throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        String tercih = "";
        do {
            System.out.println(
                    "   Sakarya Üniversitesi\n" +
                            "       Ana Menu        \n" +
                            "\n" +
                            "\t     1- Okul Bilgileri\n" +
                            "\t     2- Öğretmen Bilgileri\n" +
                            "\t     3- Öğrenci Bilgileri\t\t\n" +
                            "\t     q- Çıkış\n");

            tercih = scan.nextLine();


            switch (tercih) {
                case "1":
                    Depo.okulBilgileriniYazdır();
                    break;
                case "2":
                    Ogretmen.ogretmenMenu();
                    break;
                case "3":
                    Ogrenci.ogrenciMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("lütfen geçerli tercih yapınız");
            }

        } while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();

    }

    public static void okulBilgileriniYazdır() throws InterruptedException {
        System.out.println("   Sakarya Üniversitesi\n" +
                "\t\t Adres:"+ Okul.adres+
                "\n\t\t Telefon :"+ Okul.tel);
        Thread.sleep(5000);
    }

    public static void projeDurdur() {
        System.out.println("okul projesinden çıkınız");
        System.exit(0);

    }
}