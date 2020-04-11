package com.hc.jetpackdemo.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.hc.jetpackdemo.R;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);


        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button button;

       button =  getView().findViewById(R.id.button8);


       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //导航





               NavController controller =  Navigation.findNavController(view);


               Bundle bundle = new Bundle();
               bundle.putString("my_name","this is string in bundle");

               //传递目的地或者 action 都可以导航
               controller.navigate(R.id.action_navigation_notifications_to_detataiFragment,bundle);


               //这样也会传递
               //controller.navigate(R.id.detataiFragment);






           }
       });


      // getView().findViewById(R.id.button8).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_navigation_notifications_to_detataiFragment));


    }
}