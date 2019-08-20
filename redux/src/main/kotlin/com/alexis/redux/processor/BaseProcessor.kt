package com.alexis.redux.processor

import com.alexis.redux.action.IAction

abstract class BaseProcessor<T, W : IAction> : IProcessor<T, W>