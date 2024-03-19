package com.coderfaysal.kurbani;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);


        hashMap = new HashMap<>();
        hashMap.put("title", "কুরবানি কী ও কেন?");
        hashMap.put("message", "আরবি করব বা কুরবান (قرب বা قربان) শব্দটি উর্দূ ও ফার্সীতে (قربانى) কুরবানি নামে রূপান্তরিত। এর অর্থ হলো-নৈকট্য বা সান্নিধ্য। কুরআনুল কারিমের কুরবানির একাধিক সমার্থক শব্দের ব্যবহার দেখা যায়। ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "কুরবানীর গুরুত্ব");
        hashMap.put("message", "কুরবানী হলো ইসলামের একটি শি’য়ার বা মহান নিদর্শন। কুরআন মাজীদে আল্লাহ তা‘আলা নির্দেশ দিয়েছেন: \n" +
                "‘তোমার প্রতিপালকের উদ্দেশ্যে সালাত আদায় কর ও পশু কুরবানী কর।’ [সূরা আল-কাউসার : ২] \n" +
                "আবু হুরায়রা রাদিয়াল্লাহু ‘আনহু থেকে বর্ণিত, রাসূলুল্লাহ সাল্লাল্লাহু আলাইহি ওয়াসাল্লাম বলেছেন : \n" +
                "‘যে ব্যক্তি সামর্থ্য থাকা সত্ত্বেও কুরবানি করে না সে যেন আমাদের ঈদগাহের ধারে না আসে। [মুসনাদ আহমাদ, ইবন মাজাহ- ৩১২৩ হাদীসটি হাসান]");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "আকিকা-");
        hashMap.put("message", "আকিকা করা সুন্নত। আকিকা শিশুর অধিকার। নবজাতক শিশুর জন্য আকিকা এতই গুরুত্বপূর্ণ যে, এর ফজিলত বর্ণনা করে শেষ করা যাবে না। আকিকার ফজিলতের বরকতে নবজাতক শিশুর বালা-মুসিবত দূর হয়ে যায়। নবজাতক শিশু সন্তানের শুকরিয়া আদায়ের নিদর্শন হিসেবে বাবা-মাকে সন্তানের জন্য আকিকা করতে হয়। এ ক্ষেত্রে সন্তান ছেলে বা মেয়ে যা হোক না কেন, উভয়ের জন্য আকিকা করতে হবে।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("title", "আকিকার সময়-");
        hashMap.put("message", "নবজাতক ভূমিষ্ঠ হওয়ার সপ্তম দিনে আকিকা করা উত্তম। হজরত রাসূল সা: নিজে সপ্তম দিনে আকিকা করেছেন। যদি কোনো কারণে সপ্তম দিনে আকিকা করা সম্ভব না হয়, তাহলে চতুর্দশতম দিনে আকিকা করতে হয়। তাও সম্ভব না হলে, একবিংশতম দিনে আকিকা করতে হয়। তাও সম্ভব না হলে, অন্য যেকোনো দিনে আদায় করে নিতে হবে। হজরত সামুরা ইবনে জুনদুব রা: থেকে বর্ণিত হয়েছে, হজরত রাসূল সা: ইরশাদ করেছেন, ‘প্রত্যেক শিশু তার আকিকার বিনিময়ে বন্ধকস্বরূপ। কাজেই সপ্তম দিনে তার পক্ষ থেকে জবাই করবে এবং তারা মাথা মুণ্ডন করে নাম রাখবে’ (সুনানে আবু দাউদ : ২/৩৯২)। ");
        arrayList.add(hashMap);


        XAdapter xAdapter = new XAdapter();
        recyclerView.setAdapter(xAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }


    private class XAdapter extends RecyclerView.Adapter<XAdapter.XViewHolder>{


        @NonNull
        @Override
        public XViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = getLayoutInflater();
            View view = inflater.inflate(R.layout.items, parent, false );
            return new XViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull XViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String message = hashMap.get("message");

            holder.textView.setText(title);

            holder.cardView.setOnClickListener(view -> {
                Details.TITLE = title;
                Details.MESSAGE = message;
                startActivity(new Intent(MainActivity.this, Details.class));
            });


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class XViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            CardView cardView;

            public XViewHolder(@NonNull View itemView) {
                super(itemView);

                textView = itemView.findViewById(R.id.textView);
                cardView = itemView.findViewById(R.id.cardView);
            }
        }

    }






}