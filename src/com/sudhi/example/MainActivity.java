/**
 * Copyright 2014 Sudhi S
 * sudhi001@icloud.com /droidsworld@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *    http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.sudhi.example;

import java.util.ArrayList;
import java.util.List;
import android.support.v4.view.MenuItemCompat;
import android.app.SearchManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.OnQueryTextListener;
import com.androidhelpline.ui.widgets.UIGridView;
import com.androidhelpline.ui.widgets.UIGridView.UIGridViewDataSource;
import com.sudhi.example.MainActivity.ViewHolder;

public class MainActivity extends Activity implements
		UIGridViewDataSource<ViewHolder, String>,OnQueryTextListener  {

	List<String> data = new ArrayList<String>();
	private UIGridView<ViewHolder, String> grid;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

         	data.add("hello");
		data.add("hello");
		data.add("hello");
		data.add("hello");
		data.add("hello");
                data.add("hello");
                data.add("hello");
                data.add("hello");
                data.add("hello");
                data.add("hello");
                data.add("hello");
                data.add("hello");
		grid = (UIGridView<ViewHolder, String>) findViewById(R.id.StaticGridView);
		grid.setDatasourse(this);
		grid.setUiAdapterArray(data);
	}

     @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getActivity()
                .getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat
                .getActionView(searchItem);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(this);
        super.onCreateOptionsMenu(menu, inflater);
    }
	public class ViewHolder {
		TextView txt;

	}


	@Override
	public ViewHolder holderForUIGridView() {
		return new ViewHolder();
	}

	@Override
	public void onCreateUIGridViewView(View view, ViewHolder h) {
      h.txt=(TextView) view.findViewById(android.R.id.text1);
	}

	@Override
	public void onUIGridViewViewCreated(View view, ViewHolder holder,
			String item) {
		holder.txt.setText(item);


	}

	  @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            gridView.getUIGridViewAdapter().getFilter().filter("");
            gridView.clearTextFilter();
        } else {
            gridView.getUIGridViewAdapter().getFilter().filter(newText.toString());
        }
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String arg0) {
        return false;
    }

    @Override
    public void onFilter(List<AppointmentDTO> mList, String item,CharSequence constraint) {
        if (item.toLowerCase(Locale.getDefault())
                .contains(constraint)) {
            mList.add(item);
        }
        
    }

}
