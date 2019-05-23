package com.example.aa.tugaspw;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aa.tugaspw.Adapter.HomeMenuAdapter;
import com.example.aa.tugaspw.Model.HomeMenuModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView recyclerViewHome;
    HomeMenuAdapter homeMenuAdapter;
    ArrayList<HomeMenuModel> homeMenuModelArrayList;

    LinearLayout form;

    ImageView login;
    LinearLayout formLogin, formDaftar;
    private EditText myNama, myNoHP, myEmail, myUsername, myPassword;
    private TextView myTglLahir, goDaftar, noHp, AkunEmail;
    private Button btnDaftar, btnLogin;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    private String getNama, getTglLahir, getNoHP, getEmail, getUsername, getPassword, getEmailLogin, getPasswordLogin;
    private EditText myEmailLogin, myPasswordLogin;
    private ProgressBar progressBarLogin;
    private FirebaseAuth.AuthStateListener listener;
    private Dialog d;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerViewHome = view.findViewById(R.id.gridView);

        AkunEmail = view.findViewById(R.id.emailAkun);

        if (recyclerViewHome != null) {
            addData();
            homeMenuAdapter = new HomeMenuAdapter(homeMenuModelArrayList);
            recyclerViewHome.setHasFixedSize(true);
            recyclerViewHome.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerViewHome.setAdapter(homeMenuAdapter);
        }

        login = view.findViewById(R.id.user);

        noHp = view.findViewById(R.id.noHp);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d = new Dialog(getContext());
                d.setTitle("Login");
                d.setContentView(R.layout.form_login);

                formLogin = d.findViewById(R.id.formLogin);
                formDaftar = d.findViewById(R.id.formDaftar);
                form = getActivity().findViewById(R.id.formAkun);

                goDaftar = d.findViewById(R.id.signUp);

                myNama = d.findViewById(R.id.input_nama_lengkap);
                myTglLahir = d.findViewById(R.id.input_tgl_lahir);
                myNoHP = d.findViewById(R.id.input_no_hp);
                myEmail = d.findViewById(R.id.input_email);
                myUsername = d.findViewById(R.id.input_username_daftar);
                myPassword = d.findViewById(R.id.input_password_daftar);
                progressBar = d.findViewById(R.id.progressBarDaftar);
                progressBarLogin = d.findViewById(R.id.progressBarLogin);

                myEmailLogin = d.findViewById(R.id.input_email_login);
                myPasswordLogin = d.findViewById(R.id.input_password);

                auth = FirebaseAuth.getInstance();
                myPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                btnDaftar = d.findViewById(R.id.btnDaftar);
                btnLogin = d.findViewById(R.id.btnLogin);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cekLogIn();
                    }
                });

                listener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                        //Mengecek apakah ada user yang sudah login / belum logout
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user != null) {
                            //Jika ada, maka halaman akan langsung berpidah pada MainActivity
                            Toast.makeText(getContext(), "Anda sudah pernah masuk kedalam akun anda", Toast.LENGTH_SHORT).show();
                            d.hide();
                        }
                    }
                };

                btnDaftar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cekDataUser();
                    }
                });

                goDaftar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        formDaftar.setAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_in_left));
                        formLogin.setAnimation(AnimationUtils.loadAnimation(getContext(), android.R.anim.slide_out_right));
                        formDaftar.setVisibility(View.VISIBLE);
                        formLogin.setVisibility(View.GONE);

                    }
                });

                d.show();

            }
        });

        return view;
    }

    private void showAkun() {

        if (auth.getCurrentUser() == null) {
            form.setVisibility(View.GONE);

        } else {
            form.setVisibility(View.VISIBLE);
            AkunEmail.setText(auth.getCurrentUser().getEmail());
        }

    }

    private void cekLogIn() {

        getEmailLogin = myEmailLogin.getText().toString();
        getPasswordLogin = myPasswordLogin.getText().toString();

        if (TextUtils.isEmpty(getEmailLogin) || TextUtils.isEmpty(getPasswordLogin)) {
            Toast.makeText(getContext(), "Email atau Sandi Tidak Boleh Kosong Login", Toast.LENGTH_SHORT).show();
        } else {
            sendLogIn();
            progressBar.setVisibility(View.VISIBLE);
        }
    }

    private void sendLogIn() {

        auth.signInWithEmailAndPassword(getEmailLogin, getPasswordLogin)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //Mengecek status keberhasilan saat login
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Login Success", Toast.LENGTH_SHORT).show();

                            showAkun();

                            d.hide();
                        } else {
                            Toast.makeText(getContext(), "Tidak Dapat Masuk, Silakan Coba Lagi", Toast.LENGTH_SHORT).show();
                            progressBarLogin.setVisibility(View.GONE);
                        }
                    }
                });

    }

    /*//Menerapkan Listener
    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(listener);
    }

    //Melepaskan Litener
    @Override
    public void onStop() {
        super.onStop();
        if(listener != null){
            auth.removeAuthStateListener(listener);
        }
    }*/

    private void cekDataUser() {

        getNama = myNama.getText().toString();
        getTglLahir = myTglLahir.getText().toString();
        getNoHP = myNoHP.getText().toString();
        getEmail = myEmail.getText().toString();
        getUsername = myUsername.getText().toString();
        getPassword = myPassword.getText().toString();

        if (TextUtils.isEmpty(getEmail) || TextUtils.isEmpty(getPassword)) {
            Toast.makeText(getContext(), "Email atau Password Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else {
            //Mengecek panjang karakter password baru yang akan didaftarkan
            if (getPassword.length() < 6) {
                Toast.makeText(getContext(), "Sandi Terlalu Pendek, Minimal 6 Karakter", Toast.LENGTH_SHORT).show();
            } else {
                progressBar.setVisibility(View.VISIBLE);
                createUserAccount();
            }
        }
    }

    private void createUserAccount() {
        auth.createUserWithEmailAndPassword(getEmail, getPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //Mengecek status keberhasilan saat medaftarkan email dan sandi baru
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Sign Up Success", Toast.LENGTH_SHORT).show();
                            formDaftar.setVisibility(View.GONE);
                            formLogin.setVisibility(View.VISIBLE);
                        } else {
                            Toast.makeText(getContext(), "Terjadi Kesalahan, Silakan Coba Lagi", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void addData() {

        homeMenuModelArrayList = new ArrayList<>();
        homeMenuModelArrayList.add(new HomeMenuModel(R.drawable.gunung1, "Gunung"));
        homeMenuModelArrayList.add(new HomeMenuModel(R.drawable.pantai, "Pantai"));
        homeMenuModelArrayList.add(new HomeMenuModel(R.drawable.bumper1, "Bumper"));
        homeMenuModelArrayList.add(new HomeMenuModel(R.drawable.airterjun, "Air Terjun"));
        homeMenuModelArrayList.add(new HomeMenuModel(R.drawable.danau, "Danau"));
        homeMenuModelArrayList.add(new HomeMenuModel(R.drawable.hutan, "Hutan"));

    }
}
