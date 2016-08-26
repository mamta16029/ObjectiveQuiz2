package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hintActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);
        TextView txt;
        txt=(TextView)findViewById(R.id.textView4);
        txt.setText("The Number not having any factors other than 1 and the number itself is a prime number.");

        Button buttonback=(Button)findViewById(R.id.buttonback1);
        buttonback.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent();
                intent.putExtra("str1",100);
                setResult(RESULT_OK, intent);
                // Toast.makeText(getApplicationContext(),"hinttaken!",Toast.LENGTH_SHORT).show();

                finish();

                // onBackPressed();
            }
        });
    }
}
