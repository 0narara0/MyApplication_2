package com.narara.myapplication_2.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narara.myapplication_2.R;
import com.narara.myapplication_2.models.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather(R.drawable.weather_01, "수원", "18도"));
        weatherList.add(new Weather(R.drawable.weather_02, "서울", "20도"));
        weatherList.add(new Weather(R.drawable.weather_03, "안양", "19도"));
        weatherList.add(new Weather(R.drawable.weather_04, "광주", "21도"));
        weatherList.add(new Weather(R.drawable.weather_05, "부산", "25도"));
        weatherList.add(new Weather(R.drawable.weather_06, "대구", "30도"));
        weatherList.add(new Weather(R.drawable.weather_07, "제주", "26도"));
        weatherList.add(new Weather(R.drawable.weather_08, "평양", "12도"));
        weatherList.add(new Weather(R.drawable.weather_09, "파리", "15도"));
        weatherList.add(new Weather(R.drawable.weather_10, "도쿄", "22도"));

        // 어댑터
        WeatherRecyclerAdapter adapter = new WeatherRecyclerAdapter();
        adapter.addItems(weatherList);

        //
        RecyclerView recyclerView = findViewById(R.id.weatherList);
        recyclerView.setAdapter(adapter);
    }


    private static class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.WeatherViewHolder> {

        // 다른 클래스에 있는 데이터를 받기 위해 ArrayList를 만들어 주소값을 받아오고 변수를 만듦.
        private List<Weather> mItems = new ArrayList<>();


        @NonNull
        @Override //뷰홀더가 생성된 후 뷰홀더 레이아웃을 완성하는 코드 작성
        public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_weather, viewGroup, false); //복붙
            // LayoutInflater을 사용하기 위해  context가 필요해서 ViewGroup 이용해서 context를 쓴다.
            return new WeatherViewHolder(view);
        }

        @Override //인덱스, 실제로 데이터 뿌려주는 곳
        public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
                                                              //위에 있던 뷰홀더가 여기로 들어온다

            Weather weather = mItems.get(i);
            weatherViewHolder.weatherImageView.setImageResource(weather.getImageRes());
            weatherViewHolder.cityTextView.setText(weather.getCity());
            weatherViewHolder.tempTextView.setText(weather.getTemp());


        }

        @Override
        public int getItemCount() { //뿌려질 아이템의 갯수
            return mItems.size();
        }

        // 다른 클래스에서 받은 데이터(ArrayList)-주소값를 변수에 넣기 위해 함수를 만든 것
        public void addItems(List<Weather> items) {
            mItems.addAll(items);
        }

        public static class WeatherViewHolder extends RecyclerView.ViewHolder {
            public ImageView weatherImageView;
            public TextView cityTextView;
            public TextView tempTextView;

            public WeatherViewHolder(View view) {
                super(view);

                weatherImageView = view.findViewById(R.id.weatherImageView);
                cityTextView = view.findViewById(R.id.cityTextView);
                tempTextView = view.findViewById(R.id.tempTextView);
            }

        }
    }
}
