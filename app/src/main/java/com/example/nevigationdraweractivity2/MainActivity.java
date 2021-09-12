package com.example.nevigationdraweractivity2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.example.nevigationdraweractivity2.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Flaoting Action Button", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });

        DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        MyProfile myProfile=new MyProfile();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_id,myProfile);
        transaction.commit();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.profile:
                MyProfile myProfile=new MyProfile();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_id,myProfile);
                transaction.commit();

                break;

            case R.id.wallets:
                WalletFragment walletFragment=new WalletFragment();
                FragmentTransaction transaction1=getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.content_id,walletFragment);
                transaction1.commit();

                break;

            case R.id.chats:
                ChartsFragment chartsFragment=new ChartsFragment();
                FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                transaction2.replace(R.id.content_id,chartsFragment);
                transaction2.commit();

                break;

            case R.id.orders:
                OrdersFragment ordersFragment=new OrdersFragment();
                FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.content_id,ordersFragment);
                transaction3.commit();

                break;

                case R.id.coupans:
                    CoupensFragment coupensFragment=new CoupensFragment();
                    FragmentTransaction transaction4=getSupportFragmentManager().beginTransaction();
                    transaction4.replace(R.id.content_id,coupensFragment);
                    transaction4.commit();

                    break;

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.setting:
                Toast.makeText(MainActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                break;

            case  R.id.cart:
                Toast.makeText(MainActivity.this, "Cart ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contact:
                Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                break;

            case R.id.mapid:
                Intent intent=new Intent(MainActivity.this,MapsActivity.class);
                startActivity(intent);
                break;

            case R.id.logout:

                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                builder.setTitle("Alert");
                builder.setMessage("Do you want to Exit");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(MainActivity.this,Login.class);
                        startActivity(intent);
                        dialogInterface.dismiss();
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }

                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}