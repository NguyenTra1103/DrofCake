package com.example.droidcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();//Phan biet 3 banh
        //Toast.makeText(this,"You have order cake",Toast.LENGTH_LONG).show();
    }

    public void showDonutOrder(View view) {
        if (view.getId() == R.id.donut) {
            displayToast(getString(R.string.donut_order_message));
        }else if (view.getId() == R.id.ice_cream){
            displayToast(getString(R.string.ice_cream_order_message));

        }
        else if (view.getId() == R.id.froyo){
            displayToast(getString(R.string.froyo_order_message));

        }

    }

    public void onClick(View view) {
        Intent intent = new Intent(this,OrderActivity.class);
        startActivity(intent);
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */

    /*public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
    }*/

    /**
     * Shows a message that the froyo image was clicked.
     */
   /* public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
    }*/
// Hien Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Bat su kien menu item
    /*public void order(MenuItem menuItem){
        displayToast("Order");
    }*/
    // Bat su kiem menu item thuong dung

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                displayToast(getString(R.string.settings));
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                myAlertBuilder.setTitle("Thanh toan???");
                myAlertBuilder.setMessage("Ban co muon thanh toan ngay bay gio khong?");
                myAlertBuilder.setPositiveButton("OK", (dialogInterface, i) -> {
                    startActivity(new Intent(this,OrderActivity.class));
                });
                myAlertBuilder.setNegativeButton("Cancel",null);
                myAlertBuilder.show();
                return true;
            case R.id.action_status:
// Date
                displayToast(getString(R.string.status));
                return true;

            case R.id.action_order:
                displayToast(getString(R.string.order));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);
    }
}