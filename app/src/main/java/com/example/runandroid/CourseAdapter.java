package com.example.runandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder>{
    public JSONArray elements;
    private Context context;
    public String userFromId;

    public CourseAdapter(JSONArray elements, Context context, String userFromId) {
        this.elements = elements;
        this.context = context;
        this.userFromId = userFromId;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView first_line;
        RelativeLayout container;

        public ViewHolder(View itemView) {
            super(itemView);
            first_line = itemView.findViewById(R.id.element_view_first_line);
            container = itemView.findViewById(R.id.element_view_container);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_view,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.ViewHolder holder, int position) {
        try {
        final JSONObject element = elements.getJSONObject(position);

            String name = element.getString("nombre");
            final String id = element.getString("id");
            final String descripcion = element.getString("descripcion");
            final String horario = element.getString("horario");

            holder.first_line.setText(name);

            holder.container.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Intent goToMessage = new Intent(context,CourseActivity.class);

                    goToMessage.putExtra("course_id",userFromId);
                    goToMessage.putExtra("descripcion", descripcion);
                    goToMessage.putExtra("horario", horario);

                    context.startActivity(goToMessage);
                }
            });
        } catch (JSONException e) {
           e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return elements.length();
    }
}
