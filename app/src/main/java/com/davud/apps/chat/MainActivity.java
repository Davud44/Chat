package com.davud.apps.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.davud.apps.chat.adapters.AllChatAdapter;
import com.davud.apps.chat.adapters.FriendsAdapter;
import com.davud.apps.chat.models.AllChatModel;
import com.davud.apps.chat.models.FriendsModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView close;
    private EditText editText;
    private RecyclerView recyclerViewFriends;
    private ArrayList<FriendsModel> friendsModels;
    private FriendsAdapter friendsAdapter;
    private Context context  = this;

    private RecyclerView recyclerViewChats;
    private ArrayList<AllChatModel> chatModels;
    private AllChatAdapter allChatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        initRecyclerViewFriends();
        initRecyclerViewChats();

        close.setOnClickListener(view -> editText.setText(""));
    }

    private void init()
    {
        close = findViewById(R.id.close);
        editText = findViewById(R.id.editText);
        recyclerViewFriends = findViewById(R.id.recyclerview_friends);
        friendsModels = new ArrayList<>();
        friendsAdapter = new FriendsAdapter(friendsModels , context);
        recyclerViewChats = findViewById(R.id.recyclerview_chat);
        chatModels = new ArrayList<>();
        allChatAdapter = new AllChatAdapter(chatModels , context);

    }

    private  void initRecyclerViewFriends()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context  ,RecyclerView.HORIZONTAL , false);
        recyclerViewFriends.setLayoutManager(layoutManager);
        recyclerViewFriends.setAdapter(friendsAdapter);
        friendsModels.add(new FriendsModel(1 , "https://api.wannart.com/storage/post/2019/12/tomhardy_900x600.jpg" , "Tom Hardy"));
        friendsModels.add(new FriendsModel(2 , "https://i.pinimg.com/originals/56/13/01/561301828393528bfc9f575e976642f0.jpg" , "Barbara Palvin"));
        friendsModels.add(new FriendsModel(3 , "https://icdn.ensonhaber.com/resimler/galeri/leonardo-dicaprio-at-the-beverly-wilshire-hotel-in-beverly-news-photo-98152663-1540332414.jpg" , "Leonardo Dicaprio"));
        friendsModels.add(new FriendsModel(4 , "https://iasbh.tmgrup.com.tr/7e46bb/366/218/22/0/731/421?u=https://isbh.tmgrup.com.tr/sbh/2018/01/17/tom-cruise-kimdir-1516177329595.jpg" , "Tom Cruise"));
        friendsModels.add(new FriendsModel(5 , "https://i2.cnnturk.com/i/cnnturk/75/400x512/5d5b9f8217aca9108c116c59.jpg" , "Margot Robbie"));
        friendsAdapter.notifyDataSetChanged();
    }

    private void initRecyclerViewChats()
    {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context  ,RecyclerView.VERTICAL , false);
        recyclerViewChats.setLayoutManager(layoutManager);
        recyclerViewChats.setAdapter(allChatAdapter);
        chatModels.add(new AllChatModel(4 , "Tom Cruise" , "https://iasbh.tmgrup.com.tr/7e46bb/366/218/22/0/731/421?u=https://isbh.tmgrup.com.tr/sbh/2018/01/17/tom-cruise-kimdir-1516177329595.jpg" , true , "hello","11:22 AM", false ));
        chatModels.add(new AllChatModel(5 , "Margot Robbie" , "https://i2.cnnturk.com/i/cnnturk/75/400x512/5d5b9f8217aca9108c116c59.jpg" , false , "Hi dear","11:00 AM", false ));
        ArrayList<String> images = new ArrayList<>();
        images.add("https://api.wannart.com/storage/post/2019/12/tomhardy_900x600.jpg");
        images.add("https://i.pinimg.com/originals/56/13/01/561301828393528bfc9f575e976642f0.jpg");
        chatModels.add(new AllChatModel(1 , "Instamobile team" , images , "wow", "10:45 AM",true ));
        allChatAdapter.notifyDataSetChanged();
    }


}