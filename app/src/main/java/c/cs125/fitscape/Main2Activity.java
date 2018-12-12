package c.cs125.fitscape;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    String nameP;
    int ageP;
    double weightP, heightP;

    EditText name;
    EditText age;
    EditText weight;
    EditText height;
    CheckBox problems;
    boolean flag = true;

    public void makeToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        name.setVisibility(View.VISIBLE);
        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        problems = findViewById(R.id.checkBox);

        Button welcomeButton = findViewById(R.id.calculateID);
        welcomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!name.getText().toString().equals("") && !age.getText().toString().equals("") && !weight.getText().toString().equals("") && !height.getText().toString().equals("")) {
                    nameP = name.getText().toString();
                    ageP = Integer.valueOf(age.getText().toString());
                    weightP = Integer.valueOf(weight.getText().toString());
                    heightP = Integer.valueOf(height.getText().toString());
                    if (ageP < 13 || ageP > 100) {
                        makeToast("The app is not available for ages below 13 and above 100.");
                        flag = false;
                    } else {
                        flag = true;
                    }
                    if (heightP < 56 || heightP > 272) {
                        makeToast("The entered height is invalid");
                        flag = false;
                    } else {
                        flag = true;
                    }
                } else {
                    makeToast("Please enter all values correctly.");
                    flag = false;
                }
                if (flag) {
                    double power = (heightP/100)*(heightP/100);
                    Main3Activity.bmi = (weightP/power);
                    Main3Activity.isChecked = problems.isChecked();
                    // makeToast(nameP);
                    startActivity(new Intent(Main2Activity.this, Main3Activity.class));
                }
                // startActivity(new Intent(Main2Activity.this, Main3Activity.class));
            }
        });

    }
}
/* <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Main2Activity">

    <EditText
        android:id="@+id/editText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Name"
        tools:layout_editor_absoluteX="48dp"
        tools:layout_editor_absoluteY="66dp" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        tools:layout_editor_absoluteX="219dp"
        tools:layout_editor_absoluteY="82dp" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Age"
        tools:layout_editor_absoluteX="48dp"
        tools:layout_editor_absoluteY="117dp" />

    <EditText
        android:id="@+id/editText3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Weight"
        tools:layout_editor_absoluteX="48dp"
        tools:layout_editor_absoluteY="171dp" />

    <EditText
        android:id="@+id/editText4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Height"
        tools:layout_editor_absoluteX="48dp"
        tools:layout_editor_absoluteY="218dp" />

    <EditText
        android:id="@+id/editText5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Working hrs / week"
        tools:layout_editor_absoluteX="48dp"
        tools:layout_editor_absoluteY="272dp" />

    <EditText
        android:id="@+id/editText6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="Respiratory problems"
        tools:layout_editor_absoluteX="48dp"
        tools:layout_editor_absoluteY="330dp" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        tools:layout_editor_absoluteX="219dp"
        tools:layout_editor_absoluteY="133dp" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        tools:layout_editor_absoluteX="219dp"
        tools:layout_editor_absoluteY="286dp" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        tools:layout_editor_absoluteX="219dp"
        tools:layout_editor_absoluteY="234dp" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        tools:layout_editor_absoluteX="219dp"
        tools:layout_editor_absoluteY="188dp" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Results"
        tools:layout_editor_absoluteX="197dp"
        tools:layout_editor_absoluteY="413dp" />

    <CheckBox
        android:id="@+id/checkBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="CheckBox"
        tools:layout_editor_absoluteX="229dp"
        tools:layout_editor_absoluteY="337dp" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Back"
        tools:layout_editor_absoluteX="109dp"
        tools:layout_editor_absoluteY="413dp" />
</android.support.constraint.ConstraintLayout>
*/