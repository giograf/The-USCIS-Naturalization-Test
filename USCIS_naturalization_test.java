import java.util.*;

/*
 	
 	USCIS Naturalization Test
    Copyright (C) 2015  Roman Zakharenkov

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

	Ñontact the author:
	E-mail: roman.zakharenkov@gmail.com
	Github: https://github.com/giograf/The-USCIS-Naturalization-Test
		
 
*/

class QandA {

    /*

       Questions and Answers to the naturalization test are stored as objects of QandA class,
       each object stores a question and an answer corresponding to one another. In addition to that, each
       QandA class object stores a number of answers to be given in order to resolve the question in a variable
       "required answers" and an integer variable "special case" which:

       1) If equal to 0, designates a regular QandA object.
       2) If equal to 1, designates a QandA object dedicated for examination of applicants who are
       65 years old or older and have lived in the U.S. for 20 or more years.
       3) If equal to 2, designates a QandA object answers to the question within which vary depending
       on the respondent.
       4) If equal to 3, designates a QandA object corresponding to both "1" and "2" values of the
       special_case variable.

    */

    Scanner keyboard = new Scanner(System.in);

    int special_case;
    int required_answers;
    String question;
    String answer;
    public QandA() {

    }
    public QandA(int given_special_case,
                 int given_required_answers,
                 String given_question,
                 String given_answer ) {
        special_case = given_special_case;
        required_answers = given_required_answers;
        question = given_question;
        answer = given_answer;
    }

    public int get_special_case(){
        return this.special_case;
    }
}


class QandA_used_class extends  QandA {

    /*

        This class is used to store questions and required answers currently in use by the test.

    */

    String[] user_answers = new String[10];
    boolean question_is_answered_correctly;

    public QandA_used_class(int given_special_case,
                            int given_required_answers,
                            String given_question,
                            String given_answer) {
        super(given_special_case,
            given_required_answers,
            given_question,
            given_answer);
    }

    public QandA_used_class(QandA object) {
        special_case = object.special_case;
        required_answers = object.required_answers;
        question = object.question;
        answer = object.answer;
    }

    public void add_answer(int given_index, String given_answer) {
        int index = given_index;
        String answer = given_answer;
        user_answers[index] = given_answer;
    }


    public void put_result(boolean true_or_false) {
        question_is_answered_correctly = true_or_false;
    }

    /*
        The method below converts an ArrayList of integers into an array of integers.
    */

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        Iterator<Integer> iterator = integers.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }
}



