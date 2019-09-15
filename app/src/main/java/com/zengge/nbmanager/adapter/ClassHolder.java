package com.zengge.nbmanager.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zengge.nbmanager.R;
import com.zengge.nbmanager.adapter.base.RecyclerViewAdapter;
import com.zengge.nbmanager.adapter.base.RecyclerViewHolder;
import jadx.gui.treemodel.JNode;
import jadx.gui.treemodel.JPackage;

public class ClassHolder extends RecyclerViewHolder<ClassHolder> {

    ImageView fileIcon;
    TextView fileName;
    TextView fileChildCount;
    TextView fileSize;
    ImageView dir_enter_image;

    public ClassHolder(View view) {
        super(view);
        fileIcon = view.findViewById(R.id.fileIcon);
        fileName = view.findViewById(R.id.fileName);
        fileChildCount = view.findViewById(R.id.fileChildCount);
        fileSize = view.findViewById(R.id.fileSize);
        dir_enter_image = view.findViewById(R.id.dir_enter_image);
    }

    @Override
    public void onBindViewHolder(final ClassHolder classHolder, RecyclerViewAdapter adapter, int position) {
        JNode jNode = (JNode) adapter.getItem(position);
        classHolder.fileName.setText(jNode.getName());

        if (R.mipmap.package_obj == jNode.getIcon()) {
            JPackage jPackage = (JPackage) jNode;
            classHolder.fileChildCount.setVisibility(View.VISIBLE);
            classHolder.fileChildCount.setText(jPackage.getClasses().size() + jPackage.getInnerPackages().size() + "项");
            classHolder.fileSize.setVisibility(View.GONE);
            classHolder.dir_enter_image.setVisibility(View.VISIBLE);

        } else {
            classHolder.fileChildCount.setVisibility(View.GONE);
            classHolder.fileSize.setVisibility(View.GONE);
            classHolder.dir_enter_image.setVisibility(View.GONE);
        }

        //设置图标
        classHolder.fileIcon.setImageResource(jNode.getIcon());

    }


}
