package in.ac.iiitd.psingh.mc16.objectivequiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity implements OnClickListener
{
    TextView txt;
    static int flag;
    public static final int REQUEST_CODE_one = 100;
    public static final int REQUEST_CODE_hint = 200;
    private Button cheatButton;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button hintButton;
private static TextView mtext;

static int n;
    private static final String TAG = "QuizActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        hintButton = (Button) findViewById(R.id.buttonhint);
        hintButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),hintActivity.class);
                intent.putExtra("number", n);

                startActivityForResult(intent,REQUEST_CODE_hint);



            }
        });

        cheatButton = (Button) findViewById(R.id.cheatButton);
        txt=(TextView)findViewById(R.id.textView3);
        cheatButton.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),cheatActivity.class);
                 intent.putExtra("number", n);

                startActivityForResult(intent,REQUEST_CODE_one);



            }
        });


mtext=(TextView)findViewById(R.id.textViewer);
        mNextButton = (Button) findViewById(R.id.next_button);
        if(flag==0) {
            n = rando();
            flag = 1;
        }

        mtext.setText("Is "+n+" a prime number?");
        mNextButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view)
            {
                
                    n=rando();
                
                mtext.setText("Is "+n+" a prime number?");
                txt.setText("");


            }
        });
        mTrueButton = (Button) findViewById(R.id.TrueButton);
        mTrueButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPrime(n)) {
                    Log.d(TAG, "Correct!");
                    Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.d(TAG, "Incorrect!");
                    Toast.makeText(getApplicationContext(),"Incorrect!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mFalseButton = (Button) findViewById(R.id.FalseButton);
        mFalseButton.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPrime(n))
                {  Log.d(TAG, "Incorrect!");
                    Toast.makeText(getApplicationContext(),"Incorrect!",Toast.LENGTH_SHORT).show();}
                else
                {  Log.d(TAG, "Correct!");
                    Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();}
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
       // if(requestCode==REQUEST_CODE_one)
       // {
            if(resultCode==RESULT_OK)
            {
                int i=data.getIntExtra("str",-1);
                if(-1!=i)
                txt.setText("You Cheated!");
            }

     //   }

       // super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");
    }
    public  int rando()
    {
        int diff=999;
        Random rn = new Random();
        int i = rn.nextInt(diff+1);

        i+=1;

        return i;
    }
    public boolean isPrime(int n)
    {
        if(n==1 || n==2)
        {
            if(n==1)
                return false;
            else
                return true;
        }
        else if(n>2 && n<1001)
        {int i;
            for(i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    return false;

                }
            }
            return true;
        }
        else
            return false;

    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }


    @Override
    public void onClick(View view) {

    }
}
