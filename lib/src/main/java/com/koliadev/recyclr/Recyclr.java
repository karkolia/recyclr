package com.koliadev.recyclr;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import java.util.ArrayList;

/**
 * Created by Nicolas Marone on 02/09/2017.
 * Init of recyclr library
 */

public class Recyclr<T extends Recyclr.Holder, U> {

  private Context context;
  private int layoutId;
  private Adapter adapter;
  private RecyclerView recyclerView;
  private Maker<T> maker;
  private Binder<T, U> binder;
  private ArrayList<U> items;

  public static <T extends Recyclr.Holder, U> Recyclr<T, U> from(RecyclerView recyclerView) {
    Recyclr<T, U> recyclr = new Recyclr<>();
    recyclr.recyclerView = recyclerView;
    recyclr.context = recyclerView.getContext();
    recyclr.initRecyclerView();
    return recyclr;
  }

  private void initRecyclerView() {
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
  }

  public Recyclr<T, U> layout(@LayoutRes int layoutId) {
    this.layoutId = layoutId;
    this.adapter = new Adapter(context);
    recyclerView.setAdapter(adapter);
    return this;
  }

  public Recyclr<T, U> viewHolder(Maker<T> maker, Binder<T, U> binder) {
    this.maker = maker;
    this.binder = binder;
    return this;
  }

  public void items(ArrayList<U> items) {
    this.items = items;
    this.adapter.notifyDataSetChanged();
  }

  public interface Maker<T extends Holder> {
    T onCreate(View view);
  }

  public interface Binder<T extends Holder, U> {
    void onBind(T holder, U item);
  }

  public static class Holder extends ViewHolder {

    public Holder(View itemView) {
      super(itemView);
      ButterKnife.bind(this, itemView);
    }
  }

  private class Adapter extends RecyclerView.Adapter<T> {

    private final LayoutInflater inflater;

    Adapter(Context context) {
      this.inflater = LayoutInflater.from(context);
    }

    @Override public T onCreateViewHolder(ViewGroup parent, int viewType) {
      return maker.onCreate(inflater.inflate(layoutId, null));
    }

    @Override public void onBindViewHolder(T holder, int position) {
      binder.onBind(holder, items.get(position));
    }

    @Override public int getItemCount() {
      return items == null ? 0 : items.size();
    }
  }
}
