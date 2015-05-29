/*
 * Copyright 2015-2016 TakWolf
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.takwolf.android.lock9view;

import android.app.AlertDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.takwolf.android.lock9.Lock9View;

public class MainActivity extends AppCompatActivity {

    private Lock9View lock9View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lock9View = (Lock9View) findViewById(R.id.lock_9_view);
        lock9View.setCallBack(new Lock9View.CallBack() {

            @Override
            public void onFinish(String password) {
                Toast.makeText(MainActivity.this, password, Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:
                new AlertDialog.Builder(this)
                        .setTitle("Android-Lock9View")
                        .setMessage(
                                "Github : https://github.com/TakWolf/Android-Lock9View\n\n" +
                                "Author : TakWolf\n\n" +
                                "Email : takwolf@foxmail.com\n\n" +
                                "HP : http://takwolf.com")
                        .setPositiveButton("OK", null)
                        .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
