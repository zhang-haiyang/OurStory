package zhy.com.engine.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import zhy.com.engine.R;

/**
 * 各种对话框
 * Created by hww on 2018/1/18.
 */

public class VariousDialog {

    //询问选择对话框
    public static void showAskDialog(final Context context, final String title, final String message, final DialogOnClick dialogOnClick){
        final Dialog dialog;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.dialog_ask, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(view);
        dialog = builder.create();
        view.findViewById(R.id.tv_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogOnClick.click();
            }
        });
        view.findViewById(R.id.tv_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        TextView mTitleTV, mMessageTV;
        mTitleTV = view.findViewById(R.id.tv_title);
        mMessageTV = view.findViewById(R.id.tv_message);
        mTitleTV.setText(title);
        mMessageTV.setText(message);
        dialog.show();
    }
}
