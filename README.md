# Sistem Manajemen Komisi Gambar (Art Commission Management System)

*Tugas Ujian Tengah Semester - Pemrograman Berbasis Objek (PBO)*

## 1. Deskripsi Proyek

  **Sistem Manajemen Komisi Gambar** adalah aplikasi berbasis Pemrograman Berbasis Objek (PBO) yang dirancang untuk mempermudah seniman (*artist*) dan klien dalam mengelola alur kerja komisi seni digital secara terstruktur.

## 2. Penerapan 4 Elemen Wajib Pemrograman

Program ini mengimplementasikan 4 pilar utama pemrograman sebagai berikut:

### A. Inheritance (Pewarisan)
Penerapan minimal 2 tipe pewarisan kelas pada program:
* **Hierarki Artwork:** Class `PersonalUse` dan `CommersialUse` mewarisi properti serta method dari *class* `Artwork`.

  **> Superclass Artwork**
  
  <img width="690" height="126" alt="image" src="https://github.com/user-attachments/assets/682a9600-36c5-45d8-a39b-b7b675265a1b" />

  **> Subclass PersonalUse**
  
  <img width="688" height="89" alt="image" src="https://github.com/user-attachments/assets/41ac9a17-ea0b-4101-ad73-b17ad2e8eda0" />

  **> Subclass CommersialUse**
  
  <img width="687" height="88" alt="image" src="https://github.com/user-attachments/assets/7e0519fa-0acd-493c-85a2-070d5883f47c" />


* **Hierarki Pembayaran:** Class `PembayaranDP` dan `PembayaranLunas` mewarisi atribut dan struktur dari *abstract class* `Pembayaran`.

  **> Superclass Pembayaran**
  
  <img width="688" height="90" alt="image" src="https://github.com/user-attachments/assets/366f8680-4ab6-482b-bba4-b6e6ab39ca18" />

  **> Subclass PembayaranDP**
  
  <img width="687" height="71" alt="image" src="https://github.com/user-attachments/assets/e4a7fb73-cdb2-4687-ac4f-ca09ad675d32" />

  **> Subclass PembayaranLunas**
  
  <img width="689" height="71" alt="image" src="https://github.com/user-attachments/assets/94a6a88a-6820-4104-a2ac-778b04630ff1" />


### B. Polymorphism
Penerapan *Method Overriding* untuk mendefinisikan ulang perilaku method pada subclass:
* **Method `hitungTotalHarga()`:** Didefinisikan ulang di `PersonalUse` dan `CommersialUse` untuk menghitung total biaya spesifik sesuai jenis lisensi.
* **Method `hitungNominalBayar()` & `getStatusPembayaran()`:** Didefinisikan ulang di `PembayaranDP` (menghitung 50%) dan `PembayaranLunas` (menghitung 100%).

  <img width="689" height="196" alt="image" src="https://github.com/user-attachments/assets/bef6afa8-eb0c-40ea-8e25-7076513648da" />


### C. Condition (Percabangan)
Penggunaan logika percabangan untuk mengontrol alur eksekusi:
* **`if-else` (Penentuan Jenis Lisensi Karya):** Digunakan untuk mengecek nilai variabel `jenis`. Jika pengguna memilih `1` (Personal Use), sistem meminta catatan keperluan pribadi dan instansiasi objek `PersonalUse`. Jika `else` (Commercial Use), sistem meminta input biaya lisensi komersial dan instansiasi objek `CommersialUse`.

  <img width="902" height="177" alt="image" src="https://github.com/user-attachments/assets/4d9170ea-9db4-4d36-8b45-a0e2c3e35040" />

* **`switch-case` / `switch expression`:** Digunakan saat menentukan nama paket gaya gambar berdasarkan pilihan angka pengguna (`case 1 -> "Lineart"`, `case 2 -> "Chibi"`, dst).

  <img width="846" height="144" alt="image" src="https://github.com/user-attachments/assets/3227f3ac-1981-4f2a-acef-ccac0ce84b18" />

### D. Looping (Perulangan)
Penggunaan struktur iterasi dalam mengolah data koleksi dan mengontrol validasi input:
* **Perulangan `for` / `for-each`:**
  * **Navigasi Data Koleksi (`daftarPesanan`):** Digunakan pada method `isIdExist()` dan method `tambahPesanan()` untuk mengecek ketersediaan ID pesanan agar tidak terjadi duplikasi.
    
    <img width="696" height="145" alt="image" src="https://github.com/user-attachments/assets/5dd94910-ff98-429e-8fa1-e19fea185b2b" />  
  
  * **`while`:** Digunakan pada proses validasi input angka pilihan paket agar pengguna terus diinstruksikan menginputkan pilihan jika input belum valid.

    <img width="688" height="95" alt="image" src="https://github.com/user-attachments/assets/9f65972e-573c-4fdf-af22-25c7f6499ab8" />


