package com.alexis.redux.store;

import com.alexis.redux.action.IAction
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.processor.ITransient
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.state.IState

abstract class BaseStore<T: IState>(
    protected val notifier: INotifier,
    protected val state: T
) : IStore, INotifier by notifier
{
    protected val processors: MutableMap<Class<out IAction>, IProcessor> = mutableMapOf()

    override fun dispatch(action: IAction) {
        return dispatchSync<Unit>(action)
    }

    override fun <T> dispatchSync(action: IAction): T {
        val key = action::class.java
        if (processors.containsKey(key)) {
            processors.get(key)?.let {
                return it.process(action) as T
            }
        }
        val processor = resolveProcessor(action)
        processor?.let { p ->
            if (processor !is ITransient) {
                processors.put(action::class.java, p)
            }
            return p.process(action) as T
        } ?: throw RuntimeException ("No processor found to process the action.")
    }

    override fun reset() {
        state.reset()
        notifier.cleanup()
        processors.clear()
    }
}
