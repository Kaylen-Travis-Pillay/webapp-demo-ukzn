package za.co.ktpsolutions.webappdemoukzn;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.ldoublem.loadingviewlib.view.LVBlock;

public class LoadActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        //=======OPTIONAL==========
            String GITHUB_URL = generateGithubURL();
            TextView lp_tv_footer = findViewById(R.id.lp_tv_footer);

            SpannableString github = new SpannableString(getText(R.string.github));
            github.setSpan(new URLSpan(GITHUB_URL),0, github.length(),0);
            lp_tv_footer.setText(github);
        //=========================

        //Get reference to LVBlock
        LVBlock lp_loading_icon = findViewById(R.id.lp_loading_icon);
        //Start loading anim
        lp_loading_icon.startAnim();

    }

    private String generateGithubURL(){
        return String.valueOf(getText(R.string.github_url));
    }

    public void onViewGithubClick(View view){
        TextView textView = (TextView) view;
        URLSpan span = textView.getUrls()[0];

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(span.getURL()));
        startActivity(intent);
    }
}
