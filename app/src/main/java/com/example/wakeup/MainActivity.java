package com.example.wakeup;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button vibrationBtn;
    Button systemBeepBtn;
    Button customBeepBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrationBtn = (Button)findViewById(R.id.btn_vbiration);
        systemBeepBtn = (Button)findViewById(R.id.btn_system_beep);
        customBeepBtn = (Button)findViewById(R.id.btn_custom_sound);

        vibrationBtn.setOnClickListener(this);
        systemBeepBtn.setOnClickListener(this);
        customBeepBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == vibrationBtn) {
            Vibrator vib = (Vibrator)getSystemService(VIBRATOR_SERVICE);
            // 배열의 홀수번째 값이 대기시간, 짝수 번째 값이 진동시간, 두번째 매개변수는 몇 번 반복할 것인가 설정 0으로 주면
            // 코드에서 취소(cancel)할 때까지 무한 반복, -1로 주면 한번만 패턴대로 진동
            vib.vibrate(new long[] {500,1000,500,1000},-1);
        } else if(v == systemBeepBtn) {
            // 스마트폰에 등록된 효과음의 식별자를 Uri 타입으로 획득한다.
            Uri uri = RingtoneManager.getActualDefaultRingtoneUri(getApplicationContext(), RingtoneManager.TYPE_NOTIFICATION);
            Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), uri);
            ringtone.play();
        }
    }
}
