/*
 * Copyright 2016 GcsSloop
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Last modified 2016-10-02 00:22:33
 *
 */

package com.daolion.activity.demo.timerdown;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.daolion.activity.BaseActivity;
import com.daolion.compro.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends BaseActivity{
    
    private CountDownTimer countDownTimer;
    
    
    @ViewById
    TextView tvFirst;
    
    
    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        
        countDownTimer = new CountDownTimer(21 * 1000, 1000){
            @Override
            public void onTick( long millisUntilFinished ){
                String strCurrentLeft = millisUntilFinished / 1000 + "";
                tvFirst.setText(strCurrentLeft);
            }
            
            @Override
            public void onFinish( ){
            
            }
            
            
            public void onStart( ){
            
            }
            
        };
    }
    
    @Override
    protected void onResume( ){
        super.onResume( );
        countDownTimer.start( );
    }
    
    public void skipToSecondActivity( View view ){
        countDownTimer.cancel( );
        countDownTimer.start( );
    }
    
}
