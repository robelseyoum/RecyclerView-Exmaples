package com.robelseyoum3.recycleviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> personArrayList;
    private onPersonClickListener listener;

    public PersonAdapter(ArrayList<Person> personArrayList, onPersonClickListener onPersonClickListener) {
        this.personArrayList = personArrayList;
        listener = onPersonClickListener;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyler_item_layout, parent, false);

        return new PersonViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {

        Person person = personArrayList.get(position);

        holder.tvFname.setText(person.getFirstName());
        holder.tvLname.setText(person.getLastName());
        holder.tvAge.setText(""+person.getAge());
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

    //here it implement view onClick listner
    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvFname, tvLname, tvAge;

        private onPersonClickListener onPersonClickListener; //we use this because by considering as if might have this class outside this class

        public PersonViewHolder(@NonNull View itemView, onPersonClickListener onPersonClickListener) {

            super(itemView);
            tvFname = itemView.findViewById(R.id.tv_fname);
            tvLname = itemView.findViewById(R.id.tv_lname);
            tvAge = itemView.findViewById(R.id.tv_age);
            this.onPersonClickListener = onPersonClickListener;


            //set click listener for itemview
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Person person = personArrayList.get(getAdapterPosition());
            onPersonClickListener.onItemClicked(person);
        }
    }

    public interface onPersonClickListener {

        void onItemClicked(Person person); //this send the click info to the acitivity

    }





























}
