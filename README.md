# MINI PROJECT 2 PBO
## SISTEM MANAJEMEN TEMPAT BILLIARD

**Nama:** Riko Azkarazendra Russianto  
**NIM:** 2509116104  
**Kelas:** C-2025  
**Mata Kuliah:** Pemrograman Berorientasi Objek (PBO)

---

## 1. Deskripsi Program

Sistem Manajemen Tempat Billiard merupakan program berbasis Java
Console yang digunakan untuk mengelola data meja billiard dan
transaksi pelanggan.

Program ini merupakan pengembangan dari Mini Project 1 dengan
menerapkan konsep Pemrograman Berorientasi Objek (PBO), seperti
encapsulation, inheritance, polymorphism, ArrayList, input validation,
dan struktur MVC.

Fitur yang tersedia:

- Menambah data meja.
- Menampilkan data meja.
- Mengubah jenis meja.
- Menghapus data meja.
- Membuka meja untuk pelanggan.
- Menambahkan waktu bermain.
- Menutup meja dan menampilkan struk pembayaran.
- Validasi input pengguna.

Jenis meja yang tersedia:

- Reguler: Rp30.000 per jam.
- VIP: Rp60.000 per jam.

---

## 2. Struktur Package Program

Program menggunakan struktur MVC untuk memisahkan bagian model,
view, dan controller.

```text
src/main/java/com/mycompany/miniproject2_pbo
├── Miniproject2_PBO.java
├── model
│   ├── MejaBilliard.java
│   ├── MejaReguler.java
│   ├── MejaVIP.java
│   └── Transaksi.java
├── controller
│   └── BilliardController.java
└── view
    └── Menu.java
```

### Penjelasan

- **Model:** Mengatur objek meja billiard dan transaksi.
- **View:** Menampilkan menu dan menerima input pengguna.
- **Controller:** Mengatur proses CRUD dan transaksi.
- **Main:** Menjalankan program.

### Screenshot Struktur Package

<img width="229" height="176" alt="image" src="https://github.com/user-attachments/assets/a3ce885a-c9ca-449d-8dcd-aadbcb1d644b" />

**Penjelasan:**

Screenshot menunjukkan pemisahan class ke dalam package model,
view, dan controller sesuai dengan konsep MVC.

---

## 3. Alur Program

Alur program:

1. Program dijalankan melalui class utama.
2. Sistem menampilkan menu utama.
3. Pengguna memilih menu.
4. Sistem memproses pilihan pengguna.
5. Sistem menampilkan hasil proses.
6. Program kembali ke menu utama.
7. Program berhenti ketika pengguna memilih menu Keluar.

---

## 4. Implementasi CRUD

### 4.1 Create - Menambah Data Meja

Fitur ini digunakan untuk menambahkan meja baru dengan nomor meja
dan jenis meja Reguler atau VIP.

<img width="143" height="165" alt="image" src="https://github.com/user-attachments/assets/894f06e0-2db9-40b4-96c8-69ef06e7a6c7" />

**Penjelasan Output:**

Screenshot menunjukkan bahwa data meja berhasil ditambahkan ke
dalam ArrayList. Sistem juga melakukan pemeriksaan agar nomor meja
tidak boleh sama.

---

### 4.2 Read - Menampilkan Data Meja

Fitur ini digunakan untuk menampilkan seluruh data meja yang
tersimpan.

<img width="120" height="164" alt="image" src="https://github.com/user-attachments/assets/0393bad3-c7da-49c2-a48f-359aa126edc2" />

**Penjelasan Output:**

Screenshot menunjukkan nomor meja, jenis meja, harga per jam,
dan status meja. Data ditampilkan menggunakan perulangan `for`.

---

### 4.3 Update - Mengubah Data Meja

Fitur ini digunakan untuk mengubah jenis meja yang masih tersedia.

<img width="122" height="152" alt="image" src="https://github.com/user-attachments/assets/163dbc81-ee2c-47af-afa6-2b98431fef1c" />

**Penjelasan Output:**

