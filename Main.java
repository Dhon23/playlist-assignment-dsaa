import java.util.ArrayList;
import java.util.Scanner;

class User {
    private String nama;
    private ArrayList<Lagu> daftarLagu;

    public User(String nama, ArrayList<Lagu> daftarLagu) {
        this.nama = nama;
        this.daftarLagu = daftarLagu;
    }

    public void tampilkanNama() {
        System.out.println("Nama: " + nama);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void tampilkanDaftarLagu(ArrayList<Lagu> daftarLagu) {
        System.out.println("Daftar Lagu:");
        System.out.println("--------------------");
        for (Lagu lagu : daftarLagu) {
            lagu.tampilkanInfo();
            System.out.println("--------------------");
        }
    }

    public void cariLagu(ArrayList<Lagu> daftarLagu, String judul) {
        boolean ditemukan = false;
        for (Lagu lagu : daftarLagu) {
            if (lagu.getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Lagu ditemukan:");
                lagu.tampilkanInfo();
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Lagu dengan judul '" + judul + "' tidak ditemukan.");
        }
    }

    public void tambahLagu(Lagu lagu) {
        daftarLagu.add(lagu);
        System.out.println("Lagu " + lagu.getJudul() + " berhasil ditambahkan.");
    }
}

class Admin extends User {
    public Admin(String nama, ArrayList<Lagu> daftarLagu) {
        super(nama, daftarLagu);
    }

    public void tambahLagu(Lagu lagu) {
        super.tambahLagu(lagu);
        System.out.println("Admin " + getNama() + " berhasil menambahkan lagu.");
    }
}

class Member extends User {
    public Member(String nama, ArrayList<Lagu> daftarLagu) {
        super(nama, daftarLagu);
    }

    public void tambahLagu(Lagu lagu) {
        System.out.println("Member " + getNama() + " tidak memiliki hak untuk menambahkan lagu.");
    }

    public void hitungRataRataDurasi(ArrayList<Lagu> daftarLagu) {
        double totalDurasi = 0;
        for (Lagu lagu : daftarLagu) {
            totalDurasi += lagu.getDurasi();
        }
        double rataDurasi = totalDurasi / daftarLagu.size();
        System.out.println("Rata-rata durasi lagu: " + rataDurasi + " detik");
    }
}

class Lagu {
    private String judul;
    private String artis;
    private double durasi;

    public Lagu(String judul, String artis, double durasi) {
        this.judul = judul;
        this.artis = artis;
        this.durasi = durasi; // durasi dalam detik
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public double getDurasi() {
        return durasi;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    public void tampilkanInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Artis: " + artis);
        double durasiMenit = Math.floor(durasi / 60 * 100) / 100;
        System.out.println("Durasi: " + durasiMenit + " menit");
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Lagu> playList = new ArrayList<Lagu>();

        playList.add(new Lagu("Lagu 1", "Artis 1", 180));
        playList.add(new Lagu("Lagu 2", "Artis 2", 240));
        playList.add(new Lagu("Lagu 3", "Artis 3", 210));

        // dummy login

        Scanner scanner = new Scanner(System.in);
        User user = null;
        while (true) {
            if (user == null) {
                System.out.print("Masukkan nama pengguna: ");
                String namaPengguna = scanner.nextLine();

                System.out.print("Apakah Anda admin? (ya/tidak): ");
                String isAdmin = scanner.nextLine();

                if (isAdmin.equalsIgnoreCase("ya")) {
                    user = new Admin(namaPengguna, playList);
                } else {
                    user = new Member(namaPengguna, playList);
                }
            }

            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan nama pengguna");
            System.out.println("2. Tampilkan daftar lagu");
            System.out.println("3. Cari lagu");
            System.out.println("4. Tambah lagu (hanya untuk admin)");
            System.out.println("5. Hitung rata-rata durasi lagu di playList (hanya untuk member)");
            System.out.println("6. Ganti pengguna");
            System.out.println("7. Keluar");
            int userInput = 0;
            try {
                System.out.print("Pilih menu (1-6): ");
                userInput = Integer.parseInt(scanner.nextLine());
                System.out.println();
                System.out.println("================================");
                System.out.println();
            } catch (Exception e) {
                System.out.println("Input tidak valid. Silakan masukkan angka antara 1 hingga 6.");
                continue;
            }
            switch (userInput) {
                case 1:
                    user.tampilkanNama();
                    break;

                case 2:
                    user.tampilkanDaftarLagu(playList);
                    break;

                case 3:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    String judulLagu = scanner.nextLine();
                    user.cariLagu(playList, judulLagu);
                    break;

                case 4:
                    if (user instanceof Admin) {
                        System.out.print("Masukkan judul lagu: ");
                        String judulBaru = scanner.nextLine();
                        System.out.print("Masukkan artis lagu: ");
                        String artisBaru = scanner.nextLine();
                        System.out.print("Masukkan durasi lagu (dalam detik): ");
                        double durasiBaru = Double.parseDouble(scanner.nextLine());
                        Lagu laguBaru = new Lagu(judulBaru, artisBaru, durasiBaru);
                        user.tambahLagu(laguBaru);
                    } else {
                        System.out.println("Anda tidak memiliki hak untuk menambahkan lagu.");
                    }
                    break;

                case 5:
                    if (user instanceof Member) {
                        ((Member) user).hitungRataRataDurasi(playList);
                    } else {
                        System.out.println("Hanya member yang dapat menghitung rata-rata durasi lagu.");
                    }
                    break;

                case 6:
                    user = null;
                    break;

                case 7:
                    System.out.println("Terima kasih telah menggunakan aplikasi ini.");
                    scanner.close();
                    System.exit(0);
                    break;
            }

            System.out.println();
            System.out.println("================================");
            System.out.println();

            if (userInput < 1 || userInput > 7) {
                System.out.println("Pilihan menu tidak valid. Silakan pilih menu antara 1 hingga 7.");
            }
        }
    }
}