---

### 3. Fitur Utama

* **Manajemen Pesanan:** Memproses pendaftaran komisi baru dari klien.
* **Perhitungan Komisi & Biaya:** Menghitung total harga secara otomatis berdasarkan kompleksitas, jenis lisensi (komersial/personal), dan tingkat kerumitan gambar.
* **Rekapitulasi Pendapatan:** Menghitung total pendapatan selama 1 batch, meliputi pembayran secara DP maupun lunas. Serta memberikan estimasi pendapatan (jika semua sudah lunas)

---

## 4. Alur Sistem Program

Alur sistem ini dirancang untuk mensimulasikan proses bisnis manajemen komisi gambar secara menyeluruh, mulai dari penerimaan pesanan hingga tahap penyelesaian.

```
+---------------------------+
|  1. Penerimaan Pesanan    |
|     (Input Data Klien)    |
+-------------+-------------+
              |
              v
+---------------------------+
|  2. Kalkulasi Biaya       |
|     (Lisensi & Detail)    |
+-------------+-------------+
              |
              v
+---------------------------+
|  3. Registrasi & Status   |
|     (Inisialisasi Antrean)|
+-------------+-------------+
              |
              v
+---------------------------+
|  5. Rekap                 |
|     (Laporan & Selesai)   |
+---------------------------+
```

#### 1. Tahap Penerimaan & Pendataan Pesanan (*Order Entry*)
* **Input Data Klien:** Sistem meminta informasi identitas dasar seperti nama klien dan rincian kontak.
* **Spesifikasi Karya:** Klien/seniman memasukkan spesifikasi gambar yang dipesan, meliputi:
  * Jenis karya (misal: *Headshot*, *Half Body*, *Full Body*, atau *Illustration Background*).
  * Tingkat kerumitan (*Level of Detail*).
  * Hak Penggunaan / Lisensi (*Personal Use* atau *Commercial Use*).

#### 2. Tahap Logika Kalkulasi & Penentuan Harga (*Pricing Calculation*)
* **Penetapan Tarif Dasar:** Sistem mengambil nilai *base price* berdasarkan jenis karya yang dipilih.
* **Lisensi:** Jika lisensi bernilai *Commercial Use*, sistem secara otomatis menerapkan tambahan harga.
* **Output Harga:** Sistem menghasilkan rincian (*breakdown*) total biaya transparan yang harus dibayar oleh klien.

#### 3. Tahap Pencatatan & Inisialisasi Antrean (*Queue & Initialization*)
* Pesanan yang telah dikonfirmasi akan dicatat oleh sistem dengan nomor identitas unik (*Order ID*).
* Sistem menginisialisasi slot yang tersedia, jika slot sudah habis maka pesanan akan ditolak.

#### 5. Tahap Finalisasi & Pelaporan (*Completion & Summary*)
* **Rekapitulasi Sistem:** Sistem menyajikan laporan komprehensif berisi daftar seluruh transaksi, rincian pesanan, total biaya yang diperoleh untuk keperluan pencatatan keuangan dan manajemen seniman.

---

## 5. Penjelasan Diagram & Dokumentasi

Section ini berisi diagram arsitektur kelas (*Class Diagram*) serta tangkapan layar (*screenshot*) hasil uji coba sistem.

### 1. Class Diagram (Diagram Kelas)

Diagram ini menggambarkan struktur Pemrograman Berbasis Objek (PBO) yang diterapkan dalam aplikasi.

```
          +-------------------+                             +-------------------+
          |      Artwork      | (Superclass)                |    Pembayaran     | (Superclass)
          +-------------------+                             +-------------------+
                    |                                                |
    +---------------+---------------+                     +----------+------------+
    |                               |                     |                       |
+---------------+           +-----------------+    +---------------+       +------------------+
|  PersonalUse  |           |  CommersialUse  |    |  PembayaranDP |       |  PembayaranLunas |
+---------------+           +-----------------+    +---------------+       +------------------+
   (Subclass)                   (Subclass)              (Subclass)               (Subclass)

models
├── Customer.java       (Model data pelanggan: nama & no hp)
├── Artwork.java        (Superclass/Abstract: judul, gaya gambar, & harga dasar)
├── PersonalUse.java    (Subclass dari Artwork: spesifik penggunaan pribadi)
├── CommersialUse.java  (Subclass dari Artwork: spesifik lisensi komersial)
├── Pembayaran.java     (Superclass/Abstract: kalkulasi pembayaran)
├── PembayaranDP.java   (Subclass dari Pembayaran: skema DP 50%)
├── PembayaranLunas.java(Subclass dari Pembayaran: skema pelunasan 100%)
└── CommisionOrder.java (Menggabungkan Customer, Artwork, & Pembayaran)

controller
├── CommisionService.java (Manajemen penyimpanan list order, slot batch, & rekap)
└── ValidasiInput.java   (Handling dan validasi input data)

main
└── Main.java           (Menu utama & kontrol alur program/entry point)
```

