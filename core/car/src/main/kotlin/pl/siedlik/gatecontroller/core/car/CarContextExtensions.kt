package pl.siedlik.gatecontroller.core.car

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.car.app.CarContext
import androidx.car.app.model.CarColor
import androidx.car.app.model.CarIcon
import androidx.core.graphics.drawable.IconCompat

fun CarContext.getCarIcon(
  @DrawableRes id: Int,
  color: CarColor = CarColor.DEFAULT,
): CarIcon = CarIcon.Builder(
  /* icon = */ IconCompat.createWithResource(this, id)
).run {
  setTint(color)
  build()
}

fun CarContext.getCarColor(
  @ColorRes id: Int,
  @ColorRes darkId: Int = id
): CarColor = CarColor.createCustom(
  /* color = */ getColor(id),
  /* colorDark = */ getColor(darkId),
)
