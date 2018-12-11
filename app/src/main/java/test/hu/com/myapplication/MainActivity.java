package test.hu.com.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UpdateDialog.Builder builder = new UpdateDialog.Builder()
                .setContext(this)
                .setTitle("标题")
                .setLayout(R.layout.dialog_update)
                .setThemeId(R.style.updateStyleDialog)
                .setNowVersion("现在版本")
                .setNewVersion("新版本")
                .setNewContent("新版本描述")
                .setNegativeButton("取消按钮")
                .setPositiveButton("确定按钮")
                .setCancel(false)//是否强制升级
                .setOnClickLisener(new UpdateDialog.onClickListener() {
                    @Override
                    public void onConfirmClick(Dialog dialog) {
                        showToast("确定");
                        dialog.dismiss();
                    }

                    @Override
                    public void onCancleClick(Dialog dialog) {
                        showToast("取消");
                        dialog.dismiss();
                    }
                });
        builder.build().show();

    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
