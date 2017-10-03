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
import com.koliadev.example.model.MyItem;
import com.koliadev.recyclr.Recyclr;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.recycler_view) public RecyclerView recyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    initList();
  }

  public class MyViewHolder extends Recyclr.Holder {
    @BindView(R.id.name) public TextView nameTv;
    @BindView(R.id.description) public TextView descriptionTv;

    MyViewHolder(View itemView) {
      super(itemView);
    }
  }

  private void initList() {
    Recyclr<MyViewHolder, MyItem> recyclr = Recyclr.from(recyclerView);
    recyclr
        .layout(R.layout.list_item)
        .viewHolder(MyViewHolder::new, (holder, item) -> {
          holder.nameTv.setText(item.getName());
          holder.descriptionTv.setText(item.getDescription());
        });

    new Handler().postDelayed(() -> recyclr.items(getTestData()), 1000);
  }

  @NonNull private ArrayList<MyItem> getTestData() {
    ArrayList<MyItem> datas = new ArrayList<>();
    for (int i = 0; i < 18; i++) {
      MyItem testData = new MyItem();
      testData.setName("NAME_" + i);
      testData.setDescription(
          "jqshdfljkqhs fqhsd fjq sjdfoqsjdhf qhsdufo iuqhsd fiuhqs oidfuqsodfu qodfoqisduh " + i);
      datas.add(testData);
    }
    return datas;
  }
}
