/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.datasource.DataSource
import com.example.androiddevchallenge.util.SingleLiveEvent

/**
 * Created by mitohato14 on 2021/02/27.
 */
class PuppyViewModel : ViewModel() {
    private val _puppy: MutableLiveData<PuppyBindingModel> = MutableLiveData()
    val puppy: LiveData<PuppyBindingModel> = _puppy

    private val _navigateToList: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToList: LiveData<Unit> = _navigateToList

    fun onCreate(id: Long) {
        _puppy.value = DataSource.getPuppyById(id).toBindingModel()
    }
}
