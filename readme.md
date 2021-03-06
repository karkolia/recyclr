Welcome to the recyclr wiki!


Recyclr
===================


Recyclr is an Android utility library meant to help developers simplify recycler views init and use.

For now, this tool only allows you to deal with the main, most used case: **One column, one view type list**.


> **Note:**
> It is important to notice that this tool uses:
>
> - Java 8 compilation level
> - [Butterknife library](http://jakewharton.github.io/butterknife/)
> - Recyclerview support library


Gradle
-----------

To add this library to your project, just add the following line to your gradle file:
```
compile 'com.koliadev.view:recyclr:0.1.1'
```

> **Note:**
>
> In case your project already uses Butterknife library, use these lines instead:
```
compile 'com.koliadev.view:recyclr:0.1.1', {
	exclude group: 'com.jakewharton'
}
```


Usage
-----------

To implement it, you have 3 simple steps:

- Create a ViewHolder class extending *Recyclr.Holder* with all the views bound with Butterknife annotations

```
public class ViewHolder extends Recyclr.Holder {
	@BindView(R.id.name) public TextView nameTv;
	@BindView(R.id.description) public TextView descTv;

	ViewHolder(View itemView) {
		super(itemView);
	}
}
```

- Call Recyclr to init the recyclr object with your parameters and recycler view:

```
recyclr = Recyclr.<MyViewHolder, MyModel>from(recyclerView)
.layout(R.layout.list_item)
.viewHolder(MyViewHolder::new, (myHolder, myModel) -> {
  myHolder.nameTv.setText(myModel.getName());
  myHolder.descriptionTv.setText(myModel.getDescription());
});
```
Here we call Recyclr passing the recycler view as parameter to from() method.
Then call layout() method with the item layout id as parameter.
Then we call the viewHolder method with 2 parameters.

- First: an implementation of Recyclr.Maker interface which provides viewholders instances
- Second: an implementation of Recyclr.Binder interface which the Tool will use to let you fill a list item with your data passing you the holder and the item to do so.

Don't forget to keep a reference to the newly created object to be able to pass the items to it

- Provide the models list to the recyclr object:
```
recyclr.items(itemsList)
```


That's it !

Don't hesitate to comment or propose improvements.