Screenshot menunjukkan bahwa jenis meja berhasil diubah yang awalnya reguler menjadi VIP dan harga
per jam menyesuaikan jenis meja yang baru.

Meja yang sedang digunakan tidak dapat diubah.

---

### 4.4 Delete - Menghapus Data Meja

Fitur ini digunakan untuk menghapus data meja yang masih tersedia.

<img width="125" height="145" alt="image" src="https://github.com/user-attachments/assets/636f7fcd-15cd-4a0e-b31c-62946a971cf3" />

**Penjelasan Output:**

Screenshot menunjukkan pesan bahwa meja berhasil dihapus.
Jika nomor meja tidak ditemukan atau sedang digunakan, sistem
akan menolak proses penghapusan.

---

## 5. Fitur Transaksi

### 5.1 Membuka Meja

Fitur ini digunakan untuk mencatat pelanggan dan durasi awal
penggunaan meja.

<img width="139" height="166" alt="image" src="https://github.com/user-attachments/assets/b727d364-6cda-416f-b7b8-019f8e994daf" />

**Penjelasan Output:**

Setelah meja dibuka, status meja berubah dari `Tersedia` menjadi
`Digunakan`. Sistem juga mencatat nama pelanggan, nomor meja,
durasi, dan total biaya.

---

### 5.2 Menambahkan Waktu

Fitur ini digunakan untuk menambahkan durasi bermain pelanggan.

<img width="118" height="151" alt="image" src="https://github.com/user-attachments/assets/c8eff509-b334-4b99-8638-350eff2bd201" />

**Penjelasan Output:**

Durasi bermain dan total pembayaran akan diperbarui sesuai dengan
tambahan waktu yang dimasukkan oleh pengguna.

---

### 5.3 Menutup Meja

Fitur ini digunakan untuk mengakhiri transaksi pelanggan.

<img width="124" height="202" alt="image" src="https://github.com/user-attachments/assets/21868c72-fdc4-4a5a-8ef2-43f040a36eb7" />

**Penjelasan Output:**

Sistem menampilkan nama pelanggan, nomor meja, durasi bermain,
dan total pembayaran. Setelah transaksi ditutup, status meja
kembali menjadi `Tersedia`.

---

## 6. Encapsulation

Encapsulation diterapkan dengan menggunakan access modifier
`private` pada atribut class.

Contohnya terdapat pada class `MejaBilliard`:

```java
private int nomorMeja;
private double hargaPerJam;
private String status;
```

Atribut tersebut diakses melalui method getter dan setter.

Contoh method:

```java
public int getNomorMeja()
public void setNomorMeja(int nomorMeja)
```

### Penjelasan

Encapsulation digunakan untuk melindungi atribut agar tidak dapat
diakses secara langsung dari luar class. Pengaksesan data dilakukan
melalui method yang telah disediakan.

### Letak Implementasi

- File: `MejaBilliard.java`
- File: `Transaksi.java`
- Access modifier: `private`
- Method: Getter dan setter

---

## 7. Inheritance

Inheritance diterapkan dengan class `MejaBilliard` sebagai
superclass dan dua subclass, yaitu `MejaReguler` dan `MejaVIP`.

Struktur inheritance:

```text
MejaBilliard
├── MejaReguler
└── MejaVIP
```

Contoh penerapan:

```java
public class MejaReguler extends MejaBilliard
```

```java
public class MejaVIP extends MejaBilliard
```

### Penjelasan

Subclass mewarisi atribut dan method dari superclass.
Setiap subclass memiliki jenis meja dan harga per jam yang berbeda.

### Letak Implementasi

- Superclass: `MejaBilliard.java`
- Subclass: `MejaReguler.java`
- Subclass: `MejaVIP.java`

---

## 8. Polymorphism

Polymorphism diterapkan melalui penggunaan reference superclass
untuk menyimpan objek dari subclass.

Contohnya:

```java
private ArrayList<MejaBilliard> daftarMeja;
```

ArrayList tersebut dapat menyimpan objek `MejaReguler` dan
`MejaVIP`.

Polymorphism juga diterapkan melalui overriding method:

