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