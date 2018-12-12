package c.cs125.fitscape;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main3Activity extends AppCompatActivity {

    public static double bmi;

    public static EditText result;
    EditText links;
    String resultString;
    Button screenshot;
    public static boolean isChecked;

    private View main;
    private ImageView imageview;

    private void captureScreen() {
        View v = findViewById(R.id.resultsShow);
        v.setDrawingCacheEnabled(true);
        Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
        v.setDrawingCacheEnabled(false);
        try {
            FileOutputStream fos = new FileOutputStream(new File(Environment
                    .getExternalStorageDirectory().toString(), "SCREEN"
                    + System.currentTimeMillis() + ".png"));
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap screenShot(View view) {
        if (view != null) {
            Bitmap bitmap = Bitmap.createBitmap(view.getWidth(),
                    view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            view.draw(canvas);
            return bitmap;
        }
        return null;
    }

    private void checkBMI(double bmi) {
        if (isChecked) {
            result.setText(R.string.result5);
            links.setText(Html.fromHtml("<a href=\"https://www.medicinenet.com/best_exercises_for_asthma_yoga_swimming_biking/views.html\">Healthy Exercises for People with Respiratory problems</a> "));
            links.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (bmi < 18.5) {
            result.setText(R.string.result1);
            links.setText(Html.fromHtml("<a href=\"https://exercise.lovetoknow.com/Exercise_for_Underweight\">Healthy Exercises for Underweight People</a> "));
            links.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (bmi < 25) {
            result.setText(R.string.result2);
            links.setText(Html.fromHtml("<a href=\"https://www.sparkpeople.com/resource/fitness_plan_generator.asp\">Exercises to do for a Healthy body</a> "));
            links.setMovementMethod(LinkMovementMethod.getInstance());
        } else if (bmi < 30) {
            result.setText(R.string.result3);
        } else {
            System.out.println(bmi);
            result.setText(R.string.result4);
            links.setText(Html.fromHtml("<a href=\"https://www.acefitness.org/education-and-resources/professional/expert-articles/5296/exercises-for-obese-clients-training-progressions-to-try\">Healthy Exercises for Heavier People</a> "));
            links.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    private void getMsg(int num) {
        int toastmsg;
        if (num == 1) {
            toastmsg = R.string.workout_msg;
        } else {
            toastmsg = R.string.gym_msg;
        }
        Toast.makeText(this, toastmsg, Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},00);

        result = findViewById(R.id.resultsShow);
        result.setEnabled(false);
        result.setTextColor(Color.BLACK);

        links = findViewById(R.id.links);

        screenshot = findViewById(R.id.screenshot);
        screenshot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Bitmap bitmap;
                View v1 = findViewById(R.id.resultsShow);// get ur root view id
                v1.setDrawingCacheEnabled(true);
                bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                v1.setDrawingCacheEnabled(false);

                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 40, bytes);
                File f = new File(Environment.getExternalStorageDirectory()
                        + File.separator + "test.jpg")
                f.createNewFile();
                FileOutputStream fo = new FileOutputStream(f);
                fo.write(bytes.toByteArray());
                fo.close(); */

                /* String imagePath = null;
                Bitmap imageBitmap = screenShot(findViewById(R.id.resultsShow));
                if (imageBitmap != null) {
                    imagePath = MediaStore.Images.Media.insertImage(getContentResolver(), imageBitmap, "title", null);
                } */
                startActivity(new Intent(Main3Activity.this, Main4Activity.class));

            }
        });

        Button workout = findViewById(R.id.workoutID);
        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Information", "This button would display to workout plan created in the space below. " + bmi);
                // getMsg(1);
                try {
                    checkBMI(bmi);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}
