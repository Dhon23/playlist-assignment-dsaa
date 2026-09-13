# Aplikasi Manajemen Playlist Lagu (Java OOP)

Aplikasi konsol sederhana berbasis Java yang menerapkan konsep **Object-Oriented Programming (OOP)** seperti *Inheritance*, *Polymorphism*, *Encapsulation*, dan *Abstraction* untuk mengelola playlist lagu dengan hak akses pengguna (**Admin** dan **Member**).

---

## 📌 Fitur Utama

- **Sistem Pengguna (User Management)**:
  - **Admin**: Memiliki hak akses untuk melihat daftar lagu, mencari lagu, serta menambahkan lagu baru ke dalam playlist.
  - **Member**: Memiliki hak akses untuk melihat daftar lagu, mencari lagu, dan menghitung rata-rata durasi lagu di playlist.
- **Manajemen Playlist**:
  - Menampilkan daftar lagu lengkap beserta informasi judul, artis, dan durasi (dalam menit).
  - Pencarian lagu berdasarkan judul (*case-insensitive*).
  - Penambahan lagu baru (khusus Admin).
  - Perhitungan rata-rata durasi seluruh lagu dalam playlist (khusus Member).
- **Multi-session / Ganti Pengguna**: Mengganti akun pengguna tanpa perlu menghentikan program.

---

## 🛠️ Konsep OOP yang Diterapkan

1. **Encapsulation (Pengkapsulan)**:
   - Penggunaan *access modifier* `private` pada atribut kelas (`User`, `Lagu`) dengan penyediaan *getter* dan *setter* yang sesuai.
2. **Inheritance (Pewarisan)**:
   - Kelas `Admin` dan `Member` merupakan *subclass* (turunan) dari *superclass* `User`.
3. **Polymorphism (Polimorfisme)**:
   - *Method Overriding* pada method `tambahLagu()` di kelas `Admin` dan `Member` untuk menyesuaikan perilaku berdasarkan peran pengguna.
4. **Type Casting & Instance Check**:
   - Penggunaan operator `instanceof` dan *downcasting* untuk menjalankan fitur spesifik seperti `hitungRataRataDurasi()` pada kelas `Member`.

---

## 🚀 Cara Menjalankan Program

### Prasyarat

* **Java Development Kit (JDK)** versi 8 atau yang lebih baru.

### Langkah-langkah Execution

1. **Clone / Download** repository ini.
2. Buka terminal atau command prompt di direktori proyek.
3. Kompilasi file Java:
```bash
javac Main.java

```


4. Jalankan program:
```bash
java Main

```



---

## 📋 Menu Aplikasi

Saat program dijalankan, Anda akan diminta memasukkan **Nama Pengguna** dan **Status Admin (ya/tidak)**, lalu menu berikut akan ditampilkan:

```text
Menu:
1. Tampilkan nama pengguna
2. Tampilkan daftar lagu
3. Cari lagu
4. Tambah lagu (hanya untuk admin)
5. Hitung rata-rata durasi lagu di playList (hanya untuk member)
6. Ganti pengguna
7. Keluar

```

---

## 🎬 Video Demonstrasi (Result)

Berikut adalah demonstrasi alur kerja dan pengujian program:

<video src="https://raw.githubusercontent.com/Dhon23/playlist-assignment-dsaa/main/result.mp4" controls width="100%" style="max-width: 700px;">
  Browser Anda tidak mendukung pemutaran video. Silakan tonton langsung melalui <a href="https://github.com/Dhon23/playlist-assignment-dsaa/blob/main/result.mp4">link GitHub ini</a>.
</video>

---

*Dibuat untuk memenuhi tugas / latihan pemrograman berorientasi objek Java.*

```

---

### Ringkasan Penjelasan
Dokumentasi di atas sudah mencakup:
1. Deskripsi umum aplikasi & fitur-fiturnya.
2. Penjelasan konsep OOP yang diimplementasikan pada kode Java Anda.
3. Cara mengompilasi dan menjalankan program.
4. Penjelasan struktur folder yang mencantumkan keberadaan file **`result.mp4`** di root folder.

```