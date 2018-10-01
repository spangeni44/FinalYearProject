package com.ccss.nast.qrce.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ccss.nast.qrce.Database.DbHelper;
import com.ccss.nast.qrce.R;
import java.util.Collections;
import java.util.List;


public class QuestionsActivity extends AppCompatActivity {

    List<Question> questionList;
    int score = 0;
    int quid = 0;
    Question currentQuestion;

    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    String subjectType=getIntent().getStringExtra("SubjectType");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        DbHelper dbHelper = new DbHelper(this);
        questionList = dbHelper.getAllQuestions();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);

        txtQuestion = findViewById(R.id.tv_question);
        rda = findViewById(R.id.radio0);
        rdb = findViewById(R.id.radio1);
        rdc = findViewById(R.id.radio2);
        butNext = findViewById(R.id.button1);

        setQuestionView();

    }

    private void setQuestionView() {
        txtQuestion.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        quid++;
    }

    public void btClick(View view) {
        RadioGroup grp = findViewById(R.id.radioGroup1);
        final RadioButton answerId = findViewById(grp.getCheckedRadioButtonId());

        if (!answerId.getText().toString().equalsIgnoreCase(currentQuestion.getAnswer())) {
            answerId.setBackgroundColor(getResources().getColor(R.color.red));
            Toast.makeText(QuestionsActivity.this, "You Are Wrong" + "The Correct Answer is:" + currentQuestion.getAnswer(), Toast.LENGTH_SHORT).show();
            if (rda.getText().equals(currentQuestion.getAnswer())) {
                rda.setBackgroundColor(getResources().getColor(R.color.green));
                rdc.setBackgroundColor(getResources().getColor(R.color.red));
                rdb.setBackgroundColor(getResources().getColor(R.color.red));
            } else if (rdb.getText().equals(currentQuestion.getAnswer())) {
                rdb.setBackgroundColor(getResources().getColor(R.color.green));
                rda.setBackgroundColor(getResources().getColor(R.color.red));
                rdc.setBackgroundColor(getResources().getColor(R.color.red));
            } else if (rdc.getText().equals(currentQuestion.getAnswer())) {
                rdc.setBackgroundColor(getResources().getColor(R.color.red));
                rda.setBackgroundColor(getResources().getColor(R.color.red));
                rdb.setBackgroundColor(getResources().getColor(R.color.red));
            }
        } else {
            rda.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            rdb.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            rdc.setBackgroundColor(getResources().getColor(R.color.colorWhite));
            TextView message = findViewById(R.id.tv_Message);
            answerId.setBackgroundColor(getResources().getColor(R.color.green));
            message.setText("You Are Correct");
            score++;
            Log.d("Score", "Your score: " + score);
        }
/*
        if (quid < 10) {
            currentQuestion = questionList.get(quid);
            setQuestionView();
        } else {
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score);
            intent.putExtras(b);
            startActivity(intent);
            finish();
        }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
