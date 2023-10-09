package pl.edu.pb.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionTextView;

    private TextView wynikTextView;
    private int currentIndex = 0;
    private int wynik = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        trueButton = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
        nextButton = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);
        questionTextView.setText(questions[currentIndex].getQuestionId());
        trueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkAnswerCorrectness(true);
                setNextQuestion();
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                checkAnswerCorrectness(false);
                setNextQuestion();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                setNextQuestion();
            }
        });
    }

    private void setNextQuestion(){

        if(currentIndex == questions.length-1){
            setContentView(R.layout.activity_koniec);
            wynikTextView = findViewById(R.id.wynik_text_view);
            wynikTextView.setText( Integer.toString(wynik));
        }else{
            currentIndex++;
            questionTextView.setText(questions[currentIndex].getQuestionId());
        }
    }
    private Question[] questions = new Question[] {
            new Question(R.string.q_activity, true),
            new Question(R.string.q_find_resources, true),
            new Question(R.string.q_listener, false),
            new Question(R.string.q_resources, false),
            new Question(R.string.q_version, true)
    };
    private  void checkAnswerCorrectness(boolean userAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;
        if(userAnswer == correctAnswer)
        {
            resultMessageId = R.string.correct_answer;
            wynik++;
        }
        else
        {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }
}


















