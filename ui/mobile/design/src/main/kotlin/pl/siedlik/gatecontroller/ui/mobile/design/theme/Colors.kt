package pl.siedlik.gatecontroller.ui.mobile.design.theme

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import pl.siedlik.gatecontroller.ui.common.design.Indigo10
import pl.siedlik.gatecontroller.ui.common.design.Indigo20
import pl.siedlik.gatecontroller.ui.common.design.Indigo30
import pl.siedlik.gatecontroller.ui.common.design.Indigo40
import pl.siedlik.gatecontroller.ui.common.design.Indigo80
import pl.siedlik.gatecontroller.ui.common.design.Indigo90
import pl.siedlik.gatecontroller.ui.common.design.IndigoLight10
import pl.siedlik.gatecontroller.ui.common.design.IndigoLight20
import pl.siedlik.gatecontroller.ui.common.design.IndigoLight30
import pl.siedlik.gatecontroller.ui.common.design.IndigoLight40
import pl.siedlik.gatecontroller.ui.common.design.IndigoLight80
import pl.siedlik.gatecontroller.ui.common.design.IndigoLight90
import pl.siedlik.gatecontroller.ui.common.design.Turquoise10
import pl.siedlik.gatecontroller.ui.common.design.Turquoise20
import pl.siedlik.gatecontroller.ui.common.design.Turquoise30
import pl.siedlik.gatecontroller.ui.common.design.Turquoise40
import pl.siedlik.gatecontroller.ui.common.design.Turquoise80
import pl.siedlik.gatecontroller.ui.common.design.Turquoise90

internal val lightColorScheme = lightColorScheme(
  primary = Indigo40,
  onPrimary = Color.White,
  primaryContainer = Indigo90,
  onPrimaryContainer = Indigo10,
  secondary = IndigoLight40,
  onSecondary = Color.White,
  secondaryContainer = IndigoLight90,
  onSecondaryContainer = IndigoLight10,
  tertiary = Turquoise40,
  onTertiary = Color.White,
  tertiaryContainer = Turquoise90,
  onTertiaryContainer = Turquoise10,
)

internal val darkColorScheme = darkColorScheme(
  primary = Indigo80,
  onPrimary = Indigo20,
  primaryContainer = Indigo30,
  onPrimaryContainer = Indigo90,
  secondary = IndigoLight80,
  onSecondary = IndigoLight20,
  secondaryContainer = IndigoLight30,
  onSecondaryContainer = IndigoLight90,
  tertiary = Turquoise80,
  onTertiary = Turquoise20,
  tertiaryContainer = Turquoise30,
  onTertiaryContainer = Turquoise90,
)

@RequiresApi(Build.VERSION_CODES.S)
@Composable
internal fun dynamicColorScheme(
  darkTheme: Boolean,
  context: Context = LocalContext.current,
): ColorScheme = when {
  darkTheme -> dynamicDarkColorScheme(context)
  else -> dynamicLightColorScheme(context)
}
