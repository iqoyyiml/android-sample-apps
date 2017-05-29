package com.ooyala.sample.players;

import android.os.Bundle;
import com.ooyala.android.OoyalaPlayer;
import com.ooyala.android.OoyalaPlayerLayout;
import com.ooyala.android.PlayerDomain;
import com.ooyala.android.configuration.Options;
import com.ooyala.android.ui.OoyalaPlayerLayoutController;
import com.ooyala.sample.R;

/**
 * This activity illustrates how you can play a video with an initial time set
 *
 * This can be used in conjunction with Cross Device Resume (XDR) to start videos where
 * an end user left off
 *
 *
 */
public class PlayWithInitialTimePlayerActivity extends AbstractHookActivity {
	public final static String getName() {
		return "Play With InitialTime";
	}

	protected OoyalaPlayerLayoutController playerLayoutController;


	@Override
	void completePlayerSetup(boolean asked) {
		//Initialize the player
		OoyalaPlayerLayout playerLayout = (OoyalaPlayerLayout) findViewById(R.id.ooyalaPlayer);

		Options options = new Options.Builder().setUseExoPlayer(true).build();
		player = new OoyalaPlayer(pcode, new PlayerDomain(domain), options);
		playerLayoutController = new OoyalaPlayerLayoutController(playerLayout, player);
		player.addObserver(this);

		if (player.setEmbedCode(embedCode)) {
			//Play from the 20 second mark;
			player.play(20000);
		}
	}

	/**
	 * Called when the activity is first created.
	 */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.player_simple_layout);
		completePlayerSetup(asked);
	}
}