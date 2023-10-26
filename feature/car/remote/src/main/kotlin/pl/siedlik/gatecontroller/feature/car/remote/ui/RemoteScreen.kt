package pl.siedlik.gatecontroller.feature.car.remote.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.car.app.CarContext
import androidx.car.app.CarToast
import androidx.car.app.Screen
import androidx.car.app.model.Action
import androidx.car.app.model.GridItem
import androidx.car.app.model.GridTemplate
import androidx.car.app.model.Item
import androidx.car.app.model.ItemList
import androidx.car.app.model.Template
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import pl.siedlik.gatecontroller.core.car.collectAsState
import pl.siedlik.gatecontroller.core.car.getCarColor
import pl.siedlik.gatecontroller.core.car.getCarIcon
import pl.siedlik.gatecontroller.feature.car.remote.presenter.LoadingAction
import pl.siedlik.gatecontroller.feature.car.remote.presenter.RemotePresenter
import pl.siedlik.gatecontroller.feature.car.remote.presenter.RemoteState
import pl.siedlik.gatecontroller.ui.common.design.ColorR
import pl.siedlik.gatecontroller.ui.common.design.DrawableR
import pl.siedlik.gatecontroller.ui.common.design.StringR

class RemoteScreen(carContext: CarContext) : Screen(carContext), KoinComponent {

  private val presenter: RemotePresenter by inject { parametersOf(lifecycleScope) }
  private val state: RemoteState by collectAsState(presenter.stateFlow)

  init {
    lifecycleScope.launch {
      repeatOnLifecycle(Lifecycle.State.STARTED) {
        presenter.messagesFlow.collect { message ->
          CarToast.makeText(carContext, message, CarToast.LENGTH_SHORT).show()
        }
      }
    }
  }

  override fun onGetTemplate(): Template {
    val gateActions = ItemList.Builder().run {
      addItem(
        buildGridItem(
          title = StringR.open,
          icon = DrawableR.ic_gate_open,
          isLoading = state.action == LoadingAction.Open,
          onClick = presenter::open,
        )
      )
      addItem(
        buildGridItem(
          title = StringR.close,
          icon = DrawableR.ic_gate_close,
          isLoading = state.action == LoadingAction.Close,
          onClick = presenter::close,
        )
      )
      build()
    }
    return GridTemplate.Builder().run {
      setHeaderAction(Action.APP_ICON)
      setTitle(carContext.getString(StringR.gate_control))
      setSingleList(gateActions)
      build()
    }
  }

  private fun buildGridItem(
    @StringRes title: Int,
    @DrawableRes icon: Int,
    isLoading: Boolean,
    onClick: () -> Unit,
  ): Item = GridItem.Builder().run {
    when {
      isLoading -> setLoading(true)
      else -> {
        val carIcon = carContext.getCarIcon(
          id = icon,
          color = carContext.getCarColor(ColorR.indigo_60, ColorR.indigo_40)
        )
        setImage(carIcon)
        setOnClickListener(onClick)
      }
    }
    setTitle(carContext.getString(title))
    build()
  }
}
