package hitesh.asimplegame;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

public class AnswerClickSound {
    private int mRightAnswerSound;
    private SoundPool sound;

    public AnswerClickSound(Context context) {
        sound = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);// maxStreams, streamType, srcQuality
        mRightAnswerSound = sound.load(context, R.raw.miss, 1);
    }

    public void playSound() {
        Log.d("AnswerClickSound", "----- Answer Called! -----");
        sound.play(mRightAnswerSound, 1.0F, 1.0F, 1, 0, 1.0F);
    }

}