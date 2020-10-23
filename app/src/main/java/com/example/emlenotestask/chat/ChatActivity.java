package com.example.emlenotestask.chat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.emlenotestask.R;
import com.example.emlenotestask.adapter.chat;
import com.example.emlenotestask.model.Chat;
import com.example.emlenotestask.model.Messages;
import com.example.emlenotestask.network.InternetConnection;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChatActivity extends AppCompatActivity implements ChatContract.viewInterface {


    @BindView(R.id.chat_backBtn)
    ImageButton chatBackBtn;
    @BindView(R.id.chat_friend_image)
    CircleImageView chatFriendImage;
    @BindView(R.id.chat_friend_name)
    TextView chatFriendName;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btn_send)
    ImageButton btnSend;
    @BindView(R.id.text_msg)
    EditText textMsg;

    private ChatContract.presenterInterface presenterInterface;
    private chat chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        presenterInterface = new ChatPresenter(this);

        if (InternetConnection.checkInternetConnection(this)) {
            presenterInterface.getChatMessages();
        } else {
            displayError("Please check your internet connection");
        }

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = textMsg.getText().toString();
                if (msg.equals("")) {
                    displayError("You can't send empty message");
                } else {
                    chatAdapter.insertItem(new Messages(msg, 0));
                    chatAdapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(chatAdapter.getItemCount() - 1);
                    textMsg.setText("");
                }
            }

        });

        chatBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void showMessages(Chat body) {
        chatFriendName.setText(body.getName());
        Picasso.get().load(body.getPic()).into(chatFriendImage);
        chatAdapter = new chat(body.getMessages());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
        recyclerView.scrollToPosition(chatAdapter.getItemCount() - 1);
    }

    @Override
    public void displayError(String msg) {
        Toast.makeText(ChatActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


}