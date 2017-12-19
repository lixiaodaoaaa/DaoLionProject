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

package com.daolion.activity.demo.assetfilenotfound;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.daolion.activity.BaseActivity;
import com.daolion.common.Schema;
import com.daolion.compro.R;

import java.io.InputStream;

public class SecondActivity extends BaseActivity{
    
    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_second);
        openAssert();
    }
    
    
    public void sendBoradCastReceiver( View view ){
        Intent intent = new Intent( );
        intent.setAction(Schema.ACTION_CHANG_TEXT);
        sendBroadcast(intent);
    }
    
    
    private void openAssert( ){
        try {
            //检查文件是否存在
            InputStream open = this.getAssets( ).open("package.zip");
            if (null == open) {
                Log.i(TAG, " file is null open failed");
            }
        } catch (Exception e) {
            e.printStackTrace( );
            new Handler( ).postDelayed(( ) -> {
                Intent intent = new Intent(getApplicationContext( ), MainActivity_.class);
                startActivity(intent);
                finish( );
            }, 2000);
            Log.i(TAG, " file is null open failed");
        }
    }
    
}