class USCIS_naturalization_test {
    public static void main (String[] args) {

        /*
            Below is the initialization of the storage of questions and answers.

            The underscores ('_') in strings representing answers are used to seperate the valid
            answers to the question given.
        */

        QandA[] storage_of_QandA = {
                new QandA(0, 1, " What is the supreme law of the land?", "the Constitution_Constitution"),
                new QandA(0, 2, " What does the Constitution do?",
                        "defines the government_protects basic rights of Americans_sets up the government"),
                new QandA(0, 1, " The idea of self-government is in the first three words " +
                        "of the Constitution. What are these words?", "We the People"),
                new QandA(0, 1, " What is an amendment?", "a change_an addition_an addition (to the Constitution)_a change (to the Constitution)_" +
                        "an addition (to the Constitution)_an addition to the Constitution_a change to the Constitution"),
                new QandA(0, 1, " What do we call the first ten amendments to the Constitution?", "the Bill of Rights"),
                new QandA(1, 1, " What is one right or freedom from the First Amendment?", "speech_religion_assembly_press_petition the government"),
                new QandA(0, 1, " How many amendments does the Constitution have?", "27_twenty-seven"),
                new QandA(0, 1, "What did the Declaration of Independence do?", "announced our independence (from Great Britain)_" +
                        "declared our independence (from Great Britain)_said that the United States is free (from Great Britain)"),
                new QandA(0, 2, "What are two rights in the Declaration of Independence?", "life_liberty_pursuit of happiness"),
                new QandA(0, 1, "What is freedom of religion?", "You can practice any religion, or not practice a religion."),
                new QandA(1, 1, "What is the economic system in the United States?", "capitalist economy_market economy"),
                new QandA(0, 3, "What is the \"rule of law\"?", "Everyone must follow the law_Leaders must obey the law_Government must obey the law_" +
                        "No one is above the law"),
                new QandA(1, 1, "Name one branch or part of the government.", "Congress_legislative_President_executive_the courts_" +
                        "judicial"),
                new QandA(0, 2, "What stops one branch of government from becoming too powerful?", "checks and balances_separation of powers"),
                new QandA(0, 1, "Who is in charge of the executive branch?", "the President_President"),
                new QandA(0, 3, "Who makes federal laws?", "Congress_Senate and House (of Representatives)_Senate and House_" +
                        "U.S. legislature_national legislature"),
                new QandA(1, 2, "What are the two parts of the U.S. Congress?", "the Senate_" +
                        "the House of Representatives"),
                new QandA(0, 1, "How many U.S. Senators are there?", "one hundred_100"),
                new QandA(0, 1, "We elect a U.S. Senator for how many years?", "six_6"),
                new QandA(3, 1, "Who is one of your state's U.S. Senators now?", "No answer provided."),
                new QandA(0, 1, "The House of Representatives has how many voting members?", "four hundred thirty-five_435"),
                new QandA(0, 1, "We elect a U.S. Representative for how many years?", "two_2"),
                new QandA(2, 1, "Name your U.S. Representative.", "No answer provided."),
                new QandA(0, 1, "Who does a U.S. Senator represent?", "all people of the state_all people"),
                new QandA(0, 1, "Why do some states have more Representatives than other states?", "the state's population_" +
                        "they have more people_some states have more people_because some states have more people_" +
                        "because they have more people_because of the state's population"),
                new QandA(0, 1, "We elect a President for how many years?", "four_4"),
                new QandA(1, 1, "In what month do we vote for President?", "November"),
                new QandA(1, 1, "What is the name of the President of the United States now?", "Barack Obama_Obama"),
                new QandA(0, 1, "What is the name of the Vice President of the United States now?", "Joseph R. Biden, Jr._" +
                        "Joe Biden_Biden"),
                new QandA(0, 1, "If the President can no longer serve, who becomes President?", "the Vice President_Vice President"),
                new QandA(0, 1, "If both the President and the Vice President can no longer serve, who becomes President?",
                        "the Speaker of the House"),
                new QandA(0, 1, "Who is the Commander in Chief of the military?", "the President_President"),
                new QandA(0, 1, "Who signs bills to become laws?", "the President_President"),
                new QandA(0, 1, "Who vetoes bills?", "the President_President"),
                new QandA(0, 1, "What does the President's Cabinet do?", "advises the President_ gives advice to the President"),
                new QandA(0, 2, "What are two Cabinet-level positions?", "Secretary of Agriculture_Secretary of Commerce_" +
                        "Secretary of Defense_Secretary of Education_Secretary of Energy_Secretary of Health and Human Services_" +
                        "Secretary of Homeland Security_Secretary of Housing and Urban Development_Secretary of the Interior_" +
                        "Secretary of Labor_Secretary of State_Secretary of Transportation_Secretary of the Treasury_" +
                        "Secretary of Veterans Affairs_Attorney General_Vice President"),
                new QandA(0, 4, "What does the judicial branch do?", "reviews laws_explains laws_resolves disputes_" +
                        "decides if a law goes against the Constitution"),
                new QandA(0, 1, "What is the highest court in the United States?", "the Supreme Court_Supreme Court"),
                new QandA(0, 1, "How many justices are on the Supreme Court?", "9_nine"),
                new QandA(0, 1, "Who is the Chief Justice of the United States now?", "John Roberts_John G. Roberts, Jr."),
                new QandA(0, 1, "Under our Constitution, some powers belong to the federal government. What is one power of the federal\n" +
                        "government?", "to print money_printing money_to declare war_war declaration_to create an army_" +
                        "army creation_ to make treaties_ making treaties"),
                new QandA(0, 1, "Under our Constitution, some powers belong to the states. What is one power of the states?", "" +
                        "provide schooling and education_provide protection_provide safety_give a driver's license_" +
                        "approve zoning and land use"),
                new QandA(2, 1, "Who is the Governor of your state now?", "No answer provided."),
                new QandA(3, 1, "What is the capital of your state?", "No answer provided."),
                new QandA(1, 2, "What are the two major political parties in the United States?", "Democratic_Republican_Republican Party_" +
                        "Democratic Party"),
                new QandA(0, 1, "What is the political party of the President now?", "Democratic_Democratic Party"),
                new QandA(0, 1, "What is the name of the Speaker of the House of Representatives now?", "Paul Ryan_Paul D. Ryan_Ryan"),
                new QandA(0, 1, "There are four amendments to the Constitution about who can vote. Describe one of them.",
                        "Citizens eighteen and older can vote_Citizens eighteen and older_Citizens 18 and older_" +
                                "Citizens eighteen 18 and older can vote_A male citizen of any race_" +
                                "A male citizen of any race can vote_You don't have to pay a poll tax to vote_" +
                                "You don't have to pay a tax to vote_One doesn't have to pay a poll tax to vote_" +
                                "Any citizen can vote_Women and men can vote"),
                new QandA(1, 1, "What is one responsibility that is only for United States citizens?", "vote in a federal election_" +
                        "serve on a jury"),
                new QandA(0, 1, "Name one right only for United States citizens.", "vote in a federal election_run for federal office"),
                new QandA(0, 2, "What are two rights of everyone living in the United States?", "freedom of expression_" +
                        "freedom of speech_freedom of assembly_freedom to petition the government_freedom of worship_" +
                        "the right to bear arms_the right to have arms"),
                new QandA(0, 1, "What do we show loyalty to when we say the Pledge of Allegiance?", "the United States_" +
                        "the flag_the U.S._U.S._US_the flag of the U.S._flag of the U.S._flag of the US_United States"),
                new QandA(0, 1, "What is one promise you make when you become a United States citizen?", "be loyal to the United States_" +
                        "to be loyal to the United States_give up loyalty to other countries_to give up loyalty to other countries_" +
                        "to be loyal to United States_be loyal to United States_to be loyal to the U.S._" +
                        "be loyal to the US_be loyal to US_defend the Constitution and laws of the United States_" +
                        "defend the Constitution and laws of the United States_defend Constitution and laws of the United States_" +
                        "to defend the Constitution and laws of the United States_defend Constitution and laws of United States_" +
                        "to defend Constitution and laws of United States_defend the Constitution and laws of the U.S._" +
                        "defend the Constitution and laws of the US_to defend the Constitution and laws of the U.S._" +
                        "defend Constitution and laws of the US_defend Constitution and laws of US_" +
                        "obey the laws of the United States_obey the laws of the US_obey laws of the United States" +
                        "obey laws of the U.S._obey laws of United States_serve in the U.S. military_" +
                        "serve in the United States military_to serve in the United States military_" +
                        "serve in the United States military if needed_to serve in the United States military_" +
                        "to serve in the United States military if needed_to serve in the U.S. military_" +
                        "to serve in the U.S. military if needed_serve in the U.S. military if needed_" +
                        "serve the nation_do important work for the nation if needed_to serve the nation_" +
                        "to do important work for the nation if needed"),
                new QandA(1, 1, "How old do citizens have to be to vote for President?", "eighteen and older_18 and older_" +
                        "18"),
                new QandA(0, 2, "What are two ways that Americans can participate in their democracy?", "vote_to vote_" +
                        "join a political party_to join a political party_help with a campaign_to help with a campaign_" +
                        "to join a civic group_join a civic group_join a community group_to join a community group_" +
                        "give an elected official your opinion on an issue_" +
                        "to give an elected official your opinion on an issue_give an elected official your opinion_" +
                        "call Senators and Representatives_call Senators and Representatives_" +
                        "publicly support or oppose an issue or policy_publicly support or oppose an policy_" +
                        "publicly support or oppose an issue_to publicly support or oppose an issue or policy_" +
                        "to publicly support or oppose an issue_to publicly support or oppose a policy_run for office_" +
                        "to run for office_write to a newspaper_to write to a newspaper"),
                new QandA(1, 1, "When is the last day you can send in federal income tax forms?", "April 15_the 15th of April_" +
                        "15 of April"),
                new QandA(0, 1, "When must all men register for the Selective Service?", "at age eighteen_at age 18_at age of eighteen_" +
                        "between eighteen and twenty-six_between 18 and 26_between the age 18 and 26_" +
                        "between the age of eighteen and twenty-six_between the age eighteen and twenty-six"),
                new QandA(0, 1, "What is one reason colonists came to America?", "freedom_political liberty_religious freedom_" +
                        "economic opportunity_economic opportunities_practice their religion_to practice their religion_" +
                        "to escape persecution_escape persecution"),
                new QandA(0, 1, "Who lived in America before the Europeans arrived?", "American Indians_Native Americans"),
                new QandA(0, 1, "What group of people was taken to America and sold as slaves?", "Africans_people from Africa"),
                new QandA(0, 1, "Why did the colonists fight the British?", "because they didn't have self-government_" +
                        "they didn't have self-government_because of high taxes_because the British army stayed in their houses"),
                new QandA(0, 1, "Who wrote the Declaration of Independence?", "Jefferson_Thomas Jefferson_Jeferson"),
                new QandA(0, 1, "When was the Declaration of Independence adopted?", "July 4, 1776_the 4th of July 1776_" +
                        "July 4 1776_July the 4th, 1776_July 4th 1776_4th of July 1776_4th of July in 1776_" +
                        "the 4th of July in 1776_"),
                new QandA(0, 3, "There were 13 original states. Name three.", "New Hampshire_Massachusetts_Rhode Island_" +
                        "Connecticut_New York_New Jersey_Pennsylvania_Delaware_Maryland_Virginia_North Carolina_" +
                        "South Carolina_Georgia"),
                new QandA(0, 1, "What happened at the Constitutional Convention?", "The Constitution was written._" +
                        "The Constitution was written_Constitution was written_The Founding Fathers wrote the Constitution_" +
                        "Founding Fathers wrote the Constitution_The Founding Fathers wrote Constitution"),
                new QandA(0, 1, "When was the Constitution written?", "1787_in 1787"),
                new QandA(0, 1, "The Federalist Papers supported the passage of the U.S. Constitution. Name one of the writers.",
                        "Madison_James Madison_Hamilton_Alexander Hamilton_John Jay_Jay_Publius"),
                new QandA(0, 1, "What is one thing Benjamin Franklin is famous for?", "U.S. diplomat_ U.S. diplomacy_" +
                        "US diplomat_US diplomacy_oldest member of the Constitutional Convention_" +
                        "the first Postmaster General of the United States_" +
                        "first Postmaster General of the United States_writer of \"Poor Richard's Almanac\"_" +
                        "writer of Poor Richard's Almanac_started the first free libraries"),
                new QandA(1, 1, "Who is the \"Father of Our Country\"?", "George Washington_Washington"),
                new QandA(1, 1, "Who was the first President?", "George Washington_Washington"),
                new QandA(0, 1, "What territory did the United States buy from France in 1803?", "the Louisiana Territory_" +
                        "Louisiana_Louisiana Territory"),
                new QandA(0, 1, "Name one war fought by the United States in the 1800s.", "War of 1812_the War of 1812_" +
                        "Mexican-American War_the Mexican-American War_Civil War_the Civil War_" +
                        "Spanish-American War_the Spanish-American War"),
                new QandA(0, 1, "Name the U.S. war between the North and the South.", "the Civil War_Civil War_" +
                        "the War between the States_War between the States"),
                new QandA(0, 1, "Name one problem that led to the Civil War.", "slavery_economic reasons_economy_" +
                        "states' rights_states rights"),
                new QandA(1, 1, "What was one important thing that Abraham Lincoln did?*", "led the United States during the Civil War_" +
                        "led the US during the Civil War_led the U.S. during the Civil War_" +
                        "led the United States during Civil War_led the U.S. during Civil War_" +
                        "led United States during the Civil War_led the United States during Civil War_" +
                        "led United States during Civil War_led the US during the Civil War_" +
                        "led US during Civil War_saved the Union_preserved the Union_saved Union_" +
                        "preserved the Union_preserved Union_freed the slaves_Emancipation Proclamation)"),
                new QandA(0, 1, "What did the Emancipation Proclamation do?", "freed the slaves_freed slaves in the Confederacy_" +
                        "freed slaves in the Confederate states_freed slaves in most Southern states"),
                new QandA(0, 1, "What did Susan B. Anthony do?", "fought for women's rights_fought for civil rights"),
                new QandA(1, 1, "Name one war fought by the United States in the 1900s.", "World War I_the World War I_" +
                        "World War 1_the World War I_the World War 1_the World War_the 1st World War_the first World War_" +
                        "World War II_the World War II_World War 2_the World War II_the World War 2__the 1st World War_" +
                        "the 1st World War_the first World War_Korean War_the Korean War_Vietnam War_ the Vietnam War_" +
                        "Persian Gulf War_the Persian Gulf War_Gulf War_the Gulf War"),
                new QandA(0, 1, "Who was President during World War I?", "Woodrow Wilson_Wilson"),
                new QandA(0, 2, "Who was President during the Great Depression and World War II?", "Roosevelt_Franklin Roosevelt"),
                new QandA(0, 3, "Who did the United States fight in World War II?", "Germany_Italy_Japan_Nazi Germany_Third Reich_" +
                        "the Third Reich"),
                new QandA(0, 1, "Before he was President, Eisenhower was a general. What war was he in?", "World War II_" +
                        "the second World War_the 2nd World War_World War the second"),
                new QandA(0, 1, "During the Cold War, what was the main concern of the United States?", "Communism_communists_" +
                        "the USSR_the U.S.S.R_The Union of Soviet Socialist Republics"),
                new QandA(0, 1, "What movement tried to end racial discrimination?", "civil rights_civil rights movement_" +
                        "the civil rights movement"),
                new QandA(1, 1, "What did Martin Luther King, Jr. do?", "fought for civil rights_worked for equality for all Americans_" +
                        "worked for equality"),
                new QandA(0, 1, "What major event happened on September 11, 2001, in the United States?",
                        "Terrorists attacked the United States_Terrorists attacked the US_Terrorists attacked the U.S." +
                                "Terrorists attacked New York_Terrorists attacked the New York City_ The United States was attacked" +
                                "by terrorists_New York was attacked by terrorists_The New York city was attacked by terrorists"),
                new QandA(0, 1, "Name one American Indian tribe in the United States.", "Cherokee_Navajo_Sioux_Chippewa_Choctaw_" +
                        "Pueblo_Apache_Iroquois_Creek_Blackfeet_Seminole_Cheyenne_Arawak_Shawnee_Mohegan_Huron_Oneida_" +
                        "Lakota_Crow_Teton_Hopi_Inuit"),
                new QandA(0, 1, "Name one of the two longest rivers in the United States.", "Missouri_Missouri River_" +
                        "the Missouri River_Mississippi_Mississippi River_the Mississippi River"),
                new QandA(0, 1, "What ocean is on the West Coast of the United States?", "Pacific_Pacific Ocean_" +
                        "the Pacific Ocean_the Pacific"),
                new QandA(0, 1, "What ocean is on the East Coast of the United States?", "the Atlantic Ocean_the Atlantic" +
                        "Atlantic_Atlantic Ocean_"),
                new QandA(0, 1, "Name one U.S. territory.", "Puerto Rico_American Samoa_Northern Mariana Islands_Guam_" +
                        "U.S. Virgin Islands_Virgin Islands"),
                new QandA(0, 1, "Name one state that borders Canada.", "Maine_New Hampshire_Vermont_New York_Pennsylvania_" +
                        "Ohio_Michigan_Minnesota_North Dakota_Montana_Idaho_Washington_Alaska"),
                new QandA(0, 1, "Name one state that borders Mexico.", "California_Arizona_New Mexico_Texas"),
                new QandA(1, 1, "What is the capital of the United States?", "Washington, D.C._Washington D.C._" +
                        "Washington, DC_Washington DC"),
                new QandA(1, 1, "Where is the Statue of Liberty?", "New York_the New York city_New York Harbor_" +
                        "the New York Harbor_Liberty Island_New Jersey_the Hudson River_Hudson River"),
                new QandA(0, 1, "Why does the flag have 13 stripes?", "because there were 13 original colonies_" +
                        "because the stripes represent the original colonies_the stripes represent the original colonies_" +
                        "there were 13 original colonies"),
                new QandA(1, 1, "Why does the flag have 50 stars?", "because there is one star for each state_" +
                        "there is one star for each state_because each star represents a state_" +
                        "each star represents a state_because there are 50 states_there are 50 states"),
                new QandA(0, 1, "What is the name of the national anthem?", "The Star-Spangled Banner"),
                new QandA(1, 1, "When do we celebrate Independence Day?", "July 4_the 4th of July_the fourth of July_" +
                        "fourth of July_4th of July_July the 4th"),
                new QandA(0, 2, "Name two national U.S. holidays.", "New Year's Day_New Year_Martin Luther King, Jr. Day_" +
                        "Martin Luther King Day_ Martin Luther King Juniour Day_Presidents' Day_" +
                        "Memorial Day_Independence Day_Labor Day_Columbus Day_Veterans Day_Thanksgiving_" +
                        "Christmas")
        };

        /*
            Variables used by the main method of the program are declared below.
        */

        Scanner keyboard = new Scanner(System.in);
        Scanner keyboard_special = new Scanner(System.in);
        boolean user_wants_to_use_the_program = true;
        boolean user_wants_to_use_the_subprogram = true;

        char pressed_button; // used throughout the program whenever one makes a choice.

        String user_answer = new String ();
        ArrayList<QandA_used_class> QandA_used = new ArrayList<QandA_used_class>();
        QandA_used_class [] QandA_used_array;
        ArrayList<String> given_answers = new ArrayList<String>();
        String [] given_answers_array;
        int answers_correct;
        boolean question_is_answered_correctly;
        boolean equality;
        String [] given_answers_array_check;
        String [] answers_check;
        int index = 0;
        int max_index;
        boolean user_wants_to_see_results_or_mistakes;
        ArrayList<String> results_arraylist = new ArrayList<String>();
        String [] results;
        ArrayList<Integer> listing_qanda_mistake_index = new ArrayList<Integer>();
        int [] listing_qanda_mistake_index_array;

        int random_number;
        int [] used_random_numbers;
        boolean number_was_used;
        boolean object_is_placed;
        int special_case;


        int listing_qanda_index;
        int end_of_listing;
        String answer_from_the_list;
        String question_from_the_list;
        String answers [];
        int answer_number_line;

        do {

            /*
                The code below represents the main menu of the program.
             */

            System.out.println("\n\n\n\n\n\n\n\n U.S. Citizenship \n and Immigration \n Services\n");
            System.out.println("\n When appplying to the U.S. Citizenship one is obliged to" +
                    "\n pass an oral naturalization test which includes the English test and" +
                    "\n the Civics test. The latter consists of 10 questions 6 of which" +
                    "\n has to be answered in order to pass the test. There are 100" +
                    "\n questions out of which an examiner may choose.");

            System.out.println("" +
                    "\n     Press 'f' to try answering all 100 questions." +
                    "\n     Press 'r' to pass a 10 question \"real\" test." +
                    "\n\n     Press 'o' if you are older than 65 years old or older and you've been \n" +
                    "     residing" +
                    "in the U.S for 20 or more years and want to pass the full test." +
                    "\n     Press 'm' if you are older than 65 years old or older and you've \n" +
                    "      been residing" +
                    "in the U.S for 20 or more years and want to pass \n" +
                    "     the \"real\" test." +
                    "\n\n     Press 'a' to read the full list of possible questions and answers." +
                    "\n     Press 'e' to exit the program\n     ");

            pressed_button = keyboard.next().charAt(0);









            /*
                The subprogram below represents the full test in which all possible questions are asked from a
                regular user of the program.
            */

            if (pressed_button == 'f') {

                /*
                    The loop below copies all QandA storage to a QandA_used object with which further work
                    is intended.
                */

                QandA_used.clear();

                for (listing_qanda_index = 0;
                     listing_qanda_index < storage_of_QandA.length;
                     listing_qanda_index++) {
                    QandA_used.add(new QandA_used_class(storage_of_QandA[listing_qanda_index].special_case,
                            storage_of_QandA[listing_qanda_index].required_answers,
                            storage_of_QandA[listing_qanda_index].question,
                            storage_of_QandA[listing_qanda_index].answer));
                }

                QandA_used_array = new QandA_used_class[QandA_used.size()];
                QandA_used_array = QandA_used.toArray(QandA_used_array);
                listing_qanda_index = 0;
                user_wants_to_use_the_subprogram = true;

                /*
                    The while loop below is where the action of the subprogram takes place.
                */

                while (user_wants_to_use_the_subprogram == true) {

                    /*
                        The loop below is used for asking questions, recieving and saving answers.

                        While defines limits of the loop according to the length of the ArrayList.
                        For defines limits of the loop according to the number of answers expected from a user. It,
                            in fact, recieves, checks and saves all the answers.
                    */

                    while (listing_qanda_index < QandA_used_array.length && user_wants_to_use_the_subprogram == true) {
                        given_answers.clear();
                        for (int number_of_answers_given = 0;
                             number_of_answers_given < QandA_used_array[listing_qanda_index].required_answers;
                             number_of_answers_given++) {
                            System.out.println("\n  Question #" + (listing_qanda_index + 1) + " :\n" +
                                    QandA_used_array[listing_qanda_index].question +
                                    "\n\n  Questions left: " + (QandA_used_array.length - listing_qanda_index) +
                                    "      Answers left: " + (QandA_used_array[listing_qanda_index].required_answers -
                                    number_of_answers_given));
                            user_answer = keyboard_special.nextLine();
                            given_answers.add(user_answer);
                        }

                    /*
                        Turn an ArrayList of answers given by a user to a given question into an array and save it
                        to an array which is a datafield of a object containing the asked question.
                    */

                        given_answers_array = new String[given_answers.size()];
                        given_answers_array = given_answers.toArray(given_answers_array);
                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            QandA_used_array[listing_qanda_index].add_answer(index, given_answers_array[index]);
                        }

                    /*
                        Both correct answers and answers given by a user are translated to lower-case letters.
                    */

                        answers = QandA_used_array[listing_qanda_index].answer.split("_");

                        given_answers_array_check = new String[given_answers_array.length];
                        answers_check = new String[answers.length];

                        for (index = 0;
                             index < answers.length;
                             index++) {
                            answers_check[index] = answers[index].toLowerCase();
                        }

                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            given_answers_array_check[index] = given_answers_array[index].toLowerCase();
                        }

                    /*
                        Check whether the answers entered by user are the same as those stored in database.
                    */

                        answers_correct = 0;
                        equality = false;

                        for (int index1 = 0;
                             index1 < given_answers_array_check.length;
                             index1++) {
                            for (int index2 = 0;
                                 index2 < answers_check.length;
                                 index2++) {
                                equality = given_answers_array_check[index1].equals(answers_check[index2]);
                                if (equality == true) {
                                    answers_correct++;
                                    index2 = answers_check.length;
                                    equality = false;
                                }
                            }
                        }

                    /*
                        Check whether the entered answers are correct and if not ask user whether he would
                        answer the answer correctly in an oral test.
                    */

                        question_is_answered_correctly = true;

                        if (answers_correct == QandA_used_array[listing_qanda_index].required_answers) {
                            question_is_answered_correctly = true;
                        }

                        else if (answers_correct != QandA_used_array[listing_qanda_index].required_answers) {

                            System.out.print("\n  Question: " + QandA_used_array[listing_qanda_index].question + "." +
                                    "\n  " + QandA_used_array[listing_qanda_index].required_answers +
                                    " answers you entered must be same as (similar to) asnwers provided in" +
                                    "\n  the database," +
                                    "\n  Your answers : \n");

                            answer_number_line = 1;
                            for (String answer : given_answers_array) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.print("\n  Correct answers: \n");

                            answer_number_line = 1;
                            for (String answer : answers) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.println("\n  The answers you have entered are not found in our datebase.\n" +
                                    "  Please, check whether your answers correspond to the correct answers\n  we have in" +
                                    " our datebase.\n" +
                                    "  Press 'y' if you answered correctly.\n" +
                                    "  Press 'n' if you answered incorrectly.\n");

                            pressed_button = keyboard.next().charAt(0);

                            if (pressed_button != 'n') {
                                question_is_answered_correctly = true;
                            }

                            else if (pressed_button == 'n') {
                                question_is_answered_correctly = false;
                            }
                        }

                        QandA_used_array[listing_qanda_index].put_result(question_is_answered_correctly);

                    /*
                        Making a choice. Only if the test is not finished.


                        Press 'n' to move to the next question.
                        Press 'e' to exit the test.
                    */

                        System.out.println("\n  Press 'n' to  move to the next question. \n" +
                                "  Press 'e' to exit the test.");
                        pressed_button = keyboard.next().charAt(0);

                        if (listing_qanda_index != QandA_used_array.length) {

                            if (pressed_button != 'e') {
                                user_wants_to_use_the_subprogram = true;
                                listing_qanda_index++;
                            }

                            if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }

                    /*
                        The subprogram within the test below helps user analise his results.
                        User can see all of the results, see questions and answers where he made a mistake or
                        leave the test.
                    */


                    if (user_wants_to_use_the_subprogram == true) {
                        while (user_wants_to_use_the_subprogram == true) {
                            System.out.println("\n\n\n\n  Menu:\n\n" +
                                    "  Press 'f' to see results.\n" +
                                    "  Press 'm' to see mistakes.\n" +
                                    "  Press 'e' to exit to the main menu.\n\n\n\n\n\n\n\n\n\n\n\n");
                            pressed_button = keyboard.next().charAt(0);

                            results_arraylist.clear();
                            for (listing_qanda_index = 0;
                                 listing_qanda_index < QandA_used_array.length;
                                 listing_qanda_index++) {
                                results_arraylist.add(Boolean.toString(QandA_used_array[listing_qanda_index].question_is_answered_correctly));
                            }

                            results = new String[results_arraylist.size()];
                            results = results_arraylist.toArray(results);

                            /*
                                After pressing 'f' user can see what questions were answered correctly and what were not.
                            */

                            if (pressed_button == 'f') {

                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true) {
                                    max_index = index + 10;
                                    while (index < max_index) {
                                        System.out.printf("\n Answer #%-2d" + "   %-12s" + "Answer #%-2d" +
                                                "   %-12s", (index + 1), results[index], (index + 11), results[(index + 10)]);
                                        index++;
                                    }

                                    index --;

                                    System.out.print("\n  Press 'n' to see next results. \n" +
                                            "  Press 'p' to see previous results.\n" +
                                            "  Press 'e' to exit to the test menu.\n");

                                    pressed_button = keyboard.next().charAt(0);

                                    if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;

                                    }
                                    else if (pressed_button == 'p' && index >= 29) {
                                        index -= 29;
                                    }
                                    else if (pressed_button == 'n' && index <= 69) {
                                        index += 11;
                                    }
                                    else if (pressed_button == 'p' && index < 29) {
                                        index -= 9;
                                        System.out.println("\n  No previous results found.");
                                    }
                                    else if (pressed_button == 'n' && index > 69) {
                                        index -= 9;
                                        System.out.println("\n  No further results found.");
                                    }
                                }
                            }

                            /*
                                If user pressed 'm', he would be able to see those questions and answers where a mistake
                                was made.
                            */

                            else if (pressed_button == 'm') {
                                for (listing_qanda_index = 0;
                                     listing_qanda_index < QandA_used_array.length;
                                     listing_qanda_index++) {
                                    if (results[listing_qanda_index] == "false") {
                                        listing_qanda_mistake_index.add(listing_qanda_index);
                                    }
                                }
                                listing_qanda_mistake_index_array = new int[listing_qanda_mistake_index.size()];
                                for (int i = 0; i < listing_qanda_mistake_index.size(); i++) {
                                    listing_qanda_mistake_index_array[i] = listing_qanda_mistake_index.get(i);
                                }


                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true && index >= 0 &&
                                        index < listing_qanda_mistake_index_array.length) {

                                    answers = QandA_used_array[listing_qanda_mistake_index_array[index]].answer.split("_");
                                    System.out.println("\n  Question #" + (listing_qanda_mistake_index_array[index ] + 1)+ ":\n" +
                                            QandA_used_array[listing_qanda_mistake_index_array[index]].question +
                                            "\n\n  Correct Answer: ");
                                    answer_number_line = 1;
                                    for (String answer : answers) {
                                        System.out.println("  " + answer_number_line + ". " + answer);
                                        answer_number_line++;
                                    }
                                    System.out.println("\n\n  Your Answer(s):");
                                    answer_number_line = 1;
                                    for (String answer : QandA_used_array[index].user_answers) {
                                        if(answer != null){
                                            System.out.println("  " + answer_number_line + ". " + answer);
                                        }
                                        answer_number_line++;
                                    }

                                    System.out.println("\n\n  Press 'n' to analyse next mistake." +
                                            "\n  Press 'p' to analyse previous mistake." +
                                            "\n  Press 'e' to exit to the test menu.\n\n\n\n\n\n\n\n\n\n");

                                    pressed_button = keyboard_special.next().charAt(0);

                                    if (pressed_button == 'n' && index >= (listing_qanda_mistake_index_array.length - 1)) {
                                        System.out.println("This is the last mistake.");
                                    }
                                    else if (pressed_button == 'p' && index <= 0) {
                                        System.out.println("This is the first mistake.");
                                    }
                                    else if (pressed_button == 'p' && index > 0) {
                                        index--;
                                    }
                                    else if (pressed_button == 'n' && index < (listing_qanda_mistake_index_array.length - 1)) {
                                        index++;
                                    }
                                    else if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;
                                    }
                                }
                            }

                            else if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }
                }
            }










            /*
                The subprogram below represents the real test in which 10 questions are asked from a
                regular user of the program.
            */

            else if (pressed_button == 'r') {

                /*
                    The loop below copies all QandA storage to a QandA_used object with which further work
                    is intended.
                */

                QandA_used_array = new QandA_used_class[10];
                used_random_numbers = new int[10];

                for (int objects_in_array = 0;
                     objects_in_array < 10;
                     objects_in_array ++){
                    object_is_placed = false;
                    number_was_used = false;

                    while (object_is_placed == false){
                        random_number = (int) (Math.random() * 100);
                        object_is_placed = false;
                        number_was_used = false;
                        index = 0;
                        while (index < 10 && number_was_used == false){
                            if (random_number == used_random_numbers[index]){
                                number_was_used = true;
                            }
                            index ++;
                        }
                        if (number_was_used == false){
                            QandA_used_array[objects_in_array] = new QandA_used_class(storage_of_QandA[random_number]);
                            used_random_numbers[objects_in_array] = random_number;
                            object_is_placed = true;
                        }
                    }
                }


                listing_qanda_index = 0;
                user_wants_to_use_the_subprogram = true;

                /*
                    The while loop below is where the action of the subprogram takes place.
                */

                while (user_wants_to_use_the_subprogram == true) {

                    /*
                        The loop below is used for asking questions, recieving and saving answers.

                        While defines limits of the loop according to the length of the ArrayList.
                        For defines limits of the loop according to the number of answers expected from a user. It,
                            in fact, recieves, checks and saves all the answers.
                    */

                    while (listing_qanda_index < QandA_used_array.length && user_wants_to_use_the_subprogram == true) {
                        given_answers.clear();
                        for (int number_of_answers_given = 0;
                             number_of_answers_given < QandA_used_array[listing_qanda_index].required_answers;
                             number_of_answers_given++) {
                            System.out.println("\n  Question #" + (listing_qanda_index + 1) + " :\n" +
                                    QandA_used_array[listing_qanda_index].question +
                                    "\n\n  Questions left: " + (QandA_used_array.length - listing_qanda_index) +
                                    "      Answers left: " + (QandA_used_array[listing_qanda_index].required_answers -
                                    number_of_answers_given));
                            user_answer = keyboard_special.nextLine();
                            given_answers.add(user_answer);
                        }

                    /*
                        Turn an ArrayList of answers given by a user to a given question into an array and save it
                        to an array which is a datafield of a object containing the asked question.
                    */

                        given_answers_array = new String[given_answers.size()];
                        given_answers_array = given_answers.toArray(given_answers_array);
                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            QandA_used_array[listing_qanda_index].add_answer(index, given_answers_array[index]);
                        }

                    /*
                        Both correct answers and answers given by a user are translated to lower-case letters.
                    */

                        answers = QandA_used_array[listing_qanda_index].answer.split("_");

                        given_answers_array_check = new String[given_answers_array.length];
                        answers_check = new String[answers.length];

                        for (index = 0;
                             index < answers.length;
                             index++) {
                            answers_check[index] = answers[index].toLowerCase();
                        }

                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            given_answers_array_check[index] = given_answers_array[index].toLowerCase();
                        }

                    /*
                        Check whether the answers entered by user are the same as those stored in database.
                    */

                        answers_correct = 0;
                        equality = false;

                        for (int index1 = 0;
                             index1 < given_answers_array_check.length;
                             index1++) {
                            for (int index2 = 0;
                                 index2 < answers_check.length;
                                 index2++) {
                                equality = given_answers_array_check[index1].equals(answers_check[index2]);
                                if (equality == true) {
                                    answers_correct++;
                                    index2 = answers_check.length;
                                    equality = false;
                                }
                            }
                        }

                    /*
                        Check whether the entered answers are correct and if not ask user whether he would
                        answer the answer correctly in an oral test.
                    */

                        question_is_answered_correctly = true;

                        if (answers_correct == QandA_used_array[listing_qanda_index].required_answers) {
                            question_is_answered_correctly = true;
                        }

                        else if (answers_correct != QandA_used_array[listing_qanda_index].required_answers) {

                            System.out.print("\n  Question: " + QandA_used_array[listing_qanda_index].question + "." +
                                    "\n  " + QandA_used_array[listing_qanda_index].required_answers +
                                    " answers you entered must be same as (similar to) asnwers provided in" +
                                    "\n  the database," +
                                    "\n  Your answers : \n");

                            answer_number_line = 1;
                            for (String answer : given_answers_array) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.print("\n  Correct answers: \n");

                            answer_number_line = 1;
                            for (String answer : answers) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.println("\n  The answers you have entered are not found in our datebase.\n" +
                                    "  Please, check whether your answers correspond to the correct answers\n  we have in" +
                                    " our datebase.\n" +
                                    "  Press 'y' if you answered correctly.\n" +
                                    "  Press 'n' if you answered incorrectly.\n");

                            pressed_button = keyboard.next().charAt(0);

                            if (pressed_button != 'n') {
                                question_is_answered_correctly = true;
                            }

                            else if (pressed_button == 'n') {
                                question_is_answered_correctly = false;
                            }
                        }

                        QandA_used_array[listing_qanda_index].put_result(question_is_answered_correctly);

                    /*
                        Making a choice. Only if the test is not finished.


                        Press 'n' to move to the next question.
                        Press 'e' to exit the test.
                    */

                        System.out.println("\n  Press 'n' to  move to the next question. \n" +
                                "  Press 'e' to exit the test.");
                        pressed_button = keyboard.next().charAt(0);

                        if (listing_qanda_index != QandA_used_array.length) {

                            if (pressed_button != 'e') {
                                user_wants_to_use_the_subprogram = true;
                                listing_qanda_index++;
                            }

                            if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }

                    /*
                        The subprogram within the test below helps user analise his results.
                        User can see all of the results, see questions and answers where he made a mistake or
                        leave the test.
                    */


                    if (user_wants_to_use_the_subprogram == true) {
                        while (user_wants_to_use_the_subprogram == true) {
                            System.out.println("\n\n\n\n  Menu:\n\n" +
                                    "  Press 'f' to see results.\n" +
                                    "  Press 'm' to see mistakes.\n" +
                                    "  Press 'e' to exit to the main menu.\n\n");
                            pressed_button = keyboard.next().charAt(0);
                            System.out.println("\n\n\n\n\n");

                            results_arraylist.clear();
                            for (listing_qanda_index = 0;
                                 listing_qanda_index < QandA_used_array.length;
                                 listing_qanda_index++) {
                                results_arraylist.add(Boolean.toString(QandA_used_array[listing_qanda_index].question_is_answered_correctly));
                            }

                            results = new String[results_arraylist.size()];
                            results = results_arraylist.toArray(results);

                            /*
                                After pressing 'f' user can see what questions were answered correctly and what were not.
                            */

                            if (pressed_button == 'f') {

                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true) {
                                    index = 0;
                                    max_index = index + 10;
                                    while (index < max_index) {
                                        System.out.printf("\n Answer #%-2d" + "   %-12s", (index + 1), results[index]);
                                        index++;
                                    }


                                    System.out.print("\n\n  Press 'e' to exit to the test menu.\n");

                                    pressed_button = keyboard.next().charAt(0);

                                    if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;

                                    }
                                }
                            }

                            /*
                                If user pressed 'm', he would be able to see those questions and answers where a mistake
                                was made.
                            */

                            else if (pressed_button == 'm') {
                                for (listing_qanda_index = 0;
                                     listing_qanda_index < QandA_used_array.length;
                                     listing_qanda_index++) {
                                    if (results[listing_qanda_index] == "false") {
                                        listing_qanda_mistake_index.add(listing_qanda_index);
                                    }
                                }
                                listing_qanda_mistake_index_array = new int[listing_qanda_mistake_index.size()];
                                /*listing_qanda_mistake_index_array = listing_qanda_mistake_index.toArray(listing_qanda_mistake_index_array);*/
                                for (int i = 0; i < listing_qanda_mistake_index.size(); i++) {
                                    listing_qanda_mistake_index_array[i] = listing_qanda_mistake_index.get(i);
                                }


                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true && index >= 0 &&
                                        index < listing_qanda_mistake_index_array.length) {

                                    answers = QandA_used_array[listing_qanda_mistake_index_array[index]].answer.split("_");
                                    System.out.println("\n  Question #" + (listing_qanda_mistake_index_array[index ] + 1)+ ":\n" +
                                            QandA_used_array[listing_qanda_mistake_index_array[index]].question +
                                            "\n\n  Correct Answer: ");
                                    answer_number_line = 1;
                                    for (String answer : answers) {
                                        System.out.println("  " + answer_number_line + ". " + answer);
                                        answer_number_line++;
                                    }
                                    System.out.println("\n\n  Your Answer(s):");
                                    answer_number_line = 1;
                                    for (String answer : QandA_used_array[index].user_answers) {
                                        if(answer != null){
                                            System.out.println("  " + answer_number_line + ". " + answer);
                                        }
                                        answer_number_line++;
                                    }

                                    System.out.println("\n\n  Press 'n' to analyse next mistake." +
                                            "\n  Press 'p' to analyse previous mistake." +
                                            "\n  Press 'e' to exit to the test menu.\n\n\n\n");

                                    pressed_button = keyboard_special.next().charAt(0);

                                    if (pressed_button == 'n' && index >= (listing_qanda_mistake_index_array.length - 1)) {
                                        System.out.println("This is the last mistake.");
                                    }
                                    else if (pressed_button == 'p' && index <= 0) {
                                        System.out.println("This is the first mistake.");
                                    }
                                    else if (pressed_button == 'p' && index > 0) {
                                        index--;
                                    }
                                    else if (pressed_button == 'n' && index < (listing_qanda_mistake_index_array.length - 1)) {
                                        index++;
                                    }
                                    else if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;
                                    }
                                }
                            }

                            else if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }
                }
            }








            /*
                The subprogram below represents the full test in which all possible questions are asked from an
                older user of the program.
            */

            else if (pressed_button == 'o') {

                /*
                    The loop below copies all QandA storage to a QandA_used object with which further work
                    is intended.
                */

                QandA_used.clear();

                for (listing_qanda_index = 0;
                     listing_qanda_index < storage_of_QandA.length;
                     listing_qanda_index ++) {
                     if (storage_of_QandA[listing_qanda_index].special_case == 1 ||
                         storage_of_QandA[listing_qanda_index].special_case == 3) {
                            QandA_used.add(new QandA_used_class(storage_of_QandA[listing_qanda_index].special_case,
                                 storage_of_QandA[listing_qanda_index].required_answers,
                                 storage_of_QandA[listing_qanda_index].question,
                                 storage_of_QandA[listing_qanda_index].answer));
                     }
                }

                QandA_used_array = new QandA_used_class [QandA_used.size()];
                QandA_used_array = QandA_used.toArray(QandA_used_array);
                user_wants_to_see_results_or_mistakes = true;
                user_wants_to_use_the_subprogram = true;

                /*
                    The while loop below is where the action of the subprogram takes place.
                */

                while (user_wants_to_use_the_subprogram == true) {


                    /*
                        The loop below is used for asking questions, recieving and saving answers.

                        While defines limits of the loop according to the length of the ArrayList.
                        For defines limits of the loop according to the number of answers expected from a user. It,
                            in fact, recieves, checks and saves all the answers.
                    */
                    listing_qanda_index = 0;
                    while (listing_qanda_index < QandA_used_array.length && user_wants_to_use_the_subprogram == true) {
                        given_answers.clear();
                        for (int number_of_answers_given = 0;
                             number_of_answers_given < QandA_used_array[listing_qanda_index].required_answers;
                             number_of_answers_given++) {
                            System.out.println("\n  Question #" + (listing_qanda_index + 1) + " :\n" +
                                    QandA_used_array[listing_qanda_index].question +
                                    "\n\n  Questions left: " + (QandA_used_array.length - listing_qanda_index) +
                                    "      Answers left: " + (QandA_used_array[listing_qanda_index].required_answers -
                                    number_of_answers_given));
                            user_answer = keyboard_special.nextLine();
                            given_answers.add(user_answer);
                        }

                    /*
                        Turn an ArrayList of answers given by a user to a given question into an array and save it
                        to an array which is a datafield of a object containing the asked question.
                    */

                        given_answers_array = new String[given_answers.size()];
                        given_answers_array = given_answers.toArray(given_answers_array);
                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            QandA_used_array[listing_qanda_index].add_answer(index, given_answers_array[index]);
                        }

                    /*
                        Both correct answers and answers given by a user are translated to lower-case letters.
                    */

                        answers = QandA_used_array[listing_qanda_index].answer.split("_");

                        given_answers_array_check = new String[given_answers_array.length];
                        answers_check = new String[answers.length];

                        for (index = 0;
                             index < answers.length;
                             index++) {
                            answers_check[index] = answers[index].toLowerCase();
                        }

                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            given_answers_array_check[index] = given_answers_array[index].toLowerCase();
                        }

                    /*
                        Check whether the answers entered by user are the same as those stored in database.
                    */

                        answers_correct = 0;
                        equality = false;

                        for (int index1 = 0;
                             index1 < given_answers_array_check.length;
                             index1++) {
                            for (int index2 = 0;
                                 index2 < answers_check.length;
                                 index2++) {
                                equality = given_answers_array_check[index1].equals(answers_check[index2]);
                                if (equality == true) {
                                    answers_correct++;
                                    index2 = answers_check.length;
                                    equality = false;
                                }
                            }
                        }

                    /*
                        Check whether the entered answers are correct and if not ask user whether he would
                        answer the answer correctly in an oral test.
                    */

                        question_is_answered_correctly = true;

                        if (answers_correct == QandA_used_array[listing_qanda_index].required_answers) {
                            question_is_answered_correctly = true;
                        }

                        else if (answers_correct != QandA_used_array[listing_qanda_index].required_answers) {

                            System.out.print("\n  Question: " + QandA_used_array[listing_qanda_index].question + "." +
                                    "\n  " + QandA_used_array[listing_qanda_index].required_answers +
                                    " answers you entered must be same as (similar to) asnwers provided in" +
                                    "\n  the database," +
                                    "\n  Your answers : \n");

                            answer_number_line = 1;
                            for (String answer : given_answers_array) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.print("\n  Correct answers: \n");

                            answer_number_line = 1;
                            for (String answer : answers) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.println("\n  The answers you have entered are not found in our datebase.\n" +
                                    "  Please, check whether your answers correspond to the correct answers\n  we have in" +
                                    " our datebase.\n" +
                                    "  Press 'y' if you answered correctly.\n" +
                                    "  Press 'n' if you answered incorrectly.\n");

                            pressed_button = keyboard.next().charAt(0);

                            if (pressed_button != 'n') {
                                question_is_answered_correctly = true;
                            }

                            else if (pressed_button == 'n') {
                                question_is_answered_correctly = false;
                            }
                        }

                        QandA_used_array[listing_qanda_index].put_result(question_is_answered_correctly);

                    /*
                        Making a choice. Only if the test is not finished.


                        Press 'n' to move to the next question.
                        Press 'e' to exit the test.
                    */

                        System.out.println("\n  Press 'n' to  move to the next question. \n" +
                                "  Press 'e' to exit the test.");
                        pressed_button = keyboard.next().charAt(0);

                        if (listing_qanda_index != QandA_used_array.length) {

                            if (pressed_button != 'e') {
                                user_wants_to_use_the_subprogram = true;
                                listing_qanda_index++;
                            }

                            if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }




                    /*
                        The subprogram within the test below helps user analise his results.
                        User can see all of the results, see questions and answers where he made a mistake or
                        leave the test.
                    */


                    if (user_wants_to_use_the_subprogram == true) {
                        while (user_wants_to_use_the_subprogram == true) {
                            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n  Menu:\n\n" +
                                    "  Press 'f' to see results.\n" +
                                    "  Press 'm' to see mistakes.\n" +
                                    "  Press 'e' to exit to the main menu.\n" +
                                    "\n" +
                                    "\n" +
                                    "\n" +
                                    "\n");
                            pressed_button = keyboard.next().charAt(0);

                            results_arraylist.clear();
                            for (listing_qanda_index = 0;
                                 listing_qanda_index < QandA_used_array.length;
                                 listing_qanda_index++) {
                                results_arraylist.add(Boolean.toString(QandA_used_array[listing_qanda_index].question_is_answered_correctly));
                            }

                            results = new String[results_arraylist.size()];
                            results = results_arraylist.toArray(results);

                            /*
                                After pressing 'f' user can see what questions were answered correctly and what were not.
                            */

                            if (pressed_button == 'f') {

                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true) {
                                    max_index = index + 10;
                                    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                                    if(index >= 0 && index < 20) {
                                        index = 0;
                                        while (index < max_index) {
                                            System.out.printf("\n Answer #%-2d" + "   %-12s" + "Answer #%-2d" +
                                                    "   %-12s", (index + 1), results[index], (index + 11), results[(index + 10)]);
                                            index++;
                                        }
                                        index = 0;
                                    }

                                    if(index >= 20) {
                                        while (index < results.length) {
                                            System.out.printf("\n Answer #%-2d" + "   %-12s", (index + 1), results[index]);
                                            index++;
                                        }
                                        index = 20;
                                    }




                                    System.out.print("\n\n  Press 'n' to see next results. \n" +
                                            "  Press 'p' to see previous results.\n" +
                                            "  Press 'e' to exit to the test menu.\n\n\n\n\n\n");

                                    pressed_button = keyboard.next().charAt(0);



                                    if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;
                                    }
                                    else if (pressed_button == 'p' && index == 20) {
                                        index = 0;
                                    }
                                    else if (pressed_button == 'n' && index == 0) {
                                        index = 20;
                                    }
                                    else if (pressed_button == 'p' && index == 0) {
                                        System.out.println("\n  No previous results found.");

                                    }
                                    else if (pressed_button == 'n' && index == 20) {
                                        System.out.println("\n  No further results found.");
                                    }
                                }
                            }

                            /*
                                If user pressed 'm', he would be able to see those questions and answers where a mistake
                                was made.
                            */

                            else if (pressed_button == 'm') {
                                for (listing_qanda_index = 0;
                                     listing_qanda_index < QandA_used_array.length;
                                     listing_qanda_index++) {
                                    if (results[listing_qanda_index] == "false") {
                                        listing_qanda_mistake_index.add(listing_qanda_index);
                                    }
                                }
                                if (listing_qanda_mistake_index.size() == 0) {
                                    System.out.println("\n\n No mistakes were made. \n\n");
                                }
                                else if (listing_qanda_mistake_index.size() > 0) {

                                    listing_qanda_mistake_index_array = new int[listing_qanda_mistake_index.size()];

                                    for (int i = 0; i < listing_qanda_mistake_index.size(); i++) {
                                        listing_qanda_mistake_index_array[i] = listing_qanda_mistake_index.get(i);
                                    }


                                    user_wants_to_see_results_or_mistakes = true;
                                    index = 0;
                                    while (user_wants_to_see_results_or_mistakes == true && index >= 0 &&
                                            index < listing_qanda_mistake_index_array.length) {

                                        answers = QandA_used_array[listing_qanda_mistake_index_array[index]].answer.split("_");
                                        System.out.println("\n  Question #" + (listing_qanda_mistake_index_array[index] + 1) + ":\n" +
                                                QandA_used_array[listing_qanda_mistake_index_array[index]].question +
                                                "\n\n  Correct Answer: ");
                                        answer_number_line = 1;
                                        for (String answer : answers) {
                                            System.out.println("  " + answer_number_line + ". " + answer);
                                            answer_number_line++;
                                        }
                                        System.out.println("\n\n  Your Answer(s):");
                                        answer_number_line = 1;
                                        for (String answer : QandA_used_array[index].user_answers) {
                                            if (answer != null) {
                                                System.out.println("  " + answer_number_line + ". " + answer);
                                            }
                                            answer_number_line++;
                                        }

                                        System.out.println("\n\n  Press 'n' to analyse next mistake." +
                                                "\n  Press 'p' to analyse previous mistake." +
                                                "\n  Press 'e' to exit to the test menu.\n\n");

                                        pressed_button = keyboard_special.next().charAt(0);

                                        if (pressed_button == 'n' && index >= (listing_qanda_mistake_index_array.length - 1)) {
                                            System.out.println("This is the last mistake.");
                                        } else if (pressed_button == 'p' && index <= 0) {
                                            System.out.println("This is the first mistake.");
                                        } else if (pressed_button == 'p' && index > 0) {
                                            index--;
                                        } else if (pressed_button == 'n' && index < (listing_qanda_mistake_index_array.length - 1)) {
                                            index++;
                                        } else if (pressed_button == 'e') {
                                            user_wants_to_see_results_or_mistakes = false;
                                        }
                                    }
                                }
                            }

                            else if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }
                }
            }









            /*
                The subprogram below represents the real test in which 10 questions are asked from an
                older user of the program.
            */

            else if (pressed_button == 'm') {
            /*
                    The loop below copies all QandA storage to a QandA_used object with which further work
                    is intended.
                */

                QandA_used_array = new QandA_used_class[10];
                used_random_numbers = new int[10];
                number_was_used = false;
                object_is_placed = false;

                for (int objects_in_array = 0;
                     objects_in_array < 10;
                     objects_in_array ++){
                    object_is_placed = false;
                    number_was_used = false;
                    while (object_is_placed == false){
                        random_number = (int) (Math.random() * 100);
                        object_is_placed = false;
                        number_was_used = false;
                        index = 0;

                            while (index < 10 && number_was_used == false){
                                if (random_number == used_random_numbers[index]){
                                    number_was_used = true;
                                }

                                index ++;
                            }
                            if (number_was_used == false){
                                special_case = storage_of_QandA[random_number].get_special_case();
                                if (special_case == 1 || special_case == 3){
                                    QandA_used_array[objects_in_array] = new QandA_used_class(storage_of_QandA[random_number]);
                                    object_is_placed = true;
                                }
                            }
                    }
                }


                listing_qanda_index = 0;
                user_wants_to_use_the_subprogram = true;

                /*
                    The while loop below is where the action of the subprogram takes place.
                */

                while (user_wants_to_use_the_subprogram == true) {

                    /*
                        The loop below is used for asking questions, recieving and saving answers.

                        While defines limits of the loop according to the length of the ArrayList.
                        For defines limits of the loop according to the number of answers expected from a user. It,
                            in fact, recieves, checks and saves all the answers.
                    */

                    while (listing_qanda_index < QandA_used_array.length && user_wants_to_use_the_subprogram == true) {
                        given_answers.clear();
                        for (int number_of_answers_given = 0;
                             number_of_answers_given < QandA_used_array[listing_qanda_index].required_answers;
                             number_of_answers_given++) {
                            System.out.println("\n  Question #" + (listing_qanda_index + 1) + " :\n" +
                                    QandA_used_array[listing_qanda_index].question +
                                    "\n\n  Questions left: " + (QandA_used_array.length - listing_qanda_index) +
                                    "      Answers left: " + (QandA_used_array[listing_qanda_index].required_answers -
                                    number_of_answers_given));
                            user_answer = keyboard_special.nextLine();
                            given_answers.add(user_answer);
                        }

                    /*
                        Turn an ArrayList of answers given by a user to a given question into an array and save it
                        to an array which is a datafield of a object containing the asked question.
                    */

                        given_answers_array = new String[given_answers.size()];
                        given_answers_array = given_answers.toArray(given_answers_array);
                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            QandA_used_array[listing_qanda_index].add_answer(index, given_answers_array[index]);
                        }

                    /*
                        Both correct answers and answers given by a user are translated to lower-case letters.
                    */

                        answers = QandA_used_array[listing_qanda_index].answer.split("_");

                        given_answers_array_check = new String[given_answers_array.length];
                        answers_check = new String[answers.length];

                        for (index = 0;
                             index < answers.length;
                             index++) {
                            answers_check[index] = answers[index].toLowerCase();
                        }

                        for (index = 0;
                             index < given_answers_array.length;
                             index++) {
                            given_answers_array_check[index] = given_answers_array[index].toLowerCase();
                        }

                    /*
                        Check whether the answers entered by user are the same as those stored in database.
                    */

                        answers_correct = 0;
                        equality = false;

                        for (int index1 = 0;
                             index1 < given_answers_array_check.length;
                             index1++) {
                            for (int index2 = 0;
                                 index2 < answers_check.length;
                                 index2++) {
                                equality = given_answers_array_check[index1].equals(answers_check[index2]);
                                if (equality == true) {
                                    answers_correct++;
                                    index2 = answers_check.length;
                                    equality = false;
                                }
                            }
                        }

                    /*
                        Check whether the entered answers are correct and if not ask user whether he would
                        answer the answer correctly in an oral test.
                    */

                        question_is_answered_correctly = true;

                        if (answers_correct == QandA_used_array[listing_qanda_index].required_answers) {
                            question_is_answered_correctly = true;
                        }

                        else if (answers_correct != QandA_used_array[listing_qanda_index].required_answers) {

                            System.out.print("\n  Question: " + QandA_used_array[listing_qanda_index].question + "." +
                                    "\n  " + QandA_used_array[listing_qanda_index].required_answers +
                                    " answers you entered must be same as (similar to) asnwers provided in" +
                                    "\n  the database," +
                                    "\n  Your answers : \n");

                            answer_number_line = 1;
                            for (String answer : given_answers_array) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.print("\n  Correct answers: \n");

                            answer_number_line = 1;
                            for (String answer : answers) {
                                System.out.println(answer_number_line + ". " + answer);
                                answer_number_line++;
                            }

                            System.out.println("\n  The answers you have entered are not found in our datebase.\n" +
                                    "  Please, check whether your answers correspond to the correct answers\n  we have in" +
                                    " our datebase.\n" +
                                    "  Press 'y' if you answered correctly.\n" +
                                    "  Press 'n' if you answered incorrectly.\n");

                            pressed_button = keyboard.next().charAt(0);

                            if (pressed_button != 'n') {
                                question_is_answered_correctly = true;
                            }

                            else if (pressed_button == 'n') {
                                question_is_answered_correctly = false;
                            }
                        }

                        QandA_used_array[listing_qanda_index].put_result(question_is_answered_correctly);

                    /*
                        Making a choice. Only if the test is not finished.


                        Press 'n' to move to the next question.
                        Press 'e' to exit the test.
                    */

                        System.out.println("\n  Press 'n' to  move to the next question. \n" +
                                "  Press 'e' to exit the test.");
                        pressed_button = keyboard.next().charAt(0);

                        if (listing_qanda_index != QandA_used_array.length) {

                            if (pressed_button != 'e') {
                                user_wants_to_use_the_subprogram = true;
                                listing_qanda_index++;
                            }

                            if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }

                    /*
                        The subprogram within the test below helps user analise his results.
                        User can see all of the results, see questions and answers where he made a mistake or
                        leave the test.
                    */


                    if (user_wants_to_use_the_subprogram == true) {
                        while (user_wants_to_use_the_subprogram == true) {
                            System.out.println("\n\n\n\n  Menu:\n\n" +
                                    "  Press 'f' to see results.\n" +
                                    "  Press 'm' to see mistakes.\n" +
                                    "  Press 'e' to exit to the main menu.\n\n");
                            pressed_button = keyboard.next().charAt(0);
                            System.out.println("\n\n\n\n\n\n");

                            results_arraylist.clear();
                            for (listing_qanda_index = 0;
                                 listing_qanda_index < QandA_used_array.length;
                                 listing_qanda_index++) {
                                results_arraylist.add(Boolean.toString(QandA_used_array[listing_qanda_index].question_is_answered_correctly));
                            }

                            results = new String[results_arraylist.size()];
                            results = results_arraylist.toArray(results);

                            /*
                                After pressing 'f' user can see what questions were answered correctly and what were not.
                            */

                            if (pressed_button == 'f') {

                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true) {
                                    index = 0;
                                    max_index = index + 10;
                                    while (index < max_index) {
                                        System.out.printf("\n Answer #%-2d" + "   %-12s", (index + 1), results[index]);
                                        index++;
                                    }


                                    System.out.print("\n\n  Press 'e' to exit to the test menu.\n\n");

                                    pressed_button = keyboard.next().charAt(0);

                                    if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;

                                    }
                                }
                            }

                            /*
                                If user pressed 'm', he would be able to see those questions and answers where a mistake
                                was made.
                            */

                            else if (pressed_button == 'm') {
                                for (listing_qanda_index = 0;
                                     listing_qanda_index < QandA_used_array.length;
                                     listing_qanda_index++) {
                                    if (results[listing_qanda_index] == "false") {
                                        listing_qanda_mistake_index.add(listing_qanda_index);
                                    }
                                }
                                listing_qanda_mistake_index_array = new int[listing_qanda_mistake_index.size()];
                                /*listing_qanda_mistake_index_array = listing_qanda_mistake_index.toArray(listing_qanda_mistake_index_array);*/
                                for (int i = 0; i < listing_qanda_mistake_index.size(); i++) {
                                    listing_qanda_mistake_index_array[i] = listing_qanda_mistake_index.get(i);
                                }


                                user_wants_to_see_results_or_mistakes = true;
                                index = 0;
                                while (user_wants_to_see_results_or_mistakes == true && index >= 0 &&
                                        index < listing_qanda_mistake_index_array.length) {

                                    answers = QandA_used_array[listing_qanda_mistake_index_array[index]].answer.split("_");
                                    System.out.println("\n  Question #" + (listing_qanda_mistake_index_array[index ] + 1)+ ":\n" +
                                            QandA_used_array[listing_qanda_mistake_index_array[index]].question +
                                            "\n\n  Correct Answer: ");
                                    answer_number_line = 1;
                                    for (String answer : answers) {
                                        System.out.println("  " + answer_number_line + ". " + answer);
                                        answer_number_line++;
                                    }
                                    System.out.println("\n\n  Your Answer(s):");
                                    answer_number_line = 1;
                                    for (String answer : QandA_used_array[index].user_answers) {
                                        if(answer != null){
                                            System.out.println("  " + answer_number_line + ". " + answer);
                                        }
                                        answer_number_line++;
                                    }

                                    System.out.println("\n\n  Press 'n' to analyse next mistake." +
                                            "\n  Press 'p' to analyse previous mistake." +
                                            "\n  Press 'e' to exit to the test menu.\n\n\n\n");

                                    pressed_button = keyboard_special.next().charAt(0);

                                    if (pressed_button == 'n' && index >= (listing_qanda_mistake_index_array.length - 1)) {
                                        System.out.println("This is the last mistake.");
                                    }
                                    else if (pressed_button == 'p' && index <= 0) {
                                        System.out.println("This is the first mistake.");
                                    }
                                    else if (pressed_button == 'p' && index > 0) {
                                        index--;
                                    }
                                    else if (pressed_button == 'n' && index < (listing_qanda_mistake_index_array.length - 1)) {
                                        index++;
                                    }
                                    else if (pressed_button == 'e') {
                                        user_wants_to_see_results_or_mistakes = false;
                                    }
                                }
                            }

                            else if (pressed_button == 'e') {
                                user_wants_to_use_the_subprogram = false;
                            }
                        }
                    }
                }
            }









            /*
                The subprogram below is designed to show all possible questions and answers to the Civics test.
                Users can move to the previously shown and next questions by typing 'p' or 'n' correspondingly.
            */

            else if (pressed_button == 'a') {

                listing_qanda_index = 0;
                end_of_listing = listing_qanda_index + 2;

                /*
                    The do-while loop restricts the action of the subprogram.
                */

                do {

                    user_wants_to_use_the_subprogram = true;

                    /*
                        The while loop below lists two questions and two answers corresponding to them.
                    */

                    while (listing_qanda_index < end_of_listing) {
                        question_from_the_list = storage_of_QandA[listing_qanda_index].question;
                        answer_from_the_list = storage_of_QandA[listing_qanda_index].answer;
                        System.out.println("\n\nQuestion #" + (listing_qanda_index + 1));
                        System.out.println(question_from_the_list + "\n");
                        System.out.println("Answers #" + (listing_qanda_index + 1));
                        answers = answer_from_the_list.split("_");
                        answer_number_line = 1;
                        for (String answer : answers) {
                            System.out.println(answer_number_line + ". " + answer + "\n");
                            answer_number_line ++ ;
                        }
                        if (listing_qanda_index != end_of_listing) {
                            listing_qanda_index ++;
                        }
                    }

                    System.out.print("\n\n Press 'n' to see next questions and answers." +
                            "\n Press 'p' to see previous questions and answers." +
                            "\n Press 'e' to see the main menu of the program.\n\n");
                    pressed_button = keyboard.next().charAt(0);

                    if (pressed_button == 'e') {
                        user_wants_to_use_the_subprogram = false;
                    }

                    else if (pressed_button == 'n') {
                        if (listing_qanda_index <= 98) {
                            end_of_listing = listing_qanda_index + 2;
                        }
                        else if (listing_qanda_index >= 99) {
                            System.out.print("\n  There are no next questions and answers, please," +
                                    " press 'p' to see\n  previous questions or press 'e' to see the main menu.\n");
                        }
                    }

                    else if (pressed_button == 'p') {
                        if (listing_qanda_index >= 3) {
                            listing_qanda_index = listing_qanda_index - 4;
                            end_of_listing = listing_qanda_index + 2;
                        }
                        else if (listing_qanda_index <= 2) {
                            System.out.print("\n  There are no previous questions and answers, please," +
                                    " press 'n' to see\n  next questions or press 'e' to see the main menu\n");
                        }
                    }
                }
                while (user_wants_to_use_the_subprogram == true) ;
            }









            /*
                To exit the program from the main menu user can type in 'e'.
                If the 'e' button is pressed, the condition for the loop within which program is located
                will become false and the program will terminate.
            */

            else if (pressed_button == 'e') {
                user_wants_to_use_the_program = false;
            }









        }
    while (user_wants_to_use_the_program == true);
    }
}