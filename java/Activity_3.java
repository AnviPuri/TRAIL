package com.anvipuri.trail;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Activity_3 extends AppCompatActivity implements View.OnClickListener {

    //private ListView listplace;
    private DatabaseHelper databaseHelper;
    //private ArrayAdapter adapter;
    String Message;
    TextView text1;
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
    TextView text17;
    TextView text18;
    TextView text19;
    TextView text20;
    TextView text21;
    TextView text22;
    TextView text23;
    TextView text24;
    TextView text25;
    Button onclick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        databaseHelper= new DatabaseHelper(this);

        Bundle data=getIntent().getExtras();
        if(data==null)
        {
            return;
        }
        Message=data.getString("Message");

        Bundle data2=getIntent().getExtras();
        if(data2==null)
        {
            return;
        }
        Message=data.getString("Message");

        Log.d("insert", "inserting data for Place");

/*
        databaseHelper.save(new Place("Ahmedabad","Gujarat","Gujarati,Hindi,English","The climate is usually hot and dry apart from the monsoon season which is very humid","Consists mainly of Vegetarian food.Gujarati thali is very famous around the city.","Uttarayan, Navratras,Ganesh Chaturthi. A lot of fairs and festivals are conducted as well.","Transportation within the city is very convenient. Some of the options include hiring private taxis, rickshaws for short distances and buses which have very nominal rates."));
        databaseHelper.save(new Suggestion("Ahmedabad","Sabarmati Ashram", "Adalaj Stepwell","Kankaria Lake","Akshardham Temple","Hutheesing Jain Temple","Sabarmati River Front","Bhadra Fort","Sarkhej Roja","Auto World Vintage Car Museum","Calico Museum of Textiles"));

        databaseHelper.save(new Place("Agra","Uttar Pradesh","Hindi,Urdu,Punjabi,English","Hot and dry summers along with mild monsoon and mild winters ","The city is famous for the Mughal cuisine. Pethas from Agra are also very  famous around the country.","Taj Mahotsav, Ram Barat,Taj Literature Festival,Kailash Fair,Gangaur Fair","Buses, Rickshaws and auto rickshaws. One has to take a Tonga a few kilometres away from Taj Mahal."));
        databaseHelper.save(new Suggestion("Agra","Taj Mahal","Agra Fort","Fatehpur Sikri","Sikandar(Akbar’s Tomb)","Jama Masjid","Mariam’s Tomb","Keetham Lake","Mughal Heritage Walk","Ram Bagh","Mehtab Bagh"));

        databaseHelper.save(new Place("Amritsar","Punjab","Punjabi,Hindi,Urdu,English","Summer from April to June, monsoon from July to September, post monsoon from October to November and winter from December to March.","The city is famous for its spicy and rich food. Non Vegetarian food and Milk based foods are a speciality.","Ram Tirath Fair, Baisakhi, Guru Parb, Hola Mohalla.","Rickshaws, Auto Rickshaws and City Bus Service."));
        databaseHelper.save(new Suggestion("Amritsar","Golden Temple","Jallianwala Bagh","Durgiana Temple","Wagah Border","Gobindgarh Fort","Akal Takht","Maharaja Ranjit Singh Museum","Harike Wetland","Model Town Temple","Tarn Taran"));

        databaseHelper.save(new Place("Bangalore","Karnataka","Kannada,English","Moderate climate throughout the year","A diverse food culture.","Ganesh Chaturthi,Pongal,Groundnut Fair,Travel and Tourism Fair,Karaga Festival.","Bus, Taxi and Auto Rickshaws."));
        databaseHelper.save(new Suggestion("Bangalore","Bangalore Palace","MG Road","Lal Bagh","Bull Temple","Ulsoor Lake","Chunchi Falls","Skandagiri","Avani village","Bannerghatta National Park","Kolar(Town)"));

        databaseHelper.save(new Place("Bhopal","Madhya Pradesh","Hindi,English,Urdu.","Hot summers, humid monsoon and cold dry winters.","The cuisine includes both vegetarian and non-vegetarian mouth-watering delicacies like keemas, Rogan josh, kebabs, pulao and a lot more.","Lokrang Festival,Dhrupad Samaroh,Rashtriya Hindi Natya Samaroh,Alauddin Khan Vyakhyanmala,Rashtriya Alankaran Samaroh,Bharat Bhawan,Film Festival.","Buses, Autos and Tempos for cheap travel. Taxis for day trips."));
        databaseHelper.save(new Suggestion("Bhopal","Upper Lake and Lower Lake","Bhojpur Temple","National Museum of Mankind","State Archaeological Museum","Sanchi Stupa","Taj-ul-Masjid","Gohar Mahal","Shaukat Mahal & Sadar Manzil","Raisen Fort","Bhimbetka Caves"));

        databaseHelper.save(new Place("Bhubaneshwar","Odisha","Hindi,English,Oriya.","Tropical Climate with less rainfall in winters as compared to summers.","Various Oriyan delicacies. Mostly vegetarian but non vegetarian food can be found as well.","Makar Mela,Megha Mela,Taratarini Mela,Ashokastami.","Buses,auto-rickshaws,cycle rickshaws and Taxis"));
        databaseHelper.save(new Suggestion("Bhubaneshwar","Lingaraj Temple","Nandankanan zoo","Dhauli Giri Shanti Stupa","Udayagiri and Khandagiri Caves","Orissa State Museum","Museum of Tribal Art and Artefacts","Dhauli Giri","Swargadwar Beach","Mukteswara Temple","Hirapur Village"));

        databaseHelper.save(new Place("Chandigarh","Punjab,Haryana","English,Hindi,Punjabi","Humid climate with hot summers, mild winters and heavy rainfall. A great variation in temperature throughout the year.","Traditional Punjabi food including both vegetarian and non-vegetarian cuisine.","Baisakhi,Lohri,Holla Mohalla,Gurpurab,Teeyan,The Festival of Gardens,The Mango Festival,The Chrysanthemums Show,The Plaza Carnival","Bus services and rickshaws.Taxis preferable for day trips."));
        databaseHelper.save(new Suggestion("Chandigarh","Sukhna Lake","Rose Garden and Leisure Valley","Rock Garden","The Government Museum and Art Gallery","Chattbir Zoo","Terraced Garden","Punjab Kala Kendra","Forest Reserves","Pinjore Garden","Internationals Doll Museum"));

        databaseHelper.save(new Place("Chennai","Tamil Nadu","English,Tamil,Telugu.","Tropical climate experiencing seasons of summers, monsoon and moderate winters.","Home to vegetarian and non-vegetarian south Indian delicacies. Famous for its filtered coffee as well.","Natyanjali Dance Festival,Dance and Music Festival,Travel and Tourism Fair,Pongal.","Bus,Taxi,Auto Rickshaw and Local Train."));
        databaseHelper.save(new Suggestion("Chennai","Thousand Lights Mosque","Marine Beach","The Huddleston Gardens of Theosophical Society","Arignar Anna Zoological Park","Pulicat Lake","Kapaleeswarar Temple","Breezy Beach","Little Mount Shrine","Fort St. George","Ubbalamadugu Falls"));

        databaseHelper.save(new Place("Dehradun","Uttarakhand","Hindi,Garhwali,English","Heavy rainfall in monsoon, severely cold in winters and hot in summers.","Local cuisine with milk and milk products as the main ingredients, Street Food.","Tapkeshwar Mela,Laxman Sidhha Fair,Bissu Fair,Lakhawar Fair, Neelkanth Mahadev Fair,Mahasu Devta's Fair,Jhanda Fair","Buses,Taxis,Private cars,Tongas,Tempos and Auto Rickshaws"));
        databaseHelper.save(new Suggestion("Dehradun","Sahastradhara","Tiger Falls","Pindari Glacier","Clement town","Robber’s Cave","Mindrolling Monastery","Forest Research Institute","Lachhiwala","Malsi Deer Park","Tapkeshwar Temple"));

        databaseHelper.save(new Place("Delhi","The National Capital Territory of Delhi","Hindi,English,Punjabi,Urdu.","Hot summers, average rainfall in monsoons and cold winters.","Offers a diverse cuisine from all states of India.","India International Trade Fair,Delhi Auto Expo,Surajkund Crafts Mela,Phoolwalon Ki Sair,Delhi Book Fair,Mango Festival,Qutub Festival,Garden Tourism Festival Delhi","Buses,Auto Rickshaws,Metro and taxis can be hired for day trips."));
        databaseHelper.save(new Suggestion("Delhi","Akshardham Temple","Lotus Temple","Red Fort and Chandini Chowk","Hauz Khas Village and Deer Park. Dilli Haat. Connaught Place and shopping markets like Lajpat Nagar, Saojini Market and various malls throughout the city.","Humanyun’s Tomb","India Gate","Qutub Minar","Rashtrapati Bhavan","Rajghat","Tughlaqabad Fort"));

        databaseHelper.save(new Place("Gangtok","Sikkim","English,Nepali,Hindi.","Heavy rainfall in monsoon, summers are pleasant and is considered to be the best time to visit the place. No snowfall in winters.","Authentic local cuisine including momos,thupkas,chang and much more.Tibetan and Indo- Chinese cuisines are also popular.","Lasor Festival,Red Panda Winter Festival,Christmas at Gangtok.","Local Buses and Taxis."));
        databaseHelper.save(new Suggestion("Gangtok","Tsomgo Lake","Rumtek Monaestry","Do Drul Chorten","Nathu La Pass and Hnuman Tok","Seven Sisters Waterfall","Phurchachu Hot Springs","MG Road","Ban Chakri Falls","Kanchenjunga","Kabi Longstok"));

        databaseHelper.save(new Place("Goa","Goa","Konkani,Marathi,English,Hindi","Hot and humid summers.Heavy monsoon and a cool pleasant weather from December to February.","Goan cuisine.","Shigmotsav,Goa Heritage Festival,Bonderam,Sea Food Festival,Monte Music Festival,Kesarbai Kerkar Music Festival,Annual Mando festival,Fontainhas Festival of Arts","Taxi,Self-Drive by hiring cars and bikes,Buses."));
        databaseHelper.save(new Suggestion("Goa","Fort Aguada","Basilica of Bom Jesus","Dudhsagar Falls","Dona Paula","Old Goa Churches & its History","Bicholim","Various beaches like Palolem Beach, Calangute Beach, Vagator Beach and many more beaches.","Pandava cave complex and Arvalem waterfalls","Chapora fort","Casinos in North Goa"));

        databaseHelper.save(new Place("Hyderabad","Telangana,de jure capital of Andhra Pradesh","Telegu,Urdu,English,Hindi.","Hot and humid summers,Heavy rainfall from June to September and cool temperatures in December and January.","Deccani cuisine","Deccan Festival,Ugadi Festival,Lumbini Festival","Railways and Buses.Auto Rickshaws and Taxis."));
        databaseHelper.save(new Suggestion("Hyderabad","Charminar","Hussain Sagar Lake","Chowmahalla Palace","Osman Sagar Lake","Mecca Masjid","Golkonda Fort","Salar Jung Museum","Nizams Museum","Falaknuma Palace","Paigah Tombs"));

        databaseHelper.save(new Place("Jaipur","Rajasthan","Hindi,Rajasthani,Marwari,English,Dhundari.","High temperatures during summers, Heavy rains in monsoon, pleasant temperature in winter months.","Rajasthani cuisine. The city is known for its sweets.","Gangaur Festival,Kite Festival,Elephant Festival,Jaipur Literature Festival,Teej Festival.","Buses,Taxis,Auto Rickshaws and Metro."));
        databaseHelper.save(new Suggestion("Jaipur","City Palace","Hawa Mahal","Jantar Mantar Observatory","Albert Hall Museum","Amer Fort","Jal Mahal","Jaigarh Fort","Nahargarh Fort","Kanak Vrindavan","Chokhi Dhani"));

        databaseHelper.save(new Place("Kochi","Kerala","Malyalam,English","Tropical  monsoon climate.","Keralite cuisine.Apart from that other South Indian cuisines and Chinese cuisines are also popular.","Cochin Carnival,Indira Gandhi Boat Race,Malayatoor Perunal,Jewish Festivals,Utsavam.","Auto Rickshaws,Buses,Taxis and Ferry Rides."));
        databaseHelper.save(new Suggestion("Kochi","The Indo-Portuguese Museum","Paradesi synagogue","Mattancherry Palace","Kerala Folklore Theatre and Museum","Fort Kochi","Santa Cruz Basilica","Veeranpuzha Beach","Hill Palace","Mangalavanam Bird Sanctuary","Bolgatty Palace"));

        databaseHelper.save(new Place("Kolkata","West Bengal","Bengali,English,Hindi.","Hot and humid summers, monsoon and pleasant winters.","Bengali cuisine with the main highlight being rice and fish curry known as machher jhol. Sweets like mishti dohi,sandesh,roshogolla and many more are also very famous.","Durga Puja,Kali Puja,Rath Yatra,Kolkata Book Fair,National Theatre Festival,Jatra Festival.","Kolkata Suburban Railway,Metro,trams,Taxis,Buses"));
        databaseHelper.save(new Suggestion("Kolkata","Howrah Bridge","Mother House","Victoria Memorial","Indian Museum","Prinsep Ghat","Fort William","Town Hall","Jorasanko Thakur Bari","St. Paul's Cathedral","Sabarna Sangrahashala"));

        databaseHelper.save(new Place("Lucknow","Uttar Pradesh","Hindi,Urdu,English","Hot and dry summers, cool and dry winters with average rainfall in monsoon.","Awadhi cuisine","Lucknow Festival,Vrindavan Sharadotsav,Book Fair.","Buses,Auto Rickshaws,Taxis."));
        databaseHelper.save(new Suggestion("Lucknow","Bara Imambara","Chota Imambara","Lucknow Zoo","Jama Masjid","Rumi Darwaza","British Residency","Heritage Walk","1857 Memorial Museum","Dr Amedkar Park","Chattar Manzil"));

        databaseHelper.save(new Place("Mumbai","Maharashtra","Hindi,English,Marathi.","Tropical wet and dry climate.","Maharashtrian food,Street Food.","Elephanta Festival,Bnaganga Festival, Ganesh Chaturthi, Kala Ghoda Festival, Gudi Padwa.","Bus,Railway Network,Metro,Monorail,Trams,Taxis,Auto Rickshaws."));
        databaseHelper.save(new Suggestion("Mumbai","Marine Drive","Gateway of India","Juhu Beach","Elephanta Caves","Prince of Waes Museum","Kanheri Caves","Sanjay Gandhi National Park","Banganga Tank","Mahakali Caves","Haji Ali Dargah"));

        databaseHelper.save(new Place("Patna","Bihar","Hindi,English.","Extremely hot summers, average monsoon and cold winters.","Bihari cuisine which is predominantly vegetarian","Sonepur Mela,Kite Festival,Pitrapaksha Mela,Chatth Puja.","Buses,Auto Rickshaws,Local Trains,Taxis."));
        databaseHelper.save(new Suggestion("Patna","Kumrahar","Patna Museum","Golghar","Patna Zoo","Nalanda University","Agam Kuan","Sun Temple","Begu Hajjam’s Mosque","Kesaria Stupa","Sanjay Gandhi Jaivik Udyan"));

        databaseHelper.save(new Place("Pune","Maharashtra","Marathi,English,Hindi.","Hot and humid in May and June, Heavy rainfall from July to September.Best time to visit is from October to February when the weather is pleasant.","Maharashtrian cuisine.","Pune Festival,Shivaji Maharaj Jayanti,Chaturshringi Fair,Gudi Padwa,Pola.","Local Trains,Metro,Buses,Auto Rickshaws,Taxis."));
        databaseHelper.save(new Suggestion("Pune","Shanivar Wada","Aga Khan Palace","Sinhagad Fort","Pataleshwar Cave Temple","Rajiv Gandhi Zoological Park","Mulshi Dam","Khadakwasla Dam","Lohagarh Fort","Vetal Hill","Osho Ashram"));

        databaseHelper.save(new Place("Shillong","Meghalaya","English,Khasi,Hindi,Bengali","Summers from March to June. Monsoon season from June to September considered to be the best time to visit. Chilly winters.","Traditional Khasi Food.","Autumn Festival,Behdienkhlam Festival,Nongkrem Dance.","Buses,Taxi."));
        databaseHelper.save(new Suggestion("Shillong","Elephant Caves","Mawlynnong","Don Bosco Museum","Umiam Lake","Mawsynram","Shillong Peak","Ward’s Lake","Garo Hills,Khasi Hills,Jaintia Hills","David Scott Trail","Sweet Falls and Spread Eagle Falls"));

        databaseHelper.save(new Place("Simla","Himachal Pradesh","Hindi,English,Pahari.","Moderately hot in summers, moderate rainfall in monsoon and extremely cold winters.","Himachali cuisine","Ice Skating Carnival,Rhyali Festival,Shimla Summer Festival,Bhoj Fair,Lavi Fair,Sipi Fair","Buses,Taxi."));
        databaseHelper.save(new Suggestion("Simla","Annandale","Jakhoo Hill","Summer Hills","The Shimla State Museum","Chadwick Falls","The Scandal Point Ridge","Kufri","Mall Road","Chail","Mashobra"));

        databaseHelper.save(new Place("Srinagar","Jammu and Kashmir","Kashmiri,Urdu,Hindi,English","Best time to visit the place is from A pril to October. Mildly hot summers and extremely cold winters. No proper monsoon season.","Kashmiri Wazwan cuisine,primarily non vegetarian dishes.","Tulip Festival,Navroz Festival,Gurez Festival,Kheer Bhawani Festival,Urs Festtival,Gradens of Paradise Festival,Shikara Festival,Saffron Festival,Water Sports Festival.","Bus,Taxi,Auto Rickshaws,Shikaras."));
        databaseHelper.save(new Suggestion("Srinagar","Dal Lake","Mughal Gardens","Hazratbal Mosque","Nigeen Lake","Dal Lake and Nishat Bagh","Dachigam National Park","Pahalgam","Wular Lake","Aru Valley and Betaab Valley","Awantipora"));

        databaseHelper.save(new Place("Trivandrum","Kerala","Malyalam,English","Summers from March to May, Heavy rainfall in monsoon and cold winters from December to February.","Keralite cuisine. Apart from that other South Indian cuisines and Chinese cuisines are also popular.","Onam,Classical Music Festival,Vetta and Arattu,Nishagandhi Dance Festival,Food Festival,The Village Fair,Attukal Pongala.","Buses,Taxi."));
        databaseHelper.save(new Suggestion("Trivandrum","Sri Padmanabhaswamy Temple","Neyyar Dam and Wildlife Sanctuary","The Napier Museum","The Kanakakunnu Palace","The Zoological Park","Sri Chitra Art Gallery","Agastya Mala Peak","Poovar Island","Shanghumukham Beach","Science and Technology Museum"));

        databaseHelper.save(new Place("Udaipur","Rajasthan","Hindi,Mewari,English","The climate is hot. Summers from March to June, heavy rainfall in monsoon, pleasant cool weather in winters.","Rajasthani cuisine","Mewar Festival,Teej Festival,Shilpgram Utsav,Hariyali Amavasya.","Buses,Auto Rickshaws,Taxi."));
        databaseHelper.save(new Suggestion("Udaipur","City Palace","Lake Pichola","Lake Palace","Jag Mandir","Lake Fatehsagar","Saheliyon Ki Bari","Kumbhalgarh Fort","Bagore Ki Haveli and Ambrai Ghat","Ahar","Monsoon Palace"));

*/
        Log.d("reading", "reading all data");
        List<Place> listplace = databaseHelper.findAllp();
        for (Place b : listplace) {
            Log.d("data", "ID :" + b.getId() + " | City :" + b.getCity() + " | State :" + b.getState() + "Language :" + b.getLanguage() + " \n| Climate :" + b.getWeather() + " \n| Cuisine :" + b.getCuisine() + " \n| Festival and Fair :" + b.getFandf() + "\n| Transport :" +b.getTransport());
        }

        Log.d("reading", "reading all data");
        List<Suggestion> listsuggestion = databaseHelper.findAll();
        for (Suggestion b : listsuggestion) {
            Log.d("data", "ID :" + b.getId() + " | City :" + b.getCity() + " | Place 1 :" + b.getPlace1() + " | Place 2 :" + b.getPlace2() + " | Place 3 :" + b.getPlace3() + " | Place 4 :" + b.getPlace4() + " \n| Place 5 :" + b.getPlace5() + " | Place 6 :" + b.getPlace6() + " | Place 7 :" + b.getPlace7() + " \n| Place 8 :" + b.getPlace8() + " | Place 9 :" + b.getPlace9() + " | Place 10 :" + b.getPlace10());

        }
        onclick=(Button)findViewById(R.id.information);
        onclick.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        text1=(TextView)findViewById(R.id.text1);
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
        text17=(TextView)findViewById(R.id.text17);
        text18=(TextView)findViewById(R.id.text18);
        text19=(TextView)findViewById(R.id.text19);
        text20=(TextView)findViewById(R.id.text20);
        text21=(TextView)findViewById(R.id.text21);
        text22=(TextView)findViewById(R.id.text22);
        text23=(TextView)findViewById(R.id.text23);
        text24=(TextView)findViewById(R.id.text24);
        text25=(TextView)findViewById(R.id.text25);
        Place p = databaseHelper.findOnep(Message);
        Suggestion s = databaseHelper.findOne(Message);
        String[] ans = {"CITY:\n" + p.getCity(), "STATE:\n" + p.getState(), "LANGUAGE:\n" + p.getLanguage(), "CLIMATE:\n" + p.getWeather(), "CUISINE:\n" + p.getCuisine(), "FESTIVALS AND FAIRS:\n" + p.getFandf(), "TRANSPORT:\n" + p.getTransport(), "PLACES:", s.getPlace1(), s.getPlace2(), s.getPlace3(), s.getPlace4(), s.getPlace5(), s.getPlace6(), s.getPlace7(), s.getPlace8(), s.getPlace9(), s.getPlace10()};
        text1.setText("CITY:");
        text2.setText(p.getCity());
        text3.setText("STATE:");
        text4.setText(p.getState());
        text5.setText("LANGUAGE");
        text6.setText(p.getLanguage());
        text7.setText("WEATHER:");
        text8.setText(p.getWeather());
        text9.setText("CUISINE");
        text10.setText(p.getCuisine());
        text11.setText("FAIRS AND FESTIVALS:");
        text12.setText(p.getFandf());
        text13.setText("TRANSPORT:");
        text14.setText(p.getTransport());
        text15.setText("MUST VISIT PLACES:");
        text16.setText(s.getPlace1());
        text17.setText(s.getPlace2());
        text18.setText(s.getPlace3());
        text19.setText(s.getPlace4());
        text20.setText(s.getPlace5());
        text21.setText(s.getPlace6());
        text22.setText(s.getPlace7());
        text23.setText(s.getPlace8());
        text24.setText(s.getPlace9());
        text25.setText(s.getPlace10());
    }

    public void gotoselect(View view)
    {
        Intent i=new Intent(this,Activity2.class);
        startActivity(i);
    }

    public void gotoplannerinformation(View view)
    {
        Intent i=new Intent(this,Activity_4.class);
        i.putExtra("City_Name",Message);
        startActivity(i);
    }

   /* public void onaddinformation(View view)
    {

            //listplace = (ListView) findViewById(R.id.listplace);
        text2=(TextView)findViewById(R.id.text2);
        text4=(TextView)findViewById(R.id.text4);
        text6=(TextView)findViewById(R.id.text6);
        text8=(TextView)findViewById(R.id.text8);
        text10=(TextView)findViewById(R.id.text10);
        text12=(TextView)findViewById(R.id.text12);
        text14=(TextView)findViewById(R.id.text14);
        text16=(TextView)findViewById(R.id.text16);
        text17=(TextView)findViewById(R.id.text17);
        text18=(TextView)findViewById(R.id.text18);
        text19=(TextView)findViewById(R.id.text19);
        text20=(TextView)findViewById(R.id.text20);
        text21=(TextView)findViewById(R.id.text21);
        text22=(TextView)findViewById(R.id.text22);
        text23=(TextView)findViewById(R.id.text23);
        text24=(TextView)findViewById(R.id.text24);
        text25=(TextView)findViewById(R.id.text25);
            Place p = databaseHelper.findOnep(Message);
            Suggestion s = databaseHelper.findOne(Message);
            String[] ans = {"CITY:\n" + p.getCity(), "STATE:\n" + p.getState(), "LANGUAGE:\n" + p.getLanguage(), "CLIMATE:\n" + p.getWeather(), "CUISINE:\n" + p.getCuisine(), "FESTIVALS AND FAIRS:\n" + p.getFandf(), "TRANSPORT:\n" + p.getTransport(), "PLACES:", s.getPlace1(), s.getPlace2(), s.getPlace3(), s.getPlace4(), s.getPlace5(), s.getPlace6(), s.getPlace7(), s.getPlace8(), s.getPlace9(), s.getPlace10()};


        text2.setText(p.getCity());
        text4.setText(p.getState());
        text6.setText(p.getLanguage());
        text8.setText(p.getWeather());
        text10.setText(p.getCuisine());
        text12.setText(p.getFandf());
        text14.setText(p.getTransport());
        text16.setText(s.getPlace1());
        text17.setText(s.getPlace2());
        text18.setText(s.getPlace3());
        text19.setText(s.getPlace4());
        text20.setText(s.getPlace5());
        text21.setText(s.getPlace6());
        text22.setText(s.getPlace7());
        text23.setText(s.getPlace8());
        text24.setText(s.getPlace9());
        text25.setText(s.getPlace10());

        //adapter = new ArrayAdapter(getApplicationContext(), R.layout.custom_view, ans);
        //listplace.setAdapter(adapter);



    }*/
}