* **Penjelasan Class Diagram:**
  * `Artwork` (Superclass): Menyimpan atribut dasar karya seperti judul, gaya gambar, dan harga dasar, serta mendefinisikan metode abstrak untuk kalkulasi harga.
  * `PersonalUse` / `CommersialUse` (Subclass): Turunan dari kelas Artwork yang memiliki perhitungan tarif spesifik berdasarkan jenis lisensi (penggunaan pribadi atau hak komersial).
  * `Pembayaran` (Abstract Class/Superclass): Kelas abstrak pengelolaan skema pembayaran yang menghitung nominal bayar berdasarkan total tagihan.
  * `PembayaranDP` / `PembayaranLunas` (Subclass): Turunan dari kelas Pembayaran untuk memproses pembayaran awal (DP 50%) maupun pelunasan penuh (100%).
  * `Customer`: Mengelola data identitas pemesan seperti nama dan nomor telepon.
  * `CommisionOrder`: Kelas entitas utama yang menghubungkan (aggregation/composition) data pelanggan, karya gambar, dan status pembayaran ke dalam satu objek pesanan.
  * `CommisionService`: Kelas controller untuk menangani logika bisnis, seperti validasi kuota batch (maksimal 3 slot), pembuatan ID unik, penambahan pesanan, serta rekapitulasi pendapatan.

---

### 2. Tangkapan Layar Output Program (Screenshots)

- Menu Utama & Input Data Pesanan

  <img width="600" alt="image" src="https://github.com/user-attachments/assets/50d47227-7f9c-482e-b455-51075791066c" />

  *Deskripsi Gambar:* Menampilkan antarmuka yang terdapat 4 menu, yaitu Tambah Pesanan Baru, Lihat Daftar Pesanan, Lihat Rekap Pendapatan, dan Keluar.

- Menu 1: Tambah Pesanan  

  <img width="600" alt="image" src="https://github.com/user-attachments/assets/9b07cbf5-44e9-4d95-b496-2e3be67448ec" />

  *Deskripsi Gambar:* Menampilkan proses penginputan data pesanan baru.

  <img width="600" alt="image" src="https://github.com/user-attachments/assets/4e101aaf-d8c0-4507-acd7-421a88e4eecb" />

  *Deskripsi Gambar:* Setelah pesanan baru berhasil di-inputkan, sistem akan mencetak output berupa invoice yang berisi data pesanan serta total tagihan pembayaran.

- Menu 2: Tambah Pesanan  

  <img width="600" alt="image" src="https://github.com/user-attachments/assets/64cfcffa-980d-42d1-a445-3b7930ae2772" />

  *Deskripsi Gambar:* Menampilkan seluruh data pesanan, termasuk status bayar dan total nominal yang harus dibayar.

- Menu 3: Rekap Pendapatan 

  <img width="600" alt="image" src="https://github.com/user-attachments/assets/fb6a5262-d50e-41d2-b44c-a340e3219798" />

  *Deskripsi Gambar:* Menampilkan total pendapatan selama 1 batch, meliputi pembayran secara DP maupun lunas. Serta memberikan estimasi pendapatan (jika semua sudah lunas).

- Menu 4: Keluar 

  <img width="600" alt="image" src="https://github.com/user-attachments/assets/16a5f2a4-7858-4288-88b5-3d2fa53d2a1c" />

  *Deskripsi Gambar:* Menampilkan proses keluar dari sistem untuk mengakhiri proses output.

---

## 6. Kesimpulan

  Sistem Manajemen Komisi Gambar ini berhasil mengimplementasikan seluruh pilar utama Pemrograman Berbasis Objek (PBO) dalam memodelkan proses bisnis komisi karya digital. Penggunaan konsep *Inheritance* dan *Polymorphism* mempermudah fleksibilitas perhitungan harga berbasis jenis lisensi (*Personal*/*Commercial*) dan skema pembayaran (*DP*/*Lunas*). Didukung oleh logika *Condition* dan *Looping* yang presisi, sistem mampu melakukan validasi data secara otomatis, mengelola kuota *batch*, serta menyajikan rekapitulasi finansial secara efisien, terstruktur, dan akurat.
