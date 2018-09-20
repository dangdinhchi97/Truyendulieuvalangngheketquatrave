package g.acedemy.truyendulieuvalangngheketquatrave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOutput extends AppCompatActivity {
Button btResult;

TextView tv_numbera,tv_numberb;
    int numberA;
    int numberB;
    static final String RESULT="result";
    static  final int RESULT_PIN=1;
    static  final int RESULT_PIN1=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
       getWilig();
        getData();
        setEvent();

    }

    private void getWilig() {
        btResult= (Button) findViewById(R.id.bt_result);
        tv_numbera= (TextView) findViewById(R.id.tv_numbera);
        tv_numberb= (TextView) findViewById(R.id.tv_numberb);
    }

    public void getData(){
        Intent intent=getIntent();
         numberA=intent.getIntExtra(ActivityInput.NUMBERA,0);
         numberB=intent.getIntExtra(ActivityInput.NUMBERB,0);
        tv_numbera.setText(numberA+"");
        tv_numberb.setText(numberB+"");
    }
    public void setEvent(){
        btResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result=numberA+ numberB;
                Intent intent=new Intent();
                intent.putExtra(RESULT,result);
                setResult(RESULT_PIN,intent);
                //setResultdemo();
                finish();
            }
        });
    }
   /* public void setResultdemo(){
        Intent intent=new Intent();
        intent.putExtra(RESULT,20 );
        setResult(RESULT_PIN1,intent);
    }*/
}
