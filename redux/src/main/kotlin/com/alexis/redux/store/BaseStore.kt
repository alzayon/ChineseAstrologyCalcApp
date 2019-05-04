package com.alexis.redux.store;

import com.alexis.redux.action.IAction
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.processor.ITransient
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.state.IState

abstract class BaseStore<T: IState>(
    override val notifier: INotifier,
    override val state: T
) : IStore<T>, INotifier by notifier
{
    protected val processors: MutableMap<Class<out IAction>, IProcessor> = mutableMapOf()

    override fun dispatch(action: IAction) {
        val key = action::class.java
        if (processors.containsKey(key)) {
            processors.get(key)?.let {
                return it.process(action)
            }
        }
        val processor = resolveProcessor(action)
        processor?.let { p ->
            if (processor !is ITransient) {
                processors.put(action::class.java, p)
            }
            return p.process(action)
        } ?: throw RuntimeException ("No processor found to process the action.")
    }

    override fun reset() {
        state.reset()
        notifier.cleanup()
        processors.clear()
    }
}
