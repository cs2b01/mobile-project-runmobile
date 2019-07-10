package com.example.runandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.text.Html;
import android.view.View;
import android.text.Spanned;
import android.view.ViewGroup;
import android.widget.TextView;

public class FaqFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_faq, container, false);

        TextView tv = view.findViewById(R.id.simpleTv);

        Spanned html = Html.fromHtml(
                "TextView first line... <br />" +
                        "<b>Bold Text</b> | <i>Italic Text</i> and <br/>" +
                        "<u>Underlined text</u>"
        );

        tv.setText(html);

        return view;
    }
}
