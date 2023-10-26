package pl.siedlik.gatecontroller.core.car

import androidx.car.app.Screen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.KProperty

// Created as a experiment
/**
 * Syntax sugar for state flow collection inside of the [Screen] class that allows to write
 * the UI builders in a declarative way. It scopes collection to the [Screen] lifecycle
 * and invalidates it on every item received. Current value can be accessed by a delegate.
 */
fun <T> Screen.collectAsState(flow: StateFlow<T>) = ScreenStateFlowCollector(
  screen = this,
  flow = flow,
)

class ScreenStateFlowCollector<T> internal constructor(
  screen: Screen,
  flow: StateFlow<T>,
) {

  private val invalidator: () -> Unit = { screen.invalidate() }
  private var value: T = flow.value

  init {
    screen.lifecycleScope.launch {
      screen.repeatOnLifecycle(Lifecycle.State.STARTED) {
        flow.collect(::updateAndInvalidateScreen)
      }
    }
  }

  private fun updateAndInvalidateScreen(item: T) {
    value = item
    invalidator()
  }

  operator fun getValue(thisObj: Any?, property: KProperty<*>): T = value
}
