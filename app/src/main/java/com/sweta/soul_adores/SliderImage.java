package com.sweta.soul_adores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class SliderImage extends AppCompatActivity {
    ImageSlider slider;
    ArrayList<SlideModel> list =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_image);
        slider=findViewById(R.id.image_slider);
        list.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.FIT));
        list.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.", ScaleTypes.FIT));
        list.add(new SlideModel(R.drawable.launcher, "Splash Design", ScaleTypes.FIT));
        list.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.", ScaleTypes.FIT));
        slider.setImageList(list,ScaleTypes.FIT);
    }
}