package com.example.balticseahack.ui.gallery;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.balticseahack.R;
import com.example.balticseahack.Sender;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.layers.GeoObjectTapListener;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;

import java.util.concurrent.ExecutionException;

public class MapsFragment extends Fragment {

    private MapsViewModel mapsViewModel;
    private MapView mapView;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

        MapKitFactory.setApiKey("605296b0-f67f-42fd-931d-d4d3fc15afba");
        MapKitFactory.initialize(getActivity());

        mapView = new MapView(getActivity());

        mapsViewModel =
                ViewModelProviders.of(this).get(MapsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_maps, container, false);

        LinearLayout ll = root.findViewById(R.id.map_lay);

        mapView.getMap().move(
                new CameraPosition(new Point(59.761232, 30.354974), 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 0),
                null
        );
        Map map = mapView.getMap();
        final EditText et = new EditText(getContext());
        map.addInputListener(new InputListener() {
            @Override
            public void onMapTap(@NonNull final Map map, @NonNull final Point point) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Добавление метки").setView(et).setNegativeButton("Назад", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //try {
                            String answer = "OK";/*new Sender().execute("AddPoint", String.valueOf(point.getLatitude()),
                                    String.valueOf(point.getLongitude()), /*login, et.getText().toString()).get();*/
                            if(answer.equals("OK")) {
                                Toast.makeText(getContext(), "Метка добавлена", Toast.LENGTH_SHORT).show();
                                map.getMapObjects().addPlacemark(point);
                            } else {
                                Toast.makeText(getContext(), "Ошибка", Toast.LENGTH_SHORT).show();
                            }
                            dialog.dismiss();
                        //} catch (ExecutionException | InterruptedException ignored) {}
                    }
                });
            }

            @Override
            public void onMapLongTap(@NonNull Map map, @NonNull Point point) {

            }
        });

        ll.addView(mapView);

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
        MapKitFactory.getInstance().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
    }
}