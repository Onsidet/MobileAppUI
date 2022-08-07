package com.sidet.mobileappui.ui.setup.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sidet.mobileappui.R;
import com.sidet.mobileappui.models.res.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(
                R.layout.category_card_item,null, false
        );
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        String getId = String.valueOf(category.getId());
        holder.categoryId.setText(getId);
        holder.categoryName.setText(category.getName());
        holder.categoryStatus.setText(category.getStatus().toLowerCase());
    }


    @Override
    public int getItemCount() {
        if (categoryList.isEmpty()){
            return 0;
        }
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        TextView categoryId, categoryName, categoryStatus;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryId = itemView.findViewById(R.id.tvCategoryId);
            categoryName = itemView.findViewById(R.id.tvCategoryName);
            categoryStatus = itemView.findViewById(R.id.tvCategoryStatus);
        }
    }
}
