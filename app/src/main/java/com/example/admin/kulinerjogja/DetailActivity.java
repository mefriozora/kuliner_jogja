package com.example.admin.kulinerjogja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView gambar;
    TextView nama, Des;

    // buat variable untuk menampung nama buah dan gambar
    String namaKuliner;
    String deskripsi;
    int gambarKuliner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // casting id
        gambar = (ImageView) findViewById(R.id.IvDetailGambar);
        nama = (TextView)findViewById(R.id.TxtDetailKuliner);
        Des = (TextView)findViewById(R.id.TxtDeskipsi);

        // ambil nilai yang di kirim pada saat di klik
        namaKuliner = getIntent().getStringExtra("Nama");
        deskripsi = getIntent().getStringExtra("Deskripsi");
        gambarKuliner = getIntent().getIntExtra("Gambar",0);

        // tampilkan di widged
        gambar.setImageResource(gambarKuliner);
        nama.setText(namaKuliner);
        Des.setText(deskripsi);
    }
}
