package project1.udacity.aithanasakis.project1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface awsomefont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        Typeface caligraphy = Typeface.createFromAsset(getAssets(), "dancing-script.regular.ttf");

        TextView textViewslogan = (TextView) findViewById(R.id.textViewslogan);
        textViewslogan.setTypeface(caligraphy);
        TextView textview1 = (TextView) findViewById(R.id.textView1);
        textview1.setTypeface(awsomefont);
        TextView textview2 = (TextView) findViewById(R.id.textView2);
        textview2.setTypeface(awsomefont);
        TextView textview3 = (TextView) findViewById(R.id.textView3);
        textview3.setTypeface(awsomefont);
        //  textview1.setY(200);
    }

    public void onClickAddress(View v) {
        double latitude = 40.592953;
        double longitude = 22.958952;
        String label = "Nikos Bakery";
        String uriBegin = "geo:" + latitude + "," + longitude;
        String query = latitude + "," + longitude + "(" + label + ")";
        String encodedQuery = Uri.encode(query);
        String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
        Uri uri = Uri.parse(uriString);
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickPhone(View v) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + "111112222"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void onClickLogo(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ble.com.gr")));
    }
}
