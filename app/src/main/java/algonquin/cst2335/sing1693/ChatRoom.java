package algonquin.cst2335.sing1693;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import algonquin.cst2335.sing1693.databinding.ActivityChatRoomBinding;
import algonquin.cst2335.sing1693.databinding.SentMessageBinding;

public class ChatRoom extends AppCompatActivity {

    ArrayList<String> messages = new ArrayList<>();
    ActivityChatRoomBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatRoomBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button.setOnClickListener(cli ->{
            messages.add("New message" + messages.size());

        });

        binding.myRecycler.setAdapter(new RecyclerView.Adapter<MyRowHolder>() {
            @NonNull
            @Override
            public MyRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                SentMessageBinding binding = SentMessageBinding.inflate(getLayoutInflater());
                return new MyRowHolder(binding.getRoot());
            }

            @Override
            public void onBindViewHolder(@NonNull MyRowHolder holder, int position) {

                String obj = messages.get(position);
                holder.messageText.setText("");
                holder.timeText.setText("");
            }

            @Override
            public int getItemCount() {
                return messages.size();
            }
        });
    }
    class MyRowHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        TextView timeText;
        public MyRowHolder(@NonNull View theRootConstraintLayout) {
            super(theRootConstraintLayout);
            messageText = itemView.findViewById(R.id.textView);
            timeText = itemView.findViewById(R.id.textView2);
        }
    }
}