package com.example;

import com.dooioo.example.R;
import com.dooioo.tool.CallUtil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button callButton;
	private Button pasCallButton;
	private Context context;
	@Override
	protected void onCreate(Bundle saveBundle){
		super.onCreate(saveBundle);
		setContentView(R.layout.hello_test);
		callButton = (Button)findViewById(R.id.buttonCall);
		callButton.setOnClickListener(this);
		
		pasCallButton = (Button) findViewById(R.id.button1);
		pasCallButton.setOnClickListener(this);
		
		context = (Context) this; 
	}
	@Override
	public void onClick(View view){
		switch(view.getId()){
			case R.id.buttonCall:
				Uri url = Uri.parse("tel:10086");
				Intent intent = new Intent(Intent.ACTION_CALL, url);
				intent.putExtra("key1", "hello");
				intent.putExtra("key2", "world");
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				try{
					startActivity(intent);
					Intent it = new Intent("com.dooioo.psa.CALL");
					it.putExtra("key1", "hello");
					it.putExtra("key2", "world");
					it.addCategory(Intent.CATEGORY_DEFAULT);
					sendBroadcast(it);
				}catch(Exception e){
					e.printStackTrace();
				}
				
			break;
			case R.id.button1:
				CallUtil.call(context, "13918443628", "psa", "hello world");
				break;
		}
	}
	@Override
	protected void onResume(){
		super.onResume();
		
	}
}
