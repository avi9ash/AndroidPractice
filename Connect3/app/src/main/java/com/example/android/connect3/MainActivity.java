package com.example.android.connect3;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;//0=cross,1=knot
    boolean act=true;
    int state[]={2,2,2,2,2,2,2,2,2};
    int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;
        System.out.println(counter.getTag().toString());
        int tappedCount= Integer.parseInt(counter.getTag().toString());
        if(state[tappedCount]==2&&act)
        {
            state[tappedCount]=activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.ximg);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.oimg);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1000f)
                    .rotation(360)
                    .setDuration(1000);
            for (int w[]:winningPositions)
            {
                if(state[w[0]]==state[w[1]]&&state[w[1]]==state[w[2]]&&state[w[0]]!=2)
                {
                    String winner="KNOTS";
                    if(state[w[0]]==0)
                    {
                        winner="CROSSES";
                    }
                    LinearLayout lay=(LinearLayout) findViewById(R.id.playAgainLayout);
                    lay.setVisibility(View.VISIBLE);
                    TextView winnermsg=(TextView)(findViewById(R.id.winnermsg));
                    winnermsg.setText(winner + " have won!!");
                    act=false;
                    System.out.println(winner);
                }
            }
        }
    }
    public void playAgain(View view)
    {

        LinearLayout lay=(LinearLayout) findViewById(R.id.playAgainLayout);
        lay.setVisibility(View.INVISIBLE);
        activePlayer=0;//0=cross,1=knot
        for(int i=0;i<state.length;i++)
        {
            state[i] = 2;
        }
        GridLayout gridd= (GridLayout)findViewById(R.id.gl);
        for(int i=0;i<gridd.getChildCount();i++) {
            ((ImageView) gridd.getChildAt(i)).setImageResource(0);
        }
        act=true;
    }
}
