package jos.huuduan.hinhnenchuagiesu;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.io.IOException;

import jos.huuduan.hinhnenchuagiesu.user.User;
import jos.huuduan.hinhnenchuagiesu.R;


public class OnClickActivity extends AppCompatActivity {
    private WallpaperManager wallpaperManager;
    public AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_click);
        Bundle bundle = getIntent().getExtras();
        if (bundle ==null){
            return;
        }
        final User user = (User) bundle.get("OBA");

        ImageView tvNameUser = findViewById(R.id.tv_Onclick);
        Button btnOnClick = findViewById(R.id.btHinhNen);

        wallpaperManager =WallpaperManager.getInstance(getApplicationContext());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),user.getResouceImage());


        AdView adView = new AdView(this);

        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5382625544778444/9081309714");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView) ;
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int height = metrics.heightPixels;
        int width = metrics.widthPixels;
        Bitmap mbitmap;
        Bitmap myBitmap = BitmapFactory.decodeResource(getResources(), user.getResouceImage());
        mbitmap = Bitmap.createScaledBitmap(myBitmap, width, height, true);
        wallpaperManager.getInstance(this);
        wallpaperManager.setWallpaperOffsetSteps(1,1);
        wallpaperManager.suggestDesiredDimensions(width,height);
        tvNameUser.setImageBitmap(mbitmap);

        btnOnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    wallpaperManager.setBitmap(mbitmap);
                    Toast.makeText(OnClickActivity.this,"Đã cài đặt hình nền !!!",Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}

