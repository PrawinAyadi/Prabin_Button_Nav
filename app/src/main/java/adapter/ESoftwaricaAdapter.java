package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prabin_button_nav.R;

import java.util.List;

import model.ESoftwarica;

public class ESoftwaricaAdapter extends RecyclerView.Adapter<ESoftwaricaAdapter.ContactsViewHolder> {

    Context context;
    List<ESoftwarica> eSoftwaricaList;
    int img;
    public ESoftwaricaAdapter(Context context, List<ESoftwarica> eSoftwaricaList){
        this.context=context;
        this.eSoftwaricaList=eSoftwaricaList;
    }
    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contactview,parent,false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, final int position) {

        final ESoftwarica eSoftwarica=eSoftwaricaList.get(position);
        String gender=eSoftwarica.getGender();
        if(gender.equals("Female")){
            img =R.drawable.female;
        }
        else if(gender.equals("Male"))
        {
            img=R.drawable.male;
        }
        else {
            img=R.drawable.noimage;
        }
        int age = eSoftwarica.getAge();
        holder.img.setImageResource(img);
        holder.txtgender.setText(eSoftwarica.getGender());
        holder.txtname.setText(eSoftwarica.getName());
        holder.txtage.setText(String.valueOf(age));
        holder.txtaddress.setText(eSoftwarica.getAddress());
        holder.img2.setImageResource(R.drawable.delete);

        holder.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eSoftwaricaList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return eSoftwaricaList.size();
    }

    public  class ContactsViewHolder extends RecyclerView.ViewHolder {

        private TextView txtgender,txtname,txtage,txtaddress;
        private ImageView img,img2;
        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            img2=itemView.findViewById(R.id.imgdelete);
            img=itemView.findViewById(R.id.imageView3);
            txtgender=itemView.findViewById(R.id.txtgender);
            txtname=itemView.findViewById(R.id.txtname);
            txtage=itemView.findViewById(R.id.txtage);
            txtaddress=itemView.findViewById(R.id.txtaddress);
        }
    }
}
