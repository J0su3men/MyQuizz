package com.men.josu.myquizz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private int id_respuestas[] = { R.id.radioButton1, R.id.radioButton2,
                                    R.id.radioButton3, R.id.radioButton4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_question));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        TextView text_question = (TextView) findViewById(R.id.txtquestion);
        text_question.setText(R.string.first_question);

        String[] answers = getResources().getStringArray(R.array.answers);

        for (int i = 0; i <id_respuestas.length; i++) {
            RadioButton rb = (RadioButton) findViewById(id_respuestas[i]);
            rb.setText(answers[i]);
        }

        final int correct_answer = getResources().getInteger(R.integer.correct_answer);
        final RadioGroup radio_grups = (RadioGroup) findViewById(R.id.group_answers);

        Button btn_check = (Button) findViewById(R.id.btnchecks);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = radio_grups.getCheckedRadioButtonId();
                int index_group = -1;
                for (int i = 0; i< id_respuestas.length; i++){
                    if (id_respuestas[i] == id){
                        index_group =i;
                    }
                }
                if (index_group == correct_answer){
                    Toast.makeText(QuestionActivity.this, "Respuesta, Corraceta ", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(QuestionActivity.this, "Respuesta, Incorraceta ", Toast.LENGTH_LONG).show();
                }

            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
