package com.koliadev.recyclrexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created on 03/09/2017.
 */

public class TestViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.name) public TextView nameTv;
  @BindView(R.id.description) public TextView descriptionTv;

  public TestViewHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
