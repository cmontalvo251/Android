package com.example.randomquestions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
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
		String message = "You need to hit the reset button first";
		if (NumberOfQuestions > 0) {
			message = Questions.get(index);
			index += 1;
			if (index > NumberOfQuestions - 1) {
				index = 0;
			}
		}
        textViewX.setText(message);
        SetQuestionCounter(view);
    }

    /** Called When user hits the reset button **/
    public void Reset(View view) {
		//Reset number of questions
		NumberOfQuestions = 0;
		Questions.clear();
		//Check status of switches
		Switch swFF = (Switch) findViewById(R.id.switchFF);
		boolean isCheckedFF = swFF.isChecked();
		if (isCheckedFF) {
			// The toggle is enabled
			//Add Family Friendly Questions
			///FAMILY FRIENDLY
			Questions.add("What's your sign?");
			Questions.add("What is your favorite color?");
			Questions.add("What's your favorite food?");
			Questions.add("What are ten things you would bring to a desert island?");
			Questions.add("What is your favorite movie?");
			Questions.add("Chocolate or Flowers");
			Questions.add("What's a new hobby you'd like to try?");
			Questions.add("If you could change one thing about your looks what would it be?");
			Questions.add("What's an embarrassing fashion moment?");
			Questions.add("Would you rather give up music or TV for a month?");
			Questions.add("If you had one day left to live what would you do?");
			Questions.add("What's your deepest fear?");
			Questions.add("What's your sign?");
			Questions.add("How many siblings do you have?");
			Questions.add("What's your favorite show and tell?");
			Questions.add("What's your favorite podcast?");
			Questions.add("Coffee or tea?");
			Questions.add("What's your favorite concert?");
			Questions.add("How often do you talk to your parents?");
			Questions.add("What's your favorite silly game to play? Let's play it");
			Questions.add("Favorite drink?");
			Questions.add("What's your humor like? Give me a favorite joke");
			Questions.add("Favorite hobby?");
			Questions.add("What song can always make you dance? Play it");
			Questions.add("What would your super power be?");
			Questions.add("How would you spend a million dollars?");
			Questions.add("What's your favorite song? Play it");
			Questions.add("What's your dream vacation?");
			Questions.add("Favorite childhood memory?");
			Questions.add("What are you trying to work on to better yourself?");
			Questions.add("Who's your celebrity crush?");
			Questions.add("Craziest dream?");
			Questions.add("What are your 5 and 10 year goals?");
			Questions.add("If you could live anywhere for a year where would it be?");
			Questions.add("Weirdest habit or quirk?");
			Questions.add("What's something you've always wanted to try?");
			Questions.add("What did you want to be when you grew up?");
			Questions.add("Ask me anything");
			Questions.add("Tell a crazy thing you've done");
			Questions.add("What's your favorite(or least) nickname?");
			Questions.add("If money didn't matter what would you do for a living?");
			Questions.add("Have you ever met a celebrity?");
			Questions.add("If you could meet someone famous who would it be?");
			Questions.add("Name 3 things on your bucket list");
			Questions.add("Do you have any hidden talents? Do it!!");
			Questions.add("What's the dumbest thing you've ever done?");
			Questions.add("What keeps you up at night?");
			Questions.add("What were you like in high school?");
			Questions.add("What are your 3 favorite things in the whole wide world?");
			Questions.add("What's your most enjoyable and hated household chore?");
			Questions.add("What's a guilty pleasure?");
			Questions.add("What's your favorite item of clothing?");
			Questions.add("If you had to stay home for a month what 2 things would you absolutely have to have?");
			Questions.add("What TV series have you repeatedly watched?");
			Questions.add("How have you grown or changed in the last 2 years?");
			Questions.add("What's your ideal holiday?");
			Questions.add("What was the funniest moment of your life?");
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
			Questions.add("Do you eat eggs?");
			Questions.add("What is your favorite season?");
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
			Questions.add("What's your weapon of choice during a zombie apocalypse?");
			Questions.add("What's something super popular that you're not into?");
			Questions.add("What's your biggest pet peeve?");
			Questions.add("What are you like when there's a ton of traffic?");
			Questions.add("What is our biggest inconvenience because other people ruined it?");
			Questions.add("If you could ask anyone a question and get a legitimate answer what and who would you ask?");
		}
		Switch swPR = (Switch) findViewById(R.id.switchPR);
		boolean isCheckedPR = swPR.isChecked();
		if (isCheckedPR) {
			// The toggle is enabled
			//Add Politics and Religion
			//POLITICS AND RELIGION
			Questions.add("Do you believe in ghosts?");
			Questions.add("Do you believe in horoscopes?");
			Questions.add("Do you believe in conspiracy theories?");
			Questions.add("Thoughts on gay marriage?");
			Questions.add("Thoughts on abortion?");
			Questions.add("Thoughts on Transgender?");
			Questions.add("Political Views in general?");
			Questions.add("What's your faith life like?");
			Questions.add("Do you go to church?");
			Questions.add("How do you feel about meditation?");
			Questions.add("Do you believe in an afterlife?");
			Questions.add("Trump?");
			Questions.add("Do you believe in karma?");
			Questions.add("Do you think religion is important for a relationship?");
		}
		Switch swCD = (Switch) findViewById(R.id.switchCD);
		boolean isCheckedCD = swCD.isChecked();
		if (isCheckedCD) {
			// The toggle is enabled
			//Add Casually Dating
			//DATING CASUALLY
			Questions.add("What do you wish for our relationship?");
			Questions.add("What do you admire most about me?");
			Questions.add("What are your love languages?");
			Questions.add("Tell me about your first crush");
			Questions.add("Who was the first person you kissed?");
			Questions.add("What's your relationship deal breaker?");
			Questions.add("How do you manage your finances?");
			Questions.add("Do you have a type?");
			Questions.add("Netflix and Chill or Night out?");
			Questions.add("Have you ever had an eating disorder or body image dysmorphia?");
			Questions.add("Do you enjoy surprises or receiving gifts?");
			Questions.add("What's the worst date you've been on?");
			Questions.add("Play never have I ever (just 5 fingers)");
			Questions.add("What's your relationship with your parents like?");
			Questions.add("How many kids do you want?");
			Questions.add("Favorite date night activity?");
			Questions.add("What is one thing you like to receive in a relationship.?");
			Questions.add("What's one way to create connection in a hectic environment like a party?");
			Questions.add("If I upset you what is something I can do to help you calm down?");
			Questions.add("Do you feel comfortable explaining your emotions with someone you're newly dating?");
			Questions.add("How important is money to you?");
			Questions.add("Savings or paying off credit card debt?");
			Questions.add("What were you like in high school? If we met in high school would we be friends?");
			Questions.add("What are your non negotiables and deal breakers?");
			Questions.add("Do you go to therapy?");
			Questions.add("Do you do drugs?");
			Questions.add("Have you ever been addicted to anything?");
		}
		Switch swSD = (Switch) findViewById(R.id.switchSD);
		boolean isCheckedSD = swSD.isChecked();
		if (isCheckedSD) {
			// The toggle is enabled
			// Add Seriously Dating
			//DATING SERIOUSLY
			Questions.add("Describe your childhood trauma");
			Questions.add("Have you ever cheated on a past partner?");
			Questions.add("What do I do that irritates you the most?");
			Questions.add("Would you consider ever going to couple's counseling?");
			Questions.add("How do you feel about relationships with the opposite sex?");
			Questions.add("Can you describe one of your previous relationships?");
			Questions.add("What went wrong in your previous relationship?");
			Questions.add("What do you think you could have done better in your previous relationship?");
			Questions.add("What makes you feel better when you're sad or stressed?");
			Questions.add("What's one thing that could make our relationship better?");
			Questions.add("Am I a safe person for you to talk to? How to make it better?");
			Questions.add("Tell me a mistake in a relationship that taught you a lesson?");
			Questions.add("How do you handle conflict?");
			Questions.add("What's your favorite thing about me?");
			Questions.add("When did your last relationship end and what did it teach you?");
			Questions.add("Have you ever been in a relationship where your partner had strong emotional needs? How did you handle it?");
			Questions.add("Are you still friends with your ex? If not do you at least still talk?");
			Questions.add("Are you open to marriage? Why or why not?");
			Questions.add("If we lived together, who would do what chores around the house?");
			Questions.add("If we had kids what would be everyone's responsibility? Like traditional gender roles or not?");
			Questions.add("What are the expectation for time with each other versus time with friends and family?");

		}
		Switch swXR = (Switch) findViewById(R.id.switchXR);
		boolean isCheckedXR = swXR.isChecked();
		if (isCheckedXR) {
			// The toggle is enabled
			// Add X-Rated
			//X-RATED
			Questions.add("Do you like massages? Where?");
			Questions.add("What does physical intimacy look like to you?");
			Questions.add("Cuddles or kisses?");
			Questions.add("What do I do that turns you on the most?");
			Questions.add("When did you parents talk to you about sex?");
			Questions.add("Tell me about your previous sexual partners");
			Questions.add("Have you ever had a bad hookup?");
			Questions.add("What part of your body do you most like to be touched?");
			Questions.add("What do you do in the shower?");
			Questions.add("Have you ever had a threesome?");
			Questions.add("Craziest place you've had sex?");
			Questions.add("Favorite sex position?");
			Questions.add("What's your favorite part of my body?");
			Questions.add("Porn and/or masturbation?");
			Questions.add("Do you touch yourself at night?");
			Questions.add("Tits or ass?");
			Questions.add("Does size matter?");
			Questions.add("What does sex mean to you?");
		}
		//////////////UPDATE NUMBER OF QUESTIONS//////////////
		index = 0;
		NumberOfQuestions = Questions.size();
		SetQuestionCounter(view);
		//////////////UPDATE TEXT///////////////////////////
		TextView textViewX = findViewById(R.id.textViewX);
		String message = "Default";
		if (NumberOfQuestions == 0) {
			message = "You need to switch one of the toggles below!!!";
		} else {
			message = "Resetting Questions!!!";
			Collections.shuffle(Questions);
		}
        textViewX.setText(message);
    }
}
