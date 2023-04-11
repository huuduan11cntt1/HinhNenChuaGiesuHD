package jos.huuduan.hinhnenchuagiesu.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import jos.huuduan.hinhnenchuagiesu.OnClickActivity;
import jos.huuduan.hinhnenchuagiesu.R;
import jos.huuduan.hinhnenchuagiesu.adapter.UserAdapter;
import jos.huuduan.hinhnenchuagiesu.databinding.FragmentHomeBinding;
import jos.huuduan.hinhnenchuagiesu.my_interface.IClickItemUserListener;
import jos.huuduan.hinhnenchuagiesu.user.User;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView rcvUser;
    private UserAdapter mUserAdapter;
    private AdView mAdView;
    private DatabaseReference reference ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rcvUser = binding.rcvUser ;
        mUserAdapter = new UserAdapter(getListUser(), new IClickItemUserListener() {
            @Override
            public void onClickItemUser(User user) {
                onClickGotoDetail(user);
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        rcvUser.setLayoutManager(gridLayoutManager);

        mUserAdapter.setData(getListUser());

        rcvUser.setAdapter(mUserAdapter);

        AdView adView = new AdView(getContext());

        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5382625544778444/9081309714");
        MobileAds.initialize(getContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = binding.adView ;
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

       // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.a));
        list.add(new User(R.drawable.b));
        list.add(new User(R.drawable.c));
        list.add(new User(R.drawable.d));
        list.add(new User(R.drawable.e));
        list.add(new User(R.drawable.f));
        list.add(new User(R.drawable.g));
        list.add(new User(R.drawable.h));
        list.add(new User(R.drawable.i));
        list.add(new User(R.drawable.k));
        list.add(new User(R.drawable.l));
        list.add(new User(R.drawable.m));
        list.add(new User(R.drawable.n));
        list.add(new User(R.drawable.o));
        list.add(new User(R.drawable.p));
        list.add(new User(R.drawable.q));
        list.add(new User(R.drawable.r));
        list.add(new User(R.drawable.s));
        list.add(new User(R.drawable.t));
        list.add(new User(R.drawable.u));
        list.add(new User(R.drawable.v));
        list.add(new User(R.drawable.w));
        list.add(new User(R.drawable.q));
        list.add(new User(R.drawable.x));
        list.add(new User(R.drawable.y));
        list.add(new User(R.drawable.z));
        list.add(new User(R.drawable.q));

        return list;
    }
    private  void onClickGotoDetail(User user){
        Intent intent = new Intent(getContext(), OnClickActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("OBA",user);
        intent.putExtras(bundle) ;
        startActivity(intent);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

