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

package com.daolion.activity.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ailianlian.base.utils.DeleteLogUtils;
import com.daolion.activity.BaseActivity;
import com.daolion.compro.R;
import com.daolion.uitls.HashCheckUtils;

import java.io.File;

public class DeleteLogActivity extends BaseActivity{
    
    final String logDirectoryPath = File.separator + "sdcard" + File.separator + "VMC";
    
    
    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getHashValue( );
        deleteDeleteLogTest( );
    }
    
    private void deleteDeleteLogTest( ){
        final String logDirectoryPath = File.separator + "sdcard" + File.separator + "VMC";
        DeleteLogUtils.deleteLogFilesByBeforeSomeDays(logDirectoryPath, 7);
    }
    
    private void getHashValue( ){
        String strHash = HashCheckUtils.getHash1Value(this);
        Log.i(this.TAG, strHash);
    }
    
    public void skipToSecondActivity( View view ){
    
    }
    
    
}
