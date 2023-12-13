import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);
    static Map<String , String>ogretmenlerMap=new HashMap<>();
    public  static void feykOgretmenEkle(){
        ogretmenlerMap.put("10492387432","Ali ,Can,1982,Matematik");
        ogretmenlerMap.put("96576534534","Yunus,Emre,1984,Fen");
        ogretmenlerMap.put("43242345253","Osman ,Yusa,1970,Beden");
        ogretmenlerMap.put("57465346346","Ahmet ,Karacam,1950,Isletme");
        ogretmenlerMap.put("53764534634","Üveys,Aydoğan,1977,Matematik");


    }
    public static void ogretmenMenu() throws InterruptedException {
        String tercih;

        do {
            System.out.println(
                                "   Sakarya Üniversitesi\n" +
                                        "Ogretmen Menu\n"+
                            "\n"+
                            "\t   1- Ogretmenler Listesi Yazdiir \t\n"+
                            "\t   2- Soyisim Oğretmen Bulma \n"+
                            "\t   3- Branstan Öğretmen Bulma \n"+
                            "\t   4- Bilgilerini girerek Ogretmen Ekleme \n"+
                            "\t   5- Kimşik No ile kayıt silme \t\n"+
                            "\t   A- Anamenu \n"+
                            "\t   Q- Çıkış \n");
            tercih=scan.nextLine();
            switch (tercih){
                case "1":
                    ogretmenListesiYazdır();
                    break;
                case "2":
                    soyisimOgretmenBulma();
                    break;
                case "3":
                    branstanOgretmenBulma();
                    break;
                case "4":
                    ogretmenEkleme();
                    break;
                case "5":
                    ogretmenSil();
                    break;
                case "a":
                case "A":
                    Depo.anaMenu();
                    break;
                case "q":
                    break;
                case "Q":
                    break;
                default:System.out.println("okul projesinden çıktınız");

            }

        }while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();
    }

    public static void ogretmenSil() {
        System.out.println("Silinecek öğretmen kimlik no giriniz");
        String silinecekOgretmen=scan.nextLine();
        String silinecekValue=ogretmenlerMap.get(silinecekOgretmen);
        String sonucValue= ogretmenlerMap.remove(silinecekOgretmen);
        try {
            boolean sonuc= sonucValue.equals(silinecekValue);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("İstediğini öğretmen numarsı ile bulunumadı");
        }

    }

    public static void ogretmenEkleme() {
        System.out.println("Tc No Giriniz");
        String tcNo=scan.nextLine();
        System.out.println("İsim Giriniz");
        String isim=scan.nextLine();
        System.out.println("Soyisim Giriniz");
        String soyisim=scan.nextLine();
        System.out.println("Doğum Yılı Giriniz");
        String dogumYılı=scan.nextLine();
        System.out.println("Brans Giriniz");
        String brans=scan.nextLine();

        String eklenecekValue= isim+","+ soyisim+","+ dogumYılı+","+brans;
        ogretmenlerMap.put(tcNo,eklenecekValue);
    }

    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("öğretmen brans gir");
        String istenenBrans=scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("Sakarya Üniversitesi\n       " +
                "  Ögretmen Brans ile Bulma \n         "+
                "TcNo    Isim  Soyisim  D.yılı   Brans");
        for (Map.Entry<String,String> each: ogretmenEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[] = eachValue.split(",");
            if(istenenBrans.equalsIgnoreCase(eachValuarr[3])){
                System.out.printf(" %11s %-6s %-8s %4s   %s \n", eachKey, eachValuarr[0], eachValuarr[1],
                        eachValuarr[2], eachValuarr[3]);
            }

        }
        Thread.sleep(5000);



    }

    public static void soyisimOgretmenBulma() throws InterruptedException {
        System.out.println("öğretmen soyismi gir");
        String istenenSoyisim=scan.nextLine();

        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("   Sakarya Üniversitesi\n       " +
                "          Ögretmen Soyismi ile Bulma \n         "+
                "TcNo      Isim   Soyisim    D.yılı     Brans");
        for (Map.Entry<String,String> each: ogretmenEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[] = eachValue.split(",");
            if(istenenSoyisim.equalsIgnoreCase(eachValuarr[1])){
                System.out.printf(" %11s %-6s %-8s %4s %s \n", eachKey, eachValuarr[0], eachValuarr[1],
                        eachValuarr[2], eachValuarr[3]);
            }

        }
        Thread.sleep(5000);





    }

    public static void ogretmenListesiYazdır() throws InterruptedException {
        Set<Map.Entry<String,String>> ogretmenEntrySet= ogretmenlerMap.entrySet();
        System.out.println("   Sakarya Üniversitesi\n       " +
                        "        Ogretmen Listesi \n         "+
                        "TcNo      Isim     D.yılı     Brans");
        for (Map.Entry<String,String> each: ogretmenEntrySet
             ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuarr[] = eachValue.split(",");
            System.out.printf(" %11s %-6s %-8s %4s %s \n", eachKey, eachValuarr[0], eachValuarr[1],
                    eachValuarr[2], eachValuarr[3]);
        }
            Thread.sleep(5000);

        }

    }
