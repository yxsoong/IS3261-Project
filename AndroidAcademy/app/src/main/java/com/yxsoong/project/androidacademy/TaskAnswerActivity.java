package com.yxsoong.project.androidacademy;

import android.support.v7.app.ActionBar;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import io.github.kbiakov.codeview.CodeView;
import io.github.kbiakov.codeview.adapters.CodeWithDiffsAdapter;
import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.views.DiffModel;

public class TaskAnswerActivity extends AppCompatActivity {
    CodeView codeView;
    //TextView tv;
    public static final String URLKEY = "urlAnswers";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_answer);

        LinearLayout linearLayout = findViewById(R.id.linearLayoutContainer);
        AsyncLoadAnswers asyncLoadAnswers = new AsyncLoadAnswers();
        Intent myIntent = getIntent();
        String lessonUrl = myIntent.getStringExtra(URLKEY);

        asyncLoadAnswers.execute(lessonUrl);

        codeView = findViewById(R.id.code_view);
        codeView.setOptions(Options.Default.get(this));
//        tv = new TextView(this);
//        tv.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        linearLayout.addView(tv);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }



    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }

    public class AsyncLoadAnswers extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... str) {
            if(str[0] == null)
                Log.i("string is null", "null");
            else
                Log.i("string is null", str[0]);
            URL url = convertToUrl(str[0]);
            HttpURLConnection httpURLConnection = null;

            int responseCode;

            StringBuilder stringBuilder = new StringBuilder();
            String line;

            try{
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();

                if(responseCode == httpURLConnection.HTTP_OK) {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
                e.printStackTrace();
            } finally {
                httpURLConnection.disconnect();
            }

            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String result) {
            try{
                /*StringReader sr = new StringReader(result);
                InputSource is = new InputSource(sr);
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();;
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document dom = builder.parse(is);*/
                /*XmlResourceParser xmlResourceParser = new
                int eventType = 0;
                try {
                    eventType = xmlResourceParser.getEventType();

                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        if (eventType == XmlPullParser.START_DOCUMENT) {
                            System.out.println("Start document");
                        } else if (eventType == XmlPullParser.START_TAG) {
                            System.out.println("Start tag " + xmlResourceParser.getName());
                        } else if (eventType == XmlPullParser.END_TAG) {
                            System.out.println("End tag " + xmlResourceParser.getName());
                        } else if (eventType == XmlPullParser.TEXT) {
                            String text = textView.getText().toString();
                            textView.setText(text + xmlResourceParser.getText());
                            System.out.println("Text " + xmlResourceParser.getText());
                        }
                        eventType = xmlResourceParser.next();
                    }
                } catch (XmlPullParserException | IOException e) {


                }*/

                //Toast.makeText(getApplicationContext(), "text " + result, Toast.LENGTH_LONG).show();
                String oldString = result.replace("    ", "\n");
                //String[] strings = result.split("    ");
                String newString = oldString.replace(">", ">\n");
                newString = newString.replace("\n\nandroid", "\n\tandroid");
                if(newString.contains("app")){
                    //Toast.makeText(getApplicationContext(),"in",Toast.LENGTH_LONG).show();
                    newString = newString.replace("\n\napp", "\n\tapp");
                }
                /*for(int i = 0; i < strings.length; i++) {
                    newString += strings[i] + "\n";
                    if(strings[i].charAt(strings[i].length() - 1) == '>')
                        newString += "\n";
                }
                int startIndex = 0, endIndex = 0;
                boolean isAngularBracket = false;
                while(endIndex < oldString.length()){
                    if(isAngularBracket){
                        isAngularBracket = false;
                        newString += oldString.substring(startIndex, endIndex) + "\n";
                        startIndex = endIndex + 1;
                    }
                    else if(result.charAt(endIndex) == '>'){
                        isAngularBracket = true;
                    }
                    endIndex++;
                }*/

                CodeWithDiffsAdapter diffsAdapter = new CodeWithDiffsAdapter(getApplicationContext());
                codeView.getOptions()
                        .withLanguage("xml")
                        .setCode(newString);
                codeView.updateAdapter(diffsAdapter);
                diffsAdapter.addFooterEntity(16, new DiffModel(newString, true));
                //codeView.setCode(newString, "xml");

                //tv.setText(newString);
            } catch (Exception ex){
                Log.d("Exception ", ex.getLocalizedMessage());
            }
        }

        private URL convertToUrl(String urlStr){
            try{
                URL url = new URL(urlStr);
                URI uri = new URI(url.getProtocol(), url.getUserInfo(),
                        url.getHost(), url.getPort(), url.getPath(),
                        url.getQuery(), url.getRef());
                url = uri.toURL();
                return url;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}


