package com.koliadev.example;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.koliadev.example.model.TestData;
import com.koliadev.recyclr.Recyclr;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recycler_view) public RecyclerView recyclerView;
  private Recyclr recyclr;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    initList();
  }

  public class ViewHolder extends Recyclr.Holder {
    @BindView(R.id.name) public TextView nameTv;
    @BindView(R.id.description) public TextView descriptionTv;

    ViewHolder(View itemView) {
      super(itemView);
    }
  }

  private void initList() {
    recyclr = Recyclr.from(recyclerView)
        .layout(R.layout.list_item)
        .viewHolder(ViewHolder::new, (holder, item) -> {
          ViewHolder h = (ViewHolder) holder;
          TestData i = (TestData) item;
          h.nameTv.setText(i.getName());
          h.descriptionTv.setText(i.getDescription());
        });

    new Handler().postDelayed(() -> recyclr.items(getTestData()), 1000);
  }

  @NonNull private ArrayList<TestData> getTestData() {
    ArrayList<TestData> datas = new ArrayList<>();
    for (int i = 0; i < 18; i++) {
      TestData testData = new TestData();
      testData.setName("NAME_" + i);
      testData.setDescription(
          "jqshdfljkqhs fqhsd fjq sjdfoqsjdhf qhsdufo iuqhsd fiuhqs oidfuqsodfu qodfoqisduh " + i);
      datas.add(testData);
    }
    return datas;
  }
}
