package com.alexis.redux;

import com.alexis.redux.action.IAction
import com.alexis.redux.processor.IProcessor
import com.alexis.redux.processor.ITransient
import com.alexis.redux.notifier.INotifier
import com.alexis.redux.store.IDispatcher

abstract class Container(private val notifier: INotifier) : INotifier by notifier, IDispatcher {
    protected val processors: MutableMap<Class<out IAction>, IProcessor> = mutableMapOf()
    protected abstract fun resolveProcessor(action: IAction): IProcessor?

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
}
