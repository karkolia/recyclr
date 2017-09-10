package com.koliadev.recyclrexample;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.koliadev.recyclrexample.model.TestData;
import java.util.ArrayList;

/**
 * Created on 03/09/2017.
 */

public class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {
  private ArrayList<TestData> data;

  @Override public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new TestViewHolder(View.inflate(parent.getContext(), R.layout.list_item, null));
  }

  @Override public void onBindViewHolder(TestViewHolder holder, int position) {
    TestData testData = data.get(position);
    holder.nameTv.setText(testData.getName());
    holder.descriptionTv.setText(testData.getDescription());
  }

  @Override public int getItemCount() {
    return data == null ? 0 : data.size();
  }

  public void setData(ArrayList<TestData> data) {
    this.data = data;
    notifyDataSetChanged();
  }
}
