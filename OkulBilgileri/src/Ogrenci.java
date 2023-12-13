import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

    public class Ogrenci {
        static Scanner scan = new Scanner(System.in);
        static Map<String, String> ogrencilerMap = new HashMap<>();
        public static void feykOgrenciEkle() {
            ogrencilerMap.put("10659387413", "Ahmet  ,Karacam,2001,4586,3,A");
            ogrencilerMap.put("83471951531", "Alexde ,Souza,2004,3131,5,B");
            ogrencilerMap.put("13423535234", "Raul   ,Meireles,2009,2312,1,P");
            ogrencilerMap.put("75656534353", "David  ,Villa,2005,1500,2,D");
            ogrencilerMap.put("90879667564", "Mehmet ,Topuz,1999,6055,6,E");
            ogrencilerMap.put("25463242243", "Dırk   ,Kuyt,1986,1907,8,F");

        }

        public static void ogrenciMenu() throws InterruptedException {
            String tercih;

            do {
                System.out.println("   Sakarya Üniversitesi\n" +
                        "Ogretmen Menu\n" +
                        "\n" +
                        "\t   1- Ogrenciler Listesi Yazdiir \t\n" +
                        "\t   2- Soyisimden ogrenci Bulma \n" +
                        "\t   3- Sınıf ve sube ile Ogrenci Bulma \n" +
                        "\t   4- Bilgilerini girerek Ogrenci Ekleme \n" +
                        "\t   5- Kimşik No ile kayıt silme \t\n" +
                        "\t   A- Anamenu \n" +
                        "\t   Q- Çıkış \n");
                tercih = scan.nextLine();
                switch (tercih) {
                    case "1":
                        ogrenciListesiYazdir();
                        break;
                    case "2":
                        soyisimdenOgrenciBulma();
                        break;
                    case "3":
                        sinifSubeIleOgrenciBulma();
                        break;
                    case "4":
                        ogrenciEkleme();
                        break;
                    case "5":
                        kimlikNoKayıtSilme();
                        break;
                    case "A":
                    case "a":
                        Depo.anaMenu();
                        break;
                    case "q":
                    case "Q":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("lütfen geçerli bir tercih seçiniz ");
                }
            }while (!tercih.equalsIgnoreCase("q"));
            Depo.projeDurdur();
        }

        private static void soyisimdenOgrenciBulma() throws InterruptedException {
             {
                System.out.println("öğrenci soyismi gir");
                String istenen1Soyisim = scan.nextLine();

                Set<Map.Entry<String, String>> ogretmenEntrySet = ogrencilerMap.entrySet();
                System.out.println("   Sakarya Üniversitesi\n       " +
                        "          Ögretmen Soyismi ile Bulma \n         " +
                        "TcNo      Isim   Soyisim    D.yılı     Okul N.  Şube  Sınıf");
                for (Map.Entry<String, String> each : ogretmenEntrySet
                ) {
                    String eachKey = each.getKey();
                    String eachValue = each.getValue();

                    String eachValuarr[] = eachValue.split(",");
                    if (istenen1Soyisim.equalsIgnoreCase(eachValuarr[1])) {
                        System.out.printf(" %11s %-6s %-8s %4s %s \n", eachKey, eachValuarr[0], eachValuarr[1],
                                eachValuarr[2], eachValuarr[3], eachValuarr[4], eachValuarr[5]);
                    }

                }
                Thread.sleep(5000);
            }
        }

        public static void kimlikNoKayıtSilme() {
            System.out.println("Silinecek öğretmenin Tc giriniz");
            String silinecekOgrenci=scan.nextLine();

            String silinecekValue=ogrencilerMap.get(silinecekOgrenci);

            String sonucValue=ogrencilerMap.remove(silinecekOgrenci);

            try {
                boolean sonuc =sonucValue.equals(silinecekValue);
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Öğremten numarası ile Bulma");
            }

        }

        private static void ogrenciEkleme() {
            System.out.println("Tc No Giriniz");
            String tcNo=scan.nextLine();
            System.out.println("İsim Giriniz");
            String isim=scan.nextLine();
            System.out.println("Soyisim Giriniz");
            String soyisim=scan.nextLine();
            System.out.println("Doğum Yılı Giriniz");
            String dogumYılı=scan.nextLine();
            System.out.println("Okul Numarası Giriniz");
            String okulNumarası=scan.nextLine();
            System.out.println("Şubenizi Giriniz");
            String sube=scan.nextLine();
            System.out.println("Kaçıncı sınıf olduğunuzu girin");
            String sinif=scan.nextLine();
            String eklenecekValue=isim+","+soyisim+","+dogumYılı+","+okulNumarası+","+
                    sube+","+sinif;
            ogrencilerMap.put(tcNo,eklenecekValue);

        }

        public static void sinifSubeIleOgrenciBulma() throws InterruptedException {
            System.out.println("Sınıf Şube ile öğrencii bulma");
            String istenenSinifSube = scan.nextLine();

            Set<Map.Entry<String, String>> ogretmenEntrySet = ogrencilerMap.entrySet();
            System.out.println("Sakarya Üniversitesi\n       " +
                    "  Ögretmen Brans ile Bulma \n         " +
                    "TcNo    Isim  Soyisim  D.yılı   okulNo   Sube   Sınıf");
            for (Map.Entry<String, String> each : ogretmenEntrySet) {
                String eachKey = each.getKey();
                String eachValue = each.getValue();

                String eachValuaar[] = eachValue.split(",");
                if (istenenSinifSube.equalsIgnoreCase(eachValuaar[3]) || istenenSinifSube.equalsIgnoreCase(eachValuaar[5])) {
                    System.out.printf(" %11s %-6s %-9s %4s %-4s %-2s %-2s \n", eachKey, eachValuaar[0],
                            eachValuaar[1], eachValuaar[2], eachValuaar[3],
                            eachValuaar[4], eachValuaar[5]);
                }

            }

        }

        private static void ogrenciListesiYazdir() throws InterruptedException {
            Set<Map.Entry<String,String>> ogrenciEntrySet = ogrencilerMap.entrySet();
            System.out.println
                    ("   Sakarya Üniversitesi\n       " +
                    "    Ögretmen Soyismi ile Bulma \n         "+
        "TcNo Isim Soyisim  D.yılı Okul N. Şube  Sınıf");
            for (Map.Entry<String,String> each: ogrenciEntrySet
            ) {
                String eachKey = each.getKey();
                String eachValue = each.getValue();

                String eachValuarr[] = eachValue.split(",");
                System.out.printf(" %11s %-6s %-9s %4s %-4s %s %s  \n", eachKey,
                        eachValuarr[0], eachValuarr[1], eachValuarr[2],
                        eachValuarr[3],eachValuarr[4],eachValuarr[5]);

            }
            Thread.sleep(5000);
        }
    }


