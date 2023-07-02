package com.example.randomquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();
    List<String> Questions = new ArrayList<String>();
    int NumberOfQuestions = 0;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Questions.add("What's your sign?");
        Questions.add("What is your favorite color?");
        Questions.add("What's your favorite food?");
        Questions.add("Describe your childhood trauma");
        Questions.add("What do you wish for our relationship?");
        Questions.add("Have you ever cheated on a past partner?");
        Questions.add("What are ten things you would bring to a desert island?");
        Questions.add("What is your favorite movie?");
        Questions.add("What do you admire most about me?");
        Questions.add("What do I do that irritates you the most?");
        Questions.add("What do I do that turns you on the most?");
        Questions.add("Chocolate or Flowers");
        Questions.add("What are your love languages?");
        Questions.add("Neflix and Chill or Night out?");
        Questions.add("What's a new hobby you'd like to try?");
        Questions.add("If you could change on thing about your looks what would it be?");
        Questions.add("What's an embarassing fashion moment?");
        Questions.add("Would you rather give up music or TV for a month?");
        Questions.add("Tell me about your first crush");
        Questions.add("When did you parents talk to you about sex?");
        Questions.add("If you had one day left to live what would you do?");
        Questions.add("What's your deepest fear?");
        Questions.add("Do you go to therapy?");
        Questions.add("Do you go to church?");
        Questions.add("Would you consider ever going to couple's counseling?");
        Questions.add("What are you trying to work on to better yourself?");
        Questions.add("How do you feel about meditation?");
        Questions.add("Thoughts on gay marriage?");
        Questions.add("Thoughts on abortion?");
        Questions.add("Thoughts on Transgender?");
        Questions.add("Political Views in general?");
        Questions.add("What's your sign?");
        Questions.add("How many siblings do you have?");
        Questions.add("Tell me about your previous sexual partners");
        Questions.add("How do you feel about relationships with the opposite sex?");
        Questions.add("Have you ever had a bad hookup?");
        Questions.add("What's your favorite show and tell?");
        Questions.add("What's your favorite podcast?");
        Questions.add("Coffee or tea?");
        Questions.add("What's your favorite concert?");
        Questions.add("How often do you talk to your parents?");
        Questions.add("Can you describe one of your previous relationships?");
        Questions.add("What went wrong in your previous relationship?");
        Questions.add("What do you think you could have done better in your previous relationship?");
        Questions.add("What's your favorite silly game to play? Let's play it");
        Questions.add("Who's your celebrity crush?");
        Questions.add("What part of your body do you most like to be touched?");
        Questions.add("What's your relationship deal breaker?");
        Questions.add("What's your faith life like?");
        Questions.add("What do you do in the shower?");
        Questions.add("Favorite drink?");
        Questions.add("Favorite hobby?");
        Questions.add("Have you ever had a threesome?");
        Questions.add("Who was the first person you kissed?");
        Questions.add("What song can always make you dance? Play it");
        Questions.add("What would your super power be?");
        Questions.add("How would you spend a million dollars?");
        Questions.add("What's your favorite song? Play it");
        Questions.add("How do you manage your finances?");
        Questions.add("What's your dream vacation?");
        Questions.add("Do you have a type?");
        Questions.add("Favorite childhood memory?");
        Questions.add("Craziest dream?");
        Questions.add("Do you like massages? Where?");
        Questions.add("Cuddles or kisses?");
        Questions.add("Eating disorder?");
        Questions.add("Craziest place you've had sex?");
        Questions.add("What makes you feel better when you're sad or stressed?");
        Questions.add("5 and 10 year goals?");
        Questions.add("If you could live anywhere for a year where would it be?");
        Questions.add("Weirdest habit or quirk?");
        Questions.add("What's something you've always wanted to try?");
        Questions.add("What's one thing that could make our relationship better?");
        Questions.add("What did you want to be when you grew up?");
        Questions.add("Ask me anything");
        Questions.add("Tell a crazy thing you've done");
        Questions.add("Do you enjoy surprises or receiving gifts?");
        Questions.add("Favorite nickname?");
        Questions.add("If money didn't matter what would you do for a living?");
        Questions.add("Do you believe in an afterlife?");
        Questions.add("Have you ever met a celebrity?");
        Questions.add("If you could meet someone famous who would it be?");
        Questions.add("What's your favorite part of my body?");
        Questions.add("Favorite sex position?");
        Questions.add("Name 3 things on your bucket list");
        Questions.add("Hidden talents?");
        Questions.add("Worst date?");
        Questions.add("What's your relationship with your parents like?");
        Questions.add("Dumbest thing you've ever done?");
        Questions.add("Porn and/or masturbation?");
        Questions.add("What keeps you up at night?");
        Questions.add("How many kids do you want?");
        Questions.add("What were you like in high school?");
        Questions.add("Favorite date night activity?");
        Questions.add("Am I a safe person for you to talk to? How to make it better?");
        Questions.add("Do you believe in karma?");
        Questions.add("Tell me a mistake in a relationship that taught you a lesson?");
        Questions.add("How do you handle conflict?");
        Questions.add("What's your favorite thing about me?");
        Questions.add("What are your 3 favorite things in the whole wide world?");
        Questions.add("What is one thing you like to receive in a relationship.?");
        Questions.add("What's one way to create connection in a hectic environment like a party?");
        Questions.add("If I upset you what is something I can do to help you calm down?");
        Questions.add("What's your most enjoyable and hated household chore?");
        Questions.add("What's a guilty pleasure?");
        Questions.add("What's your favorite item of clothing?");
        Questions.add("If you had to stay home for a month what 2 things would you absolutely have to have?");
        Questions.add("What TV series have you repeatedly watched?");
        Questions.add("How have you grown or changed in the last 2 years?");
        Questions.add("What's your ideal holiday?");
        Questions.add("What was the funniest moment of your life so far?");
        Questions.add("What are you most proud of?");
        Questions.add("What book have you recommended the most?");
        Questions.add("What do you want your life legacy to be?");
        Questions.add("What's one small thing that always makes you smile?");
        Questions.add("If you could get rid of one habit and make a new habit what would it be?");
        Questions.add("What book, show or TV show had the biggest impact on your life?");
        Questions.add("What's your favorite flavor?");
        Questions.add("What does spending time in nature look like?");
        Questions.add("Do you prefer home cooked meals or a night out to order food? Or maybe carry out? Picnic?");
        Questions.add("If you see a butterfly what do you do?");
        Questions.add("What do you wear when you sleep?");
        Questions.add("What temperature do you sleep at?");
        Questions.add("Do you touch yourself at night?");
        Questions.add("Do you eat eggs?");
        Questions.add("When did your last relationship end and what did it teach you?");
        Questions.add("Have you ever been in a relationship where your partner had strong emotional needs? How did you handle it?");
        Questions.add("Do you feel comfortable explaining your emotions with someone you're newly dating?");
        Questions.add("What is your favorite season?");
        Questions.add("Tits or ass?");
        Questions.add("Do you ever write handwritten letters? If so to whom? If not who would you do it to?");
        Questions.add("What's your favorite museum? Which one is on your bucket list?");
        Questions.add("What's your favorite sport to play?");
        Questions.add("What's your favorite road trip? Where's your next road trip?");
        Questions.add("What's your most prized possession?");
        Questions.add("What's next on your wish list?");
        Questions.add("If you started a business what would you sell?");
        Questions.add("Whats the next movie you want to see?");
        Questions.add("What person from history would you like to meet?");
        Questions.add("What's your favorite board game?");
        Questions.add("What's your favorite city you've visited?");
        Questions.add("What fictional place do you want to visit?");
        Questions.add("What's your favorite junk food?");
        Questions.add("What junk food has no effect on you?");
        Questions.add("What would you do during a significant natural disaster (like a fire sail)?");
        Questions.add("Are you still friends with your ex? If not do you at least still talk?");
        Questions.add("What's your weapon of choice during a zombie apocalypse?");
        Questions.add("How important is money to you?");
        Questions.add("Savings or paying off credit card debt?");
        Questions.add("What were you like in high school? If we met in high school would we be friends?");
        Questions.add("What's something super popular that you're not into?");
        Questions.add("What's your biggest pet peeve?");
        Questions.add("What are you like when there's a ton of traffic?");
        Questions.add("What is our biggest inconvenience because other people ruined it?");
        Questions.add("Do you believe in horoscopes?");
        Questions.add("Do you believe in ghosts?");
        Questions.add("Do you believe in conspiracy theories?");
        Questions.add("If you could ask anyone a question and get a legitimate answer what and who would you ask?");
        Questions.add("What are your non-negotiables and deal breakers?");
        Questions.add("Do you have any favorite podcasts?");
        NumberOfQuestions = Questions.size();
        Collections.shuffle(Questions);
        setContentView(R.layout.activity_main);
    }

    /**Called Everytime a question changes**/
    public void SetQuestionCounter(View view) {
        TextView textViewNumbers = findViewById(R.id.textViewNUMBERS);
        String messageNumbers = "Question " + String.valueOf(index) + " out of " + String.valueOf(NumberOfQuestions);
        textViewNumbers.setText(messageNumbers);
    }

    /** Called when the user taps the Send button */
    public void GenerateQuestions(View view) {
        TextView textViewX = findViewById(R.id.textViewX);
        String message = Questions.get(index);
        index+=1;
        if (index > NumberOfQuestions-1) {
            index = 0;
        }
        textViewX.setText(message);
        SetQuestionCounter(view);
    }

    /** Called When user hits the reset button **/
    public void Reset(View view) {
        TextView textViewX = findViewById(R.id.textViewX);
        String message = "Resetting Questions!!!";
        textViewX.setText(message);
        //Reset counter to 0
        index = 0;
        SetQuestionCounter(view);
        Collections.shuffle(Questions);
    }
}
