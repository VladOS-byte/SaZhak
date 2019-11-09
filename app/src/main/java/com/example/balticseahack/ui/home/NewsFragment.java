package com.example.balticseahack.ui.home;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.balticseahack.ContainerForNew;
import com.example.balticseahack.R;
import com.example.balticseahack.Sender;

import java.util.concurrent.ExecutionException;

public class NewsFragment extends Fragment {

    private NewsViewModel newsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        newsViewModel =
                ViewModelProviders.of(this).get(NewsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_news, container, false);

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
        getActivity().getWindowManager().getDefaultDisplay().getSize(size);
        int displayWibth = size.x;

        Bitmap[] set = new Bitmap[10];
        set[0] = BitmapFactory.decodeResource(getResources(), R.drawable.yarmarka);
        set[1] = BitmapFactory.decodeResource(getResources(), R.drawable.screen);
        set[2] = BitmapFactory.decodeResource(getResources(), R.drawable.hall);
        System.out.println("ss4");
        set[3] = BitmapFactory.decodeResource(getResources(), R.drawable.festival);
        set[4] = BitmapFactory.decodeResource(getResources(), R.drawable.exc);

        LinearLayout content_main = root.findViewById(R.id.news_scroll_layout);
        content_main.addView(new TextView(getActivity()));
        String[] newsArr = news.split("\u02ad");
        for(int i = 0; i < 5; i++){
            content_main.addView(new ContainerForNew(newsArr[i], set[i], displayWibth, i%2 == 1, getActivity()));
        }
        return root;
    }
}