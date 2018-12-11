package test.hu.com.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class UpdateDialog extends Dialog implements View.OnClickListener {
    private TextView titleTxt;
    private TextView submitTxt;
    private TextView cancelTxt;
    private TextView nowVersionTxt;
    private TextView newVersionTxt;
    private TextView newContentTxt;
    private onClickListener listener;
    private String positiveName;
    private String negativeName;
    private String title;
    private int layout;
    private String nowVersion;
    private String newVersion;
    private String newContent;
    private boolean isCancel;

    @Override
    protected void onStart() {
        super.onStart();
        this.getWindow().setDimAmount(0f);
    }

    private UpdateDialog(Builder builder) {
        super(builder.mContext, builder.mThemeId);
        this.layout = builder.layout;
        this.title = builder.title;
        this.listener = builder.listener;
        this.positiveName = builder.positiveName;
        this.negativeName = builder.negativeName;
        this.nowVersion = builder.nowVersion;
        this.newVersion = builder.newVersion;
        this.newContent = builder.newContent;
        this.isCancel = builder.isCancel;
    }


    public static class Builder {
        private Context mContext;
        private String content;
        private onClickListener listener;
        private String positiveName;
        private String negativeName;
        private String title;
        private int layout;
        private int mThemeId;
        private String nowVersion;
        private String newVersion;
        private String newContent;
        private boolean isCancel;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setCancel(boolean isCancel) {
            this.isCancel = isCancel;
            return this;
        }

        public Builder setNowVersion(String nowVersion) {
            this.nowVersion = nowVersion;
            return this;
        }

        public Builder setNewVersion(String newVersion) {
            this.newVersion = newVersion;
            return this;
        }

        public Builder setNewContent(String newContent) {
            this.newContent = newContent;
            return this;
        }

        public Builder setThemeId(int themeId) {
            this.mThemeId = themeId;
            return this;
        }

        public Builder setPositiveButton(String name) {
            this.positiveName = name;
            return this;
        }

        public Builder setNegativeButton(String name) {
            this.negativeName = name;
            return this;
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public Builder setcontent(String content) {
            this.content = content;
            return this;
        }

        public Builder setLayout(int layout) {
            this.layout = layout;
            return this;
        }

        public Builder setOnClickLisener(onClickListener lisener) {
            this.listener = lisener;
            return this;
        }

        public UpdateDialog build() {
            return new UpdateDialog(this);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        setCanceledOnTouchOutside(false);
        initView();
        this.setCancelable(isCancel);
    }

    private void initView() {
        titleTxt = (TextView) findViewById(R.id.title);
        submitTxt = (TextView) findViewById(R.id.submit);
        submitTxt.setOnClickListener(this);
        cancelTxt = (TextView) findViewById(R.id.cancel);
        cancelTxt.setOnClickListener(this);
        nowVersionTxt = (TextView) findViewById(R.id.tv_version_now);
        newVersionTxt = (TextView) findViewById(R.id.tv_version_new);
        newContentTxt = (TextView) findViewById(R.id.tv_content_new);
        if (!TextUtils.isEmpty(nowVersion)) {
            nowVersionTxt.setText(nowVersion);
        }
        if (!TextUtils.isEmpty(newVersion)) {
            newVersionTxt.setText(newVersion);
        }
        if (!TextUtils.isEmpty(newContent)) {
            newContentTxt.setText(newContent);
        }
        if (!TextUtils.isEmpty(positiveName)) {
            submitTxt.setText(positiveName);
        }

        if (!TextUtils.isEmpty(negativeName)) {
            cancelTxt.setText(negativeName);
        }

        if (!TextUtils.isEmpty(title)) {
            titleTxt.setText(title);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cancel:
                if (listener != null) {
                    listener.onCancleClick(this);
                }
                break;
            case R.id.submit:
                if (listener != null) {
                    listener.onConfirmClick(this);
                }
                break;
        }
    }

    public interface onClickListener {
        void onConfirmClick(Dialog dialog);

        void onCancleClick(Dialog dialog);
    }
}
