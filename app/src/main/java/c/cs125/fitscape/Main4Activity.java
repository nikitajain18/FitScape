package c.cs125.fitscape;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main4Activity extends AppCompatActivity {

    private ImageView imageView;
    View main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        main = Main3Activity.result;
        imageView = findViewById(R.id.imageView);
        Bitmap b = Screenshot.takescreenshotOfRootView(main);
        imageView.setImageBitmap(b);

    }
}
