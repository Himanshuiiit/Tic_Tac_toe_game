package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameActive = true;
    //Active player on the positions
    //0-0
    //1-X
    //2-null

    int player = 1;
    //initially all the positions are empty(null)
    int position[] = {2,2,2,2,2,2,2,2,2};
    //all possible winning positions are as follows
    int[][] winPos = {{0,1,2},{3,4,5},{6,7,8},
                                {0,3,6},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};
    public void Input (View view){
        ImageView img = (ImageView) view;

        int tappedImg = Integer.parseInt(img.getTag().toString());
        if(!gameActive){

            reset(view);
        }
        //if space is empty or not
        if(position[tappedImg]==2){
            position[tappedImg]= player;
            //To switch between players
            if(player == 0){
                img.setImageResource(R.drawable.o);
                TextView status = findViewById(R.id.status);
                status.setText("X's Move");
                player = 1;
            }
            else{
                img.setImageResource(R.drawable.x);
                TextView status = findViewById(R.id.status);
                status.setText("O's Move");
                player = 0;
            }
        }
        boolean end = true;//to check the draw condition
        for(int i=0;i<position.length;i++){
            if(position[i]==2){
                end = false;
            }
        }
        //To check the result
        String winnerstr;
        for(int[] winner : winPos ){
            if (position[winner[0]]==position[winner[1]] && position[winner[1]]==position[winner[2]] && position[winner[0]]!=2) {//condition for winning
                //checking the winner
                if (position[winner[0]]==0) {
                    winnerstr = "O has won!! Click anywhere to restart";
                }
                else{
                    winnerstr = "X has won!! Click anywhere to restart";
                }
                gameActive = false;
                //winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }
            else if(end && (position[winner[0]]==position[winner[1]] || position[winner[1]]==position[winner[2]] )){
                //checking the winner
                if (position[winner[0]]==0) {
                    winnerstr = "O has won!! Click anywhere to restart";
                }
                else{
                    winnerstr = "X has won!! Click anywhere to restart";
                }
                gameActive = false;
                //winner announcement
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);
            }
            else if(end && (position[winner[0]]!=position[winner[1]] || position[winner[1]]!=position[winner[2]] )){
                TextView status = findViewById(R.id.status);
                status.setText("Game is Draw! click anywhere to restart");
                gameActive = false;
            }
        }
    }
    public void reset(View view){
        gameActive = true;
        player = 1;
        for(int i=0;i<position.length;i++){
            position[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Move");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}