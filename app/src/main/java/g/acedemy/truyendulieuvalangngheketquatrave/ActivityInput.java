package g.acedemy.truyendulieuvalangngheketquatrave;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityInput extends AppCompatActivity {
private EditText et_NumberA,et_NumberB;
private Button bt_Start;
static final String NUMBERA="NUMBERA";
    static final String NUMBERB="NUMBERB";
    static final int  REQUESTCODE=2018;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getWidget();
        setEvent();
    }

    private void setEvent() {
        bt_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(et_NumberA.getText().toString())&&!TextUtils.isEmpty(et_NumberB.getText().toString())){
                int numbera=Integer.parseInt(et_NumberA.getText().toString());
                int numberb=Integer.parseInt(et_NumberB.getText().toString());

                    Intent intent=new Intent(ActivityInput.this,ActivityOutput.class);
                    intent.putExtra(NUMBERA,numbera);
                    intent.putExtra(NUMBERB,numberb);
                    startActivityForResult(intent,REQUESTCODE);

            }
            }
        });
    }

    private void getWidget() {
        et_NumberA= (EditText) findViewById(R.id.et_numbera);
        et_NumberB= (EditText) findViewById(R.id.et_numberb);
        bt_Start= (Button) findViewById(R.id.bt_sart);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUESTCODE){
            switch (resultCode){
                case ActivityOutput.RESULT_PIN:
                int result=data.getIntExtra(ActivityOutput.RESULT,0);
                    Toast.makeText(this, result+"jjjj", Toast.LENGTH_SHORT).show();
                    break;
               /* case ActivityOutput.RESULT_PIN1:
                    int result1=data.getIntExtra(ActivityOutput.RESULT,0);
                    Toast.makeText(this, result1+"jjjj", Toast.LENGTH_SHORT).show();
                    break;*/
                default:break;
            }


        }

    }
}
