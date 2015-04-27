package yaoque.androidprojects.modernartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MyDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				Intent intent = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.moma.org"));
				getActivity().startActivity(intent);
			}
		};
		DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				dismiss();
			}
		};
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setNegativeButton("Not Now", negativeClick);
		builder.setPositiveButton("Visit MOMA", positiveClick);
		builder.setTitle("Click Here to Visit MoMA!");
		Dialog dg = builder.create();
		return dg;
	}
}
