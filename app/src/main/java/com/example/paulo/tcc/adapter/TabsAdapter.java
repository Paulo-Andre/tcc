package com.example.paulo.tcc.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.HalfFloat;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.ViewGroup;

import com.example.paulo.tcc.R;
import com.example.paulo.tcc.fragments.HomeFragment;
import com.example.paulo.tcc.fragments.NoticiasFragment;
import com.example.paulo.tcc.fragments.PerdidoFragment;
import com.example.paulo.tcc.fragments.UsuariosFragment;

import java.util.HashMap;


public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private String[] abas = new String[]{"HOME","USUARIOS"};
    private int[] icones = new int[]{R.mipmap.icon_home1,R.mipmap.icon_notcias,R.mipmap.incone_perdido,R.mipmap.icon_usuario};
    private int tamanhoicone;
    private HashMap<Integer,Fragment> fragmentosutilizados=new HashMap<>();
    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
        double escala = this.context.getResources().getDisplayMetrics().density;
        tamanhoicone= (int) (20*escala);

    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment= null;
        switch (position){
            case 0 :
                fragment = new HomeFragment();
                fragmentosutilizados.put(position,fragment);
                break;
            case 1:
                fragment = new NoticiasFragment();
                fragmentosutilizados.put(position,fragment);
            break;
            case 2:
                fragment = new PerdidoFragment();
                fragmentosutilizados.put(position,fragment);
                break;
            case 3:
                fragment = new UsuariosFragment();
                fragmentosutilizados.put(position,fragment);
                break;

        }
        return fragment;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
        fragmentosutilizados.remove(position);
    }

    public Fragment getFragment(Integer indice){
        return fragmentosutilizados.get(indice);
    }
    @Override
    public CharSequence getPageTitle(int position){
        Drawable drawable = ContextCompat.getDrawable(this.context,icones[position]);
        drawable.setBounds(0,0,tamanhoicone,tamanhoicone);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = new SpannableString(" ");
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    @Override
    public int getCount() {
        return icones.length;
    }
}
