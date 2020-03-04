package com.example.admin.kulinerjogja;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.List;

public class Kuliner extends AppCompatActivity {
    // membuat array data list buah
    String list_nama[] = {
            "GUDEG",
            "BAKPIA",
            "GEPLAK",
            "KRECEK",
            "OSENG MERCON",
            "YANGKO",
            "COKELAT MONGGO"
    };
    String deskripsi[] = {
            "Gudeg merupakan salah satu makanan khas dari daerah istimewa yogyakarta , gudeg ini mempunyai rasa yang manis, gudeg terbuat dari nangka muda yang dimasak dengan santan. Perlu waktu lama untuk membuat makanan ini. Warna gudeg yang cokelat dihasilkan oleh daun jati yang dimasak secara bersamaan",
            "Bakpia adalah makanan yang terbuat dari campuran kacang hijau dengan gula yang dibungkus dengan tepung , lalu dipanggang . istilah bakpia sendiri adalah berasal dari dialek Hokkian , yaitu dari kata 'bak' yang berati daging dan 'pia' yang berarti kue, yang secara harfiah berarti roti berisikan daging",
            "Geplak adalah makanan khas kota Bantul yang terbuat dari parutan kelapa dan gula pasir atau gula jawa , yang rasanya manis. Bentuknya yang unik , membuat makanan ini digemari oleh masyarakat setempat maupun wisatawan. Bentuk geplak adalah bulat dan memiliki banyak warna / warna - warni",
            "Krecek atau kerecek adalah makanan yang dibuat dari kulit sapi yang dipotong kecil-kecil . Krecek ini wajib disuguhkan bersama gudeg sebagai pelengkapnya",
            "Oseng mercon adalah makanan tradisional khas yogyakarta yang sangat pedas dengan cabai rawit sebagai bahan utamanya . Makanan ini terbuat dari bahan dasar dagig sapi , gajih , dan kikil atau kulit sapi yang dimasak dengan cara dioseng. Untuk ukuran 10kg daging sapi biasanya menggunakan perbandingan 2kg cabai rawit",
            "Yangko merupakan makanan khas yogyakarta yang terbuat dari tepung ketan, Yangko berbentuk kotak dan kenyal , memiliki rasa yang manis, biasanya terdapat isi kacang didalamnya",
            "Cokelat Monggo merupakan salah satu oleh oleh baru yang wajib dibeli ketika berkunjung ke yogyakarts .Cokelat bergaya Swiss ini diproduksi di Kota Gede, Yogyakarta;)"
    };
    // daftar gambar
    int list_gambar[] = {
            R.drawable.gudeg,
            R.drawable.bakpia,
            R.drawable.geplak,
            R.drawable.krecek,
            R.drawable.oseng_mercon,
            R.drawable.yangko,
            R.drawable.cokelat_monggo
    };
    ListView LvKuliner;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        LvKuliner = (ListView) findViewById(R.id.LvKuliner);
        // membuat sebuah adapter yang berfungsi untuk menampung data sementara sebelum di tampilkan ke dalam list view
        AdapterKuliner adapter = new AdapterKuliner(this, list_nama, list_gambar, deskripsi);
        //menampilkan / memasukan adapter ke dalam ListView
        LvKuliner.setAdapter(adapter);
        //memberikan event ketika listview diklik
        LvKuliner.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // inten ke detail.java dengan mengirimkan parameter yang berisi nama dan gambar
                Intent a = new Intent(getApplicationContext(), DetailActivity.class);
                //kirimkan parameter
                a.putExtra("Nama", list_nama[position]);
                a.putExtra("Gambar", list_gambar[position]);
                a.putExtra("Deskripsi", deskripsi[position]);

                //kirimkan ke detail.java
                startActivity(a);
            }
        });
    }
    // class di dalam class
    private class AdapterKuliner extends ArrayAdapter {
        String list_nama[];
        String deskripsi[];
        int list_gambar[];
        Activity activity;

        //konstruktor
        public AdapterKuliner( Kuliner Kuliner, String[] list_nama, int[] list_gambar, String[] deskripsi) {
            super(Kuliner, R.layout.list_kuliner, list_nama);
            this.list_gambar = list_gambar;
            activity = Kuliner;
            this.list_nama = list_nama;
            this.deskripsi = deskripsi;

        }
        //menthode yang digunakan untuk memanggil layout list_kuliner dan mengenalkan widgetnya
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // panggil layout list_kuliner
            LayoutInflater inflater = (LayoutInflater) activity.getLayoutInflater();
            View v = inflater.inflate(R.layout.list_kuliner, null);
            // kenalkan widget yang ada pada list buah
            ImageView gambar;
            TextView nama;

            //casting widget id
            gambar = (ImageView) v.findViewById(R.id.IvKuliner);
            nama = (TextView) v.findViewById(R.id.TxtNamaKuliner);


            // set data kedalam image
            gambar.setImageResource(list_gambar[position]);
            nama.setText(list_nama[position]);


            return v;
        }
    }
}