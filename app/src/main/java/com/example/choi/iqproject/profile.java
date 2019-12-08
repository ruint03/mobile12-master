package com.example.choi.iqproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class profile extends AppCompatActivity implements View.OnClickListener {
    private Button logout,remove;
    private TextView email,name,gender,birth,seek,avoid,sensor,regist;
    private String id1;
    private  FirebaseAuth auth;
    private DatabaseReference Ref;
    private DatabaseReference Ref1;
    FirebaseDatabase Date_re;
    FirebaseUser currUser;
    Toolbar toolbar;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_layout);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        auth = FirebaseAuth.getInstance();
        Date_re= FirebaseDatabase.getInstance();
        Ref = Date_re.getReference("USER");
        logout = (Button)findViewById(R.id.Logout);
        remove = (Button)findViewById(R.id.remove);
        email = (TextView)findViewById(R.id.UserEmail);
        name = (TextView)findViewById(R.id.Username);
        gender = (TextView)findViewById(R.id.Usergender);
        birth = (TextView)findViewById(R.id.Userbirth);
        seek = (TextView)findViewById(R.id.seek);
        avoid = (TextView)findViewById(R.id.avoid);
        sensor = (TextView)findViewById(R.id.sensor);
        regist = (TextView)findViewById(R.id.regist);

        profile();
        logout.setOnClickListener(this);
        remove.setOnClickListener(this);
    }

    public  void  onClick(View view){
        if(view.getId() == R.id.Logout){
            auth.signOut();
            Toast.makeText(this,"로그아웃 되었습니다!" ,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivityForResult(intent, 3000);
            finish();
        }

        if(view.getId() == R.id.remove){
            AlertDialog.Builder alert_confirm = new AlertDialog.Builder(profile.this);
            alert_confirm.setMessage("정말 계정을 삭제 할까요?").setCancelable(false).setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    user.delete()
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Ref.child(user.getUid()).removeValue();
                                    Toast.makeText(profile.this,"계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                    finish();
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                }
                            });
                }
            });
            alert_confirm.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(profile.this, "취소", Toast.LENGTH_LONG).show();
                }
            });
            alert_confirm.show();
        }

    }

    public void profile() {
        FirebaseUser user = auth.getCurrentUser();
        email.setText("반갑습니다!! "+ user.getEmail()+"으로 로그인 하였습니다.");
        Ref.child(user.getUid()).child("NAME").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                name.setText("아이 이름 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Ref.child(user.getUid()).child("GENDER").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                gender.setText("아이 성별 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Ref.child(user.getUid()).child("BIRTH").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                birth.setText("아이 탄생일 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Ref.child(user.getUid()).child("seek").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);

                if (value.equals("no")){
                    seek.setText("설문을 통해 아이를 알아보세요!");
                }
                else {
                    sumDB();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    public void sumDB(){
        FirebaseUser user = auth.getCurrentUser();
        Ref.child(user.getUid()).child("seek").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                seek.setText("감각 추구 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Ref.child(user.getUid()).child("avoid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                avoid.setText("감각 회피 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Ref.child(user.getUid()).child("sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                sensor.setText("감각 민첩 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Ref.child(user.getUid()).child("regist").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Object value = dataSnapshot.getValue(Object.class);
                regist.setText("감각 둔감 : " + value.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
