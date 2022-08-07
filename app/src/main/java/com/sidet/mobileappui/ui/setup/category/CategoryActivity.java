package com.sidet.mobileappui.ui.setup.category;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.sidet.mobileappui.R;
import com.sidet.mobileappui.app.BaseActivity;
import com.sidet.mobileappui.models.res.Category;
import com.sidet.mobileappui.presenters.CategoryPresenter;
import com.sidet.mobileappui.utils.local.UserSharedPreference;
import com.sidet.mobileappui.views.CategoryView;

import java.util.List;

public class CategoryActivity extends BaseActivity implements CategoryView {
    private RecyclerView recyclerViewCategory;
    private ProgressBar progressBar;
    private CategoryAdapter categoryAdapter;
    private CategoryPresenter categoryPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerViewCategory = findViewById(R.id.recyclerviewCategory);
        progressBar = findViewById(R.id.progressBar);

        categoryPresenter = new CategoryPresenter(this);
        categoryPresenter.getAllCategory(UserSharedPreference.getToken(this));
    }

    @Override
    public void onLoading(String message) {
//        showMessage("Loading...");
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading(String message) {
//        showMessage("Hiding..");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(String message) {
//        showMessage("Success...");
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onServerError(String message) {
        showMessage(message);
    }

    @Override
    public void setData(List<Category> list) {
//        showMessage(list.toString());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        categoryAdapter = new CategoryAdapter(this, list);

        recyclerViewCategory.setLayoutManager(linearLayoutManager);
        recyclerViewCategory.setAdapter(categoryAdapter);
       
    }
}