# Catatan ASD

pada dasarnya cuma membuat program yang meniru konsep utama social media, yaitu hubungan antara satu akun dengan akun lainnya menggunakan graph.

## Main Module

1. login
2. create account
3. tampilkan semua account
4. exit

## Login Module

login cukup memasukkan username

module setelah login:

1. beranda (menampilkan postingan dari setiap teman)
2. posting (menambah postingan yang kemudian ditambahkan ke setiap postlist milik follower)
   jadi saat posting, postingan akan langsung dimasukkan ke setiap postlist milik teman. bukan disimpan di postlist milik dirinya sendiri.
3. cari akun untuk di follow (menampilkan semua list account(kecuali dirinya sendiri dan sistem), untuk kemudian bisa di follow)
4. logout

## Create Account Module

Account fields:

    1. username
    2. postlist (menggunakan queue untuk menyimpan postingan)

langsung mengisi form
-generate code secara sequential untuk tiap pembuatan akun, sehingga code unik untuk tiap akun.
-tiap akun akan menjadi vertices, dan hubungan pertemanan akan didefinisikan menggunakan edge.
-tiap akun harus dihubungkan dengan akun sistem, sehingga akun sistem akan menjadi root dari graph. dan akun baru tidak dimakan garbage collector

Posting fields:

    1. judul postingan
    2. isi postingan
    3. nama account
