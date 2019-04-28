package com.lixinxinlove.hencoderpluspro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lixinxinlove.hencoderpluspro.view.AvatarView2;

public class MainActivity extends AppCompatActivity {


    AvatarView2 avatarView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avatarView2=findViewById(R.id.avatar_view2);

        //avatarView2.setLayerType(LAYER_TYPE_SOFTWARE, null);
    }
}
