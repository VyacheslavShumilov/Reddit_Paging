package com.vshum.reddit.base

import android.view.LayoutInflater
import android.view.ViewGroup

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T