package pl.siedlik.gatecontroller.ui.mobile.design.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
internal fun isAtLeastAndroid12(): Boolean = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
