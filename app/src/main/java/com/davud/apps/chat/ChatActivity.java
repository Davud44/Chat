package com.davud.apps.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.davud.apps.chat.adapters.ChatAdapter;
import com.davud.apps.chat.models.ChatModel;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ImageView back;
    private RecyclerView recyclerView;
    private ArrayList<ChatModel> models;
    private ChatAdapter adapter;
    Context context = this;
    private TextView isOnlineTxt;
    private  TextView nameTxt;
    private boolean isGroup;
    private boolean isOnline;
    private String name;
    private ImageView send;
    private EditText message;
    private  LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        init();

        if(isGroup)
        {
            initRecyclerViewGroup();
        }
        else{
            initRecyclerView();
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WriteMessage();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private  void init()
    {
        back = findViewById(R.id.imageView);
        recyclerView = findViewById(R.id.recyclerview);
        models = new ArrayList<>();
        adapter = new ChatAdapter( models , context);
        isOnlineTxt = findViewById(R.id.is_online);
        nameTxt = findViewById(R.id.textView);
        name = getIntent().getStringExtra("name");
        isOnline = getIntent().getBooleanExtra("isOnline" , false);
        isGroup = getIntent().getBooleanExtra("isGroup" , false);
        send = findViewById(R.id.send);
        message = findViewById(R.id.message);

        layoutManager = new LinearLayoutManager(context , RecyclerView.VERTICAL , false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        nameTxt.setText(name);

        if(isOnline)
        {
            isOnlineTxt.setVisibility(View.VISIBLE);
        }
        else{
            isOnlineTxt.setVisibility(View.GONE);
        }


    }

    private  void initRecyclerView()
    {


        models.add(new ChatModel(1 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "salam" , true , false , true));
        models.add(new ChatModel(2 , "https://iasbh.tmgrup.com.tr/7e46bb/366/218/22/0/731/421?u=https://isbh.tmgrup.com.tr/sbh/2018/01/17/tom-cruise-kimdir-1516177329595.jpg" , "salam" , true , false , false));
        models.add(new ChatModel(3 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "https://i.pinimg.com/736x/6f/a3/8a/6fa38a17702d825b6379df5913cc6c34.jpg" , true , true , true));
        models.add(new ChatModel(4 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "necedi?" , true , false , true));
        models.add(new ChatModel(5 , "https://iasbh.tmgrup.com.tr/7e46bb/366/218/22/0/731/421?u=https://isbh.tmgrup.com.tr/sbh/2018/01/17/tom-cruise-kimdir-1516177329595.jpg" , "eladi" , true , false , false));
        models.add(new ChatModel(6 , "https://iasbh.tmgrup.com.tr/7e46bb/366/218/22/0/731/421?u=https://isbh.tmgrup.com.tr/sbh/2018/01/17/tom-cruise-kimdir-1516177329595.jpg" , "https://i0.shbdn.com/photos/92/75/65/x5_8689275650e0.jpg" , true , true , false));
        models.add(new ChatModel(7 , "https://iasbh.tmgrup.com.tr/7e46bb/366/218/22/0/731/421?u=https://isbh.tmgrup.com.tr/sbh/2018/01/17/tom-cruise-kimdir-1516177329595.jpg" , "ama bu daha yaxsidi" , true , false , false));

        adapter.notifyDataSetChanged();


        final int lastItemPosition = models.size() - 1;
        layoutManager.scrollToPosition(lastItemPosition);

    }

    private  void initRecyclerViewGroup()
    {

        models.add(new ChatModel(1 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "salam" , true , false , true));
        models.add(new ChatModel(2 , "https://i.pinimg.com/originals/56/13/01/561301828393528bfc9f575e976642f0.jpg" , "salam" , true , false , false));
        models.add(new ChatModel(3 , "https://api.wannart.com/storage/post/2019/12/tomhardy_900x600.jpg" , "salam" , true , false , false));
        models.add(new ChatModel(4 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "necesiz?" , true , false , true));
        models.add(new ChatModel(5 , "https://i.pinimg.com/originals/56/13/01/561301828393528bfc9f575e976642f0.jpg" , "yaxsi sen?" , true , false , false));
        models.add(new ChatModel(6 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "yaxsiyam" , true , false , true));
        models.add(new ChatModel(7 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , "https://i.pinimg.com/736x/6f/a3/8a/6fa38a17702d825b6379df5913cc6c34.jpg" , true , true , true));

        adapter.notifyDataSetChanged();


        final int lastItemPosition = models.size() - 1;
        layoutManager.scrollToPosition(lastItemPosition);

    }

    private  void  WriteMessage()
    {
        String text = message.getText().toString().trim();

        models.add(new ChatModel(0 , "https://i.pinimg.com/originals/56/b1/46/56b146ec1c6454b7db2bcbd273d025f8.jpg" , text , true , false ,true ));

        message.setText("");
        adapter.notifyDataSetChanged();

        final int lastItemPosition = models.size() - 1;
        layoutManager.scrollToPosition(lastItemPosition);

    }

}