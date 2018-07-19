package com.example.abhatripathi.iitline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterMaths1 extends RecyclerView.Adapter<AdapterMaths1.MyViewHolder> {
    private ArrayList<mathsMainsQuestion1> MathsArrayList;
    private Context context;

    public AdapterMaths1(ArrayList<mathsMainsQuestion1> mathsMainsQuestion1s, Context ctx) {
        MathsArrayList = mathsMainsQuestion1s;
        context = ctx;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater lif = LayoutInflater.from(context);
        View inflatedView = lif.inflate(R.layout.fragment_ques,parent,false);
        return new MyViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        mathsMainsQuestion1 mathsMainsQuestion1 = MathsArrayList.get(position);
        holder.questionNumber.setText(mathsMainsQuestion1.getQuestionNumber());
        holder.question.setText(mathsMainsQuestion1.getQuestion());
        holder.explanation.setText(mathsMainsQuestion1.getExplanation());
        holder.option1.setText(mathsMainsQuestion1.getOption1());
        holder.option2.setText(mathsMainsQuestion1.getOption2());
        holder.option3.setText(mathsMainsQuestion1.getOption3());
        holder.option4.setText(mathsMainsQuestion1.getOption4());

    }

    @Override
    public int getItemCount() {
        return MathsArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView questionNumber,question,explanation;
        Button option1,option2,option3,option4;

        public MyViewHolder(View itemView) {
            super(itemView);
            questionNumber= itemView.findViewById(R.id.QuestionNumber);
            question = itemView.findViewById(R.id.Question);
            explanation = itemView.findViewById(R.id.explanation);
            option1 = itemView.findViewById(R.id.radioButton1);
            option2 = itemView.findViewById(R.id.radioButton2);
            option3 = itemView.findViewById(R.id.radioButton3);
            option4 = itemView.findViewById(R.id.radioButton4);
        }
    }

}

