# SmartLibrary – Akıllı Kütüphane Yönetim Sistemi

---

## 📌 Proje Açıklaması

SmartLibrary, Java OOP + JDBC + SQLite kullanılarak geliştirilmiş basit bir konsol tabanlı **Akıllı Kütüphane Yönetim Sistemi**dir. Proje; kitap, öğrenci ve ödünç alma işlemlerini yönetmek için temel veri modeli, repository yapısı ve SQLite veri tabanı kullanır.

Bu proje, Nesneye Dayalı Programlama prensipleri (Sınıflar, Nesne İlişkileri, Constructor, Kalıtım/Kompozisyon) ile JDBC CRUD işlemlerini uygulamalı bir şekilde göstermektedir.

---

## 🎯 Proje Gereksinimleri 

Aşağıdaki maddelerin tamamı projede uygulanmıştır:

* ✔️ Sınıflar (Book, Student, Loan, Database, Repository sınıfları)
* ✔️ Nesne İlişkileri (Loan → Book & Student ilişkisi, Repository → Database kompozisyonu)
* ✔️ Constructor kullanımı
* ✔️ Kalıtım (BaseRepository → BookRepository, StudentRepository, LoanRepository)
* ✔️ Koleksiyonlar (ArrayList dönüşleri)
* ✔️ SQLite Bağlantısı (Database.java)
* ✔️ JDBC CRUD işlemleri
* ✔️ PreparedStatement kullanımı
* ✔️ Veri tabanı dosyası ve tablo oluşturma
* ✔️ Konsol Menü Sistemi

---

## 🏛️ Sistem Bileşenleri

### 1) **Book Sınıfı**

* id
* title
* author
* year

### 2) **Student Sınıfı**

* id
* name
* department

### 3) **Loan Sınıfı**

* id
* bookId
* studentId
* dateBorrowed
* dateReturned

### 4) **Database Sınıfı**

* SQLite bağlantısı kurar
* Tabloları CREATE TABLE ile oluşturur
* Bağlantıyı kapatır

### 5) **Repository Sınıfları (CRUD)**

* BookRepository
* StudentRepository
* LoanRepository

Tümü şu fonksiyonları içerir:

```
add()  
update()  
delete()  
getById()  
getAll()  
```

Ayrıca tüm repository sınıfları **BaseRepository** sınıfından kalıtım almaktadır.

---

## 📚 Uygulama Menüsü

Program çalıştığında kullanıcıya şu menü sunulur:

1. Kitap Ekle
2. Kitapları Listele
3. Öğrenci Ekle
4. Öğrencileri Listele
5. Kitap Ödünç Ver
6. Ödünç Listesini Görüntüle
7. Kitap Geri Teslim Al
8. Çıkış

---

## 🗄️ SQLite Veri Tabanı Şeması

### **books** tablosu

```
id INTEGER PRIMARY KEY AUTOINCREMENT,
title TEXT,
author TEXT,
year INTEGER
```

### **students** tablosu

```
id INTEGER PRIMARY KEY AUTOINCREMENT,
name TEXT,
department TEXT
```

### **loans** tablosu

```
id INTEGER PRIMARY KEY AUTOINCREMENT,
bookId INTEGER,
studentId INTEGER,
dateBorrowed TEXT,
dateReturned TEXT
```

---

## ▶️ Çalıştırma Adımları

1. Proje klasörünü bilgisayarına indir.
2. `sqlite-jdbc.jar` dosyasını projeye ekle (libs klasörü).
3. `Main.java` dosyasını çalıştır.
4. Program ilk çalıştığında **SmartLibrary.db** dosyasını ve tabloları otomatik oluşturur.

---

## 📦 Proje Yapısı (Klasör Hiyerarşisi)

```
src/
 ├── database/
 │     └── Database.java
 ├── models/
 │     ├── Book.java
 │     ├── Student.java
 │     └── Loan.java
 ├── repositories/
 │     ├── BaseRepository.java
 │     ├── BookRepository.java
 │     ├── StudentRepository.java
 │     └── LoanRepository.java
 ├── utils/
 │     └── ConsoleHelper.java
 └── Main.java
```

---

## 📝 Notlar

* Kod yapısı OOP prensiplerine uygun şekilde tasarlanmıştır.
* Tüm veri işlemleri PreparedStatement ile güvenli şekilde yapılmaktadır.
* Kalıtım ve kompozisyon yapıları açık bir şekilde kullanılmıştır.
