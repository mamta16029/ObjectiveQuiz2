package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String;
import org.xml.sax.helpers.DefaultHandler;

import static in.ac.iiitd.psingh.mc16.objectivequiz.R.layout.activity_cheat;

public class cheatActivity extends AppCompatActivity {

    public boolean isPrime1(int p)
    {
        if(p==1 || p==2)
        {
            if(p==1)
                return false;
            else
                return true;
        }
        else if(p>2 && p<1001)
        {int i;
            for(i=2;i<p;i++)
            {
                if(p%i==0)
                {
                    return false;

                }
            }
            return true;
        }
        else
            return false;

    }
    public String intval(boolean m)
    {
        if(!m)
            return("not a prime number!");
        else
            return("a prime number!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_cheat);
        int n= getIntent().getIntExtra("number", -1);
        TextView txt = (TextView)findViewById(R.id.textView);
        boolean m= isPrime1(n);

        txt.setText("Number "+n+" is " + (intval(m)));

        intval(m);
        Button buttonback=(Button)findViewById(R.id.buttonback);
        buttonback.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                    Intent intent=new Intent();
                    intent.putExtra("str",100);
                    setResult(RESULT_OK, intent);
               // Toast.makeText(getApplicationContext(),"hinttaken!",Toast.LENGTH_SHORT).show();

                finish();

               // onBackPressed();
            }
        });
    }
}
