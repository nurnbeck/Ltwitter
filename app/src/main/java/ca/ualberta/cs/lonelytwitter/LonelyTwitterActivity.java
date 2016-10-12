/*
Copyright (c) 2016 Team Hurricane, CMPUT301, University of Alberta - All Rights Reserved.
Ypu may use, distribute, and copy all or parts of this code under terms and conditions of
University of Alberta and the code of Student Behaviour.
You can find a copy of Licence at http://www.github.com/TeamHurricane/.....
For further information, contact me at nbeck@ualberta.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*
*<p>This is the main view class of LonelyTwitter project. It handles all
* user interactions as well as file manipulations.<p/>
* @since 1.0
* @see NormalTweet
* <ol>
* 	<li> an item <\li>
* 	<li> another item <\li>
* <\ol>
* @see java.io.FileNotFoundException
* @author Nolan Beck
*
*/

/**
 * The type Lonely twitter activity.
 */
public class LonelyTwitterActivity extends Activity {

/*
*this is the file that is being loaded / saved and contains all tweets.
*@see #LoadFromFile()
*@see #SaveInFile()
 */
	private Activity activity = this;
	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<Tweet> tweetList = new ArrayList<Tweet>();

	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList(){
		return oldTweetsList;
	}
	/** Called when the activity is first created. takes parameter
     * of the previously saved instance.
     * */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		/* Create the save, or "Tweet" button. */
		Button saveButton = (Button) findViewById(R.id.save);
		saveButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
                bodyText.setText("");

				Tweet newTweet = new NormalTweet(text);

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		/* Clear all the tweets and their data. */
		Button clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				tweetList.clear();
                adapter.notifyDataSetChanged();
				saveInFile();
			}
		});
		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position, long id){
				Intent intent = new Intent(activity, EditTweetActivity.class);
				startActivity(intent);
			}
		});
	}

    /*
    the enables our adapter and loads our tweets from memory
     */
	@Override
	protected void onStart() {
		super.onStart();
		loadFromFile();
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}
/*
this method loads tweets from FILE_NAME (file.sav), and laods into adapter
 */
	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Code from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();

			tweetList = gson.fromJson(in,listType);

		} catch (FileNotFoundException e) {
			/* Create a brand new tweet list if we can't find the file. */
			tweetList = new ArrayList<Tweet>();
		}
	}
	/*
	saves our tweets in a file with GSON
	throws FileNotFoundException and
	IOException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					0);

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList, out);
			out.flush();

			fos.close();
		} catch (FileNotFoundException e) {
			/* Rethrow. */
			throw new RuntimeException(e);
		} catch (IOException e) {
			/* Rethrow. */
			throw new RuntimeException(e);
		}
	}
}