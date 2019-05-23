package com.example.aa.tugaspw.BookPayment;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aa.tugaspw.Helper.RealmHelper;
import com.example.aa.tugaspw.Model.PesananModel;
import com.example.aa.tugaspw.R;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class BookingRinjani extends AppCompatActivity {

    private static final String TAG = "tiket";
    TextView tglBerangkat, tglPulang, namaPesanan;
    PesananModel pesananModel;
    RealmHelper realmHelper;
    EditText namaPemesan, orang;
    ImageView gambarPesanan;
    RelativeLayout btnTourGuide;
    LinearLayout formTour;
    String gambar;

    CheckBox checkBox;

    Button book;
    private DatePickerDialog dialog;
    private DatePickerDialog.OnDateSetListener mDateSetListener, mDateSetListener1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_rinjani);

        Toolbar mToolbar = findViewById(R.id.bookingBack);
        mToolbar.setTitle("Booking");
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setNavigationIcon(R.drawable.ic_kiri);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnTourGuide = findViewById(R.id.btnTourGuide);
        formTour = findViewById(R.id.formTourGuide);

        checkBox = findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (checkBox.isChecked()) {
                    checkBox.setChecked(true);

                    btnTourGuide.setVisibility(View.VISIBLE);
                    btnTourGuide.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.downtoup));

                    btnTourGuide.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            formTour.setVisibility(View.VISIBLE);
                            formTour.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.downtoup));
                        }
                    });


                } else {
                    checkBox.setChecked(false);

                    btnTourGuide.setAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.uptodown));
                    btnTourGuide.setVisibility(View.GONE);

                }

            }
        });

        tglBerangkat = findViewById(R.id.tanggal_berangkat);
        tglPulang = findViewById(R.id.tanggal_pulang);

        tglPulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                dialog = new DatePickerDialog(BookingRinjani.this, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth, mDateSetListener1, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        tglBerangkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                dialog = new DatePickerDialog(BookingRinjani.this, android.R.style.Theme_DeviceDefault_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "-" + month + "-" + year;
                tglBerangkat.setText(date);
            }
        };

        mDateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "-" + month + "-" + year;
                tglPulang.setText(date);
            }
        };

        book = findViewById(R.id.prosesBtnBookingRinjani);
        namaPemesan = findViewById(R.id.nama_pemesan);
        namaPesanan = findViewById(R.id.nama_pesanan);
        orang = findViewById(R.id.orang);
        gambarPesanan = findViewById(R.id.imageBooking);
        Picasso.get().load(R.drawable.gunung_rinjani).into(gambarPesanan);

        pesananModel = new PesananModel();
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().build();
        Realm realm = Realm.getInstance(realmConfiguration);
        realmHelper = new RealmHelper(realm);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesananModel.setNama_pesanan(String.valueOf(namaPesanan.getText()));
                pesananModel.setNama_pemesan(String.valueOf(namaPemesan.getText()));
                pesananModel.setGambar_pesanan(String.valueOf(Uri.parse("https://trello-attachments.s3.amazonaws.com/5b99f898f881065f2b5372cf/5be4244da6b8c54c6e1329cc/359fbf00a851cbaf9c578fcc80fa2ac9/Gunung_Rinjani%2C_Nusa_Tenggara_Barat.png")));
                pesananModel.setTanggal_berangkat(String.valueOf(tglBerangkat.getText()));
                pesananModel.setTanggal_pulang(String.valueOf(tglPulang.getText()));
                pesananModel.setJumlah_orang(String.valueOf(orang.getText()));
                realmHelper.save(pesananModel);
                Toast.makeText(getApplicationContext(), "Anda sukses Melakukan pemesanan", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
