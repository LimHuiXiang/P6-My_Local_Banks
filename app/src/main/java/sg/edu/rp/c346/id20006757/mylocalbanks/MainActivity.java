package sg.edu.rp.c346.id20006757.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView DBS, OCBC, UOB;
    String TextViewClicked = "";
    String url = "";
    String phoneno = "";
    boolean favDBS = false, favOCBC = false, favUOB = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        //…
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact The Bank");


        if (v == DBS) {
            TextViewClicked = "DBS";
        } else if (v == OCBC) {
            TextViewClicked = "OCBC";
        } else
            TextViewClicked = "UOB";

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (TextViewClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dbs.com.sg/index/default.page#wm"));
                startActivity(intent);

            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 111 1111"));
                startActivity(intentCall);
            }
        }

        if (TextViewClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intent);

            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 363 3333"));
                startActivity(intentCall);
            }

        }

        if (TextViewClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://pib.uob.com.sg/PIBLogin/Public/processPreCapture.do?keyId=lpc"));
                startActivity(intent);

            } else {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1800 222 2121"));
                startActivity(intentCall);
            }
        }
        return true; //menu item successfully handled
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.language) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
            return true;
        } else if (id == R.id.language1) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
            return true;



        }
        return super.onOptionsItemSelected(item);
    }
}







