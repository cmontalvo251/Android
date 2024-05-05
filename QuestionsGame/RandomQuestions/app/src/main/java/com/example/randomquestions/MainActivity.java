package com.example.randomquestions;

///For Android Version 11.0+
import androidx.appcompat.app.AppCompatActivity;
//For Android Version 9.0
//import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
			Questions.add("What is the best compliment you have ever received?");
			Questions.add("What is your relationship with cheese?");
			Questions.add("Give me an example of a pet peeve?");
			Questions.add("What is your favorite color?");
			Questions.add("What's your favorite food?");
			Questions.add("What is something that makes you lose track of time?");
			Questions.add("What are ten things you would bring to a desert island?");
			Questions.add("What is your favorite movie?");
			Questions.add("What movie do you basically have memorized?");
			Questions.add("When you fly do you prefer the window or aisle seat?");
			Questions.add("What's something you love but others hate?");
			Questions.add("What's your best animal impression?");
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
			Questions.add("What is your most controversial opinion?");
			Questions.add("Do you believe in conspiracy theories?");
			Questions.add("Thoughts on gay marriage?");
			Questions.add("Thoughts on abortion?");
			Questions.add("Thoughts on Transgender?");
			Questions.add("How would you feel if a family member (sibling, parent, child) did not identify with their sex at birth?");
			Questions.add("Political Views in general?");
			Questions.add("What's your faith life like?");
			Questions.add("Do you go to church?");
			Questions.add("How do you feel about meditation?");
			Questions.add("Do you believe in an afterlife?");
			Questions.add("Trump?");
			Questions.add("Do you believe in karma?");
			Questions.add("Do you believe in abortion if you knew the child would be disabled?");
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
			Questions.add("Can I post photos of us on social media?");
			Questions.add("What are you expectations with integrating with my life (friends, family, kids)?");
			Questions.add("What are your love languages?");
			Questions.add("Tell me about your first crush");
			Questions.add("Who was the first person you kissed?");
			Questions.add("What's your relationship deal breaker?");
			Questions.add("How do you manage your finances?");
			Questions.add("Do you have a type?");
			Questions.add("Netflix and Chill or Night out?");
			Questions.add("What is the best compliment you've ever received?");
			Questions.add("What do you want to be remembered for?");
			Questions.add("Can you be trusted with secrets? (Share one if so)");
			Questions.add("Have you ever had an eating disorder or body image dysmorphia?");
			Questions.add("Do you enjoy surprises or receiving gifts?");
			Questions.add("What's the worst date you've been on?");
			Questions.add("Play never have I ever (just 5 fingers)");
			Questions.add("What's your relationship with your parents like?");
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
			Questions.add("How do you consume your weed?");
			Questions.add("What do you typically do for mothers day and fathers day?");
			Questions.add("Do you do drugs?");
			Questions.add("Have you ever been addicted to anything?");
		}
		Switch swSD = (Switch) findViewById(R.id.switchSD);
		boolean isCheckedSD = swSD.isChecked();
		if (isCheckedSD) {
			// The toggle is enabled
			// Add Seriously Dating
			//DATING SERIOUSLY
			Questions.add("If I cheat on you and feel terrible about it, do you want me to tell you or deal with it on my own?");
			Questions.add("Do you want to know if an ex is contacting me or just keep it to myself?");
			Questions.add("Do you want our phones to remain private or are they free to be looked at whenever you want?");
			Questions.add("How do you feel about me maintaining friendships with people where I've had prior romantic relationships with?");
			Questions.add("How do you define the boundaries between privavy in our relationship and sharing things with close friends and family?");
			Questions.add("Do you want me to share all moments of doubt or only share when it becomes a problem?");
			Questions.add("Do you want me to tell you if someone has a crush on me or you?");
			Questions.add("How do you feel about innocently flirting with someone of the opposite sex?");
			Questions.add("Do you want me to tell you when a close friend or family member doesn't like you");
			Questions.add("How do you define emotional cheating?");
			Questions.add("Describe your childhood trauma");
			Questions.add("What are your expectations for communication throughout the day (texting, calls, check-ins)?");
			Questions.add("Have you ever cheated on a past partner?");
			Questions.add("If I do end up cheating on you would you rather just break up or discuss the issue and try and resolve it together?");
			Questions.add("Do you want to know if an ex is contacting me?");
			Questions.add("Do you want me to tell you when someone has a crush on me?");
			Questions.add("How do you feel about me innocently flirting with other people?");
			Questions.add("Do you want me to tell you if one of my friends or family members doesn't like you?");
			Questions.add("How do you define emotional cheating and if I did emotionally cheat would you want me to tell you about it?");
			Questions.add("Do you want me to share any doubts I have about the relationship or only bring it up if it becomes a big problem?");
			Questions.add("How private does our relationship need to be in terms of sharing details of the relationship with friends or family?");
			Questions.add("Do you want our phones remain private or is it something that you want to have free access too?");
			Questions.add("How do you feel about me maintaining friendships with people I've had a prior romantic relationship with?");
			Questions.add("What do I do that irritates you the most?");
			Questions.add("How do you feel about saying 'I love you'?");
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
			Questions.add("How can I support you during difficult times in your life?");
			Questions.add("Have you ever been abused in any way (emotional or physical)?");
			Questions.add("Do you have an addition to anything? (Drugs, alcohol, gambling, TV, porn, etc)");
			Questions.add("How many kids do you want? Do you even wants kids? Adoption?");
			Questions.add("What's your favorite thing about me?");
			Questions.add("When did your last relationship end and what did it teach you?");
			Questions.add("Have you ever been in a relationship where your partner had strong emotional needs? How did you handle it?");
			Questions.add("Are you still friends with your ex? If not do you at least still talk?");
			Questions.add("Are you open to marriage? Why or why not?");
			Questions.add("Are you willing to co-habitate before getting married?");
			Questions.add("If we lived together, who would do what chores around the house?");
			Questions.add("If we had kids what would be everyone's responsibility? Like traditional gender roles or not?");
			Questions.add("What are the expectation for time with each other versus time with friends and family?");
			Questions.add("Have you thought about asking the marriage questions? Maybe you're not thinking about marriage but there are some good ones in there.");
		}
		Switch swXR = (Switch) findViewById(R.id.switchXR);
		boolean isCheckedXR = swXR.isChecked();
		if (isCheckedXR) {
			// The toggle is enabled
			// Add Physical Relationship
			//PHYSICAL RELATIONSHIP
			Questions.add("Do you like massages? Where?");
			Questions.add("What does physical intimacy look like to you?");
			Questions.add("Cuddles or kisses?");
			Questions.add("How wide can you stretch your ball sack or your vagina?");
			Questions.add("How do you feel about PDA in front of people you don't know vs family vs friends?");
			Questions.add("What do I do that turns you on the most?");
			Questions.add("When did your parents talk to you about sex?");
			Questions.add("Tell me about your previous sexual partners");
			Questions.add("Have you ever had a bad hookup?");
			Questions.add("What part of your body do you most like to be touched?");
			Questions.add("What do you do in the shower?");
			Questions.add("Have you ever had a threesome? Is that something you want to do in our relationship?");
			Questions.add("Where is the craziest place you've had sex?");
			Questions.add("What is your favorite sex move?");
			Questions.add("What is your favorite sex position?");
			Questions.add("Have you ever had an orgasm? If so how? If not, how does that make you feel?");
			Questions.add("What's your favorite part of my body?");
			Questions.add("How do you feel about your partner watching porn without you in a committed relationship?");
			Questions.add("How do you feel about your partner masturbating in a committed relationship?");
			Questions.add("Do you touch yourself at night?");
			Questions.add("Do you prefer tits or ass?");
			Questions.add("Does size matter (height, dick, boobs, ass, weight)?");
			Questions.add("What does sex mean to you?");
			Questions.add("Do you have any insecurities surrounding sex?");
			Questions.add("Do you have any fears surrounding sex?");
			Questions.add("Are there certain sexual activities that are off the table?");
			Questions.add("What does intimacy mean to you?");
			Questions.add("What does 'making love' mean to you?");
		}
		Switch swM = (Switch) findViewById(R.id.switchM);
		boolean isCheckedM = swM.isChecked();
		if (isCheckedM) {
			//Questions to ask before you get married
			//MARRIAGE
			Questions.add("Be sure you've asked everyone question in this game. Nothing should be off the table when considering to get married.");
			Questions.add("Why do you want to get married?");
			Questions.add("What are the expectations for holidays?");
			Questions.add("Who will handle conflict within extended family?");
			Questions.add("Who will plan trips with extended family?");
			Questions.add("What roles do you foresee in the home (dishes, childcare, cleaning, car and house maintenance etc)?");
			Questions.add("If one spouse is offered a career promotion requiring re-location, how will you make a decision as a couple?");
			Questions.add("How will an income differential affect the relationship?");
			Questions.add("How do you feel about your spouse bringing work home?");
			Questions.add("How do you feel about attending an office party for your spouse?");
			Questions.add("How do you feel about entertaining people from work?");
			Questions.add("How will you handle long distance travel? (Loneliness, kids, etc)?");
			Questions.add("How do you feel about working late?");
			Questions.add("How will you handle your finances? (who pays for what? , Separate bank accounts?, Debt?, Toys?)");
			Questions.add("How do you feel about your spouse working with someone of the opposite sex?");
			Questions.add("Rank these in order of importance: Career, Friends, Children, Marriage, Spirituality, Chores, Parents, Leisure");
			Questions.add("What is your opinion about spending time with single friends (same sex) after you are married?");
			Questions.add("How important is it to you for you to both have mutual (or individual) friends?");
			Questions.add("What is appropriate for you to share about your marriage to friends and family? What needs to be kept within the marriage?");
			Questions.add("How often do you foresee seeing your parents?");
			Questions.add("What will be your holiday plans after marriage?");
			Questions.add("What are your goals for your marriage?");
			Questions.add("Will you get jealous if I give someone of the opposite sex attention or even look at?");
			Questions.add("Do you have a hard time trusting your partner?");
			Questions.add("Do you feel like there are areas or topics that you cannot discuss with your partner?");
			Questions.add("Do you have a problem apologizing to your partner or admitting fault?");
			Questions.add("Do you hold grudges?");
			Questions.add("Is there any outside pressure to get married?");
			Questions.add("Agree or disagree: I can't handle being single");
			Questions.add("What does 'Being faithful/cheating' mean to you in a marriage?");
			Questions.add("Are there things your partner does that you hope they will change? What are they? Note: You cannot force someone to change.");
			Questions.add("Can you relax and be yourself around your partner?");
			Questions.add("Do you act differently at parties when your partner is there or not?");
			Questions.add("Do you depend on each other for emotional support?");
			Questions.add("If you have an issue with your partner, how do you bring it up? Are you loving or brutally honest?");
			Questions.add("How much time will you spend together or apart? Hobbies? Alone time? Other friends and family?");
			Questions.add("When you are making a decision and cannot agree, what will you do?");
			Questions.add("How will you show each other affection (hand holding, hugs, etc)? This is different than the 5 love languages");
			Questions.add("How close do you want to live ideally to your parents?");
			Questions.add("Under what circumstances will you accept financial assistance from your parents?");
			Questions.add("Under what circumstances will you offer financial assistance to your parents?");
			Questions.add("If we plan on having kids, what will be the roles of the grandparents?");
			Questions.add("If you already have children, how will you parent shared children?");
			Questions.add("Does your family and extended family like and welcome your partner into their lives?");
			Questions.add("Do you feel welcome in your partners family?");
			Questions.add("Is there ever a circumstance where physical discipline is appropriate for children?");
			Questions.add("If we are going to raise kids together, what is your parenting philosophy?");
			Questions.add("If you found out your partner cheated on you, would you immediately get divorced?");
			Questions.add("Will spirituality be important in your marriage? If so, how will you grow spiritually together (church, faith, ministries, prayer, etc)?");
			Questions.add("How would you feel about your child holding a different faith belief than you?");

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
