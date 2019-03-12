package com.narara.myapplication_2.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.narara.myapplication_2.R;

public class WebViewActivity extends AppCompatActivity {
    private EditText mAddressEdit;
    private WebView myWebView;
    private Button mMoveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        myWebView = findViewById(R.id.web_view);
        // WebView의 설정
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient()); // WebViewClient상속받아 재정의 하는 것 영상에 나와있음
        mAddressEdit = findViewById(R.id.address_edit);
        mMoveButton = findViewById(R.id.move_button);

        // 소프트키보드의 돋보기를 클릭했을 때 이동 버튼을 클릭하도록 함 (익명클래스)
        mAddressEdit.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                                                // v는 mAddressEdit를 가리킴. EditText는 TextView를 상속받음
                if (actionId == EditorInfo.IME_ACTION_SEARCH) { // EditorInfo에 키보드 키정보 상수로 다 있다.
                    mMoveButton.callOnClick();

                    // 키보드 내리기
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });
    }

    public void onClick_WebView(View view) {
        String address = mAddressEdit.getText().toString();
        if (address.startsWith("http://") == false) {
            address = "http://" + address;
        }
        myWebView.loadUrl(address);
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();   //웹뷰의 기록이 있으면 이전 페이지로 이동하고
        } else {
            super.onBackPressed(); // super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_webview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_back:
                // 뒤로 가기
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                }
                break;
            case R.id.action_forward:
                // 앞으로 가기
                if (myWebView.canGoForward()) {
                    myWebView.goForward();
                }
                break;
            case R.id.action_refresh:
                // 새로 고침
                myWebView.reload();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