```java
@Override
public String getJenisMeja()
```

```java
@Override
public double hitungBiaya(int durasiJam)
```

### Penjelasan

Method yang dijalankan menyesuaikan objek subclass yang digunakan.
Dengan demikian, satu tipe reference dapat digunakan untuk berbagai
jenis objek meja.

### Letak Implementasi

- File: `MejaReguler.java`
- File: `MejaVIP.java`
- File: `BilliardController.java`

---

## 9. Input Validation

Program menerapkan validasi input untuk mengurangi kesalahan
pengguna.

Validasi yang diterapkan:

- Nomor meja harus lebih dari 0.
- Durasi harus lebih dari 0.
- Tambahan waktu harus lebih dari 0.
- Input angka tidak boleh berupa huruf.
- Jenis meja hanya Reguler atau VIP.
- Nama pelanggan tidak boleh kosong.
- Nomor meja tidak boleh sama.
- Meja yang sedang digunakan tidak dapat diubah atau dihapus.

### Screenshot Validasi

<img width="200" height="341" alt="image" src="https://github.com/user-attachments/assets/e3a217c7-17a5-46d8-a2c9-8c065bc87392" />
<img width="125" height="151" alt="image" src="https://github.com/user-attachments/assets/8059570b-9468-4cd4-832b-28bd24e89475" />

**Penjelasan Output:**

Sistem menolak input yang tidak sesuai dan meminta pengguna
memasukkan data yang benar kembali.

### Letak Implementasi

- File: `Menu.java`
- Method: `bacaAngka()`
- Method: `bacaAngkaPositif()`
- Method: `bacaJenisMeja()`

---

## 10. Penggunaan ArrayList

Program menggunakan ArrayList untuk menyimpan data meja dan transaksi.

```java
private ArrayList<MejaBilliard> daftarMeja;
private ArrayList<Transaksi> daftarTransaksi;
```

ArrayList digunakan karena data dapat ditambah, diubah, dan
dihapus selama program berjalan.

Operasi yang digunakan:

- `add()` untuk menambahkan data.
- `remove()` untuk menghapus data.
- `set()` untuk memperbarui data.
- Perulangan `for` untuk menampilkan data.

---

## 11. Data Dummy Awal

Program memiliki data dummy awal agar menu Read langsung
menampilkan data ketika program dijalankan.

Data dummy:

- Nomor meja: 1
- Jenis meja: Reguler
- Harga per jam: Rp30.000
- Status: Tersedia

Data dummy dibuat pada constructor class `BilliardController`.

### Screenshot Data Dummy

**Tempat Screenshot:**

Tambahkan screenshot saat menu tampilkan data dijalankan pertama kali.

**Penjelasan Output:**

Screenshot menunjukkan bahwa data meja sudah tersedia sejak awal
program tanpa harus melakukan proses tambah data terlebih dahulu.

---

## 12. Pengujian Program

Pengujian dilakukan untuk memastikan setiap fitur berjalan
sesuai dengan fungsinya.

| No. | Pengujian | Hasil |
|---|---|---|
| 1 | Menambah meja baru | Berhasil |
| 2 | Menampilkan data meja | Berhasil |
| 3 | Mengubah jenis meja | Berhasil |
| 4 | Menghapus meja | Berhasil |
| 5 | Menolak nomor meja duplikat | Berhasil |
| 6 | Menolak input huruf | Berhasil |
| 7 | Menolak angka nol | Berhasil |
| 8 | Membuka meja | Berhasil |
| 9 | Menambahkan waktu | Berhasil |
| 10 | Menutup meja dan menampilkan struk | Berhasil |

---

## 13. Kesimpulan

Program Sistem Manajemen Tempat Billiard berhasil dikembangkan
menggunakan bahasa Java dan konsep Pemrograman Berorientasi Objek.

Program memiliki fitur CRUD, transaksi meja, validasi input,
encapsulation, inheritance, polymorphism, dan struktur MVC.

Penerapan konsep tersebut membantu program menjadi lebih terstruktur,
mudah dikembangkan, dan lebih mudah dipahami.

---
