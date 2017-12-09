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

package com.daolion.activity.demo.sendanotation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.daolion.activity.BaseActivity;
import com.daolion.common.Schema;
import com.daolion.compro.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Receiver;
import org.androidannotations.annotations.ViewById;

@EActivity
public class MainActivity extends BaseActivity{
    
    @ViewById
    TextView tvFirst;
    
    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    
    @Receiver(actions = Schema.ACTION_CHANG_TEXT)
    public void onReiverChangeTextAction( ){
        tvFirst.setText("哈哈哈 我收到了");
    }
    
    public void skipToSecondActivity( View view ){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
    
}
