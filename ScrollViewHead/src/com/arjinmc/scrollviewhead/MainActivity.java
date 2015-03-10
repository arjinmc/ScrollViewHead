package com.arjinmc.scrollviewhead;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.arjinmc.scrollviewhead.NotifyingScrollView.OnScrollChangedListener;

/**
 * @desciption main
 * @author Eminem Lu
 * @email arjinmc@hotmail.com
 * @create 2015/3/10
 */
public class MainActivity extends Activity {
	
	private NotifyingScrollView scrollview;
	private LinearLayout layoutHead;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		scrollview = (NotifyingScrollView) findViewById(R.id.sv_layout);
		layoutHead = (LinearLayout) findViewById(R.id.ll_head);
		
		//first init the head background to transparent
		layoutHead.getBackground().setAlpha(0);
		
		
		scrollview.setOnScrollChangedListener(new OnScrollChangedListener() {

			@Override
			public void onScrollChanged(ScrollView who, int l, int t, int oldl,
					int oldt) {
				//define it for scroll height
				int lHeight = 400;
				if(t<=lHeight){
					int progress = (int)(new Float(t)/new Float(lHeight)*255);
					layoutHead.getBackground().setAlpha(progress);
				}else{
					layoutHead.getBackground().setAlpha(255);
				}
				
			}
		});
	}
}
