package com.example.newproject;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newproject.JobsFragment.OnListFragmentInteractionListener;
import com.example.newproject.dummy.JobList;
import com.example.newproject.dummy.JobList.Jobs;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link JobList.Jobs} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyJobsRecyclerViewAdapter extends RecyclerView.Adapter<MyJobsRecyclerViewAdapter.ViewHolder> {

    private final List<JobList.Jobs> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyJobsRecyclerViewAdapter(List<JobList.Jobs> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_jobs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.profileName.setText(mValues.get(position).profileName);
        holder.designation.setText(mValues.get(position).desgnation);
        holder.ratings.setText(mValues.get(position).ratings);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView profileName;
        public final TextView designation;
        public final TextView ratings;
        public Jobs mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            profileName = (TextView) view.findViewById(R.id.profile_name);
            designation = (TextView) view.findViewById(R.id.designation);
            ratings = (TextView) view.findViewById(R.id.ratings);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "mView=" + mView +
                    ", profileName=" + profileName +
                    ", designation=" + designation +
                    ", ratings=" + ratings +
                    ", mItem=" + mItem +
                    '}';
        }
    }
}
