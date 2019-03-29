package com.anvipuri.trail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Activity_4 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] no_of_days= {"2 days","3 days"};
    Spinner spinner;
    String city_name;
    String noofdays;

    private DatabaseHelperPlanner databasehelper;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;
    TextView text9;
    TextView text10;
    TextView text11;
    TextView text12;
    TextView text13;
    TextView text14;
    TextView text15;
    TextView text16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        //Spinner
        spinner = (Spinner) findViewById(R.id.days);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,no_of_days);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        Bundle data=getIntent().getExtras();
        if(data==null)
        {
            return;
        }
        city_name=data.getString("City_Name");

        databasehelper=new DatabaseHelperPlanner(this);

        Log.d("insert", "inserting data for Place");
        /*databasehelper.save(new Planner("Ahmedabad","2 days","Day 1:","10 :00 am-Sabarmati Ashram (8:30 am- 6:30 pm)- People usually take 2 hours visiting the Ashram.",
                "12:30 pm-Sabarmati River Front (6:00 am-10:00 pm)-People usually spend around half an hour here.","3:00 pm-Adalaj Stepwell (8:00 am– 7:00 pm)- People usually take 30 minutes to 1 hour to visit the Stepwell.","5:30 pm- Akshardham Temple (9:30 am – 7:30 pm)-People usually take 2-3 hours to visit the Temple.","","Day 2:","9:00 am-Kankaria Lake (9:00 am -10:00 pm)- People usually take an hour to visit the Lake.","11:30 am-Hutheesing Jain Temple (8:00 am -8:00 pm)- People usually take around an hour to visit the temple","2:30 pm-Bhadra Fort(9:00 am-5:00pm)-People usually take an hour to visit the Fort."
                ,"5:00 pm-Sarkhej Roja(9:00 am-6:00 pm)-People usually take an hour to visit the lake.","7:00 pm-Auto World Vintage Car Museum (8:00 am-9:00pm)- People spend around one to two hours here.","","",""));

        databasehelper.save(new Planner("Ahmedabad","3 days","Day 1:","10 :00 am-Sabarmati Ashram (8:30 am- 6:30 pm)- People usually take 2 hours visiting the Ashram.",
                "12:30 pm-Sabarmati River Front (6:00 am-10:00 pm)-People usually spend around half an hour here.","3:00 pm-Adalaj Stepwell (8:00 am– 7:00 pm)- People usually take 30 minutes to 1 hour to visit the Stepwell.","","","Day 2:","9:00 am-Kankaria Lake (9:00 am -10:00 pm)- People usually take an hour to visit the Lake.","11:30 am-Hutheesing Jain Temple (8:00 am -8:00 pm)- People usually take around an hour to visit the temple","2:30 pm-Bhadra Fort(9:00 am-5:00pm)-People usually take an hour to visit the Fort."
                ,"5:00 pm-Sarkhej Roja(9:00 am-6:00 pm)-People usually take an hour to visit the lake.","7:00 pm-Auto World Vintage Car Museum (8:00 am-9:00pm)- People spend around one to two hours here.","DAY 3:","10:00 am-Calico Museum of Textiles (10:15 am-12:30 pm (Wednesday Closed))-People usually spend two hours here.","5:30 pm- Akshardham Temple (9:30 am – 7:30 pm)-People usually take 2-3 hours to visit the Temple."));


        databasehelper.save(new Planner("Agra","2 days","Day 1:","10:00 am- Keetham Lake (6:00 am- 6:00 pm)- People spend around 2 to 3 hours here.",
                "3:00 pm-Taj Mahal (8:00 am-5:00 pm (Friday Opened only for prayer))-People spend around 2 hours here.","6:00 pm- Jama Masjid (6:00 am- 8:00 pm)- People spend around 1 to 2 hours.","","","Day 2:","8:00 am- Agra Fort (6:00 am-6:00 pm)-People spend around 2 to 3 hours here.","12:00 pm- Sikandar (Akbar’s Tomb) (6:00 am- 6:00 pm) – People spend around 1 to 2 hours here.","4:00 pm- Fatehpur Sikri (9:00 am- 5:00 pm) – People spend around an hour here."
                ,"6:00 pm- Mehtab Bagh (6:00 am- 7:00 pm)- People spend around an hour here.","","","",""));

        databasehelper.save(new Planner("Agra","3 days","Day 1:","10:00 am- Keetham Lake (6:00 am- 6:00 pm)- People spend around 2 to 3 hours here.",
                "3:00 pm-Taj Mahal (8:00 am-5:00 pm (Friday Opened only for prayer))-People spend around 2 hours here.","6:00 pm- Jama Masjid (6:00 am- 8:00 pm)- People spend around 1 to 2 hours.","","","Day 2:","8:00 am- Agra Fort (6:00 am-6:00 pm)-People spend around 2 to 3 hours here.","12:00 pm- Sikandar (Akbar’s Tomb) (6:00 am- 6:00 pm) – People spend around 1 to 2 hours here.","4:00 pm- Fatehpur Sikri (9:00 am- 5:00 pm) – People spend around an hour here."
                ,"6:00 pm- Mehtab Bagh (6:00 am- 7:00 pm)- People spend around an hour here.","","DAY 3:","8:00 am- Mariam’s Tomb (from Sunrise to Sunset)- People spend around 2 to 3 hours here.","2:00 pm-Ram Bagh (9:00 am- 6:00 pm)-People spend around 2 hours here."));

        databasehelper.save(new Planner("Amritsar","2 days","Day 1:","8:00 am- Golden Temple (4:00 am- 12:00 pm)- People spend around 1 to 2 hours here.",
                "12:00 pm- Jallianwala Bagh (6:30 am – 7:30 pm)-People spend around 1 to 2 hours here.","4:00 pm- Maharaja Ranjit Singh Museum (10:00 am-5:00 pm)-People spend around an hour here.","6:00 pm- Gobindgarh Fort (10:00 am-10:00 pm)-People spend around 1 to 2 hours here.","8:00 pm-Durgiana Temple (6:00 am- 10:00 pm) – People spend around an hour here.","Day 2:","9:00 am- Harike Wetland (Best time to visit during the day)-People spend around 3 hours here. It is about 57 kms from Amritsar.","3:00 PM- Wagah Border (2:00 pm-6:00 pm)-People spend around 3 to 4 hours here.",""
                ,"","","","",""));

        databasehelper.save(new Planner("Amritsar","3 days","Day 1:","8:00 am- Golden Temple (4:00 am- 12:00 pm)- People spend around 1 to 2 hours here.",
                "12:00 pm- Jallianwala Bagh (6:30 am – 7:30 pm)-People spend around 1 to 2 hours here.","4:00 pm- Maharaja Ranjit Singh Museum (10:00 am-5:00 pm)-People spend around an hour here.","6:00 pm- Gobindgarh Fort (10:00 am-10:00 pm)-People spend around 1 to 2 hours here.","","Day 2:","11:00 am- Harike Wetland (Best time to visit during the day)-People spend around 3 hours here. It is about 57 kms from Amritsar.","",""
                ,"","","DAY 3:","9:00 am-Durgiana Temple (6:00 am- 10:00 pm) – People spend around an hour here.","3:00 PM- Wagah Border (2:00 pm-6:00 pm)-People spend around 3 to 4 hours here."));

        databasehelper.save(new Planner("Bangalore","2 days","Day 1:","10:00 am-Bangalore Palace (10:00 am-5:30 pm)-People spend around an hour to an hour and a half here.",
                "1:00 pm- Chunchi Falls (8:00 am-5:00 pm)-People spend around 3 to 4 hours here.","6:00 pm-Bull Temple (6:00 am-12:00 pm and 5:30 pm-9:00 pm)-People spend around 1 to 2 hours here.","","","Day 2:","10:00 am-Lal Bagh (6:00 am-7:00 pm)-People spend around 3 hours here.","4:00 pm-Ulsoor Lake (6:00 am-10:00 pm)-People spend around half an hour to an hour here.","10:00 pm- Skandagiri Trek (Starts at 10:00 pm)-Skandagiri at about 70 kms from Bangalore. 2 hours taken to reach there."
                ,"","","","",""));
        databasehelper.save(new Planner("Bangalore","3 days","Day 1:","10:00 am-Bangalore Palace (10:00 am-5:30 pm)-People spend around an hour to an hour and a half here.",
                "1:00 pm- Chunchi Falls (8:00 am-5:00 pm)-People spend around 3 to 4 hours here.","6:00 pm-Bull Temple (6:00 am-12:00 pm and 5:30 pm-9:00 pm)-People spend around 1 to 2 hours here.","","","Day 2:","10:00 am-Lal Bagh (6:00 am-7:00 pm)-People spend around 3 hours here.","6:00 pm-Ulsoor Lake (6:00 am-10:00 pm)-People spend around half an hour to an hour here.",""
                ,"","","Day 3:","11:00 am-Bannerghatta National Park (9:30 am-5:00 pm)-People spend around an hour here.","10:00 pm- Skandagiri Trek (Starts at 10:00 pm)-Skandagiri at about 70 kms from Bangalore. 2 hours taken to reach there."));

        databasehelper.save(new Planner("Bhopal","2 days","Day 1:","8:00 am-Upper Lake (Sunrise-Sunset)-People spend around an hour here.",
                "9:30 am- Lower Lake (9:00 am-5:00 pm)-People spend around half an hour here.","1:00 pm-Bhojpur Temple (6:00 am-7:00 pm except Mondays)-People spend around an hour here. 28 kms away from Bhopal.","6:00 pm- Taj-ul-Masjid (6:00 am-8:00 pm)-People spend around an hour here.","","Day 2:","8:00 am- Sanchi Stupa (7:00 am-7:00 pm)-People spend around 2 hours here.","12:00 pm-Gohar Mahal (8:00 am-6:00 pm)-People spend around an hour here.","3:00 pm- Bhimbetka Caves (7:00 am-6:00 pm)- People spend around an hour here."
                ,"5:00 pm- Raisen Fort (During day)-People spend more than 3 hours here. 39 kms away from Bhopal.","","","",""));

        databasehelper.save(new Planner("Bhopal","3 days","Day 1:","8:00 am-Upper Lake (Sunrise-Sunset)-People spend around an hour here.",
                "9:30 am- Lower Lake (9:00 am-5:00 pm)-People spend around half an hour here.","1:00 pm-Bhojpur Temple (6:00 am-7:00 pm except Mondays)-People spend around an hour here. 28 kms away from Bhopal.","6:00 pm- Taj-ul-Masjid (6:00 am-8:00 pm)-People spend around an hour here.","","Day 2:","8:00 am- Sanchi Stupa (7:00 am-7:00 pm)-People spend around 2 hours here.","12:00 pm-Gohar Mahal (8:00 am-6:00 pm)-People spend around an hour here.","3:00 pm- Bhimbetka Caves (7:00 am-6:00 pm)- People spend around an hour here."
                ,"5:00 pm- Raisen Fort (During day)-People spend more than 3 hours here. 39 kms away from Bhopal.","","Day 3:","11:00 am-National Museum of Mankind (11:00 am-6:00 pm)-People spend around 2 to 3 hours here.","5:00 pm-Shaukat Mahal & Sadar Manzil (Open 24 hours)-People spend around an hour here."));


        databasehelper.save(new Planner("Bhubaneshwar","2 days","Day 1:","8:00 am-Lingaraj Temple (5:00 am-9:00 pm)- People spend around 1 to 2 hours here.",
                "12:00 pm-Nandankanan zoo (7:30 am-5:30 pm)-People spend around an hour and a half over here.","3:00 pm-Dhauli Giri Shanti Stupa (6:00 am-6:00 pm)-People spend around 1 to 2 hours here.","6:00 pm- Mukteswara Temple (6:30 am-7:30 pm)-People spend around an hour here.","","Day 2:","8:00 am-Udayagiri and Khandagiri Caves (8:00 am-5:00 pm)-People spend around 2 to 3 hours here.","1:00 pm-Orissa State Museum (10:00 am-5:00 pm)-People spend around an hour and a half here.","4:00 pm-Museum of Tribal Art and Artefacts (10:00 am-5:00 pm)-People spend around an hour here."
                ,"6:00 pm-Swargadwar Beach (24 hrs.)- People spend around an hour here.","","","",""));

        databasehelper.save(new Planner("Bhubaneshwar","3 days","Day 1:","8:00 am-Lingaraj Temple (5:00 am-9:00 pm)- People spend around 1 to 2 hours here.",
                "12:00 pm-Nandankanan zoo (7:30 am-5:30 pm)-People spend around an hour and a half over here.","3:00 pm-Dhauli Giri Shanti Stupa (6:00 am-6:00 pm)-People spend around 1 to 2 hours here.","","","Day 2:","8:00 am-Udayagiri and Khandagiri Caves (8:00 am-5:00 pm)-People spend around 2 to 3 hours here.","1:00 pm-Orissa State Museum (10:00 am-5:00 pm)-People spend around an hour and a half here.","4:00 pm-Museum of Tribal Art and Artefacts (10:00 am-5:00 pm)-People spend around an hour here."
                ,"","","Day 3:","11:00 am-Swargadwar Beach (24 hrs.)- People spend around an hour here.","3:00 pm- Mukteswara Temple (6:30 am-7:30 pm)-People spend around an hour here."));

        databasehelper.save(new Planner("Chandigarh","2 days","Day 1:","9:00 am-Sukhna Lake (5:00 am-9:00 pm)-People spend around 1 to 2 hours here.",
                "12:00 pm-Rose Garden (Open 24 hours)-People spend around an hour here.","3:00 pm-The Government Museum and Art Gallery (10 :00 am – 4:45 pm)-People spend around an hour and a half here.","6:00 pm-Pinjore Garden (7:00 am-9:00 pm)-People spend around an hour here.","","Day 2:","9:00 am-Rock Garden (9:00 am-7:30 pm from 1st April to 30th September and 9:00 am-6:00 pm from 1st October to 31st March)-People spend around 3 to 4 hours here.","3:00 pm-Chattbir Zoo (9:00 am-5:00 pm)-People spend around an hour and a half here.","6:00 pm-Terraced Garden (Open 24 hours) –People spend around an hour here."
                ,"","","","",""));

        databasehelper.save(new Planner("Chandigarh","3 days","Day 1:","9:00 am-Sukhna Lake (5:00 am-9:00 pm)-People spend around 1 to 2 hours here.",
                "12:00 pm-Rose Garden (Open 24 hours)-People spend around an hour here.","3:00 pm-The Government Museum and Art Gallery (10 :00 am – 4:45 pm)-People spend around an hour and a half here.","6:00 pm-Pinjore Garden (7:00 am-9:00 pm)-People spend around an hour here.","","Day 2:","9:00 am-Rock Garden (9:00 am-7:30 pm from 1st April to 30th September and 9:00 am-6:00 pm from 1st October to 31st March)-People spend around 3 to 4 hours here.","3:00 pm-Chattbir Zoo (9:00 am-5:00 pm)-People spend around an hour and a half here.","6:00 pm-Terraced Garden (Open 24 hours) –People spend around an hour here."
                ,"","","Day 3:","12:00 pm-Internationals Doll Museum (10:00 am -4:30 pm)-People spend around an hour and a half here.",""));

        databasehelper.save(new Planner("Chennai","2 days","Day 1:","9:00 am-Thousand Lights Mosque (5:30 am-9:00 pm)-People spend around half an hour here.",
                "11:00 am-Marine Beach (24 hours)-People spend around 2 to 3 hours here.","4:00 pm- Pulicat Lake (6:00 am-6:00 pm)-People spend around 1 to 2 hours here.","7:00 pm- Breezy beach (24 hours)-People spend around 1 to 2 hours here.","","Day 2:","8:30 am-The Huddleston Gardens of Theosophical Society (8:30 am - 10:00 am and 2:00 PM - 4:00 PM (Grounds) , 9:30 am-12:30 pm (Bookshop)- All days except Sunday)-People spend around 2 to 3 hours here.","1:00 pm-Arignar Anna Zoological Park (9:00 am-5:45 pm)-People spend around an hour and a half here.","5:00 pm-Kapaleeswarar Temple (5:30 am - 12:00 pm and 5:00 pm - 9:00 pm)-People spend around 2 to 3 hours here."
                ,"","","","",""));

        databasehelper.save(new Planner("Chennai","3 days","Day 1:","9:00 am-Thousand Lights Mosque (5:30 am-9:00 pm)-People spend around half an hour here.",
                "11:00 am-Marine Beach (24 hours)-People spend around 2 to 3 hours here.","4:00 pm- Pulicat Lake (6:00 am-6:00 pm)-People spend around 1 to 2 hours here.","7:00 pm- Breezy beach (24 hours)-People spend around 1 to 2 hours here.","","Day 2:","8:30 am-The Huddleston Gardens of Theosophical Society (8:30 am - 10:00 am and 2:00 PM - 4:00 PM (Grounds) , 9:30 am-12:30 pm (Bookshop)- All days except Sunday)-People spend around 2 to 3 hours here.","1:00 pm-Arignar Anna Zoological Park (9:00 am-5:45 pm)-People spend around an hour and a half here.","5:00 pm-Kapaleeswarar Temple (5:30 am - 12:00 pm and 5:00 pm - 9:00 pm)-People spend around 2 to 3 hours here."
                ,"","","Day 3:","11:00 am-Fort St. George (9:00 am-5:00 pm)-People spend around 3 hours here.",""));

        databasehelper.save(new Planner("Dehradun","2 days","Day 1:","9:00 am-Sahastradhara (8:00 am-7:00 pm)-People spend around 2 to 3 hours here.",
                "2:00 pm-Tiger Falls (Not allowed after 7:00 pm)-People spend around 2 to 3 hours here.","6:00 pm- Mindrolling Monastery (9:00 am-7:00 pm)-People spend around half an hour here.","","","Day 2:","9:00 am-Robber’s Cave (7:00 am-6:00 pm)-People spend around 2 to 3 hours here.","2:00 pm-Malsi Deer Park (10:00 am-6:00 pm)-People spend around an hour here.","6:00 pm-Tapkeshwar Temple (6:00 am-7:00 pm)-People spend around half an hour here."
                ,"","","","",""));
        databasehelper.save(new Planner("Dehradun","3 days","Day 1:","9:00 am-Sahastradhara (8:00 am-7:00 pm)-People spend around 2 to 3 hours here.",
                "2:00 pm-Tiger Falls (Not allowed after 7:00 pm)-People spend around 2 to 3 hours here.","6:00 pm- Mindrolling Monastery (9:00 am-7:00 pm)-People spend around half an hour here.","","","Day 2:","9:00 am-Robber’s Cave (7:00 am-6:00 pm)-People spend around 2 to 3 hours here.","2:00 pm-Malsi Deer Park (10:00 am-6:00 pm)-People spend around an hour here.","6:00 pm-Tapkeshwar Temple (6:00 am-7:00 pm)-People spend around half an hour here."
                ,"","","Day 3:","11:00 am-Forest Research Institute (9:00 am-1:00 pm and 1:30 pm-5:30 pm)-People spend around 2 hours here.",""));

        databasehelper.save(new Planner("Delhi","2 days","Day 1:","8:00 am-Humanyun’s Tomb (Sunrise to Sunset)-People spend around an hour here.",
                "11:00 am-Rashtrapati Bhavan (9:00 am-4:00 pm on Friday, Saturday and Sunday)-People spend around an hour here.","1:00 pm- Rajghat (5:30 am-7:00 pm except Mondays)-People spend around an hour here.","4:00 pm- Dilli Haat (10:30 am-10:00 pm)-People spend around 2 to 3 hours here.","","Day 2:","9:00 am-Lotus Temple (9:00 am-7:00 pm (Summers) and 9:00 am-5:30 pm(Winters) except Mondays)-People spend around 1 to 2 hours here.","12:00 pm-Red Fort (9:30 am-4:30 pm except Mondays)-People spend around 2 to 3 hours here. ","5:00 pm-Qutub Minar (Sunrise to Sunset)-People spend around 2 to 3 hours here."
                ,"10:00 pm-India Gate (5:00 am-12:00 am)-People spend around 1 to 2 hours here.","","","",""));

        databasehelper.save(new Planner("Delhi","3 days","Day 1:","8:00 am-Humanyun’s Tomb (Sunrise to Sunset)-People spend around an hour here.",
                "11:00 am-Rashtrapati Bhavan (9:00 am-4:00 pm on Friday, Saturday and Sunday)-People spend around an hour here.","1:00 pm- Rajghat (5:30 am-7:00 pm except Mondays)-People spend around an hour here.","4:00 pm- Dilli Haat (10:30 am-10:00 pm)-People spend around 2 to 3 hours here.","","Day 2:","9:00 am-Lotus Temple (9:00 am-7:00 pm (Summers) and 9:00 am-5:30 pm(Winters) except Mondays)-People spend around 1 to 2 hours here.","12:00 pm-Red Fort (9:30 am-4:30 pm except Mondays)-People spend around 2 to 3 hours here. ","5:00 pm-Qutub Minar (Sunrise to Sunset)-People spend around 2 to 3 hours here."
                ,"10:00 pm-India Gate (5:00 am-12:00 am)-People spend around 1 to 2 hours here.","","Day 3:","11:00 am-Akshardham Temple (9:30 am -8:00 pm except Mondays. Last entry made by 6:30 pm)- People spend around 6 to 7 hours here.",""));

        databasehelper.save(new Planner("Gangtok","2 days","Day 1:","9:00 am-Tsomgo Lake (Best time to visit during the day)- People spend around 1 to 2 hours here.",
                "12:00 pm-Rumtek Monastery (6:00 am-6:00 pm)- People spend around 2 hours here.","4:00 pm-Do Drul Chorten (8:00 am-6:00 pm)-People spend around 1 hour.","7:00 pm-Seven Sisters Waterfall (24 hours)-People spend around 2 hours here.","","Day 2:","10:00 am-Nathu La Pass (Open for Indian nationals on Wednesday, Thursday, Friday, Saturday and Sundays. Closes at 1:30 pm.)-People spend around an hour here.","12:00 am-Hanuman Tok (7:00 am-5:00 pm)-People spend around half an hour here.","3:00 pm-Seven Sisters Waterfall (24 hours)-People spend around 2 hours here."
                ,"7:00 pm-Phurchachu Hot Springs (24 hours)-People spend around 3 hours here.","","","",""));

        databasehelper.save(new Planner("Gangtok","3 days","Day 1:","9:00 am-Tsomgo Lake (Best time to visit during the day)- People spend around 1 to 2 hours here.",
                "12:00 pm-Rumtek Monastery (6:00 am-6:00 pm)- People spend around 2 hours here.","4:00 pm-Do Drul Chorten (8:00 am-6:00 pm)-People spend around 1 hour.","7:00 pm-Seven Sisters Waterfall (24 hours)-People spend around 2 hours here.","","Day 2:","10:00 am-Nathu La Pass (Open for Indian nationals on Wednesday, Thursday, Friday, Saturday and Sundays. Closes at 1:30 pm.)-People spend around an hour here.","12:00 am-Hanuman Tok (7:00 am-5:00 pm)-People spend around half an hour here.","3:00 pm-Seven Sisters Waterfall (24 hours)-People spend around 2 hours here."
                ,"7:00 pm-Phurchachu Hot Springs (24 hours)-People spend around 3 hours here.","","Day 3:","11:00 am-Ban Jhakri Falls (9:00 am-6:00 pm)- People spend around 2 hours here.","4:00 pm-Kanchenjunga (24 hours)- People spend around 2 hours here."));

        databasehelper.save(new Planner("Goa","2 days","Day 1:","10:00 am-Fort Aguada (9:30 am-6:00 pm)- People spend around 2 hours here.",
                "2:00 pm-Basilica of Bom Jesus (9:00 am-6:30 pm and 10:30 am-6:30 pm on Sundays)- People spend around 1 hour here.","5:00 pm-Dona Paula (6:00 am- 10:00 pm)- People spend around 2 hours here.","","","Day 2:","11:00 am-Dudhsagar Falls (11:00 am-7:00 pm)- People spend around 1 to 2 hours here.","2:00 pm- Chapora fort (10:00 am-5:30 pm)-People spend around an hour here.","4:00 pm- Palolem Beach (6:00 am-10:00 pm)-People spend around 2 to 3 hours here. Visit other beaches like Calangute Beach, Vagator Beach and many more."
                ,"","","","",""));

        databasehelper.save(new Planner("Goa","3 days","Day 1:","10:00 am-Fort Aguada (9:30 am-6:00 pm)- People spend around 2 hours here.",
                "2:00 pm-Basilica of Bom Jesus (9:00 am-6:30 pm and 10:30 am-6:30 pm on Sundays)- People spend around 1 hour here.","5:00 pm-Dona Paula (6:00 am- 10:00 pm)- People spend around 2 hours here.","","","Day 2:","11:00 am-Dudhsagar Falls (11:00 am-7:00 pm)- People spend around 1 to 2 hours here.","2:00 pm- Chapora fort (10:00 am-5:30 pm)-People spend around an hour here.","4:00 pm- Palolem Beach (6:00 am-10:00 pm)-People spend around 2 to 3 hours here. Visit other beaches like Calangute Beach, Vagator Beach and many more."
                ,"","","Day 3:","9:00 am-Arvalem waterfalls (9:00 am-7:00 pm)- People spend around 3 to 4 hours here.","2:00 pm- Visit other beaches like Calangute Beach, Vagator Beach and many more."));

        databasehelper.save(new Planner("Hyderabad","2 days","Day 1:","9:30 am-Charminar (9:30 am-5:30 pm)-People spend around an hour here.",
                "12:00 pm-Hussain Sagar Lake (8:00 am-10:00 pm)- People spend around an hour here.","3:00 pm-Chowmahalla Palace (10:00 am-5:00 pm)-People spend around an hour and a half here.","6:00 pm-Mecca Masjid (4:00 am-9:30 pm)- People spend around 1 to 2 hours here.","","Day 2:","8:00 am-Osman Sagar Lake (7:00 am-7:00 pm)- People spend around 2 to 3 hours here.","12:00 pm-Golkonda Fort (9:00 am-5:30 pm)-People spend around 2 hours here.","3:00 pm- Nizams Museum (10:00 am-5:00 pm)-People spend around an hour and a half here."
                ,"","","","",""));

        databasehelper.save(new Planner("Hyderabad","3 days","Day 1:","9:30 am-Charminar (9:30 am-5:30 pm)-People spend around an hour here.",
                "12:00 pm-Hussain Sagar Lake (8:00 am-10:00 pm)- People spend around an hour here.","3:00 pm-Chowmahalla Palace (10:00 am-5:00 pm)-People spend around an hour and a half here.","6:00 pm-Mecca Masjid (4:00 am-9:30 pm)- People spend around 1 to 2 hours here.","","Day 2:","8:00 am-Osman Sagar Lake (7:00 am-7:00 pm)- People spend around 2 to 3 hours here.","12:00 pm-Golkonda Fort (9:00 am-5:30 pm)-People spend around 2 hours here.","3:00 pm- Nizams Museum (10:00 am-5:00 pm)-People spend around an hour and a half here."
                ,"","","Day 3:","10:00 am-Salar Jung Museum (10:00 am-4:30 pm)-People spend around 2 hours here.","2:00 pm- Paigah Tombs (10:00 am-5:00 pm)- People spend around 2 hours here."));

        databasehelper.save(new Planner("Jaipur","2 days","Day 1:","9:30 am-City Palace (9:30 am-5:00 pm)- People spend around an hour and a half here.",
                "12:00 pm-Hawa Mahal (9:00 am-5:00 pm)- People spend around an hour here.","3:00 pm-Jantar Mantar Observatory (9:00 am- 4:30 pm)-People spend around an hour here.","5:00 pm- Kanak Vrindavan (8:00 am-7:00 pm)- People spend around an hour here.","7:00 pm- Albert Hall Museum (9:00 am- 5:00 pm and 7:00 pm – 9:30 pm)-People spend around an hour here.","Day 2:","11:00 am-Amer Fort (8:00 am-5:30 pm)- People spend around an hour and a half here.","2:00 pm-Jal Mahal (9:00 am- 5:00 pm)-People spend around 1 to 2 hours here.","6:00 pm- Nahargarh Fort (9:00 am-8:00 pm)- People spend around an hour and a half here."
                ,"","","","",""));

        databasehelper.save(new Planner("Jaipur","3 days","Day 1:","9:30 am-City Palace (9:30 am-5:00 pm)- People spend around an hour and a half here.",
                "12:00 pm-Hawa Mahal (9:00 am-5:00 pm)- People spend around an hour here.","3:00 pm-Jantar Mantar Observatory (9:00 am- 4:30 pm)-People spend around an hour here.","5:00 pm- Kanak Vrindavan (8:00 am-7:00 pm)- People spend around an hour here.","7:00 pm- Albert Hall Museum (9:00 am- 5:00 pm and 7:00 pm – 9:30 pm)-People spend around an hour here.","Day 2:","11:00 am-Amer Fort (8:00 am-5:30 pm)- People spend around an hour and a half here.","2:00 pm-Jal Mahal (9:00 am- 5:00 pm)-People spend around 1 to 2 hours here.","6:00 pm- Nahargarh Fort (9:00 am-8:00 pm)- People spend around an hour and a half here."
                ,"","","Day 3:","11:00 am-Jaigarh Fort (10:00 am-5:00 pm)-People spend around an hour here.","5:00 pm-Chokhi Dhani (5:00 pm-11:00 pm)- People spend around 4 to 5 hours here."));

        databasehelper.save(new Planner("Kochi","2 days","Day 1:","9:00 am-The Indo-Portuguese Museum (9:00 am-1:00 pm and 2:00 pm-6:00 pm)- People usually spend around half an hour here.",
                "10:30 am-Paradesi synagogue (10:00 am-5:00 pm)- People usually spend around half an hour here.","12:00 pm-Mattancherry Palace (9:45 am-1:00 pm and 2:00 pm-4:45 pm)- People usually spend around half an hour here.","3:00 pm- Mangalavanam Bird Sanctuary (10:00 am-5:00 pm)- People spend around an hour and a half here.","","Day 2:","9:00 am-Fort Kochi (9:00 am-1:00 pm and 3:00 pm-5:00 pm. On Saturdays: 3:00 pm-6:00 pm)- People usually spend around 3 to 4 hours here.","2:00 pm-Hill Palace (9:00 am- 12:30 pm and 2:00 pm-4:30 pm)- People spend around 1 to 2 hours here.","4:00 pm-Santa Cruz Basilica (7: 00 am-6:30 pm. On Sundays: 8:00 am-6:30 pm)-People spend around 1 to 2 hours here."
                ,"","","","",""));

        databasehelper.save(new Planner("Kochi","3 days","Day 1:","9:00 am-The Indo-Portuguese Museum (9:00 am-1:00 pm and 2:00 pm-6:00 pm)- People usually spend around half an hour here.",
                "10:30 am-Paradesi synagogue (10:00 am-5:00 pm)- People usually spend around half an hour here.","12:00 pm-Mattancherry Palace (9:45 am-1:00 pm and 2:00 pm-4:45 pm)- People usually spend around half an hour here.","3:00 pm- Mangalavanam Bird Sanctuary (10:00 am-5:00 pm)- People spend around an hour and a half here.","","Day 2:","9:00 am-Fort Kochi (9:00 am-1:00 pm and 3:00 pm-5:00 pm. On Saturdays: 3:00 pm-6:00 pm)- People usually spend around 3 to 4 hours here.","2:00 pm-Hill Palace (9:00 am- 12:30 pm and 2:00 pm-4:30 pm)- People spend around 1 to 2 hours here.",""
                ,"","","Day 3:","11:00 am-Bolgatty Palace (Daytime)-People spend around 1 to 2 hours here.","4:00 pm-Santa Cruz Basilica (7: 00 am-6:30 pm. On Sundays: 8:00 am-6:30 pm)-People spend around 1 to 2 hours here."));

        databasehelper.save(new Planner("Kolkata","2 days","Day 1:","9:00 am-Howrah Bridge (24 hours)-People spend around 1 to 2 hours here.",
                "12:00 pm-Mother House (10:00 am–12:30 pm and 3:00 pm–6:00 pm. Closed on Thursdays.)- People spend around an hour here.","3:00 pm-Victoria Memorial (10:00 am- 5:00 pm)- People spend around half an hour here.","4:00 pm- Town Hall (9:00 am-5:00 pm. Closed on Sundays.)- People spend around an hour here.","","Day 2:","10:00 am-Indian Museum (10:00 am - 5:00 pm (March to November), 10:00 am - 4:30 pm (December to February). Closed on Thursdays.)- People spend around 1 to 2 hours here.","2:00 pm-Fort William (10:00 am-5:30 pm)- People spend around 3 to 4 hours here.","7:00 pm- Princep Ghat (Open 24 hours)- People spend around an hour here."
                ,"","","","",""));

        databasehelper.save(new Planner("Kolkata","3 days","Day 1:","9:00 am-Howrah Bridge (24 hours)-People spend around 1 to 2 hours here.",
                "12:00 pm-Mother House (10:00 am–12:30 pm and 3:00 pm–6:00 pm. Closed on Thursdays.)- People spend around an hour here.","3:00 pm-Victoria Memorial (10:00 am- 5:00 pm)- People spend around half an hour here.","4:00 pm- Town Hall (9:00 am-5:00 pm. Closed on Sundays.)- People spend around an hour here.","","Day 2:","10:00 am-Indian Museum (10:00 am - 5:00 pm (March to November), 10:00 am - 4:30 pm (December to February). Closed on Thursdays.)- People spend around 1 to 2 hours here.","2:00 pm-Fort William (10:00 am-5:30 pm)- People spend around 3 to 4 hours here.","7:00 pm- Princep Ghat (Open 24 hours)- People spend around an hour here."
                ,"","","Day 3:","10:00 am-Jorasanko Thakur Bari (10:00 am-4:30 pm)- People spend around 2 to 3 hours here.","2:00 pm-St. Paul's Cathedral (9:00 am-12:00 pm and 3:00 pm-6:00 pm. 7:30 am-6:00 pm on Sundays)- People spend around an hour to an hour and a half here."));

        databasehelper.save(new Planner("Lucknow","2 days","Day 1:","8:00 am-Bara Imambara (6:00 am-5:00 pm)- People spend around an hour here.",
                "11:00 am-Chota Imambara (5:00 am-6:00 pm)- People spend around 2 to 3 hours here.","3:00 pm-Lucknow Zoo (8:00 am-6:00 pm)- People spend around an hour and a half here.","6:00 pm- Jama Masjid (5:00 am-9:00 pm)- People spend around half an hour to an hour here.","","Day 2:","10:00 am-1857 Memorial Museum (10:00 am-5:00 pm. Closed on Sundays)- People spend around 2 to 3 hours here.","3:00 pm-British Residency (7:00 am-6:00 pm)- People spend around 2 hours here.","6:00 pm-Rumi Darwaza (24 hours)-People spend around half an hour to an hour here."
                ,"","","","",""));

        databasehelper.save(new Planner("Lucknow","3 days","Day 1:","8:00 am-Bara Imambara (6:00 am-5:00 pm)- People spend around an hour here.",
                "11:00 am-Chota Imambara (5:00 am-6:00 pm)- People spend around 2 to 3 hours here.","3:00 pm-Lucknow Zoo (8:00 am-6:00 pm)- People spend around an hour and a half here.","6:00 pm- Jama Masjid (5:00 am-9:00 pm)- People spend around half an hour to an hour here.","","Day 2:","10:00 am-1857 Memorial Museum (10:00 am-5:00 pm. Closed on Sundays)- People spend around 2 to 3 hours here.","3:00 pm-British Residency (7:00 am-6:00 pm)- People spend around 2 hours here.","6:00 pm-Rumi Darwaza (24 hours)-People spend around half an hour to an hour here."
                ,"","","Day 3:","12:00 pm-Dr Amedkar Park (11:00 am-9:00 pm)- People spend around an hour here.","3:00 pm-Chattar Manzil (8:00 am-6:00 pm)- People spend around an hour and a half here."));


        databasehelper.save(new Planner("Mumbai","2 days","Day 1:","10:00 am-Marine Drive (24 hours)- People spend around 3 hours here.",
                "3:00 pm-Gateway of India (24 hours)- People spend around 2 hours here.","6:00 pm-Juhu Beach (24 hours)- People spend around 1 to 2 hours here.","","","Day 2:","9:00 am-Elephanta Caves (9:00 am-5:00 pm)- People spend around 4 to 5 hours here.","3:00 pm-Kanheri Caves (7:30 am-5:00 pm)- People spend around half an hour here.","4:30 pm-Prince of Waes Museum (10:15 am-6:00 pm)- People spend around an hour and a half here."
                ,"","","","",""));

        databasehelper.save(new Planner("Mumbai","3 days","Day 1:","10:00 am-Marine Drive (24 hours)- People spend around 3 hours here.",
                "3:00 pm-Gateway of India (24 hours)- People spend around 2 hours here.","6:00 pm-Juhu Beach (24 hours)- People spend around 1 to 2 hours here.","","","Day 2:","9:00 am-Elephanta Caves (9:00 am-5:00 pm)- People spend around 4 to 5 hours here.","3:00 pm-Kanheri Caves (7:30 am-5:00 pm)- People spend around half an hour here.","4:30 pm-Prince of Waes Museum (10:15 am-6:00 pm)- People spend around an hour and a half here."
                ,"","","Day 3:","9:00 am-Sanjay Gandhi National Park (7:30 am-6:30 pm. Closed on Mondays)- People spend around 3 to 4 hours here.","4:00 pm-Banganga Tank (24 hours)- People spend around two and a half hours here."));

        databasehelper.save(new Planner("Patna","2 days","Day 1:","10:00 am-Kumrahar (9:00 am-5:00 pm. Closed on Mondays)- People spend around 2 hours here.",
                "1:00 pm-Patna Museum (10:00 am-4:30 pm)- People spend around 1 to 2 hours here.","4:00 pm-Golghar (9:30 am-6:00 pm)- People spend around an hour and a half here.","","","Day 2:","9:00 am-Patna Zoo (8:00 am-5:30 pm)- People spend around an hour and a half here.","12:00 pm-Nalanda University (9:00 am-5:00 pm)- People spend around 1 to 2 hours here.","3:00 pm-Kesaria Stupa (6:00 am-6:00 pm)- People spend around 2 to 3 hours here."
                ,"7:00 pm- Begu Hajjam’s Mosque (6:00 am-8:00 pm)- People spend around half an hour to an hour.","","","",""));

        databasehelper.save(new Planner("Patna","3 days","Day 1:","10:00 am-Kumrahar (9:00 am-5:00 pm. Closed on Mondays)- People spend around 2 hours here.",
                "1:00 pm-Patna Museum (10:00 am-4:30 pm)- People spend around 1 to 2 hours here.","4:00 pm-Golghar (9:30 am-6:00 pm)- People spend around an hour and a half here.","","","Day 2:","9:00 am-Patna Zoo (8:00 am-5:30 pm)- People spend around an hour and a half here.","12:00 pm-Nalanda University (9:00 am-5:00 pm)- People spend around 1 to 2 hours here.","3:00 pm-Kesaria Stupa (6:00 am-6:00 pm)- People spend around 2 to 3 hours here."
                ,"7:00 pm- Begu Hajjam’s Mosque (6:00 am-8:00 pm)- People spend around half an hour to an hour.","","Day 3:","11:00 am-Agam Kuan (During days)- People spend around 1 to 2 hours here.","3:00 pm-Sanjay Gandhi Jaivik Udyan (8:00 am-5:30 pm)- People spend around one and a half hour here."));

        databasehelper.save(new Planner("Pune","2 days","Day 1:","10:00 am-Shanivar Wada (8:00 am-6:30 pm)- People spend around 1 hour here.",
                "1:00 pm-Aga Khan Palace (9:00 am-5:30 pm)- People spend around 1 hour here.","4:00 pm-Sinhagad Fort (6:00 am-6:00 pm)- People spend around 2 hours here.","","","Day 2:","9:00 am-Pataleshwar Cave Temple (8:30 am-5:30 pm)- People spend around 1 to 2 hours here.","12:00 pm-Rajiv Gandhi Zoological Park (9:30 am-6:00 pm)- People spend around an hour and a half here.","3:00 pm-Mulshi Dam (9:00 am-6:00 pm)- People spend around 1 to 2 hours here."
                ,"","","","",""));

        databasehelper.save(new Planner("Pune","3 days","Day 1:","10:00 am-Shanivar Wada (8:00 am-6:30 pm)- People spend around 1 hour here.",
                "1:00 pm-Aga Khan Palace (9:00 am-5:30 pm)- People spend around 1 hour here.","4:00 pm-Sinhagad Fort (6:00 am-6:00 pm)- People spend around 2 hours here.","","","Day 2:","9:00 am-Pataleshwar Cave Temple (8:30 am-5:30 pm)- People spend around 1 to 2 hours here.","12:00 pm-Rajiv Gandhi Zoological Park (9:30 am-6:00 pm)- People spend around an hour and a half here.","3:00 pm-Mulshi Dam (9:00 am-6:00 pm)- People spend around 1 to 2 hours here."
                ,"","","Day 3:","11:00 am-Lohagarh Fort (9:00 am-6:00 pm)- People spend around 3 to 4 hours here.","5:00 pm-Khadakwasla Dam (24 hours)- People spend around an hour and a half here."));

        databasehelper.save(new Planner("Shillong","2 days","Day 1:","10:00 am-Elephant Caves (10:00 am-6:00 pm)- People spend around half an hour to an hour here.",
                "1:00 pm-Don Bosco Museum (9:00 am-5:30 pm)- People spend around an hour and a half here.","4:00 pm-Sweet Falls (24 hours)- People spend around an hour here.","","","Day 2:","10:00 am-Shillong Peak (9:00 am-3:30 pm)- People spend around half an hour here.","12:00 pm-Ward’s Lake (November to February: 8:30 am - 5:30 pm and March to October: 8:30 am - 7:00 pm)- People spend around 1 to 2 hours here.","3:00 pm-Umiam Lake (9:00 am-5:00 pm)- People spend around 1 to 2 hours here."
                ,"6:00 pm-Mawlynnong (24 hours)- People spend around 1 to 2 hours here.","","","",""));

        databasehelper.save(new Planner("Shillong","3 days","Day 1:","10:00 am-Elephant Caves (10:00 am-6:00 pm)- People spend around half an hour to an hour here.",
                "1:00 pm-Don Bosco Museum (9:00 am-5:30 pm)- People spend around an hour and a half here.","4:00 pm-Sweet Falls (24 hours)- People spend around an hour here.","","","Day 2:","10:00 am-Shillong Peak (9:00 am-3:30 pm)- People spend around half an hour here.","12:00 pm-Ward’s Lake (November to February: 8:30 am - 5:30 pm and March to October: 8:30 am - 7:00 pm)- People spend around 1 to 2 hours here.","3:00 pm-Umiam Lake (9:00 am-5:00 pm)- People spend around 1 to 2 hours here."
                ,"6:00 pm-Mawlynnong (24 hours)- People spend around 1 to 2 hours here.","","Day 3:","11:00 am-David Scott Trail (During Day)- People spend more than 3 hours here.","5:00 pm-Spread Eagle Falls (10:00 am-6:00 pm)- People spend around half an hour here."
                ));

        databasehelper.save(new Planner("Simla","2 days","Day 1:","10:00 am-Annandale (9:00 am-2:00 pm)- People spend around 2 hours here.",
                "2:00 pm-Jakhoo Hill (7:00 am-8:00 pm)- People spend around 1 to 2 hours here.","5:00 pm-Summer Hills (24 hours)- People spend around 1 to 2 hours here.","8:00 pm- The Scandal Point, Ridge (6:00 am-8:00 pm)- People spend around 2 hours here.","","Day 2:","10:00 am- Chail (10:00 am-10:00 pm)- People spend around 2 to 3 hours here.","3:00 pm-Chadwick Falls (Sunrise to Sunset)- People spend around 3 to 4 hours here.",""
                ,"","","","",""));

        databasehelper.save(new Planner("Simla","3 days","Day 1:","10:00 am-Annandale (9:00 am-2:00 pm)- People spend around 2 hours here.",
                "2:00 pm-Jakhoo Hill (7:00 am-8:00 pm)- People spend around 1 to 2 hours here.","5:00 pm-Summer Hills (24 hours)- People spend around 1 to 2 hours here.","8:00 pm- The Scandal Point, Ridge (6:00 am-8:00 pm)- People spend around 2 hours here.","","Day 2:","10:00 am- Chail (10:00 am-10:00 pm)- People spend around 2 to 3 hours here.","3:00 pm-Chadwick Falls (Sunrise to Sunset)- People spend around 3 to 4 hours here.",""
                ,"","","Day 3:","10:00 am-The Shimla State Museum (10:00 am-5:00 pm. Closed on Mondays)- People spend around 2 hours here.","2:00 pm-Reserve Forest Sanctuary, Mashobra (9:00 am-6:00 pm)- People spend around 4 to 5 hours here."));

        databasehelper.save(new Planner("Srinagar","2 days","Day 1:","8:00 am-Dal Lake (6:00 am-6:00 pm)- People spend around 2 to 3 hours here.",
                "2:00 pm-Mughal Gardens (9:00 am-6:00 pm)- People spend around 3 hours here.","6:00 pm- Betaab Valley (8:00 am-7:00 pm)- People spend around half an hour here.","","","Day 2:","9:30 am-Hazratbal Mosque (9:30 am-5:30 am)- People spend around 2 to 3 hours here.","3:00 pm-Nishat Bagh (9:00 am-7:00 pm)- People spend around 2 to 3 hours here.",""
                ,"","","","",""));

        databasehelper.save(new Planner("Srinagar","3 days","Day 1:","8:00 am-Dal Lake (6:00 am-6:00 pm)- People spend around 2 to 3 hours here.",
                "2:00 pm-Mughal Gardens (9:00 am-6:00 pm)- People spend around 3 hours here.","6:00 pm- Betaab Valley (8:00 am-7:00 pm)- People spend around half an hour here.","","","Day 2:","9:30 am-Hazratbal Mosque (9:30 am-5:30 am)- People spend around 2 to 3 hours here.","3:00 pm-Nishat Bagh (9:00 am-7:00 pm)- People spend around 2 to 3 hours here.",""
                ,"","","Day 3:","7:00 am-Dachigam National Park (Summer: 5.30 am - 6.30 pm, Winter: 5.30 am - 6.30 pm)- People spend more than 3 hours here.","1:00 pm-Wular Lake (Daytime)- People spend around 2 to 3 hours here."));

        databasehelper.save(new Planner("Trivandrum","2 days","Day 1:","9:00 am-Sri Padmanabhaswamy Temple (3:30 am - 5:00 am, 6:30 am - 7:00 am, 8:30 am - 10:00 am, 10:30 am - 11:10 am, 11:45 am- 12:00 am. Closed on Saturdays and Sundays.)- People spend around an hour here.",
                "12:00 pm-Neyyar Dam and Wildlife Sanctuary (9:00 am-4:00 pm)- People spend around 3 hours here.","6:00 pm- The Kanakakunnu Palace (6:00 am-9:00 pm)- People spend around an hour and a half here.","","","Day 2:","10:00 am-The Napier Museum (10:00 am-5:00 pm)- People spend around an hour here.","12:00 pm-The Zoological Park (9:00 am-5:15 pm. Closed on Mondays)- People spend around two and a half hours here.","5:00 pm-Poovar Island (12:00 am-12:00 pm)- People spend around an hour here."
                ,"","","","",""));

        databasehelper.save(new Planner("Trivandrum","3 days","Day 1:","9:00 am-Sri Padmanabhaswamy Temple (3:30 am - 5:00 am, 6:30 am - 7:00 am, 8:30 am - 10:00 am, 10:30 am - 11:10 am, 11:45 am- 12:00 am. Closed on Saturdays and Sundays.)- People spend around an hour here.",
                "12:00 pm-Neyyar Dam and Wildlife Sanctuary (9:00 am-4:00 pm)- People spend around 3 hours here.","6:00 pm- The Kanakakunnu Palace (6:00 am-9:00 pm)- People spend around an hour and a half here.","","","Day 2:","10:00 am-The Napier Museum (10:00 am-5:00 pm)- People spend around an hour here.","12:00 pm-The Zoological Park (9:00 am-5:15 pm. Closed on Mondays)- People spend around two and a half hours here.","5:00 pm-Poovar Island (12:00 am-12:00 pm)- People spend around an hour here."
                ,"","","Day 3:","10:00 am-Sri Chitra Art Gallery (10:00 am-4:45 pm. Mondays Closed)- People spend around 2 to 3 hours here.","4:00 pm-Shanghumukham Beach (Sunrise to Sunset)- People spend around 1 to 2 hours here."));

        databasehelper.save(new Planner("Udaipur","2 days","Day 1:","9:30 am-City Palace (9:30 am-5:30 am)- People spend around 3 hours here.",
                "2:00 pm-Lake Pichola (24 hours)- People spend around 2 hours here.","5:00 pm-Jag Mandir (10:00 am-6:00 pm)- People spend around an hour here.","7:00 pm- Ambrai Ghat (24 hours)- People spend around an hour here.","","Day 2:","8:00 am-Lake Fatehsagar (8:00 am-4:30 pm)- People spend around an hour here.","10:00 am-Saheliyon Ki Bari (8:00 am-8:00 pm)- People spend around an hour here.","12:00 pm-Kumbhalgarh Fort (9:00 am-5:00 pm)- People spend around an hour and a half here."
                ,"3:00 pm-Monsoon Palace (10:00 am-6:30 pm)- People spend around an hour here.","","","",""));

        databasehelper.save(new Planner("Udaipur","3 days","Day 1:","9:30 am-City Palace (9:30 am-5:30 am)- People spend around 3 hours here.",
                "2:00 pm-Lake Pichola (24 hours)- People spend around 2 hours here.","5:00 pm-Jag Mandir (10:00 am-6:00 pm)- People spend around an hour here.","7:00 pm- Ambrai Ghat (24 hours)- People spend around an hour here.","","Day 2:","8:00 am-Lake Fatehsagar (8:00 am-4:30 pm)- People spend around an hour here.","10:00 am-Saheliyon Ki Bari (8:00 am-8:00 pm)- People spend around an hour here.","12:00 pm-Kumbhalgarh Fort (9:00 am-5:00 pm)- People spend around an hour and a half here."
                ,"3:00 pm-Monsoon Palace (10:00 am-6:30 pm)- People spend around an hour here.","","Day 3:","10:00 am-Ahar Museum (10:00 am-5:00 pm)- People spend around an hour and a half here.","3:00 pm-Bagore Ki Haveli (10:00 am-5:30 pm)- People spend around 2 hours here."));
*/

        Log.d("reading", "reading all data");
        List<Planner> listplann = databasehelper.findAll();
        for (Planner b : listplann) {
            Log.d("data", "ID :" + b.getId() + " | City :" + b.getCity() + " | Days :" + b.getDay());
        }





    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), no_of_days[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }

    public void gototravelinfo(View view)
    {
        Intent i=new Intent(this,Activity_3.class);
        i.putExtra("Message",city_name);
        startActivity(i);
    }

    public void gotonextpage(View view)
    {

        noofdays=spinner.getSelectedItem().toString();

        Planner planner = databasehelper.findOne(city_name,noofdays);

        text2=(TextView)findViewById(R.id.text2);
        text3=(TextView)findViewById(R.id.text3);
        text4=(TextView)findViewById(R.id.text4);
        text5=(TextView)findViewById(R.id.text5);
        text6=(TextView)findViewById(R.id.text6);
        text7=(TextView)findViewById(R.id.text7);
        text8=(TextView)findViewById(R.id.text8);
        text9=(TextView)findViewById(R.id.text9);
        text10=(TextView)findViewById(R.id.text10);
        text11=(TextView)findViewById(R.id.text11);
        text12=(TextView)findViewById(R.id.text12);
        text13=(TextView)findViewById(R.id.text13);
        text14=(TextView)findViewById(R.id.text14);
        text15=(TextView)findViewById(R.id.text15);
        text16=(TextView)findViewById(R.id.text16);
        text2.setText(planner.getOne_view());
        text3.setText(planner.getTwo_view());
        text4.setText(planner.getThree_view());
        text5.setText(planner.getFour_view());
        text6.setText(planner.getFive_view());
        text7.setText(planner.getSix_view());
        text8.setText(planner.getSeven_view());
        text9.setText(planner.getEight_view());
        text10.setText(planner.getNine_view());
        text11.setText(planner.getTen_view());
        text12.setText(planner.getEleven_view());
        text13.setText(planner.getTwelve_view());
        text14.setText(planner.getThirteen_view());
        text15.setText(planner.getFourteen_view());
        text16.setText(planner.getFifteen_view());
    }
}
