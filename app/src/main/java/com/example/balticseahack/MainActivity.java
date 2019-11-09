package com.example.balticseahack;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.widget.LinearLayout;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String news = "1\u02ad2\u02ad3\u02ad4\u02ad5\u02ad6\u02ad7\u02ad8\u02ad9\u02ad10";

        try {
            news = new Sender().execute("readResentNews").get();//получаем последние новости,юникод разделителя: U+02A
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        news = "";

        news += "Петербургская ярмарка" + "\u02ac" + "Петербургская ярмарка — грандиозный фестиваль хендмейда, где можно не только найти совершенно уникальные изделия ручной работы и пообщаться с талантливыми людьми, но и создать собственный маленький шедевр на мастер-классе, послушать живую музыку, вкусно перекусить на фуд-корте и в целом отлично провести осенний день.\n"
                + "\u02ac" + "yarmarka" + "\u02ad";
        news += "Люмьер-Холл" + "\u02ac" + "Познакомиться с самыми разными состояниями моря — от полного штиля до шторма, сравнимого с концом света — и необыкновенными горами от Алтая до Индии жителям Петербурга предлагается в креативном пространстве «Люмьер-Холл», где проходят мультимедийные выставки Айвазовского и Рериха. Они разительно отличаются от предыдущих подобных проектов как визуальным наполнением, так и техническим оснащением: анимация картин выведена на совершенно новый уровень. Динамичный видеоряд, 30 проекторов высокого разрешения и объёмный звук позволяют зрителям оказаться «внутри» работ художников, вдохнуть солёный морской воздух или почувствовать горный ветер. Всего на выставках можно по единому билету увидеть более 200 творений Айвазовского, оригиналы которых хранятся в музеях России и Армении, и более 300 полотен Рериха.\n" +
                "\u02ac" + "screen" + "\u02ad";
        news += "Сад сновидений" + "\u02ac" + "Креативное пространство «Люмьер Холл» приглашает в волшебный «Сад сновидений». Это выставка световых и интерактивных инсталляций, включающая в себя 15 зон — кошмар, осознанный сон, вещий сон и так далее. В каждой локации благодаря трёхмерной графике, аудиоэффектам и видеомаппингу зрители окунаются в фантастическую вселенную, где реальность смешана с миром грёз. Удивительное путешествие начинается уже в вестибюле, где гостей встречают промышленные роботы. Интересно, что каждый сон принадлежит определённому персонажу, поэтому выходит, что зрители гуляют по подсознанию того или иного героя.\n"
                + "\u02ac" + "hall" + "\u02ad";
        news += "Mеждународный Фестиваль" + "\u02ac" + "В культурном пространстве Петербурга «Севкабель Порт» состоятся выставка Russian kids case и закрытие Международного Большого Детского фестиваля, которым руководит Сергей Безруков.\n" + "Эти события предваряла пресс-конференция с участием художественного руководителя фестиваля Сергея Безрукова. Он рассказал, что «сегодня за детский театр надо драться», необходимо привлекать внимание к проблемам детского театра в России, особенно за пределами двух столиц. Вместе с мэтром на конференции присутствовали юные амбассадоры фестиваля, выбранные по результатам видеокастинга. К сожалению, искусство для детей часто считается чем-то второстепенным или даже не имеющим отношения к искусству как к таковому. В то время как запрос на детский театр и другие исполнительские жанры огромен и со стороны зрителей, и со стороны художников. Многие режиссёры начали последовательно работать с молодой аудиторией, создавая новые формы, язык и способы взаимодействия со своим зрителем. В честь закрытия Большого Детского фестиваля организована выставка Russian kids case («Рашан кидс кейс»), на которой предстанут достижения искусства, адресованного детям. На этой площадке можно будет провести весь день. Уютное пространство напоминает детскую комнату и в то же время театральную декорацию. Здесь разместится игровая зона, разработанный дизайнерами лабиринт и стенды представителей различных видов искусства — кино, театра, цирка, анимации.\n"
                + "\u02ac" + "festival" + "\u02ad";
        news += "Узнавая город" + "\u02ac" + "Крыши и дворы-колодцы, набережные и мосты, доходные дома и парадные, каналы и проспекты — в нашей подборке вы найдёте экскурсии, которые позволят узнать Санкт-Петербург с разных сторон.\n"
                + "\u02ac" + "exc" + "\u02ad";

        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int displayWibth = size.x;

        Bitmap[] set = new Bitmap[10];
        System.out.println("ss1");
        set[0] = BitmapFactory.decodeResource(getResources(), R.drawable.yarmarka);
        System.out.println("ss2");
        set[1] = BitmapFactory.decodeResource(getResources(), R.drawable.screen);
        System.out.println("ss3");
        set[2] = BitmapFactory.decodeResource(getResources(), R.drawable.hall);
        System.out.println("ss4");
        set[3] = BitmapFactory.decodeResource(getResources(), R.drawable.festival);
        set[4] = BitmapFactory.decodeResource(getResources(), R.drawable.exc);

        LinearLayout content_main = findViewById(R.id.main_content_scroll_layout);
        String[] newsArr = news.split("\u02ad");
        for(int i = 0; i < 5; i++){
            content_main.addView(new ContainerForNew(newsArr[i], set[i], displayWibth, i%2 == 1, this));
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
